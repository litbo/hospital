package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.FwBaoxiu;
import com.litbo.hospital.security.dao.sqlprovider.FwBaoxiuProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zjc
 * @create 2018-12-03 10:54
 */
@Mapper
public interface FwBaoxiuDao {

    @Insert("insert into fw_baoxiu (id, eq_id, bxr_id, \n" +
            "      bxfs, bxrdh, bxks_id, bxksdh, \n" +
            "      bx_time, fx_time, jjx_status, \n" +
            "      bx_status, gzxx, zz_status, \n" +
            "      zz_time)\n" +
            "    values (#{id,jdbcType=VARCHAR}, #{eqId,jdbcType=INTEGER}, #{bxrId,jdbcType=VARCHAR}, \n" +
            "      #{bxfs,jdbcType=VARCHAR}, #{bxrdh,jdbcType=VARCHAR}, #{bxksId,jdbcType=CHAR}, #{bxksdh,jdbcType=VARCHAR}, \n" +
            "      #{bxTime,jdbcType=TIMESTAMP}, #{fxTime,jdbcType=TIMESTAMP}, #{jjxStatus,jdbcType=INTEGER}, \n" +
            "      #{bxStatus,jdbcType=INTEGER}, #{gzxx,jdbcType=VARCHAR}, #{zzStatus,jdbcType=INTEGER}, \n" +
            "      #{zzTime,jdbcType=TIMESTAMP})")
    public void addBaoxiu(FwBaoxiu fwBaoxiu);

    @Update("update fw_baoxiu set bx_status = #{baoxiuStatus} where id = #{fwId}")
    //@UpdateProvider(type = FwBaoxiuProvider.class)
    public void updateBaoxiuStatus(@Param("fwId") String fwId, @Param("baoxiuStatus") int baoxiuStatus);

    @SelectProvider(type = FwBaoxiuProvider.class,method = "listFwBaoxiu")
    public List<FwBaoxiu> findFwBaoxiu();
}
