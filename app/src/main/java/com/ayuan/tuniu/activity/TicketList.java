package com.ayuan.tuniu.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ayuan.tuniu.R;
import com.ayuan.tuniu.utils.HttpRequset;
import com.ayuan.tuniu.utils.SortUtils;
import com.ayuan.tuniu.vo.Lists;
import com.ayuan.tuniu.vo.Prices;

import org.w3c.dom.ls.LSException;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 火车票详情页
 */
public class TicketList extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "TicketList";
    private ImageView iv_back;
    private ImageView iv_option;
    private TextView tv_titlecity;
    private ListView lv_list;
    private ArrayList<Lists> ticketList;
    private Intent intent;
    private String[] parameters;
    private ProgressDialog progressDialog;
    private Map<String, Object> map = null;
    private LinearLayout ll_item;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticketlist);

        initUI();
        initData();
    }

    private void initUI() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_option = (ImageView) findViewById(R.id.iv_option);
        tv_titlecity = (TextView) findViewById(R.id.tv_titlecity);
        lv_list = (ListView) findViewById(R.id.lv_list);

        intent = getIntent();
        parameters = intent.getStringArrayExtra("parameter");
        if (parameters != null) {
            //将出发城市和目的城市回显到控件上
            /*tv_titlecity.setText(URLDecoder.decode(parameters[2], "utf-8") + "——" + URLDecoder.decode(parameters[4], "utf-8"));*/
            tv_titlecity.setText(parameters[2] + "——" + parameters[4]);
        }

        iv_back.setOnClickListener(this);
        iv_option.setOnClickListener(this);
    }

    private void initData() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("加载中....");
        progressDialog.show();
        new Thread() {
            @Override
            public void run() {
                super.run();
                if (parameters != null) {
                    map = HttpRequset.trainTicketQuery(parameters);
                    if (map != null) {
                        map = SortUtils.time_Sort(map);
                        ticketList = (ArrayList<Lists>) map.get("list");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                lv_list.setAdapter(new TrainTicketAdapter());
                                progressDialog.dismiss();
                            }
                        });
                    }
                }
            }
        }.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_option:
                //sequence
                sequence();
                break;
        }
    }

    private void sequence() {
        //北京上海
    }


    private class TrainTicketAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return ticketList.size();
        }

        @Override
        public Lists getItem(int position) {
            return ticketList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            if (convertView == null) {
                view = View.inflate(TicketList.this, R.layout.item_ticket, null);
            } else {
                view = convertView;
            }
            TextView tv_starttime = (TextView) view.findViewById(R.id.tv_starttime);
            TextView tv_startcity = (TextView) view.findViewById(R.id.tv_startcity);
            TextView tv_number = (TextView) view.findViewById(R.id.tv_number);
            TextView tv_time = (TextView) view.findViewById(R.id.tv_time);
            TextView tv_endtime = (TextView) view.findViewById(R.id.tv_endtime);
            TextView tv_endcity = (TextView) view.findViewById(R.id.tv_endcity);
            TextView tv_price = (TextView) view.findViewById(R.id.tv_price);
            Lists lists = ticketList.get(position);
            ArrayList<Prices> prices = lists.getPrices();
            tv_starttime.setText(lists.getDepartDepartTime());
            tv_startcity.setText(lists.getDepartStationName());
            tv_number.setText(lists.getTrainNum());
            tv_time.setText(lists.getDuration() + "分钟");
            tv_endtime.setText(lists.getDestArriveTime());
            tv_endcity.setText(lists.getDestStationName());
            tv_price.setText(prices.get(prices.size() - 1).getPrice() + "");
            return view;
        }
    }
}
