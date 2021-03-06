package com.litbo.hospital.user.dao;

import com.litbo.hospital.supervise.bean.SGangwei;
import com.litbo.hospital.user.bean.SRole;
import com.litbo.hospital.user.dao.provider.RoleProvider;
import com.litbo.hospital.user.vo.SelectUserVo;
import com.litbo.hospital.user.vo.UserVo;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface RoleDao {
    @Select("SELECT\n" +
            "u.user_name,\n" +
            "r.role_id,\n" +
            "r.role_name,\n" +
            "u.user_id\n" +
            "FROM\n" +
            "dbo.s_user AS u\n" +
            "INNER JOIN dbo.s_user_role AS ur ON u.user_id= ur.user_id\n" +
            "INNER JOIN dbo.s_role AS r ON r.role_id= ur.role_id\n" +
            "WHERE\n" +
            "u.user_name = #{userName}")
    List<SRole> getRoleByUsername(String username);

    @Insert("Insert into s_role(role_id, role_name)" +
            " values(#{roleId},#{roleName})")
    Integer addRole(SRole role);

    @Insert("Insert into s_user_role(user_id, role_id)" +
            " values(#{userId},#{roleId})")
    Integer setRole(@Param("userId") String userId, @Param("roleId") String roleId);

    @Update("Update s_user set status = 1 where user_id=#{userId}")
    Integer setStatus(String userId);


    @SelectProvider(type = RoleProvider.class , method = "listUser")
    List<UserVo> ListUser();

    @SelectProvider(type = RoleProvider.class , method = "listUserByX")
    List<UserVo> listUserByX(SelectUserVo selectUserVo);
    @Select("select * from s_role")
    List<SRole> listRoles() ;
    @Select("select top 1 role_id from s_role order by cast(role_id as int) DESC")
    String getLastId();
    @Select("SELECT\n" +
            "r.role_name\n" +
            "FROM\n" +
            "dbo.s_user AS u\n" +
            "INNER JOIN dbo.s_user_role AS ur ON u.user_id= ur.user_id\n" +
            "INNER JOIN dbo.s_role AS r ON r.role_id= ur.role_id\n" +
            "WHERE\n" +
            "u.user_name = #{userName}")
    SRole getRole(String userName);


    /**
     * 樊小铭  2019年9月27日
     * 从岗位表中拿出岗位信息作为权限
     * @return
     */
    @Select("select gw_id as roleId, gw_name as roleName from s_gangwei")
    List<SRole> getGangWei();

    /**
     * 樊小铭  2019年9月27日
     * 从岗位表中拿出岗位信息作为权限
     * @return
     */
    @Select("select gw_name as roleName from s_gangwei where gw_id = #{id}")
    String getGangWeiMessage(String id);
}
