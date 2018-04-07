package com.yang.service;

import com.yang.dao.LendDao;
import com.yang.domain.Lend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LendService {
    private LendDao lendDao;
    @Autowired

    public void setLendDao(LendDao lendDao) {
        this.lendDao = lendDao;
    }

    public boolean returnBook(long bookId){
        return lendDao.returnBookOne(bookId)>0&&lendDao.returnBookTwo(bookId)>0;
    }

    public boolean lendBook(int readerId,long bookId){
        return lendDao.lendBookOne(readerId,bookId)>0&&lendDao.lendBookTwo(bookId)>0;
    }

    public ArrayList<Lend> getAllLendList(){
        return lendDao.getAllLendList();
    }

    public ArrayList<Lend> getMyLendList(int readerId){
        return lendDao.getMyLendlist(readerId);
    }
}
