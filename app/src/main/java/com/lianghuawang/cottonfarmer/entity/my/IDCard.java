package com.lianghuawang.cottonfarmer.entity.my;

public class IDCard {

    /**
     * success : true
     * code : 200
     * message : OK
     * data : {"errmsg":"上传成功","imageUrl":"images/idcode/201806/27/1530096426922b2bd5-e1ca-3e50-8274-e9c8b63f2085.jpg"}
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
         * errmsg : 上传成功
         * imageUrl : images/idcode/201806/27/1530096426922b2bd5-e1ca-3e50-8274-e9c8b63f2085.jpg
         */

        private String errmsg;
        private String imageUrl;

        public String getErrmsg() {
            return errmsg;
        }

        public void setErrmsg(String errmsg) {
            this.errmsg = errmsg;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }
}
