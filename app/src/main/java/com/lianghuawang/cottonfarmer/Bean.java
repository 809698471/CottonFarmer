package com.lianghuawang.cottonfarmer;

/**
 * Created by a on 2018/4/8.
 */

public class Bean {
    String name;
    int image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Bean(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public Bean() {
    }
}
