package com.mitrais.carrotmobile;

import android.app.Application;
import android.content.SharedPreferences;

import com.mitrais.carrotmobile.component.ApplicationComponent;
import com.mitrais.carrotmobile.component.DaggerApplicationComponent;
import com.mitrais.carrotmobile.data.PreferencesHelper;
import com.mitrais.carrotmobile.module.ContextModule;
import com.mitrais.carrotmobile.data.ApiHelper;

import javax.inject.Inject;

public class CarrotApplication extends Application {
    @Inject
    ApiHelper apiHelper;
    @Inject
    PreferencesHelper preferencesHelper;

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .contextModule(new ContextModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
