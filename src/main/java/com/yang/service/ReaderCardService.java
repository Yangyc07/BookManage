package com.yang.service;

import com.yang.dao.ReaderCardDao;
import com.yang.domain.ReaderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReaderCardService {
    private ReaderCardDao readerCardDao;

    @Autowired
    public void setReaderCardDao(ReaderCardDao readerCardDao) {
        this.readerCardDao = readerCardDao;
    }


    public boolean addReaderCard(ReaderInfo readerInfo) {
        return readerCardDao.addReaderCard(readerInfo) > 0;
    }
}
