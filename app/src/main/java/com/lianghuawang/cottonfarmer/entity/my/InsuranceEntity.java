package com.lianghuawang.cottonfarmer.entity.my;

import java.io.Serializable;
import java.util.List;

public class InsuranceEntity {


    /**
     * success : true
     * code : 200
     * message : OK
     * data : [{"id":82,"year":2018,"risk":"1621","ins_area":50,"risk_name":"棉花种植险"}]
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

    public static class DataBean implements Serializable{
        /**
         * id : 82
         * year : 2018
         * risk : 1621
         * ins_area : 50
         * risk_name : 棉花种植险
         */

        private int id;
        private int year;
        private String risk;
        private int ins_area;
        private String risk_name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public String getRisk() {
            return risk;
        }

        public void setRisk(String risk) {
            this.risk = risk;
        }

        public int getIns_area() {
            return ins_area;
        }

        public void setIns_area(int ins_area) {
            this.ins_area = ins_area;
        }

        public String getRisk_name() {
            return risk_name;
        }

        public void setRisk_name(String risk_name) {
            this.risk_name = risk_name;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", year=" + year +
                    ", risk='" + risk + '\'' +
                    ", ins_area=" + ins_area +
                    ", risk_name='" + risk_name + '\'' +
                    '}';
        }
    }
}
