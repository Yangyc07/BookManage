package com.yang.dao;

import com.yang.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
    private JdbcTemplate jdbcTemplate;

    private final static String ADD_BOOK_SQL="INSERT INTO book_info VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
    private final static String DELETE_BOOK_SQL="DELETE FORM book_info WHERE book_id = ?";

    public int addBook(Book book){
        long book_id=book.getBook_id();
        String name=book.getName();
        String author=book.getAuthor();
        return 0;
    }


}
