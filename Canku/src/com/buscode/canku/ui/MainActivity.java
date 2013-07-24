package com.buscode.canku.ui;

import android.support.v4.app.FragmentActivity;

import com.buscode.canku.MyApp;
import com.buscode.canku.R;
import com.buscode.canku.ui.today.TodayListProgressFragment;
import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.App;
import com.googlecode.androidannotations.annotations.EActivity;

import dagger.ObjectGraph;

@EActivity(R.layout.main)
public class MainActivity extends FragmentActivity {

    @App
    MyApp myApp;

    ObjectGraph mObjectGraph;

    public ObjectGraph getObjectGraph() {
        return mObjectGraph;
    }

    @AfterViews
    void init() {
        mObjectGraph = myApp.getObjectGraph().plus(new MainModule());
        getSupportFragmentManager().beginTransaction().replace(R.id.content, new TodayListProgressFragment()).commit();
    }
}
