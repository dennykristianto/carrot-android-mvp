package com.mitrais.carrotmobile.module;

import android.content.Context;

import com.mitrais.carrotmobile.data.PreferencesHelper;
import com.mitrais.carrotmobile.data.PreferencesHelperImpl;
import com.mitrais.carrotmobile.model.ApplicationContext;
import com.mitrais.carrotmobile.model.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module(includes = ContextModule.class)
public class PreferencesModule {
    private Context mContext;

    @ApplicationScope
    @Provides
    public PreferencesHelper providePreferenceHelper(@ApplicationContext Context context){
            return new PreferencesHelperImpl(context);
    }

}
