package com.litbo.hospital.operational_data_monitoring.software_interface.mapper;

import com.litbo.hospital.operational_data_monitoring.software_interface.bean.HisSflb;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.HISCycle;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.mapper
 * @Author: looli
 * @CreateTime: 2019-07-26 09:23
 * @Description: todo
 */
public interface HisSflbMapper {
    /**
     * 根据时间
     * 查询his收费明细
     */
    @Select({
            "<script>",
            "SELECT\n" +
                   "c_SfID as hisSFID,\n" +
                    "his_AssetNo as hisAssetNO,\n" +
                    "c_PatID as hisPatID,\n" +
                    "c_Sfsj as hisSfsj,\n" +
                    "c_Brxm as hisBrXm,\n" +
                    "c_Brxb as hisBrXb,\n" +
                    "c_Brnl as hisBrNl,\n" +
                    "  c_Brbz as hisBrBz,\n" +
                    "c_Xmbm AS hisYXmBm,\n" +
                    "c_Xmje as hisXmJe,\n" +
                    "c_Xmsl as hisXmSl,\n" +
                    "c_MDeptID as hisMDeptID,\n" +
                    "MTime as hisMTime,\n" +
                    "c_State as hisstatus",
                    "FROM\n" +
                    "app_fd_hissflb \n" +
                    "WHERE\n" +
                    "c_Sfsj  &gt;= #{beginTime} \n" +
                    "AND c_Sfsj &lt;= #{endTime}",
            "</script>"
    })
    List<HisSflb> selectByTime(HISCycle cycle);
}
