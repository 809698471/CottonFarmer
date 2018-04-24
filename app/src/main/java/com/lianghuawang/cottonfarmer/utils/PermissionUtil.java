package com.lianghuawang.cottonfarmer.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.lianghuawang.cottonfarmer.MyApp;

import java.util.ArrayList;
import java.util.List;

/**
 * 6.0动态权限
 */
public class PermissionUtil {

    private static int Key;

    private static Context Context;

    private List<String> p;

    private int temp = 0;

    public static PermissionUtil newInstance(Context context,int key) {
        Key = key;
        Context = context;
        return PermissionHolder.util;
    }

    private PermissionUtil(int key) {

    }

    private static class PermissionHolder {
        private static PermissionUtil util = new PermissionUtil(Key);
    }

    public PermissionUtil Build(){
        if (p == null){
            p = new ArrayList<>();
        }
        return this;
    }

    /**
     * 单个添加权限
     */
    public PermissionUtil add(String permission) {
        p.add(permission);
        return this;
    }

    /**
     * 批量增加
     */
    public PermissionUtil addList(List<String> permissionList) {
        p.addAll(permissionList);
        return this;
    }

    /**
     * 授权
     */
    public PermissionUtil setPermission(){
        while(p.size()>temp){
            requestPermission(temp);
            temp++;
        }

        String [] strings = getPermissionString();
        if (strings.length != 0)
            ActivityCompat.requestPermissions((Activity) Context,strings,Key);
        return this;
    }

    public void build(){

    }

    public void Call(int requestCode, String[] permissions, int[] grantResults, Call call){
        if(requestCode == Key){
            if (grantResults.length > 0){
                //每个权限的返回信息都可以判断其是否授权成功
                for(int i = 0;i<grantResults.length;i++){
                    if(grantResults[i] == PackageManager.PERMISSION_GRANTED){
                        //成功授权
                        call.succeed();
                    }else{
                        //授权失败
                        call.error(permissions[i]);
                    }
                }
            }
            return;
        }

    }

    /**
     * 将list转换为字符串数组
     * @return
     */
    private String[] getPermissionString(){
        String [] permissionString = new String[p.size()];
        for (int k = 0, j = p.size(); k < j; k++) {
            permissionString[k] = p.get(k);
        }
        return permissionString;
    }

    /**
     * 验证权限的信息
     */
    private void requestPermission(int i) {
        if (ContextCompat.checkSelfPermission(Context, p.get(i))
                == PackageManager.PERMISSION_GRANTED) {
            //检查权限被授权就移除权限
            p.remove(i);
            temp--;
        } else {
            //权限没有被授权
        }
    }

    public interface Call{
        void succeed();
        void error(String permission);
    }

}
