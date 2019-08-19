package com.litbo.hospital.operational_data_monitoring.software_interface.service;

import com.litbo.hospital.operational_data_monitoring.software_interface.bean.HisDeptDict;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.service
 * @Author: looli
 * @CreateTime: 2019-07-31 14:35
 * @Description: todo
 */
public interface HisDeptDictService {
    /**
     * 删除相关数据
     */
    void delete();

    /**
     * 进行两个系统数据的自动匹配
     */
    void match();
}
