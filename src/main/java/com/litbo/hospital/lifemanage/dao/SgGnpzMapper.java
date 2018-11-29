package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgGnpz;
import com.litbo.hospital.lifemanage.bean.SgGnpzExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 功能配置表
 */
public interface SgGnpzMapper {
    int countByExample(SgGnpzExample example);

    int deleteByExample(SgGnpzExample example);

    int deleteByPrimaryKey(String gnpzId);

    int insert(SgGnpz record);

    int insertSelective(SgGnpz record);

    List<SgGnpz> selectByExample(SgGnpzExample example);

    SgGnpz selectByPrimaryKey(String gnpzId);

    int updateByExampleSelective(@Param("record") SgGnpz record, @Param("example") SgGnpzExample example);

    int updateByExample(@Param("record") SgGnpz record, @Param("example") SgGnpzExample example);

    int updateByPrimaryKeySelective(SgGnpz record);

    int updateByPrimaryKey(SgGnpz record);
}