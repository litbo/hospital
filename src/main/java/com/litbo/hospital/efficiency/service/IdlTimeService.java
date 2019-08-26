package com.litbo.hospital.efficiency.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.efficiency.vo.IdlTimeVO;
import com.litbo.hospital.efficiency.vo.SearchVO;

/**
 * description:
 * @Author: jz
 * @Date: 2019/8/2 12:29
 */
public interface IdlTimeService {

    /**
     * 默认搜索上一月的工作日闲置时间
     * @param pageNum   页码
     * @param pageSize  大小
     * @return  工作日闲置时间
     */
    PageInfo selectIdlTime(int pageNum, int pageSize);

    /**
     * 按条件搜索工作日闲置时间
     * @param pageNum   页码
     * @param pageSize  大小
     * @param searchVO 搜索工作日闲置时间条件
     * @return  工作日闲置时间
     */
    PageInfo selectIdlTimeByCon(int pageNum, int pageSize, SearchVO searchVO);

}
