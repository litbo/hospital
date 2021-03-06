package com.litbo.hospital.beneficial.dao.provider;

import com.litbo.hospital.beneficial.vo.CbMhVo;
import org.apache.commons.lang3.StringUtils;

public class CwProvider {
    public String listZjcb() {

        String sql = "<script> SELECT " +
                "Max(dbo.b_sbcw.bm_name) AS bmName, " +
                "Max(dbo.b_sbcw.eq_name) AS eqName, " +
                "Max(dbo.eq_info.eq_zcbh) AS eqNum, " +
                "Max(dbo.eq_info.eq_xh) AS eqXh, " + "Max(dbo.eq_info.eq_gg) AS eqGg, " +
                "sum(case dbo.b_sbcw.km_name when '人员经费' then km_value ELSE 0 END) AS ryjf, " +
                "sum(case dbo.b_sbcw.km_name when '卫生材料费' then km_value ELSE 0 END) AS wsclf, " +
                "sum(case dbo.b_sbcw.km_name when '药品费' then km_value ELSE 0 END) AS ypf, " +
                "sum(case dbo.b_sbcw.km_name when '固定资产折旧费' then km_value ELSE 0 END) AS gdzczjf, " +
                "sum(case dbo.b_sbcw.km_name when '医疗设备折旧' then km_value ELSE 0 END) AS ylsbzjf, " +

                "sum(case dbo.b_sbcw.km_name when '无形资产摊销费' then km_value ELSE 0 END) AS wxzctxf, " +
                "sum(case dbo.b_sbcw.km_name when '医疗风险费' then km_value ELSE 0 END) AS ylfxf, " +
                "sum(case dbo.b_sbcw.km_name when '水费' then km_value ELSE 0  END) +sum(case km_name when '电费' then km_value ELSE 0  END) +sum(case km_name when '维保费' then km_value ELSE 0  END) + sum(case km_name when '配件费' then km_value ELSE 0  END) AS qt, " +
                "sum(case dbo.b_sbcw.km_cjdm when '3' then km_value ELSE 0  END) AS zj " +
                "FROM " +
                "dbo.b_sbcw , " +
                "dbo.eq_info " +
                "WHERE\n " +
                "dbo.b_sbcw.eq_id = dbo.eq_info.eq_zcbh \n" +
                "<if test = \" qssj!=null \">" +
                "and dbo.b_sbcw.km_sj &gt;=#{qssj} " +
                "</if>" +
                "<if test = \" jssj!=null \">" +
                "and dbo.b_sbcw.km_sj &lt;=#{jssj} " +
                "</if>" +
                "<if test = \" bmName!=null and bmName!='' \">" +
                "and dbo.b_sbcw.bm_name =#{bmName} " +
                "</if>" +
                "<if test = \" eqName!=null and eqName!='' \">" +
                "and dbo.b_sbcw.eq_name like concat( '%', #{eqName}, '%') " +
                "</if>" +
                "GROUP BY " +
                "dbo.b_sbcw.eq_id order by  eqNum" +
                "</script>";


        return sql;
    }

