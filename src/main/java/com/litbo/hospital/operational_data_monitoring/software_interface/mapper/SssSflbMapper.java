package com.litbo.hospital.operational_data_monitoring.software_interface.mapper;

import com.litbo.hospital.operational_data_monitoring.software_interface.bean.HisSflb;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.SssSflb;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.HISCycle;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.mapper
 * @Author: looli
 * @CreateTime: 2019-07-26 15:39
 * @Description: 查询手术室收费列表明细
 */
public interface SssSflbMapper {

    @Select({"<script>",
            "SELECT\n" +
                    "c_SfID AS sssSFID,\n" +
                    "c_PatID AS sssPatID,\n" +
                    "c_Sfsj AS sssSfsj,\n" +
                    "c_Brxm AS sssBrXm,\n" +
                    "c_Brxb AS sssBrXb,\n" +
                    "c_Brnl AS sssBrNl,\n" +
                    "c_Brbz AS sssBrBz,\n" +
                    "c_Xmbm AS sssYXmBm,\n" +
                    "c_Xmje AS sssXmJe,\n" +
                    "c_Xmsl AS sssXmSl,\n" +
                    "c_MDeptID AS sssMDeptId,\n" +
                    "c_State AS sssStatus,\n" +
                    "c_ChkNo AS sssChkNo,\n" +
                    "c_Jcbz AS sssJcbz,\n" +
                    "c_NDeptID AS sssNDeptID \n" +
                    "FROM\n" +
                    "app_fd_hissslb",
            "WHERE\n" +
                    "c_Sfsj &gt;= #{beginTime} \n" +
                    "AND c_Sfsj &lt;= #{endTime}",
            "</script>"})
    List<SssSflb> selectByTime(HISCycle cycle);
}
