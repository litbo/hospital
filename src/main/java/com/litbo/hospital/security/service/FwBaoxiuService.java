package com.litbo.hospital.security.service;

import com.litbo.hospital.security.bean.FwBaoxiu;

/**
 * @author zjc
 * @create 2018-12-03 11:01
 * 报修单
 */
public interface FwBaoxiuService {
    /**
     * 添加保修单
     * @param fwBaoxiu
     */
    public void addBaoxiu(FwBaoxiu fwBaoxiu);

    /**
     * 根据报修单修改状态
     * @param id
     * @param baoxiuStatus
     */
    public void updateBaoxiuStatusById(String id,Integer baoxiuStatus);
}
