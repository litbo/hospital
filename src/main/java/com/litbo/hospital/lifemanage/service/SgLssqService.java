package com.litbo.hospital.lifemanage.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.SgLssq;

/**
 * 临时采购授权表Service接口
 */
public interface SgLssqService {
    /**
     * 添加临时授权信息
     *
     * @param sgLssq 临时授权信息
     */
    void insertSgLssq(SgLssq sgLssq);

    /**
     * 查询临时授权信息
     *
     * @param ksId     科室id
     * @param isKsg    授权是否过期
     * @param pageNum  当前页数
     * @param pageSize 每页的记录数
     * @return PageInfo<SgLssq>
     */
    PageInfo<SgLssq> selectSgLssq(String ksId, String isKsg, Integer pageNum, Integer pageSize);
}
