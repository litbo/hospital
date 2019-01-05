package com.litbo.hospital.lifemanage.dao.provider;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

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
     * @param departmentId        部门id
     * @param equipmentPinyinCode 设备拼音码
     * @param departmentCoding    院内编码
     * @param equipmentNumber     设备编码
     * @return sql
     */
    public String selectEquipmentAccount(String category, String state, String departmentId, String equipmentPinyinCode, String departmentCoding, String equipmentNumber) {
        SQL sql = new SQL();
        sql.SELECT("dbo.eq_info.eq_id,\n" +
                "dbo.eq_info.eq_sbbh,\n" +
                "dbo.eq_info.eq_yq,\n" +
                "dbo.eq_info.eq_gg,\n" +
                "dbo.eq_info.eq_xh,\n" +
                "dbo.eq_info.eq_bmid,\n" +
                "dbo.eq_info.eq_tzlb,\n" +
                "dbo.eq_info.eq_qysj,\n" +
                "dbo.eq_info.eq_synx,\n" +
                "dbo.eq_info.eq_syzt as state");
        sql.FROM("dbo.eq_info");
        if (StringUtils.isNotBlank(category)){
            //医学装备 68是 非68不是
            if (category.equals("68")){
                sql.WHERE("LEFT(dbo.eq_info.eq_pm_id,2) = 68");
            }else{
                sql.WHERE("LEFT(dbo.eq_info.eq_pm_id,2) <> 68");
            }
        }
        if (StringUtils.isNotBlank(state)){
            sql.WHERE("dbo.eq_info.eq_syzt = #{state,jdbcType=VARCHAR}");
        }
        if (StringUtils.isNotBlank(departmentId)){
            sql.WHERE("dbo.eq_info.eq_bmid = #{departmentId,jdbcType=VARCHAR}");
        }
        if (StringUtils.isNotBlank(equipmentPinyinCode)){
            sql.WHERE("dbo.eq_info.eq_pym = #{equipmentPinyinCode,jdbcType=VARCHAR}");
        }
        if (StringUtils.isNotBlank(departmentCoding)){
            sql.WHERE("1=1");
        }

        if (StringUtils.isNotBlank(equipmentNumber)){
            sql.WHERE("dbo.eq_info.eq_sbbh = #{equipmentNumber,jdbcType=VARCHAR}");
        }
        return sql.toString();
    }
}
