package com.litbo.hospital.lifemanage.dao.mapper;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 科室讨论申购设备关联表sql语句
 */
public class SgTiPmProvider {
    /**
     * 申购设备关联信息批量添加拼接的sql语句
     *
     * @param kstlId  科室讨论的ID
     * @param pmId 设备品名ID
     * @return sql语句
     */
    public String insertSgTiPmSql(String kstlId, List<Integer> pmId) {
        StringBuilder sql = new StringBuilder();
        if (StringUtils.isNotBlank(kstlId) && pmId.size() > 0) {
            sql.append("INSERT INTO sg_tl_pm(kstl_id,eq_pm_id) VALUES");
            for (int i = 0; i < pmId.size(); i++) {
                if ((i + 1) == pmId.size()) {
                    sql.append("(").append(kstlId).append(",").append(pmId.get(i)).append(")");
                } else {
                    sql.append("(").append(kstlId).append(",").append(pmId.get(i)).append("),");
                }
            }
            return sql.toString();
        } else {
            return "";
        }
    }
}