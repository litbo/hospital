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


    public String listFwPjsgZjbExamine(Integer id){
        return new SQL(){
            {
                SELECT("d.pj_name,d.pj_ggxh,d.pj_zczh,d.pj_zcz_dq_time," +
                        "c.sbcs_name as scqy_name,s.sbcs_name as ghs_name,z.pjsg_count,z.pjsg_price");
                FROM("fw_pjsg AS f");
                LEFT_OUTER_JOIN("fw_pjsg_zjb AS z ON z.pjsg_id = f.id");
                LEFT_OUTER_JOIN("fw_pjzd as d on d.id = z.pjzd_id");
                LEFT_OUTER_JOIN("eq_cs as c on c.sbcs_id = d.pj_scqy_id");
                LEFT_OUTER_JOIN("eq_cs as s on s.sbcs_id = d.pj_ghs_id");
                WHERE("f.id = #{id}");

            }
        }.toString();
    }
}
