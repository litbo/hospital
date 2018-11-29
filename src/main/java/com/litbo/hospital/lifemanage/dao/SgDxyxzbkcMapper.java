package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgDxyxzbkc;
import com.litbo.hospital.lifemanage.bean.SgDxyxzbkcExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 大型医学装备考察报告表
 */
public interface SgDxyxzbkcMapper {
    int countByExample(SgDxyxzbkcExample example);

    int deleteByExample(SgDxyxzbkcExample example);

    int deleteByPrimaryKey(String dxzbId);

    int insert(SgDxyxzbkcExample record);

    int insertSelective(SgDxyxzbkcExample record);

    List<SgDxyxzbkcExample> selectByExampleWithBLOBs(SgDxyxzbkcExample example);

    List<SgDxyxzbkc> selectByExample(SgDxyxzbkcExample example);

    SgDxyxzbkcExample selectByPrimaryKey(String dxzbId);

    int updateByExampleSelective(@Param("record") SgDxyxzbkcExample record, @Param("example") SgDxyxzbkcExample example);

    int updateByExampleWithBLOBs(@Param("record") SgDxyxzbkcExample record, @Param("example") SgDxyxzbkcExample example);

    int updateByExample(@Param("record") SgDxyxzbkc record, @Param("example") SgDxyxzbkcExample example);

    int updateByPrimaryKeySelective(SgDxyxzbkcExample record);

    int updateByPrimaryKeyWithBLOBs(SgDxyxzbkcExample record);

    int updateByPrimaryKey(SgDxyxzbkc record);
}