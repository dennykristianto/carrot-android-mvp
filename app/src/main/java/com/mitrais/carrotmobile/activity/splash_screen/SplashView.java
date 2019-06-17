package com.mitrais.carrotmobile.activity.splash_screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.mitrais.carrotmobile.R;
import com.mitrais.carrotmobile.activity.home.HomeView;
import com.mitrais.carrotmobile.activity.login.LoginView;
import com.mitrais.carrotmobile.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class SplashView extends BaseActivity implements ISplashView {
    @Inject
    ISplashPresenter<ISplashView> splashScreenPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);
        /*Attaching this view into presenter*/
        splashScreenPresenter.onAttach(this);
        splashScreenPresenter.checkUserLogin();
    }

    @Override
    public void showIndexPage() {
        Intent intent = new Intent(this, HomeView.class);
        this.startActivity(intent);
        this.finish();
    }

    @Override
    public void showLoginPage() {
        Intent intent = new Intent(this, LoginView.class);
        this.startActivity(intent);
        this.finish();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
