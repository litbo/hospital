package com.litbo.hospital.efficiency.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.calculate.Efficiency;
import com.litbo.hospital.efficiency.dao.IdlTimeDAO;
import com.litbo.hospital.efficiency.service.IdlTimeService;
import com.litbo.hospital.efficiency.vo.IdlTimeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: 工作日平均闲置时间
 * @Author: jz
 * @Date: 2019/8/2 12:29
 */

@Service
public class IdlTimeServiceImpl implements IdlTimeService {

    @Autowired
    private IdlTimeDAO idlTimeDAO;

    public static List<IdlTimeVO> handData(List<IdlTimeVO> lists){


        // 计算平均闲置时间
        lists.forEach(item->{
            item.setAvgTimes(Efficiency.results(item.getIdleTimes(),item.getWorkDays()));
        });

        lists.sort((vo1, vo2) -> vo2.getAvgTimes().compareTo(vo1.getAvgTimes()));

        for (int i = 0; i < lists.size(); i++) {
            lists.get(i).setRanking(i+1);
        }

        return lists;
    }


    @Override
    public PageInfo selectIdlTime(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<IdlTimeVO> idlTimeVOS = idlTimeDAO.selectIdlTime();
        return new PageInfo(handData(idlTimeVOS));
    }

    @Override
    public PageInfo selectIdlTimeByCon(int pageNum, int pageSize, IdlTimeVO idlTimeVO) {
        PageHelper.startPage(pageNum, pageSize);
        List<IdlTimeVO> idlTimeVOS = idlTimeDAO.selectIdlTimeByCon(idlTimeVO);
        return new PageInfo(handData(idlTimeVOS));
    }
}
