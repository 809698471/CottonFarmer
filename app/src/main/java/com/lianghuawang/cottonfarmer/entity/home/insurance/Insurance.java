package com.lianghuawang.cottonfarmer.entity.home.insurance;

public final class Insurance {
    /**
     * 商品编号:id
     * 图片url:photopath
     * 标题:title
     * 说明内容:content
     * 有效期:validity
     */
    private int id;
    private String photoPath;
    private String title;
    private String content;
    private String validity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
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

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "id=" + id +
                ", photoPath='" + photoPath + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", validity='" + validity + '\'' +
                '}';
    }
}
