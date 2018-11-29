package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgLzfxxhbj;
import com.litbo.hospital.lifemanage.bean.SgLzfxxhbjExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 论证分析参考型号及报价表
 */
public interface SgLzfxxhbjMapper {
    int countByExample(SgLzfxxhbjExample example);

    int deleteByExample(SgLzfxxhbjExample example);

    int deleteByPrimaryKey(String xhbjId);

    int insert(SgLzfxxhbj record);

    int insertSelective(SgLzfxxhbj record);

    List<SgLzfxxhbj> selectByExampleWithBLOBs(SgLzfxxhbjExample example);

    List<SgLzfxxhbj> selectByExample(SgLzfxxhbjExample example);

    SgLzfxxhbj selectByPrimaryKey(String xhbjId);

    int updateByExampleSelective(@Param("record") SgLzfxxhbj record, @Param("example") SgLzfxxhbjExample example);

    int updateByExampleWithBLOBs(@Param("record") SgLzfxxhbj record, @Param("example") SgLzfxxhbjExample example);

    int updateByExample(@Param("record") SgLzfxxhbj record, @Param("example") SgLzfxxhbjExample example);

    int updateByPrimaryKeySelective(SgLzfxxhbj record);

    int updateByPrimaryKeyWithBLOBs(SgLzfxxhbj record);

    int updateByPrimaryKey(SgLzfxxhbj record);
}