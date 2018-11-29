package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgZbwyhRyExample;
import com.litbo.hospital.lifemanage.bean.SgZbwyhRy;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 参加装备委员会会议人员关联表
 */
public interface SgZbwyhRyMapper {
    int countByExample(SgZbwyhRyExample example);

    int deleteByExample(SgZbwyhRyExample example);

    int deleteByPrimaryKey(SgZbwyhRy key);

    int insert(SgZbwyhRy record);

    int insertSelective(SgZbwyhRy record);

    List<SgZbwyhRy> selectByExample(SgZbwyhRyExample example);

    int updateByExampleSelective(@Param("record") SgZbwyhRy record, @Param("example") SgZbwyhRyExample example);

    int updateByExample(@Param("record") SgZbwyhRy record, @Param("example") SgZbwyhRyExample example);
}