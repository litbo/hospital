package com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.vo.SearchVO;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.service
 * @Author: looli
 * @CreateTime: 2019-08-07 10:20
 * @Description: todo
 */
public interface InspectdetailbackService {
    /**
     * 显示所选时间段内的数据
     * 分页
     * 搜索
     * @param pageNum
     * @param pageSize
     * @param searchVO
     * @return 返回所选时间段的数据
     */
    PageInfo show(Integer pageNum, Integer pageSize, SearchVO searchVO);

    /**
     * 显示所选时间段原始记录
     * 分页
     * 搜索
     * @param pageNum
     * @param pageSize
     * @param searchVO
     * @return 返回所选时间段的数据
     */
    PageInfo show2(Integer pageNum, Integer pageSize, SearchVO searchVO);

    /**
     * 选择所选时间的单机设备运行记录
     * @param pageNum
     * @param pageSize
     * @param searchVO
     * @return
     */
    PageInfo show3(Integer pageNum, Integer pageSize, SearchVO searchVO);
    /**
     * 选择所选时间的单机设备运行记录 年
     * @param pageNum
     * @param pageSize
     * @param searchVO
     * @return
     */
    PageInfo show31(Integer pageNum, Integer pageSize, SearchVO searchVO);
    /**
     * 选择所选时间的单机设备运行记录 年
     * @param pageNum
     * @param pageSize
     * @param searchVO
     * @return
     */
    PageInfo show32(Integer pageNum, Integer pageSize, SearchVO searchVO);

    /**
     * 显示科室使用设备信息
     * @param pageNum
     * @param pageSize
     * @param searchVO
     * @return
     */
    PageInfo show4(Integer pageNum, Integer pageSize, SearchVO searchVO);
    PageInfo show41(Integer pageNum, Integer pageSize, SearchVO searchVO);
    PageInfo show42(Integer pageNum, Integer pageSize, SearchVO searchVO);


}
