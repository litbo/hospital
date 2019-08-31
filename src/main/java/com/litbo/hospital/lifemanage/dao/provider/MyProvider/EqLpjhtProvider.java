package com.litbo.hospital.lifemanage.dao.provider.MyProvider;

public class EqLpjhtProvider {

    private static String str = "";

    public String deleteByPrimaryKey(String id) {
        str = "delete from eq_lpjht where id=#{id}";
        return str;
    }

    public String insert() {
        str = " insert into eq_lpjht (id, ht_jf, ht_yf, \n" +
                "      ht_bxq, ht_jhsj, ht_sbmc, \n" +
                "      ht_gzms, ht_gzfx, ht_pjmc, \n" +
                "      ht_ggxh, ht_count, ht_bj, \n" +
                "      ht_yhj, ht_zj, ht_cjje, \n" +
                "      ht_jfrq, ht_yfdh, ht_khhzh, \n" +
                "      ht_yfrq, ht_sbbh, ht_zt, \n" +
                "      ht_jhtid, ht_lpjhz)\n" +
                "    values (#{id,jdbcType=VARCHAR}, #{htJf,jdbcType=VARCHAR}, #{htYf,jdbcType=VARCHAR}, \n" +
                "      #{htBxq,jdbcType=INTEGER}, #{htJhsj,jdbcType=DATE}, #{htSbmc,jdbcType=VARCHAR}, \n" +
                "      #{htGzms,jdbcType=VARCHAR}, #{htGzfx,jdbcType=VARCHAR}, #{htPjmc,jdbcType=VARCHAR}, \n" +
                "      #{htGgxh,jdbcType=VARCHAR}, #{htCount,jdbcType=INTEGER}, #{htBj,jdbcType=DECIMAL}, \n" +
                "      #{htYhj,jdbcType=DECIMAL}, #{htZj,jdbcType=DECIMAL}, #{htCjje,jdbcType=INTEGER}, \n" +
                "      #{htJfrq,jdbcType=DATE}, #{htYfdh,jdbcType=VARCHAR}, #{htKhhzh,jdbcType=VARCHAR}, \n" +
                "      #{htYfrq,jdbcType=DATE}, #{htSbbh,jdbcType=VARCHAR}, #{htZt,jdbcType=VARCHAR}, \n" +
                "      #{htJhtid,jdbcType=VARCHAR}, #{htLpjhz,jdbcType=VARCHAR})";
        return str;
    }


    public String updateByPrimaryKey() {
        str = "update eq_lpjht\n" +
                "    set ht_jf = #{htJf,jdbcType=VARCHAR},\n" +
                "      ht_yf = #{htYf,jdbcType=VARCHAR},\n" +
                "      ht_bxq = #{htBxq,jdbcType=INTEGER},\n" +
                "      ht_jhsj = #{htJhsj,jdbcType=DATE},\n" +
                "      ht_sbmc = #{htSbmc,jdbcType=VARCHAR},\n" +
                "      ht_gzms = #{htGzms,jdbcType=VARCHAR},\n" +
                "      ht_gzfx = #{htGzfx,jdbcType=VARCHAR},\n" +
                "      ht_pjmc = #{htPjmc,jdbcType=VARCHAR},\n" +
                "      ht_ggxh = #{htGgxh,jdbcType=VARCHAR},\n" +
                "      ht_count = #{htCount,jdbcType=INTEGER},\n" +
                "      ht_bj = #{htBj,jdbcType=DECIMAL},\n" +
                "      ht_yhj = #{htYhj,jdbcType=DECIMAL},\n" +
                "      ht_zj = #{htZj,jdbcType=DECIMAL},\n" +
                "      ht_cjje = #{htCjje,jdbcType=INTEGER},\n" +
                "      ht_jfrq = #{htJfrq,jdbcType=DATE},\n" +
                "      ht_yfdh = #{htYfdh,jdbcType=VARCHAR},\n" +
                "      ht_khhzh = #{htKhhzh,jdbcType=VARCHAR},\n" +
                "      ht_yfrq = #{htYfrq,jdbcType=DATE},\n" +
                "      ht_sbbh = #{htSbbh,jdbcType=VARCHAR},\n" +
                "      ht_zt = #{htZt,jdbcType=VARCHAR},\n" +
                "      ht_jhtid = #{htJhtid,jdbcType=VARCHAR},\n" +
                "      ht_lpjhz = #{htLpjhz,jdbcType=VARCHAR}\n" +
                "    where id = #{id,jdbcType=VARCHAR}";
        return str;
    }

    public String updateByJhtId() {
        str = "update eq_lpjht\n" +
                "   set ht_zt = #{htZt,jdbcType=VARCHAR} \n" +
                "   where ht_jhtid = #{htJhtid,jdbcType=VARCHAR}";
        return str;
    }

    public String selectByPrimaryKey(){
        str="select \n" +
                "  id, ht_jf, ht_yf, ht_bxq, ht_jhsj, ht_sbmc, ht_gzms, ht_gzfx, ht_pjmc, ht_ggxh, ht_count, \n" +
                "    ht_bj, ht_yhj, ht_zj, ht_cjje, ht_jfrq, ht_yfdh, ht_khhzh, ht_yfrq, ht_sbbh, ht_zt, \n" +
                "    ht_jhtid, ht_lpjhz" +
                "    from eq_lpjht\n" +
                "    where id = #{id,jdbcType=VARCHAR}";
        return str;
    }


}
