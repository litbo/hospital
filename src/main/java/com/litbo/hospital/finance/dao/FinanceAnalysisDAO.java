package com.litbo.hospital.finance.dao;

import com.litbo.hospital.finance.pojo.FinanceAnalysis;

import java.util.List;

public interface FinanceAnalysisDAO {
    int deleteByPrimaryKey(String id);

    int insert(FinanceAnalysis record);

    int insertSelective(FinanceAnalysis record);

    FinanceAnalysis selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FinanceAnalysis record);

    int updateByPrimaryKey(FinanceAnalysis record);

    List<FinanceAnalysis> getFinanceAnalysis(String id);
}