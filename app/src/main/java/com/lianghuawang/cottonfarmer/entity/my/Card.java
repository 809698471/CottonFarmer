package com.lianghuawang.cottonfarmer.entity.my;

public class Card {

    /**
     * success : true
     * code : 200
     * message : OK
     * data : {"errmsg":"银行卡号的值\"6214623750000229755\"已经被占用了。","key":"verificationCode_lviXxhyLDLGxqVI","expired_at":"2018-06-12 14:49:18"}
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
         * errmsg : 银行卡号的值"6214623750000229755"已经被占用了。
         * key : verificationCode_lviXxhyLDLGxqVI
         * expired_at : 2018-06-12 14:49:18
         */

        private String errmsg;
        private String key;
        private String expired_at;

        public String getErrmsg() {
            return errmsg;
        }

        public void setErrmsg(String errmsg) {
            this.errmsg = errmsg;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getExpired_at() {
            return expired_at;
        }

        public void setExpired_at(String expired_at) {
            this.expired_at = expired_at;
        }
    }
}
