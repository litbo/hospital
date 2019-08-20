package com.litbo.hospital.operational_data_monitoring.internet_of_things.real_time_monitoring.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.dao.RealTimeMonitoringDAO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.real_time_monitoring.service.RealTimeMonitoringService;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.real_time_monitoring.vo.ResultVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.real_time_monitoring.vo.SearchOV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RealTimeMonitoringServiceImpl implements RealTimeMonitoringService {

    @Autowired
    private RealTimeMonitoringDAO dao;
    /**
     * 根据条件显示设备运行装态
     * @param pageNum
     * @param pageSize
     * @param searchOV
     * @return
     */
    @Override
    public PageInfo show1(Integer pageNum, Integer pageSize, SearchOV searchOV) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(dao.select1(searchOV));
    }

    @Override
    public List<ResultVO> show2() {
        List<ResultVO> resultVOS =  new ArrayList<>();
        ResultVO resultVO1 = dao.select21();
        resultVO1.setGoodCondition("在用");
        ResultVO resultVO2 = dao.select22();
        resultVO2.setGoodCondition("故障");
        ResultVO resultVO3 = dao.select23();
        resultVO3.setGoodCondition("维修");
        resultVOS.add(0,resultVO1);
        resultVOS.add(1,resultVO2);
        resultVOS.add(2,resultVO3);
        return resultVOS;
    }

    @Override
    public List<ResultVO> show3() {
        List<ResultVO> resultVOS =  new ArrayList<>();
        ResultVO resultVO1 = dao.select31();
        resultVO1.setGoodCondition("工作");
        ResultVO resultVO2 = dao.select32();
        resultVO2.setGoodCondition("待机");
        ResultVO resultVO3 = dao.select33();
        resultVO3.setGoodCondition("关机");
        resultVOS.add(0,resultVO1);
        resultVOS.add(1,resultVO2);
        resultVOS.add(2,resultVO3);
        return resultVOS;
    }
}
