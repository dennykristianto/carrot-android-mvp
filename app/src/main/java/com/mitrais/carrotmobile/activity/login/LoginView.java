package com.mitrais.carrotmobile.activity.login;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.mitrais.carrotmobile.R;
import com.mitrais.carrotmobile.base.BaseActivity;
import com.mitrais.carrotmobile.model.Login;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginView extends BaseActivity implements ILoginView {
    private static final String TAG = "LoginView";

    @Inject
    ILoginPresenter<ILoginView> loginPresenter;

    @BindView(R.id.et_email) EditText email;

    @BindView(R.id.et_password) EditText password;

    @BindView(R.id.btn_server_login) Button login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);
        /*Attaching this view into presenter*/
        loginPresenter.onAttach(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.performLogin(email.getText().toString(),password.getText().toString());
            }
        });
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void successfulLogin(Login loginResponseModel) {
        Log.d(TAG, loginResponseModel.getAccessToken());
    }

    @Override
    public void showError(String call, String statusMessage) {

    }
}
