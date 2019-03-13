package com.litbo.hospital.security.dao.sqlprovider;

import org.apache.ibatis.jdbc.SQL;

public class FwBlsjSqlProvider {
    public String selectFwBlsjById(Integer id){
        return new SQL(){
            {
                SELECT("eq_info.eq_name,user_xm,f.user_id,f.bgbh,f.bgmc,f.bgrgw," +
                        "f.bg_time,f.sjxz,f.bgrqz,f.hzxm,f.hz_age,f.hz_sex,sjfs_time,sjhg," +
                        "fxzx_time,ylqxsxcs,czry,zr_time,bxdh,yqzlxg,qxgz,zysh,sjcs");
                FROM("fw_blsj as f");
                LEFT_OUTER_JOIN("eq_info ON eq_info.eq_id = f.eq_id");
                LEFT_OUTER_JOIN("s_emp ON s_emp.user_id = f.user_id");
                WHERE("id=#{id}");
            }
        }.toString();
    }
    public String listFwBlsj(String sjxz,String bmName,String sbcsName,String bgmc){
        return new SQL(){
            {
                SELECT("b.id,f.eq_name,m.bm_name,b.bgmc,b.bg_time,b.sjxz,f.eq_gg,e.sbcs_name,f.eq_azrq");
                FROM("fw_blsj as b");
                LEFT_OUTER_JOIN("eq_info as f on b.eq_id = f.eq_id");
                LEFT_OUTER_JOIN("s_bm as m on m.bm_id =  f.eq_bmid");
                LEFT_OUTER_JOIN("eq_cs as e on e.sbcs_id = f.sbcs_id_scs");
                if(sjxz!=null&&!"".equals(sjxz)){
                    WHERE("b.sjxz = #{sjxz}");
                }
                if(bgmc!=null&&!"".equals(bgmc)){
                    WHERE("b.bgmc like '%'+#{bgmc}+'%'");
                }
                if(bmName!=null&&!"".equals(bmName)){
                    WHERE("bm_name = #{bmName}");
                }
                if(sbcsName!=null&&!"".equals(sbcsName)){
                    WHERE("sbcs_name like '%'+#{sbcsName}+'%'");
                }
            }
        }.toString();
    }
}
