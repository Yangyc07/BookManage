package com.yang.service;

import com.yang.dao.BookDao;
import com.yang.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookService {
    private BookDao bookDao;

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public boolean addBoook(Book book){
        return bookDao.addBook(book)>0;
    }

    public boolean deleteBook(Long bookId){
        return  bookDao.deleteBook(bookId)>0;
    }

    public ArrayList<Book> queryBook(String searchWord){
        return  bookDao.queryBook(searchWord);
    }

    public ArrayList<Book> getAllBooks(){
        return bookDao.getAllBooks();
    }
}
