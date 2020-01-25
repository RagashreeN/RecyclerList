package com.retrofit.recyclerview.di.component;

import android.app.Application;
import android.content.Context;

import com.retrofit.recyclerview.MVVMApplication;
import com.retrofit.recyclerview.di.annotation.ApplicationContext;
import com.retrofit.recyclerview.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Provides;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MVVMApplication app);

    @ApplicationContext
    Context context();

    Application application();
}
