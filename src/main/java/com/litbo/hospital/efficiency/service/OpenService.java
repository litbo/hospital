package com.litbo.hospital.efficiency.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.efficiency.vo.OpenVO;

/**
 * description:设备开机率的Service层
 * @Author: jz
 * @Date: 2019/8/1 10:09
 */
public interface OpenService {

    /**
     * 默认搜索上个月设备的开机率
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo selectOpen(int pageNum, int pageSize);

    /**
     * 按条件搜索设备的开机率
     * @param pageNum
     * @param pageSize
     * @param openVO
     * @return
     */
    PageInfo selectOpenByCon(int pageNum, int pageSize, OpenVO openVO);

}
