package com.yang.web;

import com.yang.domain.ReaderInfo;
import com.yang.service.LoginService;
import com.yang.service.ReaderCardService;
import com.yang.service.ReaderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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


    @RequestMapping("admin_add_reader.html")
    public ModelAndView addReader(){
        return new ModelAndView("admin_add_reader");
    }

   @RequestMapping("do_add_reader.html")
   public String readerInfoAddDo(int readerId,String name,String sex,String birth,String address,String telCode,RedirectAttributes redirectAttributes){
       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
       Date nbirth=new Date();
       try{
           java.util.Date date=sdf.parse(birth);
           nbirth=date;
       }catch (ParseException e){
           e.printStackTrace();
       }
       ReaderInfo readerInfo=new ReaderInfo();
       readerInfo.setAddress(address);
       readerInfo.setBirth(nbirth);
       readerInfo.setName(name);
       readerInfo.setReaderId(readerId);
       readerInfo.setTelcode(telCode);
       readerInfo.setSex(sex);
       boolean b1=readerInfoService.addReaderInfo(readerInfo);
       boolean b2=readerCardService.addReaderCard(readerInfo);
       ArrayList<ReaderInfo> readers=readerInfoService.getAllReaders();
       if (b1&&b2){
           redirectAttributes.addFlashAttribute("b2", "读者信息添加成功！");
           return "redirect:/admin_all_reader.html";
       }else {
           redirectAttributes.addFlashAttribute("b2", "读者信息修改失败！");
           return "redirect:/admin_all_reader.html";
       }
   }
   @RequestMapping("reader_delete.html")
    public String readerDelete(HttpServletRequest request,RedirectAttributes redirectAttributes){
       int readerId= Integer.parseInt(request.getParameter("readerId"));
       boolean success=readerInfoService.deleteReaderInfo(readerId);
       if(success){
           redirectAttributes.addFlashAttribute("b2", "删除成功！");
           return "redirect:/admin_all_reader.html";
       }else {
           redirectAttributes.addFlashAttribute("b2", "删除失败！");
           return "redirect:/admin_all_reader.html";
       }
   }
    @RequestMapping("admin_edit_reader.html")
    public ModelAndView editReader(HttpServletRequest request){
        int readerId=Integer.parseInt(request.getParameter("readerId"));
        ReaderInfo readerInfo=readerInfoService.getReaderInfo(readerId);
        ModelAndView modelAndView = new ModelAndView("admin_edit_reader");
        modelAndView.addObject("readerInfo",readerInfo);
        return modelAndView;
    }
}
