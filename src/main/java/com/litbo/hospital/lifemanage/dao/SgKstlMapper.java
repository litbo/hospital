package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgKstl;
import com.litbo.hospital.lifemanage.bean.SgKstlExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 科室讨论表
 */
public interface SgKstlMapper {
    int countByExample(SgKstlExample example);

    int deleteByExample(SgKstlExample example);

    int deleteByPrimaryKey(String kstlId);

    int insert(SgKstlExample record);

    int insertSelective(SgKstlExample record);

    List<SgKstlExample> selectByExampleWithBLOBs(SgKstlExample example);

    List<SgKstl> selectByExample(SgKstlExample example);

    SgKstlExample selectByPrimaryKey(String kstlId);

    int updateByExampleSelective(@Param("record") SgKstlExample record, @Param("example") SgKstlExample example);

    int updateByExampleWithBLOBs(@Param("record") SgKstlExample record, @Param("example") SgKstlExample example);

    int updateByExample(@Param("record") SgKstl record, @Param("example") SgKstlExample example);

    int updateByPrimaryKeySelective(SgKstlExample record);

    int updateByPrimaryKeyWithBLOBs(SgKstlExample record);

    int updateByPrimaryKey(SgKstl record);
}