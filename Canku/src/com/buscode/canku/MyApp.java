package com.buscode.canku;


import android.annotation.TargetApi;
import android.os.Build;
import com.buscode.canku.storage.StorageModule;
import com.googlecode.androidannotations.annotations.EApplication;
import dagger.ObjectGraph;
import de.mindpipe.android.logging.log4j.LogConfigurator;
import org.apache.log4j.Level;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * 程序的Application, 全局唯一
 */
@TargetApi(Build.VERSION_CODES.BASE)
@EApplication
public class MyApp extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initLog4j();
        initObjectGraph();
    }

    private ObjectGraph mObjectGraph;

    public ObjectGraph getObjectGraph() {
        return mObjectGraph;
    }

    protected void initObjectGraph() {
        mObjectGraph = ObjectGraph.create(getModules().toArray());
    }

    protected List<Object> getModules() {
        return Arrays.<Object>asList(
                new AppModule(this),
                new StorageModule()
        );
    }

    private void initLog4j() {
        //log文件在 /sdcard/android/com.buscode.canku/canku.log
        File log_file = new File(getExternalCacheDir(), AppConfig.LOG_FILE_NAME);
        final LogConfigurator lc = new LogConfigurator();
        lc.setFileName(log_file.getAbsolutePath());//日志文件路径
        lc.setFilePattern("%d - [%-6p-%c] - %m%n");//日志输出格式
        lc.setMaxBackupSize(2);//最多的文件备份个数， 超过后log4j将自行删除
        lc.setMaxFileSize(1024 * 1024);//最大的日志大小， 超过后log4j将备份下来, 再新建一个文件。
        lc.setRootLevel(Level.DEBUG);
        // Set log level of a specific logger
        lc.setLevel("org.apache", Level.DEBUG);
        lc.configure();
    }
}
