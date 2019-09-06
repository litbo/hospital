package com.litbo.hospital.check_before_use.dao;

import com.litbo.hospital.check_before_use.pojo.CheckBeforeUse;
import com.litbo.hospital.check_before_use.pojo.CheckBeforeUseExample;
import java.util.List;

import com.litbo.hospital.check_before_use.vo.EqInfoCheckBeforeUseVo;
import org.apache.ibatis.annotations.Param;

public interface CheckBeforeUseDAO {

    // 查看设备信息
    List<EqInfoCheckBeforeUseVo> seeEqMessage(@Param("eqNum") String eqNum,@Param("bmName") String bmName,@Param("eqName") String eqName);

    long countByExample(CheckBeforeUseExample example);

    int deleteByExample(CheckBeforeUseExample example);

    int insert(CheckBeforeUse record);

    int insertSelective(CheckBeforeUse record);

    List<CheckBeforeUse> selectByExample(CheckBeforeUseExample example);

    int updateByExampleSelective(@Param("record") CheckBeforeUse record, @Param("example") CheckBeforeUseExample example);

    int updateByExample(@Param("record") CheckBeforeUse record, @Param("example") CheckBeforeUseExample example);


}