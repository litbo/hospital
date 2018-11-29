package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgKxxfx;
import com.litbo.hospital.lifemanage.bean.SgKxxfxExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 可行性分析表
 */
public interface SgKxxfxMapper {
    int countByExample(SgKxxfxExample example);

    int deleteByExample(SgKxxfxExample example);

    int deleteByPrimaryKey(String kxfxId);

    int insert(SgKxxfxExample record);

    int insertSelective(SgKxxfxExample record);

    List<SgKxxfxExample> selectByExampleWithBLOBs(SgKxxfxExample example);

    List<SgKxxfx> selectByExample(SgKxxfxExample example);

    SgKxxfxExample selectByPrimaryKey(String kxfxId);

    int updateByExampleSelective(@Param("record") SgKxxfxExample record, @Param("example") SgKxxfxExample example);

    int updateByExampleWithBLOBs(@Param("record") SgKxxfxExample record, @Param("example") SgKxxfxExample example);

    int updateByExample(@Param("record") SgKxxfx record, @Param("example") SgKxxfxExample example);

    int updateByPrimaryKeySelective(SgKxxfxExample record);

    int updateByPrimaryKeyWithBLOBs(SgKxxfxExample record);

    int updateByPrimaryKey(SgKxxfx record);
}