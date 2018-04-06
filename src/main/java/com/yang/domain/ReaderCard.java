package com.yang.domain;

//图书卡的信息
public class ReaderCard {
    private long readerId;//读者id
    private String name;//姓名
    private String password;//密码
    private int cardState;//读者级别

    public long getReader_id() {
        return readerId;
    }

    public void setReader_id(long reader_id) {
        this.readerId = reader_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCardState() {
        return cardState;
    }

    public void setCardState(int carState) {
        this.cardState = carState;
    }
}
