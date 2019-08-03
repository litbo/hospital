package com.litbo.hospital.operational_data_monitoring.software_interface.service;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.service
 * @Author: looli
 * @CreateTime: 2019-07-27 16:57
 * @Description: todo
 */
public interface SBmService {
    /**
     * 获取部门信息
     * @param name
     * @return
     */
    PageInfo showBm(@Param("pageNum") Integer pageNum,
                    @Param("pageSize") Integer pageSize, String name);


}
