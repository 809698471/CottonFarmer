package com.lianghuawang.cottonfarmer.entity.home.insurance;

import com.lianghuawang.cottonfarmer.widget.linkage_menu.CityInterface;

import java.util.List;

public class FenJiGou {


    /**
     * success : true
     * code : 200
     * message : OK
     * data : [{"mechanism_code":"65920200","chinese_name":"中华联合财产保险股份有限公司一团支公司"},{"mechanism_code":"65920300","chinese_name":"中华联合财产保险股份有限公司二团支公司"},{"mechanism_code":"65920400","chinese_name":"中华联合财产保险股份有限公司三团支公司"},{"mechanism_code":"65920500","chinese_name":"中华联合财产保险股份有限公司四团支公司"},{"mechanism_code":"65920600","chinese_name":"中华联合财产保险股份有限公司五团支公司"},{"mechanism_code":"65920700","chinese_name":"中华联合财产保险股份有限公司六团支公司"},{"mechanism_code":"65920800","chinese_name":"中华联合财产保险股份有限公司七团支公司"},{"mechanism_code":"65922100","chinese_name":"中华联合财产保险股份有限公司幸福农场支公司"},{"mechanism_code":"65921900","chinese_name":"中华联合财产保险股份有限公司塔河种业支公司"},{"mechanism_code":"65921000","chinese_name":"中华联合财产保险股份有限公司十团支公司"},{"mechanism_code":"65921100","chinese_name":"中华联合财产保险股份有限公司十一团支公司"},{"mechanism_code":"65921200","chinese_name":"中华联合财产保险股份有限公司十二团支公司"},{"mechanism_code":"65921300","chinese_name":"中华联合财产保险股份有限公司十三团支公司"},{"mechanism_code":"65921400","chinese_name":"中华联合财产保险股份有限公司十四团支公司"},{"mechanism_code":"65921600","chinese_name":"中华联合财产保险股份有限公司十六团支公司"},{"mechanism_code":"65920900","chinese_name":"中华联合财产保险股份有限公司八团支公司"},{"mechanism_code":"65922000","chinese_name":"中华联合财产保险股份有限公司阿拉尔农场支公司"}]
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

    public static class DataBean implements CityInterface {
        /**
         * mechanism_code : 65920200
         * chinese_name : 中华联合财产保险股份有限公司一团支公司
         */

        private String mechanism_code;
        private String chinese_name;

        public String getMechanism_code() {
            return mechanism_code;
        }

        public void setMechanism_code(String mechanism_code) {
            this.mechanism_code = mechanism_code;
        }

        public String getChinese_name() {
            return chinese_name;
        }

        public void setChinese_name(String chinese_name) {
            this.chinese_name = chinese_name;
        }

        @Override
        public int getId() {
            return 0;
        }

        @Override
        public String getArea_code() {
            return getMechanism_code();
        }

        @Override
        public String getCityName() {
            return getChinese_name();
        }
    }
}
