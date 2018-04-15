package com.yang.web;

import com.yang.domain.Book;
import com.yang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class BookController {
    private BookService bookService;

    @Autowired

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("all_books")
    public ModelAndView getAllBooks() {
        ArrayList<Book> books = bookService.getAllBooks();
        ModelAndView modelAndView = new ModelAndView("admin_all_books");
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @RequestMapping("delete_book")
    public String deleteBook(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        Long bookId = Long.parseLong(request.getParameter("bookId"));
        boolean success = bookService.deleteBook(bookId);
        if (success) {
            redirectAttributes.addFlashAttribute("success", "成功删除图书");
            return "redirect:/all_books.html";
        } else {
            redirectAttributes.addFlashAttribute("success", "删除图书失败");
            return "redirect:/all_books.html";
        }
    }


}
