package com.litbo.hospital.lifemanage.dao.provider.MyProvider;

import com.litbo.hospital.lifemanage.bean.MyBean.EqHt;

public class EqHtProvider {
    private static String str = "";

    public String selectShowHtList() {
        str = " select id, ht_zt, ht_bianhao, ht_zbmc, ht_pinpai, ht_yfrq," +
                " ht_ggxh, ht_count,ht_danjia from eq_ht " + " order by ht_bianhao";
        return str;
    }

    public String selectHtList() {
        str = SelectAllStr() + "order by ht_bianhao";
        return str;
    }



    public String selectByHtId() {

        str = SelectAllStr() +
                "  where ht_bianhao = #{htBianhao,jdbcType=VARCHAR}";
        return str;
    }

    public String selectByPrimaryId() {
        str = "select * from eq_ht where id=#{id}";
        return str;
    }

    public String insert(EqHt record) {
        str = "insert into eq_ht (id, ht_qyd, ht_jf, \n" +
                "      ht_yf, ht_jfdz, ht_yfdz, \n" +
                "      ht_xmbh, ht_xmmc, ht_zbmc, \n" +
                "      ht_ggxh, ht_pinpai, ht_ycd, \n" +
                "      ht_danwei, ht_count, ht_danjia, \n" +
                "      ht_zongjia, ht_cjje, ht_beizhu, \n" +
                "      ht_jfq, ht_bzr, ht_tsr, \n" +
                "      ht_ysfk, ht_zbj, ht_scrq, \n" +
                "      ht_bxq, ht_bxxy, ht_bxdc, \n" +
                "      ht_zgfg, ht_zgbfb, ht_bycs, \n" +
                "      ht_lpjyhj, ht_jfdb, ht_jfdh, \n" +
                "      ht_nsrdjh, ht_yfdb, ht_yfdh, \n" +
                "      ht_khyh, ht_zh, ht_jfrq, \n" +
                "      ht_yfrq, ht_zt, ht_bianhao, \n" +
                "      ht_zbhz)\n" +
                "    values (#{id,jdbcType=VARCHAR}, #{htQyd,jdbcType=VARCHAR}, #{htJf,jdbcType=VARCHAR}, \n" +
                "      #{htYf,jdbcType=VARCHAR}, #{htJfdz,jdbcType=VARCHAR}, #{htYfdz,jdbcType=VARCHAR}, \n" +
                "      #{htXmbh,jdbcType=VARCHAR}, #{htXmmc,jdbcType=VARCHAR}, #{htZbmc,jdbcType=VARCHAR}, \n" +
                "      #{htGgxh,jdbcType=VARCHAR}, #{htPinpai,jdbcType=VARCHAR}, #{htYcd,jdbcType=VARCHAR}, \n" +
                "      #{htDanwei,jdbcType=VARCHAR}, #{htCount,jdbcType=INTEGER}, #{htDanjia,jdbcType=DECIMAL}, \n" +
                "      #{htZongjia,jdbcType=DECIMAL}, #{htCjje,jdbcType=INTEGER}, #{htBeizhu,jdbcType=VARCHAR}, \n" +
                "      #{htJfq,jdbcType=INTEGER}, #{htBzr,jdbcType=INTEGER}, #{htTsr,jdbcType=INTEGER}, \n" +
                "      #{htYsfk,jdbcType=INTEGER}, #{htZbj,jdbcType=INTEGER}, #{htScrq,jdbcType=DATE}, \n" +
                "      #{htBxq,jdbcType=INTEGER}, #{htBxxy,jdbcType=INTEGER}, #{htBxdc,jdbcType=INTEGER}, \n" +
                "      #{htZgfg,jdbcType=DECIMAL}, #{htZgbfb,jdbcType=INTEGER}, #{htBycs,jdbcType=INTEGER}, \n" +
                "      #{htLpjyhj,jdbcType=DECIMAL}, #{htJfdb,jdbcType=VARCHAR}, #{htJfdh,jdbcType=VARCHAR}, \n" +
                "      #{htNsrdjh,jdbcType=VARCHAR}, #{htYfdb,jdbcType=VARCHAR}, #{htYfdh,jdbcType=VARCHAR}, \n" +
                "      #{htKhyh,jdbcType=VARCHAR}, #{htZh,jdbcType=VARCHAR}, #{htJfrq,jdbcType=DATE}, \n" +
                "      #{htYfrq,jdbcType=DATE}, #{htZt,jdbcType=CHAR}, #{htBianhao,jdbcType=VARCHAR}, \n" +
                "      #{htZbhz,jdbcType=VARCHAR})";
        return str;
    }

    public String updateByHtBianhao() {
        str = "update eq_ht" +
                "  set ht_zt = #{htZt,jdbcType=VARCHAR} " +
                "  where ht_bianhao = #{htBianhao,jdbcType=VARCHAR}";
        return str;
    }


