package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.dao;

import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.EqDutyVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.SearchVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.EqDutyTab;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author looli
 * 设备值班表操作
 */
@Mapper
public interface EqDutyTabDAO {
    /**保存*/
    @Insert("insert into eq_duty_tab (id, eq_mac_id, DType, \n" +
            "W1, W2, W3, W4, \n" +
            "W5, W6, W7, am_w1, \n" +
            "am_w2, am_w3, am_w4, am_w5, \n" +
            "am_w6, am_w7, pm_w1, pm_w2, \n" +
            "pm_w3, pm_w4, pm_w5, pm_w6, \n" +
            "pm_w7, fm_w1, fm_w2, fm_w3, \n" +
            "fm_w4, fm_w5, fm_w6, fm_w7\n" +
            ")\n" +
            "values (#{id,jdbcType=VARCHAR}, #{eqMacId,jdbcType=VARCHAR}, #{dtype,jdbcType=VARCHAR}, \n" +
            "#{w1,jdbcType=VARCHAR}, #{w2,jdbcType=VARCHAR}, #{w3,jdbcType=VARCHAR}, #{w4,jdbcType=VARCHAR}, \n" +
            "#{w5,jdbcType=VARCHAR}, #{w6,jdbcType=VARCHAR}, #{w7,jdbcType=VARCHAR}, #{amW1,jdbcType=VARCHAR}, \n" +
            "#{amW2,jdbcType=VARCHAR}, #{amW3,jdbcType=VARCHAR}, #{amW4,jdbcType=VARCHAR}, #{amW5,jdbcType=VARCHAR}, \n" +
            "#{amW6,jdbcType=VARCHAR}, #{amW7,jdbcType=VARCHAR}, #{pmW1,jdbcType=VARCHAR}, #{pmW2,jdbcType=VARCHAR}, \n" +
            "#{pmW3,jdbcType=VARCHAR}, #{pmW4,jdbcType=VARCHAR}, #{pmW5,jdbcType=VARCHAR}, #{pmW6,jdbcType=VARCHAR}, \n" +
            "#{pmW7,jdbcType=VARCHAR}, #{fmW1,jdbcType=VARCHAR}, #{fmW2,jdbcType=VARCHAR}, #{fmW3,jdbcType=VARCHAR}, \n" +
            "#{fmW4,jdbcType=VARCHAR}, #{fmW5,jdbcType=VARCHAR}, #{fmW6,jdbcType=VARCHAR}, #{fmW7,jdbcType=VARCHAR}\n" +
            ")")
    void save(EqDutyTab eqDutyTab);

    /**查询所有设备值班情况*/
    @Select("SELECT\n" +
            "b.id,\n" +
            "d.eq_sbbh,\n" +
            "g.c_AName,\n" +
            "c.cDtypeName,\n" +
            "b.W1,\n" +
            "b.W2,\n" +
            "b.W3,\n" +
            "b.W4,\n" +
            "b.W5,\n" +
            "b.W6,\n" +
            "b.W7 \n" +
            "FROM\n" +
            "eq_mac_tab a,\n" +
            "eq_duty_tab b,\n" +
            "eq_duty_type c,\n" +
            "eq_info d,\n" +
            "eq_name e,\n" +
            "eq_sbjcfl f,\n" +
            "eq_jiancheng g\n" +
            "WHERE\n" +
            "a.id = b.eq_mac_id \n" +
            "AND b.DType = c.cDType \n" +
            "AND a.EquID = d.eq_id\n" +
            "AND d.eq_nid = e.id\n" +
            "AND e.c_BID = f.id\n" +
            "AND f.c_EquSimpleId = g.id\n")
    List<EqDutyVO> selectAll();

    /**根据条件筛选设备值班信息*/
    @Select({
            "<script>",
            "SELECT\n" +
                    "b.id,\n" +
                    "a.MacID as macId,\n" +
                    "d.eq_sbbh,\n" +
                    "g.c_AName,\n" +
                    "c.cDtypeName,\n" +
                    "b.W1,\n" +
                    "b.W2,\n" +
                    "b.W3,\n" +
                    "b.W4,\n" +
                    "b.W5,\n" +
                    "b.W6,\n" +
                    "b.W7 \n" +
                    "FROM\n" +
                    "eq_mac_tab a,\n" +
                    "eq_duty_tab b,\n" +
                    "eq_duty_type c,\n" +
                    "eq_info d,\n" +
                    "eq_name e,\n" +
                    "eq_sbjcfl f,\n" +
                    "eq_jiancheng g\n" +
                    "WHERE\n" +
                    "a.MacID = b.eq_mac_id \n" +
                    "AND b.DType = c.cDType \n" +
                    "AND a.EquID = d.eq_id\n" +
                    "AND d.eq_nid = e.id\n" +
                    "AND e.c_BID = f.id\n" +
                    "AND f.c_EquSimpleId = g.id\n",
                    "<if test='eqPym != null'> AND d.eq_pym = #{eqPym} </if>\n" +
                    "<if test='eqSbbh != null'> AND d.eq_sbbh = #{eqSbbh} </if>",
                    "<if test='bmId != null'> AND d.eq_bmid = #{bmId} </if>",
            "</script>"
    })
    List<EqDutyVO> selectAllBy(SearchVO searchVO);