    public String listZjcbByX(CbMhVo cbMhVo) {

        StringBuffer sql = new StringBuffer("SELECT " +
                "Max(dbo.b_sbcw.bm_name) AS bmName, " +
                "Max(dbo.b_sbcw.eq_name) AS eqName, " +
                "Max(dbo.eq_info.eq_zcbh) AS eqNum, " +
                "Max(dbo.eq_info.eq_xh) AS eqXh, " + "Max(dbo.eq_info.eq_gg) AS eqGg, " +
                "sum(case dbo.b_sbcw.km_name when '人员经费' then km_value ELSE 0 END) AS ryjf, " +
                "sum(case dbo.b_sbcw.km_name when '卫生材料费' then km_value ELSE 0 END) AS wsclf, " +
                "sum(case dbo.b_sbcw.km_name when '药品费' then km_value ELSE 0 END) AS ypf, " +
                "sum(case dbo.b_sbcw.km_name when '固定资产折旧费' then km_value ELSE 0 END) AS gdzczjf, " +
                "sum(case dbo.b_sbcw.km_name when '医疗设备折旧' then km_value ELSE 0 END) AS ylsbzjf, " +
                "sum(case dbo.b_sbcw.km_name when '无形资产摊销费' then km_value ELSE 0 END) AS wxzctxf, " +
                "sum(case dbo.b_sbcw.km_name when '医疗风险费' then km_value ELSE 0 END) AS ylfxf, " +
                "sum(case dbo.b_sbcw.km_name when '水费' then km_value ELSE 0  END) +sum(case km_name when '电费' then km_value ELSE 0  END) +sum(case km_name when '维保费' then km_value ELSE 0  END) + sum(case km_name when '配件费' then km_value ELSE 0  END) AS qt, " +
                "sum(case dbo.b_sbcw.km_cjdm when '1' then km_value ELSE 0  END) AS zj " +
                "FROM " +
                "dbo.b_sbcw , " +
                "dbo.eq_info " +
                "WHERE " +
                "dbo.b_sbcw.eq_id = dbo.eq_info.eq_zcbh \n "
        );

        if (StringUtils.isNotBlank(cbMhVo.getBmNameByx())) {
            sql.append("and dbo.b_sbcw.bm_name Like '%'+ #{bmNameByx}+'%' ");
        }
        if (StringUtils.isNotBlank(cbMhVo.getEqNameByx())) {
            sql.append("and dbo.b_sbcw.eq_name Like '%'+ #{eqNameByx}+'%' ");
        }
        if ((cbMhVo.getKssj() != null) && (cbMhVo.getJssj() == null)) {
            sql.append("and dbo.b_sbcw.km_sj BETWEEN #{kssj} AND '3000-01-01'");
        }
        if ((cbMhVo.getKssj() == null) && (cbMhVo.getJssj() != null)) {
            sql.append("and dbo.b_sbcw.km_sj BETWEEN '1900-1-1' AND #{jssj}");
        }
        if ((cbMhVo.getKssj() != null) && (cbMhVo.getJssj() != null)) {
            sql.append("and km_sj BETWEEN #{kssj} AND #{jssj}");
        }
        /*if((StringUtils.isNotBlank((CharSequence) cbMhVo.getKssj())) && (StringUtils.isBlank((CharSequence) cbMhVo.getJssj()))){
            sql.append("and dbo.b_sbcw.km_sj BETWEEN #{kssj} AND '3000-01-01'" );
        }
        if((StringUtils.isBlank((CharSequence) cbMhVo.getKssj()))&&(StringUtils.isNotBlank((CharSequence) cbMhVo.getJssj()))){
            sql.append("and dbo.b_sbcw.km_sj BETWEEN '1900-1-1' AND #{jssj}" );
        }
        if((StringUtils.isNotBlank((CharSequence) cbMhVo.getKssj()))&&(StringUtils.isNotBlank((CharSequence) cbMhVo.getJssj()))) {
            sql.append("and km_sj BETWEEN #{kssj} AND #{jssj}");

        }*/


        sql.append("GROUP BY \n" +
                "dbo.b_sbcw.eq_id order by  eqNum");

        return sql.toString();
    }

