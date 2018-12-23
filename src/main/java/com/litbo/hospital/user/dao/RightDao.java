package com.litbo.hospital.user.dao;

import com.litbo.hospital.user.bean.SRight;
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
}