    public String updateByPrimaryId() {
        str = "update eq_ht\n" +
                "    set ht_qyd = #{htQyd,jdbcType=VARCHAR},\n" +
                "      ht_jf = #{htJf,jdbcType=VARCHAR},\n" +
                "      ht_yf = #{htYf,jdbcType=VARCHAR},\n" +
                "      ht_jfdz = #{htJfdz,jdbcType=VARCHAR},\n" +
                "      ht_yfdz = #{htYfdz,jdbcType=VARCHAR},\n" +
                "      ht_xmbh = #{htXmbh,jdbcType=VARCHAR},\n" +
                "      ht_xmmc = #{htXmmc,jdbcType=VARCHAR},\n" +
                "      ht_zbmc = #{htZbmc,jdbcType=VARCHAR},\n" +
                "      ht_ggxh = #{htGgxh,jdbcType=VARCHAR},\n" +
                "      ht_pinpai = #{htPinpai,jdbcType=VARCHAR},\n" +
                "      ht_ycd = #{htYcd,jdbcType=VARCHAR},\n" +
                "      ht_danwei = #{htDanwei,jdbcType=VARCHAR},\n" +
                "      ht_count = #{htCount,jdbcType=INTEGER},\n" +
                "      ht_danjia = #{htDanjia,jdbcType=DECIMAL},\n" +
                "      ht_zongjia = #{htZongjia,jdbcType=DECIMAL},\n" +
                "      ht_cjje = #{htCjje,jdbcType=INTEGER},\n" +
                "      ht_beizhu = #{htBeizhu,jdbcType=VARCHAR},\n" +
                "      ht_jfq = #{htJfq,jdbcType=INTEGER},\n" +
                "      ht_bzr = #{htBzr,jdbcType=INTEGER},\n" +
                "      ht_tsr = #{htTsr,jdbcType=INTEGER},\n" +
                "      ht_ysfk = #{htYsfk,jdbcType=INTEGER},\n" +
                "      ht_zbj = #{htZbj,jdbcType=INTEGER},\n" +
                "      ht_scrq = #{htScrq,jdbcType=DATE},\n" +
                "      ht_bxq = #{htBxq,jdbcType=INTEGER},\n" +
                "      ht_bxxy = #{htBxxy,jdbcType=INTEGER},\n" +
                "      ht_bxdc = #{htBxdc,jdbcType=INTEGER},\n" +
                "      ht_zgfg = #{htZgfg,jdbcType=DECIMAL},\n" +
                "      ht_zgbfb = #{htZgbfb,jdbcType=INTEGER},\n" +
                "      ht_bycs = #{htBycs,jdbcType=INTEGER},\n" +
                "      ht_lpjyhj = #{htLpjyhj,jdbcType=DECIMAL},\n" +
                "      ht_jfdb = #{htJfdb,jdbcType=VARCHAR},\n" +
                "      ht_jfdh = #{htJfdh,jdbcType=VARCHAR},\n" +
                "      ht_nsrdjh = #{htNsrdjh,jdbcType=VARCHAR},\n" +
                "      ht_yfdb = #{htYfdb,jdbcType=VARCHAR},\n" +
                "      ht_yfdh = #{htYfdh,jdbcType=VARCHAR},\n" +
                "      ht_khyh = #{htKhyh,jdbcType=VARCHAR},\n" +
                "      ht_zh = #{htZh,jdbcType=VARCHAR},\n" +
                "      ht_jfrq = #{htJfrq,jdbcType=DATE},\n" +
                "      ht_yfrq = #{htYfrq,jdbcType=DATE},\n" +
                "      ht_zt = #{htZt,jdbcType=CHAR},\n" +
                "      ht_bianhao = #{htBianhao,jdbcType=VARCHAR},\n" +
                "      ht_zbhz=#{htZbhz,jdbcType=VARCHAR}" +
                "    where id = #{id,jdbcType=VARCHAR}";
        return str;
    }

    public String deleteByPrimaryKey() {
        str="delete from eq_ht where id=#{id}";
        return str;
    }

    private String SelectAllStr() {
        return "select " +
                "  id, ht_qyd, ht_jf, ht_yf, ht_jfdz, ht_yfdz, ht_xmbh, ht_xmmc, ht_zbmc, ht_ggxh, ht_pinpai,\n" +
                "  ht_ycd, ht_danwei, ht_count, ht_danjia, ht_zongjia, ht_cjje, ht_beizhu, ht_jfq, ht_bzr,\n" +
                "  ht_tsr, ht_ysfk, ht_zbj, ht_scrq, ht_bxq, ht_bxxy, ht_bxdc, ht_zgfg, ht_zgbfb, ht_bycs,\n" +
                "  ht_lpjyhj, ht_jfdb, ht_jfdh, ht_nsrdjh, ht_yfdb, ht_yfdh, ht_khyh, ht_zh, ht_jfrq,\n" +
                "  ht_yfrq,ht_zt,ht_bianhao,ht_zbhz" +
                "  from eq_ht\n";

    }
}
