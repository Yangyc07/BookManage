package com.yang.service;

import com.yang.dao.ReaderDao;
import com.yang.domain.ReaderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReaderInfoService {
    private ReaderDao readerDao;
    @Autowired
    public void setReaderDao(ReaderDao readerDao) {
        this.readerDao = readerDao;
    }


}
