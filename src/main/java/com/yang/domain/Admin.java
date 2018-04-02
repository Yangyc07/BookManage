package com.yang.domain;

//管理员信息
public class Admin {
    private int adminId;//账号
    private String password;//密码

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
