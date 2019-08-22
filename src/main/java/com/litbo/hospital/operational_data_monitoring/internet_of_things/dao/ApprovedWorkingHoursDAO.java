package com.litbo.hospital.operational_data_monitoring.internet_of_things.dao;

import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.ApprovedWorkingHoursVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.SearchVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.ApprovedWorkingHours;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author looli
 * 核定工时设置
 */
@Mapper
public interface ApprovedWorkingHoursDAO {
    /**初始保存操作*/
    @Insert("INSERT INTO [hospital].[dbo].[approved_working_hours] " +
            "(id,eq_mac_id,rating_type,work_days, am_shift,pm_shift,fm_shift,full_load_time)\n" +
            "values " +
            "(#{id}, #{eqMacId},#{ratingType},#{workDays}, #{amShift}, #{pmShift},#{fmShift}, #{fullLoadTime})")
    void save(ApprovedWorkingHours approvedWorkingHours);

    /**查询所有*/
    @Select("SELECT\n" +
            "d.eq_sbbh,\n" +
            "g.c_AName,\n" +
            "a.rating_type,\n" +
            "a.am_shift,\n" +
            "a.pm_shift,\n" +
            "a.fm_shift \n" +
            "FROM\n" +
            "approved_working_hours a,\n" +
            "eq_mac_tab b,\n" +
            "eq_info d,\n" +
            "eq_name e,\n" +
            "eq_sbjcfl f,\n" +
            "eq_jiancheng g \n" +
            "WHERE\n" +
            "a.eq_mac_id = b.id \n" +
            "AND b.EquID = d.eq_id \n" +
            "AND d.eq_nid = e.id \n" +
            "AND e.c_BID = f.id \n" +
            "AND f.c_EquSimpleId = g.id ")
    List<ApprovedWorkingHoursVO> selectAll();

    /**
     * 根据条件查询
     * @param searchVO
     * @return
     */
    @Select({
            "<script>",
            "SELECT\n" +
                    "d.eq_sbbh,\n" +
                    "g.c_AName,\n" +
                    "a.rating_type,\n" +
                    "a.am_shift,\n" +
                    "a.pm_shift,\n" +
                    "a.fm_shift \n" +
                    "FROM\n" +
                    "approved_working_hours a,\n" +
                    "eq_mac_tab b,\n" +
                    "eq_info d,\n" +
                    "eq_name e,\n" +
                    "eq_sbjcfl f,\n" +
                    "eq_jiancheng g \n" +
                    "WHERE\n" +
                    "a.eq_mac_id = b.id \n" +
                    "AND b.EquID = d.eq_id \n" +
                    "AND d.eq_nid = e.id \n" +
                    "AND e.c_BID = f.id \n" +
                    "AND f.c_EquSimpleId = g.id ",
                    "<if test='eqPym != null'> AND d.eq_pym = #{eqPym} </if>\n" +
                    "<if test='eqSbbh != null'> AND d.eq_sbbh = #{eqSbbh} </if>",
            "</script>"
    })
    List<ApprovedWorkingHoursVO> selectAllBy(SearchVO searchVO);

    /**根据id删除*/
    @Delete("DELETE FROM approved_working_hours WHERE eq_mac_id = #{id}")
    void delete(String id);
    @Delete({"<script>",
            "DELETE FROM approved_working_hours where eq_mac_id in",
            "<foreach item='id' collection='array' open='(' separator=',' close=')'> #{id} </foreach>"
            ,"</script>"})
    void deletes(String[] ids);
    /**批量删除*/
    @Delete({
            "<script>",
            "DELETE FROM approved_working_hours WHERE id in",
            "<foreach item='id' collection='list' open='(' separator=',' close=')'> #{id} </foreach>",
            "</script>"
    })
    void deleteByIds(List<String> ids);

    /**根据id查询*/
    @Select("SELECT\n" +
            "d.eq_name,\n" +
            "a.id,\n" +
            "a.eq_mac_id,\n" +
            "a.work_days,\n" +
            "a.rating_type,\n" +
            "a.am_shift,\n" +
            "a.pm_shift,\n" +
            "a.fm_shift,\n" +
            "a.full_load_time\n" +
            "FROM\n" +
            "approved_working_hours a,\n" +
            "eq_mac_tab b,\n" +
            "eq_info d,\n" +
            "eq_name e,\n" +
            "eq_sbjcfl f,\n" +
            "eq_jiancheng g \n" +
            "WHERE\n" +
            "a.eq_mac_id = b.id \n" +
            "AND b.EquID = d.eq_id \n" +
            "AND d.eq_nid = e.id \n" +
            "AND e.c_BID = f.id \n" +
            "AND f.c_EquSimpleId = g.id \n" +
            "AND a.id = #{id}")
    ApprovedWorkingHoursVO selectById(String id);

    /**根据id修改*/
    @Update("update approved_working_hours\n" +
            "set\n" +
            "rating_type = #{ratingType,jdbcType=VARCHAR},\n" +
            "work_days = #{workDays,jdbcType=VARCHAR},\n" +
            "am_shift = #{amShift,jdbcType=VARCHAR},\n" +
            "pm_shift = #{pmShift,jdbcType=VARCHAR},\n" +
            "fm_shift = #{fmShift,jdbcType=VARCHAR},\n" +
            "full_load_time = #{fullLoadTime,jdbcType=VARCHAR}\n " +
            "where eq_mac_id = #{eqMacId}")
    void update(ApprovedWorkingHours approvedWorkingHours);

    /**根据eq_mac_id修改*/
    @Update("update approved_working_hours\n" +
            "set\n" +
            "rating_type = #{ratingType,jdbcType=VARCHAR},\n" +
            "work_days = #{workDays,jdbcType=VARCHAR},\n" +
            "am_shift = #{amShift,jdbcType=VARCHAR},\n" +
            "pm_shift = #{pmShift,jdbcType=VARCHAR},\n" +
            "fm_shift = #{fmShift,jdbcType=VARCHAR},\n" +
            "full_load_time = #{fullLoadTime,jdbcType=VARCHAR}" +
            " where eq_mac_id = #{eqMacId}")
    void update2(ApprovedWorkingHours approvedWorkingHours);
}