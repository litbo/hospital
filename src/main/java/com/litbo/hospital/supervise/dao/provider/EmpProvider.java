package com.litbo.hospital.supervise.dao.provider;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class EmpProvider {
    public String selectEmpsByX(String bmId,String userId,String status){
/**
                SELECT bm.bm_name,emp.user_xm,emp.user_id, sex.sex,xllb.xllb,zwlb.zwlb,emp.byyx\n" +
                " from s_emp emp\n" +
                " LEFT JOIN s_bm bm ON (emp.bm_id=bm.bm_id)\n" +
                " LEFT JOIN s_sex sex ON (sex.sex_id=emp.sex_id)\n" +
                " LEFT JOIN s_xllb xllb ON (xllb.xllb_id=emp.xllb_id)\n" +
                " LEFT JOIN s_zwlb zwlb ON (zwlb.zwlb_id=emp.zwlb_id)")*/
        StringBuffer sql = new StringBuffer("" +
                "  SELECT bm.bm_name, emp.user_xm, emp.user_id, sex.sex, xllb.xllb, zwlb.zwlb, emp.byyx" +
                "  from s_emp emp " +
                "  LEFT JOIN s_bm bm ON (emp.bm_id=bm.bm_id)" +
                "  LEFT JOIN s_sex sex ON (sex.sex_id=emp.sex_id) " +
                "  LEFT JOIN s_xllb xllb ON (xllb.xllb_id=emp.xllb_id)" +
                "  LEFT JOIN s_zwlb zwlb ON (zwlb.zwlb_id=emp.zwlb_id) where 1=1" );
        if(!"0000000000".equals(bmId))  sql.append(" and bm.bm_id Like '%'+#{bmId}+'%'");
        if(userId!=null) sql.append(" and emp.user_id like '%'+#{userId}+'%' ");
        if(status!=null) sql.append(" and emp.status like  '%'+#{status}+'%' ");
        return sql.toString();
    }

    public String selectEmpByIdOrName(String userId,String userXm){
        return new SQL(){
            {
                SELECT("emp.user_id AS empId,emp.user_xm,bm.bm_name");
                FROM("s_emp AS emp , s_bm AS bm");
                WHERE("emp.bm_id = bm.bm_id");
                if(StringUtils.isNotBlank(userId)){
                    WHERE("emp.user_id = #{userId}");
                }
                if(StringUtils.isNotBlank(userXm)){
                    WHERE("emp.user_xm like '%'+#{userXm}+'%'");
                }
            }
        }.toString();
    }
}