    public String listJjcb() {
        String sql = "<script>SELECT " +
                "Max(dbo.b_sbcw.bm_name) as bmName, " +
                "Max(dbo.b_sbcw.eq_name) as eqName, " +
                "Max(dbo.eq_info.eq_zcbh) AS eqNum, " +
                "Max(dbo.eq_info.eq_xh) AS eqXh, " + "Max(dbo.eq_info.eq_gg) AS eqGg, " +
                "sum(case km_name when '管理费用' then km_value ELSE 0 END) AS glfy, " +
                "sum(case km_name when '辅助科室分摊' then km_value ELSE 0 END) AS fzkscb, " +
                "sum(case km_name when '其他支出' then km_value ELSE 0 END) AS qt, " +
                "sum(case km_cjdm when '1' then km_value ELSE 0  END) AS zj " +

                "FROM " +
                "dbo.b_sbcw, " +
                "dbo.eq_info " +

                "WHERE " +
                "dbo.b_sbcw.eq_id = dbo.eq_info.eq_zcbh \n" +
                "<if test=\" qssj!=null\">" +
                " and dbo.b_sbcw.km_sj &gt;=#{qssj} " +
                "</if>" +
                "<if test=\" jssj!=null\">" +
                " and dbo.b_sbcw.km_sj &lt;=#{jssj} " +
                "</if>" +
                "<if test = \" bmName!=null and bmName!='' \">" +
                "and dbo.b_sbcw.bm_name =#{bmName} " +
                "</if>" +
                "<if test = \" eqName!=null and eqName!='' \">" +
                "and dbo.b_sbcw.eq_name like concat( '%', #{eqName}, '%') " +
                "</if>" +
                " GROUP BY " +
                "dbo.b_sbcw.eq_id  order by  eqNum</script> ";
        return sql;
    }

    public String listJjcbByX(CbMhVo cbMhVo) {
        StringBuffer sql = new StringBuffer("<script> SELECT " +
                "Max(dbo.b_sbcw.bm_name) as bmName, " +
                "Max(dbo.b_sbcw.eq_name) as eqName, " +
                "Max(dbo.eq_info.eq_zcbh) AS eqNum, " +
                "Max(dbo.eq_info.eq_xh) AS eqXh, " + "Max(dbo.eq_info.eq_gg) AS eqGg, " +
                "sum(case km_name when '管理费用' then km_value ELSE 0 END) AS glfy, " +
                "sum(case km_name when '辅助科室分摊' then km_value ELSE 0 END) AS fzkscb, " +
                "sum(case km_cjdm when '2' then km_value ELSE 0  END) AS zj " +

                "FROM " +
                "dbo.b_sbcw, " +
                "dbo.eq_info " +

                "WHERE " +
                "dbo.b_sbcw.eq_id = dbo.eq_info.eq_zcbh \n" +
                "<if test=\" \">" +
                "</if>");

        /*if(StringUtils.isNotBlank(cbMhVo.getBmNameByx())) {
            sql.append("and dbo.b_sbcw.bm_name Like '%'+ #{bmNameByx}+'%' ");
        }
        if(StringUtils.isNotBlank(cbMhVo.getEqNameByx())){
            sql.append("and dbo.b_sbcw.eq_name Like '%'+ #{eqNameByx}+'%' " );
        }
        if ((cbMhVo.getKssj()!=null) && (cbMhVo.getJssj()==null)){
            sql.append("and dbo.b_sbcw.km_sj BETWEEN #{kssj} AND '3000-01-01'" );

        }
        if((cbMhVo.getKssj()==null)&&( cbMhVo.getJssj()!=null)){
            sql.append("and dbo.b_sbcw.km_sj BETWEEN '1900-1-1' AND #{jssj}" );
        }
        if(( cbMhVo.getKssj()!=null)&&( cbMhVo.getJssj()!=null)) {
            sql.append("and km_sj BETWEEN #{kssj} AND #{jssj}");
        }*/
        /*if((StringUtils.isNotBlank((CharSequence) cbMhVo.getKssj())) && (StringUtils.isBlank((CharSequence) cbMhVo.getJssj()))){
            sql.append("and dbo.b_sbcw.km_sj BETWEEN #{kssj} AND '3000-01-01'" );
        }
        if((StringUtils.isBlank((CharSequence) cbMhVo.getKssj()))&&(StringUtils.isNotBlank((CharSequence) cbMhVo.getJssj()))){
            sql.append("and dbo.b_sbcw.km_sj BETWEEN '1900-1-1' AND #{jssj}" );
        }
        if((StringUtils.isNotBlank((CharSequence) cbMhVo.getKssj()))&&(StringUtils.isNotBlank((CharSequence) cbMhVo.getJssj()))){
            sql.append("and km_sj BETWEEN #{kssj} AND #{jssj}" );
        }*/
        sql.append(" GROUP BY " +
                "dbo.b_sbcw.eq_id order by  eqNum </script>");

        return sql.toString();
    }

