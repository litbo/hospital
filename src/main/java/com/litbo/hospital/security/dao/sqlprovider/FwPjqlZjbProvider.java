package com.litbo.hospital.security.dao.sqlprovider;

import com.litbo.hospital.security.enums.EnumApplyStatus;
import org.apache.ibatis.jdbc.SQL;

import java.util.Date;

public class FwPjqlZjbProvider {
    public String listFwPjqlZjb(Date start,Date end, String pjName){
        return new SQL(){
            {
                SELECT("z.id , l.id as pjql_id , d.pj_name,s1.user_xm as qlr_name," +
                        "s2.user_xm as qrr_name,l.qr_time,z.pjsg_count");
                FROM("fw_pjql AS l");
                INNER_JOIN("fw_pjql_zjb AS z ON l.id = z.pjql_id");
                LEFT_OUTER_JOIN("fw_pjzd AS d ON d.id = z.pjql_id");
                LEFT_OUTER_JOIN("s_emp as s1 on s1.user_id = l.qlr_id");
                LEFT_OUTER_JOIN("s_emp as s2 on s2.user_id = l.qrr_id");
                WHERE("l.sq_status = "+EnumApplyStatus.APPLY_APPROVAL.getCode());
                if (pjName!=null&&!"".equals(pjName)) {
                    WHERE("d.pj_name like '%'+#{pjName}+'%'");
                }
                if(start!=null&&end!=null&&start.before(end)){
                    WHERE("l.qr_time >= #{start}");
                }
                if(end!=null&&start!=null&&end.after(start)){
                    WHERE("l.qr_time <= #{end}");
                }
            }
        }.toString();
    }

    public String listFwPjqlZjbExamine(Integer id){
        return new SQL(){
            {
                SELECT("d.pj_name,d.pj_ggxh,d.pj_zczh,d.pj_zcz_dq_time," +
                        "c.sbcs_name as scqy_name,s.sbcs_name as ghs_name,z.pjsg_count");
                FROM("fw_pjql AS f");
                LEFT_OUTER_JOIN("fw_pjql_zjb AS z ON z.pjql_id = f.id");
                LEFT_OUTER_JOIN("fw_pjzd as d on d.id = z.pjzd_id");
                LEFT_OUTER_JOIN("eq_cs as c on c.sbcs_id = d.pj_scqy_id");
                LEFT_OUTER_JOIN("eq_cs as s on s.sbcs_id = d.pj_ghs_id");
                WHERE("f.id = #{id}");

            }
        }.toString();
    }
}
