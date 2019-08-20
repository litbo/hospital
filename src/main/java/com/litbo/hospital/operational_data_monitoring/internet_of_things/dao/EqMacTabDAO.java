package com.litbo.hospital.operational_data_monitoring.internet_of_things.dao;

import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.EqMacVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.SearchVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.EqMacTab;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author looli
 * 设备联网表操作
 */
@Mapper
public interface EqMacTabDAO {
    /**保存设备联网信息*/
    @Insert("insert into eq_mac_tab (id, DeptID, EquID," +
            "MacID, MacIP, flag," +
            "hasPacs, hasWorkBox, MacRule," +
            "PMacID)" +
            "values (#{id,jdbcType=VARCHAR}, #{deptid,jdbcType=VARCHAR}, #{equid,jdbcType=VARCHAR}," +
            "#{macid,jdbcType=VARCHAR}, #{macip,jdbcType=VARCHAR}, #{flag,jdbcType=VARCHAR}," +
            "#{haspacs,jdbcType=VARCHAR}, #{hasworkbox,jdbcType=VARCHAR}, #{macrule,jdbcType=VARCHAR}," +
            "#{pmacid,jdbcType=VARCHAR})")
    void save(EqMacTab eqMac);

    /**查看所有设备联网设置表数据*/
    @Select("SELECT b.eq_sbbh,b.eq_name,b.eq_xh,b.eq_gg,a.MacID,a.MacIP " +
            "FROM eq_mac_tab a,eq_info b " +
            "WHERE a.EquID = b.eq_id")
    List<EqMacVO> selectAll();

    /**根据条件查看所有设备联网设置表数据*/
    @Select({
            "<script>",
            "SELECT\n" +
                    "b.eq_sbbh,\n" +
                    "b.eq_name,\n" +
                    "b.eq_xh,\n" +
                    "b.eq_gg,\n" +
                    "a.MacID,\n" +
                    "a.MacIP \n" +
                    "FROM\n" +
                    "eq_mac_tab a,\n" +
                    "eq_info b \n" +
                    "WHERE\n" +
                    "a.EquID = b.eq_id\n" +
                    "<if test='macid != null'> AND a.MacID = #{macid} </if>\n" +
                    "<if test='bmId != null'> AND a.DeptID = #{bmId} </if>\n" +
                    "<if test='eqSbbh != null'> AND b.eq_sbbh = #{eqSbbh} </if>",
            "</script>"
    })
    List<EqMacVO> selectAllBy(SearchVO searchVO);

    /**根据id删除*/
    @Delete("DELETE FROM eq_mac_tab where id = #{id}")
    void deleteById(String id);

    /**根据id批量删除*/
    @Delete({
            "<script>",
            "DELETE FROM eq_mac_tab where id in",
            "<foreach item='id' collection='list' open='(' separator=',' close=')'> #{id} </foreach>",
            "</script>"
    })
    void deleteByIds(List<String> ids);

    /**根据id查询*/
    @Select("SELECT b.eq_sbbh,b.eq_name,b.eq_xh,b.eq_gg,a.MacID,a.MacIP " +
            "FROM eq_mac_tab a,eq_info b " +
            "WHERE a.EquID = b.eq_id and a.id = #{id}")
    EqMacVO selectById(String id);

    /**根据id显示设备名称*/
    @Select("SELECT b.eq_name " +
            "FROM eq_mac_tab a,eq_info b " +
            "WHERE a.EquID = b.eq_id and a.id = #{id}")
    String selectEqNameById(String id);

    @Update("update eq_mac_tab " +
            " set " +
            "DeptID = #{deptid,jdbcType=VARCHAR}," +
            "EquID = #{equid,jdbcType=VARCHAR}," +
            "MacIP = #{macip,jdbcType=VARCHAR}," +
            "flag = #{flag,jdbcType=VARCHAR}," +
            "hasPacs = #{haspacs,jdbcType=VARCHAR}," +
            "hasWorkBox = #{hasworkbox,jdbcType=VARCHAR}," +
            "MacRule = #{macrule,jdbcType=VARCHAR}," +
            " PMacID = #{pmacid,jdbcType=VARCHAR} " +
            " where MacID = #{macid}")
    /**根据id更新*/
    void update(EqMacTab eqMacTab);
}