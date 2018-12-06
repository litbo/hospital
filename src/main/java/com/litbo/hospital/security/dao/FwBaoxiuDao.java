package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.FwBaoxiu;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author zjc
 * @create 2018-12-03 10:54
 */
@Mapper
public interface FwBaoxiuDao {

    @Insert(" insert into fw_baoxiu (id, eq_id, bxr_id, \n" +
            "      bxfs, bxrdh, bxks, \n" +
            "      bxksdh, bx_time, fx_time, \n" +
            "      jjx_status, bx_status, gzxx, \n" +
            "      zz_status, zz_time)\n" +
            "    values (#{id,jdbcType=VARCHAR}, #{eqId,jdbcType=INTEGER}, #{bxrId,jdbcType=VARCHAR}, \n" +
            "      #{bxfs,jdbcType=VARCHAR}, #{bxrdh,jdbcType=VARCHAR}, #{bxks,jdbcType=VARCHAR}, \n" +
            "      #{bxksdh,jdbcType=VARCHAR}, #{bxTime,jdbcType=TIMESTAMP}, #{fxTime,jdbcType=TIMESTAMP}, \n" +
            "      #{jjxStatus,jdbcType=INTEGER}, #{bxStatus,jdbcType=INTEGER}, #{gzxx,jdbcType=INTEGER}, \n" +
            "      #{zzStatus,jdbcType=INTEGER}, #{zzTime,jdbcType=TIMESTAMP})")
    public void addBaoxiu(FwBaoxiu fwBaoxiu);

    @Update("update fw_baoxiu set bx_status = #{baoxiuStatus} where id = #{fwId}")
    public void updateBaoxiuStatus(@Param("fwId") String fwId, @Param("baoxiuStatus") int baoxiuStatus);
}
