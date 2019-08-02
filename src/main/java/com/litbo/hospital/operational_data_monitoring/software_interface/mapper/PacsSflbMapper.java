package com.litbo.hospital.operational_data_monitoring.software_interface.mapper;

import com.litbo.hospital.operational_data_monitoring.software_interface.bean.PacsSflb;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.HISCycle;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.mapper
 * @Author: looli
 * @CreateTime: 2019-07-26 14:38
 * @Description: 查询pacs数据记录
 */
public interface PacsSflbMapper {
    @Select({
            "<script>",
            "SELECT\n" +
                    "ID as cSFID,\n" +
                    "c_PatID AS cPatID,\n" +
                    "c_Brxm AS cBrXm,\n" +
                    "c_Brnl AS cBrNl,\n" +
                    "c_Brxb as cBrXb,\n" +
                    "c_Brbz as cBrBz,\n" +
                    "c_MacID as cMacID,\n" +
                    "c_MacName as cMacName,\n" +
                    "c_Stime AS cStime,\n" +
                    "c_Parts as cParts,\n" +
                    "c_Result as cResult,\n" +
                    "c_ImgNo as cImgNo,\n" +
                    "c_Xmbm AS cXmBm,\n" +
                    "c_Xmmc AS cXmMc,\n" +
                    "c_YyDjsj as cYyDjsj,\n" +
                    "c_YUserNO as cYUserNO,\n" +
                    "c_Jhsj as cJhsj,\n" +
                    "c_CUserNo as cCUserNo,\n" +
                    "c_CDeptNo as cCDeptNo,\n" +
                    "c_CTime as cCTime,\n" +
                    "c_ZUserNo as cZUserNo,\n" +
                    "c_ZTime as cZTime,\n" +
                    "c_FUserNo as cFUserNo,\n" +
                    "c_FTime as cFTime,\n" +
                    "c_DTime as cDTime,\n" +
                    "c_ChkNo as cChkNo,\n" +
                    "c_PXmje as cPacsJe\n" +
                    "FROM\n" +
                    "app_fd_pacssflb\n" +
                    "WHERE\n" +
                    "c_FTime &gt;= #{beginTime}\n" +
                    "AND c_FTime &lt;= #{endTime}",
            "</script>"
    })
    List<PacsSflb> selectPacsByTime(HISCycle cycle);
}
