package com.mitrais.carrotmobile.data;

import android.content.Context;

import com.mitrais.carrotmobile.Configuration;

import javax.inject.Inject;

public class PreferencesHelperImpl implements PreferencesHelper {
    private Context mContext;

    @Inject
    public PreferencesHelperImpl(Context context) {
        mContext=context;
    }

    @Override
    public void setPreference(String key, String value) {
        mContext.getSharedPreferences(Configuration.SHARED_PREF_NAME,Context.MODE_PRIVATE).edit().putString(key,value).apply();
    }

    @Override
    public void deletePreference(String key) {
        mContext.getSharedPreferences(Configuration.SHARED_PREF_NAME,Context.MODE_PRIVATE).edit().remove(key).apply();
    }

    @Override
    public String getPreference(String key) {
        return mContext.getSharedPreferences(Configuration.SHARED_PREF_NAME,Context.MODE_PRIVATE).getString(key,"");
    }
}
