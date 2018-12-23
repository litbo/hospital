package com.litbo.hospital.lifemanage.service;

import com.litbo.hospital.lifemanage.bean.SgDict;

/**
 * SgDictService 申购字典Service
 *
 * @author Administrator on 2018-12-11
 */
public interface SgDictService {
    /**
     * 添加申购字典信息
     *
     * @param sgDict 字典信息
     */
    void updateSgDict(SgDict sgDict);

    /**
     * 查询申购字典信息
     *
     * @return 字典信息
     */
    SgDict selectSgDict();
}
