package com.litbo.hospital.beneficial.dao.provider;

import com.litbo.hospital.beneficial.vo.CbMhVo;

public class CwProvider {
    public String listZjcb(){

        String sql = "SELECT "+
        "Max(bm_name) AS bmName, "+
        "Max(eq_name) AS eqName, "+
        "Max(dbo.eq_info.eq_sbbh) AS eqNum, "+
        "Max(dbo.eq_info.eq_xh) AS eqXh, "+
        "sum(case km_name when '人员经费' then km_value ELSE 0 END) AS ryjf, "+
        "sum(case km_name when '卫生材料费' then km_value ELSE 0 END) AS wsclf, "+
        "sum(case km_name when '药品费' then km_value ELSE 0 END) AS ypf, "+
        "sum(case km_name when '固定资产折旧费' then km_value ELSE 0 END) AS gdzczjf, "+
        "sum(case km_name when '无形资产摊销费' then km_value ELSE 0 END) AS wxzctxf, "+
        "sum(case km_name when '医疗风险费' then km_value ELSE 0 END) AS ylfxf, "+
        "sum(case km_name when '水费' then km_value ELSE 0  END) +sum(case km_name when '电费' then km_value ELSE 0  END) +sum(case km_name when '维保费' then km_value ELSE 0  END) + sum(case km_name when '配件费' then km_value ELSE 0  END) AS qt, "+
        "sum(case km_cjdm when '1' then km_value ELSE 0  END) AS zj "+
        "FROM "+
        "dbo.b_sbcw , "+
                "dbo.eq_info "+
        "WHERE "+
        "dbo.b_sbcw.eq_id = dbo.eq_info.eq_id "+
        "GROUP BY "+
        "dbo.b_sbcw.eq_id ";


        return sql;
    }

    public String listZjcbByX(CbMhVo cbMhVo){

        StringBuffer sql = new StringBuffer("SELECT "+
                "Max(bm_name) AS bmName, "+
                "Max(eq_name) AS eqName, "+
                "Max(dbo.eq_info.eq_sbbh) AS eqNum, "+
                "Max(dbo.eq_info.eq_xh) AS eqXh, "+
                "sum(case km_name when '人员经费' then km_value ELSE 0 END) AS ryjf, "+
                "sum(case km_name when '卫生材料费' then km_value ELSE 0 END) AS wsclf, "+
                "sum(case km_name when '药品费' then km_value ELSE 0 END) AS ypf, "+
                "sum(case km_name when '固定资产折旧费' then km_value ELSE 0 END) AS gdzczjf, "+
                "sum(case km_name when '无形资产摊销费' then km_value ELSE 0 END) AS wxzctxf, "+
                "sum(case km_name when '医疗风险费' then km_value ELSE 0 END) AS ylfxf, "+
                "sum(case km_name when '水费' then km_value ELSE 0  END) +sum(case km_name when '电费' then km_value ELSE 0  END) +sum(case km_name when '维保费' then km_value ELSE 0  END) + sum(case km_name when '配件费' then km_value ELSE 0  END) AS qt, "+
                "sum(case km_cjdm when '1' then km_value ELSE 0  END) AS zj "+

                "FROM "+
                "dbo.b_sbcw , "+
                "dbo.eq_info "+
                "WHERE "+
                "dbo.b_sbcw.eq_id = dbo.eq_info.eq_id "
                );

        if(cbMhVo.getBmNameByx()!=null) {
            sql.append("and bm_name Like #{bmNameByx}");
        }
        if(cbMhVo.getEqNameByx()!=null){
            sql.append("and eq_name Like #{eqNameByx}");
        }
        if((cbMhVo.getKssj()!=null)&&(cbMhVo.getJssj()==null)){
            sql.append("and km_sj BETWEEN #{kssj} AND '3000-01-01'" );
        }
        if((cbMhVo.getKssj()==null)&&(cbMhVo.getJssj()!=null)){
            sql.append("and km_sj BETWEEN '1900-1-1' AND #{jssj}" );
        }
        if((cbMhVo.getKssj()!=null)&&(cbMhVo.getJssj()!=null)){
            sql.append("and km_sj BETWEEN #{kssj} AND #{jssj}" );
        }

        sql.append("GROUP BY " +
                               "dbo.b_sbcw.eq_id ");

        return sql.toString();
    }

