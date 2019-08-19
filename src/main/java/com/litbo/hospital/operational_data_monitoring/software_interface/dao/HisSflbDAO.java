package com.litbo.hospital.operational_data_monitoring.software_interface.dao;

import com.litbo.hospital.operational_data_monitoring.software_interface.bean.HisSflb;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.HISCycle;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.HisSflbVO;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.SearchVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.dao
 * @Author: looli
 * @CreateTime: 2019-07-26 10:16
 * @Description: 我方系统数据库操作
 */
public interface HisSflbDAO {
    /**
     * 批量保存
     * @param hisSflbs
     */
    @Insert({"<script>",
            "INSERT INTO his_sflb (his_SFID, his_AssetNO, his_PatID, \n" +
                    "      his_Sfsj, his_BrXm, his_BrNl, \n" +
                    "      his_BrXb, his_BrBz, his_YXmBm, \n" +
                    "      his_XmBm, his_XmJe, his_XmSl, \n" +
                    "      his_MDeptID, his_MTime, his_status\n" +
                    "      )\n" +
                    "    values ",
                    "<foreach item='his' collection='list' separator=',' > \n" +
                            "(#{his.hisSFID}, #{his.hisAssetNO}, #{his.hisPatID}, \n" +
                            "#{his.hisSfsj}, #{his.hisBrXm}, #{his.hisBrNl}, \n" +
                            "#{his.hisBrXb}, #{his.hisBrBz}, #{his.hisYXmBm}, \n" +
                            "#{his.hisXmBm}, #{his.hisXmJe}, #{his.hisXmSl}, \n" +
                            "#{his.hisMDeptID}, #{his.hisMTime}, #{his.hisstatus})\n" +
                    "</foreach>",
            "</script>"})
    void saves(List<HisSflb> hisSflbs);

    /**
     * 根据时间
     * 查询his收费明细
     */
    @Select({
            "<script>",
            "SELECT\n" +
                    "a.his_PatID as hisPatID,\n" +
                    "a.his_BrXm as hisBrXm,\n" +
                    "a.his_BrBz as hisBrBz,\n" +
                    "b.Sf_XmMc as SfXmmc,\n" +
                    "a.his_XmJe as hisXmJe,\n" +
                    "a.his_status as hisstatus \n" +
                    "FROM\n" +
                    "his_sflb a,\n" +
                    "his_SFXM_DICT b\n" +
                    "WHERE\n" +
                    "a.his_YXmBm = b.Sf_XmBm",
                    "AND CONVERT(VARCHAR(100), his_Sfsj, 23) = #{beginTime} \n" +
                    "<if test='patientId != null'> AND a.his_PatID = #{patientId} </if>\n" +
                    "<if test='patientType != null'> AND a.his_BrBz = #{patientType} </if>\n" ,
            "</script>"
    })
    List<HisSflbVO> selectByTime(SearchVO searchVO);
}