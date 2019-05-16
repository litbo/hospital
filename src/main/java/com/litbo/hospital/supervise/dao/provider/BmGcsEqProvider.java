package com.litbo.hospital.supervise.dao.provider;

import com.litbo.hospital.supervise.vo.BmGcsEqSelectXVO;

public class BmGcsEqProvider {
    public String selectBmGcsEqByX(BmGcsEqSelectXVO xvo){

        /**
         @Select("select swge.bg_id,swge.bm_id,bm.bm_name,swge.user_id,emp.user_xm,swge.eq_id,eq.eq_name\n" +
         "from s_wxbm_gcs_eq swge \n" +
         "LEFT JOIN s_bm bm ON(swge.bm_id=bm.bm_id) \n" +
         "LEFT JOIN s_emp emp on (swge.user_id=emp.user_id) \n" +
         "LEFT JOIN eq_info eq ON (swge.eq_id=eq.eq_id)")
         */
        StringBuffer sql = new StringBuffer("" +
                "   select swge.bg_id,swge.bm_id,bm.bm_name,swge.user_id,emp.user_xm,swge.eq_id,eq.eq_name" +
                "   from s_wxbm_gcs_eq swge " +
                "   LEFT JOIN s_bm bm ON(swge.bm_id=bm.bm_id) " +
                "   LEFT JOIN s_emp emp on (swge.user_id=emp.user_id)" +
                "   LEFT JOIN eq_info eq ON (swge.eq_id=eq.eq_id) where 1=1" );
        if(!"0000000000".equals(xvo.getBmId()))  sql.append(" and bm.bm_id=#{bmId} ");
        if(!"0000000000".equals(xvo.getUserId())) sql.append(" and emp.user_id=#{userId} ");
        if(xvo.getEqPym()!=null&&!"".equals(xvo.getEqPym())) sql.append(" and eq.eq_pym like '%'+#{eqPym}+'%' ");
        return sql.toString();
    }
}
