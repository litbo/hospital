package com.litbo.hospital.efficiency.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.efficiency.vo.IdlingVO;

/**
 * description: 空转率Service层
 * @Author: jz
 * @Date: 2019/8/1 16:28
 */
public interface IdlingService {

    /**
     * 默认查询昨天设备的空转率
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo selectIdling(int pageNum, int pageSize);

    /**
     * 按条件查询设备的空转率
     * @param pageNum
     * @param pageSize
     * @param idlingVO
     * @return
     */
    PageInfo selectIdlingByCon(int pageNum, int pageSize, IdlingVO idlingVO);

}