    public String listJjcb(){
        String sql = "SELECT "+
        "Max(bm_name) as bmName, "+
        "Max(eq_name) as eqName, "+
        "Max(dbo.eq_info.eq_sbbh) AS eqNum, "+
        "Max(dbo.eq_info.eq_xh) AS eqXh, "+
        "sum(case km_name when '管理费用' then km_value ELSE 0 END) AS glfy, "+
        "sum(case km_name when '辅助科室分摊' then km_value ELSE 0 END) AS fzkscb, "+
        "sum(case km_cjdm when '2' then km_value ELSE 0  END) AS zj "+

        "FROM "+
        "dbo.b_sbcw, "+
                "dbo.eq_info "+

        "WHERE "+
        "dbo.b_sbcw.eq_id = dbo.eq_info.eq_id "+
        "GROUP BY "+
        "dbo.b_sbcw.eq_id ; ";
        return sql;
    }

    public String listJjcbByX(CbMhVo cbMhVo){
        StringBuffer sql = new StringBuffer("SELECT "+
                "Max(bm_name) as bmName, "+
                "Max(eq_name) as eqName, "+
                "Max(dbo.eq_info.eq_sbbh) AS eqNum, "+
                "Max(dbo.eq_info.eq_xh) AS eqXh, "+
                "sum(case km_name when '管理费用' then km_value ELSE 0 END) AS glfy, "+
                "sum(case km_name when '辅助科室分摊' then km_value ELSE 0 END) AS fzkscb, "+
                "sum(case km_cjdm when '2' then km_value ELSE 0  END) AS zj "+

                "FROM "+
                "dbo.b_sbcw, "+
                "dbo.eq_info "+

                "WHERE "+
                "dbo.b_sbcw.eq_id = dbo.eq_info.eq_id ");
;
        if(cbMhVo.getBmNameByx()!=null) {
            sql.append("and bm_name Like #{bmNameByx}");
        }
        if(cbMhVo.getEqNameByx()!=null){
            sql.append("and eq_name Like #{eqNameByx}");
        }
        if((cbMhVo.getKssj()!=null)&&(cbMhVo.getJssj()==null)){
            sql.append("and km_sj BETWEEN #{kssj} AND '3000-01-01'" );
        }
        if((cbMhVo.getKssj()==null)&&(cbMhVo.getJssj()!=null)){
            sql.append("and km_sj BETWEEN '1900-1-1' AND #{jssj}" );
        }
        if((cbMhVo.getKssj()!=null)&&(cbMhVo.getJssj()!=null)){
            sql.append("and km_sj BETWEEN #{kssj} AND #{jssj}" );
        }
        sql.append("GROUP BY " +
                "dbo.b_sbcw.eq_id ");

        return sql.toString();
    }

    public String listSr(){
        String sql = "SELECT "+
                "Max(bm_name) as bmName, "+
                "Max(eq_name) as eqName, "+
                "Max(dbo.eq_info.eq_sbbh) AS eqNum, "+
                "Max(dbo.eq_info.eq_xh) AS eqXh, "+
                "sum(case km_name when '门诊收入' then km_value ELSE 0 END) AS mzsr, "+
                "sum(case km_name when '住院收入' then km_value ELSE 0 END) AS zysr, "+
                "sum(case km_cjdm when '3' then km_value ELSE 0  END) -sum(case km_name when '门诊收入' then km_value ELSE 0 END) -sum(case km_name when '住院收入' then km_value ELSE 0 END) AS qt, "+
                "sum(case km_cjdm when '3' then km_value ELSE 0  END) AS zj "+

                "FROM "+
                "dbo.b_sbcw, "+
                "dbo.eq_info "+

                "WHERE "+
                "dbo.b_sbcw.eq_id = dbo.eq_info.eq_id "+
                "GROUP BY "+
                "dbo.b_sbcw.eq_id ; ";
        return sql;
    }

