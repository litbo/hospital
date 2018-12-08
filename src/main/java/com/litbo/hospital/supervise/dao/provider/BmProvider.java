package com.litbo.hospital.supervise.dao.provider;

import com.litbo.hospital.supervise.vo.BmSelectVO;

public class BmProvider {

    public String selectBmByX(BmSelectVO selectVo){
        StringBuffer sql = new StringBuffer("select bm_id, bm_name, user_id, bm_tel, bm_addr, wx_flag, p_bm_id,obm_id,xbm_flag from s_bm where 1=1" );
        if(selectVo.getBmName()!=null)  sql.append(" and bm_name Like #{bmName}");
        if(selectVo.getBmlb()!=null) sql.append(" and bm_id Like #{bmlb}");
        if(selectVo.getGklb()!=null)  sql.append(" and eq_sbbh LIKE #{gklb}" );
        if(selectVo.getIsWx()!=null)  sql.append(" and wx_flag = #{isWx}");
        return sql.toString();
    }
}