package com.litbo.hospital.finance.dao;

import com.litbo.hospital.finance.pojo.ProfitAndLoss;
import com.litbo.hospital.finance.vo.ProfitAndLossVo;

import java.util.List;

public interface ProfitAndLossDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(ProfitAndLoss record);

    int insertSelective(ProfitAndLoss record);

    ProfitAndLoss selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProfitAndLoss record);

    int updateByPrimaryKey(ProfitAndLoss record);

    List<ProfitAndLossVo> getMessage(String id);
}