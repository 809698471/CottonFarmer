package com.lianghuawang.cottonfarmer.entity.my;

public class InsuranceDelEntity {


    /**
     * success : true
     * code : 200
     * message : OK
     * data : {"successmsg":"删除成功!"}
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
         * successmsg : 删除成功!
         */

        private String successmsg;

        public String getSuccessmsg() {
            return successmsg;
        }

        public void setSuccessmsg(String successmsg) {
            this.successmsg = successmsg;
        }
    }
}