    public String listSr() {
        String sql = "<script> SELECT " +
                "Max(dbo.b_sbcw.bm_name) as bmName, " +
                "Max(dbo.b_sbcw.eq_name) as eqName, " +
                "Max(dbo.eq_info.eq_zcbh) AS eqNum, " +
                "Max(dbo.eq_info.eq_xh) AS eqXh, " + "Max(dbo.eq_info.eq_gg) AS eqGg, " +
                "sum(case km_name when '门诊收入' then km_value ELSE 0 END) AS mzsr, " +
                "sum(case km_name when '科教项目收入' then km_value ELSE 0 END) AS kjxmsr, " +
                "sum(case km_name when '住院收入' then km_value ELSE 0 END) AS zysr, " +
                "sum(case km_name when '其他收入' then km_value     ELSE 0 END) AS qt " +
//                "sum(case km_cjdm when '3' then km_value ELSE 0  END) -sum(case km_name when '门诊收入' then km_value ELSE 0 END) -sum(case km_name when '住院收入' then km_value ELSE 0 END) AS qt, "+

//                "sum(case km_cjdm when '3' then km_value ELSE 0  END) AS zj "+

                "FROM " +
                "dbo.b_sbcw, " +
                "dbo.eq_info " +

                "WHERE " +
                "dbo.b_sbcw.eq_id = dbo.eq_info.eq_zcbh \n" +
                "<if test = \" qssj!=null \">" +
                "and dbo.b_sbcw.km_sj &gt;=#{qssj} " +
                "</if>" +
                "<if test = \" jssj!=null \">" +
                "and dbo.b_sbcw.km_sj &lt;=#{jssj} " +
                "</if>" +
                "<if test = \" bmName!=null and bmName!='' \">" +
                "and dbo.b_sbcw.bm_name =#{bmName} " +
                "</if>" +
                "<if test = \" eqName!=null and eqName!='' \">" +
                "and dbo.b_sbcw.eq_name like concat( '%', #{eqName}, '%') " +
                "</if>" +
                "GROUP BY " +
                "dbo.b_sbcw.eq_id  order by  eqNum </script> ";
        return sql;
    }

