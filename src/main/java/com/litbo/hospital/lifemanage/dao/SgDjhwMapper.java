package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgDjhw;
import com.litbo.hospital.lifemanage.bean.SgDjhwExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 登记货物表
 */
public interface SgDjhwMapper {
    int countByExample(SgDjhwExample example);

    int deleteByExample(SgDjhwExample example);

    int deleteByPrimaryKey(String djhwId);

    int insert(SgDjhw record);

    int insertSelective(SgDjhw record);

    List<SgDjhw> selectByExample(SgDjhwExample example);

    SgDjhw selectByPrimaryKey(String djhwId);

    int updateByExampleSelective(@Param("record") SgDjhw record, @Param("example") SgDjhwExample example);

    int updateByExample(@Param("record") SgDjhw record, @Param("example") SgDjhwExample example);

    int updateByPrimaryKeySelective(SgDjhw record);

    int updateByPrimaryKey(SgDjhw record);
}