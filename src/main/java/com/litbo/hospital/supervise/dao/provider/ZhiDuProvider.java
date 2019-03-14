package com.litbo.hospital.supervise.dao.provider;

public class ZhiDuProvider {
    public String listZdsByTimeAndZdNameAndZt(String startTime, String endTime, String zdName, String zdZt){

        StringBuffer sql = new StringBuffer("" +
                "  SELECT * from s_zhidu where 1=1");
        if(startTime!=null) sql.append(" and create_time>#{startTime} ");
        if(endTime!=null) sql.append(" and create_time<#{endTime} ");
        if(zdName!=null) sql.append(" and zd_name like '%'+#{zdName}+'%' ");
        if(zdZt!=null) sql.append(" and zd_zt= #{zdZt} ");
        return sql.toString();
    }


    public String listZdsByZdZt(String zdZt){

        StringBuffer sql = new StringBuffer("" +
                "  SELECT * from s_zhidu where 1=1");
        if(zdZt!=null) sql.append(" and zd_zt= #{zdZt} ");
        return sql.toString();
    }

//    SELECT * from s_zhidu as zd INNER JOIN s_zhiduzhize_zt zt on(zt.zd_id=zd.zd_id)  where zd.zd_id=45  ORDER BY zt.zt_date DESC
}
