package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.JhRylr;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * @author zjc
 * @create 2018-11-30 18:28
 */
@Mapper
public interface JhRyLrDao {

    @Insert("insert into jh_rylr (jhlr_pxgw, jh_id, \n" +
            "      jhlr_cj, jhlr_sgzmc, jhlr_zjURL, \n" +
            "      sb_id, jhlr_fzdw, jhlr_fz_time, \n" +
            "      jhlr_yxq)\n" +
            "    values (#{jhlrPxgw,jdbcType=VARCHAR}, #{jhId,jdbcType=INTEGER}, \n" +
            "      #{jhlrCj,jdbcType=DOUBLE}, #{jhlrSgzmc,jdbcType=VARCHAR}, #{jhlrZjurl,jdbcType=VARCHAR}, \n" +
            "      #{sbId,jdbcType=INTEGER}, #{jhlrFzdw,jdbcType=VARCHAR}, #{jhlrFzTime,jdbcType=TIMESTAMP}, \n" +
            "      #{jhlrYxq,jdbcType=TIMESTAMP})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    public int addJhRyLr(JhRylr jhRylr);

}