    public String listSrByX(CbMhVo cbMhVo) {
        StringBuffer sql = new StringBuffer("SELECT " +
                "Max(dbo.b_sbcw.bm_name) as bmName, " +
                "Max(dbo.b_sbcw.eq_name) as eqName, " +
                "Max(dbo.eq_info.eq_zcbh) AS eqNum, " +
                "Max(dbo.eq_info.eq_xh) AS eqXh, " + "Max(dbo.eq_info.eq_gg) AS eqGg, " +
                "sum(case km_name when '门诊收入' then km_value ELSE 0 END) AS mzsr, " +
                "sum(case km_name when '住院收入' then km_value ELSE 0 END) AS zysr, " +
                "sum(case km_cjdm when '3' then km_value ELSE 0  END) -sum(case km_name when '门诊收入' then km_value ELSE 0 END) -sum(case km_name when '住院收入' then km_value ELSE 0 END) AS qt, " +
                "sum(case km_cjdm when '3' then km_value ELSE 0  END) AS zj " +

                "FROM " +
                "dbo.b_sbcw, " +
                "dbo.eq_info " +

                "WHERE " +
                "dbo.b_sbcw.eq_id = dbo.eq_info.eq_zcbh \n");
        ;
        if (StringUtils.isNotBlank(cbMhVo.getBmNameByx())) {
            sql.append("and dbo.b_sbcw.bm_name Like '%'+ #{bmNameByx}+'%' ");
        }
        if (StringUtils.isNotBlank(cbMhVo.getEqNameByx())) {
            sql.append("and dbo.b_sbcw.eq_name Like '%'+ #{eqNameByx}+'%' ");
        }
        if ((cbMhVo.getKssj() != null) && (cbMhVo.getJssj() == null)) {
            sql.append("and dbo.b_sbcw.km_sj BETWEEN #{kssj} AND '3000-01-01'");
        }
        if ((cbMhVo.getKssj() == null) && (cbMhVo.getJssj() != null)) {
            sql.append("and dbo.b_sbcw.km_sj BETWEEN '1900-1-1' AND #{jssj}");
        }
        if ((cbMhVo.getKssj() != null) && (cbMhVo.getJssj() != null)) {
            sql.append("and km_sj BETWEEN #{kssj} AND #{jssj}");
        }
        /*if((StringUtils.isNotBlank((CharSequence) cbMhVo.getKssj())) && (StringUtils.isBlank((CharSequence) cbMhVo.getJssj()))){
            sql.append("and dbo.b_sbcw.km_sj BETWEEN #{kssj} AND '3000-01-01'" );
        }
        if((StringUtils.isBlank((CharSequence) cbMhVo.getKssj()))&&(StringUtils.isNotBlank((CharSequence) cbMhVo.getJssj()))){
            sql.append("and dbo.b_sbcw.km_sj BETWEEN '1900-1-1' AND #{jssj}" );
        }
        if((StringUtils.isNotBlank((CharSequence) cbMhVo.getKssj()))&&(StringUtils.isNotBlank((CharSequence) cbMhVo.getJssj()))){
            sql.append("and km_sj BETWEEN #{kssj} AND #{jssj}" );
        }*/
        sql.append("GROUP BY " +
                "dbo.b_sbcw.eq_id order by  eqNum ");

        return sql.toString();
    }

    public String listXyFx() {
        String sql = "<script>SELECT " +
                "Max(dbo.b_sbcw.bm_name) AS bmName, " +
                "Max(dbo.b_sbcw.eq_name) AS eqName, " +
                "Max(dbo.eq_info.eq_zcbh) AS eqNum, " +
                "Max(dbo.eq_info.eq_xh) AS eqXh, " + "Max(dbo.eq_info.eq_gg) AS eqGg, " +
                "Sum(case km_cjdm when '2' then km_value ELSE 0  END) AS sr, " +
                "Sum(case km_cjdm when '1' then km_value ELSE 0  END) +SUM(case km_cjdm when '3' then km_value ELSE 0  END) cb, " +
                "SUM(case km_name when '住院收入' then qjlc ELSE 0  END) as qjlc " +


                "FROM " +
                "dbo.b_sbcw , " +
                "dbo.eq_info " +
                "WHERE " +
                "dbo.b_sbcw.eq_id = dbo.eq_info.eq_zcbh \n " +
                "<if test = \" qssj!=null \">" +
                "and dbo.b_sbcw.km_sj &gt;=#{qssj} " +
                "</if>" +
                "<if test = \" jssj!=null \">" +
                "and dbo.b_sbcw.km_sj &lt;=#{jssj} " +
                "</if>" +
                "<if test = \" bmName!=null and bmName!='' \">" +
                "and dbo.b_sbcw.bm_name =#{bmName} " +
                "</if>" +
                "<if test = \" eqName!=null and eqName!='' \">" +
                "and dbo.b_sbcw.eq_name like concat( '%', #{eqName}, '%') " +
                "</if>" +
                "GROUP BY " +
                "dbo.b_sbcw.eq_id  order by  eqNum </script>";
        return sql;
    }

