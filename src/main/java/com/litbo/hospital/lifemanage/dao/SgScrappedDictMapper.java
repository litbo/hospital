package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgScrappedDict;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

/**
 * 报废原因字典
 */
@Mapper
public interface SgScrappedDictMapper {
    /**
     * 添加处置管理的报废原因
     *
     * @param record 信息
     * @return 添加记录数
     */
    @Insert({
            "insert into sg_scrapped_dict (reason_id, reason_name)",
            "values (#{reasonId,jdbcType=INTEGER}, #{reasonName,jdbcType=VARCHAR})"
    })
    int insert(SgScrappedDict record);

    /**
     * 根据主键查询处置管理的报废原因
     *
     * @param reasonId 主键
     * @return 查询到的信息
     */
    @Select({
            "select",
            "reason_id, reason_name",
            "from sg_scrapped_dict",
            "where reason_id = #{reasonId,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
            @Arg(column = "reason_id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "reason_name", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    SgScrappedDict selectByPrimaryKey(Integer reasonId);
}