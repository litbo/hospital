package com.litbo.hospital.efficiency.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.efficiency.vo.IdlTimeVO;

/**
 * description:
 * @Author: jz
 * @Date: 2019/8/2 12:29
 */
public interface IdlTimeService {

    /**
     * 默认搜索上一月的工作日闲置时间
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo selectIdlTime(int pageNum, int pageSize);

    /**
     * 按条件搜索工作日闲置时间
     * @param pageNum
     * @param pageSize
     * @param idlTimeVO
     * @return
     */
    PageInfo selectIdlTimeByCon(int pageNum, int pageSize, IdlTimeVO idlTimeVO);

}
