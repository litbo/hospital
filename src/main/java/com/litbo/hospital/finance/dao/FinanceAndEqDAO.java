package com.litbo.hospital.finance.dao;

import com.litbo.hospital.finance.pojo.FinanceAndEq;
import com.litbo.hospital.finance.vo.FinanceEqVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinanceAndEqDAO {
    int insert(FinanceAndEq record);

    int insertSelective(FinanceAndEq record);

    List<FinanceEqVo> getGuanLian(@Param("eqNum") String eqNum,@Param("eqName") String eqName,@Param("name") String name,@Param("bmName") String bmName);
}