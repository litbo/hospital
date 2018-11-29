package com.litbo.hospital.beneficial.service.serviceImpl;

import com.litbo.hospital.beneficial.bean.BAccountBean;
import com.litbo.hospital.beneficial.dao.BAccountDao;
import com.litbo.hospital.beneficial.service.BAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BAccountServiceImpl implements BAccountService {

    @Autowired
    private BAccountDao bAccountDao;

    public int insertAccount(String fkmName) {
        return 0;
    }

    @Override
    public int deleteAccount(int id) {
        return 0;
    }

    @Override
    public int updateAccount(int id) {
        return 0;
    }

    @Override
    public BAccountBean accountList() {
        return null;
    }

    @Override
    public String getFkmName(String num) {
        return null;
    }

    @Override
    public String getKmName(String num) {
        return null;
    }

    @Override
    public String getKmNum(int id) {
        return null;
    }

    @Override
    public int updateAccountNum(String accountName) {
        return 0;
    }
}
