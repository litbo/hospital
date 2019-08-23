package com.litbo.hospital.efficiency.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.calculate.Efficiency;
import com.litbo.hospital.efficiency.dao.IntegrityDAO;
import com.litbo.hospital.efficiency.service.IntegrityService;
import com.litbo.hospital.efficiency.vo.IntegrityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *   设备完好率Service的实现层
 *   @Author: jz
 *   @Date: 2019/7/31 16:59
 */
@Service
public class IntegrityServiceImpl implements IntegrityService {

    @Autowired
    private IntegrityDAO integrityDAO;

    public static List<IntegrityVO> handleIntegrity(List<IntegrityVO> integrityVOS){

        //计算并设置设备的完好率
        integrityVOS.forEach(item->{
            item.setRating(Efficiency.result(String.valueOf(item.getUsingNums()),String.valueOf(item.getEqNums())));
        });
        //设备完好率排序
        integrityVOS.sort((vo1, vo2) -> vo1.getRating().compareTo(vo2.getRating()));
        //设置设备完好率排名
        for (int i = 0;i<integrityVOS.size();i++) {
            integrityVOS.get(i).setRanking(i + 1);
            integrityVOS.get(i).setRating(integrityVOS.get(i).getRating()+"%");
        }

        return integrityVOS;
    }


    @Override
    public PageInfo selectIntegrity(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<IntegrityVO> integrityVOS = integrityDAO.selectIntegrity();
        return new PageInfo(handleIntegrity(integrityVOS));
    }

    @Override
    public PageInfo selectIntegrityByCon(int pageNum, int pageSize, IntegrityVO integrityVO) {
        PageHelper.startPage(pageNum, pageSize);
        List<IntegrityVO> integrityVOS = integrityDAO.selectIntegrityByCon(integrityVO);
        return new PageInfo(handleIntegrity(integrityVOS));
    }
}
