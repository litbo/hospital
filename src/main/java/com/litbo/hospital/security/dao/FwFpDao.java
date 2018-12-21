package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.FwFp;
import com.litbo.hospital.security.vo.ListFwFpByWaitExamineVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FwFpDao {

    @SelectProvider(type=com.litbo.hospital.security.dao.sqlprovider.FwFpSqlProvider.class,method="listFwFpByWaitExamine")
    List<ListFwFpByWaitExamineVo> listFwFpByWaitExamine();

    @Insert("    insert into fw_fp ( fp_dh, fp_price," +
            "      fp_sdtime, fp_status, user_id" +
            "      fp_cj_time,fp_hm)" +
            "    values (#{fpDh,jdbcType=VARCHAR}, #{fpPrice,jdbcType=DECIMAL}, " +
            "      #{fpSdtime,jdbcType=TIMESTAMP}, #{fpStatus,jdbcType=INTEGER}, #{userId,jdbcType=VARCHAR}, " +
            "      #{fpCjTime,jdbcType=TIMESTAMP}, #{fpHm,jdbcType=VARCHAR})")
    Integer insertFwFp(FwFp fp);
}
