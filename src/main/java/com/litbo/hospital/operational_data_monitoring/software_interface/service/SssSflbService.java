package com.litbo.hospital.operational_data_monitoring.software_interface.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.SearchVO;
import org.apache.ibatis.annotations.Param;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.service
 * @Author: looli
 * @CreateTime: 2019-07-27 14:00
 * @Description: todo
 */
public interface SssSflbService {
    /**
     * 显示手术室收费明细
     * @param pageNum
     * @param pageSize
     * @param searchVO
     * @return
     */
    PageInfo showSssSflbByTime(@Param("pageNum") Integer pageNum,
                               @Param("pageSize") Integer pageSize,
                               SearchVO searchVO);
}
