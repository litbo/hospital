package com.litbo.hospital.user.dao;

import com.litbo.hospital.user.bean.SRight;
import com.litbo.hospital.user.vo.RightTreeSetValueVo;
import com.litbo.hospital.user.vo.RightTreeVo;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface RightDao {

    @Select("SELECT ri.*,r.* " +
            "FROM s_right AS ri " +
            "INNER JOIN s_role_right AS rr " +
            "ON ri.right_id =rr.right_id " +
            "INNER JOIN s_role AS r " +
            "ON r.role_id =rr.role_id " +
            "WHERE r.role_name =#{roleName}")
    List<SRight> getRightsByRolename(String roleName);

    @Select("select count(*) FROM s_role_right WHERE role_id =#{roleId}")
    Integer countRole(String roleId);
    @Update("update s_role_right set role_id = #{roleId} , right_id =#{rightId}")
    Integer updateRights(@Param("rightId") String rightId,@Param("roleId") String roleId);
    @Insert("INSERT INTO s_role_right(role_id,right_id) VALUES(#{roleId},#{rightId})")
    Integer addRights(@Param("rightId") String rightId,@Param("roleId") String roleId);
    @Delete("DELETE FROM s_role_right WHERE role_id = #{roleId}")
    void deletaByRoleId(String roleId);

    @Insert("INSERT INTO a_right(right_id,right_name,bz,pid) VALUES(#{rightId},#{rightName},#{bz},#{pid})")
    Integer addRight(SRight sRight);
    @Select("select right_id ,bz as rightName ,pid from a_right")
    List<RightTreeVo> listRightTree();
    @Select("SELECT r.bz as rightName ,r.right_id,r.pid FROM s_role_right rr \n" +
            "LEFT JOIN a_right r on r.right_id=rr.right_id\n" +
            "WHERE rr.role_id=#{roleId}")
    List<RightTreeVo> listRightTreeVoByRId(String roleId);

    @Select("SELECT r.bz as rightName,r.right_id,r.pid,r.right_name as checked FROM s_role_right rr \n" +
            "LEFT JOIN a_right r on r.right_id=rr.right_id\n" +
            "WHERE rr.role_id=#{roleId}")
    List<RightTreeSetValueVo> listRightTreeVoByRId1(String roleId);

}
