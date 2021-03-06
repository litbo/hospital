package com.litbo.hospital.operational_data_monitoring.software_interface.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.SearchEqVO;
import org.apache.ibatis.annotations.Param;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service
 * @Author: looli
 * @CreateTime: 2019-07-22 13:52
 * @Description: 查询设备表操作
 */
public interface EqInfoService {
    /**
     * 查询所有
     * @return
     */
    PageInfo selectAll(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 根据条件查询
     * @param searchVO
     * @return
     */
    PageInfo selectAllBy(Integer pageNum, Integer pageSize,
                         SearchEqVO searchVO);
}
