package com.litbo.hospital.security.dao.sqlprovider;

import org.apache.ibatis.jdbc.SQL;

public class FwYwFpSqlProvider {
    public String listFwYwFp(String fpHm,String eqName,String wxDh){
        return new SQL(){
            {
                SELECT("fw_ywfp.id," +
                        "ywfp_hm," +
                        "ywfp_price," +
                        "ywfp_sd_time," +
                        "s_emp.user_xm AS user_name," +
                        "\teq_info.eq_name ,\n" +
                        "\tsbcs_name");
                FROM("\tfw_ywfp");
                LEFT_OUTER_JOIN("s_emp ON s_emp.user_id = fw_ywfp.user_id");
                LEFT_OUTER_JOIN("eq_info ON eq_info.eq_id = fw_ywfp.eq_id");
                LEFT_OUTER_JOIN("eq_cs ON eq_cs.sbcs_id = fw_ywfp.sbcs_id");
                if(fpHm!=null&&!"".equals(fpHm)){
                    WHERE("fw_ywfp.ywfp_hm = #{fpHm}");
                }
                if(eqName!=null&&!"".equals(eqName)){
                    WHERE("eq_info.eq_name like '%'+#{eqName}+'%'");
                }
            }
        }.toString();
    }
}
