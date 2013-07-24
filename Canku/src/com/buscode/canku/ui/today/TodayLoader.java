package com.buscode.canku.ui.today;


import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.buscode.canku.request.TodayHttpHandler;
import com.buscode.canku.storage.Today;

import javax.inject.Inject;

public class TodayLoader extends AsyncTaskLoader<Today> {

    @Inject
    public TodayLoader(Context context) {
        super(context);
    }

    @Inject
    TodayHttpHandler mHandler;

    @Override
    public Today loadInBackground() {
        try {
            return mHandler.request();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
