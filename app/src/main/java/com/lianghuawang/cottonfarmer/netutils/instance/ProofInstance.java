package com.lianghuawang.cottonfarmer.netutils.instance;

import java.util.List;

public class ProofInstance {


    /**
     * success : true
     * code : 200
     * message : OK
     * data : [{"id":25,"img_url":"images/ownership/201806/04/1528093610a4c73ab7-024e-31d6-b915-9d14f18e04e0.jpg","is_real":0},{"id":26,"img_url":"images/ownership/201806/04/152809363023cf1ecb-4059-3ff5-81a5-80f865de6766.jpg","is_real":0}]
     */

    private boolean success;
    private int code;
    private String message;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 25
         * img_url : images/ownership/201806/04/1528093610a4c73ab7-024e-31d6-b915-9d14f18e04e0.jpg
         * is_real : 0
         */
        private int flag;
        private int id;
        private String img_url;
        private int is_real;
        private boolean updata;

        public boolean isUpdata() {
            return updata;
        }

        public void setUpdata(boolean updata) {
            this.updata = updata;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImg_url() {
            return img_url;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }

        public int getIs_real() {
            return is_real;
        }

        public void setIs_real(int is_real) {
            this.is_real = is_real;
        }
    }
}
