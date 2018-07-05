package com.lianghuawang.cottonfarmer.entity.my;

import java.util.List;

public class InsuranceTypesEntity {

    /**
     * success : true
     * code : 200
     * message : OK
     * data : [{"product_number":"1621","product_type":"棉花种植险"},{"product_number":"1668","product_type":"棉花价格险"},{"product_number":"1675","product_type":"棉花收入险"},{"product_number":"132G","product_type":"短期借款人还贷保证保险"}]
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
         * product_number : 1621
         * product_type : 棉花种植险
         */

        private String product_number;
        private String product_type;

        public String getProduct_number() {
            return product_number;
        }

        public void setProduct_number(String product_number) {
            this.product_number = product_number;
        }

        public String getProduct_type() {
            return product_type;
        }

        public void setProduct_type(String product_type) {
            this.product_type = product_type;
        }
    }
}
