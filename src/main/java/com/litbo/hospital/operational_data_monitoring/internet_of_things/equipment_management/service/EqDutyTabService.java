package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.EqDutyVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.SearchVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.EqDutyTab;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service
 * @Author: looli
 * @CreateTime: 2019-07-22 14:09
 * @Description: 设备值班操作业务层接口
 */
public interface EqDutyTabService {
    /**保存：新建值班记录*/
    void save(EqDutyTab eqDutyTab);
    /**删除：根据id删除*/
    void delete(String id);
    /**根据id删除*/
    void deletes(List<String> ids);
    /**查询所有设备值班情况*/
    PageInfo selectAll(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, SearchVO searchVO);

    /**
     * 查询一个设备的值班排班记录
     * @param id
     * @return
     */
    EqDutyVO showOne(String id);
    /**根据条件筛选设备值班信息*/
    PageInfo showEqDutyBy(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, SearchVO searchVO);
    /**根据id查询*/
    EqDutyVO getById(String id);
    /**根据id修改*/
    void update(EqDutyTab eqDutyTab);


    /**保存：新建值班记录*/
    void saveEqDuty(EqDutyVO eqDutyVO);
    /**根据id修改*/
    void updateEqDuty(EqDutyVO eqDutyVO);

    /**删除：根据id删除*/
    void deleteByEqMacId(String eqMacId);
    /**根据id删除*/
    void deleteByEqMacIds(String[] eqMacIds);
}
