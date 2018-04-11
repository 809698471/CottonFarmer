package com.lianghuawang.cottonfarmer.entity.home.insurance;

import com.lianghuawang.cottonfarmer.netutils.LogUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsuranceData {

    private List<Insurance> list;

    public static InsuranceData newInstance(){
        return new InsuranceData();
    }

    private final List<String> titles = Arrays.asList(
            "棉花灾害险",
            "棉花价格险",
            "棉花收入险",
            "棉花灾害险",
            "棉花价格险",
            "棉花收入险"
    );
    private final List<String> contents = Arrays.asList(
            "预防风、冻、霜、雹、虫、旱、涝等自然灾害的无忧险",
            "预防棉花价格下跌保障价格平稳的安心险",
            "保障棉花亩收入在合理水平的综合险",
            "预防风、冻、霜、雹、虫、旱、涝等自然灾害的无忧险",
            "预防棉花价格下跌保障价格平稳的安心险",
            "保障棉花亩收入在合理水平的综合险"
    );

    public List<Insurance> getData() {
        if (list == null) {
           list = new ArrayList<>();
        }

        if (list.size() == 0) {
            int i = 0;
            while (i < 6) {
                Insurance insurance = new Insurance();
                insurance.setId(i);
                insurance.setPhotoPath("www.baidu.com");
                insurance.setTitle(titles.get(i));
                insurance.setContent(contents.get(i));
                insurance.setValidity("有效期：2018.3.15-2018.5.10");
                list.add(insurance);
                i++;
            }
        }

        return list;
    }

    public List<Insurance> setAdd(List<Insurance> insuranceList) {
        if (insuranceList == null || insuranceList.size() == 0){
            insuranceList = getData();
        }
        Insurance insurance = new Insurance();
        insurance.setId(insuranceList.size());
        insurance.setPhotoPath("www.baidu.com");
        insurance.setTitle("新增保险");
        insurance.setContent("新增保险说明内容");
        insurance.setValidity("有效期：2018.3.15-2018.5.10");
        insuranceList.add(0,insurance);
        return insuranceList;
    }
}
