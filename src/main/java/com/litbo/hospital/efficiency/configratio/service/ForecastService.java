package com.litbo.hospital.efficiency.configratio.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.efficiency.configratio.bean.ForecastBean;
import com.litbo.hospital.efficiency.configratio.vo.ForecastRatioVO;

/**
 * description: 预测符合率
 * @author: sz
 * @date: 2019/8/29 11:12
 */
public interface ForecastService {

    /**
     * 预测符合率
     * @param forecastBean 信息参数
     * @return 返回插入的条数
     */
    Integer addForecast(ForecastBean forecastBean);

    /**
     * 预测符合率
     * @param pageNum   页码
     * @param pageSize  大小
     * @return  预测符合率
     */
    PageInfo showForecast(int pageNum, int pageSize);

    /**
     * 根据id查询预测符合率
     * @param id 预测符合率id
     * @return 返回预测符合率
     */
    ForecastRatioVO showForecastById(Integer id);

    /**
     * 更改预测符合率
     * @param forecastRatioVO 预测符合率
     * @return 更改几条预测符合率
     */
    Integer updateForecast(ForecastRatioVO forecastRatioVO);

    /**
     * 批量删除预测符合率
     * @param ids 预测符合率id
     * @return 删除几条
     */
    Integer deleteForecast(Integer[] ids);


}
