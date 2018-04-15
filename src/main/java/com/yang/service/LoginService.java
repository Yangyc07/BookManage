package com.yang.service;

import com.yang.dao.AdminDao;
import com.yang.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private AdminDao adminDao;

    public boolean hasMatchAdmin(int admin_id, String password) {
        int matchCount = adminDao.getMatchCount(admin_id, password);
        return matchCount > 0;
    }

    public boolean rePassword(int admin_id, String password) {
        return adminDao.rePassword(admin_id, password) > 0;
    }

    @Autowired
    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }
}
