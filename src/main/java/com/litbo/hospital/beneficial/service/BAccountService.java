package com.litbo.hospital.beneficial.service;

import com.litbo.hospital.beneficial.bean.BAccountBean;

public interface BAccountService {

    int insertAccount(String fkmName);

    int deleteAccount(int id);

    int updateAccount(int id);

    BAccountBean accountList();

    int updateAccountNum(String accountName);

    String getFkmName(String num);

    String getKmName(String num);

    public String getKmNum(int id);

}