    public String listSrByX(CbMhVo cbMhVo){
        StringBuffer sql = new StringBuffer("SELECT "+
                "Max(bm_name) as bmName, "+
                "Max(eq_name) as eqName, "+
                "Max(dbo.eq_info.eq_sbbh) AS eqNum, "+
                "Max(dbo.eq_info.eq_xh) AS eqXh, "+
                "sum(case km_name when '门诊收入' then km_value ELSE 0 END) AS mzsr, "+
                "sum(case km_name when '住院收入' then km_value ELSE 0 END) AS zysr, "+
                "sum(case km_cjdm when '3' then km_value ELSE 0  END) -sum(case km_name when '门诊收入' then km_value ELSE 0 END) -sum(case km_name when '住院收入' then km_value ELSE 0 END) AS qt, "+
                "sum(case km_cjdm when '3' then km_value ELSE 0  END) AS zj "+

                "FROM "+
                "dbo.b_sbcw, "+
                "dbo.eq_info "+

                "WHERE "+
                "dbo.b_sbcw.eq_id = dbo.eq_info.eq_id ");
        ;
        if(cbMhVo.getBmNameByx()!=null) {
            sql.append("and bm_name Like #{bmNameByx}");
        }
        if(cbMhVo.getEqNameByx()!=null){
            sql.append("and eq_name Like #{eqNameByx}");
        }
        if((cbMhVo.getKssj()!=null)&&(cbMhVo.getJssj()==null)){
            sql.append("and km_sj BETWEEN #{kssj} AND '3000-01-01'" );
        }
        if((cbMhVo.getKssj()==null)&&(cbMhVo.getJssj()!=null)){
            sql.append("and km_sj BETWEEN '1900-1-1' AND #{jssj}" );
        }
        if((cbMhVo.getKssj()!=null)&&(cbMhVo.getJssj()!=null)){
            sql.append("and km_sj BETWEEN #{kssj} AND #{jssj}" );
        }
        sql.append("GROUP BY " +
                "dbo.b_sbcw.eq_id ");

        return sql.toString();
    }

    public String listXyFx(){
        String sql = "SELECT "+
        "Max(dbo.b_sbcw.bm_name) AS bmName, "+
        "Max(dbo.b_sbcw.eq_name) AS eqName, "+
        "Max(dbo.eq_info.eq_sbbh) AS eqNum, "+
        "Max(dbo.eq_info.eq_xh) AS eqXh, "+
        "Sum(case km_cjdm when '3' then km_value ELSE 0  END) AS sr, "+
        "Sum(case km_cjdm when '1' then km_value ELSE 0  END) +SUM(case km_cjdm when '2' then km_value ELSE 0  END) cb, "+
        "SUM(case km_name when '住院收入' then qjlc ELSE 0  END) as qjlc "+


        "FROM "+
        "dbo.b_sbcw , "+
        "dbo.eq_info "+
        "WHERE "+
        "dbo.b_sbcw.eq_id = dbo.eq_info.eq_id "+

        "GROUP BY "+
        "dbo.b_sbcw.eq_id ";
        return sql;
    }

    public String listXyFxByX(CbMhVo cbMhVo){
        StringBuffer sql = new StringBuffer("SELECT "+
                "Max(dbo.b_sbcw.bm_name) AS bmName, "+
                "Max(dbo.b_sbcw.eq_name) AS eqName, "+
                "Max(dbo.eq_info.eq_sbbh) AS eqNum, "+
                "Max(dbo.eq_info.eq_xh) AS eqXh, "+
                "Sum(case km_cjdm when '3' then km_value ELSE 0  END) AS sr, "+
                "Sum(case km_cjdm when '1' then km_value ELSE 0  END) +SUM(case km_cjdm when '2' then km_value ELSE 0  END) cb, "+
                "SUM(case km_name when '住院收入' then qjlc ELSE 0  END) as qjlc "+


                "FROM "+
                "dbo.b_sbcw , "+
                "dbo.eq_info "+
                "WHERE "+
                "dbo.b_sbcw.eq_id = dbo.eq_info.eq_id ");
        ;
        if(cbMhVo.getBmNameByx()!=null) {
            sql.append("and bm_name Like #{bmNameByx}");
        }
        if(cbMhVo.getEqNameByx()!=null){
            sql.append("and eq_name Like #{eqNameByx}");
        }
        if((cbMhVo.getKssj()!=null)&&(cbMhVo.getJssj()==null)){
            sql.append("and km_sj BETWEEN #{kssj} AND '3000-01-01'" );
        }
        if((cbMhVo.getKssj()==null)&&(cbMhVo.getJssj()!=null)){
            sql.append("and km_sj BETWEEN '1900-1-1' AND #{jssj}" );
        }
        if((cbMhVo.getKssj()!=null)&&(cbMhVo.getJssj()!=null)){
            sql.append("and km_sj BETWEEN #{kssj} AND #{jssj}" );
        }
        sql.append("GROUP BY " +
                "dbo.b_sbcw.eq_id ");

        return sql.toString();
    }
}
