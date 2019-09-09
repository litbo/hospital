package com.litbo.hospital.lifemanage.dao.provider.MyProvider;


import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqTjjjVO;

public class TjjjProvider {
    private static String str = "";

    /*交接记录录入*/
    public String insertTjjj(EqTjjjVO vo) {

        str = "  insert into eq_tjjj (id, tjjj_bianma, tjjj_count, \n" +
                "      tjjj_tprq, tjjj_tpsj, tjjj_dpgc, \n" +
                "      tjjj_dpfztjc, tjjj_dpffjjc, tjjj_drks, \n" +
                "      tjjj_dcks, tjjj_drjbr, tjjj_dcjbr, \n" +
                "      tjjj_jllx, tjjj_zbdcid, tjjj_qita, \n" +
                "      tjjj_jsrq, tjjj_dpsc, tjjj_jsfztjc, \n" +
                "      tjjj_jsffjjc,tjjj_dcurl,tjjj_drurl)\n" +
                "    values (#{id,jdbcType=VARCHAR}, #{tjjjBianma,jdbcType=VARCHAR}, #{tjjjCount,jdbcType=INTEGER}, \n" +
                "      #{tjjjTprq,jdbcType=DATE}, #{tjjjTpsj,jdbcType=DATE}, #{tjjjDpgc,jdbcType=VARCHAR}, \n" +
                "      #{tjjjDpfztjc,jdbcType=VARCHAR}, #{tjjjDpffjjc,jdbcType=VARCHAR}, #{tjjjDrks,jdbcType=VARCHAR}, \n" +
                "      #{tjjjDcks,jdbcType=VARCHAR}, #{tjjjDrjbr,jdbcType=VARCHAR}, #{tjjjDcjbr,jdbcType=VARCHAR}, \n" +
                "      #{tjjjJllx,jdbcType=VARCHAR}, #{tjjjZbdcid,jdbcType=VARCHAR}, #{tjjjQita,jdbcType=VARCHAR}, \n" +
                "      #{tjjjJsrq,jdbcType=DATE}, #{tjjjDpsc,jdbcType=INTEGER}, #{tjjjJsfztjc,jdbcType=VARCHAR}, \n" +
                "      #{tjjjJsffjjc,jdbcType=VARCHAR}," +
                "      #{tjjjDcurl,jdbcType=VARCHAR}," +
                "      #{tjjjDrurl,jdbcType=VARCHAR})" ;
        return str;
    }




}
