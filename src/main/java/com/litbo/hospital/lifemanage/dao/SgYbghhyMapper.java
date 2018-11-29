package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgYbghhy;
import com.litbo.hospital.lifemanage.bean.SgYbghhyExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 院办公会会议信息表
 */
public interface SgYbghhyMapper {
    int countByExample(SgYbghhyExample example);

    int deleteByExample(SgYbghhyExample example);

    int deleteByPrimaryKey(String ybghhyId);

    int insert(SgYbghhyExample record);

    int insertSelective(SgYbghhyExample record);

    List<SgYbghhyExample> selectByExampleWithBLOBs(SgYbghhyExample example);

    List<SgYbghhy> selectByExample(SgYbghhyExample example);

    SgYbghhyExample selectByPrimaryKey(String ybghhyId);

    int updateByExampleSelective(@Param("record") SgYbghhyExample record, @Param("example") SgYbghhyExample example);

    int updateByExampleWithBLOBs(@Param("record") SgYbghhyExample record, @Param("example") SgYbghhyExample example);

    int updateByExample(@Param("record") SgYbghhy record, @Param("example") SgYbghhyExample example);

    int updateByPrimaryKeySelective(SgYbghhyExample record);

    int updateByPrimaryKeyWithBLOBs(SgYbghhyExample record);

    int updateByPrimaryKey(SgYbghhy record);
}