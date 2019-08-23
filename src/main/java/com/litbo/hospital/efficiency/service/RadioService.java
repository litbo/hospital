package com.litbo.hospital.efficiency.service;

import com.litbo.hospital.efficiency.bean.KpiBean;

import java.util.List;

/**
 * description: kpi比率的Service层
 * @author: sz
 * @date: 2019/8/3 11:39
 */
public interface RadioService {

    /**
     * 查询设备的开机率对应的KPI
     * @return 返回设备的开机率
     */
    List<KpiBean> selectOpen();

    /**
     * 查询设备机时利用率的KPI
     * @return 返回设备机时利用率
     */
    List<KpiBean> selectUsing();

    /**
     * 查询设备空转率对应的KPI
     * @return 返回设备空转率
     */
    List<KpiBean> selectIdling();

    /**
     * 查询设备闲置时间对应的KPI
     * @return 返回备闲置时间
     */
    List<KpiBean> selectIdlTime();

    /**
     * 查询设备完好率对应的KPI
     * @return  返回设备完好率
     */
    List<KpiBean> selectIntegrity();

    /**
     * 将查询的KPI数据插入到kpi数据表中
     * @param list kpi数据
     * @return 返回
     */
    int insertKpi(List<KpiBean> list);
}
