package com.litbo.hospital.lifemanage.service;

import com.litbo.hospital.lifemanage.bean.SgCkcssb;

import java.util.List;

/**
 * 参考厂商设备表Service接口
 */
public interface SgCkcssbService {
    List<SgCkcssb> selectSgCkcssbs();
    int insertSgCkcssb(SgCkcssb sgCkcssb);
}
