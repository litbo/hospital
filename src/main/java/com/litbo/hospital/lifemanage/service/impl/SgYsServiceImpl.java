package com.litbo.hospital.lifemanage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.SgYs;
import com.litbo.hospital.lifemanage.bean.vo.SgYsListVO;
import com.litbo.hospital.lifemanage.dao.SgYsMapper;
import com.litbo.hospital.lifemanage.service.SgYsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * 商务/临床/技术验收表Service实现类
 */
@Service
public class SgYsServiceImpl implements SgYsService {
    @Autowired
    private SgYsMapper sgYsMapper;

    /**
     * 需验收设备列表
     *
     * @param pageNum  当前页数
     * @param pageSize 每页显示的记录数
     * @return PageInfo<SgYsListVO>
     */
    @Override
    public PageInfo<SgYsListVO> sgYsList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(sgYsMapper.sgYsList());
    }

    /**
     * 添加验收信息
     *
     * @param sgYs 验收信息
     */
    @Override
    public void insertSgYs(SgYs sgYs) {
        sgYs.setYsId(UUID.randomUUID().toString());
        //添加验收信息
        sgYsMapper.insertSgYs(sgYs);
        //把申购信息添加到设备表中

    }

    /**
     * 添加信息到设备表
     * @param sgInfo 申购单id
     */
    private void insertEqInfo(String sgInfo){
        // 查出来需要的字段

        //把字段添加进设备表中

        // TODO
    }
}
