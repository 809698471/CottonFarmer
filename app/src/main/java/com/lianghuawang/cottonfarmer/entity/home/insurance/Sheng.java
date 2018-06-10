package com.lianghuawang.cottonfarmer.entity.home.insurance;

import com.lianghuawang.cottonfarmer.widget.linkage_menu.CityInterface;

import java.util.List;

public class Sheng {


    /**
     * success : true
     * code : 200
     * message : OK
     * data : [{"pro_id":"65","name":"新疆"}]
     */

    private boolean success;
    private int code;
    private String message;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements CityInterface {
        /**
         * pro_id : 65
         * name : 新疆
         */

        private String pro_id;
        private String name;

        public String getPro_id() {
            return pro_id;
        }

        public void setPro_id(String pro_id) {
            this.pro_id = pro_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int getId() {
            return Integer.valueOf(getPro_id());
        }

        @Override
        public String getArea_code() {
            return null;
        }

        @Override
        public String getCityName() {
            return getName();
        }
    }
}
