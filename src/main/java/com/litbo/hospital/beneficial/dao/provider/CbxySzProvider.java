package com.litbo.hospital.beneficial.dao.provider;

import com.litbo.hospital.beneficial.vo.CbMhVo;
import org.apache.commons.lang3.StringUtils;

public class CbxySzProvider {

    public String listCbxySz(){

        String sql = "SELECT "+
                "Max(dbo.b_sbcw.bm_name) AS bmName, "+
                "Max(dbo.b_sbcw.eq_name) AS eqName, "+
                "Max(dbo.eq_info.eq_xh) AS eqXh, "+
                "Max(dbo.eq_info.eq_id) AS eqId "+
                "FROM "+
                "dbo.b_sbcw , "+
                "dbo.eq_info "+
                "WHERE "+
                "dbo.b_sbcw.eq_id = dbo.eq_info.eq_id and "+
                "(dbo.b_sbcw.km_cjdm =1 or "+
                "dbo.b_sbcw.km_cjdm =2) "+
                "GROUP BY "+
                "dbo.b_sbcw.eq_id ";


        return sql;
    }

    public String listCbxySzByX(CbMhVo cbMhVo){

        StringBuffer sql = new StringBuffer("SELECT "+
                "Max(dbo.b_sbcw.bm_name) AS bmName, "+
                "Max(dbo.b_sbcw.eq_name) AS eqName, "+
                "Max(dbo.eq_info.eq_xh) AS eqXh, "+
                "Max(dbo.eq_info.eq_id) AS eqId "+

                "FROM "+
                "dbo.b_sbcw , "+
                "dbo.eq_info "+
                "WHERE "+
                "dbo.b_sbcw.eq_id = dbo.eq_info.eq_id and "+
                "(dbo.b_sbcw.km_cjdm =1 or "+
                "dbo.b_sbcw.km_cjdm =2) "
        );

        if(StringUtils.isNotBlank(cbMhVo.getBmNameByx())) {
            sql.append("and dbo.b_sbcw.bm_name Like '%'+ #{bmNameByx}+'%' ");
        }
        if(StringUtils.isNotBlank(cbMhVo.getEqNameByx())){
            sql.append("and dbo.b_sbcw.eq_name Like '%'+ #{eqNameByx}+'%' " );
        }
      /*  if((StringUtils.isNotBlank((CharSequence) cbMhVo.getKssj())) && (StringUtils.isBlank((CharSequence) cbMhVo.getJssj()))){
            sql.append("and dbo.b_sbcw.km_sj BETWEEN #{kssj} AND '3000-01-01'" );
        }
        if((StringUtils.isBlank((CharSequence) cbMhVo.getKssj()))&&(StringUtils.isNotBlank((CharSequence) cbMhVo.getJssj()))){
            sql.append("and dbo.b_sbcw.km_sj BETWEEN '1900-1-1' AND #{jssj}" );
        }
        if((StringUtils.isNotBlank((CharSequence) cbMhVo.getKssj()))&&(StringUtils.isNotBlank((CharSequence) cbMhVo.getJssj()))){
            sql.append("and km_sj BETWEEN #{kssj} AND #{jssj}" );
        }*/
        sql.append("GROUP BY " +
                "dbo.b_sbcw.eq_id ");

        return sql.toString();
    }

    public String selectCbkmByEqId(Integer eqId){

        String sql = "SELECT "+
                "Max(dbo.b_sbcw.a_id) AS id, "+
                "Max(dbo.b_sbcw.eq_name) AS eqName, "+
                "Max(dbo.b_sbcw.km_name) AS kmName, "+
                "Max(dbo.b_sbcw.km_value) AS kmValue, "+
                "Max(dbo.b_sbcw.km_sj) AS kmSj "+

                "FROM "+
                "dbo.b_sbcw "+
                "WHERE "+
                "dbo.b_sbcw.eq_id = #{eqId} and "+
                "(dbo.b_sbcw.km_cjdm =1 or "+
                "dbo.b_sbcw.km_cjdm =2) "+
                "GROUP BY "+
                "dbo.b_sbcw.km_num; ";

        return sql;
    }

    public String listSrSz(){

        String sql = "SELECT "+
                "Max(dbo.b_sbcw.bm_name) AS bmName, "+
                "Max(dbo.b_sbcw.eq_name) AS eqName, "+
                "Max(dbo.eq_info.eq_xh) AS eqXh, "+
                "Max(dbo.eq_info.eq_id) AS eqId "+
                "FROM "+
                "dbo.b_sbcw , "+
                "dbo.eq_info "+
                "WHERE "+
                "dbo.b_sbcw.eq_id = dbo.eq_info.eq_id and "+
                "dbo.b_sbcw.km_cjdm =3 "+
                "GROUP BY "+
                "dbo.b_sbcw.eq_id ";


        return sql;
    }

    public String listSrSzByX(CbMhVo cbMhVo){

        StringBuffer sql = new StringBuffer("SELECT "+
                "Max(dbo.b_sbcw.bm_name) AS bmName, "+
                "Max(dbo.b_sbcw.eq_name) AS eqName, "+
                "Max(dbo.eq_info.eq_xh) AS eqXh， "+
                "Max(dbo.eq_info.eq_id) AS eqId "+

                "FROM "+
                "dbo.b_sbcw , "+
                "dbo.eq_info "+
                "WHERE "+
                "dbo.b_sbcw.eq_id = dbo.eq_info.eq_id and "+
                "dbo.b_sbcw.km_cjdm =3 "
        );

        if(StringUtils.isNotBlank(cbMhVo.getBmNameByx())) {
            sql.append("and dbo.b_sbcw.bm_name Like '%'+ #{bmNameByx}+'%' ");
        }
        if(StringUtils.isNotBlank(cbMhVo.getEqNameByx())){
            sql.append("and dbo.b_sbcw.eq_name Like '%'+ #{eqNameByx}+'%' " );
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
                "dbo.b_sbcw.eq_id ");

        return sql.toString();
    }

    public String selectSrkmByEqId(Integer eqId){

        String sql = "SELECT "+
                "Max(dbo.b_sbcw.a_id) AS id, "+
                "Max(dbo.b_sbcw.eq_name) AS eqName, "+
                "Max(dbo.b_sbcw.km_name) AS kmName, "+
                "Max(dbo.b_sbcw.km_value) AS kmValue, "+
                "Max(dbo.b_sbcw.km_sj) AS kmSj "+

                "FROM "+
                "dbo.b_sbcw "+
                "WHERE "+
                "dbo.b_sbcw.eq_id = #{eqId} and "+
                "dbo.b_sbcw.km_cjdm =3 "+
                "GROUP BY "+
                "dbo.b_sbcw.km_num; ";

        return sql;
    }
}
