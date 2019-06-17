package com.mitrais.carrotmobile.activity.splash_screen;

import android.content.Context;

import com.mitrais.carrotmobile.base.BasePresenter;
import com.mitrais.carrotmobile.base.View;
import com.mitrais.carrotmobile.data.ApiHelper;
import com.mitrais.carrotmobile.data.PreferencesHelper;
import com.mitrais.carrotmobile.model.ActivityContext;
import com.mitrais.carrotmobile.model.User;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

public class SplashPresenter<V extends ISplashView> extends BasePresenter<V> implements ISplashPresenter<V> {

    @Inject
    public SplashPresenter(ApiHelper apiHelper, CompositeDisposable compositeDisposable, PreferencesHelper preferencesHelper,@ActivityContext Context context) {
        super(apiHelper, compositeDisposable, preferencesHelper, context);
    }

    @Override
    public void checkUserLogin() {
        if(!isTokenPresent())
            getMvpView().showLoginPage();
        getCompositeDisposable().add(
                getApiHelper()
                        .getUserDetails()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                data->
                                        getMvpView().showIndexPage(),
                                data->
                                        getMvpView().showLoginPage()
                        )
        );
    }

    private boolean isTokenPresent(){
        return !super.getPreferencesHelper().getPreference("token").equals("");
    }
}
