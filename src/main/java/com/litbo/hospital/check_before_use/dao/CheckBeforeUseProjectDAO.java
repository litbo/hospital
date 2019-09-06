package com.litbo.hospital.check_before_use.dao;

import com.litbo.hospital.check_before_use.pojo.CheckBeforeUseProject;
import com.litbo.hospital.check_before_use.pojo.CheckBeforeUseProjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CheckBeforeUseProjectDAO {
    long countByExample(CheckBeforeUseProjectExample example);

    int deleteByExample(CheckBeforeUseProjectExample example);

    int deleteById(int id);

    int insert(CheckBeforeUseProject record);

    int insertSelective(CheckBeforeUseProject record);

    List<CheckBeforeUseProject> selectByExample(CheckBeforeUseProjectExample example);

    int updateByExampleSelective(@Param("record") CheckBeforeUseProject record, @Param("example") CheckBeforeUseProjectExample example);

    int updateByExample(@Param("record") CheckBeforeUseProject record, @Param("example") CheckBeforeUseProjectExample example);

    int getMaxId();
}