package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 申购单表Mapper接口
 */
@Mapper
public interface SgInfoMapper {

    /**
     * 通过品名Id查询申购单表信息
     * @param pmId 品名ID
     * @return 返回申购单内容
     */
    @Select("SELECT\n" +
            "dbo.sg_info.id,\n" +
            "dbo.sg_info.bh\n" +
            "FROM\n" +
            "dbo.sg_info\n" +
            "WHERE\n" +
            "dbo.sg_info.eq_pm_id = #{pmId,jdbcType=INTEGER}")
    SgInfo selectSgInfoByPmId(Integer pmId);
}