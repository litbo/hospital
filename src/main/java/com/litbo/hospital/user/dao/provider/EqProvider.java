package com.litbo.hospital.user.dao.provider;


import com.litbo.hospital.user.bean.EqInfo;
import com.litbo.hospital.user.vo.SelectEqVo;

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
                "\tb.bm_name \n" +
                "FROM\n" +
                "\tdbo.eq_info AS e\n" +
                "\tLEFT JOIN dbo.eq_pm AS p ON e.eq_pm_id = p.eq_pm_id\n" +
                "\tLEFT JOIN dbo.s_bm AS b ON e.eq_bmid = b.bm_id";
        return SQL;
    }

    public String addEq(EqInfo eqInfo){
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
                "      eq_bz, eq_azhjyq)\n" +
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
                "      #{userId,jdbcType=VARCHAR}, #{eqJdrq,jdbcType=DATE}, #{eqJzbh,jdbcType=VARCHAR}, \n" +
                "      #{eqDabh,jdbcType=VARCHAR}, #{eqYq,jdbcType=VARCHAR}, #{eqSbzp,jdbcType=VARCHAR}, \n" +
                "      #{eqMpzp,jdbcType=VARCHAR}, #{qdfsId,jdbcType=INTEGER}, #{gzlbId,jdbcType=INTEGER}, \n" +
                "      #{eqUsewater,jdbcType=CHAR}, #{eqDcysl,jdbcType=INTEGER}, #{eqEdgl,jdbcType=INTEGER}, \n" +
                "      #{eqBz,jdbcType=LONGVARCHAR}, #{eqAzhjyq,jdbcType=LONGVARCHAR})";
        return SQL;

    }

    public String selectEqByX(SelectEqVo selectEqVo){
        StringBuffer sql = new StringBuffer("SELECT\n" +
                "\te.eq_id,\n" +
                "\te.eq_sbbh,\n" +
                "\te.eq_zcbh,\n" +
                "  e.eq_name," +
                "\tp.eq_pm_name,\n" +
                "\te.eq_gg,\n" +
                "\te.eq_xh,\n" +
                "\te.eq_qysj,\n" +
                "\tb.bm_name \n" +
                "FROM\n" +
                "\tdbo.eq_info AS e\n" +
                "\tLEFT JOIN dbo.eq_pm AS p ON e.eq_pm_id = p.eq_pm_id\n" +
                "\tLEFT JOIN dbo.s_bm AS b ON e.eq_bmid = b.bm_id\n" +
                "WHERE 1=1" );
        if(selectEqVo.getBmName()!=null)  sql.append(" and bm_name Like #{bmName}");
        if(selectEqVo.getEqPmPym()!=null) sql.append(" and eq_pm_pym Like #{eqPmPym}");
        if(selectEqVo.getEqSbbh()!=null)  sql.append(" and eq_sbbh LIKE #{eqSbbh}" );
        if(selectEqVo.getEqZcbh()!=null)  sql.append(" and eq_zcbh Like #{eqZcbh}");
        return sql.toString();

    }
}
