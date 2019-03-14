package com.litbo.hospital.security.dao.sqlprovider;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Date;

/**
 * @author zjc
 * @create 2019-03-14 8:59
 */
public class WxfProvider {

    public String updateWxf(Integer id , String wxfSpyj, Date wxfSptime){
        return new SQL(){
            {
                UPDATE("fw_wxf");
                if(StringUtils.isNotBlank(wxfSpyj))
                SET("wxf_spyj = #{wxfSpyj}");
                if(wxfSptime != null)
                SET("wxf_sptime= #{wxfSptime}");
                SET("wxf_status = 1");
                WHERE("id = #{id}");
            }
        }.toString();
    }

}
