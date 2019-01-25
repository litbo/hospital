package com.litbo.hospital.security.dao.sqlprovider;

import com.litbo.hospital.security.enums.EnumApplyStatus;
import org.apache.ibatis.jdbc.SQL;

import java.util.Date;

public class FwPjqlZjbProvider {
    public String listFwPjqlZjb(Date start,Date end, String pjName){
        return new SQL(){
            {
                SELECT("z.id , l.id as pjql_id , d.pj_name,s1.user_xm as qlr_name," +
                        "s2.user_xm as qrr_name,l.qr_time,z.pj_count");
                FROM("\tfw_pjql AS l");
                INNER_JOIN("fw_pjql_zjb AS z ON l.id = z.pjql_id");
                LEFT_OUTER_JOIN("fw_pjzd AS d ON d.id = z.pj_id");
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
}
