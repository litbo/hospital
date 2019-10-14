package com.litbo.hospital.user.dao.provider;


import com.litbo.hospital.user.bean.EqFj;
import com.litbo.hospital.user.bean.EqInfo;
import com.litbo.hospital.user.vo.EqInfoVo;
import com.litbo.hospital.user.vo.SelectEqVo;
import com.litbo.hospital.user.vo.SelectFlEqVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class EqProvider {

    public String selectAllEq(){

        String SQL = "SELECT\n" +
                "e.eq_id,\n" +
                "e.eq_sbbh,\n" +
                "e.eq_zcbh,\n" +
                "e.eq_pm_id,\n" +
                "e.eq_gg,\n" +
                "e.eq_xh,\n" +
                "z.zjly_name,\n" +
                "e.eq_price,\n" +
                "e.eq_tzlb,\n" +
                "e.eq_bxkssj,\n" +
                "e.eq_bxjssj,\n" +
                "e.eq_bxxysj,\n" +
                "e.eq_bmid,\n" +
                "e.eq_glgk,\n" +
                "e.eq_qysj,\n" +
                "e.eq_zczbh,\n" +
                "e.eq_zczmc,\n" +
                "e.eq_pp,\n" +
                "e.eq_scbh,\n" +
                "e.eq_pz,\n" +
                "e.eq_synx,\n" +
                "e.eq_htbh,\n" +
                "e.eq_cgrq,\n" +
                "e.eq_sybmfzr,\n" +
                "e.eq_azrq,\n" +
                "e.eq_azwz,\n" +
                "e.eq_zblx,\n" +
                "e.eq_zjl,\n" +
                "e.eq_jdrq,\n" +
                "e.eq_jzbh,\n" +
                "e.eq_dabh,\n" +
                "e.eq_yq,\n" +
                "e.eq_bz,\n" +
                "e.eq_sbzp,\n" +
                "e.eq_mpzp,\n" +
                "e.eq_azhjyq,\n" +
                "e.eq_dcysl,\n" +
                "e.eq_edgl,\n" +
                "j.eq_jldw_name,\n" +
                "c.eq_cxfl_name,\n" +
                "u.user_name,\n" +
                "g.gzlb_name,\n" +
                "e.eq_usewater,\n" +
                "q.qdfs_name\n" +
                "\n" +
                "FROM\n" +
                "dbo.eq_info AS e\n" +
                "LEFT JOIN dbo.eq_jldw AS j ON e.eq_jldw_id = j.eq_jldw_id\n" +
                "LEFT JOIN dbo.eq_cxfl AS c ON e.eq_cxfl_id = c.eq_cxfl_id\n" +
                "LEFT JOIN dbo.s_user AS u ON e.user_id = u.user_id\n" +
                "LEFT JOIN dbo.eq_gzlb AS g ON e.gzlb_id = g.gzlb_id\n" +
                "LEFT JOIN dbo.eq_qdfs AS q ON e.qdfs_id = q.qdfs_id\n" +
                "LEFT JOIN dbo.eq_zjly AS z ON e.zjly_id = z.zjly_id";
        return SQL;
    }

    public String selectShowEq(){
        String SQL = "SELECT\n" +
                "\te.eq_id,\n" +
                "\te.eq_sbbh,\n" +
                "\te.eq_zcbh,\n" +
                "  e.eq_name, " +
                "\tp.eq_pm_name,\n" +
                "\te.eq_gg,\n" +
                "\te.eq_xh,\n" +
                "\te.eq_qysj,\n" +
                "\tb.bm_name,  " +
                "  e.eq_syzt " +
                "FROM\n" +
                "\tdbo.eq_info AS e\n" +
                "\tLEFT JOIN dbo.eq_pm AS p ON e.eq_pm_id = p.eq_pm_id\n" +
                "\tLEFT JOIN dbo.s_bm AS b ON e.eq_bmid = b.bm_id";
        return SQL;
    }

    public String addEq(EqInfoVo eqInfo){
        String SQL=" insert into eq_info (eq_id, eq_sbbh, eq_zcbh, \n" +
                "      eq_pm_id, eq_gg, eq_xh, \n" +
                "      zjly_id, eq_jldw_id, eq_price, \n" +
                "      eq_tzlb, eq_bxkssj, eq_bxjssj, \n" +
                "      eq_bxxysj, sbcs_id_wxs, eq_bmid, \n" +
                "      eq_glgk, eq_cxfl_id, eq_qysj, \n" +
                "      eq_zczbh, eq_zczmc, sbcs_id_scs, \n" +
                "      eq_pp, eq_scbh, eq_pz, \n" +
                "      eq_synx, sbcs_id_gys, eq_htbh, \n" +
                "      eq_cgrq, eq_sybmfzr, eq_azrq, \n" +
                "      eq_azwz, eq_zblx, eq_zjl, \n" +
                "      user_id, eq_jdrq, eq_jzbh, \n" +
                "      eq_dabh, eq_yq, eq_sbzp, \n" +
                "      eq_mpzp, qdfs_id, gzlb_id, \n" +
                "      eq_usewater, eq_dcysl, eq_edgl, \n" +
                "      eq_bz, eq_azhjyq,eq_name,eq_syzt,eq_pym)\n" +
                "    values (#{eqId,jdbcType=INTEGER}, #{eqSbbh,jdbcType=VARCHAR}, #{eqZcbh,jdbcType=VARCHAR}, \n" +
                "      #{eqPmId,jdbcType=INTEGER}, #{eqGg,jdbcType=VARCHAR}, #{eqXh,jdbcType=VARCHAR}, \n" +
                "      #{zjlyId,jdbcType=CHAR}, #{eqJldwId,jdbcType=CHAR}, #{eqPrice,jdbcType=DECIMAL}, \n" +
                "      #{eqTzlb,jdbcType=VARCHAR}, #{eqBxkssj,jdbcType=DATE}, #{eqBxjssj,jdbcType=DATE}, \n" +
                "      #{eqBxxysj,jdbcType=INTEGER}, #{sbcsIdWxs,jdbcType=INTEGER}, #{eqBmid,jdbcType=CHAR}, \n" +
                "      #{eqGlgk,jdbcType=VARCHAR}, #{eqCxflId,jdbcType=CHAR}, #{eqQysj,jdbcType=DATE}, \n" +
                "      #{eqZczbh,jdbcType=VARCHAR}, #{eqZczmc,jdbcType=VARCHAR}, #{sbcsIdScs,jdbcType=INTEGER}, \n" +
                "      #{eqPp,jdbcType=VARCHAR}, #{eqScbh,jdbcType=VARCHAR}, #{eqPz,jdbcType=VARCHAR}, \n" +
                "      #{eqSynx,jdbcType=INTEGER}, #{sbcsIdGys,jdbcType=INTEGER}, #{eqHtbh,jdbcType=VARCHAR}, \n" +
                "      #{eqCgrq,jdbcType=DATE}, #{eqSybmfzr,jdbcType=VARCHAR}, #{eqAzrq,jdbcType=DATE}, \n" +
                "      #{eqAzwz,jdbcType=VARCHAR}, #{eqZblx,jdbcType=CHAR}, #{eqZjl,jdbcType=DECIMAL}, \n" +
                "      #{userName,jdbcType=VARCHAR}, #{eqJdrq,jdbcType=DATE}, #{eqJzbh,jdbcType=VARCHAR}, \n" +
                "      #{eqDabh,jdbcType=VARCHAR}, #{eqYq,jdbcType=VARCHAR}, #{eqSbzp,jdbcType=VARCHAR}, \n" +
                "      #{eqMpzp,jdbcType=VARCHAR}, #{qdfsId,jdbcType=INTEGER}, #{gzlbId,jdbcType=INTEGER}, \n" +
                "      #{eqUsewater,jdbcType=CHAR}, #{eqDcysl,jdbcType=INTEGER}, #{eqEdgl,jdbcType=INTEGER}, \n" +
                "      #{eqBz,jdbcType=LONGVARCHAR}, #{eqAzhjyq,jdbcType=LONGVARCHAR} ,#{eqName},#{eqSyzt},#{eqPym})";
        return SQL;

    }

    public String updateEq(EqInfoVo eqInfo) {
        return new SQL() {
            {
                UPDATE("eq_info");
                if(eqInfo.getEqName()!=null) {
                    SET("eq_name=#{eqName}");
                }
                if(eqInfo.getEqPym()!=null) {
                    SET("eq_pym=#{eqPym}");
                }
                if(eqInfo.getEqSbbh()!=null) {
                    SET("eq_sbbh=#{eqSbbh}");
                }
                if(eqInfo.getEqZcbh()!=null) {
                    SET("eq_zcbh=#{eqZcbh}");
                }

                //再议
                if(eqInfo.getEqPmId()!=null) {
                    SET("eq_pm_id=#{eqPmId}");
                }

                if(eqInfo.getEqGg()!=null) {
                    SET("eq_gg=#{eqGg}");
                }
                if(eqInfo.getEqXh()!=null) {
                    SET("eq_xh=#{eqXh}");
                }
                if(eqInfo.getZjlyId()!=null) {
                    SET("zjly_id=#{zjlyId}");
                }
                if(eqInfo.getEqJldwId()!=null) {
                    SET("eq_jldw_id=#{eqJldwId}");
                }

                if(eqInfo.getEqPrice()!=null) {
                    SET("eq_price=#{eqPrice}");
                }

                if(eqInfo.getEqTzlb()!=null) {
                    SET("eq_tzlb=#{eqTzlb}");
                }
                if(eqInfo.getEqBxkssj()!=null) {
                    SET("eq_bxkssj=#{eqBxkssj}");
                }
                if(eqInfo.getEqBxjssj()!=null) {
                    SET("eq_bxjssj=#{eqBxjssj}");
                }
                if(eqInfo.getEqBxxysj()!=null) {
                    SET("eq_bxxysj=#{eqBxxysj}");
                }

                if(eqInfo.getSbcsIdWxs()!=null) {
                    SET("sbcs_id_wxs=#{sbcsIdWxs}");
                }

                if(eqInfo.getEqBmid()!=null) {
                    SET("eq_bmid=#{eqBmid}");
                }
                if(eqInfo.getEqGlgk()!=null) {
                    SET("eq_glgk=#{eqGlgk}");
                }
                if(eqInfo.getEqCxflId()!=null) {
                    SET("eq_cxfl_id=#{eqCxflId}");
                }
                if(eqInfo.getEqQysj()!=null) {
                    SET("eq_qysj=#{eqQysj}");
                }

                if(eqInfo.getEqZczbh()!=null) {
                    SET("eq_zczbh=#{eqZczbh}");
                }

                if(eqInfo.getEqZczmc()!=null) {
                    SET("eq_zczmc=#{eqZczmc}");
                }
                if(eqInfo.getSbcsIdScs()!=null) {
                    SET("sbcs_id_scs=#{sbcsIdScs}");
                }
                if(eqInfo.getEqPp()!=null) {
                    SET("eq_pp=#{eqPp}");
                }
                if(eqInfo.getEqScbh()!=null) {
                    SET("eq_scbh=#{eqScbh}");
                }


                if(eqInfo.getEqPz()!=null) {
                    SET("eq_pz=#{eqPz}");
                }
                if(eqInfo.getEqSynx()!=null) {
                    SET("eq_synx=#{eqSynx}");
                }
                if(eqInfo.getSbcsIdGys()!=null) {
                    SET("sbcs_id_gys=#{sbcsIdGys}");
                }
                if(eqInfo.getEqHtbh()!=null) {
                    SET("eq_htbh=#{eqHtbh}");
                }

                if(eqInfo.getEqSybmfzr()!=null) {
                    SET("eq_sybmfzr=#{eqSybmfzr}");
                }

                if(eqInfo.getEqAzwz()!=null) {
                    SET("eq_azwz=#{eqAzwz}");
                }
                if(eqInfo.getEqZblx()!=null) {
                    SET("eq_zblx=#{eqZblx}");
                }
                if(eqInfo.getEqZjl()!=null) {
                    SET("eq_zjl=#{eqZjl}");
                }
                if(eqInfo.getUserId()!=null) {
                    SET("user_id=#{userId}");
                }
                if(eqInfo.getUserName()!=null) {
                    SET("user_id=#{userName}");
                }

                if(eqInfo.getEqJdrq()!=null) {
                    SET("eq_jdrq=#{eqJdrq}");
                }

                if(eqInfo.getEqJzbh()!=null) {
                    SET("eq_jzbh=#{eqJzbh}");
                }
                if(eqInfo.getEqDabh()!=null) {
                    SET("eq_dabh=#{eqDabh}");
                }
                if(eqInfo.getEqYq()!=null) {
                    SET("eq_yq=#{eqYq}");
                }
                    SET("eq_sbzp=#{eqSbzp}");

                    SET("eq_mpzp=#{eqMpzp}");

                if(eqInfo.getEqAzhjyq()!=null) {
                    SET("eq_azhjyq=#{eqAzhjyq}");
                }
                if(eqInfo.getQdfsId()!=null) {
                    SET("qdfs_id=#{qdfsId}");
                }

                if(eqInfo.getGzlbId()!=null) {
                    SET("gzlb_id=#{gzlbId}");
                }
                if(eqInfo.getEqUsewater()!=null) {
                    SET("eq_usewater=#{eqUsewater}");
                }
                if(eqInfo.getEqDcysl()!=null) {
                    SET("eq_dcysl=#{eqDcysl}");
                }
                if(eqInfo.getEqEdgl()!=null) {
                    SET("eq_edgl=#{eqEdgl}");
                }
                if(eqInfo.getEqSyfw()!=null) {
                    SET("eq_syfw=#{eqSyfw}");
                }
                if(eqInfo.getEqBz()!=null) {
                    SET("eq_bz=#{eqBz}");
                }
                if (eqInfo.getEqSyzt()!=null){
                    SET("eq_syzt=#{eqSyzt}");
                }
                WHERE("eq_id=#{eqId}");
            }
        }.toString();
    }

    public String listFlEq(){
        String SQL = "SELECT\n" +
                "\te.eq_id,\n" +
                "\te.eq_sbbh,\n" +
                "\te.eq_zcbh,\n" +
                "  e.eq_name, " +
                "\tp.eq_pm_name,\n" +
                "\te.eq_gg,\n" +
                "\te.eq_xh,\n" +
                "\te.eq_qysj,e.eq_price,e.eq_pp,\n" +
                "\tb.bm_name \n" +
                "FROM\n" +
                "\tdbo.eq_info AS e\n" +
                "\tLEFT JOIN dbo.eq_pm AS p ON e.eq_pm_id = p.eq_pm_id\n" +
                "\tLEFT JOIN dbo.s_bm AS b ON e.eq_bmid = b.bm_id" +
                " where e.eq_pm_id is not NULL";

        return SQL;
    }
    public String listFlEqByX(SelectFlEqVo selectFlEqVo){
        StringBuffer SQL =new StringBuffer( "SELECT\n" +
                "\te.eq_id,\n" +
                "\te.eq_sbbh,\n" +
                "\te.eq_zcbh,\n" +
                "  e.eq_name, " +
                "\tp.eq_pm_name,\n" +
                "\te.eq_gg,\n" +
                "\te.eq_xh,\n" +
                "\te.eq_qysj,e.eq_price,e.eq_pp,\n" +
                "\tb.bm_name \n" +
                "FROM\n" +
                "\tdbo.eq_info AS e\n" +
                "\tLEFT JOIN dbo.eq_pm AS p ON e.eq_pm_id = p.eq_pm_id\n" +
                "\tLEFT JOIN dbo.s_bm AS b ON e.eq_bmid = b.bm_id" +
                " where e.eq_pm_id is not NULL");
                 if(StringUtils.isNotBlank(selectFlEqVo.getBmId()))SQL.append(" and eq_bmid Like '%'+ #{bmId}+'%'");
                 if(StringUtils.isNotBlank(selectFlEqVo.getEqName()))SQL.append(" and eq_name Like '%'+ #{eqName}+'%'");
                 if(StringUtils.isNotBlank(selectFlEqVo.getBmName()))SQL.append(" and bm_name Like '%'+ #{bmName}+'%'");

        return SQL.toString();
    }

    public String listWFlEqByX(SelectFlEqVo selectFlEqVo){
        StringBuffer SQL =new StringBuffer( "SELECT\n" +
                "\te.eq_id,\n" +
                "\te.eq_sbbh,\n" +
                "\te.eq_zcbh,\n" +
                "  e.eq_name, " +
                "\tp.eq_pm_name,\n" +
                "\te.eq_gg,\n" +
                "\te.eq_xh,\n" +
                "\te.eq_qysj,e.eq_price,e.eq_pp,\n" +
                "\tb.bm_name \n" +
                "FROM\n" +
                "\tdbo.eq_info AS e\n" +
                "\tLEFT JOIN dbo.eq_pm AS p ON e.eq_pm_id = p.eq_pm_id\n" +
                "\tLEFT JOIN dbo.s_bm AS b ON e.eq_bmid = b.bm_id" +
                " where e.eq_pm_id is NULL");
        if(StringUtils.isNotBlank(selectFlEqVo.getBmId()))SQL.append(" and eq_bmid Like '%'+ #{bmId}+'%'");
        if(StringUtils.isNotBlank(selectFlEqVo.getEqName()))SQL.append(" and eq_name Like '%'+ #{eqName}+'%'");
        if(StringUtils.isNotBlank(selectFlEqVo.getBmName()))SQL.append(" and bm_name Like '%'+ #{bmName}+'%'");
        return SQL.toString();
    }
    public String listWFlEq(){
        String SQL = "SELECT\n" +
                "\te.eq_id,\n" +
                "\te.eq_sbbh,\n" +
                "\te.eq_zcbh,\n" +
                "  e.eq_name, " +
                "\tp.eq_pm_name,\n" +
                "\te.eq_gg,\n" +
                "\te.eq_xh,\n" +
                "\te.eq_qysj,e.eq_pp,eq_price,\n" +
                "\tb.bm_name \n" +
                "FROM\n" +
                "\tdbo.eq_info AS e\n" +
                "\tLEFT JOIN dbo.eq_pm AS p ON e.eq_pm_id = p.eq_pm_id\n" +
                "\tLEFT JOIN dbo.s_bm AS b ON e.eq_bmid = b.bm_id" +
                " where e.eq_pm_id is  NULL";

        return SQL;
    }

    public String listPmsByPym(String pym){
        StringBuffer sql = new StringBuffer("select * from eq_pm where 1=1");
        if(StringUtils.isNotBlank(pym))  sql.append(" and pym Like #{pym}");
        sql.append(" and len(eq_pm_id)=10");
        return sql.toString();

    }


    public String saveFj(EqFj eqFj){
        String sql="Insert into eq_fujian (eq_id,fj_gg,fj_xh,fj_name,fj_scbh)" +
                "values(#{eqId},#{fjGg},#{fjXh},#{fjName},#{fjScbh})";
        return sql;
    }

    public String getEqById(String id){

        String SQL = "SELECT\n" +
                "e.eq_id,e.eq_name,\n" +
                "e.eq_sbbh,\n" +
                "e.eq_zcbh,\n" +
                "e.eq_pm_id, p.eq_pm_name,\n" +
                "e.eq_gg,\n" +
                "e.eq_xh,\n" +
                "z.zjly_name,e.zjly_id,\n" +
                "e.eq_price,\n" +
                "e.eq_tzlb,\n" +
                "e.eq_bxkssj,\n" +
                "e.eq_bxjssj,\n" +
                "e.eq_bxxysj,\n" +
                "e.eq_bmid,b.bm_name,\n" +
                "e.eq_glgk,\n" +
                "e.eq_qysj,\n" +
                "e.eq_zczbh,\n" +
                "e.eq_zczmc,\n" +
                "e.eq_pp,\n" +
                "e.eq_scbh,\n" +
                "e.eq_pz,\n" +
                "e.eq_synx,\n" +
                "e.eq_htbh,\n" +
                "e.eq_cgrq,\n" +
                "e.eq_sybmfzr,\n" +
                "e.eq_azrq,\n" +
                "e.eq_azwz,\n" +
                "e.eq_zblx,\n" +
                "e.eq_zjl,\n" +
                "e.eq_jdrq,\n" +
                "e.eq_jzbh,\n" +
                "e.eq_dabh,\n" +
                "e.eq_yq,\n" +
                "e.eq_bz,\n" +
                "e.sbcs_id_scs," +
                "e.sbcs_id_wxs," +
                "e.sbcs_id_gys," +
                "e.eq_sbzp,\n" +
                "e.eq_mpzp,\n" +
                "e.eq_azhjyq,\n" +
                "e.eq_dcysl,\n" +
                "e.eq_edgl,\n" +
                "j.eq_jldw_name,e.eq_jldw_id,\n" +
                "e.eq_cxfl_id,c.eq_cxfl_name,\n" +
                "e.user_id as userName,\n" +
                "g.gzlb_name,\n" +
                "e.eq_usewater,\n" +
                "q.qdfs_name\n" +
                "\n" +
                "FROM\n" +
                "dbo.eq_info AS e\n" +
                "LEFT JOIN dbo.eq_jldw AS j ON e.eq_jldw_id = j.eq_jldw_id\n" +
                "LEFT JOIN dbo.eq_cxfl AS c ON e.eq_cxfl_id = c.eq_cxfl_id\n" +
                "LEFT JOIN dbo.s_user AS u ON e.user_id = u.user_id\n" +
                "LEFT JOIN dbo.eq_gzlb AS g ON e.gzlb_id = g.gzlb_id\n" +
                "LEFT JOIN dbo.eq_qdfs AS q ON e.qdfs_id = q.qdfs_id\n" +
                "LEFT JOIN dbo.eq_zjly AS z ON e.zjly_id = z.zjly_id " +
                "LEFT JOIN dbo.eq_pm AS p ON e.eq_pm_id = p.eq_pm_id " +
                "LEFT JOIN dbo.s_bm AS b ON e.eq_bmid = b.bm_id " +
                "where eq_id = #{id}";
        return SQL;
    }

    public String listEqNameByX(String ccname){
        StringBuffer sql = new StringBuffer("SELECT id,c_CName  " +
                "FROM\n" +
                "\tdbo.eq_name \n" +
                "WHERE 1=1" );
        if(StringUtils.isNotBlank(ccname))sql.append(" and c_CName Like '%'+ #{ccname}+'%'");
        return sql.toString();

    }

}
