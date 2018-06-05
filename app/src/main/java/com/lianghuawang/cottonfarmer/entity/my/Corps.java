package com.lianghuawang.cottonfarmer.entity.my;

import com.lianghuawang.cottonfarmer.widget.linkage_menu.CityInterface;

import java.util.List;

public class Corps {

    /**
     * success : true
     * code : 200
     * message : OK
     * data : [{"id":2890,"area_code":"6269901","area_name":"农一师","parent_id":"0","level":1,"created_at":1527479408,"updated_at":1527479408},{"id":2891,"area_code":"6269902","area_name":"农二师","parent_id":"0","level":1,"created_at":1527479408,"updated_at":1527479408},{"id":2892,"area_code":"6269903","area_name":"农三师","parent_id":"0","level":1,"created_at":1527479408,"updated_at":1527479408},{"id":2893,"area_code":"6269904","area_name":"农四师","parent_id":"0","level":1,"created_at":1527479408,"updated_at":1527479408},{"id":2894,"area_code":"6269905","area_name":"农五师","parent_id":"0","level":1,"created_at":1527479408,"updated_at":1527479408},{"id":2895,"area_code":"6269906","area_name":"农六师","parent_id":"0","level":1,"created_at":1527479408,"updated_at":1527479408},{"id":2896,"area_code":"6269907","area_name":"农七师","parent_id":"0","level":1,"created_at":1527479408,"updated_at":1527479408},{"id":2897,"area_code":"6269908","area_name":"农八师","parent_id":"0","level":1,"created_at":1527479408,"updated_at":1527479408},{"id":2898,"area_code":"6269909","area_name":"农九师","parent_id":"0","level":1,"created_at":1527479408,"updated_at":1527479408},{"id":2899,"area_code":"6269910","area_name":"农十师","parent_id":"0","level":1,"created_at":1527479408,"updated_at":1527479408},{"id":2900,"area_code":"6269912","area_name":"农十二师","parent_id":"0","level":1,"created_at":1527479408,"updated_at":1527479408},{"id":2901,"area_code":"6269913","area_name":"农十三师","parent_id":"0","level":1,"created_at":1527479408,"updated_at":1527479408},{"id":2902,"area_code":"6269914","area_name":"农十四师","parent_id":"0","level":1,"created_at":1527479408,"updated_at":1527479408},{"id":2903,"area_code":"6269915","area_name":"新疆兵团兵直","parent_id":"0","level":1,"created_at":1527479408,"updated_at":1527479408}]
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
         * id : 2890
         * area_code : 6269901
         * area_name : 农一师
         * parent_id : 0
         * level : 1
         * created_at : 1527479408
         * updated_at : 1527479408
         */

        private int id;
        private String area_code;
        private String area_name;
        private String parent_id;
        private int level;
        private int created_at;
        private int updated_at;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getArea_code() {
            return area_code;
        }

        public void setArea_code(String area_code) {
            this.area_code = area_code;
        }

        public String getArea_name() {
            return area_name;
        }

        public void setArea_name(String area_name) {
            this.area_name = area_name;
        }

        public String getParent_id() {
            return parent_id;
        }

        public void setParent_id(String parent_id) {
            this.parent_id = parent_id;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getCreated_at() {
            return created_at;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }

        public int getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(int updated_at) {
            this.updated_at = updated_at;
        }

        @Override
        public String getCityName() {
            return getArea_name();
        }
    }
}
