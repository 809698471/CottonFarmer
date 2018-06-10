package com.lianghuawang.cottonfarmer.entity.home.insurance;

public class ConfirmOrder {


    /**
     * success : true
     * code : 200
     * message : OK
     * data : {"username":"范文轲","id_code":"412727199308122715","address":"北京","name":"测试","category_name":{"category_id":"1621","category_name":"棉花种植险"},"risk_name":"综合保险","image_url":"/images/insurance/images/product_picture1528455267t013f3d9225b0e93841.jpg","cotton_area":"200亩","price":"1000","insurance_amount":200000,"rate":90,"premium":18000,"plant_area":"新疆兵团农一师一团一连","n_tgt_fld1":1800,"n_tgt_fld2":3600,"n_tgt_fld3":1800,"n_tgt_fld4":1800,"n_tgt_fld5":3600,"n_tgt_fld6":1800,"n_tgt_fld7":1800,"n_tgt_fld8":1800,"pay_num":1800,"dead_start_time":"2018-06-09 00:00:00","dead_end_time":"2018-06-12 00:00:00","take_effect":"测试测试测试测试测试测试","special_agreement":"测试测试测试测试测试测试"}
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
         * username : 范文轲
         * id_code : 412727199308122715
         * address : 北京
         * name : 测试
         * category_name : {"category_id":"1621","category_name":"棉花种植险"}
         * risk_name : 综合保险
         * image_url : /images/insurance/images/product_picture1528455267t013f3d9225b0e93841.jpg
         * cotton_area : 200亩
         * price : 1000
         * insurance_amount : 200000
         * rate : 90
         * premium : 18000
         * plant_area : 新疆兵团农一师一团一连
         * n_tgt_fld1 : 1800
         * n_tgt_fld2 : 3600
         * n_tgt_fld3 : 1800
         * n_tgt_fld4 : 1800
         * n_tgt_fld5 : 3600
         * n_tgt_fld6 : 1800
         * n_tgt_fld7 : 1800
         * n_tgt_fld8 : 1800
         * pay_num : 1800
         * dead_start_time : 2018-06-09 00:00:00
         * dead_end_time : 2018-06-12 00:00:00
         * take_effect : 测试测试测试测试测试测试
         * special_agreement : 测试测试测试测试测试测试
         */

        private String username;
        private String id_code;
        private String address;
        private String name;
        private CategoryNameBean category_name;
        private String risk_name;
        private String image_url;
        private String cotton_area;
        private String price;
        private int insurance_amount;
        private int rate;
        private int premium;
        private String plant_area;
        private int n_tgt_fld1;
        private int n_tgt_fld2;
        private int n_tgt_fld3;
        private int n_tgt_fld4;
        private int n_tgt_fld5;
        private int n_tgt_fld6;
        private int n_tgt_fld7;
        private int n_tgt_fld8;
        private int pay_num;
        private String dead_start_time;
        private String dead_end_time;
        private String take_effect;
        private String special_agreement;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getId_code() {
            return id_code;
        }

        public void setId_code(String id_code) {
            this.id_code = id_code;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public CategoryNameBean getCategory_name() {
            return category_name;
        }

        public void setCategory_name(CategoryNameBean category_name) {
            this.category_name = category_name;
        }

        public String getRisk_name() {
            return risk_name;
        }

        public void setRisk_name(String risk_name) {
            this.risk_name = risk_name;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getCotton_area() {
            return cotton_area;
        }

        public void setCotton_area(String cotton_area) {
            this.cotton_area = cotton_area;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public int getInsurance_amount() {
            return insurance_amount;
        }

        public void setInsurance_amount(int insurance_amount) {
            this.insurance_amount = insurance_amount;
        }

        public int getRate() {
            return rate;
        }

        public void setRate(int rate) {
            this.rate = rate;
        }

        public int getPremium() {
            return premium;
        }

        public void setPremium(int premium) {
            this.premium = premium;
        }

        public String getPlant_area() {
            return plant_area;
        }

        public void setPlant_area(String plant_area) {
            this.plant_area = plant_area;
        }

        public int getN_tgt_fld1() {
            return n_tgt_fld1;
        }

        public void setN_tgt_fld1(int n_tgt_fld1) {
            this.n_tgt_fld1 = n_tgt_fld1;
        }

        public int getN_tgt_fld2() {
            return n_tgt_fld2;
        }

        public void setN_tgt_fld2(int n_tgt_fld2) {
            this.n_tgt_fld2 = n_tgt_fld2;
        }

        public int getN_tgt_fld3() {
            return n_tgt_fld3;
        }

        public void setN_tgt_fld3(int n_tgt_fld3) {
            this.n_tgt_fld3 = n_tgt_fld3;
        }

        public int getN_tgt_fld4() {
            return n_tgt_fld4;
        }

        public void setN_tgt_fld4(int n_tgt_fld4) {
            this.n_tgt_fld4 = n_tgt_fld4;
        }

        public int getN_tgt_fld5() {
            return n_tgt_fld5;
        }

        public void setN_tgt_fld5(int n_tgt_fld5) {
            this.n_tgt_fld5 = n_tgt_fld5;
        }

        public int getN_tgt_fld6() {
            return n_tgt_fld6;
        }

        public void setN_tgt_fld6(int n_tgt_fld6) {
            this.n_tgt_fld6 = n_tgt_fld6;
        }

        public int getN_tgt_fld7() {
            return n_tgt_fld7;
        }

        public void setN_tgt_fld7(int n_tgt_fld7) {
            this.n_tgt_fld7 = n_tgt_fld7;
        }

        public int getN_tgt_fld8() {
            return n_tgt_fld8;
        }

        public void setN_tgt_fld8(int n_tgt_fld8) {
            this.n_tgt_fld8 = n_tgt_fld8;
        }

        public int getPay_num() {
            return pay_num;
        }

        public void setPay_num(int pay_num) {
            this.pay_num = pay_num;
        }

        public String getDead_start_time() {
            return dead_start_time;
        }

        public void setDead_start_time(String dead_start_time) {
            this.dead_start_time = dead_start_time;
        }

        public String getDead_end_time() {
            return dead_end_time;
        }

        public void setDead_end_time(String dead_end_time) {
            this.dead_end_time = dead_end_time;
        }

        public String getTake_effect() {
            return take_effect;
        }

        public void setTake_effect(String take_effect) {
            this.take_effect = take_effect;
        }

        public String getSpecial_agreement() {
            return special_agreement;
        }

        public void setSpecial_agreement(String special_agreement) {
            this.special_agreement = special_agreement;
        }

        public static class CategoryNameBean {
            /**
             * category_id : 1621
             * category_name : 棉花种植险
             */

            private String category_id;
            private String category_name;

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
            }

            public String getCategory_name() {
                return category_name;
            }

            public void setCategory_name(String category_name) {
                this.category_name = category_name;
            }
        }
    }
}
