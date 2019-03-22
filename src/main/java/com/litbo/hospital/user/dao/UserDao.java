package com.litbo.hospital.user.dao;

import com.litbo.hospital.user.bean.SUser;
import com.litbo.hospital.user.vo.LiveEmpVo;
import com.litbo.hospital.user.vo.UserVo;
import org.apache.ibatis.annotations.*;


@Mapper
public interface UserDao {

    @Select("SELECT * FROM s_user WHERE user_name=#{userName}")
    SUser getUserByUsername(@Param(value = "userName") String username);
    @Insert("insert into s_user (user_id, user_name, user_pwd, bz) " +
            "  values (#{userId,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, #{userPwd,jdbcType=VARCHAR},#{bz,jdbcType=LONGVARCHAR})")
    Integer addUser(SUser u);

    @Update("update s_user " +
            "set  user_pwd = #{userPwd,jdbcType=VARCHAR}" +
            " where user_id = #{userId}")
    Integer updatePwd(@Param("userId") String userId,@Param("userPwd") String userPwd);

    @Select("SELECT u.user_id , e.user_xm as name, e.bm_id ,r.role_name,r.role_id FROM s_user u\n" +
            "Left JOIN s_emp e on u.user_id = e.user_id\n" +
            "Left JOIN s_user_role ur on u.user_id = ur.user_id\n" +
            "Left JOIN s_role  r on ur.role_id = r.role_id\n" +
            "WHERE u.user_id = #{userId}")
    UserVo getUserByUserId(String userId);

    @Update("update s_emp set status='1' where user_id=#{userId}")
    Integer changeStatus(String userId);
    @Update("update s_emp set status='0' where user_id=#{userId}")
    Integer changeStatus0(String userId);
    @Delete("delete from s_user where user_id =#{id}")
    Integer delUser(String id);
    @Delete("delete from s_emp where user_id =#{id}")
    Integer delEmp(String id);
    @Delete("delete from s_user_role where user_id =#{id}")
    Integer delRole(String id);
    @Select(" SELECT bm.bm_name,emp.user_xm,emp.user_id,emp.status, sex.sex\n" +
            " from s_emp emp\n" +
            " LEFT JOIN s_bm bm ON (emp.bm_id=bm.bm_id)\n" +
            " LEFT JOIN s_sex sex ON (sex.sex_id=emp.sex_id)\n" +
            "where emp.user_id=#{userId}")
    LiveEmpVo getLiveUserById(String userId);
}
