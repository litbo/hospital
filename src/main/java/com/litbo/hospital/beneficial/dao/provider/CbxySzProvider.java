package com.litbo.hospital.beneficial.dao.provider;

import com.litbo.hospital.beneficial.vo.CbMhVo;

public class CbxySzProvider {

    public String listCbxySz(){

        String sql = "SELECT "+
                "Max(dbo.b_sbcw.bm_name) AS bmName, "+
                "Max(dbo.b_sbcw.eq_name) AS eqName, "+
                "Max(dbo.eq_info.eq_xh) AS eqXh "+
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
                "Max(dbo.eq_info.eq_xh) AS eqXh "+

                "FROM "+
                "dbo.b_sbcw , "+
                "dbo.eq_info "+
                "WHERE "+
                "dbo.b_sbcw.eq_id = dbo.eq_info.eq_id and "+
                "(dbo.b_sbcw.km_cjdm =1 or "+
                "dbo.b_sbcw.km_cjdm =2) "
        );

        if(cbMhVo.getBmNameByx()!=null) {
            sql.append("and dbo.b_sbcw.bm_name Like #{bmNameByx}");
        }
        if(cbMhVo.getEqNameByx()!=null){
            sql.append("and dbo.b_sbcw.eq_name Like #{eqNameByx}");
        }
       /* if((cbMhVo.getKssj()!=null)&&(cbMhVo.getJssj()==null)){
            sql.append("and dbo.b_sbcw.km_sj BETWEEN #{kssj} AND '3000-01-01'" );
        }
        if((cbMhVo.getKssj()==null)&&(cbMhVo.getJssj()!=null)){
            sql.append("and dbo.b_sbcw.km_sj BETWEEN '1900-1-1' AND #{jssj}" );
        }
        if((cbMhVo.getKssj()!=null)&&(cbMhVo.getJssj()!=null)){
            sql.append("and km_sj BETWEEN #{kssj} AND #{jssj}" );
        }*/

        sql.append("GROUP BY " +
                "dbo.b_sbcw.eq_id ");

        return sql.toString();
    }

    public String selectCbkmByEqId(Integer eqId){

        String sql = "SELECT "+
                "Max(dbo.b_sbcw.a_id) AS aId, "+
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
                "Max(dbo.eq_info.eq_xh) AS eqXh "+
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
                "Max(dbo.eq_info.eq_xh) AS eqXh "+

                "FROM "+
                "dbo.b_sbcw , "+
                "dbo.eq_info "+
                "WHERE "+
                "dbo.b_sbcw.eq_id = dbo.eq_info.eq_id and "+
                "dbo.b_sbcw.km_cjdm =3 "
        );

        if(cbMhVo.getBmNameByx()!=null) {
            sql.append("and dbo.b_sbcw.bm_name Like #{bmNameByx}");
        }
        if(cbMhVo.getEqNameByx()!=null){
            sql.append("and dbo.b_sbcw.eq_name Like #{eqNameByx}");
        }
       /* if((cbMhVo.getKssj()!=null)&&(cbMhVo.getJssj()==null)){
            sql.append("and dbo.b_sbcw.km_sj BETWEEN #{kssj} AND '3000-01-01'" );
        }
        if((cbMhVo.getKssj()==null)&&(cbMhVo.getJssj()!=null)){
            sql.append("and dbo.b_sbcw.km_sj BETWEEN '1900-1-1' AND #{jssj}" );
        }
        if((cbMhVo.getKssj()!=null)&&(cbMhVo.getJssj()!=null)){
            sql.append("and km_sj BETWEEN #{kssj} AND #{jssj}" );
        }*/

        sql.append("GROUP BY " +
                "dbo.b_sbcw.eq_id ");

        return sql.toString();
    }

    public String selectSrkmByEqId(Integer eqId){

        String sql = "SELECT "+
                "Max(dbo.b_sbcw.a_id) AS aId, "+
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
