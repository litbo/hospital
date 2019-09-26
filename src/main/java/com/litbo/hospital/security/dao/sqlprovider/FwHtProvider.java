package com.litbo.hospital.security.dao.sqlprovider;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author zjc
 * @create 2019-04-12 19:43
 */
public class FwHtProvider {

    public String getAllFwHt(String htName, String sbcsName){
       return  new SQL(){
           {
               SELECT("ht.id,ht.ht_name,ht.ht_price,ht.ht_time,cs.sbcs_name,ht.ht_status,cs.sbcs_id");
               FROM("fw_ht AS ht ,eq_cs AS cs");
               WHERE("ht.sbcs_id = cs.sbcs_id");
               if(StringUtils.isNotBlank(htName)){
                   WHERE("ht.ht_name like '%'+#{htName}+'%'");
               }
               if(StringUtils.isNotBlank(sbcsName)){
                   WHERE("cs.sbcs_name like '%'+#{sbcsName}+'%'");
               }
           }
       }.toString();
    }

    public String getFwHtByStatus(Integer htStatus, String htName, String sbcsName){
        return  new SQL(){
            {
                SELECT("ht.id,ht.ht_name,ht.ht_price,ht.ht_time,ht.ht_zffs,cs.sbcs_name");
                FROM("fw_ht AS ht ,eq_cs AS cs");
                WHERE("ht.sbcs_id = cs.sbcs_id");
                //if(StringUtils.isNotBlank(htStatus)){
                    WHERE("ht.ht_status = #{htStatus}");
               // }
                if(StringUtils.isNotBlank(htName)){
                    WHERE("ht.ht_name like '%'+#{htName}+'%'");
                }
                if(StringUtils.isNotBlank(sbcsName)){
                    WHERE("cs.sbcs_name like '%'+#{sbcsName}+'%'");
                }
            }
        }.toString();
    }

}
