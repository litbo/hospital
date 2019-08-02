package com.litbo.hospital.operational_data_monitoring.software_interface.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.DeparHisSss;
import org.apache.ibatis.annotations.Param;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.service
 * @Author: looli
 * @CreateTime: 2019-07-27 14:43
 * @Description: todo
 */
public interface DeparHisSssService {
    /**
     * 显示两个系统部门匹配信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo showDepartment(@Param("pageNum") Integer pageNum,
                               @Param("pageSize") Integer pageSize);

    /**
     *
     * @param pageNum
     * @param pageSize
     * @param name
     * @return
     */
    PageInfo showDepartmentByName(@Param("pageNum") Integer pageNum,
                                  @Param("pageSize") Integer pageSize,
                                  @Param("name") String name);


    /**
     * 保存关联记录
     * @param deparHisSss
     */
    void save(DeparHisSss deparHisSss);
}
