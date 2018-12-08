package com.litbo.hospital.user.dao.provider;

import com.litbo.hospital.user.bean.EqZjly;
import com.litbo.hospital.user.bean.SysLogo;
import org.apache.ibatis.jdbc.SQL;

public class LogoProvider {


    public String setLogo(SysLogo sysLogo ){
        String sql = "insert into sys_logo (logo, bbtt, sbbqtt)" +
                "    values (#{logo,jdbcType=VARCHAR}, #{bbtt,jdbcType=VARCHAR}, #{sbbqtt,jdbcType=VARCHAR})";
        return sql;
    }
 /*   public String updateLogo(SysLogo sysLogo ){
        String sql = " update sys_logo\n" +
                "    set logo = #{logo,jdbcType=VARCHAR},\n" +
                "      bbtt = #{bbtt,jdbcType=VARCHAR},\n" +
                "      sbbqtt = #{sbbqtt,jdbcType=VARCHAR}";
        return sql;
    }*/

    public String updateLogo(SysLogo sysLogo) {
        return new SQL(){{
            UPDATE("sys_logo");
            if(sysLogo.getLogo()!=null){
                SET("logo = #{logo,jdbcType=VARCHAR}");
            }
            if(sysLogo.getSbbqtt()!=null){
                SET("sbbqtt = #{sbbqtt,jdbcType=VARCHAR}");
            }
            if(sysLogo.getBbtt()!=null){
                SET(" bbtt = #{bbtt,jdbcType=VARCHAR}");
            }
        }}.toString();
    }
}
