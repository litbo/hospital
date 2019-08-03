package com.litbo.hospital.operational_data_monitoring.software_interface.dao;

import com.litbo.hospital.operational_data_monitoring.software_interface.bean.HisSflb;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.PacsSflb;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.PacsTab;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.SearchVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.dao
 * @Author: looli
 * @CreateTime: 2019-07-26 14:43
 * @Description: todo
 */
public interface PacsSflbDAO {
    /**
     * 批量保存
     * @param pacsSflbList
     */
    @Insert({"<script>",
           "insert into Pacs_sflb (C_SFID, C_PatID, C_BrXm, \n" +
                   "      C_BrNl, C_BrXb, C_BrBz, \n" +
                   "      C_MacID, C_MacName, C_Stime, \n" +
                   "      C_Parts, C_Result, C_ImgNo, \n" +
                   "      C_XmBm, C_XmMc, C_YyDjsj, \n" +
                   "      C_YUserNO, C_Jhsj, C_CUserNo, \n" +
                   "      C_CDeptNo, C_CTime, C_ZUserNo, \n" +
                   "      C_ZTime, C_FUserNo, C_FTime, \n" +
                   "      C_DTime, C_ChkNo, C_PacsJe\n" +
                   "      ) values",
            "<foreach item='pacs' collection='list' separator=',' > \n" +
                    "(#{pacs.cSFID}, #{pacs.cPatID}, #{pacs.cBrXm}, \n" +
                    "      #{pacs.cBrNl}, #{pacs.cBrXb}, #{pacs.cBrBz}, \n" +
                    "      #{pacs.cMacID}, #{pacs.cMacName}, cast(#{pacs.cStime} as datetime), \n" +
                    "      #{pacs.cParts}, #{pacs.cResult}, #{pacs.cImgNo}, \n" +
                    "      #{pacs.cXmBm}, #{pacs.cXmMc}, cast(#{pacs.cYyDjsj} as datetime), \n" +
                    "      #{pacs.cYUserNO},cast( #{pacs.cJhsj} as datetime), #{pacs.cCUserNo}, \n" +
                    "      #{pacs.cCDeptNo}, cast( #{pacs.cCTime} as datetime), #{pacs.cZUserNo}, \n" +
                    "      cast(#{pacs.cZTime} as datetime), #{pacs.cFUserNo}, cast(#{pacs.cFTime} as datetime), \n" +
                    "      cast(#{pacs.cDTime} as datetime), #{pacs.cChkNo}, #{pacs.cPacsJe}\n" +
                    "      )",
                    "</foreach>",
            "</script>"})
    void savePacsSflbs(List<PacsSflb> pacsSflbList);

    /**
     * 查询pacs 数据，在时间基础上
     * @param searchVO
     * @return
     */
    @Select({
            "<script>",
            "SELECT C_PatID as cPatID," +
                    "C_BrXm as cBrXm,C_BrBz as cBrBz," +
                    "C_MacName as cMacName,C_XmMc as cXmMc,C_PacsJe as cPacsJe FROM pacs_sflb ",
            "WHERE CONVERT(VARCHAR(100), C_FTime, 23) = #{beginTime} \n" +
            "<if test='patientId != null'> AND  C_PatID = #{patientId} </if>\n" +
            "<if test='patientType != null'> AND  C_BrBz = #{patientType} </if>\n" ,
            "<if test='pacsId != null'> AND  C_MacID = #{pacsId} </if>\n" ,
            "</script>"
    })
    List<PacsSflb> selectByTime(SearchVO searchVO);

//    /**
//     * 从pacs设备中获取pacs设备信息
//     */
//    @Select("select C_MacID as cMacId,C_MacName as cMacName  from Pacs_sflb")
//    List<PacsTab> selectPacsAll();
}
