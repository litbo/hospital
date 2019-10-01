package com.litbo.hospital.lifemanage.dao.provider;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Date;

/**
 * 电子台账Provider
 *
 * @author Administrator on 2018-12-29
 */
public class EquipmentAccountProvider {
    /**
     * 查询电子台账
     *
     * @param category            是否是医学装备 68是 非68不是
     * @param state               状态
     * @param departmentId        科室id
     * @param equipmentPinyinCode 设备拼音码
     * @param departmentCoding    院内编码
     * @param equipmentNumber     设备编码
     * @return sql
     */
    public String selectEquipmentAccount(String category, String state,String tzlb, String departmentId, String equipmentPinyinCode, String departmentCoding, String equipmentNumber) {
        SQL sql = new SQL();
        sql.SELECT("dbo.eq_info.eq_id,\n" +
                "dbo.eq_info.eq_sbbh,\n" +
                "dbo.eq_info.eq_name,\n" +
                "dbo.eq_info.eq_zcbh as eqYq,\n" +
                "dbo.eq_info.eq_pm_id AS flBh,\n" +
                "dbo.eq_info.eq_gg,\n" +
                "dbo.eq_info.eq_xh,\n" +
                "dbo.s_bm.bm_name as eqBmName,\n" +
                "dbo.eq_info.eq_tzlb,\n" +
                "dbo.eq_info.eq_qysj,\n" +
                "dbo.eq_info.eq_synx,\n" +
                "dbo.eq_info.eq_syzt as state");
        sql.FROM("dbo.eq_info");
        sql.INNER_JOIN("dbo.s_bm ON dbo.eq_info.eq_bmid = dbo.s_bm.bm_id");
        sql.WHERE("dbo.eq_info.eq_sbbh IS NOT NULL AND\n" +
                "dbo.eq_info.eq_zcbh IS NOT NULL AND\n" +
                "dbo.eq_info.eq_tzlb IS NOT NULL\n");
        if (StringUtils.isNotBlank(category)) {
            //医学装备 68是 非68不是
            if (category.equals("68")) {
                sql.WHERE("LEFT(dbo.eq_info.eq_pm_id,2) = 68");
            } else {
                sql.WHERE("LEFT(dbo.eq_info.eq_pm_id,2) <> 68");
            }
        }
        if (StringUtils.isNotBlank(state)) {
            sql.WHERE("dbo.eq_info.eq_syzt = #{state,jdbcType=VARCHAR}");
        }
        if (StringUtils.isNotBlank(tzlb)) {
            sql.WHERE("dbo.eq_info.eq_tzlb  like CONCAT('%',#{tzlb},'%') ");
        }
        if (StringUtils.isNotBlank(departmentId)) {
            sql.WHERE("dbo.eq_info.eq_bmid = #{departmentId,jdbcType=VARCHAR}");
        }
        if (StringUtils.isNotBlank(equipmentPinyinCode)) {
            sql.WHERE("dbo.eq_info.eq_pym like #{equipmentPinyinCode,jdbcType=VARCHAR}");
        }
        if (StringUtils.isNotBlank(departmentCoding)) {
            sql.WHERE("dbo.eq_info.eq_zcbh like #{departmentCoding,jdbcType=VARCHAR}");
        }

        if (StringUtils.isNotBlank(equipmentNumber)) {
            sql.WHERE("dbo.eq_info.eq_sbbh like #{equipmentNumber,jdbcType=VARCHAR}");
        }
        return sql.toString();
    }