    public String listXyFxByX(CbMhVo cbMhVo) {
        StringBuffer sql = new StringBuffer("SELECT " +
                "Max(dbo.b_sbcw.bm_name) AS bmName, " +
                "Max(dbo.b_sbcw.eq_name) AS eqName, " +
                "Max(dbo.eq_info.eq_zcbh) AS eqNum, " +
                "Max(dbo.eq_info.eq_xh) AS eqXh, " + "Max(dbo.eq_info.eq_gg) AS eqGg, " +
                "Sum(case km_cjdm when '3' then km_value ELSE 0  END) AS sr, " +
                "Sum(case km_cjdm when '1' then km_value ELSE 0  END) +SUM(case km_cjdm when '2' then km_value ELSE 0  END) cb, " +
                "SUM(case km_name when '住院收入' then qjlc ELSE 0  END) as qjlc " +
                "FROM " +
                "dbo.b_sbcw , " +
                "dbo.eq_info " +
                "WHERE " +
                "dbo.b_sbcw.eq_id = dbo.eq_info.eq_zcbh \n");

        if (StringUtils.isNotBlank(cbMhVo.getBmNameByx())) {
            sql.append("and dbo.b_sbcw.bm_name Like '%'+ #{bmNameByx}+'%' ");
        }
        if (StringUtils.isNotBlank(cbMhVo.getEqNameByx())) {
            sql.append("and dbo.b_sbcw.eq_name Like '%'+ #{eqNameByx}+'%' ");
        }
        if ((cbMhVo.getKssj() != null) && (cbMhVo.getJssj() == null)) {
            sql.append("and dbo.b_sbcw.km_sj BETWEEN #{kssj} AND '3000-01-01'");
        }
        if ((cbMhVo.getKssj() == null) && (cbMhVo.getJssj() != null)) {
            sql.append("and dbo.b_sbcw.km_sj BETWEEN '1900-1-1' AND #{jssj}");
        }
        if ((cbMhVo.getKssj() != null) && (cbMhVo.getJssj() != null)) {
            sql.append("and km_sj BETWEEN #{kssj} AND #{jssj}");
        }
        /*if((StringUtils.isNotBlank((CharSequence) cbMhVo.getKssj())) && (StringUtils.isBlank((CharSequence) cbMhVo.getJssj()))){
            sql.append("and dbo.b_sbcw.km_sj BETWEEN #{kssj} AND '3000-01-01'" );
        }
        if((StringUtils.isBlank((CharSequence) cbMhVo.getKssj()))&&(StringUtils.isNotBlank((CharSequence) cbMhVo.getJssj()))){
            sql.append("and dbo.b_sbcw.km_sj BETWEEN '1900-1-1' AND #{jssj}" );
        }
        if((StringUtils.isNotBlank((CharSequence) cbMhVo.getKssj()))&&(StringUtils.isNotBlank((CharSequence) cbMhVo.getJssj()))){
            sql.append("and km_sj BETWEEN #{kssj} AND #{jssj}" );
        }*/
        sql.append("GROUP BY " +
                "dbo.b_sbcw.eq_id  order by  eqNum");

        return sql.toString();
    }

