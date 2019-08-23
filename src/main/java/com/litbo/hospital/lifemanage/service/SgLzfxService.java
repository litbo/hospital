package com.litbo.hospital.lifemanage.service;

import com.litbo.hospital.lifemanage.bean.vo.SgLzfxVO;

/**
 * 论证分析表Service接口
 */
public interface SgLzfxService {
    /**
     * 添加论证分析信息
     *
     * @param sgLzfxVOs 论证分析信息
     */

    void insertSgLzfx(SgLzfxVO sgLzfxVOs);

    /**
     * 查看论证分析详情
     *
     * @param sgInfoId 申购单id
     * @return SgLzfxVO
     */
    SgLzfxVO selectSgLzfx(String sgInfoId);
}
