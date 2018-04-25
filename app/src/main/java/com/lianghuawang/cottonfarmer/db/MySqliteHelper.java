package com.lianghuawang.cottonfarmer.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.lianghuawang.cottonfarmer.MyApp;

public class MySqliteHelper extends SQLiteOpenHelper {

    private final static String DB_NAME = "XBDCM";
    private final static int VERSION = 1;
    public MySqliteHelper() {
        super(MyApp.getContext(), DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