    //根据id删除设备值班数据
    @Delete("DELETE FROM eq_duty_tab where eq_mac_id = #{id}")
    void delete(String id);
    //根据eqMacId删除设备值班数据
    @Delete("DELETE FROM eq_duty_tab where eq_mac_id = #{eqMacId}")
    void delete2(String eqMacId);
    //根据id删除设备值班数据
    @Delete({"<script>",
            "DELETE FROM eq_duty_tab where eq_mac_id in",
            "<foreach item='id' collection='array' open='(' separator=',' close=')'> #{id} </foreach>"
            ,"</script>"})
    void deletes(String[] ids);

    //根据id批量删除设备值班数据
    @Delete({
            "<script>",
            "DELETE FROM eq_duty_tab where id in",
            "<foreach item='id' collection='list' open='(' separator=',' close=')'> #{id} </foreach>",
            "</script>"
    })
    void deleteByIds(List<String> ids);

    //根据id查询
    @Select("SELECT\n" +
            "\tb.id,\n" +
            "a.MacID as macId,"+
            "\td.eq_sbbh,\n" +
            "\td.eq_name,\n" +
            "\td.eq_gg,\n" +
            "\td.eq_xh,\n" +
            "\tg.c_AName,\n" +
            "\tc.cDtypeName,\n" +
            "\tb.W1,\n" +
            "\tb.W2,\n" +
            "\tb.W3,\n" +
            "\tb.W4,\n" +
            "\tb.W5,\n" +
            "\tb.W6,\n" +
            "\tb.W7,\n" +
            "\tb.am_w1,\n" +
            "\tb.am_w2,\n" +
            "\tb.am_w3,\n" +
            "\tb.am_w4,\n" +
            "\tb.am_w5,\n" +
            "\tb.am_w6,\n" +
            "\tb.am_w7,\n" +
            "\tb.pm_w1,\n" +
            "\tb.pm_w2,\n" +
            "\tb.pm_w3,\n" +
            "\tb.pm_w4,\n" +
            "\tb.pm_w5,\n" +
            "\tb.pm_w6,\n" +
            "\tb.pm_w7,\n" +
            "\tb.fm_w1,\n" +
            "\tb.fm_w2,\n" +
            "\tb.fm_w3,\n" +
            "\tb.fm_w4,\n" +
            "\tb.fm_w5,\n" +
            "\tb.fm_w6,\n" +
            "\tb.fm_w7,\n" +
            "\ti.start_date,\n" +
            "\ti.start_time,\n" +
            "\ti.end_date,\n" +
            "\ti.end_time,\n" +
            "\th.work_days,\n" +
            "\th.rating_type,\n" +
            "\th.am_shift,\n" +
            "\th.pm_shift,\n" +
            "\th.fm_shift,\n" +
            "\th.full_load_time \n" +
            "FROM\n" +
            "\teq_mac_tab a,\n" +
            "\teq_duty_tab b,\n" +
            "\teq_duty_type c,\n" +
            "\teq_info d,\n" +
            "\teq_name e,\n" +
            "\teq_sbjcfl f,\n" +
            "\teq_jiancheng g,\n" +
            "\teq_overtime_tab i,\n" +
            "\tapproved_working_hours h \n" +
            "WHERE\n" +
            "\ta.MacID = b.eq_mac_id \n" +
            "\tAND b.DType = c.cDType \n" +
            "\tAND a.EquID = d.eq_id \n" +
            "\tAND d.eq_nid = e.id \n" +
            "\tAND e.c_BID = f.id \n" +
            "\tAND f.c_EquSimpleId = g.id \n" +
            "\tAND b.eq_mac_id = i.eq_mac_id \n" +
            "\tAND b.eq_mac_id = h.eq_mac_id \n" +
            "\tAND b.id\t=#{id}")
    EqDutyVO selectById(String id);

