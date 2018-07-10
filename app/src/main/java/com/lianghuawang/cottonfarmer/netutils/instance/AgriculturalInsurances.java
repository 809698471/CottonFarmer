package com.lianghuawang.cottonfarmer.netutils.instance;

import java.io.Serializable;
import java.util.List;

/**
 * 农业保险实例
 */
public class AgriculturalInsurances implements Serializable {


    /**
     * success : true
     * code : 200
     * message : OK
     * data : [{"product_id":"D1529574571","name":"喀什-棉花种植险","image_url":"/images/insurance/images/product_picture1530609452棉花种植险.png","cate_id":{"cate_id":1,"cate_name":"农业保险"},"price":"￥526元/亩","describe":"<p>为投保人规避自然灾害造成的棉花损失的风险，在保险期间内，由于暴雨、洪水（政府行蓄洪除外）、内涝、风灾、雹灾、冻灾、旱灾、地震；泥石流、山体滑坡；病虫草鼠害原因直接造成保险棉花的损失，损失率达到10%以上的，保险公司按照约定负责赔偿：<\/p>","start_end_time":"2018.06.23-2018.09.30","category_name":{"category_id":"1621","category_name":"棉花种植险"},"is_buy":{"status":0,"message":"未购买保险"}},{"product_id":"D1528860397","name":"2018年棉花价格保险","image_url":"/images/insurance/images/product_picture1530609478棉花价格.png","cate_id":{"cate_id":1,"cate_name":"农业保险"},"price":"￥1650元/亩","describe":"<p style=\"background: white\"><span style=\"font-size: 19px;font-family: 宋体\">为投保人规避市场价格波动带来的风险，约定时期内，约定棉花期货合约各交易日收盘价的平均值低于棉花目标价格时，视为保险事故发生，保险人按照本保险合同的约定负责赔偿。<\/span><\/p><p><br/><\/p>","start_end_time":"2018.10.01-2018.11.30","category_name":{"category_id":"1621","category_name":"棉花种植险"},"is_buy":{"status":0,"message":"未购买保险"}},{"product_id":"D1528859637","name":"2018年新疆兵团棉花种植保险","image_url":"/images/insurance/images/product_picture1530609509棉花种植.png","cate_id":{"cate_id":1,"cate_name":"农业保险"},"price":"￥1000元/亩","describe":"<p><span style=\"font-size:19px;font-family:宋体\">为投保人规避自然灾害造成的棉花损失的风险，在保险期间内，由于暴雨、洪水（政府行蓄洪除外）、内涝、风灾、雹灾、冻灾、旱灾、地震；泥石流、山体滑坡；病虫草鼠害原因直接造成保险棉花的损失，损失率达到10%以上的，保险公司按照约定负责赔偿： &nbsp;<\/span><\/p>","start_end_time":"2018.07.01-2018.09.30","category_name":{"category_id":"1621","category_name":"棉花种植险"},"is_buy":{"status":0,"message":"未购买保险"}}]
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
         * product_id : D1529574571
         * name : 喀什-棉花种植险
         * image_url : /images/insurance/images/product_picture1530609452棉花种植险.png
         * cate_id : {"cate_id":1,"cate_name":"农业保险"}
         * price : ￥526元/亩
         * describe : <p>为投保人规避自然灾害造成的棉花损失的风险，在保险期间内，由于暴雨、洪水（政府行蓄洪除外）、内涝、风灾、雹灾、冻灾、旱灾、地震；泥石流、山体滑坡；病虫草鼠害原因直接造成保险棉花的损失，损失率达到10%以上的，保险公司按照约定负责赔偿：</p>
         * start_end_time : 2018.06.23-2018.09.30
         * category_name : {"category_id":"1621","category_name":"棉花种植险"}
         * is_buy : {"status":0,"message":"未购买保险"}
         */

        private String product_id;
        private String name;
        private String image_url;
        private CateIdBean cate_id;
        private String price;
        private String describe;
        private String start_end_time;
        private CategoryNameBean category_name;
        private IsBuyBean is_buy;

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

        public CateIdBean getCate_id() {
            return cate_id;
        }

        public void setCate_id(CateIdBean cate_id) {
            this.cate_id = cate_id;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
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

        public CategoryNameBean getCategory_name() {
            return category_name;
        }

        public void setCategory_name(CategoryNameBean category_name) {
            this.category_name = category_name;
        }

        public IsBuyBean getIs_buy() {
            return is_buy;
        }

        public void setIs_buy(IsBuyBean is_buy) {
            this.is_buy = is_buy;
        }

        public static class CateIdBean {
            /**
             * cate_id : 1
             * cate_name : 农业保险
             */

            private int cate_id;
            private String cate_name;

            public int getCate_id() {
                return cate_id;
            }

            public void setCate_id(int cate_id) {
                this.cate_id = cate_id;
            }

            public String getCate_name() {
                return cate_name;
            }

            public void setCate_name(String cate_name) {
                this.cate_name = cate_name;
            }
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

        public static class IsBuyBean {
            /**
             * status : 0
             * message : 未购买保险
             */

            private int status;
            private String message;

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }
        }
    }
}
