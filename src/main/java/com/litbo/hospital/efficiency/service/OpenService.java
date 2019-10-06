package com.litbo.hospital.efficiency.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.efficiency.vo.OpenVO;
import com.litbo.hospital.efficiency.vo.SearchVO;

/**
 * description:设备开机率的Service层
 * @Author: jz
 * @Date: 2019/8/1 10:09
 */
public interface OpenService {

    /**
     * 默认查询上个月设备的开机率
     * @param pageNum   页码
     * @param pageSize  大小
     * @return  设备的开机率
     */
    PageInfo selectOpen(int pageNum, int pageSize);

    /**
     * 按条件查询设备的开机率
     * @param pageNum   页码
     * @param pageSize  大小
     * @param searchVO  设备的开机率
     * @return  设备的开机率
     */
    PageInfo selectOpenByCon(int pageNum, int pageSize, SearchVO searchVO);

}
