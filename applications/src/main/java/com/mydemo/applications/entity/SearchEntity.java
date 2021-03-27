package com.mydemo.applications.entity;

import java.io.Serializable;

public class SearchEntity implements Serializable {
   private  Integer type1;
   private Integer type2;
   private Integer type3;
   private String title;

    public SearchEntity() {
    }

    public SearchEntity(Integer type1, Integer type2, Integer type3, String title) {
        this.type1 = type1;
        this.type2 = type2;
        this.type3 = type3;
        this.title = title;
    }

    public Integer getType1() {
        return type1;
    }

    public void setType1(Integer type1) {
        this.type1 = type1;
    }

    public Integer getType2() {
        return type2;
    }

    public void setType2(Integer type2) {
        this.type2 = type2;
    }

    public Integer getType3() {
        return type3;
    }

    public void setType3(Integer type3) {
        this.type3 = type3;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "SearchEntity{" +
                "type1=" + type1 +
                ", type2=" + type2 +
                ", type3=" + type3 +
                ", title='" + title + '\'' +
                '}';
    }
}
