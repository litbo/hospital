package com.litbo.hospital.lifemanage.dao.provider;

import com.litbo.hospital.lifemanage.bean.SgInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.ArrayList;
import java.util.List;

/**
 * 申购单表Mapper接口的sql类
 */
public class SgInfoSqlProvider {
    /**
     * 添加申购单信息
     *
     * @param sgInfo 申购信息
     */
    public String updateSgInfoById(SgInfo sgInfo) {
        return new SQL() {{
            UPDATE("sg_info");
            SET("bh = #{sgInfo.bh,jdbcType=VARCHAR}");
            //托管科室id
            SET("tg_bm_id = #{sgInfo.tgBmId,jdbcType=CHAR}");
            //购置类别id
            SET("gzlb_id = #{sgInfo.gzlbId,jdbcType=INTEGER}");
            //资金来源id
            SET("zjly_id = #{sgInfo.zjlyId,jdbcType=INTEGER}");
            //使用性质id
            SET("syxz_id = #{sgInfo.syxzId,jdbcType=INTEGER}");
            //数量
            SET("num = #{sgInfo.num,jdbcType=INTEGER}");
            //外地价格
            SET("price_wd = #{sgInfo.priceWd,jdbcType=DECIMAL}");
            //省内价格
            SET("price_sn = #{sgInfo.priceSn,jdbcType=DECIMAL}");
            //估价元
            SET("price_gj_y = #{sgInfo.priceGjY,jdbcType=DECIMAL}");
            //估价美元
            SET("price_gj_my = #{sgInfo.priceGjMy,jdbcType=DECIMAL}");
            //检测量/日
            SET("jcl = #{sgInfo.jcl,jdbcType=VARCHAR}");
            //设计使用率
            SET("syl = #{sgInfo.syl,jdbcType=VARCHAR}");
            //购置理由
            SET("gzll = #{sgInfo.gzll,jdbcType=LONGVARCHAR}");
            //详细用途
            SET("xxyt = #{sgInfo.xxyt,jdbcType=LONGVARCHAR}");
            //目的用途
            SET("mdyt = #{sgInfo.mdyt,jdbcType=LONGVARCHAR}");
            //目前教学科研临床应用情况
            SET("jxkylcqk = #{sgInfo.jxkylcqk,jdbcType=LONGVARCHAR}");
            //基本参数要求
            SET("jbcsyq = #{sgInfo.jbcsyq,jdbcType=LONGVARCHAR}");
            //配置详细需求
            SET("pzxq = #{sgInfo.pzxq,jdbcType=LONGVARCHAR}");
            WHERE("id = #{sgInfo.id,jdbcType=VARCHAR}");
        }}.toString();
    }