    //根据id修改
    @Update("update eq_duty_tab\n" +
                "set\n" +
                "DType = #{dtype,jdbcType=VARCHAR},\n" +
                "W1 = #{w1,jdbcType=VARCHAR},\n" +
                "W2 = #{w2,jdbcType=VARCHAR},\n" +
                "W3 = #{w3,jdbcType=VARCHAR},\n" +
                "W4 = #{w4,jdbcType=VARCHAR},\n" +
                "W5 = #{w5,jdbcType=VARCHAR},\n" +
                "W6 = #{w6,jdbcType=VARCHAR},\n" +
                "W7 = #{w7,jdbcType=VARCHAR},\n" +
                "am_w1 = #{amW1,jdbcType=VARCHAR},\n" +
                "am_w2 = #{amW2,jdbcType=VARCHAR},\n" +
                "am_w3 = #{amW3,jdbcType=VARCHAR},\n" +
                "am_w4 = #{amW4,jdbcType=VARCHAR},\n" +
                "am_w5 = #{amW5,jdbcType=VARCHAR},\n" +
                "am_w6 = #{amW6,jdbcType=VARCHAR},\n" +
                "am_w7 = #{amW7,jdbcType=VARCHAR},\n" +
                "pm_w1 = #{pmW1,jdbcType=VARCHAR},\n" +
                "pm_w2 = #{pmW2,jdbcType=VARCHAR},\n" +
                "pm_w3 = #{pmW3,jdbcType=VARCHAR},\n" +
                "pm_w4 = #{pmW4,jdbcType=VARCHAR},\n" +
                "pm_w5 = #{pmW5,jdbcType=VARCHAR},\n" +
                "pm_w6 = #{pmW6,jdbcType=VARCHAR},\n" +
                "pm_w7 = #{pmW7,jdbcType=VARCHAR},\n" +
                "fm_w1 = #{fmW1,jdbcType=VARCHAR},\n" +
                "fm_w2 = #{fmW2,jdbcType=VARCHAR},\n" +
                "fm_w3 = #{fmW3,jdbcType=VARCHAR},\n" +
                "fm_w4 = #{fmW4,jdbcType=VARCHAR},\n" +
                "fm_w5 = #{fmW5,jdbcType=VARCHAR},\n" +
                "fm_w6 = #{fmW6,jdbcType=VARCHAR},\n" +
                "fm_w7 = #{fmW7,jdbcType=VARCHAR}\n" +
                "where eq_mac_id = #{eqMacId}")
    void update(EqDutyTab eqDuty);


    //根据eq_mac_id修改修改
    @Update("update eq_duty_tab\n" +
            "set\n" +
            "DType = #{dtype,jdbcType=VARCHAR},\n" +
            "W1 = #{w1,jdbcType=VARCHAR},\n" +
            "W2 = #{w2,jdbcType=VARCHAR},\n" +
            "W3 = #{w3,jdbcType=VARCHAR},\n" +
            "W4 = #{w4,jdbcType=VARCHAR},\n" +
            "W5 = #{w5,jdbcType=VARCHAR},\n" +
            "W6 = #{w6,jdbcType=VARCHAR},\n" +
            "W7 = #{w7,jdbcType=VARCHAR},\n" +
            "am_w1 = #{amW1,jdbcType=VARCHAR},\n" +
            "am_w2 = #{amW2,jdbcType=VARCHAR},\n" +
            "am_w3 = #{amW3,jdbcType=VARCHAR},\n" +
            "am_w4 = #{amW4,jdbcType=VARCHAR},\n" +
            "am_w5 = #{amW5,jdbcType=VARCHAR},\n" +
            "am_w6 = #{amW6,jdbcType=VARCHAR},\n" +
            "am_w7 = #{amW7,jdbcType=VARCHAR},\n" +
            "pm_w1 = #{pmW1,jdbcType=VARCHAR},\n" +
            "pm_w2 = #{pmW2,jdbcType=VARCHAR},\n" +
            "pm_w3 = #{pmW3,jdbcType=VARCHAR},\n" +
            "pm_w4 = #{pmW4,jdbcType=VARCHAR},\n" +
            "pm_w5 = #{pmW5,jdbcType=VARCHAR},\n" +
            "pm_w6 = #{pmW6,jdbcType=VARCHAR},\n" +
            "pm_w7 = #{pmW7,jdbcType=VARCHAR},\n" +
            "fm_w1 = #{fmW1,jdbcType=VARCHAR},\n" +
            "fm_w2 = #{fmW2,jdbcType=VARCHAR},\n" +
            "fm_w3 = #{fmW3,jdbcType=VARCHAR},\n" +
            "fm_w4 = #{fmW4,jdbcType=VARCHAR},\n" +
            "fm_w5 = #{fmW5,jdbcType=VARCHAR},\n" +
            "fm_w6 = #{fmW6,jdbcType=VARCHAR},\n" +
            "fm_w7 = #{fmW7,jdbcType=VARCHAR}\n" +
            "where eq_mac_id = #{eqMacId}")
    void update2(EqDutyTab eqDuty);

}