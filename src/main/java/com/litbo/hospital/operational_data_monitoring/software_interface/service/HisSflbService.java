package com.litbo.hospital.operational_data_monitoring.software_interface.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.HISCycle;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.HisSflbVO;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.SearchVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.service
 * @Author: looli
 * @CreateTime: 2019-07-27 11:14
 * @Description: todo
 */
public interface HisSflbService {

    /**
     * 根据条件显示一天的his数据
     * @param searchVO
     * @return
     */
    PageInfo showHisSflbByTime(@Param("pageNum") Integer pageNum,
                               @Param("pageSize") Integer pageSize,
                               SearchVO searchVO);
}
