package com.mitrais.carrotmobile.module;

import android.app.Activity;
import android.content.Context;

import com.mitrais.carrotmobile.model.ActivityContext;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module(includes = PresenterModule.class)
public class ActivityModule {
    private Activity activity;

    @Inject
    public ActivityModule(Activity activity){
        this.activity=activity;
    }

    @ActivityContext
    @Provides
    Context provideActivityContext(){
        return activity;
    }

    @Provides
    Activity provideActivity(){
        return activity;
    }
}
