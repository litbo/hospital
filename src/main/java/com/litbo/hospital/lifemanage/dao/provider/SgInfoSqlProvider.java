package com.litbo.hospital.lifemanage.dao.provider;

import com.litbo.hospital.lifemanage.bean.SgInfo;
import org.apache.ibatis.jdbc.SQL;

/**
 * 申购单表Mapper接口的sql类
 */
public class SgInfoSqlProvider {

    public String updateSgInfoById(SgInfo record) {
        return new SQL() {{
            UPDATE("sg_info");
            SET("id = #{record.id,jdbcType=VARCHAR}");
            SET("bm_id = #{record.bmId,jdbcType=CHAR}");
            SET("bh = #{record.bh,jdbcType=VARCHAR}");
            SET("eq_pm_id = #{record.eqPmId,jdbcType=INTEGER}");
            SET("tg_bm_id = #{record.tgBmId,jdbcType=CHAR}");
            SET("gzlb_id = #{record.gzlbId,jdbcType=INTEGER}");
            SET("zjly_id = #{record.zjlyId,jdbcType=INTEGER}");
            SET("syxz_id = #{record.syxzId,jdbcType=INTEGER}");
            SET("num = #{record.num,jdbcType=INTEGER}");
            SET("price_wd = #{record.priceWd,jdbcType=DECIMAL}");
            SET("price_sn = #{record.priceSn,jdbcType=DECIMAL}");
            SET("price_gj_y = #{record.priceGjY,jdbcType=DECIMAL}");
            SET("price_gj_my = #{record.priceGjMy,jdbcType=DECIMAL}");
            SET("syl = #{record.syl,jdbcType=VARCHAR}");
            SET("pjbg_id = #{record.pjbgId,jdbcType=VARCHAR}");
            SET("kxfx_id = #{record.kxfxId,jdbcType=VARCHAR}");
            SET("dxzb_id = #{record.dxzbId,jdbcType=VARCHAR}");
            SET("iskssh = #{record.iskssh,jdbcType=CHAR}");
            SET("isyxgccsh = #{record.isyxgccsh,jdbcType=CHAR}");
            SET("iszbwyhsh = #{record.iszbwyhsh,jdbcType=CHAR}");
            SET("zbwyhyj = #{record.zbwyhyj,jdbcType=VARCHAR}");
            SET("zbwyhhy_id = #{record.zbwyhhyId,jdbcType=VARCHAR}");
            SET("isybghsh = #{record.isybghsh,jdbcType=CHAR}");
            SET("ybghyj = #{record.ybghyj,jdbcType=VARCHAR}");
            SET("ybghhy_id = #{record.ybghhyId,jdbcType=VARCHAR}");
            SET("zt = #{record.zt,jdbcType=VARCHAR}");
            SET("extend_one = #{record.extendOne,jdbcType=VARCHAR}");
            SET("extend_two = #{record.extendTwo,jdbcType=VARCHAR}");
            SET("yxgccyj = #{record.yxgccyj,jdbcType=VARCHAR}");
            SET("gzll = #{record.gzll,jdbcType=LONGVARCHAR}");
            SET("xxyt = #{record.xxyt,jdbcType=LONGVARCHAR}");
            SET("mdyt = #{record.mdyt,jdbcType=LONGVARCHAR}");
            SET("jxkylc_qk = #{record.jxkylcQk,jdbcType=LONGVARCHAR}");
            SET("jbcsyq = #{record.jbcsyq,jdbcType=LONGVARCHAR}");
            SET("pzxq = #{record.pzxq,jdbcType=LONGVARCHAR}");
            WHERE("id = #{record.id,jdbcType=VARCHAR}");
        }}.toString();
    }

    public static void main(String[] args) {
        SgInfoSqlProvider s = new SgInfoSqlProvider();
        SgInfo sgInfo = new SgInfo();
        sgInfo.setId("1");
        sgInfo.setBmId("1");
        String s1 = s.updateSgInfoById(sgInfo);
        System.out.println(s1);
    }
}
