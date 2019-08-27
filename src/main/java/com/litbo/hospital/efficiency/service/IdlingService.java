package com.litbo.hospital.efficiency.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.efficiency.vo.IdlingVO;
import com.litbo.hospital.efficiency.vo.SearchVO;

/**
 * description: 空转率Service层
 * @Author: jz
 * @Date: 2019/8/1 16:28
 */
public interface IdlingService {

    /**
     * 默认查询昨天设备的空转率
     * @param pageNum   页码
     * @param pageSize  大小
     * @return     设备的空转率
     */
    PageInfo selectIdling(int pageNum, int pageSize);

    /**
     * 按条件查询设备的空转率
     * @param pageNum   页码
     * @param pageSize  大小
     * @param searchVO  查询设备的空转率条件
     * @return  设备的空转率
     */
    PageInfo selectIdlingByCon(int pageNum, int pageSize, SearchVO searchVO);

}
