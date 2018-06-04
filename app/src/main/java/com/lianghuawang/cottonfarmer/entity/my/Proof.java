package com.lianghuawang.cottonfarmer.entity.my;

public class Proof {

    private int id;
    private int resourcesId;//资源ID
    private String path;//图片地址
    private String url;
    private int is_real;
    private boolean upload;//是否上传

    public int getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(int resourcesId) {
        this.resourcesId = resourcesId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isUpload() {
        return upload;
    }

    public void setUpload(boolean upload) {
        this.upload = upload;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getIs_real() {
        return is_real;
    }

    public void setIs_real(int is_real) {
        this.is_real = is_real;
    }
}
