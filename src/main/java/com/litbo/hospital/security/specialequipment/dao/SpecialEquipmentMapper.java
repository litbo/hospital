package com.litbo.hospital.security.specialequipment.dao;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.specialequipment.bean.SpecialEquipment;
import com.litbo.hospital.security.specialequipment.bean.SpecialEquipmentExample;

import java.security.Provider;
import java.util.List;

import com.litbo.hospital.security.specialequipment.bean.SpecialEquipmentRecord;
import com.litbo.hospital.security.specialequipment.bean.vo.*;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SpecialEquipmentMapper {

    long countByExample(SpecialEquipmentExample example);

    int deleteByExample(SpecialEquipmentExample example);

    int deleteByPrimaryKey(String speqId);

    int insert(SpecialEquipment record);

    int insertSelective(SpecialEquipment record);

    List<SpecialEquipment> selectByExample(SpecialEquipmentExample example);

    SpecialEquipment selectByPrimaryKey(String speqId);

    int updateByExampleSelective(@Param("record") SpecialEquipment record, @Param("example") SpecialEquipmentExample example);

    int updateByExample(@Param("record") SpecialEquipment record, @Param("example") SpecialEquipmentExample example);

    int updateByPrimaryKeySelective(SpecialEquipment record);

    int updateByPrimaryKey(SpecialEquipment record);

    //查询所有部门信息
    @Select("select e.bm_id,b.bm_name,b.bm_tel,e.user_xm,e.tel FROM s_emp AS e,s_bm as b WHERE b.user_id = e.user_id")
    List<SpEqBmInfoVo> selectSpEqBmInfo();
    //查询部门信息根据部门名称
    @Select("select e.bm_id,b.bm_name,b.bm_tel,e.user_xm,e.tel \n" +
            "FROM s_emp AS e,s_bm as b \n" +
            "WHERE b.user_id = e.user_id \n" +
            "and b.bm_name LIKE '%'+#{bmName}+'%' ")
    List<SpEqBmInfoVo> selectSpEqBmInfoByName(String bmName);



    //查询特种设备信息Vo
    @Select("SELECT s.speq_id,s.speq_bh,s.speq_name, s.speq_ggxh, s.speq_type,s.speq_scs,s.bm_id, s.speq_bz,s.speq_spare1, s.speq_run\n" +
            "FROM special_eq AS s")
    List<SpecialEquipmentInfoVo> selectSpeqVo();

    //查询特种设备信息Vo根据设备id name 类型 生产商 科室名称
    @Select("<script>SELECT s.speq_id,s.speq_bh,s.speq_name, s.speq_ggxh, s.speq_type,s.speq_scs,s.bm_id, s.speq_bz, s.speq_run\n" +
            "FROM special_eq AS s\n" +
            "WHERE 1 = 1\n" +
            "<if test=\"speqBh != null and speqBh !=''\">\n" +
            "and s.speq_bh like concat( '%', #{speqBh}, '%')\n" +
            "</if>\n" +
            "<if test=\"speqName != null and speqName !=''\">\n" +
            "and s.speq_name like concat( '%', #{speqName}, '%')\n" +
            "</if>\n" +
            "<if test=\"speqScs != null and speqScs !=''\">\n" +
            "and s.speq_scs like concat( '%', #{speqScs}, '%')\n" +
            "</if>\n" +
            "<if test=\"speqType != 2\">\n" +
            "and s.speq_type = #{speqType}\n" +
            "</if>\n" +
            "<if test=\"speqRun != 2\">\n" +
            "and s.speq_run = #{speqRun}\n" +
            "</if>\n" +
            "<if test=\"bmId != null and bmId !=''\">\n" +
            "and s.bm_id like concat( '%', #{bmId}, '%')\n" +
            "</if></script>")
    List<SpecialEquipmentInfoVo> selectSpeqVoByBhAndNameAndScsAndTypeAndBmId(@Param("speqBh") String speqBh, @Param("speqName") String speqName,
                                                                             @Param("speqScs") String speqScs, @Param("speqType") int speqType,
                                                                             @Param("bmId") String bmId, @Param("speqRun") int speqRun);
    //查询特种设备结果记录根据speqId
    @Select("SELECT speq_bh,speq_jczbh,speq_jcsj,speq_sjsqr,speq_sjsqsj,speq_sjspr,speq_sjspsj,speq_run\n" +
            "FROM special_eq_record\n" +
            "WHERE special_eq_record.speq_bh = #{speqBh}\n" +
            "ORDER BY speq_jcsj DESC")
    List<SpecialEquipmentRecordVo> selectSpeqRecordBySpeqId(@Param("speqBh") String speqBh);



    //查询所有不是特种设备从业人员的用户
    @Select("select e.user_id,e.user_xm,b.bm_name\n" +
            "FROM special_eq_em_is AS si,s_emp AS e,s_bm AS b\n" +
            "WHERE si.is_spem = 0 AND si.user_id = e.user_id and b.bm_id = e.bm_id")
    List<UserVo> selectAllUser();
    //查询所有是特种设备从业人员的用户
    @Select("SELECT s.user_id, s.user_xm, s.bm_name, s.spem_sgzzfw,s.spem_spare1\n" +
            "FROM special_eq_em AS s\n" +
            "ORDER BY s.user_id asc")
    List<UserVo> selectAllUserIsSpem();
    //查询员工信息根据id name bmname
    @Select("select e.user_id,e.user_xm,b.bm_name\n" +
            "FROM special_eq_em_is AS si,s_emp AS e,s_bm AS b\n" +
            "WHERE si.is_spem = 0 AND si.user_id = e.user_id and b.bm_id = e.bm_id\n" +
            "and e.user_id like '%'+#{userId}+'%'\n" +
            "and e.user_xm like '%'+#{userXm}+'%'\n" +
            "and b.bm_name LIKE '%'+#{bmName}+'%'")
    List<UserVo> selectUserByIdAndNameAndBmName(@Param("userId") String userId,
                                                @Param("userXm") String userXm,
                                                @Param("bmName") String bmName);
    //查询特种设备员工信息根据id name bmname
    @Select("select s.user_id,s.user_xm,s.bm_name,s.spem_spare1\n" +
            "FROM special_eq_em_is AS si,s_emp AS e,s_bm AS b,special_eq_em AS s\n" +
            "WHERE si.is_spem = 1 AND si.user_id = e.user_id and b.bm_id = e.bm_id AND si.user_id = s.user_id\n" +
            "and e.user_id like '%'+#{userId}+'%'\n" +
            "and e.user_xm like '%'+#{userXm}+'%'\n" +
            "and b.bm_name LIKE '%'+#{bmName}+'%'")
    List<UserVo> selectSpeqUserByIdAndNameAndBmName(@Param("userId") String userId,
                                                    @Param("userXm") String userXm,
                                                    @Param("bmName") String bmName);
    //将员工设为特种设备从业人员
    @Select("UPDATE special_eq_em_is\n" +
            "SET special_eq_em_is.is_spem = 1\n" +
            "WHERE special_eq_em_is.user_id = #{userId}")
    void updateIsSpeqEm(String userId);
    @Insert("INSERT INTO special_eq_em(user_id,user_xm,bm_name)\n" +
            "SELECT user_id,user_xm,bm_id\n" +
            "FROM s_emp\n" +
            "WHERE s_emp.user_id = #{userId}")
    int insertSpemInfo(@Param("userId") String userId);
    @Select("SELECT b.bm_name\n" +
            "FROM s_emp as s , s_bm as b\n" +
            "WHERE s.user_id = #{userId} and s.bm_id = b.bm_id")
    String selectBmName(String userId);
    @Update("UPDATE special_eq_em SET\n" +
            "bm_name = #{bmName}\n" +
            "WHERE user_id = #{userId}")
    void updateBmName(@Param("userId")String userId, @Param("bmName") String bmName);

    //将员工剔除特种设备从业人员
    @Select("UPDATE special_eq_em_is\n" +
            "SET special_eq_em_is.is_spem = 0\n" +
            "WHERE special_eq_em_is.user_id = +#{userId}")
    void updateIsNotSpeqEm(String userId);

    @Select("SELECT user_id, user_xm, bm_name, spem_sgzzfw, spem_zczh, \n" +
            "spem_qfrq, spem_yxqsq, \n" +
            "spem_yxjsq, spem_dabh, \n" +
            "spem_fzjg, spem_zjimage, \n" +
            "spem_spare1 \n" +
            "FROM special_eq_em\n" +
            "WHERE user_id like '%'+#{userId}+'%'")
    SpecialEquipmentEmployeeVo selectSpeqEmployeeByUserId(@Param("userId") String userId);

    @Update("UPDATE special_eq_em\n" +
            "SET spem_sgzzfw = #{spemSgzzfw}, spem_zczh= #{spemZczh}, \n" +
            "spem_qfrq = #{spemQfrq}, spem_yxqsq = #{spemYxqsq}, \n" +
            "spem_yxjsq = #{spemYxjsq}, spem_dabh = #{spemDabh}, \n" +
            "spem_fzjg = #{spemFzjg}, spem_zjimage = #{spemZjimage}, \n" +
            "spem_spare1 = '1'\n" +
            "WHERE user_id = #{userId}")
    int updateSpemInfo(SpecialEquipmentEmployeeVo specialEquipmentEmployeeVo);

    @Select("SELECT user_id,user_xm,bm_name,spem_qfrq,spem_yxqsq,spem_yxjsq \n" +
            "FROM special_eq_em\n" +
            "WHERE spem_spare1 = '1'\n" +
            "ORDER BY spem_yxjsq ASC")
    List<SpecialEquipmentEmployeeVo> selctDate();





}