package com.litbo.hospital.lifemanage.service;

import com.litbo.hospital.lifemanage.bean.vo.SgDxyxzbkcVO;

/**
 * 大型医学装备考察报告表Service接口
 */
public interface SgDxyxzbkcService {
    /**
     * 添加或更新大型医学装备考察报告信息
     *
     * @param sgDxyxzbkcVO 大型医学装备考察报告信息
     */
    void insertOrUpdateSgDxyxzbkc(SgDxyxzbkcVO sgDxyxzbkcVO);

    /**
     * 根据申购单id查询大型医学装备考察报告信息
     *
     * @param sgInfoId 根据申购单id
     * @return SgDxyxzbkcVO
     */
    SgDxyxzbkcVO selectSgDxyxzbkc(String sgInfoId);
}
