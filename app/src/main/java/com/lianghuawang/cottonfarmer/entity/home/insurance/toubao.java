package com.lianghuawang.cottonfarmer.entity.home.insurance;

public class toubao {


    /**
     * success : true
     * code : 200.0
     * message : OK
     * data : {"o_water":"CZPT2018061100040659690000","message":"预约投保成功，请等待审核"}
     */

    private boolean success;
    private int code;
    private String message;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * o_water : CZPT2018061100040659690000
         * message : 预约投保成功，请等待审核
         */

        private String o_water;
        private String message;
        private String errmsg;

        public void setErrmsg(String errmsg){
            this.errmsg = message;
        }

        public String getErrmsg(){
            return errmsg;
        }

        public String getO_water() {
            return o_water;
        }

        public void setO_water(String o_water) {
            this.o_water = o_water;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
