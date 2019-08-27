package com.litbo.hospital.efficiency.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.calculate.Efficiency;
import com.litbo.hospital.common.utils.calculate.HandleData;
import com.litbo.hospital.efficiency.dao.IdlingDAO;
import com.litbo.hospital.efficiency.service.IdlingService;
import com.litbo.hospital.efficiency.vo.IdlingVO;
import com.litbo.hospital.efficiency.vo.SearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: 空转率Service实现层
 * @Author: jz
 * @Date: 2019/8/1 16:28
 */
@Service
public class IdlingServiceImpl implements IdlingService {

    @Autowired
    private IdlingDAO idlingDAO;

    public static List<IdlingVO> handData(List<IdlingVO> lists){

        // 计算设备的开机时间与空转率
        lists.forEach(item->{
            item.setOpenTimes(HandleData.calculateString(item.getWorkTimes(),item.getIdleTimes()));
            item.setRating(Efficiency.result(item.getIdleTimes(),item.getOpenTimes()));
        });

        // 根据设备的空转率排名
        lists.sort((vo1, vo2) -> vo2.getRating().compareTo(vo1.getRating()));

        // 设置设备的排名与空转率的格式
        for (int i = 0; i < lists.size(); i++) {
            lists.get(i).setRanking(i+1);
            lists.get(i).setRating(lists.get(i).getRanking()+"%");
        }

        return lists;
    }

    @Override
    public PageInfo selectIdling(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Integer integer = idlingDAO.deleteIdling();
        Integer integer1 = idlingDAO.updateIdling();
        List<IdlingVO> idlingVOS = idlingDAO.selectIdling();
        return new PageInfo(handData(idlingVOS));
    }

    @Override
    public PageInfo selectIdlingByCon(int pageNum, int pageSize, SearchVO searchVO) {
        PageHelper.startPage(pageNum, pageSize);
        Integer integer = idlingDAO.deleteIdling();
        Integer integer1 = idlingDAO.updateIdlingByCon(searchVO);
        List<IdlingVO> idlingVOS = idlingDAO.selectIdling();
        return new PageInfo(handData(idlingVOS));
    }
}
