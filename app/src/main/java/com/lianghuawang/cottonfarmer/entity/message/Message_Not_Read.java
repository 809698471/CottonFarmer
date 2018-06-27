package com.lianghuawang.cottonfarmer.entity.message;

public class Message_Not_Read {

    /**
     * success : false
     * code : 401
     * message : Unauthorized
     * data : {"name":"Unauthorized","message":"Your request was made with invalid credentials.","code":0,"status":401,"type":"yii\\web\\UnauthorizedHttpException","count":"0"}
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
         * name : Unauthorized
         * message : Your request was made with invalid credentials.
         * code : 0
         * status : 401
         * type : yii\web\UnauthorizedHttpException
         * count : 0
         */

        private String name;
        private String message;
        private int code;
        private int status;
        private String type;
        private String count;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }
    }
}
