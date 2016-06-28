package com.brainpg.teddystoy.common;

import android.app.Application;
import android.util.Log;

import com.brainpg.teddystoy.common.utils.TypefaceUtil;

public class AppApplication extends Application {

    private static AppApplication instance;


    public static AppApplication getInstance() {
        if (instance == null) {
            instance = new AppApplication();
        }
        return instance;
    }

     @Override public void onCreate() {
         super.onCreate();

         Log.i("AppApplication", "AppApplication - onCreate.");
         instance = this;
         initTypeface();
     }

    private void initTypeface() {
        TypefaceUtil.overrideFont(getApplicationContext(), "DEFAULT", "font/Roboto-Medium.ttf");
        TypefaceUtil.overrideFont(getApplicationContext(), "MONOSPACE", "font/Roboto-Medium.ttf");
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "font/Roboto-Medium.ttf");
        TypefaceUtil.overrideFont(getApplicationContext(), "SANS_SERIF", "font/Roboto-Medium.ttf");
    }
}
