package com.lianghuawang.cottonfarmer.entity.my;

public class CardYanZheng {


    /**
     * success : false
     * code : 422
     * message : Unprocessable entity
     * data : {"errmsg":"验证码错误","successmsg":"绑卡成功"}
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
         * errmsg : 验证码错误
         * successmsg : 绑卡成功
         */

        private String errmsg;
        private String successmsg;

        public String getErrmsg() {
            return errmsg;
        }

        public void setErrmsg(String errmsg) {
            this.errmsg = errmsg;
        }

        public String getSuccessmsg() {
            return successmsg;
        }

        public void setSuccessmsg(String successmsg) {
            this.successmsg = successmsg;
        }
    }
}
