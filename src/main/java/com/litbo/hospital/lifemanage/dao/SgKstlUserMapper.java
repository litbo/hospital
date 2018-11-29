package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgKstlUserExample;
import com.litbo.hospital.lifemanage.bean.SgKstlUser;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 科室讨论会议人员关联表
 */
public interface SgKstlUserMapper {
    int countByExample(SgKstlUserExample example);

    int deleteByExample(SgKstlUserExample example);

    int deleteByPrimaryKey(SgKstlUser key);

    int insert(SgKstlUser record);

    int insertSelective(SgKstlUser record);

    List<SgKstlUser> selectByExample(SgKstlUserExample example);

    int updateByExampleSelective(@Param("record") SgKstlUser record, @Param("example") SgKstlUserExample example);

    int updateByExample(@Param("record") SgKstlUser record, @Param("example") SgKstlUserExample example);
}