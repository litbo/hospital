package com.litbo.hospital.operational_data_monitoring.software_interface.vo;

import com.litbo.hospital.operational_data_monitoring.software_interface.bean.EqInfo;
import lombok.Data;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.vo
 * @Author: looli
 * @CreateTime: 2019-08-02 09:56
 * @Description: todo
 */
@Data
public class EqXmVO {
    private List<EqInfo> eqList;
    private List<XmVO> xmList;
}
