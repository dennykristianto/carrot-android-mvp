package com.mitrais.carrotmobile.data;

public interface PreferencesHelper {
    void setPreference(String key, String value);
    void deletePreference(String key);
    String getPreference(String key);
}
