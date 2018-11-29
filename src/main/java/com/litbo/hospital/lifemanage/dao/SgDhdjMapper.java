package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgDhdj;
import com.litbo.hospital.lifemanage.bean.SgDhdjExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 到货登记表
 */
public interface SgDhdjMapper {
    int countByExample(SgDhdjExample example);

    int deleteByExample(SgDhdjExample example);

    int deleteByPrimaryKey(String dhdjId);

    int insert(SgDhdj record);

    int insertSelective(SgDhdj record);

    List<SgDhdj> selectByExample(SgDhdjExample example);

    SgDhdj selectByPrimaryKey(String dhdjId);

    int updateByExampleSelective(@Param("record") SgDhdj record, @Param("example") SgDhdjExample example);

    int updateByExample(@Param("record") SgDhdj record, @Param("example") SgDhdjExample example);

    int updateByPrimaryKeySelective(SgDhdj record);

    int updateByPrimaryKey(SgDhdj record);
}