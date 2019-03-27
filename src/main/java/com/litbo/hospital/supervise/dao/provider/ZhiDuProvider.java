package com.litbo.hospital.supervise.dao.provider;

import com.litbo.hospital.user.vo.LiveEmpVo;
import org.apache.shiro.SecurityUtils;

public class ZhiDuProvider {

    public String listZdsByTimeAndZdNameAndZt(String startTime, String endTime, String zdName, String zdZt,String reFlag){
        LiveEmpVo emp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
        String userId = emp.getUserId();

        StringBuffer sql = new StringBuffer("" +
                "  SELECT * from s_zhidu where 1=1");
        if(startTime!=null) sql.append(" and create_time>#{startTime} ");
        if(endTime!=null) sql.append(" and create_time<#{endTime} ");
        if(zdName!=null) sql.append(" and zd_name like '%'+#{zdName}+'%' ");
        if(zdZt!=null) sql.append(" and zd_zt= #{zdZt} ");
        if(reFlag!=null) sql.append(" and zd_xgcs= #{reFlag} ");

        return sql.toString();
    }


    public String listZdsByZdZt(String zdZt){

        StringBuffer sql = new StringBuffer("" +
                "  SELECT * from s_zhidu where 1=1");
        if(zdZt!=null) sql.append(" and zd_zt= #{zdZt} ");
        return sql.toString();
    }

    public String listZdsByShr(String shr_id, String zdZt,String reFlag, String zdName){

        StringBuffer sql = new StringBuffer("" +
                " select szd.zd_id,szd.zd_name,szd.create_time,szt.zt_czname FROM s_zhidu szd LEFT JOIN s_zhiduzhize_zt szt \n" +
                "on (szd.zd_id = szt.zd_id) where szt.user_id=#{shr_id} and szt.zt_czzt=0");
        if(zdName!=null) sql.append(" and szd.zd_name like '%'+#{zdName}+'%' ");
        if(zdZt!=null) sql.append(" and szd.zd_zt= #{zdZt} ");
        if(reFlag!=null) sql.append(" and szd.zd_xgcs= #{reFlag} ");

        return sql.toString();
    }

//    SELECT * from s_zhidu as zd INNER JOIN s_zhiduzhize_zt zt on(zt.zd_id=zd.zd_id)  where zd.zd_id=45  ORDER BY zt.zt_date DESC
}
