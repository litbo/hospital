package com.litbo.hospital.security.dao.sqlprovider;
import com.litbo.hospital.security.bean.FwPjzd;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.jdbc.SQL;


public class FwPjzdSqlProvider {
    public String listFwPjzd(String pjSzm, String pjfl){
        return new SQL(){
            {
                SELECT("id as pjzd_id,pjbh,pj_name,pj_ggxh,pj_zczh,pj_zcz_dq_time,ghs.sbcs_name as ghs_name,scqy.sbcs_name as scqy_name");
                FROM("fw_pjzd");
                LEFT_OUTER_JOIN("eq_cs AS ghs ON fw_pjzd.pj_ghs_id = ghs.sbcs_id");
                LEFT_OUTER_JOIN("eq_cs AS scqy on fw_pjzd.pj_scqy_id = scqy.sbcs_id");
                if (pjSzm!=null&&!"".equals(pjSzm)) {
                    WHERE("pj_name like '%'+#{pjSzm}+'%'");
                }
                if (pjfl!=null&&!"".equals(pjfl)){
                    WHERE("pjfl = #{pjfl}");
                }
            }
        }.toString();
    }
    public String updateFwPjzd(FwPjzd pjzd){
        return new SQL(){
            {
                UPDATE("fw_pjzd");
                SET("pjfl = #{ pjfl}");
                SET("pj_scqy_id = #{ pjScqyId}");
                SET("pj_ghs_id = #{ pjGhsId}");
                SET("sb_id = #{ sbId}");
                SET("pj_name = #{ pjName}");
                SET("zb_time = #{ zbTime}");
                SET("pj_ggxh = #{ pjGgxh}");
                SET("pj_bzdw = #{ pjBzdw}");
                SET("pj_zczh = #{ pjZczh}");
                SET("pj_zcz_dq_time = #{ pjZczDqTime}");
                SET("pj_szm = #{ pjSzm}");
                SET("pjbh = #{ pjbh}");
                SET("zb_price = #{ zbPrice}");
                WHERE("id=#{ id}");

//                if (pjSzm!=null&&!"".equals(pjSzm)) {
//                    WHERE("pj_szm like '%'+#{pjSzm}+'%'");
//                }
//                if (pjfl!=null&&!"".equals(pjfl)){
//                    WHERE("pjfl = #{pjfl}");
//                }
            }
        }.toString();
    }

}
