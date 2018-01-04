package com.mvprxjavaretrofit;

import android.app.Application;
import android.content.Context;

/**
 * Created by Avazu Holding on 2018/1/3.
 */

public class MyApplication extends Application {
    public static  Context context;


    @Override
    public void onCreate() {
        context = this;
        super.onCreate();

    }
}
