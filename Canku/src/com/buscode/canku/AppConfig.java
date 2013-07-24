package com.buscode.canku;

/**
 * 各种常量配置
 */
public class AppConfig {
    private static final String API_BASE_URL = "http://canku.willerce.com/";

    public static final String LOG_FILE_NAME = "canku.log";

    // API 地址列表
    public static final String API_TODAY = API_BASE_URL + "api/today";
    public static final String API_LOGIN = API_BASE_URL + "login";
    public static final String API_REGISTER = API_BASE_URL + "register";
}
