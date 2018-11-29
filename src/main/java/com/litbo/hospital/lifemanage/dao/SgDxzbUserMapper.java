package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgDxzbUserExample;
import com.litbo.hospital.lifemanage.bean.SgDxzbUser;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 大型医学装备考察报告考察人员表
 */
public interface SgDxzbUserMapper {
    int countByExample(SgDxzbUserExample example);

    int deleteByExample(SgDxzbUserExample example);

    int deleteByPrimaryKey(SgDxzbUser key);

    int insert(SgDxzbUser record);

    int insertSelective(SgDxzbUser record);

    List<SgDxzbUser> selectByExample(SgDxzbUserExample example);

    int updateByExampleSelective(@Param("record") SgDxzbUser record, @Param("example") SgDxzbUserExample example);

    int updateByExample(@Param("record") SgDxzbUser record, @Param("example") SgDxzbUserExample example);
}