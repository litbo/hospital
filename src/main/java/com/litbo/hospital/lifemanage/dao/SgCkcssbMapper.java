package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgCkcssb;
import com.litbo.hospital.lifemanage.bean.SgCkcssbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *参考厂商设备表
 */
public interface SgCkcssbMapper {
    int countByExample(SgCkcssbExample example);

    int deleteByExample(SgCkcssbExample example);

    int deleteByPrimaryKey(String ckcssbId);

    int insert(SgCkcssb record);

    int insertSelective(SgCkcssb record);

    List<SgCkcssb> selectByExample(SgCkcssbExample example);

    SgCkcssb selectByPrimaryKey(String ckcssbId);

    int updateByExampleSelective(@Param("record") SgCkcssb record, @Param("example") SgCkcssbExample example);

    int updateByExample(@Param("record") SgCkcssb record, @Param("example") SgCkcssbExample example);

    int updateByPrimaryKeySelective(SgCkcssb record);

    int updateByPrimaryKey(SgCkcssb record);
}