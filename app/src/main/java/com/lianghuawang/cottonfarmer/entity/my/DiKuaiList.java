package com.lianghuawang.cottonfarmer.entity.my;

import java.util.List;

public class DiKuaiList {

    /**
     * success : true
     * code : 200
     * message : OK
     * data : [{"id":46,"vulgo":"无名用","longitude":"140","latitude":"35","land_num":"7","area_type":2,"division":null,"group":null,"even":null,"province":"6266521","city":"626652101","county":"62665210102"},{"id":49,"vulgo":"来了没有","longitude":"140.98","latitude":"39","land_num":"485","area_type":2,"division":null,"group":null,"even":null,"province":"6266521","city":"626652101","county":"62665210102"}]
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

    public static class DataBean {
        /**
         * id : 46
         * vulgo : 无名用
         * longitude : 140
         * latitude : 35
         * land_num : 7
         * area_type : 2
         * division : null
         * group : null
         * even : null
         * province : 6266521
         * city : 626652101
         * county : 62665210102
         */

        private int id;
        private String vulgo;
        private String longitude;
        private String latitude;
        private String land_num;
        private int area_type;
        private String division;
        private String group;
        private String even;
        private String province;
        private String city;
        private String county;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getVulgo() {
            return vulgo;
        }

        public void setVulgo(String vulgo) {
            this.vulgo = vulgo;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLand_num() {
            return land_num;
        }

        public void setLand_num(String land_num) {
            this.land_num = land_num;
        }

        public int getArea_type() {
            return area_type;
        }

        public void setArea_type(int area_type) {
            this.area_type = area_type;
        }

        public Object getDivision() {
            return division;
        }

        public void setDivision(String division) {
            this.division = division;
        }

        public Object getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public Object getEven() {
            return even;
        }

        public void setEven(String even) {
            this.even = even;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCounty() {
            return county;
        }

        public void setCounty(String county) {
            this.county = county;
        }
    }
}
