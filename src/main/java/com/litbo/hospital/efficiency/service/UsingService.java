package com.litbo.hospital.efficiency.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.efficiency.vo.SearchVO;
import com.litbo.hospital.efficiency.vo.UsingVO;

/**
 * description:机时利用率Service层
 * @Author: jz
 * @Date: 2019/8/1 17:13
 */
public interface UsingService {

    /**
     * 默认搜索机时利用率
     * @param pageNum   页码
     * @param pageSize  大小
     * @return  返回默认搜索机时利用率
     */
    PageInfo selectUsing(int pageNum, int pageSize);

    /**
     * 按条件搜索机时利用率
     * @param pageNum   页码
     * @param pageSize  大小
     * @param searchVO  搜索机时利用率条件
     * @return  返回按条件搜索机时利用率
     */
    PageInfo selectUsingByCon(int pageNum, int pageSize, SearchVO searchVO);

}
