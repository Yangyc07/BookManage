package com.yang.web;

import com.yang.domain.ReaderInfo;
import com.yang.service.LoginService;
import com.yang.service.ReaderCardService;
import com.yang.service.ReaderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class ReaderController {
    private ReaderInfoService readerInfoService;

    @Autowired
    public void setReaderInfoService(ReaderInfoService readerInfoService) {
        this.readerInfoService = readerInfoService;
    }

    private LoginService loginService;
    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    private ReaderCardService readerCardService;
    @Autowired
    public void setReaderCardService(ReaderCardService readerCardService) {
        this.readerCardService = readerCardService;
    }

    @RequestMapping("admin_all_reader.html")
    public ModelAndView allReaders(){
        ArrayList<ReaderInfo> readers=readerInfoService.getAllReaders();
        ModelAndView modelAndView=new ModelAndView("admin_all_readers");
        modelAndView.addObject("readers",readers);
        return modelAndView;
    }

}
