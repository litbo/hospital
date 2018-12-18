package com.litbo.hospital.security.dao.sqlprovider;

import com.litbo.hospital.security.enums.EnumApplyStatus;
import org.apache.ibatis.jdbc.SQL;

public class FwFpSqlProvider {
    public String listFwFpByWaitExamine(){
        return new SQL(){
            {
                SELECT("fw_fp.id,fp_dh,fp_price,fp_sd_time,fp_hm,s_user.user_name,eq_name");
                FROM("fw_fp");
                INNER_JOIN("s_user on s_user.user_id = fw_fp.user_id");
                INNER_JOIN("fw_baoxiu on fw_baoxiu.id = fw_fp.fp_dh");
                INNER_JOIN("eq_info on eq_info.eq_id = fw_baoxiu.eq_id");
                WHERE("fw_fp.fp_status = "+EnumApplyStatus.WAIT_EXAMINE.getCode().toString());
            }
        }.toString();
    }
}
