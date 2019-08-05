package com.litbo.hospital.operational_data_monitoring.software_interface.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.EqPacs;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.PacsTab;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.EqPacsVO;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.service
 * @Author: looli
 * @CreateTime: 2019-08-01 12:08
 * @Description: todo
 */
public interface PacsService {
    /**
     * 删除pacs信息
     */
    void delete();

    /**
     * 保存
     * @param pacsTabList
     */
    void saves(List<PacsTab> pacsTabList);

    /**
     * 保存设备和pacs关联信息
     */
    void save(EqPacs eqPacs);


    PageInfo showEqPacs(Integer pageNum, Integer pageSize, String pacsId);

    /**
     * 查看设备是否已经关联
     * @param eqid
     * @return
     */
    int isHas(String eqid);

    /**
     * 删除已存在的关联
     */
    void deleteOne(String pacsId);

    /**
     * 删除已存在的关联
     */
    void deleteOne2(String eqId);

}
