package com.mitrais.carrotmobile.component;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.mitrais.carrotmobile.activity.home.HomeView;
import com.mitrais.carrotmobile.activity.login.LoginView;
import com.mitrais.carrotmobile.activity.splash_screen.SplashView;
import com.mitrais.carrotmobile.model.ActivityScope;
import com.mitrais.carrotmobile.module.ActivityModule;

import dagger.Component;

@ActivityScope
@Component(modules = {ActivityModule.class}, dependencies = ApplicationComponent.class)
public interface ActivityComponent {
    ActivityModule getActivityModule();
    ApplicationComponent getApplication();

    void inject(LoginView loginView);
    void inject(SplashView splashView);
    void inject(HomeView homeView);
}
