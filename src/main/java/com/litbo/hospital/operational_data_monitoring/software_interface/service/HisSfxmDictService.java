package com.litbo.hospital.operational_data_monitoring.software_interface.service;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.service
 * @Author: looli
 * @CreateTime: 2019-07-27 15:21
 * @Description: todo
 */
public interface HisSfxmDictService {
    /**
     * 查询医嘱信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo showXm(@Param("pageNum") Integer pageNum,
                    @Param("pageSize") Integer pageSize);

    /**
     * 根据医嘱名模糊查询医嘱
     * @param pageNum
     * @param pageSize
     * @param name
     * @return
     */
    PageInfo showXmByName(@Param("name") String name,
                          @Param("pageNum") Integer pageNum,
                          @Param("pageSize") Integer pageSize);
}