    /**
     * 显示科室汇总审核列表
     *
     * @param bmId     部门id
     * @param sgInfoBh 申购单编号
     * @param pmList   品名列表
     */
    public String selectSgInfoKsshList(String bmId, String sgInfoBh, List<String> pmList) {
        return new SQL() {{
            SELECT("dbo.sg_info.id");
            SELECT("dbo.sg_info.bm_id");
            SELECT("dbo.sg_info.bh");
            SELECT("dbo.eq_pm.eq_pm_name");
            SELECT("dbo.sg_info.num");
            SELECT("dbo.sg_info.price_gj_y");
            SELECT("dbo.sg_info.zt");
            SELECT("dbo.sg_info.kstl_id");
            SELECT("dbo.sg_info.pjbg_id");
            SELECT("dbo.sg_info.kxfx_id");
            SELECT("dbo.sg_info.dxzb_id");
            SELECT("dbo.sg_info.lzfx_id");
            FROM("dbo.sg_info");
            INNER_JOIN("dbo.eq_pm ON dbo.sg_info.eq_pm_id = dbo.eq_pm.eq_pm_id");
            WHERE("dbo.sg_info.bh IS NOT NULL");
            if (StringUtils.isNotBlank(bmId)) {
                WHERE("dbo.sg_info.bm_id = #{bmId,jdbcType=VARCHAR}");
            }
            if (StringUtils.isNotBlank(sgInfoBh)) {
                WHERE("dbo.sg_info.bh like #{sgInfoBh,jdbcType=VARCHAR}");
            }
            if (pmList != null && pmList.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < pmList.size(); i++) {
                    sb.append(pmList.get(i));
                    if (pmList.size() != (i + 1)) {
                        sb.append(",");
                    }
                }
                WHERE("dbo.sg_info.eq_pm_id IN (" + sb.toString() + ")");
            }
            WHERE("dbo.sg_info.iskssh IS NULL");
        }}.toString();
    }

    /**
     * 显示工程处审核列表
     *
     * @param bmId 查看具体部门id
     */
    public String selectSgInfoGccshList(String bmId) {
        return new SQL() {{
            SELECT("dbo.sg_info.id");
            SELECT("dbo.s_bm.bm_name");
            SELECT("dbo.sg_info.bh");
            SELECT("dbo.eq_pm.eq_pm_name");
            SELECT("dbo.sg_info.num");
            SELECT("dbo.sg_info.price_gj_y");
            SELECT("dbo.sg_info.kstl_id");
            SELECT("dbo.sg_info.pjbg_id");
            SELECT("dbo.sg_info.kxfx_id");
            SELECT("dbo.sg_info.dxzb_id");
            SELECT("dbo.sg_info.lzfx_id");
            FROM("dbo.sg_info");
            INNER_JOIN("dbo.eq_pm ON dbo.sg_info.eq_pm_id = dbo.eq_pm.eq_pm_id");
            INNER_JOIN("dbo.s_bm ON dbo.sg_info.bm_id = dbo.s_bm.bm_id");
            WHERE("dbo.sg_info.bh IS NOT NULL");
            if (StringUtils.isNotBlank(bmId)) {
                WHERE("dbo.sg_info.bm_id = #{bmId,jdbcType=VARCHAR}");
            }
            WHERE("dbo.sg_info.isyxgccsh IS NULL AND dbo.sg_info.iskssh = 1");
        }}.toString();
    }

    /**
     * 显示申购单装备委员会审核列表
     *
     * @param bmId 部门id
     * @param bh   申购单编号
     */
    public String selectSgInfoSgZbwyhhyList(String bmId, String bh) {
        return new SQL() {{
            SELECT("dbo.sg_info.id");
            SELECT("dbo.sg_info.bm_id");
            SELECT("dbo.sg_info.bh");
            SELECT("dbo.eq_pm.eq_pm_name");
            SELECT("dbo.sg_info.num");
            SELECT("dbo.sg_info.price_gj_y");
            SELECT("dbo.sg_info.zt");
            SELECT("dbo.sg_info.kstl_id");
            SELECT("dbo.sg_info.pjbg_id");
            SELECT("dbo.sg_info.kxfx_id");
            SELECT("dbo.sg_info.dxzb_id");
            SELECT("dbo.sg_info.lzfx_id");
            FROM("dbo.sg_info");
            INNER_JOIN("dbo.eq_pm ON dbo.sg_info.eq_pm_id = dbo.eq_pm.eq_pm_id");
            WHERE("dbo.sg_info.bh IS NOT NULL");
            if (StringUtils.isNotBlank(bh)) {
                WHERE("dbo.sg_info.bh like #{sgInfoBh,jdbcType=VARCHAR}");
            }
            if (StringUtils.isNotBlank(bmId)) {
                WHERE("dbo.sg_info.bm_id = #{bmId,jdbcType=VARCHAR}");
            }
            WHERE("dbo.sg_info.iszbwyhsh IS NULL AND dbo.sg_info.iskssh = 1 AND dbo.sg_info.isyxgccsh = 1");
        }}.toString();
    }

    /**
     * 显示申购单院办公会审核列表
     *
     * @param bmId 部门id
     * @param bh   申购单编号
     */
    public String selectSgInfoYbgsShList(String bmId, String bh) {
        return new SQL() {{
            SELECT("dbo.sg_info.id");
            SELECT("dbo.sg_info.bm_id");
            SELECT("dbo.sg_info.bh");
            SELECT("dbo.eq_pm.eq_pm_name");
            SELECT("dbo.sg_info.num");
            SELECT("dbo.sg_info.price_gj_y");
            SELECT("dbo.sg_info.zt");
            SELECT("dbo.sg_info.kstl_id");
            SELECT("dbo.sg_info.pjbg_id");
            SELECT("dbo.sg_info.kxfx_id");
            SELECT("dbo.sg_info.dxzb_id");
            SELECT("dbo.sg_info.lzfx_id");
            FROM("dbo.sg_info");
            INNER_JOIN("dbo.eq_pm ON dbo.sg_info.eq_pm_id = dbo.eq_pm.eq_pm_id");
            WHERE("dbo.sg_info.bh IS NOT NULL");
            if (StringUtils.isNotBlank(bh)) {
                WHERE("dbo.sg_info.bh like #{sgInfoBh,jdbcType=VARCHAR}");
            }
            if (StringUtils.isNotBlank(bmId)) {
                WHERE("dbo.sg_info.bm_id = #{bmId,jdbcType=VARCHAR}");
            }
            WHERE("dbo.sg_info.isybghsh IS NULL AND dbo.sg_info.iskssh = 1 AND dbo.sg_info.isyxgccsh = 1 AND dbo.sg_info.iszbwyhsh = 1");
        }}.toString();
    }

    /**
     * 装备委员会年度采购计划
     *
     * @param year 年份
     * @param bmId 部门id
     */
    public String selectSgZbwyhYearPurchase(String year, String bmId) {
        return new SQL() {{
            SELECT("dbo.sg_info.id");
            SELECT("dbo.sg_info.bm_id");
            SELECT("dbo.sg_info.bh");
            SELECT("dbo.eq_pm.eq_pm_name");
            SELECT("dbo.sg_info.num");
            SELECT("dbo.sg_info.price_gj_y");
            SELECT("dbo.sg_info.zt");
            SELECT("dbo.sg_info.kstl_id");
            SELECT("dbo.sg_info.pjbg_id");
            SELECT("dbo.sg_info.kxfx_id");
            SELECT("dbo.sg_info.dxzb_id");
            SELECT("dbo.sg_info.lzfx_id");
            FROM("dbo.sg_info");
            INNER_JOIN("dbo.eq_pm ON dbo.sg_info.eq_pm_id = dbo.eq_pm.eq_pm_id");
            WHERE("dbo.sg_info.bh IS NOT NULL");
            if (StringUtils.isNotBlank(year)) {
                WHERE("dbo.sg_info.id IN (SELECT dbo.sg_zbwyhhy.sg_id FROM dbo.sg_zbwyhhy WHERE dbo.sg_zbwyhhy.zbwyhhy_nd = #{year,jdbcType=VARCHAR})");
            }
            if (StringUtils.isNotBlank(bmId)) {
                WHERE("dbo.sg_info.bm_id = #{bmId,jdbcType=VARCHAR}");
            }
            WHERE("dbo.sg_info.iskssh = 1 AND dbo.sg_info.isyxgccsh = 1 AND dbo.sg_info.iszbwyhsh = 1");
        }}.toString();
    }

    /**
     * 院办公会年度采购计划
     *
     * @param year 年份
     * @param bmId 部门id
     */
    public String selectSgYbghhyYearPurchase(String year, String bmId) {
        return new SQL() {{
            SELECT("dbo.sg_info.id");
            SELECT("dbo.sg_info.bm_id");
            SELECT("dbo.sg_info.bh");
            SELECT("dbo.eq_pm.eq_pm_name");
            SELECT("dbo.sg_info.num");
            SELECT("dbo.sg_info.price_gj_y");
            SELECT("dbo.sg_info.zt");
            SELECT("dbo.sg_info.kstl_id");
            SELECT("dbo.sg_info.pjbg_id");
            SELECT("dbo.sg_info.kxfx_id");
            SELECT("dbo.sg_info.dxzb_id");
            SELECT("dbo.sg_info.lzfx_id");
            FROM("dbo.sg_info");
            INNER_JOIN("dbo.eq_pm ON dbo.sg_info.eq_pm_id = dbo.eq_pm.eq_pm_id");
            WHERE("dbo.sg_info.bh IS NOT NULL");
            if (StringUtils.isNotBlank(year)) {
                WHERE("dbo.sg_info.id IN (SELECT dbo.sg_ybghhy.sg_id FROM dbo.sg_ybghhy WHERE YEAR(dbo.sg_ybghhy.ybghhy_sj) = #{year,jdbcType=VARCHAR})");
            }
            if (StringUtils.isNotBlank(bmId)) {
                WHERE("dbo.sg_info.bm_id = #{bmId,jdbcType=VARCHAR}");
            }
            WHERE("dbo.sg_info.isybghsh = 1 AND dbo.sg_info.iskssh = 1 AND dbo.sg_info.isyxgccsh = 1 AND dbo.sg_info.iszbwyhsh = 1");
        }}.toString();
    }

    /**
     * 院办公会年度采购预算
     *
     * @param year 年份
     * @param bmId 部门id
     * @return sql
     */
    public String selectSgYbghhyYearBudget(String year, String bmId) {
        return new SQL() {{
            SELECT("dbo.sg_info.bm_id");
            SELECT("Sum(dbo.sg_info.price_gj_y) AS ysy");
            SELECT("Sum(dbo.sg_info.price_gj_my) AS ysmy");
            FROM("dbo.sg_info");
            WHERE("dbo.sg_info.isybghsh = '1'");
            WHERE("dbo.sg_info.id IN ( " +
                    "SELECT dbo.sg_ybghhy.sg_id " +
                    "FROM dbo.sg_ybghhy " +
                    "INNER JOIN dbo.sg_info ON dbo.sg_ybghhy.sg_id = dbo.sg_info.id " +
                    "WHERE year(dbo.sg_ybghhy.ybghhy_sj) = #{year,jdbcType=VARCHAR}" +
                    ")");
            if (StringUtils.isNotBlank(bmId)) {
                WHERE("dbo.sg_info.bm_id = #{bmId,jdbcType=VARCHAR}");
            }
            GROUP_BY("dbo.sg_info.bm_id");
        }}.toString();
    }

    /**
     * 装备委员会年度采购预算
     *
     * @param year 年份
     * @param bmId 部门id
     * @return sql
     */
    public String selectSgZbwyhYearBudget(String year, String bmId) {
        return new SQL() {{
            SELECT("dbo.sg_info.bm_id");
            SELECT("Sum(dbo.sg_info.price_gj_y) AS ysy");
            SELECT("Sum(dbo.sg_info.price_gj_my) AS ysmy");
            FROM("dbo.sg_info");
            WHERE("dbo.sg_info.iszbwyhsh = '1'");
            WHERE("dbo.sg_info.id IN (" +
                    "SELECT dbo.sg_zbwyhhy.sg_id " +
                    "FROM dbo.sg_zbwyhhy " +
                    "INNER JOIN dbo.sg_info ON dbo.sg_zbwyhhy.sg_id = dbo.sg_info.id " +
                    "WHERE dbo.sg_zbwyhhy.zbwyhhy_nd = #{year,jdbcType=VARCHAR}" +
                    ")");
            if (StringUtils.isNotBlank(bmId)) {
                WHERE("dbo.sg_info.bm_id = #{bmId,jdbcType=VARCHAR}");
            }
            GROUP_BY("dbo.sg_info.bm_id");
        }}.toString();
    }

    public String selectSgInfoList(String isSh, String bmId, String bh, String sbName) {
        return new SQL() {{
            SELECT("dbo.sg_info.id,\n" +
                    "dbo.s_bm.bm_name,\n" +
                    "dbo.sg_info.bh,\n" +
                    "dbo.eq_pm.eq_pm_name,\n" +
                    "dbo.sg_info.num,\n" +
                    "dbo.sg_info.price_gj_y,\n" +
                    "dbo.sg_info.zt,\n" +
                    "dbo.sg_info.kstl_id,\n" +
                    "dbo.sg_info.pjbg_id,\n" +
                    "dbo.sg_info.kxfx_id,\n" +
                    "dbo.sg_info.dxzb_id,\n" +
                    "dbo.sg_info.lzfx_id,\n" +
                    "dbo.sg_info.zbwyhhy_id,\n" +
                    "dbo.sg_info.ybghhy_id\n");
            FROM("dbo.sg_info\n" +
                    "INNER JOIN dbo.eq_pm ON dbo.sg_info.eq_pm_id = dbo.eq_pm.eq_pm_id\n" +
                    "INNER JOIN dbo.s_bm ON dbo.sg_info.bm_id = dbo.s_bm.bm_id");
            //通过审核
            if ("1".equals(isSh)) {
                WHERE("dbo.sg_info.isybghsh = 1");
            }
            //未通过审核
            else if ("0".equals(isSh)) {
                WHERE("dbo.sg_info.iskssh = 0 OR dbo.sg_info.isyxgccsh = 0 OR " +
                        "dbo.sg_info.iszbwyhsh = 0 OR dbo.sg_info.isybghsh = 0");
            }
            //待审核
            else if ("2".equals(isSh)) {
                WHERE("dbo.sg_info.iskssh is null " +
                        "OR dbo.sg_info.isyxgccsh is null AND dbo.sg_info.iskssh = 1 " +
                        "OR dbo.sg_info.iszbwyhsh is null AND dbo.sg_info.iskssh = 1 AND dbo.sg_info.isyxgccsh = 1 " +
                        "OR dbo.sg_info.isybghsh is null AND dbo.sg_info.iskssh = 1 AND dbo.sg_info.isyxgccsh = 1 AND dbo.sg_info.iszbwyhsh = 1 ");
            }
            //科室查找
            if (StringUtils.isNotBlank(bmId)) {
                WHERE(" dbo.sg_info.bm_id = #{bmId,jdbcType=VARCHAR} ");
            }
            //通过申购单编号查找
            if (StringUtils.isNotBlank(bh)) {
                WHERE(" dbo.sg_info.bh = #{bh,jdbcType=VARCHAR} ");
            }
            //通过设备拼音码查找
            if (StringUtils.isNotBlank(sbName)){
                WHERE(" pym = #{sbName,jdbcType=VARCHAR} ");
            }
        }}.toString();
    }

    public static void main(String[] args) {
        SgInfoSqlProvider s = new SgInfoSqlProvider();
        SgInfo sgInfo = new SgInfo();
        sgInfo.setId("1");
        sgInfo.setBmId("1");
//        String s1 = s.updateSgInfoById(sgInfo);

        String bmId = "1000011";
        String sgInfoBh = "01";
        List<String> pmList = new ArrayList<>();
        pmList.add("6803010102");
        pmList.add("6803010101");
//        String s1 = s.selectKsShHz(bmId,sgInfoBh,pmList);
//        System.out.println(s1);
        String s1 = s.selectSgYbghhyYearBudget("2018", null);
        System.out.println(s1);
    }
}
