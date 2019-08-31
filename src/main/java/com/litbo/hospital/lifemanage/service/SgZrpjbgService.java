package com.litbo.hospital.lifemanage.service;

import com.litbo.hospital.lifemanage.bean.SgZrpjbg;

/**
 * 准入评价报告表Service接口
 */
public interface SgZrpjbgService {

    /**
     * 添加准入评价报告信息
     *
     * @param sgZrpjbg 准入评价报告
     */
    void insertOrUpdateSgZrpjbg(SgZrpjbg sgZrpjbg);

    /**
     * 根据申购单id查询准入评价报告信息
     *
     * @param sgInfoId 申购单id
     * @return 评价报告信息
     */
    SgZrpjbg selectSgZrpjbgBySgInfoId(String sgInfoId);
}
