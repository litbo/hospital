package com.litbo.hospital.security.inspectionplan.dao;

import com.litbo.hospital.security.inspectionplan.bean.vo.FuchuUpVo;
import com.litbo.hospital.security.inspectionplan.bean.vo.InspEquipmentVo;
import com.litbo.hospital.security.inspectionplan.bean.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 巡检计划制定相关的功能Dao
 *
 * @author 10366 2019-08-03 17:55
 **/

public interface InspPlDrawUpDao {


    /**
     * 功能描述: 查询副处长以上的人员
     *
     * @Param:
     * @Return: List<FuchuUpVo>
     * @Author: ZYJ
     * @Date: 2019/8/3 0003 18:09
     */
    @Select("SELECT e.user_id, e.user_xm, r.role_name\n" +
            "FROM  s_emp AS e, s_user_role AS ur, s_role AS r\n" +
            "WHERE r.role_id = ur.role_id\n" +
            "AND ur.user_id = e.user_id\n" +
            "AND ur.role_id IN ('2','3','11','12','15','16')")
    @Mapper List<FuchuUpVo> selectFuchuVos();

    /**
     * 功能描述: 查询副处长以上的人员根据名字
     *
     * @Param: name
     * @Return: List<FuchuUpVo>
     * @Author: ZYJ
     * @Date: 2019/8/4 0004 8:48
     */
    @Select("<script>SELECT e.user_id, e.user_xm,r.role_name\n" +
            "FROM s_emp AS e, s_user_role AS ur, s_role AS r\n" +
            "WHERE 1 = 1 and r.role_id = ur.role_id\n" +
            "AND ur.user_id = e.user_id\n" +
            "AND ur.role_id IN ('2','3','11','12','15','16')\n" +
            "<if test=\"userXm != null and userXm !=''\">\n" +
            "and e.user_xm like concat( '%', #{userXm}, '%')\n" +
            "</if></script>")
    List<FuchuUpVo> selectFuchuVosByName(@Param(value = "userXm") String userXm);

    /**
     * 功能描述: 查询巡检计划制定人
     *
     * @Param:
     * @Return: List<UserVo>
     * @Author: ZYJ
     * @Date: 2019/8/4 0004 9:29
     */
    @Select("SELECT e.user_id, e.user_xm, b.bm_name\n" +
            "FROM s_bm AS b, s_emp AS e\n" +
            "WHERE e.bm_id = b.bm_id")
    List<UserVo> selectAllUser();

    /**
     * 功能描述: 查询巡检计划制定人条件查询
     *
     * @Param: userId userXm bmName
     * @Return: List<UserVo>
     * @Author: ZYJ
     * @Date: 2019/8/4 0004 9:34
     */
    @Select("<script>" +
            "SELECT e.user_id, e.user_xm, b.bm_name\n" +
            "FROM s_bm AS b, s_emp AS e\n" +
            "WHERE 1 = 1 and e.bm_id = b.bm_id\n" +
            "<if test=\"userId != null and userId !='' \">\n" +
            "and e.user_id like concat( '%', #{userId},'%')\n" +
            "</if>" +
            "<if test=\"userXm != null and userXm !='' \">\n" +
            "and e.user_xm like concat( '%', #{userXm},'%')\n" +
            "</if>" +
            "<if test=\"bmName != null and bmName !='' \">\n" +
            "and b.bm_name like concat( '%', #{bmName},'%')\n" +
            "</if>" +
            "</script>")
    List<UserVo> selectUserByUserVo(@Param("userId") String userId,
                                    @Param("userXm") String userXm,
                                    @Param("bmName") String bmName);

    /**
     * 功能描述: 查询所有在此计划未选中设备
     *
     * @Param:
     * @Return: List<InspEquipmentVo>
     * @Author: ZYJ
     * @Date: 2019/8/4 0004 10:18
     */
    @Select("SELECT eq.eq_sbbh, eq.eq_name, eq.eq_xh, b.bm_name\n" +
            "FROM eq_info AS eq, s_bm AS b\n" +
            "WHERE eq.eq_bmid = b.bm_id\n" +
            "AND eq.eq_pl_selection = '0'")
    List<InspEquipmentVo> selectAllNotSelectionEq();