    /**
     * 科室设备综合查询
     *
     * @param tgbmId              托管科室id
     * @param bmId                使用科室
     * @param eqQysjLower         启用时间下限
     * @param eqQysjUpper         启用时间上限
     * @param eqCgrqLower         采购日期下限
     * @param eqCgrqUpper         采购日期上限
     * @param eqPriceLower        设备价格下限
     * @param eqPriceUpper        设备价格上限
     * @param state               状态
     * @param equipmentPinyinCode 设备拼音码
     * @param departmentCoding    院内编码
     * @param eqCxflId            设备分类Id
     * @param bxqx                是否过保
     * @return sql
     */
    public String selectKsEq(
            String tgbmId, String bmId, String eqQysjLower, String eqQysjUpper, String eqCgrqLower,
            String eqCgrqUpper, String eqPriceLower, String eqPriceUpper, String state, String equipmentPinyinCode,
            String departmentCoding, String eqCxflId, String bxqx) {
        SQL sql = new SQL();
        sql.SELECT("dbo.eq_info.eq_id,\n" +
                "dbo.eq_info.eq_zcbh,\n" +
                "dbo.eq_info.eq_sbbh,\n" +
                "dbo.eq_info.eq_name,\n" +
                "dbo.eq_info.eq_gg,\n" +
                "dbo.eq_info.eq_xh,\n" +
                "dbo.eq_info.eq_qysj,\n" +
                "dbo.eq_cxfl.eq_cxfl_name,\n" +
                "dbo.eq_info.eq_bxqx,\n" +
                "dbo.eq_info.eq_cgrq,\n" +
                "dbo.eq_info.eq_syzt,\n" +
                "dbo.s_bm.bm_name,\n" +
                "dbo.eq_info.eq_price,\n" +
                "dbo.eq_info.eq_tgks,\n" +
                "dbo.eq_cs.sbcs_name");
        sql.FROM("dbo.eq_info");
        sql.INNER_JOIN("dbo.eq_cxfl ON dbo.eq_info.eq_cxfl_id = dbo.eq_cxfl.eq_cxfl_id\n" +
                "LEFT JOIN dbo.s_bm ON dbo.eq_info.eq_bmid = dbo.s_bm.bm_id\n" +
                "LEFT JOIN dbo.eq_cs ON dbo.eq_info.sbcs_id_scs = dbo.eq_cs.sbcs_id");
        if (StringUtils.isNotBlank(state)) {
            sql.WHERE("dbo.eq_info.eq_syzt = #{state,jdbcType=VARCHAR}");
        }
        if (StringUtils.isNotBlank(equipmentPinyinCode)) {
            sql.WHERE("dbo.eq_info.eq_pym like #{equipmentPinyinCode,jdbcType=VARCHAR}");
        }
        if (StringUtils.isNotBlank(departmentCoding)) {
            sql.WHERE("dbo.eq_info.eq_zcbh like #{departmentCoding,jdbcType=VARCHAR}");
        }
        if (StringUtils.isNotBlank(eqCxflId)) {
            sql.WHERE("dbo.eq_info.eq_cxfl_id = #{eqCxflId,jdbcType=VARCHAR}");
        }
        if (StringUtils.isNotBlank(tgbmId)) {
            sql.WHERE("dbo.eq_info.eq_tgks = #{tgbmId,jdbcType=VARCHAR}");
        }
        if (StringUtils.isNotBlank(bmId)) {
            sql.WHERE("dbo.eq_info.eq_bmid = #{bmId,jdbcType=VARCHAR}");
        }
        if (StringUtils.isNotBlank(eqQysjLower)) {
            sql.WHERE("dbo.eq_info.eq_qysj >= #{eqQysjLower,jdbcType=VARCHAR}");
        }
        if (StringUtils.isNotBlank(eqQysjUpper)) {
            sql.WHERE("dbo.eq_info.eq_qysj <= #{eqQysjUpper,jdbcType=VARCHAR}");
        }
        if (StringUtils.isNotBlank(eqCgrqLower)) {
            sql.WHERE("dbo.eq_info.eq_cgrq >= #{eqCgrqLower,jdbcType=VARCHAR}");
        }
        if (StringUtils.isNotBlank(eqCgrqUpper)) {
            sql.WHERE("dbo.eq_info.eq_cgrq <= #{eqCgrqUpper,jdbcType=VARCHAR}");
        }
        if (StringUtils.isNotBlank(eqPriceLower)) {
            sql.WHERE("dbo.eq_info.eq_price >= #{eqPriceLower,jdbcType=VARCHAR}");
        }
        if (StringUtils.isNotBlank(eqPriceUpper)) {
            sql.WHERE("dbo.eq_info.eq_price <= #{eqPriceUpper,jdbcType=VARCHAR}");
        }
        // TODO 保修期限 是否过期 通过设备启用时间加上保修期限/月 大于当前日期为在保 否则为过保 bxqx == 0/1 过保/在保
        if (StringUtils.isNotBlank(bxqx) && "0".equals(bxqx)) {
            sql.WHERE("1=1");
        } else if (StringUtils.isNotBlank(bxqx) && "1".equals(bxqx)) {
            sql.WHERE("1=1");
        }
        sql.WHERE("dbo.eq_info.eq_sbbh IS NOT NULL AND dbo.eq_info.eq_zcbh IS NOT NULL");
        return sql.toString();
    }

    public static void main(String[] args) {
        EquipmentAccountProvider s = new EquipmentAccountProvider();
        String sql = s.selectKsEq(null, null, new Date().toString(), new Date().toString(), null, null, null, null, null, null, null, null, null);
        System.out.println(sql);
    }
}
