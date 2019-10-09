package com.litbo.hospital.finance.dao;

import com.litbo.hospital.finance.pojo.Finance;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinanceDAO {
    int deleteByPrimaryKey(String id);

    int insert(Finance record);

    List<Finance> allFinance(@Param("name") String name, @Param("status") String status);

    int insertSelective(Finance record);

    Finance selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Finance record);

    int updateByPrimaryKey(Finance record);
}