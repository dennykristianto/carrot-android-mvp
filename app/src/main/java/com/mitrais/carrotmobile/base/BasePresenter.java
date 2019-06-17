package com.mitrais.carrotmobile.base;

import android.content.Context;

import com.mitrais.carrotmobile.data.ApiHelper;
import com.mitrais.carrotmobile.data.PreferencesHelper;
import com.mitrais.carrotmobile.model.ActivityContext;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter<V extends View> implements Presenter<V> {
    private V mvpView;
    private final ApiHelper apiHelper;
    private final CompositeDisposable compositeDisposable;
    private final PreferencesHelper preferencesHelper;
    private final Context context;

    @Inject
    public BasePresenter(ApiHelper apiHelper, CompositeDisposable compositeDisposable, PreferencesHelper preferencesHelper, @ActivityContext Context context) {
        this.apiHelper = apiHelper;
        this.compositeDisposable=compositeDisposable;
        this.preferencesHelper=preferencesHelper;
        this.context=context;
    }

    @Override
    public void onAttach(@NotNull V mvpView) {
        this.mvpView = mvpView;
    }

    @Override
    public void onDetach() {
        this.mvpView = null;
        this.compositeDisposable.dispose();
    }

    public V getMvpView(){
        return mvpView;
    }

    protected ApiHelper getApiHelper() {
        return apiHelper;
    }

    protected CompositeDisposable getCompositeDisposable(){
        return compositeDisposable;
    }

    protected PreferencesHelper getPreferencesHelper(){
        return preferencesHelper;
    }

    public Context getContext() {
        return context;
    }
}
