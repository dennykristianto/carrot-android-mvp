package com.mitrais.carrotmobile.activity.home;

import android.content.Context;
import android.util.Log;

import com.mitrais.carrotmobile.base.BasePresenter;
import com.mitrais.carrotmobile.base.View;
import com.mitrais.carrotmobile.data.ApiHelper;
import com.mitrais.carrotmobile.data.PreferencesHelper;
import com.mitrais.carrotmobile.model.ActivityContext;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class HomePresenter<V extends IHomeView> extends BasePresenter<V> implements IHomePresenter<V> {
    private static final String TAG = "HomePresenter";

    @Inject
    public HomePresenter(ApiHelper apiHelper, CompositeDisposable compositeDisposable, PreferencesHelper preferencesHelper, @ActivityContext Context context) {
        super(apiHelper, compositeDisposable, preferencesHelper, context);
    }

    @Override
    public void getBazaar() {
        getCompositeDisposable().add(
                getApiHelper()
                        .getBazaars()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(data->getMvpView().setBazaar(data),err->getMvpView())
        );
    }
}
