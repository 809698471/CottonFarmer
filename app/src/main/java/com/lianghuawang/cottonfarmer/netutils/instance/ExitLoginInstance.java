package com.lianghuawang.cottonfarmer.netutils.instance;

public class ExitLoginInstance {

    /**
     * success : true
     * code : 200
     * message : OK
     * data : {"successmsg":"退出成功"}
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
         * successmsg : 退出成功
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
