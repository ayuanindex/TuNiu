package com.ayuan.tuniu.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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
import com.ayuan.tuniu.vo.Lists;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

        tv_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                final AlertDialog alertDialog = builder.create();
                View inflate = View.inflate(MainActivity.this, R.layout.view_date, null);
                alertDialog.setView(inflate);
                CalendarView cv_date = (CalendarView) inflate.findViewById(R.id.cv_date);
                final TextView tv_title_date = (TextView) inflate.findViewById(R.id.tv_title_date);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("y-M-d");
                Date date = new Date(cv_date.getDate());
                tv_title_date.setText(simpleDateFormat.format(date));
                cv_date.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                        tv_title_date.setText(year + "-" + month + "-" + dayOfMonth);
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
                if (start == null) {
                    Toast.makeText(MainActivity.this, "请输入出发城市", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (end == null) {
                    Toast.makeText(MainActivity.this, "请输入目的地", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (date == null) {
                    Toast.makeText(MainActivity.this, "请选择日期", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void searchData() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                final String[] par = new String[]{"2018-12-13", "200", "北京", "2500", "上海"};

                final Map<String, Object> hashMap = HttpRequset.trainTicketQuery(par);
                ArrayList<Lists> list = (ArrayList<Lists>) hashMap.get("list");
                for (Lists lists : list) {
                    Log.i(TAG, "哈哈:lists的解析" + lists.toString());
                }
            }
        }.start();
    }
}
