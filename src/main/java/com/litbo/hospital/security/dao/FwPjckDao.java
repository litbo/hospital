package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.FwPjck;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FwPjckDao {
    @Insert("    insert into fw_pjck ( user_id, bx_id, \n" +
            "      pj_id, pj_ck_time, pj_ck_xsl, \n" +
            "      pj_ck_lsl)\n" +
            "    values (#{userId,jdbcType=VARCHAR}, #{bxId,jdbcType=VARCHAR}, \n" +
            "      #{pjId,jdbcType=INTEGER}, #{pjCkTime,jdbcType=TIMESTAMP}, #{pjCkXsl,jdbcType=INTEGER}, \n" +
            "      #{pjCkLsl,jdbcType=INTEGER})")
    int insertFwPjck(FwPjck pjck);
}
