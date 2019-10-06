package com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.service;

import com.github.pagehelper.PageInfo;

import com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.vo.SearchVO;
/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.service
 * @Author: looli
 * @CreateTime: 2019-07-23 10:42
 * @Description: 运行记录显示接口
 */
public interface InspectdetailService {

    /**
     * 显示当天数据
     * 分页
     * 查询
     * @param pageNum
     * @param pageSize
     * @param searchVO
     * @return 返回当天数据
     */
    PageInfo showNow(Integer pageNum,Integer pageSize,SearchVO searchVO);

    /**
     * 显示当天的数据
     * 分页
     * 查询
     * @param pageNum
     * @param pageSize
     * @param searchVO
     * @return 返回当天数据
     */
    PageInfo showNow2(Integer pageNum,Integer pageSize,SearchVO searchVO);

    /**
     * 显示当天设备单机运行记录
     * @param pageNum
     * @param pageSize
     * @param searchVO
     * @return
     */
    PageInfo showNow3(Integer pageNum,Integer pageSize,SearchVO searchVO);

    /**
     * 显示科室使用设备信息
     * @param pageNum
     * @param pageSize
     * @param searchVO
     * @return
     */
    PageInfo showNow4(Integer pageNum,Integer pageSize,SearchVO searchVO);
}
