package com.litbo.hospital.lifemanage.dao.provider;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 申购单表Mapper接口的sql类
 */
public class SgLssqSqlProvider {
    /**
     * 查询临时授权信息
     *
     * @param ksId     科室id
     * @param isKsg    授权是否过期
     */
    public String selectSgLssq(String ksId, String isKsg) {
        return new SQL() {{
            SELECT("lssq_id");
            SELECT("lssq_sqr");
            SELECT("lssq_bsqks");
            SELECT("lssq_sqrq");
            SELECT("lssq_ksrq");
            SELECT("lssq_jsrq");
            FROM("sg_lssq");
            if (StringUtils.isNotBlank(ksId)){
                WHERE("lssq_bsqks = #{ksId,jdbcType=VARCHAR}");
            }
            if ("1".equals(isKsg)){
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date = dateFormat.format(new Date());
                WHERE("('"+date+"' BETWEEN lssq_ksrq AND lssq_jsrq)");
            }
            if ("0".equals(isKsg)){
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date = dateFormat.format(new Date());
                WHERE("('"+date+"' NOT BETWEEN lssq_ksrq AND lssq_jsrq)");
            }
        }}.toString();
    }

    public static void main(String[] args) {
        SgLssqSqlProvider sgLssqSqlProvider = new SgLssqSqlProvider();
        String s = sgLssqSqlProvider.selectSgLssq("1", "1");
        System.out.println(s);
    }
}
