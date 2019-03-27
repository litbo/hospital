package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.JhRylr;
import com.litbo.hospital.security.vo.JhEmp;
import org.apache.ibatis.annotations.*;

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

    @Select("select * from jh_rylr where emp_id=#{empId} and jh_id = #{jhId}")
    public List<JhRylr> getJhRyLrByEmpIdAndJhId(@Param("empId") String empId ,@Param("jhId") Integer jhId);

    @Select("SELECT\n" +
            "emp.user_id,\n" +
            "emp.user_xm,\n" +
            "ry.jhlr_cj\n" +
            "FROM\n" +
            "dbo.jh_rylr AS ry ,\n" +
            "dbo.s_emp AS emp\n" +
            "WHERE\n" +
            "ry.emp_id = emp.user_id AND\n" +
            "ry.jh_id = #{jhId}")
    public List<JhEmp> findEmpByJhId(Integer jhId);

    @Update("update jh_rylr set jhlr_cj = #{cj} where emp_id = #{userId} and jh_id = #{jhId}")
    public int updateCj(@Param("userId") String userId,@Param("cj")Float cj,@Param("jhId")Integer jhId);

}
