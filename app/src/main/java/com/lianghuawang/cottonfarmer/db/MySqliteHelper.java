package com.lianghuawang.cottonfarmer.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.lianghuawang.cottonfarmer.MyApp;

/**
 * 个人信息---基本信息
 * <p>
 * <p>
 * <p>
 * <p>
 * 身份证
 * 联系方式
 * 家庭住址
 * 邮编
 * 农作物类型
 * 种植面积
 * 种植地址
 * 地块数量
 * 地块信息
 * 近3年平均产量
 * 权属证明
 */
public class MySqliteHelper extends SQLiteOpenHelper {

    /**
     * ----------------------------数据库-------------------------------
     **/
    private final static String DB_NAME = "XBDCM";
    private final static int VERSION = 1;

    /**
     * ----------------------------表-------------------------------
     **/
    private final String TABLE_NAME = "personallnformation";//个人信息表
    private final String TABLE_BLOCK = "block";//地块信息表
    private final String TABLE_OWNERSHIPS = "ownerships";//权属表

    /**
     * ----------------------------表字段-------------------------------
     **/
    //基础信息表字段
    private final String VALUE_ID = "_id";//id
    private final String VALUE_HEARDLOCAL = "headLocalPath";//头像
    private final String VALUE_HEARDNET = "headNetworkPath";//头像
    private final String VALUE_USERID = "userid";//姓名编号
    private final String VALUE_NAME = "username";//姓名
    private final String VALUE_NATIONAL = "national";//民族
    private final String VALUE_IDCARD = "idCard";//身份证
    private final String VALUE_PHONE = "telePhone";//联系电话
    private final String VALUE_ADDRESS = "address";//家庭地址
    private final String VALUE_ZIPCODE = "zipcode";//邮编
    private final String VALUE_CROPSTYPE = "cropstype";//农作物类型
    private final String VALUE_PLANTINGAREA = "plantingarea";//种植面积
    private final String VALUE_PLANTING = "plantingAddressType";//种植地址
    private final String VALUE_BLOCKNUMBER = "blocknumber";//地块数量
    private final String VALUE_AVERAGE = "averageProduction";//近3年平均产量
    //地块表字段
    private final String VALUE_BLOCKID = "blockId";//地块ID
    private final String VALUE_BLOCKNAME = "blockname";//地块俗称
    private final String VALUE_BLOCKLONGITUDE = "longitude";//经度
    private final String VALUE_BLOCKLATITUDE = "latitude";//纬度
    //权属表字段
    private final String VALUE_OWENID = "ownershipId";
    private final String VALUE_OWENLOCALPATH = "ownershiplocal";
    private final String VALUE_OWENNETWORKPATH = "ownershipnewwork";

    public MySqliteHelper() {
        super(MyApp.getContext(), DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PERSONAL);
        db.execSQL(CREATE_BLOCK);
        db.execSQL(CREATE_OWEN);
    }

    //sqlite数据库类型  对应----->  java数据类型
    //integer ----->byte/short/int/long
    //text  ----->String
    //real  ----->float/double
    private final String CREATE_PERSONAL = "create table " + TABLE_NAME + "(" +
            VALUE_ID + " integer primary key," +
            VALUE_HEARDLOCAL + " text ," +
            VALUE_HEARDNET + " text ," +
            VALUE_USERID + " integer ," +
            VALUE_NAME + " gender," +
            VALUE_NATIONAL + "text," +
            VALUE_IDCARD + " text," +
            VALUE_PHONE + " text," +
            VALUE_ADDRESS + " text," +
            VALUE_ZIPCODE + " text," +
            VALUE_CROPSTYPE + " intege,r" +
            VALUE_PLANTINGAREA + " real," +
            VALUE_PLANTING + " text," +
            VALUE_BLOCKNUMBER + " integer," +
            VALUE_AVERAGE + " real"
            + ")";

    private final String CREATE_BLOCK = "create table " + TABLE_BLOCK + "(" +
            VALUE_BLOCKID + " integer primary key," +
            VALUE_ID + " integer," +
            VALUE_BLOCKNAME + " text," +
            VALUE_BLOCKLONGITUDE + " real," +
            VALUE_BLOCKLATITUDE + "real" +
            ")";

    private final String CREATE_OWEN = "create table " + TABLE_OWNERSHIPS + "(" +
            VALUE_OWENID + " integer primary key," +
            VALUE_ID + " integer," +
            VALUE_OWENLOCALPATH + " text," +
            VALUE_OWENNETWORKPATH + " text" +
            ")";

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
