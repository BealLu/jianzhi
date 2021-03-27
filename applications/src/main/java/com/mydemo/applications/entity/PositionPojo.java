package com.mydemo.applications.entity;

import java.io.Serializable;

public class PositionPojo implements Serializable {
    private Integer id;
    private String title;
    private Integer type1;
    private Integer type2;
    private Integer type3;
    private Integer descFk;
    private String salar;
    private String userId;
    private String desc;
    private String demand;
    private String address;
    private String phone;

    public PositionPojo(Integer id,String title, Integer type1, Integer type2, Integer type3, Integer descFk, String salar, String userId, String desc, String demand, String address, String phone) {
        this.id=id;
        this.title = title;
        this.type1 = type1;
        this.type2 = type2;
        this.type3 = type3;
        this.descFk = descFk;
        this.salar = salar;
        this.userId = userId;
        this.desc = desc;
        this.demand = demand;
        this.address = address;
        this.phone = phone;
    }

    public PositionPojo() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
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

    public Integer getDescFk() {
        return descFk;
    }

    public void setDescFk(Integer descFk) {
        this.descFk = descFk;
    }

    public String getSalar() {
        return salar;
    }

    public void setSalar(String salar) {
        this.salar = salar;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PositionPojo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type1=" + type1 +
                ", type2=" + type2 +
                ", type3=" + type3 +
                ", descFk=" + descFk +
                ", salar='" + salar + '\'' +
                ", userId='" + userId + '\'' +
                ", desc='" + desc + '\'' +
                ", demand='" + demand + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
