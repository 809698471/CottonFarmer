package com.lianghuawang.cottonfarmer.entity.my;

import java.util.List;

public class CardList {

    /**
     * success : true
     * code : 200
     * message : OK
     * data : [{"bank":"GDB","bank_card":"6214623750000229755","bankName":"广东发展银行","bankImg":"https://apimg.alipay.com/combo.png?d=cashier&t=GDB","cardType":"DC","cardTypeName":"储蓄卡","is_use":1,"username":null},{"bank":"CITIC","bank_card":"6217710704599356","bankName":"中信银行","bankImg":"https://apimg.alipay.com/combo.png?d=cashier&t=CITIC","cardType":"DC","cardTypeName":"储蓄卡","is_use":0,"username":null},{"bank":"CITIC","bank_card":"6229180030801841","bankName":"中信银行","bankImg":"https://apimg.alipay.com/combo.png?d=cashier&t=CITIC","cardType":"CC","cardTypeName":"信用卡","is_use":0,"username":null}]
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
         * bank : GDB
         * bank_card : 6214623750000229755
         * bankName : 广东发展银行
         * bankImg : https://apimg.alipay.com/combo.png?d=cashier&t=GDB
         * cardType : DC
         * cardTypeName : 储蓄卡
         * is_use : 1
         * username : null
         */

        private String bank;
        private String bank_card;
        private String bankName;
        private String bankImg;
        private String cardType;
        private String cardTypeName;
        private int is_use;
        private Object username;

        public String getBank() {
            return bank;
        }

        public void setBank(String bank) {
            this.bank = bank;
        }

        public String getBank_card() {
            return bank_card;
        }

        public void setBank_card(String bank_card) {
            this.bank_card = bank_card;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public String getBankImg() {
            return bankImg;
        }

        public void setBankImg(String bankImg) {
            this.bankImg = bankImg;
        }

        public String getCardType() {
            return cardType;
        }

        public void setCardType(String cardType) {
            this.cardType = cardType;
        }

        public String getCardTypeName() {
            return cardTypeName;
        }

        public void setCardTypeName(String cardTypeName) {
            this.cardTypeName = cardTypeName;
        }

        public int getIs_use() {
            return is_use;
        }

        public void setIs_use(int is_use) {
            this.is_use = is_use;
        }

        public Object getUsername() {
            return username;
        }

        public void setUsername(Object username) {
            this.username = username;
        }
    }
}
