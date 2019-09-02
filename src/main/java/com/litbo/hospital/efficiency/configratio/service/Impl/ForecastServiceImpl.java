package com.litbo.hospital.efficiency.configratio.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.calculate.Efficiency;
import com.litbo.hospital.efficiency.configratio.bean.ForecastBean;
import com.litbo.hospital.efficiency.configratio.dao.ForecastDAO;
import com.litbo.hospital.efficiency.configratio.service.ForecastService;
import com.litbo.hospital.efficiency.configratio.vo.ForecastRatioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description: 预测符合率
 * @author: sz
 * @date: 2019/8/29 11:24
 */
@Service
public class ForecastServiceImpl implements ForecastService {

    @Autowired
    private ForecastDAO forecastDAO;

    /**
     * 预测符合率
     * @param forecastBean 信息参数
     * @return 返回插入的条数
     */
    @Override
    public Integer addForecast(ForecastBean forecastBean) {
        if (forecastDAO.selectByEqCode(forecastBean.getEqSbbh())==null){
            forecastBean.setRatio(Double.valueOf(Efficiency.result(forecastBean.getActualNum(),forecastBean.getForecastNum())));
            return forecastDAO.addForecast(forecastBean);
        }else {
            return 0;
        }
    }

    /**
     * 预测符合率
     * @param pageNum  页码
     * @param pageSize 大小
     * @return 预测符合率
     */
    @Override
    public PageInfo showForecast(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo(forecastDAO.showForecast());
    }

    /**
     * 根据id查询预测符合率
     * @param id 预测符合率id
     * @return 返回预测符合率
     */
    @Override
    public ForecastRatioVO showForecastById(Integer id) {
        return forecastDAO.showForecastById(id);
    }

    /**
     * 更改预测符合率
     * @param forecastRatioVO 预测符合率
     * @return 更改几条预测符合率
     */
    @Override
    public Integer updateForecast(ForecastRatioVO forecastRatioVO) {
        if (forecastDAO.selectByEqCode(forecastRatioVO.getEqSbbh())==null||
                forecastDAO.selectByEqCode(forecastRatioVO.getEqSbbh()).equals(forecastRatioVO.getId())){
            forecastRatioVO.setRatio(Efficiency.result(forecastRatioVO.getForecastNum(),forecastRatioVO.getActualNum()));
            return forecastDAO.updateForecast(forecastRatioVO);
        }else {
            return 0;
        }
    }

    /**
     * 批量删除预测符合率
     * @param ids 预测符合率id
     * @return 删除几条
     */
    @Override
    public Integer deleteForecast(Integer[] ids) {
        return forecastDAO.deleteForecast(ids);
    }
}
