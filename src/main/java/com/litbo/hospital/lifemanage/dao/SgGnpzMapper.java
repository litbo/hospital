package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgGnpz;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * 功能配置表Mapper接口
 */
@Mapper
public interface SgGnpzMapper {

    @Insert("insert into sg_gnpz (gnpz_id, ckcssb_id, gnpz_mc, \n" +
            "   gnpz_ms, gnpz_issy, extend_one, \n" +
            "   extend_two)\n" +
            "values (#{gnpzId,jdbcType=VARCHAR}, #{ckcssbId,jdbcType=VARCHAR}, #{gnpzMc,jdbcType=VARCHAR}, \n" +
            "   #{gnpzMs,jdbcType=VARCHAR}, #{gnpzIssy,jdbcType=CHAR}, #{extendOne,jdbcType=VARCHAR}, \n" +
            "   #{extendTwo,jdbcType=VARCHAR})")
    int insertSgGnpz(SgGnpz sgGnpz);
}