    /**
     * 功能描述: 查询所有在此计划未选中设备根据eqVo
     *
     * @Param: eqsbbh eqname eqxh bmName
     * @Return: List<InspEquipmentVo>
     * @Author: ZYJ
     * @Date: 2019/8/5 0005 8:59
     */
    @Select("<script>SELECT eq.eq_sbbh, eq.eq_name, eq.eq_xh, b.bm_name\n" +
            "FROM eq_info AS eq, s_bm AS b\n" +
            "WHERE 1 = 1 and eq.eq_bmid = b.bm_id\n" +
            "AND eq.eq_pl_selection = '0'\n" +
            "<if test=\"eqSbbh != null and eqSbbh !='' \">\n" +
            "and eq.eq_sbbh like concat( '%', #{eqSbbh},'%')\n" +
            "</if>\n" +
            "<if test=\"eqName != null and eqName !='' \">\n" +
            "and eq.eq_name like concat( '%', #{eqName},'%')\n" +
            "</if>\n" +
            "<if test=\"eqXh != null and eqXh !='' \">\n" +
            "and eq.eq_xh like concat( '%', #{eqXh},'%')\n" +
            "</if>\n" +
            "<if test=\"bmName != null and bmName !='' \">\n" +
            "and b.bm_name like concat( '%', #{bmName},'%')\n" +
            "</if></script>")
    List<InspEquipmentVo> selectAllNotSelectionEqByEqVo(@Param("eqSbbh") String eqSbbh,
                                                        @Param("eqName") String eqName,
                                                        @Param("eqXh") String eqXh,
                                                        @Param("bmName") String bmName);


    /**
     * 功能描述: 查询所有在此计划选中设备
     *
     * @Param:
     * @Return: List<InspEquipmentVo>
     * @Author: ZYJ
     * @Date: 2019/8/4 0004 10:18
     */
    @Select("SELECT eq.eq_sbbh, eq.eq_name, eq.eq_xh, b.bm_name\n" +
            "FROM eq_info AS eq, s_bm AS b\n" +
            "WHERE eq.eq_bmid = b.bm_id\n" +
            "AND eq.eq_pl_selection = '1'")
    List<InspEquipmentVo> selectAllSelectionEq();

    /**
     * 功能描述: 查询所有在此计划选中设备根据eqVo
     *
     * @Param: eqsbbh eqname eqxh bmName
     * @Return: List<InspEquipmentVo>
     * @Author: ZYJ
     * @Date: 2019/8/5 0005 8:59
     */
    @Select("<script>SELECT eq.eq_sbbh, eq.eq_name, eq.eq_xh, b.bm_name\n" +
            "FROM eq_info AS eq, s_bm AS b\n" +
            "WHERE 1 = 1 and eq.eq_bmid = b.bm_id\n" +
            "AND eq.eq_pl_selection = '1'\n" +
            "<if test=\"eqSbbh != null and eqSbbh !='' \">\n" +
            "and eq.eq_sbbh like concat( '%', #{eqSbbh},'%')\n" +
            "</if>\n" +
            "<if test=\"eqName != null and eqName !='' \">\n" +
            "and eq.eq_name like concat( '%', #{eqName},'%')\n" +
            "</if>\n" +
            "<if test=\"eqXh != null and eqXh !='' \">\n" +
            "and eq.eq_xh like concat( '%', #{eqXh},'%')\n" +
            "</if>\n" +
            "<if test=\"bmName != null and bmName !='' \">\n" +
            "and b.bm_name like concat( '%', #{bmName},'%')\n" +
            "</if></script>")
    List<InspEquipmentVo> selectAllSelectionEqByEqVo(@Param("eqSbbh") String eqSbbh,
                                                     @Param("eqName") String eqName,
                                                     @Param("eqXh") String eqXh,
                                                     @Param("bmName") String bmName);
    /**
     * 功能描述: 巡检计划制定完成后清除选定的设备项
     *
     * @Param:
     * @Return: int
     * @Author: ZYJ
     * @Date: 2019/8/5 0005 14:15
     */
    @Update("UPDATE eq_info\n" +
            "SET eq_pl_selection = '0'\n" +
            "WHERE eq_pl_selection = '1'")
    int updateSelectionToZero();

    @Update("update eq_info set\n" +
            "eq_pl_selection = 1\n" +
            "where eq_sbbh = #{eqSbbh}")
    int updateEqInfo(@Param("eqSbbh") String eqSbbh);
    @Update("update eq_info set\n" +
            "eq_pl_selection = 0\n" +
            "where eq_sbbh = #{eqSbbh}")
    int updateEqInfo1(@Param("eqSbbh") String eqSbbh);

}
