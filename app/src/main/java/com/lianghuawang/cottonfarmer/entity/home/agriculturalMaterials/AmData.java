package com.lianghuawang.cottonfarmer.entity.home.agriculturalMaterials;

import java.util.ArrayList;
import java.util.List;

public class AmData {

    public static AmData newInstance() {
        return new AmData();
    }

    public List<Am> init() {
        List<Am> list = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Am am = new Am();
            am.setId(i);
            am.setImgPath("http://img2.imgtn.bdimg.com/it/u=1265398105,4029080795&fm=27&gp=0.jpg");
            am.setTitle("题目" + i);
            am.setPrice("¥ " + (i * i + 1) + "");
            list.add(am);
        }
        return list;
    }

//    private List<Am> setData(List<Am> list){
//
//    }

}
