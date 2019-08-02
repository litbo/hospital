package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.DeviceparameterVO;
import org.apache.ibatis.annotations.Param;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service
 * @Author: looli
 * @CreateTime: 2019-07-30 17:24
 * @Description: todo
 */
public interface DeviceparameterService {
    /**
     * 分页显示设备参数表信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo showEqNetWork(Integer pageNum,Integer pageSize);

    /**
     * 显示设备联网信息
     * @param ip
     * @return
     */
    DeviceparameterVO showOne(@Param("ip") String ip);
}
