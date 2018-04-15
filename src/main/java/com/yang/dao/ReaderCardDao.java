package com.yang.dao;

import com.yang.domain.ReaderCard;
import com.yang.domain.ReaderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ReaderCardDao {
    private JdbcTemplate jdbcTemplate;


    private final static String FIND_READER_BY_USERID = "select reader_id, name, password, card_state from reader_card where reader_id = ? ";
    private final static String MACTCH_COUNT_SQL = "select count(*) from reader_card where reader_id = ? and password = ? ";
    private final static String ADD_READERCARD_SQL = "INSERT INTO reader_card (reader_id,name) VALUES(?,?) ";


    public int getMatchCount(int readId, String password) {
        return jdbcTemplate.queryForObject(MACTCH_COUNT_SQL, new Object[]{readId, password}, Integer.class);
    }

    public int addReaderCard(ReaderInfo readerInfo) {
        int Id = readerInfo.getReaderId();
        String name = readerInfo.getName();
        return jdbcTemplate.update(ADD_READERCARD_SQL, new Object[]{Id, name});
    }

    public ReaderCard findReaderByReaderId(int userId) {
        final ReaderCard readerCard = new ReaderCard();
        jdbcTemplate.query(FIND_READER_BY_USERID, new Object[]{userId},
                //匿名类实现的回调函数
                new RowCallbackHandler() {
                    public void processRow(ResultSet resultSet) throws SQLException {
                        readerCard.setReader_id(resultSet.getInt("reader_id"));
                        readerCard.setPassword(resultSet.getString("passwd"));
                        readerCard.setName(resultSet.getString("name"));
                        readerCard.setCardState(resultSet.getInt("card_state"));
                    }
                });
        return readerCard;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
