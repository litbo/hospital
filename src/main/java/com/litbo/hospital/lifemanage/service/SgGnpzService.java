package com.litbo.hospital.lifemanage.service;

import com.litbo.hospital.lifemanage.bean.SgGnpz;

import java.util.List;

/**
 * 功能配置表Service接口
 */
public interface SgGnpzService {

    /**
     * 添加功能配置
     *
     * @param sgGnpz 功能配置信息
     */
    void insertSgGnpz(SgGnpz sgGnpz);

    /**
     * 通过参考厂商设备id查询对应的功能配置
     *
     * @param sgCkcssbId 参考厂商设备id
     * @return List<SgGnpz>
     */
    List<SgGnpz> selectSgGnpzBySgCkcssbId(String sgCkcssbId);
}
