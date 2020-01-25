package com.retrofit.recyclerview.di.component;

import com.retrofit.recyclerview.di.annotation.PerActivity;
import com.retrofit.recyclerview.di.module.ActivityModule;
import com.retrofit.recyclerview.ui.LoginActivity;

import javax.inject.Scope;

import dagger.Component;


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(LoginActivity loginActivity);

}
