package com.litbo.hospital.user.dao.provider;

import com.litbo.hospital.user.bean.SysDxm;
import com.litbo.hospital.user.bean.SysWjbb;
import com.litbo.hospital.user.bean.SysZxsj;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.sql.Time;

public class SysProvider {

    public String count(String bname){

        return new SQL(){{
            SELECT("count(*)");
            FROM(bname);
        }}.toString();
    }
    public String addWjbb(SysWjbb wjbb){
        String sql = "insert into sys_wjbb (dwdm, bbh)" +
                "    values ( #{dwdm,jdbcType=VARCHAR}, #{bbh,jdbcType=VARCHAR})";
        return sql;
    }
    public String updateWjbb(SysWjbb wjbb){
        String sql =" update sys_wjbb " +
                "    set  dwdm = #{dwdm,jdbcType=VARCHAR}, " +
                "      bbh = #{bbh,jdbcType=VARCHAR}";
        return sql;
    }
    public String addDxm(SysDxm dxm){
        String sql = "insert into sys_dxm(ckh , btl)" +
                    " values (#{ckh} , #{btl})";
        return  sql;
    }
    public String updateDxm(SysDxm dxm){
        String sql = "update sys_dxm" +
                    " set ckh = #{ckh} , btl = #{btl}";
        return sql;
    }
    public String addZxsj(@Param("amSbsj") Time amSbsj,@Param("amXbsj")  Time amXbsj,@Param("pmSbsj")  Time pmSbsj, @Param("pmXbsj") Time pmXbsj){
        String sql = " insert into sys_zxsj ( am_sbsj, am_xbsj,  " +
                "      pm_sbsj, pm_xbsj ) " +
                "    values (#{amSbsj }, #{amXbsj },  " +
                "      #{pmSbsj }, #{pmXbsj } )" ;
        return sql;
    }
    public String updateZxsj(@Param("amSbsj") Time amSbsj,@Param("amXbsj")  Time amXbsj,@Param("pmSbsj")  Time pmSbsj, @Param("pmXbsj") Time pmXbsj){
        String sql =" update sys_zxsj " +
                "    set am_sbsj = #{amSbsj }, " +
                "      am_xbsj = #{amXbsj }, " +
                "      pm_sbsj = #{pmSbsj }, " +
                "      pm_xbsj = #{pmXbsj }"
                ;
        return  sql;
    }
}
