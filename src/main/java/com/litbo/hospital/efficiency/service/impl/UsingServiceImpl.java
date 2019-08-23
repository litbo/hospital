package com.litbo.hospital.efficiency.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.calculate.Efficiency;
import com.litbo.hospital.efficiency.dao.UsingDAO;
import com.litbo.hospital.efficiency.service.UsingService;
import com.litbo.hospital.efficiency.vo.UsingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description:机时利用率Service层实现
 * @Author: jz
 * @Date: 2019/8/1 17:13
 */
@Service
public class UsingServiceImpl implements UsingService {

    @Autowired
    private UsingDAO usingDAO;

    public static List<UsingVO> handleData(List<UsingVO> lists){

        lists.forEach(item->{
            item.setWorkTimes(item.getWorkTimes()*3600);
            item.setRating(Efficiency.result(String.valueOf(item.getRealTimes()),String.valueOf(item.getWorkTimes())));
        });

        // 按照设备的开机率给设备排序
        lists.sort((vo1, vo2) -> vo1.getRating().compareTo(vo2.getRating()));

        // 设置数据的格式
        for (int i=0; i<lists.size(); i++){
            lists.get(i).setRanking(i+1);
            lists.get(i).setRating(lists.get(i).getRating()+"%");
        }

        return lists;
    }

    @Override
    public PageInfo selectUsing(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UsingVO> usingVOS = usingDAO.selectUsing();
        return new PageInfo(handleData(usingVOS));
    }

    @Override
    public PageInfo selectUsingByCon(int pageNum, int pageSize, UsingVO usingVO) {
        PageHelper.startPage(pageNum, pageSize);
        List<UsingVO> usingVOS = usingDAO.selectUsingByCon(usingVO);
        return new PageInfo(handleData(usingVOS));
    }
}
