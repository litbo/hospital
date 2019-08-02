package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.EqOvertimeVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.SearchVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.EqOvertimeTab;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service
 * @Author: looli
 * @CreateTime: 2019-07-22 15:07
 * @Description: 设备加班操作接口
 */
public interface EqOvertimeTabService {
    /**保存信息*/
    void save(EqOvertimeTab eqOvertime);
    /**根据id删除信息*/
    void delete(String id);
    /**批量删除信息*/
    void deletes(List<String> ids);
    /**显示所有加班信息*/
    PageInfo showAll(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
    /**根据条件显示加班信息*/
    PageInfo showAlllBy(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("search") SearchVO searchVO);
    /**根据id显示信息*/
    EqOvertimeVO getById(String id);
    /**根据id修改数据*/
    void update(EqOvertimeVO eqOvertimeTab);
}
