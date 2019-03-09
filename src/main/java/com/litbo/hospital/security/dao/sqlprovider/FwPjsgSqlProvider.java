package com.litbo.hospital.security.dao.sqlprovider;

import com.litbo.hospital.security.bean.FwPjsg;
import org.apache.ibatis.jdbc.SQL;

public class FwPjsgSqlProvider {
    public String listFwPjsg(FwPjsg fwPjsg){
        return new SQL(){
            {
                SELECT("*");
                FROM("fw_pjsg");
                if (fwPjsg.getUserId2()!=null) {
                    WHERE("user_id2 = #{userId2}");
                }
                if (fwPjsg.getSgStatus()!=null){
                    WHERE("sg_status = #{sgStatus}");
                }
            }
        }.toString();
    }

    public String selectFwPjsgById(Integer id){
        return new SQL(){
            {
                SELECT("f.id,pj_rk_time,user_xm,f.sg_yy ,f.sg_sqsx");
                FROM("fw_pjsg as f");
                LEFT_OUTER_JOIN("s_emp ON s_emp.user_id = f.user_id1");
                WHERE("id = #{id}");
            }
        }.toString();
    }
}
