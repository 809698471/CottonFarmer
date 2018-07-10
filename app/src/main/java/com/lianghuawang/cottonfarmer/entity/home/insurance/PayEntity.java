package com.lianghuawang.cottonfarmer.entity.home.insurance;

public class PayEntity {

    /**
     * success : true
     * code : 200
     * message : OK
     * data : {"msg":"该笔订单已设置为支付中","errmsg":"暂无该订单，或已支付"}
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
         * msg : 该笔订单已设置为支付中
         * errmsg : 暂无该订单，或已支付
         */

        private String msg;
        private String errmsg;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getErrmsg() {
            return errmsg;
        }

        public void setErrmsg(String errmsg) {
            this.errmsg = errmsg;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "msg='" + msg + '\'' +
                    ", errmsg='" + errmsg + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "PayEntity{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
