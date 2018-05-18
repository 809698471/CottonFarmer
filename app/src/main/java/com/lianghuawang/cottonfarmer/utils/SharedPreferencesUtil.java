package com.lianghuawang.cottonfarmer.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.lianghuawang.cottonfarmer.MyApp;

public class SharedPreferencesUtil {

    private static SharedPreferences sp;
    private static SharedPreferences.Editor editor;

    public static SharedPreferencesUtil newInstance(String NAME){
        sp = MyApp.getContext().getSharedPreferences(NAME, Context.MODE_PRIVATE);
        editor = sp.edit();
        return new SharedPreferencesUtil();
    }

    public void putInt(String key, int value){
        editor.putInt(key,value).commit();
    }

    public int getInt(String key,int defValue){
        return sp.getInt(key,defValue);
    }

    public void putString(String key, String value){
        editor.putString(key, value).commit();
    }

    public String getString(String key, String defValue){
        return sp.getString(key,defValue);
    }

    public void putBoolean(String key, boolean value){
        editor.putBoolean(key, value).commit();
    }

    public boolean getBoolean(String key, boolean defValue){
        return sp.getBoolean(key, defValue);
    }

    public void putFloat(String key, float value){
        editor.putFloat(key, value).commit();
    }

    public float getFloat(String key,float defValue){
        return sp.getFloat(key, defValue);
    }

    public void putLong(String key, long value){
        editor.putLong(key, value).commit();
    }

    public long getLong(String key, long defValue){
        return sp.getLong(key, defValue);
    }
}
