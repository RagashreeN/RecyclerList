package com.retrofit.recyclerview;

import android.app.Application;

import com.retrofit.recyclerview.di.component.ApplicationComponent;
import com.retrofit.recyclerview.di.module.ApplicationModule;

public class MVVMApplication extends Application {

    private ApplicationComponent mApplicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        mApplicationComponent.inject(this);
    }


}
