package com.yang.domain;

import java.util.Date;

//读者信息
public class ReaderInfo {
    private int readerId;//读者号
    private String name;//读者姓名
    private String sex;//性别
    private Date birth;//生日
    private String address;//地址
    private String telcode;//电话

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelcode() {
        return telcode;
    }

    public void setTelcode(String telcode) {
        this.telcode = telcode;
    }
}
