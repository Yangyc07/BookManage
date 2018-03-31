package com.yang.service;

import com.yang.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private AdminDao adminDao;

    public boolean hasMatchUser(int admin_id, String password) {
        int matchCount = adminDao.getMatchCount(admin_id, password);
        return matchCount > 0;
    }

    public boolean rePassword(int admin_id , String password){
        return adminDao.rePassword(admin_id , password)>0;
    }

    @Autowired
    public void setUserDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }
}
