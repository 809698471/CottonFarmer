package com.lianghuawang.cottonfarmer.netutils.instance;

/**
 * 登录注册实体类
 */
public class LoginInstance {


    /**
     * success : false
     * code : 422
     * message : Unprocessable entity
     * data : {"errmsg":"该账号尚未注册","access_token": "_vYm9Ohs8qf6lReS0iUb48kaQW7N67DO","step": 0}
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
         * errmsg : 该账号尚未注册
         * "access_token": "_vYm9Ohs8qf6lReS0iUb48kaQW7N67DO"
         * "step": 0
         */

        private String errmsg;
        private String access_token;
        private int step;

        public String getErrmsg() {
            return errmsg;
        }

        public void setErrmsg(String errmsg) {
            this.errmsg = errmsg;
        }

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        public int getStep() {
            return step;
        }

        public void setStep(int step) {
            this.step = step;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "errmsg='" + errmsg + '\'' +
                    ", access_token='" + access_token + '\'' +
                    ", step=" + step +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LoginInstance{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
