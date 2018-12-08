package com.litbo.hospital.lifemanage.service;

import com.litbo.hospital.lifemanage.bean.SgCkcssb;

import java.util.List;

/**
 * 参考厂商设备表Service接口
 */
public interface SgCkcssbService {
    /**
     * 根据申购单id查询所有厂商设备表信息
     *
     * @return List<SgCkcssb> 查询的信息
     */
    List<SgCkcssb> selectSgCkcssbBySgInfoId(String sgInfoId);

    /**
     * 添加厂商设备表信息
     *
     * @param sgCkcssb 厂商设备表实体类
     * @return boolean 是否添加信息成功
     */
    boolean insertSgCkcssb(SgCkcssb sgCkcssb);
}
