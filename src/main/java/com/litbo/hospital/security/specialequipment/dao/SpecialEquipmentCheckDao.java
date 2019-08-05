package com.litbo.hospital.security.specialequipment.dao;


import com.litbo.hospital.security.specialequipment.bean.vo.SpecialEquipmentCheckVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SpecialEquipmentCheckDao {

    @Select("select bm_name from s_bm where bm_id = #{bmId}")
    String selectBmName(String bmId);

    //查询所有特种设备检测申请信息
    @Select("SELECT s.speq_id,s.speq_bh,s.speq_name,s.bm_id,s.speq_ggxh,s.speq_scs,s.speq_jhjcrq\n" +
            "FROM special_eq AS s\n" +
            "where speq_sjsq = 0\n" +
            "AND speq_run = 1\n" +
            "AND speq_sjsp = 0\n" +
            "ORDER BY speq_jhjcrq ASC")
    List<SpecialEquipmentCheckVo> selectSpecialEquipmentCheckVoBy0();
    //查询所有特种设备检测申请信息name 科室 生产商
    @Select("<script>SELECT s.speq_id,s.speq_bh,s.speq_name,s.bm_id,s.speq_ggxh,s.speq_scs,s.speq_jhjcrq\n" +
            "FROM special_eq AS s\n" +
            "WHERE 1 = 1\n" +
            "<if test=\"speqBh != null and speqBh !=''\">\n" +
            "and s.speq_bh like concat( '%', #{speqBh}, '%')\n" +
            "</if>\n" +
            "<if test=\"speqName != null and speqName !=''\">\n" +
            "and s.speq_name like concat( '%', #{speqName}, '%')\n" +
            "</if>\n" +
            "<if test=\"bmId != null and bmId !=''\">\n" +
            "and s.bm_id like concat( '%', #{bmId}, '%')\n" +
            "</if>\n" +
            "<if test=\"speqScs != null and speqScs !=''\">\n" +
            "and s.speq_scs like concat( '%', #{speqScs}, '%')\n" +
            "</if>\n" +
            "AND s.speq_sjsq = 0\n" +
            "AND speq_run = 1\n" +
            "AND speq_sjsp = 0\n" +
            "ORDER BY speq_jhjcrq ASC</script>")
    List<SpecialEquipmentCheckVo> selectSpecialEquipmentCheckVoByNameAndBmIdAndScsBy0(@Param("speqBh") String speqBh,
                                                                                      @Param("speqName") String speqName,
                                                                                      @Param("bmId") String bmId,
                                                                                      @Param("speqScs") String speqScs
    );
    //同意申请送检
    @Update("UPDATE special_eq SET speq_sjsqr = #{userXm}, speq_sjsq = 1,speq_sjsqsj = #{speqSjsqsj}\n" +
            "where special_eq.speq_id= #{speqId} ")
    int applicationForInspection(@Param("speqId") String speqId, @Param("speqSjsqsj") String speqSjsqsj, @Param("userXm") String userXm);



    //查询所有特种设备检测待审批信息
    @Select("SELECT s.speq_id,s.speq_bh,s.speq_name,s.bm_id,s.speq_ggxh,s.speq_scs,s.speq_jhjcrq\n" +
            "FROM special_eq AS s\n" +
            "where speq_sjsq = 1\n" +
            "AND speq_run = 1\n" +
            "AND speq_sjsp = 0\n" +
            "ORDER BY speq_jhjcrq ASC")
    List<SpecialEquipmentCheckVo> selectSpecialEquipmentCheckVoBy1();
    //查询所有特种设备检测待审批信息name 科室 生产商
    @Select("<script>SELECT s.speq_id,s.speq_bh,s.speq_name,s.bm_id,s.speq_ggxh,s.speq_scs,s.speq_jhjcrq\n" +
            "FROM special_eq AS s\n" +
            "WHERE 1 = 1\n" +
            "<if test=\"speqBh != null and speqBh !=''\">\n" +
            "and s.speq_bh like concat( '%', #{speqBh}, '%')\n" +
            "</if>\n" +
            "<if test=\"speqName != null and speqName !=''\">\n" +
            "and s.speq_name like concat( '%', #{speqName}, '%')\n" +
            "</if>\n" +
            "<if test=\"bmId != null and bmId !=''\">\n" +
            "and s.bm_id like concat( '%', #{bmId}, '%')\n" +
            "</if>\n" +
            "<if test=\"speqScs != null and speqScs !=''\">\n" +
            "and s.speq_scs like concat( '%', #{speqScs}, '%')\n" +
            "</if>\n" +
            "AND s.speq_sjsq = 1\n" +
            "AND speq_run = 1\n" +
            "AND speq_sjsp = 0\n" +
            "ORDER BY speq_jhjcrq ASC</script>")
    List<SpecialEquipmentCheckVo> selectSpecialEquipmentCheckVoByNameAndBmIdAndScsBy1(@Param("speqBh") String speqBh,
                                                                                      @Param("speqName") String speqName,
                                                                                      @Param("bmId") String bmId,
                                                                                      @Param("speqScs") String speqScs
    );
    //同意申请送检
    @Update("UPDATE special_eq SET speq_sjspr = #{userXm}, speq_sjsp = 1,speq_sjspsj = #{speqSjspsj}\n" +
            "where special_eq.speq_id= #{speqId} ")
    int applicationForApprove(@Param("speqId") String speqId, @Param("speqSjspsj") String speqSjspsj, @Param("userXm") String userXm);



    //查询所有特种设备待录入结果
    @Select("SELECT s.speq_id,s.speq_bh,s.speq_name,s.bm_id,s.speq_ggxh,s.speq_scs,s.speq_jhjcrq\n" +
            "FROM special_eq AS s\n" +
            "where speq_sjsq = 1\n" +
            "AND speq_run = 1\n" +
            "AND speq_sjsp = 1\n" +
            "ORDER BY speq_jhjcrq ASC")
    List<SpecialEquipmentCheckVo> selectSpecialEquipmentCheckVoBy2();
    //查询所有特种设备检测待录入结果根据bh name 科室 生产商
    @Select("<script>SELECT s.speq_id,s.speq_bh,s.speq_name,s.bm_id,s.speq_ggxh,s.speq_scs,s.speq_jhjcrq\n" +
            "FROM special_eq AS s\n" +
            "WHERE 1 = 1\n" +
            "<if test=\"speqBh != null and speqBh !=''\">\n" +
            "and s.speq_bh like concat( '%', #{speqBh}, '%')\n" +
            "</if>\n" +
            "<if test=\"speqName != null and speqName !=''\">\n" +
            "and s.speq_name like concat( '%', #{speqName}, '%')\n" +
            "</if>\n" +
            "<if test=\"bmId != null and bmId !=''\">\n" +
            "and s.bm_id like concat( '%', #{bmId}, '%')\n" +
            "</if>\n" +
            "<if test=\"speqScs != null and speqScs !=''\">\n" +
            "and s.speq_scs like concat( '%', #{speqScs}, '%')\n" +
            "</if>\n" +
            "AND s.speq_sjsq = 1\n" +
            "AND speq_run = 1\n" +
            "AND speq_sjsp = 1\n" +
            "ORDER BY speq_jhjcrq ASC</script>")
    List<SpecialEquipmentCheckVo> selectSpecialEquipmentCheckVoByNameAndBmIdAndScsBy2(@Param("speqBh") String speqBh,
                                                                                      @Param("speqName") String speqName,
                                                                                      @Param("bmId") String bmId,
                                                                                      @Param("speqScs") String speqScs
    );

    //特种设备结果录入第一步更改数据
    //特种设备结果录入第二步记录到记录表中
    @Insert("INSERT INTO special_eq_record(speq_jglrid) VALUES (#{speq_jglrid})")
    int insertSpeqRecordId(@Param("speq_jglrid") String speq_jglrid);
    @Update("UPDATE special_eq_record SET speq_bh = #{speq_bh},speq_jcsj = #{speq_jcsj} ," +
            "speq_jczbh = #{speq_jczbh},speq_sjsqr = #{speq_sjsqr},\n" +
            "speq_sjsqsj = #{speq_sjsqsj},speq_sjspr = #{speq_sjspr}," +
            "speq_sjspsj = #{speq_sjspsj},speq_run = #{speq_run}\n" +
            "WHERE special_eq_record.speq_jglrid = #{speq_jglrid} ")
    int updateSpeqRecordOther(@Param("speq_bh") String speq_bh, @Param("speq_jcsj") String speq_jcsj,
                              @Param("speq_jczbh") String speq_jczbh, @Param("speq_sjsqr") String speq_sjsqr,
                              @Param("speq_sjsqsj") String speq_sjsqsj, @Param("speq_sjspr") String speq_sjspr,
                              @Param("speq_sjspsj") String speq_sjspsj, @Param("speq_run") int speq_run,
                              @Param("speq_jglrid") String speq_jglrid);




}
