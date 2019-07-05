package com.ball.project;


import android.app.Application;
import android.content.Context;

public class App extends Application {
    private static App sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    public static App getInstance() {
        return sInstance;
    }
}
