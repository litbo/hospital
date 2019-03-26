package com.litbo.hospital.security.dao.sqlprovider;

import com.litbo.hospital.security.enums.EnumApplyStatus;
import org.apache.ibatis.jdbc.SQL;

public class FwFpSqlProvider {
    public String listFwFpByWaitExamine(String fpHm,String eqName,String wxDh){
        return new SQL(){
            {
                SELECT("fw_fp.id,fp_dh,fp_price,fp_sd_time,fp_hm,s_emp.user_xm as user_name,eq_name");
                FROM("fw_fp");
                LEFT_OUTER_JOIN("s_emp on s_emp.user_id = fw_fp.user_id");
                LEFT_OUTER_JOIN("fw_baoxiu on fw_baoxiu.id = fw_fp.fp_dh");
                LEFT_OUTER_JOIN("eq_info on eq_info.eq_id = fw_baoxiu.eq_id");
                WHERE("fw_fp.fp_status = "+EnumApplyStatus.WAIT_EXAMINE.getCode().toString());
                if(fpHm!=null&&!"".equals(fpHm)){
                    WHERE("fw_fp.fp_hm = #{fpHm}");
                }
                if(eqName!=null&&!"".equals(eqName)){
                    WHERE("eq_info.eq_name like '%'+#{eqName}+'%'");
                }
                if(wxDh!=null&&!"".equals(wxDh)){
                    WHERE("fw_fp.fp_dh = #{wxDh}");
                }
            }
        }.toString();
    }
    public String listFwFpByApplyApproval(String fpHm,String eqName,String wxDh){
        return new SQL(){
            {
                SELECT("fw_fp.id,fp_dh,fp_price,fp_sd_time,fp_hm,s_emp.user_xm as user_name,eq_name,fp_sh_time,s.user_xm as shr_name");
                FROM("fw_fp");
                LEFT_OUTER_JOIN("s_emp on s_emp.user_id = fw_fp.user_id");
                LEFT_OUTER_JOIN("s_emp as s on s.user_id = fw_fp.fp_shr_id");
                LEFT_OUTER_JOIN("fw_baoxiu on fw_baoxiu.id = fw_fp.fp_dh");
                LEFT_OUTER_JOIN("eq_info on eq_info.eq_id = fw_baoxiu.eq_id");
                WHERE("fw_fp.fp_status = "+EnumApplyStatus.APPLY_APPROVAL.getCode().toString());
                if(fpHm!=null&&!"".equals(fpHm)){
                    WHERE("fw_fp.fp_hm = #{fpHm}");
                }
                if(eqName!=null&&!"".equals(eqName)){
                    WHERE("eq_info.eq_name like '%'+#{eqName}+'%'");
                }
                if(wxDh!=null&&!"".equals(wxDh)){
                    WHERE("fw_fp.fp_dh = #{wxDh}");
                }
            }
        }.toString();
    }
    public String selectFwFpById(Integer id){
        return new SQL(){
            {
                SELECT("id,fp_dh,fp_price,s.user_xm djrName,fp_hm,fp_sd_time");
                FROM("fw_fp");
                LEFT_OUTER_JOIN("s_emp AS s ON s.user_id = fw_fp.user_id");
                WHERE("id = #{id}");
            }
        }.toString();
    }
}
