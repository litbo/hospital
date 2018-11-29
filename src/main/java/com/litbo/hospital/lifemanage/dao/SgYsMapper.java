package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgYs;
import com.litbo.hospital.lifemanage.bean.SgYsExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 商务/临床/技术验收表
 */
public interface SgYsMapper {
    int countByExample(SgYsExample example);

    int deleteByExample(SgYsExample example);

    int deleteByPrimaryKey(String ysId);

    int insert(SgYsExample record);

    int insertSelective(SgYsExample record);

    List<SgYsExample> selectByExampleWithBLOBs(SgYsExample example);

    List<SgYs> selectByExample(SgYsExample example);

    SgYsExample selectByPrimaryKey(String ysId);

    int updateByExampleSelective(@Param("record") SgYsExample record, @Param("example") SgYsExample example);

    int updateByExampleWithBLOBs(@Param("record") SgYsExample record, @Param("example") SgYsExample example);

    int updateByExample(@Param("record") SgYs record, @Param("example") SgYsExample example);

    int updateByPrimaryKeySelective(SgYsExample record);

    int updateByPrimaryKeyWithBLOBs(SgYsExample record);

    int updateByPrimaryKey(SgYs record);
}