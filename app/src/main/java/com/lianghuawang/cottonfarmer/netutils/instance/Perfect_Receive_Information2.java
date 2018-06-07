package com.lianghuawang.cottonfarmer.netutils.instance;

import java.util.List;

/**
 * 接收------完善信息接口
 */
public class Perfect_Receive_Information2 {


    /**
     * success : true
     * code : 200
     * message : OK
     * data : {"id":60,"username":"范文轲","mobile_phone":"18539458912","email":null,"gender":"男","nation":"汉族","residence":null,"id_code":"412727199308122715","birthday":null,"contact_phone":"18539458912","emergency_name":null,"emergency_phone":null,"expire_at":1528187283,"logged_at":null,"avatar":"/images/avatar/1528121038764b5690-1afb-344e-b83f-16156604f66d.jpg","address":"北京","status":10,"crop_name":"棉花","plant_area":"新疆吐鲁番吐鲁番市葡萄乡沙坎村","plot_number":1,"cotton_area":20,"other_area":null,"land_num":null,"vulgo":null,"bank_card":null,"postcode":"100000","id_positive":null,"id_reverse":null,"is_identity":0,"three_loan":null,"three_insurance":null,"created_at":"2018-06-01 17:09:03","allowance":999,"allowance_updated_at":1528338274,"plant_info":[{"id":40,"vulgo":"宝地1号","longitude":"125.2145","latitude":"40.2586","land_num":"007","area_type":1,"division":"6269901","group":"626990101","even":"62699010101","province":null,"city":null,"county":null},{"id":41,"vulgo":"宝地2号","longitude":"125.2145","latitude":"40.2586","land_num":"008","area_type":1,"division":"6269901","group":"626990101","even":"62699010101","province":null,"city":null,"county":null},{"id":42,"vulgo":"过节","longitude":"123","latitude":"45","land_num":"007","area_type":1,"division":"6269901","group":"626990101","even":"6269901010101","province":null,"city":null,"county":null},{"id":46,"vulgo":"无名用","longitude":"140","latitude":"35","land_num":"7","area_type":2,"division":null,"group":null,"even":null,"province":"6266521","city":"626652101","county":"62665210102"}],"average":700,"step":3,"hand_img":null,"area_code":{"area_type":2,"division":"6266521","group":"626652101","even":"62665210102","township":"6266521010203","village":"0","plant_area":"新疆吐鲁番吐鲁番市葡萄乡沙坎村"}}
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
         * id : 60
         * username : 范文轲
         * mobile_phone : 18539458912
         * email : null
         * gender : 男
         * nation : 汉族
         * residence : null
         * id_code : 412727199308122715
         * birthday : null
         * contact_phone : 18539458912
         * emergency_name : null
         * emergency_phone : null
         * expire_at : 1528187283
         * logged_at : null
         * avatar : /images/avatar/1528121038764b5690-1afb-344e-b83f-16156604f66d.jpg
         * address : 北京
         * status : 10
         * crop_name : 棉花
         * plant_area : 新疆吐鲁番吐鲁番市葡萄乡沙坎村
         * plot_number : 1
         * cotton_area : 20
         * other_area : null
         * land_num : null
         * vulgo : null
         * bank_card : null
         * postcode : 100000
         * id_positive : null
         * id_reverse : null
         * is_identity : 0
         * three_loan : null
         * three_insurance : null
         * created_at : 2018-06-01 17:09:03
         * allowance : 999
         * allowance_updated_at : 1528338274
         * plant_info : [{"id":40,"vulgo":"宝地1号","longitude":"125.2145","latitude":"40.2586","land_num":"007","area_type":1,"division":"6269901","group":"626990101","even":"62699010101","province":null,"city":null,"county":null},{"id":41,"vulgo":"宝地2号","longitude":"125.2145","latitude":"40.2586","land_num":"008","area_type":1,"division":"6269901","group":"626990101","even":"62699010101","province":null,"city":null,"county":null},{"id":42,"vulgo":"过节","longitude":"123","latitude":"45","land_num":"007","area_type":1,"division":"6269901","group":"626990101","even":"6269901010101","province":null,"city":null,"county":null},{"id":46,"vulgo":"无名用","longitude":"140","latitude":"35","land_num":"7","area_type":2,"division":null,"group":null,"even":null,"province":"6266521","city":"626652101","county":"62665210102"}]
         * average : 700
         * step : 3
         * hand_img : null
         * area_code : {"area_type":2,"division":"6266521","group":"626652101","even":"62665210102","township":"6266521010203","village":"0","plant_area":"新疆吐鲁番吐鲁番市葡萄乡沙坎村"}
         */

