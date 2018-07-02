package com.lianghuawang.cottonfarmer.entity.home.news;

import java.util.List;

public class News {

    /**
     * success : true
     * code : 200
     * message : OK
     * data : [{"id":5,"title":"【独家指导】他们做了什么，让受灾棉田\u201c转危为安\u201d？","img_url":"/images/news/15283412430ff368b9-e602-3820-a255-77208c196320.jpg","news_type":1,"created_at":"2018-06-01 20:51:50","updated_at":"2018-06-14 10:39:56"},{"id":6,"title":"【棉田救灾】棉苗被刮死了一半，现在补种还来得及吗？","img_url":"/images/news/15289417403ae9f6c5-2a4b-3215-81b4-55094e43ad1a.jpg","news_type":1,"created_at":"2018-06-01 21:24:19","updated_at":"2018-06-15 10:10:41"},{"id":9,"title":"【补贴政策】一亩棉花补贴多少钱？2018年棉花补贴政策及发放时间","img_url":"/images/news/152894184091a1d953-ba82-368c-b1ae-2f3b6cd30091.jpg","news_type":1,"created_at":"2018-06-02 12:01:11","updated_at":"2018-06-14 10:04:03"},{"id":10,"title":"【政策解读】农村养老保险每月可以领多少钱？2018年农村养老保险最新政策解读","img_url":"/images/news/152894193337878d50-4af2-341e-b6e1-9125a52f9a96.jpg","news_type":1,"created_at":"2018-06-02 12:06:47","updated_at":"2018-06-14 10:05:35"},{"id":11,"title":"【最新政策】农村土地退出补偿多少钱一亩？2018年农村土地有偿退出新政策","img_url":"/images/news/1528942010ba3abb62-c9e6-3ac5-9a8d-c26d1c990e92.jpg","news_type":1,"created_at":"2018-06-02 13:40:54","updated_at":"2018-06-14 10:06:52"},{"id":12,"title":"【农机补贴】2018年农村购买哪些农用机械有补贴？","img_url":"/images/news/15279186085e690a42-bcab-308f-9d6e-bb45ec26098d.jpg","news_type":1,"created_at":"2018-06-02 13:50:10","updated_at":"2018-06-14 10:08:51"}]
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
         * id : 5
         * title : 【独家指导】他们做了什么，让受灾棉田“转危为安”？
         * img_url : /images/news/15283412430ff368b9-e602-3820-a255-77208c196320.jpg
         * news_type : 1
         * created_at : 2018-06-01 20:51:50
         * updated_at : 2018-06-14 10:39:56
         */

        private int id;
        private String title;
        private String img_url;
        private int news_type;
        private String created_at;
        private String updated_at;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImg_url() {
            return img_url;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }

        public int getNews_type() {
            return news_type;
        }

        public void setNews_type(int news_type) {
            this.news_type = news_type;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }
    }
}
