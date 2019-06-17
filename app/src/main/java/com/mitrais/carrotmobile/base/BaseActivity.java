package com.mitrais.carrotmobile.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mitrais.carrotmobile.CarrotApplication;
import com.mitrais.carrotmobile.component.ActivityComponent;
import com.mitrais.carrotmobile.component.DaggerActivityComponent;
import com.mitrais.carrotmobile.data.ApiHelper;
import com.mitrais.carrotmobile.module.ActivityModule;

public abstract class BaseActivity extends AppCompatActivity implements View {

    private ActivityComponent activityComponent;
    private ApiHelper apiHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent = DaggerActivityComponent
                .builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((CarrotApplication) getApplication()).getApplicationComponent())
                .build();
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    @Override
    public boolean isNetworkConnected() {
        return true;
    }
}
