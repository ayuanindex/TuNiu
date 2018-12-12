package com.ayuan.tuniu.utils;

import android.util.Log;

import com.ayuan.tuniu.vo.AllTrainType_List;
import com.ayuan.tuniu.vo.Filter;
import com.ayuan.tuniu.vo.Filter_Sort;
import com.ayuan.tuniu.vo.Lists;
import com.ayuan.tuniu.vo.Prices;
import com.ayuan.tuniu.vo.Pros;
import com.ayuan.tuniu.vo.Sort;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

public class JsonAnalyzeUtil {
	private static final String TAG = "MainActivity";
	private static Map<String, Object> objectMap = null;

	public static Map<String, Object> trainTicket(String jsonString) {
		try {
			if (jsonString != null) {
				JSONObject jsonRootObject = new JSONObject(jsonString);
				String code = jsonRootObject.optString("code");
				if (code.equals("200")) {
					objectMap = new HashMap<String, Object>();
					JSONObject data = jsonRootObject.optJSONObject("data");
					int count = data.optInt("count");
					objectMap.put("count", count);
					boolean expire = data.optBoolean("expire");
					objectMap.put("expire", expire);
					int lastTime = data.optInt("lastTime");
					objectMap.put("lastTime", lastTime);
					String remark = data.optString("remark");
					objectMap.put("remark", remark);
					String streamId = data.optString("streamId");
					objectMap.put("streamId", streamId);
					JSONObject allTrainType = data.optJSONObject("allTrainType");
					JSONArray list = allTrainType.optJSONArray("list");
					JSONObject jsonArrayJSONObject = list.getJSONObject(0);
					String link = jsonArrayJSONObject.getString("link");
					int trainType = jsonArrayJSONObject.optInt("trainType");
					String trainTypeCode = jsonArrayJSONObject.getString("trainTypeCode");
					String trainTypeName = jsonArrayJSONObject.getString("trainTypeName");
					AllTrainType_List allTrainType_list = new AllTrainType_List(link, trainType, trainTypeCode, trainTypeName);
					objectMap.put("allTrainType_list", allTrainType_list);
					//解析filter
					JSONObject filter = data.optJSONObject("filter");
					Log.i(TAG, "");
					Filter_Sort filter1 = getFilter(filter);
					objectMap.put("filter", filter1);
					//解析list
					JSONArray jsonObjectList = data.optJSONArray("list");
					ArrayList<Lists> listsArrayList = getList(jsonObjectList);
					objectMap.put("list", listsArrayList);

				} else {
					return objectMap;
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objectMap;
	}

	/**
	 * filter的解析
	 *
	 * @param filter filter的json的对象
	 */
	private static Filter_Sort getFilter(JSONObject filter) {
		JSONArray filter1 = filter.optJSONArray("filter");
		JSONArray sort = filter.optJSONArray("sort");
		ArrayList<Filter> filters1 = new ArrayList<>();
		ArrayList<Sort> sorts = new ArrayList<>();
		ArrayList<Filter_Sort> filters = new ArrayList<Filter_Sort>();
		for (int i = 0; i < filter1.length(); i++) {
			JSONObject jsonObject = filter1.optJSONObject(i);
			String id = jsonObject.optString("id");
			String name = jsonObject.optString("name");
			JSONArray pros = jsonObject.optJSONArray("pros");
			ArrayList<Pros> arrayList = new ArrayList<Pros>();
			for (int i1 = 0; i1 < pros.length(); i1++) {
				JSONObject jsonObject1 = pros.optJSONObject(i1);
				int id1 = jsonObject1.optInt("id");
				String name1 = jsonObject1.optString("name");
				arrayList.add(new Pros(id1, name1));
			}
			filters1.add(new Filter(id, name, arrayList));
		}
		for (int i = 0; i < sort.length(); i++) {
			int id = sort.optJSONObject(i).optInt("id");
			String name = sort.optJSONObject(i).optString("name");
			int type = sort.optJSONObject(i).optInt("type");
			sorts.add(new Sort(id, name, type));
		}
		return new Filter_Sort(filters1, sorts);
	}

	private static ArrayList<Lists> getList(JSONArray jsonObjectList) {
		ArrayList<Lists> lists = new ArrayList<Lists>();
		for (int i = 0; i < jsonObjectList.length(); i++) {
			JSONObject jsonObject = jsonObjectList.optJSONObject(i);
			String accessByIdcard = jsonObject.optString("accessByIdcard");
			int arrivalCityCode = jsonObject.optInt("arrivalCityCode");
			String arrivalCityName = jsonObject.optString("arrivalCityName");
			int canChooseSeat = jsonObject.optInt("canChooseSeat");
			String departDepartTime = jsonObject.optString("departDepartTime");
			int departStationId = jsonObject.optInt("departStationId");
			String departStationName = jsonObject.optString("departStationName");
			int departStationType = jsonObject.optInt("departStationType");
			String departStationTypeName = jsonObject.optString("departStationTypeName");
			int departureCityCode = jsonObject.optInt("departureCityCode");
			String departureCityName = jsonObject.optString("departureCityName");
			String destArriveTime = jsonObject.optString("destArriveTime");
			int destStationId = jsonObject.optInt("destStationId");
			String destStationName = jsonObject.optString("destStationName");
			int destStationType = jsonObject.optInt("destStationType");
			String destStationTypeName = jsonObject.optString("destStationTypeName");
			int duration = jsonObject.optInt("duration");
			int durationDay = jsonObject.optInt("durationDay");
			String durationStr = jsonObject.optString("durationStr");
			int saleStatus = jsonObject.optInt("saleStatus");
			int sellOut = jsonObject.optInt("sellOut");
			String startSaleTime = jsonObject.optString("startSaleTime");
			int trainId = jsonObject.optInt("trainId");
			String trainNum = jsonObject.optString("trainNum");
			int trainType = jsonObject.optInt("trainType");
			String trainTypeName = jsonObject.optString("trainTypeName");
			int upOrDown = jsonObject.optInt("upOrDown");
			JSONArray prices = jsonObject.optJSONArray("prices");
			ArrayList<Prices> prices1 = new ArrayList<Prices>();
			for (int j = 0; j < prices.length(); j++) {
				JSONObject priceObject = prices.optJSONObject(j);
				int leftNumber = priceObject.optInt("leftNumber");
				double price = priceObject.optDouble("price");
				double promotionPrice = priceObject.optDouble("promotionPrice");
				int resId = priceObject.optInt("resId");
				int seat = priceObject.optInt("seat");
				String seatName = priceObject.optString("seatName");
				String seatStatus = priceObject.optString("seatStatus");
				prices1.add(new Prices(leftNumber, price, promotionPrice, resId, seat, seatName, seatStatus));
			}
			Lists lists1 = new Lists(accessByIdcard, arrivalCityCode, arrivalCityName, canChooseSeat, departDepartTime, departStationId, departStationName, departStationType, departStationTypeName, departureCityCode, departureCityName, destArriveTime, destStationId, destStationName, destStationType, destStationTypeName, duration, durationDay, durationStr, "", prices1, saleStatus, sellOut, startSaleTime, trainId, trainNum, trainType, trainTypeName, upOrDown);
			lists.add(lists1);
		}
		return lists;
	}
}
