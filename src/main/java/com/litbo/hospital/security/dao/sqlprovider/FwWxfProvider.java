package com.litbo.hospital.security.dao.sqlprovider;

import org.apache.commons.lang3.StringUtils;

/**
 * @author zjc
 * @create 2019-03-25 23:29
 */
public class FwWxfProvider {

    public String WxfList(String userId, String fwId, String eqName){
        StringBuffer sql = new StringBuffer(""+
                "SELECT\n" +
                "shouli.id AS fwId,\n" +
                "eq.eq_name,\n" +
                "bm.bm_name,\n" +
                "baoxiu.bx_time,\n" +
                "wxf.wxf_status\n" +
                "FROM\n" +
                "dbo.fw_shouli AS shouli \n" +
                "LEFT JOIN dbo.fw_baoxiu AS baoxiu ON shouli.id = baoxiu.id\n" +
                "LEFT JOIN dbo.eq_info AS eq ON baoxiu.eq_id = eq.eq_id\n" +
                "LEFT JOIN dbo.s_bm AS bm ON baoxiu.bxks_id = bm.bm_id\n" +
                "LEFT JOIN fw_wxf AS wxf ON baoxiu.id = wxf.fw_id\n" +
                "WHERE\n" +
                "shouli.slr_id = #{userId} AND\n" +
                "baoxiu.bx_status = 100 AND\n" +
                "wxf.wxf_status IS NULL");
        if(StringUtils.isNotBlank(fwId)){
            sql.append(" and shouli.id = #{fwId}");
        }
        if(StringUtils.isNotBlank(eqName)){
            sql.append(" and eq.eq_name Like '%'+#{eqName}+'%'");
        }
        return sql.toString();
    }

}
