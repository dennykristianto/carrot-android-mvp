package com.mitrais.carrotmobile.module;

import android.content.Context;

import com.mitrais.carrotmobile.model.ApplicationContext;
import com.mitrais.carrotmobile.model.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context){
        this.context=context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context provideContext(){
        return this.context;
    }
}
