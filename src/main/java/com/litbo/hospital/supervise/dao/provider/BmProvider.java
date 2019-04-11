package com.litbo.hospital.supervise.dao.provider;

import com.litbo.hospital.supervise.vo.BmSelectVO;

public class BmProvider {
    public String listKgsBm(String bmName){
        StringBuffer sql = new StringBuffer("select * from s_bm where (bm_id='0000000000' or xbm_flag=0)" );
        if(bmName!=null&&!bmName.equals(""))  sql.append("and bm_name Like '%'+#{bmName}+'%'");
        return sql.toString();
    }
    public String selectBmByX(BmSelectVO selectVo){
        StringBuffer sql = new StringBuffer("select bm_id, bm_name, user_id, bm_tel, bm_addr, wx_flag, p_bm_id,obm_id,xbm_flag from s_bm where 1=1 and bm_id!='0000000000'" );
        if(selectVo.getBmName()!=null)  sql.append(" and bm_name Like '%'+#{bmName}+'%'");
        if(selectVo.getBmlb()!=null) sql.append(" and bm_id Like #{bmlb}+'%'");
        if(selectVo.getGklb()!=null)  sql.append(" and eq_sbbh LIKE #{gklb}+'%'" );
        if(selectVo.getIsWx()!=null)  sql.append(" and wx_flag = #{isWx}");
        return sql.toString();
    }

    public String listBmsAsLbBmsBySelectVO(BmSelectVO selectVo){
        StringBuffer sql = new StringBuffer("select * from s_bm where 1=1 " );

        if(selectVo.getBmName()!=null)  sql.append(" and bm_name Like '%'+#{bmName}+'%'");
        if(selectVo.getFlag()==1){
            if(selectVo.getBmlb()!=null) sql.append(" and bm_id Like #{bmlb}+'%'");
        }else if(selectVo.getFlag()==2){
            sql.append(" and bm_id LIKE '02'+'%'" );
            if(selectVo.getGklb()!=null)  sql.append(" and bm_id LIKE #{gklb}+'%'" );
        }else if(selectVo.getFlag()==3){
            sql.append(" and bm_id LIKE '02'+'%'" );
            if(selectVo.getIsWx()!=null)  sql.append(" and wx_flag = #{isWx}");
        }



        return sql.toString();
    }
}
