package com.lianghuawang.cottonfarmer.activity.my.bankcard;

/**
 * Created by a on 2018/4/12.
 */

class Card_Bean {
    String name;
    String number_card;
    int card_icon;

    public Card_Bean(String name, String number_card, int card_icon) {
        this.name = name;
        this.number_card = number_card;
        this.card_icon = card_icon;
    }

    public Card_Bean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber_card() {
        return number_card;
    }

    public void setNumber_card(String number_card) {
        this.number_card = number_card;
    }

    public int getCard_icon() {
        return card_icon;
    }

    public void setCard_icon(int card_icon) {
        this.card_icon = card_icon;
    }
}
