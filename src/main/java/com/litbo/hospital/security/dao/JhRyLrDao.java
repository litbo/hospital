package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.JhRylr;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zjc
 * @create 2018-11-30 18:28
 */
@Mapper
public interface JhRyLrDao {

    @Insert(" insert into jh_rylr (jhlr_pxgw, jh_id, \n" +
            "      jhlr_cj, jhlr_sgzmc, jhlr_zjURL, \n" +
            "      sb_id, jhlr_fzdw, jhlr_fz_time, \n" +
            "      jhlr_yxq, emp_id)\n" +
            "    values (#{jhlrPxgw,jdbcType=VARCHAR}, #{jhId,jdbcType=INTEGER}, \n" +
            "      #{jhlrCj,jdbcType=DOUBLE}, #{jhlrSgzmc,jdbcType=VARCHAR}, #{jhlrZjurl,jdbcType=VARCHAR}, \n" +
            "      #{sbId,jdbcType=INTEGER}, #{jhlrFzdw,jdbcType=VARCHAR}, #{jhlrFzTime,jdbcType=TIMESTAMP}, \n" +
            "      #{jhlrYxq,jdbcType=TIMESTAMP}, #{empId,jdbcType=VARCHAR})")
    public void addJhRyLr(JhRylr jhRylr);

    @Delete("delete from jh_rylr where id = #{id}")
    public void deleteJhRyLr(int id);

    @Select("select * from jh_rylr where jh_id=#{jhId}")
    public List<JhRylr> getJhRyLrById(int jhId);

    @Select("select * from jh_rylr where emp_id=#{empId}")
    public List<JhRylr> getJhRyLrByEmpId(String empId);

}
