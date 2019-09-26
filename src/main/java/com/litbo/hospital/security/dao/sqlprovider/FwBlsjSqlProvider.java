package com.litbo.hospital.security.dao.sqlprovider;

import org.apache.ibatis.jdbc.SQL;

public class FwBlsjSqlProvider {
    public String selectFwBlsjById(Integer id){
        return new SQL(){
            {
                SELECT("eq_info.eq_name,user_xm,f.user_id,f.bgbh,f.bgmc,f.bgrgw," +
                        "f.bg_time,f.sjxz,f.bgrqz,f.hzxm,f.hz_age,f.hz_sex,sjfs_time,sjhg," +
                        "fxzx_time,ylqxsxcs,czry,zr_time,bxdh,yqzlxg,qxgz,zysh,sjcs,lxdh");
                FROM("fw_blsj as f");
                LEFT_OUTER_JOIN("eq_info ON eq_info.eq_id = f.eq_id");
                LEFT_OUTER_JOIN("s_emp ON s_emp.user_id = f.user_id");
                WHERE("id=#{id}");
            }
        }.toString();
    }
    public String listFwBlsj(Integer status, Integer lb,String cpmc, String bgrXm){
        return new SQL(){
            {
                SELECT("*");
                FROM("fw_blsj ");
                if(cpmc!=null&&!"".equals(cpmc)){
                    WHERE("cpmc like '%'+#{cpmc}+'%'");
                }
                if(bgrXm!=null&&!"".equals(bgrXm)){
                    WHERE("bgr_xm like '%'+#{bgrXm}+'%'");
                }

                WHERE("status=#{status} and lb = #{lb} ");

            }
        }.toString();
    }
}
