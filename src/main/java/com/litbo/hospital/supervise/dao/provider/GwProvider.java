package com.litbo.hospital.supervise.dao.provider;

public class GwProvider {

    public String selectGwByX(String shr_id, Integer gwZzZt){

        StringBuffer sql = new StringBuffer("select gw.gw_id,gw.gw_name,szt.zt_czname FROM s_gangwei gw LEFT JOIN s_zhize_zt szt on (gw.gw_id = szt.zz_id) where 1=1 and gw.gw_zz_zt=#{gwZzZt} " );
        if(shr_id!=null)  sql.append(" and szt.user_id = #{shr_id}");
        return sql.toString();
    }

    public String getGwsByGwLevelAndGwName(String gwLevel, String gwName){

        StringBuffer sql = new StringBuffer("select * from s_gangwei where 1=1  " );
        if(!"0000000000".equals(gwLevel))  sql.append(" and gw_level = #{gwLevel}");
        if(gwName!=null)  sql.append(" and gw_name Like '%'+#{gwName}+'%'");
        return sql.toString();
    }

    public String listGwsByTimeAndZdNameAndZt(String startTime, String endTime, String gwName, String gwZt,String reFlag){

        StringBuffer sql = new StringBuffer("" +
                "  SELECT * from s_gangwei where 1=1");
        if(startTime!=null) sql.append(" and create_time>#{startTime} ");
        if(endTime!=null) sql.append(" and create_time<#{endTime} ");
        if(gwName!=null) sql.append(" and gw_name like '%'+#{gwName}+'%' ");
        if(gwZt!=null) sql.append(" and gw_zz_zt= #{gwZt} ");
        if(reFlag!=null) sql.append(" and zd_xgcs= #{reFlag} ");
        return sql.toString();
    }
}
