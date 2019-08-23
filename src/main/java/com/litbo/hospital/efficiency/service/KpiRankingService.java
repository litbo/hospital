package com.litbo.hospital.efficiency.service;

import com.github.pagehelper.PageInfo;

/**
 * description: kpi数据排名计算Service层
 * @author: sz
 * @date: 2019/8/4 14:25
 */
public interface KpiRankingService {


    /**
     * 获取开机率的排名变化数据
     * @param pageNum  页码
     * @param pageSize 大小
     * @return 返回开机率的排名变化数据
     */
    PageInfo selectChangeOpen(int pageNum, int pageSize);

    /**
     * 获取机时利用率的排名变化数据
     * @param pageNum  页码
     * @param pageSize 大小
     * @return 返回机时利用率的排名变化数据
     */
    PageInfo selectChangeUsing(int pageNum, int pageSize);

    /**
     * 获取空转率的排名变化数据
     * @param pageNum  页码
     * @param pageSize 大小
     * @return 返回空转率的排名变化数据
     */
    PageInfo selectChangeIdling(int pageNum, int pageSize);


    /**
     * 获取工作日平均闲置时间的排名变化数据
     * @param pageNum  页码
     * @param pageSize 大小
     * @return 返回工作日平均闲置时间的排名变化数据
     */
    PageInfo selectChangeIdlTimes(int pageNum, int pageSize);


    /**
     * 获取完好率的排名变化数据
     * @param pageNum  页码
     * @param pageSize 大小
     * @return 返回完好率的排名变化数据
     */
    PageInfo selectChangeIntegrity(int pageNum, int pageSize);


}
