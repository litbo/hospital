package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.FwBaoxiu;
import com.litbo.hospital.security.dao.sqlprovider.FwBaoxiuProvider;
import com.litbo.hospital.security.vo.FwBaoxiuIndexVo;
import com.litbo.hospital.security.vo.FwNameVo;
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
            "    values (#{id,jdbcType=VARCHAR}, #{eqId,jdbcType=VARCHAR}, #{bxrId,jdbcType=VARCHAR}, \n" +
            "      #{bxfs,jdbcType=VARCHAR}, #{bxrdh,jdbcType=VARCHAR}, #{bxksId,jdbcType=CHAR}, #{bxksdh,jdbcType=VARCHAR}, \n" +
            "      #{bxTime,jdbcType=TIMESTAMP}, #{fxTime,jdbcType=TIMESTAMP}, #{jjxStatus,jdbcType=INTEGER}, \n" +
            "      #{bxStatus,jdbcType=INTEGER}, #{gzxx,jdbcType=VARCHAR}, #{zzStatus,jdbcType=INTEGER}, \n" +
            "      #{zzTime,jdbcType=TIMESTAMP})")
    public void addBaoxiu(FwBaoxiu fwBaoxiu);

    @Update("update fw_baoxiu set bx_status = #{baoxiuStatus} where id = #{fwId}")
    //@UpdateProvider(type = FwBaoxiuProvider.class)
    public void updateBaoxiuStatus(@Param("fwId") String fwId, @Param("baoxiuStatus") int baoxiuStatus);

    @SelectProvider(type = FwBaoxiuProvider.class,method = "listFwBaoxiu")
    public List<FwBaoxiu> findFwBaoxiuList();

    @Select("select * from fw_baoxiu where id = #{fwId}")
    public FwBaoxiu findFwBaoxiu(String fwId);

    @Select("select id from fw_baoxiu where bxr_id = userId")
    public List<String> findFwId(String userId);

    @Select("SELECT baoxiu.id,eq.eq_name,eq.eq_id,bm.bm_name,bm.obm_id,emp.user_xm,emp.user_id from fw_baoxiu baoxiu\n" +
            "INNER JOIN s_emp emp ON emp.user_id = #{userId}\n" +
            "INNER JOIN s_bm bm ON bm.obm_id = baoxiu.bxks_id\n" +
            "INNER JOIN eq_info eq ON eq.eq_id = baoxiu.eq_id \n" +
            "WHERE baoxiu.id = #{fwId}")
    public FwNameVo findFwNameVO(@Param("fwId") String fwId, @Param("userId") String userId);

    @Select("SELECT eq.eq_id,eq.eq_name,bm.obm_id,bm.bm_name,emp.user_id,emp.user_xm,bm.bm_tel,emp.tel \n" +
            "FROM dbo.eq_info AS eq, dbo.s_bm AS bm,dbo.s_emp AS emp \n" +
            "WHERE eq.eq_bmid = bm.obm_id AND eq.eq_id = #{eqId} AND emp.user_id = #{userId}")
    public FwBaoxiuIndexVo findBaoxiuIndexVo(@Param("eqId") String eqId,@Param("userId") String userId);
}
