package com.lianghuawang.cottonfarmer.netutils.instance;

import java.util.List;

public class BuyInsurances {


    /**
     * success : true
     * code : 200
     * message : OK
     * data : [{"product_id":"d1526544239","name":"2018棉花种植险","image_url":"image/product_picture/product_picture1526544239img2.png","describe":"2018棉花种植险","start_end_time":"2018.02.15-2021.08.14","detail_url":"image/product_picture/product_picture1526544239img1.png","category_name":{"category_id":"1621","category_name":"棉花种植险"},"ins_obj":"棉花生成者","area":[{"area_code":"6531224","area_name":"农三师"},{"area_code":"659003400000","area_name":"图木舒克市兵团四十四团"},{"area_code":"659003400204","area_name":"兵团四十四团四连"}],"insurance_nature":"中央政策性保险","rate":90,"price":"100元/亩","dead_start_time":"2018-02-15 23:55:00","dead_end_time":"2021-08-14 15:55:00","take_effect":"付款即生效","special_agreement":null,"n_tgt_fld1":65,"n_tgt_fld2":0,"n_tgt_fld3":0,"n_tgt_fld4":0,"n_tgt_fld5":0,"n_tgt_fld6":0,"n_tgt_fld7":0,"n_tgt_fld8":35},{"product_id":"d1526544240","name":"1023棉花种植险","image_url":"image/product_picture/product_picture1526544239img2.png","describe":"2018棉花种植险","start_end_time":"2018.02.15-2021.08.14","detail_url":"image/product_picture/product_picture1526544239img1.png","category_name":{"category_id":"1621","category_name":"棉花种植险"},"ins_obj":"棉花生成者","area":[{"area_code":"6531224","area_name":"农三师"},{"area_code":"659003400000","area_name":"图木舒克市兵团四十四团"},{"area_code":"659003400204","area_name":"兵团四十四团四连"}],"insurance_nature":"中央政策性保险","rate":90,"price":"100元/亩","dead_start_time":"2018-02-15 23:55:00","dead_end_time":"2021-08-14 15:55:00","take_effect":"付款即生效","special_agreement":null,"n_tgt_fld1":65,"n_tgt_fld2":0,"n_tgt_fld3":0,"n_tgt_fld4":0,"n_tgt_fld5":0,"n_tgt_fld6":0,"n_tgt_fld7":0,"n_tgt_fld8":35}]
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
         * product_id : d1526544239
         * name : 2018棉花种植险
         * image_url : image/product_picture/product_picture1526544239img2.png
         * describe : 2018棉花种植险
         * start_end_time : 2018.02.15-2021.08.14
         * detail_url : image/product_picture/product_picture1526544239img1.png
         * category_name : {"category_id":"1621","category_name":"棉花种植险"}
         * ins_obj : 棉花生成者
         * area : [{"area_code":"6531224","area_name":"农三师"},{"area_code":"659003400000","area_name":"图木舒克市兵团四十四团"},{"area_code":"659003400204","area_name":"兵团四十四团四连"}]
         * insurance_nature : 中央政策性保险
         * rate : 90
         * price : 100元/亩
         * dead_start_time : 2018-02-15 23:55:00
         * dead_end_time : 2021-08-14 15:55:00
         * take_effect : 付款即生效
         * special_agreement : null
         * n_tgt_fld1 : 65
         * n_tgt_fld2 : 0
         * n_tgt_fld3 : 0
         * n_tgt_fld4 : 0
         * n_tgt_fld5 : 0
         * n_tgt_fld6 : 0
         * n_tgt_fld7 : 0
         * n_tgt_fld8 : 35
         */

        private String product_id;
        private String name;
        private String image_url;
        private String describe;
        private String start_end_time;
        private String detail_url;
        private CategoryNameBean category_name;
        private String ins_obj;
        private String insurance_nature;
        private int rate;
        private String price;
        private String dead_start_time;
        private String dead_end_time;
        private String take_effect;
        private Object special_agreement;
        private int n_tgt_fld1;
        private int n_tgt_fld2;
        private int n_tgt_fld3;
        private int n_tgt_fld4;
        private int n_tgt_fld5;
        private int n_tgt_fld6;
        private int n_tgt_fld7;
        private int n_tgt_fld8;
        private List<AreaBean> area;

        public String getProduct_id() {
            return product_id;
        }

        public void setProduct_id(String product_id) {
            this.product_id = product_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }

        public String getStart_end_time() {
            return start_end_time;
        }

        public void setStart_end_time(String start_end_time) {
            this.start_end_time = start_end_time;
        }

        public String getDetail_url() {
            return detail_url;
        }

        public void setDetail_url(String detail_url) {
            this.detail_url = detail_url;
        }

        public CategoryNameBean getCategory_name() {
            return category_name;
        }

        public void setCategory_name(CategoryNameBean category_name) {
            this.category_name = category_name;
        }

        public String getIns_obj() {
            return ins_obj;
        }

        public void setIns_obj(String ins_obj) {
            this.ins_obj = ins_obj;
        }

        public String getInsurance_nature() {
            return insurance_nature;
        }

        public void setInsurance_nature(String insurance_nature) {
            this.insurance_nature = insurance_nature;
        }

        public int getRate() {
            return rate;
        }

        public void setRate(int rate) {
            this.rate = rate;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
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

        public Object getSpecial_agreement() {
            return special_agreement;
        }

        public void setSpecial_agreement(Object special_agreement) {
            this.special_agreement = special_agreement;
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

        public List<AreaBean> getArea() {
            return area;
        }

        public void setArea(List<AreaBean> area) {
            this.area = area;
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

        public static class AreaBean {
            /**
             * area_code : 6531224
             * area_name : 农三师
             */

            private String area_code;
            private String area_name;

            public String getArea_code() {
                return area_code;
            }

            public void setArea_code(String area_code) {
                this.area_code = area_code;
            }

            public String getArea_name() {
                return area_name;
            }

            public void setArea_name(String area_name) {
                this.area_name = area_name;
            }
        }
    }
}
