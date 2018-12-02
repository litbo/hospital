package com.litbo.hospital.lifemanage.dao.mapper;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 科室讨论会议人员关联表sql语句
 */
public class SgKstlUserSql {
    /**
     * 添加科室讨论人员信息批量添加拼接的sql语句
     *
     * @param kstlId  科室讨论的ID
     * @param usersId 参加讨论的人员集合
     * @return sql语句
     */
    public String insertSgKstlUserSql(String kstlId, List<String> usersId) {
        StringBuilder sql = new StringBuilder();
        if (StringUtils.isNotBlank(kstlId) && usersId.size() > 0) {
            sql.append("INSERT INTO sg_kstl_user(kstl_id,user_id) VALUES");
            for (int i = 0; i < usersId.size(); i++) {
                if ((i + 1) == usersId.size()) {
                    sql.append("(").append(kstlId).append(",").append(usersId.get(i)).append(")");
                } else {
                    sql.append("(").append(kstlId).append(",").append(usersId.get(i)).append("),");
                }
            }
            return sql.toString();
        } else {
            return "";
        }
    }
}