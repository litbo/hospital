package com.litbo.hospital.lifemanage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.SgLssq;
import com.litbo.hospital.lifemanage.dao.SgLssqMapper;
import com.litbo.hospital.lifemanage.service.SgLssqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * 临时采购授权表Service实现类
 */
@Service
public class SgLssqServiceImpl implements SgLssqService {
    @Autowired
    private SgLssqMapper sgLssqMapper;

    /**
     * 添加临时授权信息
     *
     * @param sgLssq 临时授权信息
     */
    @Override
    public void insertSgLssq(SgLssq sgLssq) {
        sgLssq.setLssqId(UUID.randomUUID().toString());
        sgLssqMapper.insertSgLssq(sgLssq);
    }

    /**
     * 查询临时授权信息
     *
     * @param ksId     科室id
     * @param isKsg    授权是否过期
     * @param pageNum  当前页数
     * @param pageSize 每页的记录数
     * @return PageInfo<SgLssq>
     */
    @Override
    public PageInfo<SgLssq> selectSgLssq(String ksId, String isKsg, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(sgLssqMapper.selectSgLssq(ksId,isKsg));
    }
}
