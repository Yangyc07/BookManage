package com.yang.domain;

//管理员信息
public class Admin {
    private int adminId;//账号
    private int password;//密码

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
