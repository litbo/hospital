package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.FwLcjl;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FwLcjlDao {
    @Insert("    insert into fw_lcjl ( user_id, creat_time, " +
            "      bx_id, lc)" +
            "    values ( #{userId,jdbcType=VARCHAR}, #{creatTime,jdbcType=TIMESTAMP}, " +
            "      #{bxId,jdbcType=VARCHAR}, #{lc,jdbcType=VARCHAR})")
    int insertFwLcjl(FwLcjl lcjl);

}
