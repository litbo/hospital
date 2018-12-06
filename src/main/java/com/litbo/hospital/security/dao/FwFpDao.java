package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.FwFp;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FwFpDao {

    @Select("select * from fw_fp")
    List<FwFp> listFwFp();

    @Insert("    insert into fw_fp ( fp_dh, fp_price, " +
            "      fp_sdtime, fp_status, user_id, " +
            "      fp_cj_time)" +
            "    values (#{fpDh,jdbcType=VARCHAR}, #{fpPrice,jdbcType=DECIMAL}, " +
            "      #{fpSdtime,jdbcType=TIMESTAMP}, #{fpStatus,jdbcType=INTEGER}, #{userId,jdbcType=VARCHAR}, " +
            "      #{fpCjTime,jdbcType=TIMESTAMP})")
    Integer insertFwFp(FwFp fp);
}
