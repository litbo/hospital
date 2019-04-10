package com.litbo.hospital.supervise.dao.provider;

import com.litbo.hospital.supervise.vo.EqCsSelectVO;

public class EqCsProvider {

    public String listEqCsVO(EqCsSelectVO selectVo){
        StringBuffer sql = new StringBuffer("select * from eq_cs where 1=1" );
        if(selectVo.getEqCslb()!=null)  sql.append(" and sb_cslb_id = #{eqCslb}");
        if(selectVo.getSbcsName()!=null) sql.append(" and sbcs_name like  '%'+#{sbcsName}+'%'");
        return sql.toString();
    }

    public String selectEqCsByX(EqCsSelectVO selectVo){
        StringBuffer sql = new StringBuffer("select * from eq_cs where 1=1" );
        if(selectVo.getEqCslb()!=null)  sql.append(" and sb_cslb_id = #{eqCslb}");
        if(selectVo.getSbcsName()!=null) sql.append(" and sbcs_name like  '%'+#{sbcsName}+'%'");
        return sql.toString();
    }
    public String selectEqCsByX1(EqCsSelectVO selectVo){
        StringBuffer sql = new StringBuffer("select sbcs_id as sbcs_id1,sbcs_name,sbcs_lxr1,sbcs_lxdh1,email from eq_cs where 1=1" );
        if(selectVo.getEqCslb()!=null)  sql.append(" and sb_cslb_id = #{eqCslb}");
        if(selectVo.getSbcsName()!=null) sql.append(" and sbcs_name like  '%'+#{sbcsName}+'%'");
        return sql.toString();
    }
}
