package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.FwFk;
import com.litbo.hospital.security.bean.FwHt;
import com.litbo.hospital.security.vo.FwFkVo;
import com.litbo.hospital.security.vo.FwHtXqVo;
import com.litbo.hospital.security.vo.HtVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zjc
 * @create 2018-11-29 19:32
 */
@Mapper
public interface FwHtDao {

    @Update("update fw_ht set ht_status = #{status} where id = #{id}")
    public int updateHtStatus(@Param("id") String id, @Param("status") Integer status);

    @Insert("insert into fw_ht (id, ht_name, ht_time, \n" +
            "      ht_lx, ht_price, sbcs_id, \n" +
            "      he_wxsdb, ht_yfdb, ht_zffs, \n" +
            "      ht_jfly, ht_bxks_time, ht_bxjs_time, \n" +
            "      ht_xy_time, ht_bxfw, ht_hpjf, \n" +
            "      ht_fjURL, eq_id, ht_status, \n" +
            "      ht_ms)\n" +
            "    values (#{id,jdbcType=VARCHAR}, #{htName,jdbcType=VARCHAR}, #{htTime,jdbcType=TIMESTAMP}, \n" +
            "      #{htLx,jdbcType=VARCHAR}, #{htPrice,jdbcType=DECIMAL}, #{sbcsId,jdbcType=INTEGER}, \n" +
            "      #{heWxsdb,jdbcType=VARCHAR}, #{htYfdb,jdbcType=VARCHAR}, #{htZffs}, \n" +
            "      #{htJfly,jdbcType=VARCHAR}, #{htBxksTime,jdbcType=TIMESTAMP}, #{htBxjsTime,jdbcType=TIMESTAMP}, \n" +
            "      #{htXyTime,jdbcType=INTEGER}, #{htBxfw,jdbcType=VARCHAR}, #{htHpjf,jdbcType=INTEGER}, \n" +
            "      #{htFjurl,jdbcType=VARCHAR}, #{eqId,jdbcType=INTEGER}, #{htStatus,jdbcType=INTEGER}, \n" +
            "      #{htMs,jdbcType=LONGVARCHAR})")
    public int addFwHt(FwHt fwHt);

    @Insert("INSERT INTO fw_fk (fk_fs,fk_time,fk_fphm,fkrXm,fk_price,fk_htbh) " +
            "values (#{fkFs},#{fkTime},#{fkFphm},#{fkrXm},#{fkPrice},#{fkHtbh})")
    public int addFwFk(FwFk fwFk);

    /**
     *   合同查询
     */
    @Select("SELECT\n" +
            "ht.id,\n" +
            "ht.ht_name,\n" +
            "ht.ht_price,\n" +
            "ht.ht_time,\n" +
            "cs.sbcs_name,\n" +
            "ht.ht_status\n" +
            "\n" +
            "FROM\n" +
            "dbo.fw_ht AS ht ,\n" +
            "dbo.eq_cs AS cs\n" +
            "WHERE\n" +
            "ht.sbcs_id = cs.sbcs_id")
    public List<HtVo> getAllFwHt();

    @Select("SELECT\n" +
            "ht.id,\n" +
            "ht.ht_name,\n" +
            "ht.ht_price,\n" +
            "ht.ht_time,\n" +
            "ht.ht_zffs,\n" +
            "cs.sbcs_name\n" +
            "FROM\n" +
            "dbo.fw_ht AS ht ,\n" +
            "dbo.eq_cs AS cs\n" +
            "WHERE\n" +
            "ht.sbcs_id = cs.sbcs_id AND\n" +
            "ht.ht_status = 0")
    public List<HtVo> getFwHtByStatus(Integer htStatus);

    @Select("SELECT\n" +
            "dbo.fw_ht.id as fkHtbh,\n" +
            "dbo.fw_ht.ht_name,\n" +
            "dbo.fw_ht.ht_time,\n" +
            "dbo.fw_ht.ht_price\n" +
            "\n" +
            "FROM\n" +
            "dbo.fw_ht\n" +
            "WHERE\n" +
            "dbo.fw_ht.id = #{id}")
    public HtVo getFwHt(String id);

    @Select("SELECT\n" +
            "dbo.fw_ht.id as fkHtbh,\n" +
            "dbo.fw_ht.ht_name,\n" +
            "dbo.fw_ht.ht_time,\n" +
            "dbo.fw_ht.ht_price\n" +
            "\n" +
            "FROM\n" +
            "dbo.fw_ht\n" +
            "WHERE\n" +
            "dbo.fw_ht.id = #{id}")
    public FwHtXqVo getFwHtxq(String id);

    @Select("select count(*) FROM fw_fk fk where fk_htbh = #{htId}")
    public int findFkCountByHtId(String htId);

    @Select("select ht_zffs FROM fw_ht where id = #{htId}")
    public int findFkCs(String htId);

    @Select("SELECT\n" +
            "dbo.fw_fk.fkrXm,\n" +
            "dbo.fw_fk.fk_time,\n" +
            "dbo.fw_fk.fk_price,\n" +
            "dbo.fw_fk.fk_fs,\n" +
            "dbo.fw_fk.fk_fphm\n" +
            "\n" +
            "FROM\n" +
            "dbo.fw_fk\n" +
            "WHERE\n" +
            "dbo.fw_fk.fk_htbh = #{fpId}")
    public List<FwFkVo> findFkList(String fpId);

}
