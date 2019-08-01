package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.EqMacVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.SearchVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.EqMacTab;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service
 * @Author: looli
 * @CreateTime: 2019-07-22 12:50
 * @Description: 设备联网设置业务层操作接口
 */
public interface EqMacTabService {
    /**
     * 新建保存
     * @param eqMacTab
     */
    void save(EqMacTab eqMacTab);


    /**
     * 根据条件查看所有设备联网设置表数据
     * @param pageNum
     * @param pageSize
     * @param searchVO
     * @return
     */
    PageInfo showEqMacListBy(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,@Param("search") SearchVO searchVO);
    /**
     * 显示设备仪联网信息
     * @return
     */
    PageInfo showEqMacList(Integer pageNum,Integer pageSize);

    /**
     * 根据id删除数据
     * @param id
     */
    void delete(String id);

    /**
     * 根据id批量删除数据
     * @param ids
     */
    void deletes(List<String> ids);

    /**
     * 根据id修改数据
     * @param eqMacTab
     */
    void update(EqMacTab eqMacTab);
}
