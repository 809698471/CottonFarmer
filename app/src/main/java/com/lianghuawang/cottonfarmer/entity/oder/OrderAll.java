package com.lianghuawang.cottonfarmer.entity.oder;

import java.util.List;

public class OrderAll {


    /**
     * success : true
     * code : 200
     * message : OK
     * data : [{"id":7,"o_water":"CZPT2018061316470635400000","order_num":"CZPT20180615003178","user_id":60,"user_type":"1","cooperative_id":"1","product_id":"D1528860397","plant_area":"新疆兵团农一师一团一连","plot_number":1,"land_num":"007","vulgo":"宝地1号","cotton_area":200,"additional":null,"num":null,"status":1,"premium":"13200","pay_amount":"13200","pay_status":1,"created_at":1528879651,"updated_at":1529026383,"effective_time":null,"expire_time":null,"signed":"/images/sign/20180613/152887976842651361-786a-3ff6-85d5-31a6f8ff394c.","c_ply_no":null,"EKEY_PLYSEQ_NO":"CZPT20180613008406","C_PLY_APP_NO_HX":null,"mechanism_code":"65430601","product_number":"1668","pay_way":1,"shi":"6269901","tuan":"626990101","lian":"6269901010101","cun":null,"region":1},{"id":10,"o_water":"CZPT2018061317320613450000","order_num":"CZPT20180615007059","user_id":60,"user_type":"1","cooperative_id":"1","product_id":"D1528859637","plant_area":"新疆地方乌鲁木齐乌鲁木齐县","plot_number":1,"land_num":"007","vulgo":"宝地1号","cotton_area":1000000,"additional":null,"num":null,"status":1,"premium":"70000000","pay_amount":"24500000","pay_status":1,"created_at":1528882353,"updated_at":1529026371,"effective_time":null,"expire_time":null,"signed":"/images/sign/20180613/1528882359bb9db2b0-dcaf-3072-94a9-934a2ffd9ffb.","c_ply_no":null,"EKEY_PLYSEQ_NO":"CZPT20180613004058","C_PLY_APP_NO_HX":null,"mechanism_code":"65920200","product_number":"1621","pay_way":1,"shi":"6269901","tuan":"626990101","lian":"6269901010101","cun":null,"region":1}]
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
         * id : 7
         * o_water : CZPT2018061316470635400000
         * order_num : CZPT20180615003178
         * user_id : 60
         * user_type : 1
         * cooperative_id : 1
         * product_id : D1528860397
         * plant_area : 新疆兵团农一师一团一连
         * plot_number : 1
         * land_num : 007
         * vulgo : 宝地1号
         * cotton_area : 200
         * additional : null
         * num : null
         * status : 1
         * premium : 13200
         * pay_amount : 13200
         * pay_status : 1
         * created_at : 1528879651
         * updated_at : 1529026383
         * effective_time : null
         * expire_time : null
         * signed : /images/sign/20180613/152887976842651361-786a-3ff6-85d5-31a6f8ff394c.
         * c_ply_no : null
         * EKEY_PLYSEQ_NO : CZPT20180613008406
         * C_PLY_APP_NO_HX : null
         * mechanism_code : 65430601
         * product_number : 1668
         * pay_way : 1
         * shi : 6269901
         * tuan : 626990101
         * lian : 6269901010101
         * cun : null
         * region : 1
         */

        private int id;
        private String o_water;
        private String order_num;
        private int user_id;
        private String user_type;
        private String cooperative_id;
        private String product_id;
        private String plant_area;
        private int plot_number;
        private String land_num;
        private String vulgo;
        private int cotton_area;
        private Object additional;
        private Object num;
        private int status;
        private String premium;
        private String pay_amount;
        private int pay_status;
        private int created_at;
        private int updated_at;
        private Object effective_time;
        private Object expire_time;
        private String signed;
        private Object c_ply_no;
        private String EKEY_PLYSEQ_NO;
        private Object C_PLY_APP_NO_HX;
        private String mechanism_code;
        private String product_number;
        private int pay_way;
        private String shi;
        private String tuan;
        private String lian;
        private Object cun;
        private int region;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getO_water() {
            return o_water;
        }

        public void setO_water(String o_water) {
            this.o_water = o_water;
        }

