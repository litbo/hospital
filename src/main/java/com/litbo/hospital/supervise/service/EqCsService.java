package com.litbo.hospital.supervise.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.vo.EqCsInsertReadyVO;
import com.litbo.hospital.supervise.vo.EqCsSelectVO;
import com.litbo.hospital.user.bean.EqCs;

public interface EqCsService {
    //获得所有厂商
    PageInfo listEqCs(int pageNum, int pageSize);

    //添加数据前准备数据
    EqCsInsertReadyVO readyResource();
    //添加厂商
    void insertEqCs(EqCs eqCs);
    // 模糊级联查询
    PageInfo listEqcsByX(int pageNum, int pageSize, EqCsSelectVO selectVo);
}
