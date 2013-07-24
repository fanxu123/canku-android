package com.buscode.canku.request;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.buscode.canku.AppConfig;
import com.buscode.canku.gson.MyGson;
import com.buscode.canku.storage.Today;

import javax.inject.Inject;

/**
 * Http 请求
 */
public class TodayHttpHandler implements HttpHandler<Today>{

    @Inject
    AQuery aq;
    @Inject
    MyGson gson;

    @Override
    public Today request() throws Exception {

        AjaxCallback<String> cb = new AjaxCallback<String>();
        cb.url(AppConfig.API_TODAY).type(String.class);

        aq.sync(cb);
        AjaxStatus status = cb.getStatus();
        if (status.getCode() != 200) {
           throw new Exception("Error response code: " + status.getCode());
        }
        String content = cb.getResult();
        return gson.fromJson(content, Today.class);
    }
}
