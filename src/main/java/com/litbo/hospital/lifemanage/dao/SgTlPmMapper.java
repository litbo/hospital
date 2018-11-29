package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgTlPmExample;
import com.litbo.hospital.lifemanage.bean.SgTlPm;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 讨论申购设备关联表
 */
public interface SgTlPmMapper {
    int countByExample(SgTlPmExample example);

    int deleteByExample(SgTlPmExample example);

    int deleteByPrimaryKey(SgTlPm key);

    int insert(SgTlPm record);

    int insertSelective(SgTlPm record);

    List<SgTlPm> selectByExample(SgTlPmExample example);

    int updateByExampleSelective(@Param("record") SgTlPm record, @Param("example") SgTlPmExample example);

    int updateByExample(@Param("record") SgTlPm record, @Param("example") SgTlPmExample example);
}