package com.ayuan.tuniu.activity;

import java.util.Map;

public class MyApplication extends android.app.Application {

    private static MyApplication instance;

    private Map<String, Object> hashMap;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static MyApplication getInstance() {
        return instance;
    }

    public Map<String, Object> getHashMap() {
        return hashMap;
    }

    public void setHashMap(Map<String, Object> hashMap) {
        this.hashMap = hashMap;
    }
}
