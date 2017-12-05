package com.example.aman1.mymovielist;

import android.app.Application;
import android.content.Context;

/**
 * Created by aman1 on 23/11/2017.
 */



public class MovieApplication extends Application {

    public static Application sApplication;

    public static Application getApplication() {
        return sApplication;
    }

    public static Context getContext() {
        return getApplication().getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
    }
}
