package com.litbo.hospital.security.dao.sqlprovider;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author zjc
 * @create 2018-12-04 17:05
 */
public class FwBaoxiuProvider {

    public String listFwBaoxiu(){
        return new SQL(){
            {
                SELECT("*");
                FROM("fw_baoxiu");
                /*if()*/
            }
        }.toString();
    }

    /*public String updateFwBaoxiuStatus(){
        return new SQL(){
            {
                UPDATE("fw_baoxiu");
                SET()
            }
        }.toString();
    }*/

    public String findBaoxiuEq(String userId,String bmName,String eqName){
        String sql = "SELECT\n" +
                "bm.bm_name,eq.eq_id,\n" +
                "eq.eq_name,\n" +
                "eq.eq_sbbh,\n" +
                "eq.eq_zcbh,\n" +
                "eq.eq_xh,\n" +
                "eq.eq_gg,\n" +
                "eq.eq_qysj\n" +
                "\n" +
                "FROM\n" +
                "dbo.eq_info AS eq ,\n" +
                "dbo.s_bm AS bm ,\n" +
                "dbo.s_emp AS emp\n" +
                "WHERE\n" +
                "eq.eq_bmid = bm.bm_id AND\n" +
                "bm.bm_id = emp.bm_id AND\n" +
                "emp.user_id = #{userId}";
        if(StringUtils.isNotBlank(eqName)){
            sql+=" and eq.eq_name like '%'+#{eqName}+'%'";
        }
        if(StringUtils.isNotBlank(bmName)){
            sql+=" and bm.bm_name like '%'+#{bmName}+'%'";
        }
        return sql;
    }
    public String listFwBaoxiuVo(Integer status){
        return new SQL(){
            {
                SELECT("fw_baoxiu.id as fpDh,eq_name,eq_gg,eq_xh,wxf_cjrgf,bm_name");
                FROM("fw_baoxiu");
                INNER_JOIN("eq_info on eq_info.eq_id=fw_baoxiu.eq_id");
                INNER_JOIN("fw_wxf ON fw_wxf.fw_id = fw_baoxiu.id");
                INNER_JOIN("s_bm on eq_info.eq_bmid =  s_bm.bm_id");
                WHERE("bx_status=#{status}");
            }
        }.toString();
    }
}
