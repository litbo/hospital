package com.litbo.hospital.operational_data_monitoring.software_interface.dao;

import com.litbo.hospital.operational_data_monitoring.software_interface.bean.PacsSflb;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.SssSflb;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.SearchVO;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.SssSflbVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.dao
 * @Author: looli
 * @CreateTime: 2019-07-26 15:45
 * @Description: todo
 */
public interface SssSflbDAO {
    @Select({"<script>",
            "insert into sss_sflb (sss_SFID, sss_PatID, \n" +
            "      sss_Sfsj, sss_BrXm, sss_BrNl, \n" +
            "      sss_BrXb, sss_BrBz, sss_YXmBm, \n" +
            "      sss_XmJe, sss_XmSl, \n" +
            "      sss_MDeptId, sss_MTime, sss_Status,\n" +
            "      sss_ChkNo,sss_Jcbz,sss_NDeptID) values",
            "<foreach item='sss' collection='list' separator=',' > \n"+
                    "(#{sss.sssSFID,jdbcType=VARCHAR},#{sss.sssPatID,jdbcType=VARCHAR}, \n" +
                    "      #{sss.sssSfsj,jdbcType=TIMESTAMP}, #{sss.sssBrXm,jdbcType=VARCHAR}, #{sss.sssBrNl,jdbcType=VARCHAR}, \n" +
                    "      #{sss.sssBrXb,jdbcType=VARCHAR}, #{sss.sssBrBz,jdbcType=VARCHAR}, #{sss.sssYXmBm,jdbcType=VARCHAR}, \n" +
                    "      #{sss.sssXmJe,jdbcType=DECIMAL}, #{sss.sssXmSl,jdbcType=INTEGER}, \n" +
                    "      #{sss.sssMDeptId,jdbcType=VARCHAR}, #{sss.sssMTime,jdbcType=TIMESTAMP}, #{sss.sssStatus,jdbcType=VARCHAR},\n" +
                    "      #{sss.sssChkNo},#{sss.sssJcbz},#{sss.sssNDeptID})",
            "</foreach>",
            "</script>"})
    void saves(List<SssSflb> sssSflbList);

    /**
     * 查询手术室收费明细 根据时间
     * @param searchVO
     * @return
     */
    @Select({ "<script>",
            "\n" +
                    "    SELECT\n" +
                    "    a.sss_PatID as sPatID,\n" +
                    "    a.sss_BrXm as sBrXm,\n" +
                    "    a.sss_BrBz as sBrBz,\n" +
                    "    b.Sf_XmMc as SfXmmc,\n" +
                    "    a.sss_XmJe as sXmJe,\n" +
                    "    a.sss_Status as status\n" +
                    "            FROM\n" +
                    "    sss_sflb a,\n" +
                    "    his_SFXM_DICT b\n" +
                    "    WHERE\n" +
                    "    CONVERT ( VARCHAR ( 100 ), sss_Sfsj, 23 ) = #{beginTime}\n" +
                    "    AND a.sss_YXmBm = b.Sf_XmBm",
            "<if test='patientId != null'> AND  sss_PatID = #{patientId} </if>\n" +
                    "<if test='patientType != null'> AND  sss_BrBz = #{patientType} </if>\n" ,
            "</script>"})
    List<SssSflbVO> selectByTime(SearchVO searchVO);
}
