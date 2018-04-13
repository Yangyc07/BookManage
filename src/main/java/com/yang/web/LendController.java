package com.yang.web;

import com.yang.domain.Lend;
import com.yang.service.LendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class LendController {
    private LendService lendService;
    @Autowired

    public void setLendService(LendService lendService) {
        this.lendService = lendService;
    }

    @RequestMapping("all_lend_list.html")
    public ModelAndView getAllLendList(){
        ArrayList<Lend> lends= lendService.getAllLendList();
        ModelAndView modelAndView = new ModelAndView("admin_lend_list");
        modelAndView.addObject("lends",lends);
        return  modelAndView;
    }
    @RequestMapping("lend_book.html")
    public String lendBook(String bookId,String readerId,RedirectAttributes redirectAttributes){
        int tReaderId=Integer.parseInt(readerId);
        Long tBookId=Long.parseLong(bookId);
        boolean success=lendService.lendBook(tReaderId,tBookId);
        if(success){
            redirectAttributes.addFlashAttribute("success","成功借出");
            return "redirect:/all_books.html";
        }else{
            redirectAttributes.addFlashAttribute("success","借出失败");
            return "redirect:/all_books.html";
        }
    }
    @RequestMapping("return_book.html")
    public String returnBook(HttpServletRequest request,RedirectAttributes redirectAttributes){
        Long bookId=Long.parseLong(request.getParameter("bookId"));
        boolean success=lendService.returnBook(bookId);
        if(success){
            redirectAttributes.addFlashAttribute("success","还书成功");
            return "redirect:/all_books.html";
        }else{
            redirectAttributes.addFlashAttribute("success","还书失败");
            return "redirect:/all_books.html";
        }
    }
}
