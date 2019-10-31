package com.litbo.hospital.user.dao.provider;

import com.litbo.hospital.user.bean.SysGgxz;

public class GgxzProvider {

    public String addGgxz(SysGgxz ggxz){
        String sql =" insert into sys_ggxz (wjmc, scrq, \n" +
                "      scr, url, status, wjsm )\n" +
                "    values ( #{wjmc,jdbcType=VARCHAR}, #{scrq,jdbcType=DATE}, \n" +
                "      #{scr,jdbcType=VARCHAR}, #{url,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, #{wjsm,jdbcType=LONGVARCHAR} )\n" ;
        return sql;
    }
    public String listGgxzs(){
        String sql = "SELECT\n" +
                "sys_ggxz.id,\n" +
                "sys_ggxz.wjmc,\n" +
                "sys_ggxz.scrq,\n" +
                "sys_ggxz.scr,\n" +
                "sys_ggxz.url,\n" +
                "sys_ggxz.wjsm,\n" +
                "sys_ggxz.status,\n" +
                "sys_ggxz.scsj\n" +
                "\n" +
                "FROM\n" +
                "sys_ggxz\n" +
                "\n" ;
                /*"WHERE status =1"*/
        return sql;
    }


    public String ggxzPass(Integer id){
        String sql = "UPDATE sys_ggxz  " +
                "SET status = 1  " +
                "WHERE id = #{id}";
        return sql;
    }

    public String ggxzFail(Integer id){
        String sql = "DELETE FROM sys_ggxz " +
                "WHERE id = #{id}";
        return sql;
    }
    public String listWaits(String wjmc){
        String sql = "<script>SELECT * FROM sys_ggxz " +
                "WHERE status = 0 \n" +
                "<if test=\" wjmc!=null and wjmc!=''\">" +
                " and wjmc like CONCAT('%',#{wjmc},'%') " +
                "</if>" +
                "</script>";
        return sql;
    }

    public String getGgxzById(Integer id){
        String sql = "SELECT\n" +
                "sys_ggxz.id,\n" +
                "sys_ggxz.wjmc,\n" +
                "sys_ggxz.scrq,\n" +
                "sys_ggxz.scr,\n" +
                "sys_ggxz.url,\n" +
                "sys_ggxz.wjsm,\n" +
                "sys_ggxz.status,\n" +
                "sys_ggxz.scsj\n" +
                "\n" +
                "FROM\n" +
                "sys_ggxz\n" +
                "\n" +
                "WHERE id =#{id}";
        return sql;
    }

}
