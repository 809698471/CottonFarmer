package com.lianghuawang.cottonfarmer.entity.home.cooperation;

import java.util.ArrayList;
import java.util.List;

public class CooperData {

    public static CooperData newInstance(){
        return new CooperData();
    }

    public List<Cooper> init(){
        List<Cooper> list = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            Cooper cooper = new Cooper();
            cooper.setId(i);
            cooper.setImagepath("");
            cooper.setContent("新疆省委，下达合作社2018年最新文件我社举行集体学习活动");
            cooper.setTime("2018-2-9");
            list.add(cooper);
        }
        return list;
    }

}
