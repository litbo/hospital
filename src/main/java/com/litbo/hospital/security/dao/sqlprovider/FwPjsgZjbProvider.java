package com.litbo.hospital.security.dao.sqlprovider;

import com.litbo.hospital.security.bean.FwPjsg;
import com.litbo.hospital.security.enums.EnumApplyStatus;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.Date;

public class FwPjsgZjbProvider {
    public String listFwPjsgZjb(Date start, Date end, String pjName){
        return new SQL(){
            {
                SELECT("\tb.id,\n" +
                        "\tg.id as pjsg_id,\n" +
                        "\td.pj_name,\n" +
                        "\tg.sg_sh_time as pj_rk_time,\n" +
                        "\tb.pjsg_count,\n" +
                        "\tb.pjsg_price,\n" +
                        "\ts1.user_xm as sgr_name,\n" +
                        "\ts2.user_xm as shr_name");
                FROM("fw_pjsg AS g");
                INNER_JOIN("fw_pjsg_zjb AS b ON g.id = b.pjsg_id");
                LEFT_OUTER_JOIN("fw_pjzd AS d ON d.id = b.pjzd_id");
                LEFT_OUTER_JOIN("s_emp as s1 on s1.user_id = g.user_id1");
                LEFT_OUTER_JOIN("s_emp as s2 on s2.user_id = g.user_id2");
                WHERE("g.sg_status = "+EnumApplyStatus.APPLY_APPROVAL.getCode());
                if (pjName!=null&&!"".equals(pjName)) {
                    WHERE("d.pj_name like '%'+#{pjName}+'%'");
                }
                if(start!=null&&end!=null&&start.before(end)){
                    WHERE("g.sg_sh_time >= #{start}");
                }
                if(end!=null&&start!=null&&end.after(start)){
                    WHERE("g.sg_sh_time <= #{end}");
                }

            }
        }.toString();
    }
}
