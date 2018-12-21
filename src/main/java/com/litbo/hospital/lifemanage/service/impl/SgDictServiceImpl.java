package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.bean.SgDict;
import com.litbo.hospital.lifemanage.dao.SgDictMapper;
import com.litbo.hospital.lifemanage.service.SgDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * SgDictServiceImpl 申购字典SgDictServiceImpl
 *
 * @author Administrator on 2018-12-11
 */
@Service
public class SgDictServiceImpl implements SgDictService {
    @Autowired
    private SgDictMapper sgDictMapper;

    /**
     * 添加申购字典信息
     *
     * @param sgDict 字典信息
     */
    @Override
    public void updateSgDict(SgDict sgDict) {
        sgDictMapper.updateSgDict(sgDict);
    }

    /**
     * 查询申购字典信息
     *
     * @return 字典信息
     */
    @Override
    public SgDict selectSgDict() {
        SgDict sgDict = sgDictMapper.selectSgDict();
        //如果没有查到数据 说明字典时第一次使用 给字典插入一个主键
        if (sgDict == null){
            sgDictMapper.insertSgDict(UUID.randomUUID().toString());
        }
        return sgDict;
    }
}
