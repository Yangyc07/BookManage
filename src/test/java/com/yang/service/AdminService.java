package com.yang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.*;

import static org.testng.Assert.*;
@ContextConfiguration("classpath*:/yang-context.xml")
public class AdminService extends AbstractTransactionalTestNGSpringContextTests {
    @Autowired
    private LoginService loginService;

    @Test
    public void testAdminLogin() {
        boolean b1 = loginService.hasMatchUser(20170001,"111111");
        System.out.print(b1);
        assertTrue(b1);
    }
}
