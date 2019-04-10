package com.litbo.hospital.supervise.dao.provider;

import com.litbo.hospital.supervise.vo.EqCsSelectVO;

public class EqCsProvider {

    public String listEqCsVO(EqCsSelectVO selectVo){
        StringBuffer sql = new StringBuffer("" +
                "select  cs.sbcs_id,cs.sb_cslb_id,cs.gb_id,cs.jg_id,cs.sbcs_name,cs.sbcs_address,cs.email,\n" +
                "cs.sbcs_lxr1,cs.sbcs_lxr2,cs.sbcs_lxr3,cs.sbcs_lxdh1,cs.sbcs_lxdh2,cs.sbcs_lxdh3,cs.sbcs_csdm,\n" +
                "cs.sbcs_fax,lb.eq_cslb_name as sbCslbName,gb.gb as gbName,jp.jg as jdName\n" +
                "from eq_cs cs \n" +
                "LEFT JOIN eq_cslb lb on (lb.eq_cslb_id=cs.sbcs_id) \n" +
                "LEFT JOIN s_gb gb ON (cs.gb_id=gb.gb_id) \n" +
                "LEFT JOIN s_jg jp ON (cs.jg_id=jp.jg_id)" );
        if(selectVo.getEqCslb()!=null)  sql.append(" and cs.sb_cslb_id = #{eqCslb}");
        if(selectVo.getSbcsName()!=null) sql.append(" and cs.sbcs_name like  '%'+#{sbcsName}+'%'");
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
