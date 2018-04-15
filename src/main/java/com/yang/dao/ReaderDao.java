package com.yang.dao;

import com.yang.domain.ReaderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

@Repository
public class ReaderDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final static String ADD_READER_INFO_SQL = "INSERT INTO reader_info Values(?,?,?,?,?,?)";
    private final static String DELETE_READER_INFO_SQL = "DELETE FROM reader_info WHERE reader_id = ?";
    private final static String GET_READER_INFO_SQL = "SELECT *FROM reader_info WHERE reader_id = ?";
    private final static String GET_ALL_READER_INFO_SQL = "SELECT *FROM reader_info";


    public int addReaderInfo(ReaderInfo readerInfo) {
        int readerId = readerInfo.getReaderId();
        String name = readerInfo.getName();
        String sex = readerInfo.getSex();
        String address = readerInfo.getAddress();
        String telCode = readerInfo.getTelcode();
        Date birth = readerInfo.getBirth();

        return jdbcTemplate.update(ADD_READER_INFO_SQL, new Object[]{readerId, name, sex, birth, address, telCode});
    }

    public int deleteReaderInfo(int readerId) {
        return jdbcTemplate.update(DELETE_READER_INFO_SQL, readerId);
    }

    public ReaderInfo findReaderInfoByReaderId(final int readerId) {
        final ReaderInfo reader = new ReaderInfo();
        jdbcTemplate.query(GET_READER_INFO_SQL, new Object[]{readerId}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                reader.setReaderId(resultSet.getInt("reader_id"));
                reader.setName(resultSet.getString("name"));
                reader.setSex(resultSet.getString("sex"));
                reader.setAddress(resultSet.getString("address"));
                reader.setTelcode(resultSet.getString("telCode"));
                reader.setBirth(resultSet.getDate("birth"));
            }
        });
        return reader;
    }

    public ArrayList<ReaderInfo> getAllReaderInfo() {
        final ArrayList<ReaderInfo> readers = new ArrayList<ReaderInfo>();
        jdbcTemplate.query(GET_ALL_READER_INFO_SQL, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                resultSet.beforeFirst();
                while (resultSet.next()) {
                    ReaderInfo reader = new ReaderInfo();
                    reader.setReaderId(resultSet.getInt("reader_id"));
                    reader.setName(resultSet.getString("name"));
                    reader.setSex(resultSet.getString("sex"));
                    reader.setAddress(resultSet.getString("address"));
                    reader.setTelcode(resultSet.getString("telCode"));
                    reader.setBirth(resultSet.getDate("birth"));
                    readers.add(reader);
                }
            }
        });
        return readers;
    }
}
