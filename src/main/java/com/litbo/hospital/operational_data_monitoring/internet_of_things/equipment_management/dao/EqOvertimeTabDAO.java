package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.dao;


import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.EqOvertimeVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.SearchVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.EqOvertimeTab;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 设备加班操作
 */
@Mapper
public interface EqOvertimeTabDAO {
    /**
     * 保存信息
     * @param eqOvertime
     */
    @Insert("insert into eq_overtime_tab (id, eq_mac_id, start_date, \n" +
            "end_date, start_time, end_time\n" +
            ")\n" +
            "values (#{id,jdbcType=VARCHAR}, #{eqMacId,jdbcType=VARCHAR}, #{startDate,jdbcType=TIMESTAMP}, \n" +
            "#{endDate,jdbcType=TIMESTAMP}, #{startTime,jdbcType=VARCHAR}, #{endTime,jdbcType=VARCHAR}\n" +
            ")")
    void save(EqOvertimeTab eqOvertime);

    /**
     * 查询所有
     * @return
     */
    @Select("SELECT\n" +
            "a.id,\n" +
            "d.eq_sbbh,\n" +
            "g.c_AName,\n" +
            "a.start_date,\n" +
            "a.end_date,\n" +
            "a.start_time,\n" +
            "a.end_time \n" +
            "FROM\n" +
            "eq_overtime_tab a,\n" +
            "eq_mac_tab b,\n" +
            "eq_info d,\n" +
            "eq_name e,\n" +
            "eq_sbjcfl f,\n" +
            "eq_jiancheng g \n" +
            "WHERE\n" +
            "a.eq_mac_id = b.id \n" +
            "AND b.equid = d.eq_id\n" +
            "AND d.eq_nid = e.id \n" +
            "AND e.c_BID = f.id \n" +
            "AND f.c_EquSimpleId = g.id")
    List<EqOvertimeVO> selectAll();

    @Select({
            "<script>",
            "SELECT\n" +
                    "a.id,\n" +
                    "d.eq_sbbh,\n" +
                    "g.c_AName,\n" +
                    "a.start_date,\n" +
                    "a.end_date,\n" +
                    "a.start_time,\n" +
                    "a.end_time \n" +
                    "FROM\n" +
                    "eq_overtime_tab a,\n" +
                    "eq_mac_tab b,\n" +
                    "eq_info d,\n" +
                    "eq_name e,\n" +
                    "eq_sbjcfl f,\n" +
                    "eq_jiancheng g \n" +
                    "WHERE\n" +
                    "a.eq_mac_id = b.id \n" +
                    "AND b.equid = d.eq_id\n" +
                    "AND d.eq_nid = e.id \n" +
                    "AND e.c_BID = f.id \n" +
                    "AND f.c_EquSimpleId = g.id",
                    "<if test='eqPym != null'> AND d.eq_pym = #{eqPym} </if>\n" +
                    "<if test='eqSbbh != null'> AND d.eq_sbbh = #{eqSbbh} </if>",
            "</script>"
    })
    List<EqOvertimeVO> selectAllBy(SearchVO searchVO);

    /**根据id查询*/
    @Select("SELECT\n" +
            "a.id,\n" +
            "d.eq_name,\n" +
            "d.eq_sbbh,\n" +
            "g.c_AName,\n" +
            "a.start_date,\n" +
            "a.end_date,\n" +
            "a.start_time,\n" +
            "a.end_time \n" +
            "FROM\n" +
            "eq_overtime_tab a,\n" +
            "eq_mac_tab b,\n" +
            "eq_info d,\n" +
            "eq_name e,\n" +
            "eq_sbjcfl f,\n" +
            "eq_jiancheng g \n" +
            "WHERE\n" +
            "a.eq_mac_id = b.id \n" +
            "AND b.equid = d.eq_id\n" +
            "AND d.eq_nid = e.id \n" +
            "AND e.c_BID = f.id \n" +
            "AND f.c_EquSimpleId = g.id \n" +
            "AND a.id = #{id}")
    EqOvertimeVO selectById(String id);

    /**根据id删除加班信息*/
    @Delete("DELETE FROM eq_overtime_tab WHERE eq_mac_id = #{id}")
    void delete(@Param("id") String id);
    /**根据id删除 批量删除*/
    @Delete({
            "<script>",
            "DELETE FROM eq_overtime_tab WHERE id in",
            "<foreach item='id' collection='list' open='(' separator=',' close=')'> #{id} </foreach>",
            "</script>"
    })
    void deletes(List<String> ids);

    @Delete({"<script>",
            "DELETE FROM eq_overtime_tab where eq_mac_id in",
            "<foreach item='id' collection='array' open='(' separator=',' close=')'> #{id} </foreach>"
            ,"</script>"})
    void deletes2(String[] ids);
    /**根据id修改*/
    @Update("update eq_overtime_tab\n" +
            "set\n" +
            "start_date = #{startDate,jdbcType=TIMESTAMP},\n" +
            "end_date = #{endDate,jdbcType=TIMESTAMP},\n" +
            "start_time = #{startTime,jdbcType=VARCHAR},\n" +
            "end_time = #{endTime,jdbcType=VARCHAR}\n" +
            "where eq_mac_id = #{eqMacId}")
    void update(EqOvertimeTab eqOvertime);

    /**根据id修改*/
    @Update("update eq_overtime_tab\n" +
            "set\n" +
            "start_date = #{startDate,jdbcType=TIMESTAMP},\n" +
            "end_date = #{endDate,jdbcType=TIMESTAMP},\n" +
            "start_time = #{startTime,jdbcType=VARCHAR},\n" +
            "end_time = #{endTime,jdbcType=VARCHAR}\n" +
            "where eq_mac_id = #{eqMacId}")
    void update2(EqOvertimeVO eqOvertime);

}