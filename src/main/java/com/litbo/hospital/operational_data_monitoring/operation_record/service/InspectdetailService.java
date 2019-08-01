package com.litbo.hospital.operational_data_monitoring.operation_record.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.operation_record.vo.OperationRecord;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.operation_record.service
 * @Author: looli
 * @CreateTime: 2019-07-23 10:42
 * @Description: 运行记录显示接口
 */
public interface InspectdetailService {
    //查询当天情况
    /**运行记录*/
    PageInfo showRunningRecord(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
    /**原始记录*/
    PageInfo showOriginalRecord(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
    /**单机设备运行记录*/
    PageInfo showEqRunningRecord(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
    /**使用科室设备运行记录*/
    PageInfo showBmRunningRecord(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
    //历史记录

}
