package com.lianghuawang.cottonfarmer.entity.home.insurance;

import com.lianghuawang.cottonfarmer.widget.linkage_menu.CityInterface;

import java.util.List;

public class FenGongSi {

    /**
     * success : true
     * code : 200
     * message : OK
     * data : [{"id":0,"name":"阿拉尔分公司"},{"id":1,"name":"阿勒泰分公司"},{"id":2,"name":"巴州分公司"},{"id":3,"name":"博州分公司"},{"id":4,"name":"哈密分公司"},{"id":5,"name":"和田分公司"},{"id":6,"name":"喀什分公司"},{"id":7,"name":"克拉玛依分公司"},{"id":8,"name":"克州分公司"},{"id":9,"name":"奎屯分公司"},{"id":10,"name":"十二师分公司"},{"id":11,"name":"石河子分公司"},{"id":12,"name":"塔城分公司"},{"id":13,"name":"五家渠分公司"},{"id":14,"name":"伊犁分公司"}]
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
         * id : 0
         * name : 阿拉尔分公司
         */

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        @Override
        public String getArea_code() {
            return null;
        }

        @Override
        public String getCityName() {
            return getName();
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
