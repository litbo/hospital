package com.litbo.hospital.operational_data_monitoring.software_interface.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.EqInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.service
 * @Author: looli
 * @CreateTime: 2019-07-27 17:24
 * @Description: todo
 */
public interface EqInfoService2 {

    /**
     *查询设备信息
     * @param pageNum
     * @param pageSize
     * @param name
     * @return
     */
    PageInfo showEqInfo(@Param("pageNum") Integer pageNum,
                        @Param("pageSize") Integer pageSize,
                        @Param("name") String name);
}
