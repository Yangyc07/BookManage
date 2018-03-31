package com.yang.domain;

import sun.util.calendar.LocalGregorianCalendar;

import java.util.Date;

//借书的信息
public class Lend {
    private long sernum;    //学号
    private long book_id;   //图书号
    private int reader_id;  //读者号
    private Date lend_date; //借阅日期
    private Date back_date; //应归还日期

    public long getSernum() {
        return sernum;
    }

    public void setSernum(long sernum) {
        this.sernum = sernum;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public int getReader_id() {
        return reader_id;
    }

    public void setReader_id(int reader_id) {
        this.reader_id = reader_id;
    }

    public Date getLend_date() {
        return lend_date;
    }

    public void setLend_date(Date lend_date) {
        this.lend_date = lend_date;
    }

    public Date getBack_date() {
        return back_date;
    }

    public void setBack_date(Date back_date) {
        this.back_date = back_date;
    }
}
