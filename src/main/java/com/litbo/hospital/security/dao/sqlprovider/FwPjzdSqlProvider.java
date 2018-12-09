package com.litbo.hospital.security.dao.sqlprovider;
import org.apache.ibatis.jdbc.SQL;


public class FwPjzdSqlProvider {
    public String listFwPjzd(String pjSzm, String pjfl){
        return new SQL(){
            {
                SELECT("pjbh,pj_name,pj_ggxh,pj_zczh,pj_zcz_dq_time,ghs.sbcs_name as ghs_name,scqy.sbcs_name as scqy_name");
                FROM("fw_pjzd");
                INNER_JOIN("eq_cs AS ghs ON fw_pjzd.pj_ghs_id = ghs.sbcs_id");
                INNER_JOIN("eq_cs AS scqy on fw_pjzd.pj_scqy_id = scqy.sbcs_id");
                if (pjSzm!=null) {
                    WHERE("pj_szm like '%'+#{pjSzm}+'%'");
                }
                if (pjfl!=null){
                    WHERE("pjfl like '%'+#{pjfl}+'%'");
                }
            }
        }.toString();
    }
}
