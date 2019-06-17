package com.mitrais.carrotmobile.module;

import com.mitrais.carrotmobile.activity.home.HomePresenter;
import com.mitrais.carrotmobile.activity.home.IHomePresenter;
import com.mitrais.carrotmobile.activity.home.IHomeView;
import com.mitrais.carrotmobile.activity.login.ILoginPresenter;
import com.mitrais.carrotmobile.activity.login.ILoginView;
import com.mitrais.carrotmobile.activity.login.LoginPresenter;
import com.mitrais.carrotmobile.activity.splash_screen.ISplashPresenter;
import com.mitrais.carrotmobile.activity.splash_screen.ISplashView;
import com.mitrais.carrotmobile.activity.splash_screen.SplashPresenter;

import dagger.Binds;
import dagger.Module;

@Module
interface PresenterModule{
    @Binds
    ILoginPresenter<ILoginView> provideLoginPresenter(LoginPresenter<ILoginView> loginPresenter);

    @Binds
    ISplashPresenter<ISplashView> provideSplashScreenPresenter(SplashPresenter<ISplashView> splashLoginPresenter);

    @Binds
    IHomePresenter<IHomeView> provideHomePresenter(HomePresenter<IHomeView> homePresenter);
}
