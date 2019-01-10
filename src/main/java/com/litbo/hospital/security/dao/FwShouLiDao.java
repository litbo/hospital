package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.FwShouli;
import com.litbo.hospital.security.vo.BaoXiuRw;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zjc
 * @create 2018-12-05 17:03
 */
@Mapper
public interface FwShouLiDao {


    @Insert("insert into fw_shouli (id, xy_status, gztj_status, \n" +
            "      sl_time, wxfs, slr_id, \n" +
            "      ydwx_time, sl_bz)\n" +
            "    values (#{id,jdbcType=VARCHAR}, #{xyStatus,jdbcType=INTEGER}, #{gztjStatus,jdbcType=INTEGER}, \n" +
            "      #{slTime,jdbcType=TIMESTAMP}, #{wxfs,jdbcType=VARCHAR}, #{slrId,jdbcType=VARCHAR}, \n" +
            "      #{ydwxTime,jdbcType=TIMESTAMP}, #{slBz,jdbcType=LONGVARCHAR})")
    public void addShouLi(FwShouli fwShouli);

    @Select("select * from fw_shouli where id = #{fwId}")
    public FwShouli findShouli(String fwId);

    @Select("select id from fw_shouli where slr_id = #{userId}")
    public List<String> findFwId(String userId);

    @Select("SELECT\n" +
            "bm.bm_name,\n" +
            "eq.eq_name,\n" +
            "emp.user_xm,\n" +
            "baoxiu.bx_time,\n" +
            "baoxiu.jjx_status,\n" +
            "eq.eq_id,\n" +
            "baoxiu.bx_status,\n" +
            "baoxiu.id AS fw_id\n" +
            "\n" +
            "FROM\n" +
            "dbo.eq_info AS eq ,\n" +
            "dbo.fw_baoxiu AS baoxiu ,\n" +
            "dbo.fw_shouli AS shouli ,\n" +
            "dbo.s_bm AS bm ,\n" +
            "dbo.s_emp AS emp\n" +
            "WHERE\n" +
            "baoxiu.id = shouli.id AND\n" +
            "eq.eq_id = baoxiu.eq_id AND\n" +
            "baoxiu.bxks_id = bm.bm_id AND\n" +
            "baoxiu.bxr_id = emp.user_id AND\n" +
            "shouli.slr_id = #{userId} AND\n" +
            "baoxiu.bx_status in (4,5,10,12,44)")
    public List<BaoXiuRw> findBaoxiuRw(String userId);
}