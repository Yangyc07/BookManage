package com.yang.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class AdminDao {
    private JdbcTemplate jdbcTemplate;

    private final static  String MATCH_COUNT_SQL= "SELECT COUNT(*) FROM admin where" +
            " admin_id = ? and password = ? ";
    private final static String RE_PASSWORD_SQL="UPDATE admin set password = ? where admin_id = ? ";

    //查询登陆信息;
    public int getMatchCount(int admin_id, String password) {
        return jdbcTemplate.queryForObject(MATCH_COUNT_SQL, new Object[]{admin_id, password}, Integer.class);
    }
    //修改管理员的密码
    public  int rePassword(int admin_id, String password){
        return jdbcTemplate.queryForObject(RE_PASSWORD_SQL, new Object[]{admin_id, password}, Integer.class);
    }
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
