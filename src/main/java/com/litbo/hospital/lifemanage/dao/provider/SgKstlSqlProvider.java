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
    public String selectSgKstlVOByEqPmIds(List<Integer> pmIds) {
        return new SQL() {{
            /*SELECT
                eq_pm.eq_pm_id,
                eq_pm.eq_pm_name,
                eq_pm.eq_pm_jc,
                eq_ylqxfl.eqfl_id,
                eq_ylqxfl.eqfl_name,
                sg_info.bh,
                sg_tl_pm.kstl_sj
            FROM eq_pm
            INNER JOIN sg_info ON eq_pm.eq_pm_id = sg_info.eq_pm_id
            INNER JOIN eq_ylqxfl ON eq_pm.eq_fl_id = eq_ylqxfl.eqfl_id
            INNER JOIN sg_tl_pm ON eq_pm.eq_pm_id = sg_tl_pm.eq_pm_id
            WHERE (sg_info.eq_pm_id IN (1,2))
            */
            SELECT("eq_pm.eq_pm_id");
            SELECT("eq_pm.eq_pm_name");
            SELECT("eq_pm.eq_pm_jc");
            SELECT("eq_ylqxfl.eqfl_id");
            SELECT("eq_ylqxfl.eqfl_name");
            SELECT("sg_info.bh");
            SELECT("sg_tl_pm.kstl_sj");
            FROM("eq_pm");
            INNER_JOIN("sg_info ON eq_pm.eq_pm_id = sg_info.eq_pm_id");
            INNER_JOIN("eq_ylqxfl ON eq_pm.eq_fl_id = eq_ylqxfl.eqfl_id");
            INNER_JOIN("sg_tl_pm ON eq_pm.eq_pm_id = sg_tl_pm.eq_pm_id");
            if (pmIds != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < pmIds.size(); i++) {
                    sb.append(pmIds.get(i));
                    if (pmIds.size() != (i + 1)) {
                        sb.append(",");
                    }
                }
                WHERE("sg_info.eq_pm_id IN (" + sb.toString() + ")");
            }
        }}.toString();
    }

    public static void main(String[] args) {
        List<Integer> emPmIds = new ArrayList<>();
        emPmIds.add(1);
        emPmIds.add(2);
        SgKstlSqlProvider s = new SgKstlSqlProvider();
        String s1 = s.selectSgKstlVOByEqPmIds(emPmIds);
        System.out.println(s1);
    }
}
