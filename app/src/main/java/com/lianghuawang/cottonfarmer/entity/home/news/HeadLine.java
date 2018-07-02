package com.lianghuawang.cottonfarmer.entity.home.news;

/**
 * 链花头条详情页面实体类
 * create 2018/06/29 范文轲
 */
public class HeadLine {


    /**
     * success : true
     * code : 200
     * message : OK
     * data : {"id":5,"title":"【独家指导】他们做了什么，让受灾棉田\u201c转危为安\u201d？","content":"<p>五月的天象孩子的脸说变就变，5月24日，一场突如其来的狂风暴雨，强对流冷空气向我团进攻，随后就是棉苗叶面受伤，树木断裂、棉田一片狼藉，经过我团采用以下救灾措施后，受灾棉田也慢慢恢复了生机：<\/p><p><img src=\"http://121.42.39.45:83/images/guest/b855bb99d3-1.jpg\"/><\/p><p>1及时排水<\/p><p>暴雨停后，对雨水较多的地块进行人工排水，以免造成棉田积水，地面板结，田间湿度大，影响棉花根系正常生长。对于树木断裂压倒棉花的树枝要及时清除，及时扶苗，也便于机车作业。<\/p><p><img src=\"http://121.42.39.45:83/images/guest/f8df7514ad-2.jpg\"/><\/p><p>2及时中耕<\/p><p>（一）灾后的棉苗小，抗性差、气温低、就会死苗、烂芽，此时中耕有疏松土壤，流通空气，提高地温。有利于根系下扎，促进棉苗健壮。<\/p><p>（二）灾后中耕有益于土壤微生物活动，加速土壤有机质的分解，提高土壤的有效养分，改善营养条件。同时还有调解水分，防旱、保墒，促进棉花生长。中耕松土以后，破除土壤板结。促进棉花稳健生长。<\/p><p>（三）灾后中耕有防止土壤水分蒸发，达到蓄水保墒的作用，有时在滴水过量时，中耕松土又可以是土壤中的水分蒸发，促使棉花良好生长。同时中耕有防除杂草，棉花大行较宽，容易长草，在中耕过程中可以彻底清除大行杂草，有利于促进棉花生长。<\/p><p><img src=\"http://121.42.39.45:83/images/guest/79ba3cd269-3.jpg\"/><\/p><p>3及时喷施液面肥<\/p><p>6叶期棉苗受灾大部分是枝、叶受损，此时喷施一些叶面肥，如：赤霉素、细胞分裂素、云台素内脂等促进植物生长的调解剂及时喷施，待长出枝叶后在加强叶面喷施;对于受害较轻，枝叶受伤面积小的棉田，可以化学调控和叶面喷施同时进行。是受伤的叶片及时补充营养，恢复叶片原有的光和作用，促进棉花健壮生长。<\/p><p>4及时田间追肥<\/p><p>受灾的棉苗恢复生长需肥量大，趁灾后地湿，及时抢施一次速效氮肥和钾肥，时间越早越好，趁墒抢施。可以改善棉花的营养状况，尽快促进根系恢复正常生长，促新枝新叶后期生长发育，以弥补灾后损失，可结合中耕进行，中耕一般尿素8公斤、磷5公斤、油饼7公斤、追施。使灾后棉花快速恢复正常生长。<\/p><p>棉农朋友们，灾害不怕，但在灾害面前我们要采取及时、果断、准确地补救措施，是我们降低损失的唯一办法。<\/p><p><img src=\"http://121.42.39.45:83/images/guest/679ddd3469-4.jpg\"/><\/p><p><br/><\/p>","img_url":"/images/news/15283412430ff368b9-e602-3820-a255-77208c196320.jpg","author":"小棉袄","news_type":1,"created_at":"2018-06-01 20:51:50","updated_at":"2018-06-14 10:39:56"}
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
         * id : 5
         * title : 【独家指导】他们做了什么，让受灾棉田“转危为安”？
         * content : <p>五月的天象孩子的脸说变就变，5月24日，一场突如其来的狂风暴雨，强对流冷空气向我团进攻，随后就是棉苗叶面受伤，树木断裂、棉田一片狼藉，经过我团采用以下救灾措施后，受灾棉田也慢慢恢复了生机：</p><p><img src="http://121.42.39.45:83/images/guest/b855bb99d3-1.jpg"/></p><p>1及时排水</p><p>暴雨停后，对雨水较多的地块进行人工排水，以免造成棉田积水，地面板结，田间湿度大，影响棉花根系正常生长。对于树木断裂压倒棉花的树枝要及时清除，及时扶苗，也便于机车作业。</p><p><img src="http://121.42.39.45:83/images/guest/f8df7514ad-2.jpg"/></p><p>2及时中耕</p><p>（一）灾后的棉苗小，抗性差、气温低、就会死苗、烂芽，此时中耕有疏松土壤，流通空气，提高地温。有利于根系下扎，促进棉苗健壮。</p><p>（二）灾后中耕有益于土壤微生物活动，加速土壤有机质的分解，提高土壤的有效养分，改善营养条件。同时还有调解水分，防旱、保墒，促进棉花生长。中耕松土以后，破除土壤板结。促进棉花稳健生长。</p><p>（三）灾后中耕有防止土壤水分蒸发，达到蓄水保墒的作用，有时在滴水过量时，中耕松土又可以是土壤中的水分蒸发，促使棉花良好生长。同时中耕有防除杂草，棉花大行较宽，容易长草，在中耕过程中可以彻底清除大行杂草，有利于促进棉花生长。</p><p><img src="http://121.42.39.45:83/images/guest/79ba3cd269-3.jpg"/></p><p>3及时喷施液面肥</p><p>6叶期棉苗受灾大部分是枝、叶受损，此时喷施一些叶面肥，如：赤霉素、细胞分裂素、云台素内脂等促进植物生长的调解剂及时喷施，待长出枝叶后在加强叶面喷施;对于受害较轻，枝叶受伤面积小的棉田，可以化学调控和叶面喷施同时进行。是受伤的叶片及时补充营养，恢复叶片原有的光和作用，促进棉花健壮生长。</p><p>4及时田间追肥</p><p>受灾的棉苗恢复生长需肥量大，趁灾后地湿，及时抢施一次速效氮肥和钾肥，时间越早越好，趁墒抢施。可以改善棉花的营养状况，尽快促进根系恢复正常生长，促新枝新叶后期生长发育，以弥补灾后损失，可结合中耕进行，中耕一般尿素8公斤、磷5公斤、油饼7公斤、追施。使灾后棉花快速恢复正常生长。</p><p>棉农朋友们，灾害不怕，但在灾害面前我们要采取及时、果断、准确地补救措施，是我们降低损失的唯一办法。</p><p><img src="http://121.42.39.45:83/images/guest/679ddd3469-4.jpg"/></p><p><br/></p>
         * img_url : /images/news/15283412430ff368b9-e602-3820-a255-77208c196320.jpg
         * author : 小棉袄
         * news_type : 1
         * created_at : 2018-06-01 20:51:50
         * updated_at : 2018-06-14 10:39:56
         */

        private int id;
        private String title;
        private String content;
        private String img_url;
        private String author;
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

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getImg_url() {
            return img_url;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
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
