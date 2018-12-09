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
}
