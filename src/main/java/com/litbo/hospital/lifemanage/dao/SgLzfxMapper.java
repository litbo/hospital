package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgLzfx;
import com.litbo.hospital.lifemanage.bean.SgLzfxExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 论证分析表
 */
public interface SgLzfxMapper {
    int countByExample(SgLzfxExample example);

    int deleteByExample(SgLzfxExample example);

    int deleteByPrimaryKey(String lzfxId);

    int insert(SgLzfxExample record);

    int insertSelective(SgLzfxExample record);

    List<SgLzfxExample> selectByExampleWithBLOBs(SgLzfxExample example);

    List<SgLzfx> selectByExample(SgLzfxExample example);

    SgLzfxExample selectByPrimaryKey(String lzfxId);

    int updateByExampleSelective(@Param("record") SgLzfxExample record, @Param("example") SgLzfxExample example);

    int updateByExampleWithBLOBs(@Param("record") SgLzfxExample record, @Param("example") SgLzfxExample example);

    int updateByExample(@Param("record") SgLzfx record, @Param("example") SgLzfxExample example);

    int updateByPrimaryKeySelective(SgLzfxExample record);

    int updateByPrimaryKeyWithBLOBs(SgLzfxExample record);

    int updateByPrimaryKey(SgLzfx record);
}