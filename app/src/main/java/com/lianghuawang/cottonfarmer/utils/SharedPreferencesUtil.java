package com.lianghuawang.cottonfarmer.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.lianghuawang.cottonfarmer.MyApp;

import java.util.Map;

public class SharedPreferencesUtil {

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    public static SharedPreferencesUtil newInstance(String NAME){
        return new SharedPreferencesUtil(NAME);
    }

    private SharedPreferencesUtil(String NAME){
        sp = MyApp.getContext().getSharedPreferences(NAME, Context.MODE_PRIVATE);
        editor = sp.edit();
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
        editor.putBoolean(key, value);
        editor.commit();
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

    public void remove(String key){
        editor.remove(key).commit();
    }

    public Map<String,Object> getAll(){
        return (Map<String, Object>) sp.getAll();
    }

    public void clear(){
        editor.clear();
    }
}
