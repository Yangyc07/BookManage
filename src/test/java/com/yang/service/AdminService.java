package com.yang.service;

import com.yang.domain.Book;
import com.yang.domain.ReaderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Date;

import static org.testng.Assert.*;

@ContextConfiguration("classpath*:/yang-context.xml")
public class AdminService extends AbstractTransactionalTestNGSpringContextTests {
    @Autowired
    private LoginService loginService;
    @Autowired
    private BookService bookService;
    @Autowired
    private ReaderInfoService readerInfoService;
    @Autowired
    private ReaderCardService readerCardService;
    @Autowired
    private LendService lendService;

    @Test
    public void testAdminLogin() {
        boolean b1 = loginService.hasMatchAdmin(2017001,"111111");
        assertTrue(b1);
    }
    @Test
    public void testLend() {
        boolean b1=lendService.returnBook(10000001);
        System.out.print(b1);
    }

    @Test
    public void testBookService(){
        ArrayList<Book> books=bookService.getAllBooks();
        for(int i = 0; i<books.size(); i++){
            System.out.println(books.get(i).getAuthor());
        }
    }

    @Test
    public void testReaderCardService(){
        ReaderInfo readerInfo=new ReaderInfo(150101410,"杨亚宸","男",new Date(1992-03-21) ,"湖北荆州","18772812230");
        boolean b1=readerCardService.addReaderCard(readerInfo);
    }

    @Test
    public void testReaderService(){
        ReaderInfo readerInfo=new ReaderInfo(1501014109,"杨亚宸","男",new Date(1992-03-21) ,"湖北荆州","18772812230");
        boolean b1=readerInfoService.deleteReaderInfo(1501014101);
        readerInfoService.addReaderInfo(readerInfo);
        System.out.print(b1);

        ArrayList<ReaderInfo> readerInfos=readerInfoService.getAllReaders();
        for(int i = 0; i<readerInfos.size(); i++){
            System.out.println(readerInfos.get(i).getName());
        }
    }
}
