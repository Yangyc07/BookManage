package com.yang.web;

import com.yang.domain.Admin;
import com.yang.domain.ReaderCard;
import com.yang.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Controller
public class LoginController {
    private LoginService loginService;


    @RequestMapping(value = "/index.html")
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request) {
        //int id=Integer.valueOf(request.getParameter("id"));
        int id=20170001;
        String password=request.getParameter("password");
        System.out.print(password);
        boolean isValidUser = loginService.hasMatchAdmin(id,password);
        if (!isValidUser) {
            return new ModelAndView("login", "error", "用户名或密码错误。");
        } else {
            Admin admin = new Admin();
            admin.setAdminId(id);
            admin.setPassword(password);
            request.getSession().setAttribute("admin", admin);
            return new ModelAndView("admin_manage");
        }
    }
    @Autowired
    public void setUserService(LoginService loginService) {
        this.loginService = loginService;
    }
}

