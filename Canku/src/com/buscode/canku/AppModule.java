package com.buscode.canku;

import android.content.Context;

import com.androidquery.AQuery;
import com.buscode.canku.gson.MyGson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 最上层module。
 * 作为library存在，
 * 提供Context, MyApp, System Service 变量。
 */
@Module(
        library = true
)
public class AppModule {
    private Context mContext;

    public AppModule(Context context) {
        mContext = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return mContext;
    }

    @Provides
    @Singleton
    MyApp provideApp() {
        return (MyApp) mContext.getApplicationContext();
    }

    @Provides
    @Singleton
    AQuery provideAQuery(MyApp app) {
        return new AQuery(app);
    }

    @Provides
    @Singleton
    MyGson provideGson() {
        return new MyGson();
    }
}
