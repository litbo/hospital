package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.FwBaoxiu;
import com.litbo.hospital.security.dao.sqlprovider.FwBaoxiuProvider;
import com.litbo.hospital.security.vo.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zjc
 * @create 2018-12-03 10:54
 */
@Mapper
public interface FwBaoxiuDao {

    @Select("select bx.id AS fwId,eq_name,bx_time from fw_baoxiu AS bx,eq_info as eq where  eq.eq_id = bx.eq_id" +
            " and bx.bxr_id = #{userId}")
    public FwBxLcVo bxlc(String userId);

    //bx.id AS fwId,eq_name,bx_time,bx.jjx_status,bx.bx_status

    @SelectProvider(type = FwBaoxiuProvider.class,method = "bxlcTableList")
    public List<FwBxLcTableVo> bxlcTableList(@Param("userId") String userId,@Param("ksTime") String ksTime,@Param("jsTime") String jsTime,
                                             @Param("eqName") String eqName,@Param("bxStatus") Integer bxStatus);

    @Select("SELECT user_id FROM  s_role AS role , s_user_role AS ur WHERE\n" +
            "role.role_name LIKE '设备%处长' AND\n" +
            "role.role_id = ur.role_id")
    public List<String> shrList();

    @Select("select bxr_id from fw_baoxiu where id=#{id}")
    public String findBxrIdByFwId(String id);

    @Select("select eq.eq_name from fw_baoxiu as bx,eq_info eq where bx.eq_id = eq.eq_id and bx.id=#{id}")
    public String findEqNameByFwId(String id);

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
    public int updateBaoxiuStatus(@Param("fwId") String fwId, @Param("baoxiuStatus") int baoxiuStatus);

    @SelectProvider(type = FwBaoxiuProvider.class,method = "listFwBaoxiu")
    public List<FwBaoxiu> findFwBaoxiuList();

    @Select("select * from fw_baoxiu where id = #{fwId}")
    public FwBaoxiu findFwBaoxiu(String fwId);

    @Select("select id from fw_baoxiu where bxr_id = userId")
    public List<String> findFwId(String userId);

    @Select("SELECT baoxiu.id,eq.eq_name,eq.eq_id,bm.bm_name,bm.bm_id,emp.user_xm,emp.user_id from fw_baoxiu baoxiu\n" +
            "INNER JOIN s_emp emp ON emp.user_id = #{userId}\n" +
            "INNER JOIN s_bm bm ON bm.bm_id = baoxiu.bxks_id\n" +
            "INNER JOIN eq_info eq ON eq.eq_id = baoxiu.eq_id \n" +
            "WHERE baoxiu.id = #{fwId}")
    public FwNameVo findFwNameVO(@Param("fwId") String fwId, @Param("userId") String userId);

    @Select("SELECT eq.eq_id,eq.eq_name,bm.bm_id as bxksId,bm.bm_name,emp.user_id as bxrId,emp.user_xm,bm.bm_tel as bxksdh,emp.tel as bxrdh \n" +
            "FROM dbo.eq_info AS eq, dbo.s_bm AS bm,dbo.s_emp AS emp \n" +
            "WHERE eq.eq_bmid = bm.bm_id AND eq.eq_id = #{eqId} AND emp.user_id = #{userId}")
    public FwBaoxiuIndexVo findBaoxiuIndexVo(@Param("eqId") String eqId,@Param("userId") String userId);

    @Select("select eq_syzt from eq_info where eq_id = #{eqId}")
    public String eqStatusByEqId(String eqId);

    @Select("SELECT\n" +
            "bm.bm_name,\n" +
            "eq.eq_name,\n" +
            "emp.user_xm,\n" +
            "baoxiu.bx_time,\n" +
            "baoxiu.jjx_status,\n" +
            "eq.eq_id,baoxiu.bx_status,\n" +
            "baoxiu.id AS fw_id\n" +
            "\n" +
            "FROM\n" +
            "dbo.s_wxbm_gcs_eq AS gcs ,\n" +
            "dbo.fw_baoxiu AS baoxiu ,\n" +
            "dbo.s_bm AS bm ,\n" +
            "dbo.eq_info AS eq ,\n" +
            "dbo.s_emp AS emp\n" +
            "WHERE\n" +
            "gcs.eq_id = baoxiu.eq_id AND\n" +
            "baoxiu.bxks_id = bm.bm_id AND\n" +
            "baoxiu.eq_id = eq.eq_id AND\n" +
            "baoxiu.bxr_id = emp.user_id AND\n" +
            "gcs.user_id = #{userId} and baoxiu.bx_status = #{status}\n")
    public List<BaoXiuRw> findBaoxiuRw(@Param("userId") String userId,@Param("status") Integer status);

    /*@Select("SELECT\n" +
            "bm.bm_name,eq.eq_id,\n" +
            "eq.eq_name,\n" +
            "eq.eq_sbbh,\n" +
            "eq.eq_zcbh,\n" +
            "eq.eq_xh,\n" +
            "eq.eq_gg,\n" +
            "eq.eq_qysj\n" +
            "\n" +
            "FROM\n" +
            "dbo.eq_info AS eq ,\n" +
            "dbo.s_bm AS bm ,\n" +
            "dbo.s_emp AS emp\n" +
            "WHERE\n" +
            "eq.eq_bmid = bm.bm_id AND\n" +
            "bm.bm_id = emp.bm_id AND\n" +
            "emp.user_id = #{userId}")*/
    @SelectProvider(type = FwBaoxiuProvider.class,method = "findBaoxiuEq")
    public List<BaoxiuEqVo> findBaoxiuEq(@Param("userId") String userId,@Param("bmName") String bmName,@Param("eqName") String eqName);
    @SelectProvider(type = FwBaoxiuProvider.class,method = "listFwBaoxiuVo")
    List<ListFwBaoxiuVo> listFwBaoxiuVo(Integer status);

    @Update("update eq_info set eq_syzt = '维修' where eq_id = #{eqId}")
    public void updateEqStatus(String eqId);

    @Update("update eq_info set eq_syzt = '在用' where eq_id = #{eqId}")
    public void updateEqStatussy(String eqId);

    @Select("SELECT COUNT(eq_id) FROM fw_baoxiu WHERE bx_status = #{status}")
    public int selectCountByStatus(Integer status);

    @Select("SELECT COUNT(eq_id) FROM fw_baoxiu")
    public int selectCount();

    @Select("SELECT COUNT(eq_id) FROM fw_baoxiu WHERE bx_status != 100 AND jjx_status = #{status}")
    public int selectJjxCount(Integer status);

    @Select("SELECT\n" +
            "bm.bm_name,\n" +
            "eq.eq_name,\n" +
            "bx.gzxx,\n" +
            "bx.bx_time,\n" +
            "emp.user_xm zxrName,\n" +
            "bx.jjx_status,\n" +
            "bx.bx_status\n" +
            "FROM\n" +
            "dbo.fw_baoxiu AS bx \n" +
            "LEFT JOIN dbo.s_bm AS bm ON bx.bxks_id = bm.bm_id\n" +
            "LEFT JOIN dbo.eq_info AS eq ON eq.eq_id = bx.eq_id\n" +
            "LEFT JOIN fw_shouli AS sl ON bx.id = sl.id\n" +
            "LEFT JOIN s_emp AS emp ON emp.user_id = sl.slr_id\n" +
            "WHERE\n" +
            "bx.bx_status != 100")
    public List<wxInfoListVo> selectWxInfo();

}
