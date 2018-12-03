package com.litbo.hospital.user.dao.provider;

import com.litbo.hospital.user.bean.SysDxm;
import com.litbo.hospital.user.bean.SysWjbb;
import com.litbo.hospital.user.bean.SysZxsj;
import org.apache.ibatis.jdbc.SQL;

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
    public String addZxsj(SysZxsj zxsj){
        String sql = " insert into sys_zxsj ( am_sbsj, am_xbsj,  " +
                "      pm_sbsj, pm_xbsj,yb_sbsj,yb_sbsj,yb_xbsj) " +
                "    values (#{amSbsj,jdbcType=DATE}, #{amXbsj,jdbcType=DATE},  " +
                "      #{pmSbsj,jdbcType=DATE}, #{pmXbsj,jdbcType=DATE})" +
                "   #{ybSbsj},#{ybXbsj}";
        return sql;
    }
    public String updateZxsj(SysZxsj zxsj){
        String sql =" update sys_zxsj " +
                "    set am_sbsj = #{amSbsj,jdbcType=DATE}, " +
                "      am_xbsj = #{amXbsj,jdbcType=DATE}, " +
                "      pm_sbsj = #{pmSbsj,jdbcType=DATE}, " +
                "      pm_xbsj = #{pmXbsj,jdbcType=DATE}" +
                "      yb_sbsj = #{ybSbsj}" +
                "      yb_xbsj = #{ybXbsj}" ;
        return  sql;
    }
}
