package com.buscode.canku.gson;

import com.buscode.canku.BuildConfig;
import com.google.gson.Gson;

/**
 * 封装Gson。
 * 带有GsonBean检查
 */
public class MyGson {
    private Gson mGson = new Gson();

    public MyGson() {
    }

    public <T> T fromJson(String json, Class<T> classOfT) {
        if (BuildConfig.DEBUG) {
            checkGsonClass(classOfT);
        }
        return mGson.fromJson(json, classOfT);
    }

    public String toJson(Object src) {
        if (BuildConfig.DEBUG) {
            checkGsonClass(src.getClass());
        }
        return mGson.toJson(src);
    }

    private void checkGsonClass(Class cls) {
        if (!cls.isAnnotationPresent(GsonBean.class)) {
            throw new IllegalArgumentException("Use Gson should add GsonBean annotation.");
        }
    }
}
