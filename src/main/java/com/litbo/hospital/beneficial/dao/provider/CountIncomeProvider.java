package com.litbo.hospital.beneficial.dao.provider;

/**
 * description: 统计His、Pacs、手术室系统收入的sql语句
 * @Author: jz
 * @date  2019/7/26 15:42
 */
public class CountIncomeProvider {

    public String selectHis(){
        String sql = "SELECT MAX\n" +
                "( dbo.s_bm.p_bm_id ) AS ksId,\n" +
                "MAX ( dbo.eq_info.eq_id ) AS sbId,\n" +
                "MAX ( CONVERT( VARCHAR ( 100 ), dbo.his_sflb.his_Sfsj, 23 ) ) AS kmSj,\n" +
                "MAX ( CASE dbo.his_sflb.his_BrBz WHEN 'MZ' THEN '400101' WHEN 'ZY' THEN '400102' ELSE '4031' END ) AS kmNum,\n" +
                "MAX ( CASE dbo.his_sflb.his_BrBz WHEN 'MZ' THEN '门诊收入' WHEN 'ZY' THEN '住院收入' ELSE '其他收入' END ) AS hisSr,\n" +
                "MAX ( dbo.his_sflb.his_XmJe ) AS kmJe,\n" +
                "MAX ( CASE dbo.his_sflb.his_BrBz WHEN 'MZ' THEN '3' WHEN 'ZY' THEN '3' ELSE '3' END ) AS kmCjdm,\n" +
                "MAX ( dbo.s_bm.bm_name ) AS bmName,\n" +
                "MAX ( dbo.eq_info.eq_name ) AS eqName \n" +
                "FROM\n" +
                "dbo.his_sflb\n" +
                "JOIN dbo.his_SFXM_DICT ON dbo.his_sflb.his_YXmBm = dbo.his_SFXM_DICT.Sf_XmBm\n" +
                "JOIN dbo.eq_yz_tab ON dbo.his_SFXM_DICT.Sf_XmBm = dbo.eq_yz_tab.yz_XmBm\n" +
                "JOIN dbo.eq_info ON dbo.eq_yz_tab.eq_id = dbo.eq_info.eq_id\n" +
                "JOIN dbo.s_bm ON dbo.eq_info.eq_bmid = dbo.s_bm.p_bm_id \n" +
                "WHERE\n" +
                "dbo.his_sflb.his_status = '1' \n" +
                "AND dbo.his_sflb.his_XmSl> 0 \n" +
                "GROUP BY\n" +
                "dbo.eq_info.eq_id";
        return sql;
    }

    public String selectPacs(){
        String sql = "SELECT MAX\n" +
                "( dbo.s_bm.p_bm_id ) AS ksId,\n" +
                "MAX ( dbo.eq_info.eq_id ) AS sbId,\n" +
                "MAX ( CONVERT( VARCHAR ( 100 ), dbo.pacs_sflb.C_FTime, 23 ) ) AS kmSj,\n" +
                "MAX ( CASE dbo.pacs_sflb.C_BrBz WHEN 'MZ' THEN '400101' WHEN 'ZY' THEN '400102' ELSE '4031' END ) AS kmNum,\n" +
                "MAX ( CASE dbo.pacs_sflb.C_BrBz WHEN 'MZ' THEN '门诊收入' WHEN 'ZY' THEN '住院收入' ELSE '其他收入' END ) AS kmName,\n" +
                "MAX ( dbo.pacs_sflb.C_PacsJe ) AS keJe,\n" +
                "MAX ( CASE dbo.pacs_sflb.C_BrBz WHEN 'MZ' THEN '3' WHEN 'ZY' THEN '3' ELSE '3' END ) AS kmCjdm,\n" +
                "MAX ( dbo.s_bm.bm_name ) AS bmName,\n" +
                "MAX ( dbo.eq_info.eq_name ) AS eqName\n" +
                "FROM\n" +
                "dbo.pacs_sflb\n" +
                "JOIN dbo.pacs_tab ON dbo.pacs_sflb.C_MacID = dbo.pacs_tab.C_MacID\n" +
                "JOIN dbo.eq_pacs ON dbo.pacs_tab.C_MacID = dbo.eq_pacs.pacs_id\n" +
                "JOIN eq_info ON dbo.eq_pacs.eq_id = dbo.eq_info.eq_id\n" +
                "JOIN dbo.s_bm ON dbo.eq_info.eq_bmid = dbo.s_bm.p_bm_id \n" +
                "WHERE dbo.pacs_sflb.C_PacsJe > 0\n" +
                "GROUP BY\n" +
                "dbo.eq_info.eq_id    ";
        return sql;
    }

    public String selectSss(){
        String sql = "SELECT MAX\n" +
                "( dbo.s_bm.p_bm_id ) AS ksId,\n" +
                "MAX ( dbo.eq_info.eq_id ) AS sbId,\n" +
                "MAX ( CONVERT( VARCHAR ( 100 ), dbo.sss_sflb.sss_Sfsj, 23 ) ) AS kmSj,\n" +
                "MAX ( CASE dbo.sss_sflb.sss_BrBz WHEN 'MZ' THEN '400101' WHEN 'ZY' THEN '400102' ELSE '4031' END ) AS kmNum,\n" +
                "MAX ( CASE dbo.sss_sflb.sss_BrBz WHEN 'MZ' THEN '门诊收入' WHEN 'ZY' THEN '住院收入' ELSE '其他收入' END ) AS hisSr,\n" +
                "MAX ( dbo.sss_sflb.sss_XmJe ) AS kmJe,\n" +
                "MAX ( CASE dbo.sss_sflb.sss_BrBz WHEN 'MZ' THEN '3' WHEN 'ZY' THEN '3' ELSE '3' END ) AS kmCjdm,\n" +
                "MAX ( dbo.s_bm.bm_name ) AS bmName,\n" +
                "MAX ( dbo.eq_info.eq_name ) AS eqName \n" +
                "FROM\n" +
                "dbo.sss_sflb\n" +
                "JOIN dbo.his_SFXM_DICT ON dbo.sss_sflb.sss_YXmBm = dbo.his_SFXM_DICT.Sf_XmBm\n" +
                "JOIN dbo.eq_yz_tab ON dbo.his_SFXM_DICT.Sf_XmBm = dbo.eq_yz_tab.yz_XmBm\n" +
                "JOIN dbo.eq_info ON dbo.eq_yz_tab.eq_id = dbo.eq_info.eq_id\n" +
                "JOIN dbo.s_bm ON dbo.eq_info.eq_bmid = dbo.s_bm.p_bm_id \n" +
                "WHERE\n" +
                "dbo.sss_sflb.sss_status = '1' \n" +
                "AND dbo.sss_sflb.sss_XmSl > 0 \n" +
                "GROUP BY\n" +
                "dbo.eq_info.eq_id";
        return sql;
    }

    public String timingSelectHis(){
        String sql = "";
        return sql;
    }

    public String timingSelectPacs(){
        String sql = "";
        return sql;
    }

    public String timingSelectSss(){
        String sql = "";
        return sql;
    }

}
