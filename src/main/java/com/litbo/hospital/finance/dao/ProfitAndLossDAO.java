package com.litbo.hospital.finance.dao;

import com.litbo.hospital.finance.pojo.ProfitAndLoss;

import java.util.List;

public interface ProfitAndLossDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(ProfitAndLoss record);

    int insertSelective(ProfitAndLoss record);

    ProfitAndLoss selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProfitAndLoss record);

    int updateByPrimaryKey(ProfitAndLoss record);

    List<ProfitAndLoss> getMessage(String id);
}