        private int id;
        private String username;
        private String mobile_phone;
        private Object email;
        private String gender;
        private String nation;
        private Object residence;
        private String id_code;
        private Object birthday;
        private String contact_phone;
        private Object emergency_name;
        private Object emergency_phone;
        private int expire_at;
        private Object logged_at;
        private String avatar;
        private String address;
        private int status;
        private String crop_name;
        private String plant_area;
        private int plot_number;
        private int cotton_area;
        private Object other_area;
        private Object land_num;
        private Object vulgo;
        private Object bank_card;
        private String postcode;
        private Object id_positive;
        private Object id_reverse;
        private int is_identity;
        private Object three_loan;
        private Object three_insurance;
        private String created_at;
        private int allowance;
        private int allowance_updated_at;
        private int average;
        private int step;
        private Object hand_img;
        private AreaCodeBean area_code;
        private List<PlantInfoBean> plant_info;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getMobile_phone() {
            return mobile_phone;
        }

        public void setMobile_phone(String mobile_phone) {
            this.mobile_phone = mobile_phone;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getNation() {
            return nation;
        }

        public void setNation(String nation) {
            this.nation = nation;
        }

        public Object getResidence() {
            return residence;
        }

        public void setResidence(Object residence) {
            this.residence = residence;
        }

        public String getId_code() {
            return id_code;
        }

        public void setId_code(String id_code) {
            this.id_code = id_code;
        }

        public Object getBirthday() {
            return birthday;
        }

        public void setBirthday(Object birthday) {
            this.birthday = birthday;
        }

        public String getContact_phone() {
            return contact_phone;
        }

        public void setContact_phone(String contact_phone) {
            this.contact_phone = contact_phone;
        }

        public Object getEmergency_name() {
            return emergency_name;
        }

        public void setEmergency_name(Object emergency_name) {
            this.emergency_name = emergency_name;
        }

        public Object getEmergency_phone() {
            return emergency_phone;
        }

        public void setEmergency_phone(Object emergency_phone) {
            this.emergency_phone = emergency_phone;
        }

        public int getExpire_at() {
            return expire_at;
        }

        public void setExpire_at(int expire_at) {
            this.expire_at = expire_at;
        }

        public Object getLogged_at() {
            return logged_at;
        }

        public void setLogged_at(Object logged_at) {
            this.logged_at = logged_at;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getCrop_name() {
            return crop_name;
        }

        public void setCrop_name(String crop_name) {
            this.crop_name = crop_name;
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

        public int getCotton_area() {
            return cotton_area;
        }

        public void setCotton_area(int cotton_area) {
            this.cotton_area = cotton_area;
        }

        public Object getOther_area() {
            return other_area;
        }

        public void setOther_area(Object other_area) {
            this.other_area = other_area;
        }

        public Object getLand_num() {
            return land_num;
        }

        public void setLand_num(Object land_num) {
            this.land_num = land_num;
        }

        public Object getVulgo() {
            return vulgo;
        }

        public void setVulgo(Object vulgo) {
            this.vulgo = vulgo;
        }

        public Object getBank_card() {
            return bank_card;
        }

        public void setBank_card(Object bank_card) {
            this.bank_card = bank_card;
        }

        public String getPostcode() {
            return postcode;
        }

        public void setPostcode(String postcode) {
            this.postcode = postcode;
        }

        public Object getId_positive() {
            return id_positive;
        }

        public void setId_positive(Object id_positive) {
            this.id_positive = id_positive;
        }

        public Object getId_reverse() {
            return id_reverse;
        }

        public void setId_reverse(Object id_reverse) {
            this.id_reverse = id_reverse;
        }

        public int getIs_identity() {
            return is_identity;
        }

        public void setIs_identity(int is_identity) {
            this.is_identity = is_identity;
        }

        public Object getThree_loan() {
            return three_loan;
        }

        public void setThree_loan(Object three_loan) {
            this.three_loan = three_loan;
        }

        public Object getThree_insurance() {
            return three_insurance;
        }

        public void setThree_insurance(Object three_insurance) {
            this.three_insurance = three_insurance;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public int getAllowance() {
            return allowance;
        }

        public void setAllowance(int allowance) {
            this.allowance = allowance;
        }

        public int getAllowance_updated_at() {
            return allowance_updated_at;
        }

        public void setAllowance_updated_at(int allowance_updated_at) {
            this.allowance_updated_at = allowance_updated_at;
        }

        public int getAverage() {
            return average;
        }

        public void setAverage(int average) {
            this.average = average;
        }

        public int getStep() {
            return step;
        }

        public void setStep(int step) {
            this.step = step;
        }

        public Object getHand_img() {
            return hand_img;
        }

        public void setHand_img(Object hand_img) {
            this.hand_img = hand_img;
        }

        public AreaCodeBean getArea_code() {
            return area_code;
        }

        public void setArea_code(AreaCodeBean area_code) {
            this.area_code = area_code;
        }

        public List<PlantInfoBean> getPlant_info() {
            return plant_info;
        }

        public void setPlant_info(List<PlantInfoBean> plant_info) {
            this.plant_info = plant_info;
        }

        public static class AreaCodeBean {
            /**
             * area_type : 2
             * division : 6266521
             * group : 626652101
             * even : 62665210102
             * township : 6266521010203
             * village : 0
             * plant_area : 新疆吐鲁番吐鲁番市葡萄乡沙坎村
             */

            private int area_type;
            private String division;
            private String group;
            private String even;
            private String township;
            private String village;
            private String plant_area;

            public int getArea_type() {
                return area_type;
            }

            public void setArea_type(int area_type) {
                this.area_type = area_type;
            }

            public String getDivision() {
                return division;
            }

            public void setDivision(String division) {
                this.division = division;
            }

            public String getGroup() {
                return group;
            }

            public void setGroup(String group) {
                this.group = group;
            }

            public String getEven() {
                return even;
            }

            public void setEven(String even) {
                this.even = even;
            }

            public String getTownship() {
                return township;
            }

            public void setTownship(String township) {
                this.township = township;
            }

            public String getVillage() {
                return village;
            }

            public void setVillage(String village) {
                this.village = village;
            }

            public String getPlant_area() {
                return plant_area;
            }

            public void setPlant_area(String plant_area) {
                this.plant_area = plant_area;
            }
        }

        public static class PlantInfoBean {
            /**
             * id : 40
             * vulgo : 宝地1号
             * longitude : 125.2145
             * latitude : 40.2586
             * land_num : 007
             * area_type : 1
             * division : 6269901
             * group : 626990101
             * even : 62699010101
             * province : null
             * city : null
             * county : null
             */

            private int id;
            private String vulgo;
            private String longitude;
            private String latitude;
            private String land_num;
            private int area_type;
            private String division;
            private String group;
            private String even;
            private Object province;
            private Object city;
            private Object county;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getVulgo() {
                return vulgo;
            }

            public void setVulgo(String vulgo) {
                this.vulgo = vulgo;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public String getLand_num() {
                return land_num;
            }

            public void setLand_num(String land_num) {
                this.land_num = land_num;
            }

            public int getArea_type() {
                return area_type;
            }

            public void setArea_type(int area_type) {
                this.area_type = area_type;
            }

            public String getDivision() {
                return division;
            }

            public void setDivision(String division) {
                this.division = division;
            }

            public String getGroup() {
                return group;
            }

            public void setGroup(String group) {
                this.group = group;
            }

            public String getEven() {
                return even;
            }

            public void setEven(String even) {
                this.even = even;
            }

            public Object getProvince() {
                return province;
            }

            public void setProvince(Object province) {
                this.province = province;
            }

            public Object getCity() {
                return city;
            }

            public void setCity(Object city) {
                this.city = city;
            }

            public Object getCounty() {
                return county;
            }

            public void setCounty(Object county) {
                this.county = county;
            }
        }
    }
}
