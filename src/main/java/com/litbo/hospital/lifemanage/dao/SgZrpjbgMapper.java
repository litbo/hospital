package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgZrpjbg;
import com.litbo.hospital.lifemanage.bean.SgZrpjbgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 准入评价报告表
 */
public interface SgZrpjbgMapper {
    int countByExample(SgZrpjbgExample example);

    int deleteByExample(SgZrpjbgExample example);

    int deleteByPrimaryKey(String pjbgId);

    int insert(SgZrpjbg record);

    int insertSelective(SgZrpjbg record);

    List<SgZrpjbg> selectByExample(SgZrpjbgExample example);

    SgZrpjbg selectByPrimaryKey(String pjbgId);

    int updateByExampleSelective(@Param("record") SgZrpjbg record, @Param("example") SgZrpjbgExample example);

    int updateByExample(@Param("record") SgZrpjbg record, @Param("example") SgZrpjbgExample example);

    int updateByPrimaryKeySelective(SgZrpjbg record);

    int updateByPrimaryKey(SgZrpjbg record);
}