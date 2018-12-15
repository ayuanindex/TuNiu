package com.ayuan.tuniu.activity;

import android.app.AlertDialog;
import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ayuan.tuniu.R;
import com.ayuan.tuniu.utils.HttpRequset;
import com.ayuan.tuniu.utils.SearchStation;
import com.ayuan.tuniu.vo.Lists;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView tv_text;
    private Button btn_date;
    private EditText et_start;
    private EditText et_end;
    private ImageView iv_change;
    private TextView tv_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }


    private void initUI() {
        et_start = (EditText) findViewById(R.id.et_start);
        et_end = (EditText) findViewById(R.id.et_end);
        iv_change = (ImageView) findViewById(R.id.iv_change);
        tv_date = (TextView) findViewById(R.id.tv_date);
        btn_date = (Button) findViewById(R.id.btn_date);

        //将当前时间显示到空间上
        Date date = new Date();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("y-M-d");
        String time = simpleDateFormat.format(date);
        tv_date.setText(time);

        tv_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                final AlertDialog alertDialog = builder.create();
                View inflate = View.inflate(MainActivity.this, R.layout.view_date, null);
                alertDialog.setView(inflate);
                final CalendarView cv_date = (CalendarView) inflate.findViewById(R.id.cv_date);
                final TextView tv_title_date = (TextView) inflate.findViewById(R.id.tv_title_date);
                final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("y-M-d");
                final Date date = new Date(cv_date.getDate());
                tv_title_date.setText(simpleDateFormat.format(date));
                tv_title_date.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //点击对话框的标题将日期重置为今天的日期
                        Date time = new Date();
                        cv_date.setDate(time.getTime());
                        tv_title_date.setText(simpleDateFormat.format(time));
                    }
                });
                cv_date.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                        tv_title_date.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                    }
                });
                alertDialog.setButton2("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tv_date.setText(tv_title_date.getText().toString().trim());
                        dialog.dismiss();
                    }
                });
                alertDialog.setButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alertDialog.show();
            }
        });

        btn_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String start = et_start.getText().toString().trim();
                String end = et_end.getText().toString().trim();
                String date = tv_date.getText().toString().trim();
                Date parse = null;
                Date date2 = new Date();
                Calendar instance = Calendar.getInstance();
                instance.add(Calendar.DAY_OF_MONTH, -1);
                Date time1 = instance.getTime();
                try {
                    parse = simpleDateFormat.parse(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (TextUtils.isDigitsOnly(start)) {
                    Toast.makeText(MainActivity.this, "请输入出发城市", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isDigitsOnly(end)) {
                    Toast.makeText(MainActivity.this, "请输入目的地", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(date)) {
                    Toast.makeText(MainActivity.this, "请选择日期", Toast.LENGTH_SHORT).show();
                    return;
                } else if (parse.before(time1)) {
                    Toast.makeText(MainActivity.this, "请输入正确的日期", Toast.LENGTH_SHORT).show();
                    return;
                }
                SearchStation instence = SearchStation.getInstence(MainActivity.this);
                String startCode = instence.getStationCode(start);
                String endCode = instence.getStationCode(end);
                if (TextUtils.isEmpty(startCode)) {
                    Toast.makeText(MainActivity.this, "暂无此城市", Toast.LENGTH_SHORT).show();
                    et_start.setText("");
                    return;
                }
                if (TextUtils.isEmpty(endCode)) {
                    Toast.makeText(MainActivity.this, "暂无此城市", Toast.LENGTH_SHORT).show();
                    et_end.setText("");
                    return;
                }
                String[] par = {date, startCode, start, endCode, end};
                Intent intent = new Intent(MainActivity.this, TicketList.class);
                intent.putExtra("key", true);
                intent.putExtra("parameter", par);
                startActivity(intent);
                /*searchData(par);*/
            }
        });

        iv_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String start = et_start.getText().toString().trim();
                String end = et_end.getText().toString().trim();
                String temp = "";
                temp = start;
                start = end;
                end = temp;
                et_start.setText(start);
                et_end.setText(end);
            }
        });
    }

    private void searchData(final String[] par) {
        //点击按钮之后进行跳转，在火车票页面进行连接网络的工作
/*        new Thread() {
            @Override
            public void run() {
                super.run();
                final Map<String, Object> hashMap = HttpRequset.trainTicketQuery(par);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (hashMap.isEmpty()) {
                            Toast.makeText(MainActivity.this, "没有网络", Toast.LENGTH_SHORT).show();
                            Log.i(TAG, "没有获取到网络");
                            return;
                        }
                        Intent intent = new Intent(MainActivity.this, TicketList.class);
                        intent.putExtra("key", true);
                        intent.putExtra("parameter", par);
                        Log.i(TAG, "哈哈:执行到我啦");
                        startActivity(intent);//ticketList
                        *//*MyApplication instance = MyApplication.getInstance();
                        instance.setHashMap(hashMap);*//*
                    }
                });
            }
        }.start();*/
    }
}
