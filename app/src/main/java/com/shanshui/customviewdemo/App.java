package com.shanshui.customviewdemo;

import android.app.Application;
import android.util.DisplayMetrics;

/**
 * @author mashanshui
 * @date 2020/1/3 0003
 * @desc TODO
 */
public class App extends Application {
    public static App app;
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