        public String getOrder_num() {
            return order_num;
        }

        public void setOrder_num(String order_num) {
            this.order_num = order_num;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getUser_type() {
            return user_type;
        }

        public void setUser_type(String user_type) {
            this.user_type = user_type;
        }

        public String getCooperative_id() {
            return cooperative_id;
        }

        public void setCooperative_id(String cooperative_id) {
            this.cooperative_id = cooperative_id;
        }

        public String getProduct_id() {
            return product_id;
        }

        public void setProduct_id(String product_id) {
            this.product_id = product_id;
        }

        public String getPlant_area() {
            return plant_area;
        }

        public void setPlant_area(String plant_area) {
            this.plant_area = plant_area;
        }

        public int getPlot_number() {
            return plot_number;
        }

        public void setPlot_number(int plot_number) {
            this.plot_number = plot_number;
        }

        public String getLand_num() {
            return land_num;
        }

        public void setLand_num(String land_num) {
            this.land_num = land_num;
        }

        public String getVulgo() {
            return vulgo;
        }

        public void setVulgo(String vulgo) {
            this.vulgo = vulgo;
        }

        public int getCotton_area() {
            return cotton_area;
        }

        public void setCotton_area(int cotton_area) {
            this.cotton_area = cotton_area;
        }

        public Object getAdditional() {
            return additional;
        }

        public void setAdditional(Object additional) {
            this.additional = additional;
        }

        public Object getNum() {
            return num;
        }

        public void setNum(Object num) {
            this.num = num;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getPremium() {
            return premium;
        }

        public void setPremium(String premium) {
            this.premium = premium;
        }

        public String getPay_amount() {
            return pay_amount;
        }

        public void setPay_amount(String pay_amount) {
            this.pay_amount = pay_amount;
        }

        public int getPay_status() {
            return pay_status;
        }

        public void setPay_status(int pay_status) {
            this.pay_status = pay_status;
        }

        public int getCreated_at() {
            return created_at;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }

        public int getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(int updated_at) {
            this.updated_at = updated_at;
        }

        public Object getEffective_time() {
            return effective_time;
        }

        public void setEffective_time(Object effective_time) {
            this.effective_time = effective_time;
        }

        public Object getExpire_time() {
            return expire_time;
        }

        public void setExpire_time(Object expire_time) {
            this.expire_time = expire_time;
        }

        public String getSigned() {
            return signed;
        }

        public void setSigned(String signed) {
            this.signed = signed;
        }

        public Object getC_ply_no() {
            return c_ply_no;
        }

        public void setC_ply_no(Object c_ply_no) {
            this.c_ply_no = c_ply_no;
        }

        public String getEKEY_PLYSEQ_NO() {
            return EKEY_PLYSEQ_NO;
        }

        public void setEKEY_PLYSEQ_NO(String EKEY_PLYSEQ_NO) {
            this.EKEY_PLYSEQ_NO = EKEY_PLYSEQ_NO;
        }

        public Object getC_PLY_APP_NO_HX() {
            return C_PLY_APP_NO_HX;
        }

        public void setC_PLY_APP_NO_HX(Object C_PLY_APP_NO_HX) {
            this.C_PLY_APP_NO_HX = C_PLY_APP_NO_HX;
        }

        public String getMechanism_code() {
            return mechanism_code;
        }

        public void setMechanism_code(String mechanism_code) {
            this.mechanism_code = mechanism_code;
        }

        public String getProduct_number() {
            return product_number;
        }

        public void setProduct_number(String product_number) {
            this.product_number = product_number;
        }

        public int getPay_way() {
            return pay_way;
        }

        public void setPay_way(int pay_way) {
            this.pay_way = pay_way;
        }

        public String getShi() {
            return shi;
        }

        public void setShi(String shi) {
            this.shi = shi;
        }

        public String getTuan() {
            return tuan;
        }

        public void setTuan(String tuan) {
            this.tuan = tuan;
        }

        public String getLian() {
            return lian;
        }

        public void setLian(String lian) {
            this.lian = lian;
        }

        public Object getCun() {
            return cun;
        }

        public void setCun(Object cun) {
            this.cun = cun;
        }

        public int getRegion() {
            return region;
        }

        public void setRegion(int region) {
            this.region = region;
        }
    }
}
