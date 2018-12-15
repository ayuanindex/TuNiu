package com.ayuan.tuniu.utils;

import com.ayuan.tuniu.vo.Lists;
import com.ayuan.tuniu.vo.Prices;

import java.util.ArrayList;
import java.util.Map;

public class SortUtils {

    /**
     * 按照时长进行排序
     *
     * @param map
     * @return
     */
    public static Map<String, Object> time_Sort(Map<String, Object> map) {
        if (map != null) {
            Lists lists = new Lists();
            ArrayList<Lists> list = (ArrayList<Lists>) map.get("list");
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(i).getDuration() > list.get(j).getDuration()) {
                        lists = list.get(i);
                        list.set(i, list.get(j));
                        list.set(j, lists);
                    }
                }
            }
        }
        return map;
    }

    public static Map<String, Object> price_Sort(Map<String, Object> map) {
        if (map != null) {
            Lists lists = new Lists();
            ArrayList<Lists> list = (ArrayList<Lists>) map.get("list");
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.size(); j++) {
                    ArrayList<Prices> one = list.get(i).getPrices();
                    ArrayList<Prices> two = list.get(j).getPrices();
                    if (one.get(one.size() - 1).getPrice() > two.get(two.size() - 1).getPrice()) {
                        lists = list.get(i);
                        list.set(i, list.get(j));
                        list.set(j, lists);
                    }
                }
            }
        }
        return map;
    }
}
