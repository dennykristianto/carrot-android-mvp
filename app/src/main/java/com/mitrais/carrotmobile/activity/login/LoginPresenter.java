package com.mitrais.carrotmobile.activity.login;

import android.content.Context;
import android.util.Log;

import com.mitrais.carrotmobile.base.BasePresenter;
import com.mitrais.carrotmobile.data.ApiHelper;
import com.mitrais.carrotmobile.data.PreferencesHelper;
import com.mitrais.carrotmobile.model.ActivityContext;

import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class LoginPresenter<V extends ILoginView> extends BasePresenter<V> implements ILoginPresenter<V> {
    private static final String TAG = "LoginPresenter";
    private String token;

    @Inject
    public LoginPresenter(ApiHelper apiHelper, CompositeDisposable compositeDisposable, PreferencesHelper preferencesHelper,@ActivityContext Context context) {
        super(apiHelper, compositeDisposable, preferencesHelper, context);
    }

    @Override
    public void onDetach() {

    }

    @Override
    public void performLogin(String email, String password) {
        HashMap<String, String> loginInfo = new HashMap<>();
        loginInfo.put("username", email);
        loginInfo.put("password", password);
        getCompositeDisposable().add(
                getApiHelper()
                        .getLoginResponse(loginInfo)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(data -> {
                            getPreferencesHelper().setPreference("token",data.getAccessToken());
                            getMvpView().successfulLogin(data);
                        }, err -> Log.d(TAG, "performLogin: " + err.getMessage()))
        );
    }
}
