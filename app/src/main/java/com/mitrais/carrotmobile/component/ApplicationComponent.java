package com.mitrais.carrotmobile.component;

import android.app.Application;
import android.content.Context;

import com.mitrais.carrotmobile.data.ApiHelper;
import com.mitrais.carrotmobile.data.PreferencesHelper;
import com.mitrais.carrotmobile.model.ApplicationContext;
import com.mitrais.carrotmobile.model.ApplicationScope;
import com.mitrais.carrotmobile.module.ApiModule;
import com.mitrais.carrotmobile.module.ContextModule;
import com.mitrais.carrotmobile.module.PreferencesModule;

import dagger.Component;
import io.reactivex.disposables.CompositeDisposable;

@ApplicationScope
@Component(modules = {ApiModule.class, ContextModule.class, PreferencesModule.class})
public interface ApplicationComponent {
    ApiHelper apiServices();
    CompositeDisposable compositeDisposable();
    PreferencesHelper preferencesHelper();

    @ApplicationScope
    @ApplicationContext
    Context getContext();

    void inject(Application application);
}
