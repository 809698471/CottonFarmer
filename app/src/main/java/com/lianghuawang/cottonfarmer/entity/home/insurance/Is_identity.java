package com.lianghuawang.cottonfarmer.entity.home.insurance;
/**
 * create by fanwenke at 2018/7/9
 * 检测保险是否可用购买实例
 * code：0没有实名认证
 */
public class Is_identity {

    /**
     * success : true
     * code : 200
     * message : OK
     * data : {"code":"0","errmsg":"该账号尚未实名认证，无法预约。"}
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
         * code : 0
         * errmsg : 该账号尚未实名认证，无法预约。
         */

        private String code;
        private String errmsg;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getErrmsg() {
            return errmsg;
        }

        public void setErrmsg(String errmsg) {
            this.errmsg = errmsg;
        }
    }
}
