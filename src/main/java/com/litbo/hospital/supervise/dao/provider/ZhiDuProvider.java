package com.litbo.hospital.supervise.dao.provider;

import java.util.Date;

public class ZhiDuProvider {
    public String listZdsByTimeAndZdNameAndZt(Date startTime, Date endTime, String zdName, String zdZt){
        StringBuffer sql = new StringBuffer("" +
                "  SELECT * from s_zhidu where 1=1");
        if(startTime!=null) sql.append(" and create_time>#{startTime} ");
        if(endTime!=null) sql.append(" and create_time<#{endTime} ");
        if(zdName!=null) sql.append(" and zd_name like '%'+#{zdName}+'%' ");
        if(zdZt!=null) sql.append(" and zd_zt= #{zdZt} ");
        return sql.toString();
    }
}
