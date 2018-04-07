package com.yang.dao;

import com.yang.domain.Lend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Repository
public class LendDao {
    private JdbcTemplate jdbcTemplate;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //还书，首先对lendlist进行操作，然后对图书信息进行操作
    private static final String RETURN_BOOK_SQL_ONE="UPDATE lend_list SET back_date = ? " +
            "WHERE book_id = ? AND back_date = null  ";
    private static final String RETURN_BOOK_SQL_TWO="UPDATE book_info SET state=1 where book_id = ?";

    //借书 将图书信息插入lend_list ,然后设置图书状态
    private static final String LEND_BOOK_SQL_ONE="INSERT INTO lend_list(book_id,reader_id,lend_date) VALUES(?,?,?)";
    private static final String LEND_BOOK_SQL_TWO="UPDATE book_info SET state=0 WHERE book_id=?";

    private static final String LEND_ALL_BOOK_SQL="SELECT * FROM lend_list";
    private static final String MY_LEND_LIST_SQL="SELEC* FROM lend_list WHERE reader_id = ? ";

    public int returnBookOne(long bookId){
        return jdbcTemplate.update(RETURN_BOOK_SQL_ONE,new Object[]{df.format(new Date()),bookId});
    }

    public int returnBookTwo(long bookId){
        return jdbcTemplate.update(RETURN_BOOK_SQL_TWO,bookId);
    }
    public int lendBookOne(long boooId , long readId){
        return jdbcTemplate.update(LEND_BOOK_SQL_ONE,new Object[]{boooId,readId, df.format(new Date())});
    }
    public int lendBookTwo(long bookId){
        return jdbcTemplate.update(LEND_BOOK_SQL_TWO,bookId);
    }

    public ArrayList<Lend> getAllLendList(){
        final ArrayList<Lend> list=new ArrayList<Lend>();
        jdbcTemplate.query(LEND_ALL_BOOK_SQL, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                resultSet.beforeFirst();
                while (resultSet.next()){
                    Lend lend=new Lend();
                    lend.setBack_date(resultSet.getDate("back_date"));
                    lend.setBook_id(resultSet.getLong("book_id"));
                    lend.setLend_date(resultSet.getDate("lend_date"));
                    lend.setReader_id(resultSet.getInt("reader_id"));
                    lend.setSernum(resultSet.getLong("sernum"));
                    list.add(lend);
                }
            }
        });
        return list;
    }

    public ArrayList<Lend> getMyLendlist(int readerId){
        final ArrayList<Lend> list=new ArrayList<Lend>();
        jdbcTemplate.query(MY_LEND_LIST_SQL, new Object[]{readerId},new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                resultSet.beforeFirst();
                while (resultSet.next()){
                    Lend lend=new Lend();
                    lend.setBack_date(resultSet.getDate("back_date"));
                    lend.setBook_id(resultSet.getLong("book_id"));
                    lend.setLend_date(resultSet.getDate("lend_date"));
                    lend.setReader_id(resultSet.getInt("reader_id"));
                    lend.setSernum(resultSet.getLong("sernum"));
                    list.add(lend);
                }
            }
        });
        return list;
    }
}
