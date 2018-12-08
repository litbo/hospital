package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.FwPjzd;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FwPjzdDao {

    @Insert("INSERT INTO fw_pjzd(pjfl, pj_kw,  pj_scqy_id, pj_ghs_id, sb_id, pj_name, zb_time,"+
            " pj_ggxh,pj_bzdw, pj_zczh, pj_zcz_dq_time, pj_xg_time, pj_cj_time, pj_szm) "+
            "VALUES (  #{pjfl,jdbcType=VARCHAR}, #{pjKw,jdbcType=INTEGER}, " +
            "      #{pjScqyId,jdbcType=INTEGER}, #{pjGhsId,jdbcType=INTEGER}, #{sbId,jdbcType=INTEGER}, " +
            "      #{pjName,jdbcType=VARCHAR}, #{zbTime,jdbcType=TIMESTAMP}, #{pjGgxh,jdbcType=VARCHAR}," +
            "      #{pjBzdw,jdbcType=VARCHAR}, #{pjZczh,jdbcType=VARCHAR}, #{pjZczDqTime,jdbcType=TIMESTAMP}," +
            "      #{pjXgTime,jdbcType=TIMESTAMP}, #{pjCjTime,jdbcType=TIMESTAMP} ,#{pjSzm,jdbcType=VARCHAR} )")
    int insertPjzd(FwPjzd pjzd);


  //  @SelectProvider(type=com.litbo.hospital.security.dao.sqlprovider.FwPjzdSqlProvider.class,method="listFwPjzd")
  //  List<FwPjzd> listFwPjzd(@Param("pjSzm") String pjSzm,@Param("pjfl") String pjfl);
}
