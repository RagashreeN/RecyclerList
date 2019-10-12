package com.retrofit.recyclerview.common.utils;

import android.app.Application;

import com.retrofit.recyclerview.common.rest.NetworkService;

public class MainApplication extends Application {

    public static NetworkService networkService;

    @Override
    public void onCreate() {
        super.onCreate();
        networkService = new NetworkService();
    }
}
