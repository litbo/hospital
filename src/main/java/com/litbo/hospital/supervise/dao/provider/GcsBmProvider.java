package com.litbo.hospital.supervise.dao.provider;

public class GcsBmProvider {
    public String selectGcsBmByX(String userXm,String bmName){

        /**
        select sgb.gb_id,sgb.user_id,emp.user_xm,sgb.bm_id,bm.bm_name \n" +
        " from s_gcs_bm sgb INNER JOIN s_emp emp ON (sgb.user_id=emp.user_id)\n" +
                " INNER JOIN s_bm bm on (sgb.bm_id=bm.bm_id)\n" +
                " where emp.user_xm LIKE '%'+#{userXm}+'%' and bm.bm_name like '%'+#{bmName}+'%'
         */
        StringBuffer sql = new StringBuffer("" +
                " select sgb.gb_id,sgb.user_id,emp.user_xm,sgb.bm_id,bm.bm_name " +
                " from s_gcs_bm sgb " +
                " INNER JOIN s_emp emp ON (sgb.user_id=emp.user_id)" +
                " INNER JOIN s_bm bm on (sgb.bm_id=bm.bm_id) where 1=1" );
        if(userXm!=null)  sql.append(" and user_xm like  '%'+#{userXm}+'%' ");
        if(bmName!=null) sql.append(" and bm_name like  '%'+#{bmName}+'%' ");

        return sql.toString();
    }
}
