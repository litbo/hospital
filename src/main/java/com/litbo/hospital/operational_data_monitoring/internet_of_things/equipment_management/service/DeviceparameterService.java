package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.EqMacVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.SearchVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.Deviceparameter;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.DeviceparameterVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service
 * @Author: looli
 * @CreateTime: 2019-07-30 17:24
 * @Description: todo
 */
public interface DeviceparameterService {
    /**
     * 分页显示设备参数表信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo showEqNetWork(Integer pageNum, Integer pageSize, SearchVO searchVO);

    /**
     * 显示设备联网信息
     * @param eqMacVO
     * @return 返回设备联网相关信息
     */
    DeviceparameterVO showOne(EqMacVO eqMacVO);



    /**
     * 删除设备联网信息
     * @param searchVO
     */
    void deleteByMacId(SearchVO searchVO);

    /**
     * 删除
     * @param macIds
     */
    void deletes(String[] macIds);









    /**
     * 保存设备关联信息
     * @param deviceparameterVO
     */
    void save(DeviceparameterVO deviceparameterVO);

    /**
     * 更新设备关联信息
     * @param deviceparameterVO
     */
    void update(DeviceparameterVO deviceparameterVO);

    PageInfo showNoDutyEq(Integer pageNum, Integer pageSize, SearchVO searchVO);

    int  updateOneLwxByLwyBh(Deviceparameter deviceparameter);

}
