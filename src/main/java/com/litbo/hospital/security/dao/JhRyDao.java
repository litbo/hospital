package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.JhRy;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zjc
 * @create 2018-11-30 18:08
 * 计划人员中间表
 */
@Mapper
public interface JhRyDao {

    @Insert("insert into jh_ry (user_id, jhrylr_id\n" +
            "      )\n" +
            "    values (#{userId,jdbcType=VARCHAR}, #{jhrylrId,jdbcType=INTEGER}\n" +
            "      )")
    public void addJhRy(JhRy jhRy);

}
