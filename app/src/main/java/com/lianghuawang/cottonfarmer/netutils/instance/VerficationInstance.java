package com.lianghuawang.cottonfarmer.netutils.instance;

public class VerficationInstance {


    /**
     * success : true
     * code : 200
     * message : OK
     * data : {"key":"verificationCode_P3JbjlXSHap3Yfd","expired_at":"2018-05-14 11:08:50"}
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
         * key : verificationCode_P3JbjlXSHap3Yfd
         * expired_at : 2018-05-14 11:08:50
         * "errmsg":"验证key不能为空。"
         */

        private String key;
        private String expired_at;
        private String errmsg;

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

        @Override
        public String toString() {
            return "DataBean{" +
                    "key='" + key + '\'' +
                    ", expired_at='" + expired_at + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "VerficationInstance{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
