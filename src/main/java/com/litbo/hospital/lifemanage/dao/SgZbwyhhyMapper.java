package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgZbwyhhy;
import com.litbo.hospital.lifemanage.bean.SgZbwyhhyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 装备委员会会议信息表
 */
public interface SgZbwyhhyMapper {
    int countByExample(SgZbwyhhyExample example);

    int deleteByExample(SgZbwyhhyExample example);

    int deleteByPrimaryKey(String zbwyhhyId);

    int insert(SgZbwyhhy record);

    int insertSelective(SgZbwyhhy record);

    List<SgZbwyhhy> selectByExampleWithBLOBs(SgZbwyhhyExample example);

    List<SgZbwyhhy> selectByExample(SgZbwyhhyExample example);

    SgZbwyhhy selectByPrimaryKey(String zbwyhhyId);

    int updateByExampleSelective(@Param("record") SgZbwyhhy record, @Param("example") SgZbwyhhyExample example);

    int updateByExampleWithBLOBs(@Param("record") SgZbwyhhy record, @Param("example") SgZbwyhhyExample example);

    int updateByExample(@Param("record") SgZbwyhhy record, @Param("example") SgZbwyhhyExample example);

    int updateByPrimaryKeySelective(SgZbwyhhy record);

    int updateByPrimaryKeyWithBLOBs(SgZbwyhhy record);

    int updateByPrimaryKey(SgZbwyhhy record);
}