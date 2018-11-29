package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgInfo;
import com.litbo.hospital.lifemanage.bean.SgInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 申购单表
 */
public interface SgInfoMapper {
    int countByExample(SgInfoExample example);

    int deleteByExample(SgInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(SgInfoExample record);

    int insertSelective(SgInfoExample record);

    List<SgInfoExample> selectByExampleWithBLOBs(SgInfoExample example);

    List<SgInfo> selectByExample(SgInfoExample example);

    SgInfoExample selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SgInfoExample record, @Param("example") SgInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") SgInfoExample record, @Param("example") SgInfoExample example);

    int updateByExample(@Param("record") SgInfo record, @Param("example") SgInfoExample example);

    int updateByPrimaryKeySelective(SgInfoExample record);

    int updateByPrimaryKeyWithBLOBs(SgInfoExample record);

    int updateByPrimaryKey(SgInfo record);
}