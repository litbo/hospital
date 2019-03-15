package com.litbo.hospital.security.dao.sqlprovider;

import org.apache.ibatis.jdbc.SQL;

public class FwPjkSqlProvider {
    public String listFwPjk(String pjSzm){
        return new SQL(){
            {
                SELECT("k.pjk_sl,k.id,d.pjbh,d.pj_name,d.pj_ggxh,d.pj_zczh,d.pj_zcz_dq_time,ghs.sbcs_name AS ghs_name,scqy.sbcs_name AS scqy_name");
                FROM("fw_pjk AS k");
                INNER_JOIN("fw_pjzd AS d ON k.id = d.id");
                LEFT_OUTER_JOIN("eq_cs AS ghs ON d.pj_ghs_id = ghs.sbcs_id");
                LEFT_OUTER_JOIN("eq_cs AS scqy ON d.pj_scqy_id = scqy.sbcs_id");
                if(pjSzm!=null&&!"".equals(pjSzm))
                WHERE("d.pj_szm like '%'+#{pjSzm}+'%'");
            }
        }.toString();
    }

}
