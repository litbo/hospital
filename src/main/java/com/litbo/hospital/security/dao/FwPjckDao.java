package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.FwPjck;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FwPjckDao {
    @Insert("    insert into fw_pjck ( user_id, " +
            "      ql_id, pj_ck_time, shyy)" +
            "    values (#{userId,jdbcType=VARCHAR},"+
            "      #{qlId,jdbcType=INTEGER}, #{pjCkTime,jdbcType=TIMESTAMP}," +
            "      #{shyy,jdbcType=VARCHAR})")
    int insertFwPjck(FwPjck pjck);
}