    public String listXyPj() {
        String sql = "<script>SELECT " +
                "Max(dbo.b_sbcw.bm_name) AS bmName, " +
                "Max(dbo.b_sbcw.eq_name) AS eqName, " +
                "Max(dbo.eq_info.eq_zcbh) AS eqNum, " +
                "Max(dbo.eq_info.eq_xh) AS eqXh, " + "Max(dbo.eq_info.eq_gg) AS eqGg, " +
                "MAX(dbo.eq_info.eq_price) as eqPrice, " +
                "MAX(dbo.eq_info.eq_qysj) as eqQysj, " +
                "Sum(case km_name when '住院收入' then qjlc ELSE 0  END) as zlcs," +
                "Sum(case km_cjdm when '2' then km_value ELSE 0  END) as qjsr," +
                "Sum(case km_cjdm when '1' then km_value ELSE 0  END)+Sum(case km_cjdm when '3' then km_value ELSE 0  END) as qjzc ,"+
                "Sum(case km_cjdm when '2' then km_value ELSE 0  END) -Sum(case km_cjdm when '1' then km_value ELSE 0  END) -SUM(case km_cjdm when '3' then km_value ELSE 0  END) AS qjsy " +

                "FROM " +
                "dbo.b_sbcw , " +
                "dbo.eq_info " +
                "WHERE " +
                "dbo.b_sbcw.eq_id = dbo.eq_info.eq_zcbh \n " +
                "<if test = \" qssj!=null \">" +
                "and dbo.b_sbcw.km_sj &gt;=#{qssj} " +
                "</if>" +
                "<if test = \" jssj!=null \">" +
                "and dbo.b_sbcw.km_sj &lt;=#{jssj} " +
                "</if>" +
                "<if test = \" bmName!=null and bmName!='' \">" +
                "and dbo.b_sbcw.bm_name =#{bmName} " +
                "</if>" +
                "<if test = \" eqName!=null and eqName!='' \">" +
                "and dbo.b_sbcw.eq_name like concat( '%', #{eqName}, '%') " +
                "</if>" +
                "GROUP BY " +
                "dbo.b_sbcw.eq_id  order by  eqNum </script>";
        return sql;
    }

    public String listXyPjByX(CbMhVo cbMhVo) {
        StringBuffer sql = new StringBuffer("SELECT " +
                "Max(dbo.b_sbcw.bm_name) AS bmName, " +
                "Max(dbo.b_sbcw.eq_name) AS eqName, " +
                "Max(dbo.eq_info.eq_zcbh) AS eqNum, " +
                "Max(dbo.eq_info.eq_xh) AS eqXh, " + "Max(dbo.eq_info.eq_gg) AS eqGg, " +
                "MAX(dbo.eq_info.eq_price) as eqPrice, " +
                "MAX(dbo.eq_info.eq_qysj) as eqQysj, " +
                "Sum(case km_cjdm when '3' then km_value ELSE 0  END) -Sum(case km_cjdm when '1' then km_value ELSE 0  END) -SUM(case km_cjdm when '2' then km_value ELSE 0  END) AS sy " +

                "FROM " +
                "dbo.b_sbcw , " +
                "dbo.eq_info " +
                "WHERE " +
                "dbo.b_sbcw.eq_id = dbo.eq_info.eq_zcbh  order by  eqNum\n");

        if (StringUtils.isNotBlank(cbMhVo.getBmNameByx())) {
            sql.append("and dbo.b_sbcw.bm_name Like '%'+ #{bmNameByx}+'%' ");
        }
        if (StringUtils.isNotBlank(cbMhVo.getEqNameByx())) {
            sql.append("and dbo.b_sbcw.eq_name Like '%'+ #{eqNameByx}+'%' ");
        }
        /*if((StringUtils.isNotBlank((CharSequence) cbMhVo.getKssj())) && (StringUtils.isBlank((CharSequence) cbMhVo.getJssj()))){
            sql.append("and dbo.b_sbcw.km_sj BETWEEN #{kssj} AND '3000-01-01'" );
        }
        if((StringUtils.isBlank((CharSequence) cbMhVo.getKssj()))&&(StringUtils.isNotBlank((CharSequence) cbMhVo.getJssj()))){
            sql.append("and dbo.b_sbcw.km_sj BETWEEN '1900-1-1' AND #{jssj}" );
        }
        if((StringUtils.isNotBlank((CharSequence) cbMhVo.getKssj()))&&(StringUtils.isNotBlank((CharSequence) cbMhVo.getJssj()))){
            sql.append("and km_sj BETWEEN #{kssj} AND #{jssj}" );
        }*/
        sql.append("GROUP BY " +
                "dbo.b_sbcw.eq_id  order by  eqNum");

        return sql.toString();
    }
}
