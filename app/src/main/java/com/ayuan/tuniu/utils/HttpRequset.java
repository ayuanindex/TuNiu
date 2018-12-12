package com.ayuan.tuniu.utils;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class HttpRequset {
	private static final String TAG = "HttpRequset";
	/**
	 * 数据请求地址
	 */
	private static String URL = "http://huoche.tuniu.com/yii.php?r=train/trainTicket/getTickets";

	/**
	 * 可以传入参数在此方法中进行拼接传给httpSetting方法
	 *
	 * @param par 传入的参数
	 */
	public static Map<String, Object> trainTicketQuery(String[] par) {
		try {
			for (int i = 0; i < par.length; i++) {
				par[i] = URLEncoder.encode(par[i], "utf-8");
			}
			String primary = "&primary";
			String path = URL + primary + "%5BdepartureDate%5D=" + par[0] + primary + "%5BdepartureCityCode%5D=" + par[1] + primary + "%5BdepartureCityName%5D=" + par[2] + primary + "%5BarrivalCityCode%5D=" + par[3] + primary + "%5BarrivalCityName%5D=" + par[4] + "&start=0&limit=5";
			String jsonString = httpSetting(path);
			return JsonAnalyzeUtil.trainTicket(jsonString);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		//使用将从网络上获取的数据使用json解析类进行解析
		return null;
	}

	private static String httpSetting(String path) {
		try {
			URL url = new URL(path);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setReadTimeout(5000);
			httpURLConnection.setConnectTimeout(5000);
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setDoInput(true);
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setUseCaches(false);
			httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
			httpURLConnection.setRequestProperty("Charset", "UTF-8");
			httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			httpURLConnection.setRequestProperty("accept", "application/json");
			httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:62.0) Gecko/20100101 Firefox/62.0");
			int code = httpURLConnection.getResponseCode();
			if (code == 200) {
				InputStream inputStream = httpURLConnection.getInputStream();
				if (inputStream != null) {
					String json = StreamUtil.StreamToString(inputStream);
					return json;
				} else {
					inputStream.close();
				}
			} else {
				return null;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
