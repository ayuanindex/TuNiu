package com.ayuan.tuniu.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ayuan.tuniu.R;
import com.ayuan.tuniu.utils.HttpRequset;
import com.ayuan.tuniu.utils.SearchStation;
import com.ayuan.tuniu.vo.Lists;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = "MainActivity";
	private TextView tv_haha;
	private EditText et_input;
	private Button btn_search;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initUI();
	}


	private void initUI() {
		tv_haha = (TextView) findViewById(R.id.tv_haha);
		et_input = (EditText) findViewById(R.id.et_input);
		btn_search = (Button) findViewById(R.id.btn_search);

		btn_search.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String city = et_input.getText().toString().trim();
				SearchStation searchStation = SearchStation.getInstence(MainActivity.this);
				String stationCode = searchStation.getStationCode(city);
				if (stationCode != null) {
					tv_haha.setText(city + ":" + stationCode);
					searchData();
				} else {
					tv_haha.setText("暂无此城市");
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
