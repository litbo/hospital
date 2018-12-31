package com.litbo.hospital.supervise.dao.provider;

public class GwProvider {

    public String selectGwByX(String shr_id, Integer gwZzZt){

//        @Select("select gw.gw_id,gw.gw_name,szt.zt_czname " +
//                " FROM s_gangwei gw LEFT JOIN s_zhize_zt szt on (gw.gw_id = szt.zz_id) " +
//                "where  szt.zt_czzt=0 and szt.user_id=#{shr_id} ")   // 状态为0（未处理）
        StringBuffer sql = new StringBuffer("select gw.gw_id,gw.gw_name,szt.zt_czname FROM s_gangwei gw LEFT JOIN s_zhize_zt szt on (gw.gw_id = szt.zz_id) where 1=1 and gw.gw_zz_zt=#{gwZzZt} " );
        if(shr_id!=null)  sql.append(" and szt.user_id = #{shr_id}");
        return sql.toString();
    }
}
