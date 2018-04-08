package com.lianghuawang.cottonfarmer.utils;

import java.lang.reflect.ParameterizedType;

/**
 * Created by 韩学文 on 2018/4/2.
 */

public class ReflectUtil {
    public static <T> T getT(Object o, int i) {
        try {
            return ((Class<T>) ((ParameterizedType)
                    (o.getClass().getGenericSuperclass())).getActualTypeArguments()[i]).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}