package com.yang.service;

import com.yang.dao.ReaderDao;
import com.yang.domain.ReaderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ReaderInfoService {
    private ReaderDao readerDao;
    @Autowired
    public void setReaderDao(ReaderDao readerDao) {
        this.readerDao = readerDao;
    }

    public  boolean addReaderInfo(ReaderInfo readerInfo){
        return readerDao.addReaderInfo(readerInfo)>0;
    }

    public  boolean deleteReaderInfo(int readId){
        return readerDao.deleteReaderInfo(readId)>0;
    }

    public ReaderInfo getReaderInfo(int readId){
        return  readerDao.findReaderInfoByReaderId(readId);
    }

    public ArrayList<ReaderInfo> getAllReaders(){
        return readerDao.getAllReaderInfo();
    }

}
