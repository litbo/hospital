package com.litbo.hospital.lifemanage.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import java.util.ArrayList;
import java.util.List;

/**
 * 申购单表Mapper接口的sql类
 */
public class SgKstlSqlProvider {
    /**
     * 通过部门id和品名id查询申购单id、申购单编号
     *
     * @param pmIds 品名ID
     * @return sql语句
     */
    public String selectSgKstlVOByEqPmIds(List<String> pmIds) {
        return new SQL() {{
            SELECT("eq_pm.eq_pm_id");
            SELECT("eq_pm.eq_pm_name");
            SELECT("eq_pm.eq_pm_jc");
            SELECT("sg_info.id as sgInfoId");
            SELECT("sg_info.bh");
            SELECT("sg_tl_pm.kstl_sj");
            FROM("eq_pm");
            INNER_JOIN("sg_info ON eq_pm.eq_pm_id = sg_info.eq_pm_id");
            INNER_JOIN("sg_tl_pm ON eq_pm.eq_pm_id = sg_tl_pm.eq_pm_id");
            if (pmIds != null && pmIds.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < pmIds.size(); i++) {
                    sb.append(pmIds.get(i));
                    if (pmIds.size() != (i + 1)) {
                        sb.append(",");
                    }
                }
                WHERE("eq_pm.eq_pm_id IN (" + sb.toString() + ")");
            }
            WHERE("sg_info.iskssh <> 1 OR sg_info.iskssh IS NULL");
            ORDER_BY("kstl_sj desc");
        }}.toString();
    }

    public static void main(String[] args) {
        List<String> emPmIds = new ArrayList<>();
        emPmIds.add("6803010101");
        emPmIds.add("6803010102");
        SgKstlSqlProvider s = new SgKstlSqlProvider();
        String s1 = s.selectSgKstlVOByEqPmIds(emPmIds);
        System.out.println(s1);
    }
}
