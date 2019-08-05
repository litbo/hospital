package com.litbo.hospital.operational_data_monitoring.software_interface.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.EqYzTab;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.EqXm;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.service
 * @Author: looli
 * @CreateTime: 2019-07-27 15:38
 * @Description: todo
 */
public interface EqYzTabService {
    /**
     * 保存设备与医嘱关联记录
     * @param eqYzTabList
     */
    void save(List<EqYzTab> eqYzTabList);

    /**
     * 删除医嘱与设备关联信息
     */
    void delete();

    /**
     * 删除医嘱与设备关联信息
     */
    void delete(List<EqYzTab> eqYzTabList);

    PageInfo show(Integer pageNum, Integer pageSize, EqXm eqXm);

    void update(EqXm eqXm);

    /**
     * 2.根据id删除关联信息
     * @param id
     */
    void deleteOne(String id);

    void deletes(String[] ids);

}
