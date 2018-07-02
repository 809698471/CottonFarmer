package com.lianghuawang.cottonfarmer.entity.oder;

import java.util.List;

public class OrderAll {


    /**
     * success : true
     * code : 200
     * message : OK
     * data : [{"o_water":"CZPT2018061317320613450000","c_ply_no":null,"username":"范文轲","id_code":"412727199308122715","address":"北京","category_name":{"category_id":"1621","category_name":"棉花种植险"},"name":"2018年新疆兵团棉花种植保险","risk_name":"综合保险","image_url":"/images/insurance/images/product_picture1528859637t01fd08f0d837bed260.jpg","cotton_area":"1000000亩","price":"1000","insurance_amount":"1000000000","rate":70,"premium":"70000000","plant_area":"一团一团一连新疆兵团农一师","n_tgt_fld1":"45500000","n_tgt_fld2":"0","n_tgt_fld3":"0","n_tgt_fld4":"0","n_tgt_fld5":"0","n_tgt_fld6":"0","n_tgt_fld7":"0","n_tgt_fld8":"24500000","pay_amount":"24500000","dead_start_time":"2018-07-01 00:00:00","dead_end_time":"2018-09-30 23:59:00","start_end_time":"2018.07.01 -2018.09.30","take_effect":"保险责任期间自保险棉花播种时起，至成熟开始收获时止，但不得超出保险单载明的保险期间范围。","special_agreement":"1：按照每亩皮棉100公斤计算；2：棉花保险价格1650元/吨；3：棉花实际价格采集期2018年5月2日至2018年6月12日实际价格来源为1801合约在价格采集期的平均收盘价。","created_at":"2018-06-13 17:32:33","pay_way":"线下支付","pay_status":1,"service_time":"2018-06-29 09:50:14","cooperative":"小棉袄合作社","mechanism":"中华联合财产保险股份有限公司一团支公司","status":1,"signed":{"status":1,"message":"已签名","sign_url":"/images/sign/20180613/1528882359bb9db2b0-dcaf-3072-94a9-934a2ffd9ffb."},"pay_date_time":"2018-06-14 17:32:33","describe":"<p><span style=\"font-size:19px;font-family:宋体\">在保险期间内，由于下列原因直接造成保险的或损失，损失率达到10%以上的，保险人按照本保险合同的约定负责赔偿： 暴雨、洪水（政府行蓄洪除外）、内涝、风灾、雹灾、冻灾、旱灾、地震、火灾； 泥石流、山体滑坡； 病虫草鼠害。&nbsp; &nbsp;<\/span><\/p>"},{"o_water":"CZPT2018061316470635400000","c_ply_no":null,"username":"范文轲","id_code":"412727199308122715","address":"北京","category_name":{"category_id":"1668","category_name":"棉花价格险"},"name":"2018年棉花价格保险","risk_name":"主险","image_url":"/images/insurance/images/product_picture1528860397t01c3bcccd9066fc125.jpg","cotton_area":"200亩","price":"1650","insurance_amount":"330000","rate":40,"premium":"13200","plant_area":"一团一团一连新疆兵团农一师","n_tgt_fld1":"0","n_tgt_fld2":"0","n_tgt_fld3":"0","n_tgt_fld4":"0","n_tgt_fld5":"0","n_tgt_fld6":"0","n_tgt_fld7":"0","n_tgt_fld8":"13200","pay_amount":"13200","dead_start_time":"2018-10-01 00:00:00","dead_end_time":"2018-11-30 23:59:00","start_end_time":"2018.10.01 -2018.11.30","take_effect":"标的合约：郑商所棉花1801合约\r\n行权价格：投保时标的合约价格\r\n期权期限：10月1日-11月30日\r\n结算价格：10月1日-11月30日标的合约日收盘价均值","special_agreement":"1：按照每亩皮棉1140公斤计算；2：棉花保险价格16000元/吨；3：棉花实际价格采集期2018年5月2日至2018年6月12日实际价格来源为1801合约在价格采集期的平均收盘价。","created_at":"2018-06-13 16:47:31","pay_way":"线下支付","pay_status":1,"service_time":"2018-06-29 09:50:14","cooperative":"小棉袄合作社","mechanism":"中华联合财产保险股份有限公司哈巴河支公司一八五团营销服务部","status":1,"signed":{"status":1,"message":"已签名","sign_url":"/images/sign/20180613/152887976842651361-786a-3ff6-85d5-31a6f8ff394c."},"pay_date_time":"2018-06-14 16:47:31","describe":"<p style=\"background: white\"><span style=\"font-size: 19px;font-family: 宋体\">农户向保险公司购买价格保险，当实际价格低于目标价格时获得赔付；保险公司通过购买期货公司风险管理子公司的场外期权对冲价格风险；期货公司风险管理子公司利用期货复制期权，通过期货市场转移风险；<\/span><\/p><p><br/><\/p>"}]
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
         * o_water : CZPT2018061317320613450000
         * c_ply_no : null
         * username : 范文轲
         * id_code : 412727199308122715
         * address : 北京
         * category_name : {"category_id":"1621","category_name":"棉花种植险"}
         * name : 2018年新疆兵团棉花种植保险
         * risk_name : 综合保险
         * image_url : /images/insurance/images/product_picture1528859637t01fd08f0d837bed260.jpg
         * cotton_area : 1000000亩
         * price : 1000
         * insurance_amount : 1000000000
         * rate : 70
         * premium : 70000000
         * plant_area : 一团一团一连新疆兵团农一师
         * n_tgt_fld1 : 45500000
         * n_tgt_fld2 : 0
         * n_tgt_fld3 : 0
         * n_tgt_fld4 : 0
         * n_tgt_fld5 : 0
         * n_tgt_fld6 : 0
         * n_tgt_fld7 : 0
         * n_tgt_fld8 : 24500000
         * pay_amount : 24500000
         * dead_start_time : 2018-07-01 00:00:00
         * dead_end_time : 2018-09-30 23:59:00
         * start_end_time : 2018.07.01 -2018.09.30
         * take_effect : 保险责任期间自保险棉花播种时起，至成熟开始收获时止，但不得超出保险单载明的保险期间范围。
         * special_agreement : 1：按照每亩皮棉100公斤计算；2：棉花保险价格1650元/吨；3：棉花实际价格采集期2018年5月2日至2018年6月12日实际价格来源为1801合约在价格采集期的平均收盘价。
         * created_at : 2018-06-13 17:32:33
         * pay_way : 线下支付
         * pay_status : 1
         * service_time : 2018-06-29 09:50:14
         * cooperative : 小棉袄合作社
         * mechanism : 中华联合财产保险股份有限公司一团支公司
         * status : 1
         * signed : {"status":1,"message":"已签名","sign_url":"/images/sign/20180613/1528882359bb9db2b0-dcaf-3072-94a9-934a2ffd9ffb."}
         * pay_date_time : 2018-06-14 17:32:33
         * describe : <p><span style="font-size:19px;font-family:宋体">在保险期间内，由于下列原因直接造成保险的或损失，损失率达到10%以上的，保险人按照本保险合同的约定负责赔偿： 暴雨、洪水（政府行蓄洪除外）、内涝、风灾、雹灾、冻灾、旱灾、地震、火灾； 泥石流、山体滑坡； 病虫草鼠害。&nbsp; &nbsp;</span></p>
         */

