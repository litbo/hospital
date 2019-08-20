package com.litbo.hospital.operational_data_monitoring.internet_of_things.real_time_monitoring.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.real_time_monitoring.vo.ResultVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.real_time_monitoring.vo.SearchOV;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface RealTimeMonitoringService {
    /**
     * 根据条件显示设备运行状况
     * @return 返回符合条件的运行状态
     */
    PageInfo show1(Integer pageNum, Integer pageSize, SearchOV searchOV );

    List<ResultVO> show2();

    List<ResultVO> show3();
}
