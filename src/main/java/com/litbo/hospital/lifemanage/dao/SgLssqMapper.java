package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgLssq;
import com.litbo.hospital.lifemanage.bean.SgLssqExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 临时采购授权表
 */
public interface SgLssqMapper {
    int countByExample(SgLssqExample example);

    int deleteByExample(SgLssqExample example);

    int deleteByPrimaryKey(String lssqId);

    int insert(SgLssq record);

    int insertSelective(SgLssq record);

    List<SgLssq> selectByExample(SgLssqExample example);

    SgLssq selectByPrimaryKey(String lssqId);

    int updateByExampleSelective(@Param("record") SgLssq record, @Param("example") SgLssqExample example);

    int updateByExample(@Param("record") SgLssq record, @Param("example") SgLssqExample example);

    int updateByPrimaryKeySelective(SgLssq record);

    int updateByPrimaryKey(SgLssq record);
}