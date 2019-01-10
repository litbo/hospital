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
}