        private String o_water;
        private String c_ply_no;
        private String username;
        private String id_code;
        private String address;
        private CategoryNameBean category_name;
        private String name;
        private String risk_name;
        private String image_url;
        private String cotton_area;
        private String price;
        private String insurance_amount;
        private int rate;
        private String premium;
        private String plant_area;
        private String n_tgt_fld1;
        private String n_tgt_fld2;
        private String n_tgt_fld3;
        private String n_tgt_fld4;
        private String n_tgt_fld5;
        private String n_tgt_fld6;
        private String n_tgt_fld7;
        private String n_tgt_fld8;
        private String pay_amount;
        private String dead_start_time;
        private String dead_end_time;
        private String start_end_time;
        private String take_effect;
        private String special_agreement;
        private String created_at;
        private String pay_way;
        private int pay_status;
        private String service_time;
        private String cooperative;
        private String mechanism;
        private int status;
        private SignedBean signed;
        private String pay_date_time;
        private String describe;

        public String getO_water() {
            return o_water;
        }

        public void setO_water(String o_water) {
            this.o_water = o_water;
        }

        public String getC_ply_no() {
            return c_ply_no;
        }

        public void setC_ply_no(String c_ply_no) {
            this.c_ply_no = c_ply_no;
        }

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

        public CategoryNameBean getCategory_name() {
            return category_name;
        }

