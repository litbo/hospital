package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.ApprovedWorkingHoursVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.SearchVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.ApprovedWorkingHours;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service
 * @Author: looli
 * @CreateTime: 2019-07-22 12:49
 * @Description: 核定工时设置业务层操作
 */
public interface ApprovedWorkingHoursService {
    /**新建 保存数据*/
    void save(ApprovedWorkingHours approvedWorkingHours);
    /**根据id删除*/
    void delete(String id);
    /**批量删除*/
    void deletes(List<String> ids);
    /**显示所有核定工时设置信息*/
    PageInfo selectAll(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
    /**根据条件筛选核定工时设置信息*/
    PageInfo showEqApproBy(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, SearchVO searchVO);
    /**根据id查找*/
    ApprovedWorkingHoursVO getById(String id);
    /**根据id修改*/
    void update(ApprovedWorkingHours approvedWorkingHours);
}
