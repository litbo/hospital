package com.litbo.hospital.lifemanage.service;

import com.litbo.hospital.lifemanage.bean.SgKxxfx;

/**
 * 可行性分析表Service接口
 */
public interface SgKxxfxService {
    /**
     * 添加或更新可行性分析表信息
     *
     * @param sgKxxfx 可行性分析信息
     */
    void insertOrUpdateSgKxxfx(SgKxxfx sgKxxfx);

    /**
     * 根据申购单主键查询可行性分析信息
     *
     * @param sgInfoId 申购单主键
     * @return List<SgKxxfx>
     */
    SgKxxfx selectSgKxxfxBySgInfoId(String sgInfoId);
}
