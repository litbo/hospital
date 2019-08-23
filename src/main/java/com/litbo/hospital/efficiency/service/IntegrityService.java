package com.litbo.hospital.efficiency.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.efficiency.vo.IntegrityVO;

/**
 *   设备完好率Service层
 *   @Author: jz
 *   @date : 2019/7/31 16:59
 */
public interface IntegrityService {

    /**
     * 默认搜索完好率
     * @param pageNum 页码
     * @param pageSize 大小
     * @return  返回值
     */
    PageInfo selectIntegrity(int pageNum, int pageSize);

    /**
     * 按条件搜索完好率
     * @param pageNum 页码
     * @param pageSize 大小
     * @param integrityVO 搜索的关键词
     * @return 返回值
     */
    PageInfo selectIntegrityByCon(int pageNum, int pageSize, IntegrityVO integrityVO);

}
