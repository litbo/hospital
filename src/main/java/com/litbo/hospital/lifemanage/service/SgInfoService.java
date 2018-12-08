package com.litbo.hospital.lifemanage.service;

import com.litbo.hospital.lifemanage.bean.SgInfo;

/**
 * 申购单表Service接口
 */
public interface SgInfoService {
    /**
     * 根据申购单ID查询申购单信息
     * @param sgInfoId 申购单id
     * @return 申购单信息
     */
    SgInfo selectSgInfoById(String sgInfoId);

    /**
     * 添加申购单表
     * @param sgInfo 申购单信息
     */
    void insertSgInfo(SgInfo sgInfo);
}