        public void setCategory_name(CategoryNameBean category_name) {
            this.category_name = category_name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

        public String getInsurance_amount() {
            return insurance_amount;
        }

        public void setInsurance_amount(String insurance_amount) {
            this.insurance_amount = insurance_amount;
        }

        public int getRate() {
            return rate;
        }

        public void setRate(int rate) {
            this.rate = rate;
        }

        public String getPremium() {
            return premium;
        }

        public void setPremium(String premium) {
            this.premium = premium;
        }

        public String getPlant_area() {
            return plant_area;
        }

        public void setPlant_area(String plant_area) {
            this.plant_area = plant_area;
        }

        public String getN_tgt_fld1() {
            return n_tgt_fld1;
        }

        public void setN_tgt_fld1(String n_tgt_fld1) {
            this.n_tgt_fld1 = n_tgt_fld1;
        }

        public String getN_tgt_fld2() {
            return n_tgt_fld2;
        }

        public void setN_tgt_fld2(String n_tgt_fld2) {
            this.n_tgt_fld2 = n_tgt_fld2;
        }

        public String getN_tgt_fld3() {
            return n_tgt_fld3;
        }

        public void setN_tgt_fld3(String n_tgt_fld3) {
            this.n_tgt_fld3 = n_tgt_fld3;
        }

        public String getN_tgt_fld4() {
            return n_tgt_fld4;
        }

        public void setN_tgt_fld4(String n_tgt_fld4) {
            this.n_tgt_fld4 = n_tgt_fld4;
        }

        public String getN_tgt_fld5() {
            return n_tgt_fld5;
        }

        public void setN_tgt_fld5(String n_tgt_fld5) {
            this.n_tgt_fld5 = n_tgt_fld5;
        }

        public String getN_tgt_fld6() {
            return n_tgt_fld6;
        }

        public void setN_tgt_fld6(String n_tgt_fld6) {
            this.n_tgt_fld6 = n_tgt_fld6;
        }

        public String getN_tgt_fld7() {
            return n_tgt_fld7;
        }

        public void setN_tgt_fld7(String n_tgt_fld7) {
            this.n_tgt_fld7 = n_tgt_fld7;
        }

        public String getN_tgt_fld8() {
            return n_tgt_fld8;
        }

        public void setN_tgt_fld8(String n_tgt_fld8) {
            this.n_tgt_fld8 = n_tgt_fld8;
        }

        public String getPay_amount() {
            return pay_amount;
        }

        public void setPay_amount(String pay_amount) {
            this.pay_amount = pay_amount;
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

        public String getStart_end_time() {
            return start_end_time;
        }

        public void setStart_end_time(String start_end_time) {
            this.start_end_time = start_end_time;
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

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getPay_way() {
            return pay_way;
        }

        public void setPay_way(String pay_way) {
            this.pay_way = pay_way;
        }

        public int getPay_status() {
            return pay_status;
        }

        public void setPay_status(int pay_status) {
            this.pay_status = pay_status;
        }

        public String getService_time() {
            return service_time;
        }

        public void setService_time(String service_time) {
            this.service_time = service_time;
        }

        public String getCooperative() {
            return cooperative;
        }

        public void setCooperative(String cooperative) {
            this.cooperative = cooperative;
        }

        public String getMechanism() {
            return mechanism;
        }

        public void setMechanism(String mechanism) {
            this.mechanism = mechanism;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public SignedBean getSigned() {
            return signed;
        }

        public void setSigned(SignedBean signed) {
            this.signed = signed;
        }

        public String getPay_date_time() {
            return pay_date_time;
        }

        public void setPay_date_time(String pay_date_time) {
            this.pay_date_time = pay_date_time;
        }

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
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

        public static class SignedBean {
            /**
             * status : 1
             * message : 已签名
             * sign_url : /images/sign/20180613/1528882359bb9db2b0-dcaf-3072-94a9-934a2ffd9ffb.
             */

            private int status;
            private String message;
            private String sign_url;

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

            public String getSign_url() {
                return sign_url;
            }

            public void setSign_url(String sign_url) {
                this.sign_url = sign_url;
            }
        }
    }
}
