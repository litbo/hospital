package com.litbo.hospital.efficiency.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.efficiency.vo.IntegrityVO;
import com.litbo.hospital.efficiency.vo.SearchVO;

/**
 *   设备完好率Service层
 *   @Author: jz
 *   @date : 2019/7/31 16:59
 */
public interface IntegrityService {

    /**
     * 默认查询完好率
     * @param pageNum 页码
     * @param pageSize 大小
     * @return  返回值
     */
    PageInfo selectIntegrity(int pageNum, int pageSize);

    /**
     * 按条件查询完好率
     * @param pageNum 页码
     * @param pageSize 大小
     * @param searchVO 查询的关键词
     * @return 返回值
     */
    PageInfo selectIntegrityByCon(int pageNum, int pageSize, SearchVO searchVO);

}
