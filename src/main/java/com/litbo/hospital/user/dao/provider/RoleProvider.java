package com.litbo.hospital.user.dao.provider;

import com.litbo.hospital.user.vo.SelectUserVo;

public class RoleProvider {

    public String listUserByRId(String roleId){
       String sql =  "SELECT\n" +
               "e.user_id AS userId,\n" +
               "e.user_xm AS name,\n" +
               "r.role_name AS roleName\n" +
               "\n" +
               "FROM\n" +
               "dbo.s_emp AS e\n" +
               "INNER JOIN dbo.s_user_role AS ur ON e.user_id= ur.user_id\n" +
               "INNER JOIN dbo.s_role AS r ON r.role_id= ur.role_id\n" +
               "WHERE ur.role_id = #{roleId}";
       return sql;
    }
    public String listUser(){
        String sql = "SELECT e.user_id AS userId,\n" +
                "\t e.user_xm AS name,\n" +
                "\t r.role_name AS roleName,\n" +
                "\t e.bm_id AS bmId,u.status,\n" +
                "\t b.bm_name AS bmName\n" +
                "FROM s_user u\n" +
                "LEFT JOIN s_user_role AS ur ON u.user_id =ur.user_id\n" +
                "LEFT JOIN s_role AS r on ur.role_id = r.role_id\n" +
                "LEFT JOIN s_emp  AS e on u.user_id = e.user_id\n" +
                "LEFT JOIN s_bm   AS b on e.bm_id = b.bm_id";
        return sql;
    }
    public String listUserByX(SelectUserVo selectUserVo){
        StringBuffer sql =new StringBuffer("SELECT\n" +
                "\tu.user_id AS userId,\n" +
                "\te.user_xm AS name,\n" +
                "\tr.role_name AS roleName, \n" +
                "\t e.bm_id AS bmId,\n" +
                "\t b.bm_name AS bmName,u.status\n" +
                "FROM\n" +
                "\tdbo.s_user as u\n" +
                "\tLEFT JOIN dbo.s_emp AS e ON u.user_id = e.user_id\n" +
                "\tLEFT JOIN dbo.s_user_role AS ur ON u.user_id = ur.user_id\n" +
                "\tLEFT JOIN dbo.s_role AS r ON r.role_id= ur.role_id\n" +
                "LEFT JOIN s_bm   AS b on e.bm_id = b.bm_id\n"+
                "  WHERE 1 = 1 ");
        if(selectUserVo.getRoleId()!=null) sql.append(" and r.role_id Like '%'+#{roleId}+'%'");
        if(selectUserVo.getBmId()!=null&&!"0000000000".equals(selectUserVo.getBmId())) sql.append(" and e.bm_id Like '%'+#{bmId}+'%'");
        if(selectUserVo.getUserId()!=null) sql.append(" and u.user_id Like'%'+#{userId}+'%'");
        if(selectUserVo.getStatus()!=null) sql.append(" and u.status Like '%'+#{status}+'%'");
        if(selectUserVo.getBmName()!=null) sql.append(" and b.bm_name Like '%'+#{bmName}+'%'");
        return sql.toString();
    }
}
