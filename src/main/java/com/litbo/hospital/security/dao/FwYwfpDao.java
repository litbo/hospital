package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.FwYwfp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FwYwfpDao {
    @Insert("    insert into fw_ywfp ( eq_id, sbcs_id, \n" +
            "      ywfp_hm, ywfp_price, ywfp_sd_time, \n" +
            "      ywfp_cj_time)\n" +
            "    values ( #{eqId,jdbcType=VARCHAR}, #{sbcsId,jdbcType=VARCHAR}, " +
            "      #{ywfpHm,jdbcType=VARCHAR}, #{ywfpPrice}, #{ywfpSdTime,jdbcType=TIMESTAMP}, \n" +
            "      #{ywfpCjTime,jdbcType=TIMESTAMP})")
    int insertFwYwFp(FwYwfp fwYwfp);
}
