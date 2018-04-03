package com.yang.service;

import com.yang.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.*;

import java.util.ArrayList;

import static org.testng.Assert.*;
@ContextConfiguration("classpath*:/yang-context.xml")
public class AdminService extends AbstractTransactionalTestNGSpringContextTests {
    @Autowired
    private LoginService loginService;
    @Autowired
    private BookService bookService;

    @Test
    public void testAdminLogin() {
        boolean b1 = loginService.hasMatchAdmin(20170001,"111111");
        assertTrue(b1);
    }

    @Test
    public void testBookService(){
        ArrayList<Book> books=bookService.getAllBooks();
        for(int i = 0; i<books.size(); i++){
            System.out.println(books.get(i).getAuthor());
        }
    }
}
