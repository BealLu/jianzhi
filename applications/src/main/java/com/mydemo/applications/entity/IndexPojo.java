package com.mydemo.applications.entity;

import java.io.Serializable;

public class IndexPojo implements Serializable {
    private String username;
    private Integer posiId;
    private String pic;
    private String posiName;
    private Integer userId;

    public IndexPojo() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public IndexPojo(String username, Integer posiId, String pic, String posiName, Integer userId) {
        this.username = username;
        this.posiId = posiId;
        this.pic = pic;
        this.posiName = posiName;
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPosiId() {
        return posiId;
    }

    public void setPosiId(Integer posiId) {
        this.posiId = posiId;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPosiName() {
        return posiName;
    }

    public void setPosiName(String posiName) {
        this.posiName = posiName;
    }

    @Override
    public String toString() {
        return "IndexPojo{" +
                "username='" + username + '\'' +
                ", posiId=" + posiId +
                ", pic='" + pic + '\'' +
                ", posiName='" + posiName + '\'' +
                ", userId=" + userId +
                '}';
    }
}
