package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.FwHt;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zjc
 * @create 2018-11-29 19:32
 */
@Mapper
public interface FwHtDao {

    @Insert("insert into fw_ht (id, ht_name, ht_time, \n" +
            "      ht_lx, ht_price, wxs_id, \n" +
            "      he_wxsdb, ht_yfdb, ht_zffs, \n" +
            "      ht_jfly, ht_bxks_time, ht_bxjs_time, \n" +
            "      ht_xy_time, ht_bxfw, ht_hpjf, \n" +
            "      ht_fjURL, sb_id, ht_status, \n" +
            "      ht_ms)\n" +
            "    values (#{id,jdbcType=VARCHAR}, #{htName,jdbcType=VARCHAR}, #{htTime,jdbcType=TIMESTAMP}, \n" +
            "      #{htLx,jdbcType=VARCHAR}, #{htPrice,jdbcType=DECIMAL}, #{wxsId,jdbcType=INTEGER}, \n" +
            "      #{heWxsdb,jdbcType=VARCHAR}, #{htYfdb,jdbcType=VARCHAR}, #{htZffs,jdbcType=VARCHAR}, \n" +
            "      #{htJfly,jdbcType=VARCHAR}, #{htBxksTime,jdbcType=TIMESTAMP}, #{htBxjsTime,jdbcType=TIMESTAMP}, \n" +
            "      #{htXyTime,jdbcType=TIMESTAMP}, #{htBxfw,jdbcType=VARCHAR}, #{htHpjf,jdbcType=INTEGER}, \n" +
            "      #{htFjurl,jdbcType=VARCHAR}, #{sbId,jdbcType=INTEGER}, #{htStatus,jdbcType=INTEGER}, \n" +
            "      #{htMs,jdbcType=LONGVARCHAR})")
    public int addFwHt(FwHt fwHt);

    @Select("select * from fw_ht")
    public List<FwHt> getAllFwHt();

}
