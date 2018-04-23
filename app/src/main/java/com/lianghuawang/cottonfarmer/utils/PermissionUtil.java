package com.lianghuawang.cottonfarmer.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

import com.lianghuawang.cottonfarmer.MyApp;

import java.util.ArrayList;
import java.util.List;

/**
 * 6.0动态权限
 */
public class PermissionUtil {

    private Context context = MyApp.getContext();

    private List<String> p = new ArrayList<>();

    private int temp = 0;

    public static PermissionUtil newInstance() {
        return PermissionHolder.util;
    }

    private PermissionUtil() {

    }

    private static class PermissionHolder {
        private static PermissionUtil util = new PermissionUtil();
    }

    /**
     * 单个添加权限
     */
    public void add(String permission) {
        p.add(permission);
    }

    /**
     * 批量增加
     */
    public void addList(List<String> permissionList) {
        p.addAll(permissionList);
    }

    /**
     * 验证权限的信息
     */
    private void requestPermission(int i) {
        if (ContextCompat.checkSelfPermission(context, p.get(i))
                != PackageManager.PERMISSION_GRANTED) {

        } else {
            //检查权限被授权就移除权限
            p.remove(i);
            temp--;
        }
    }

}
