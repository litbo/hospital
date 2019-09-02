package com.litbo.hospital.efficiency.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.calculate.Efficiency;
import com.litbo.hospital.efficiency.dao.OpenDAO;
import com.litbo.hospital.efficiency.service.OpenService;
import com.litbo.hospital.efficiency.vo.OpenVO;
import com.litbo.hospital.efficiency.vo.SearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: 开机率的Service实现层
 * @Author: jz
 * @Date: 2019/8/1 10:16
 */
@Service
public class OpenServiceImpl implements OpenService {

    @Autowired
    private OpenDAO openDAO;

    public static List<OpenVO> handleOpenData(List<OpenVO> lists){

        // 计算并设置设备的开机率
        lists.forEach(item->{
            item.setRating(Efficiency.result(String.valueOf(item.getRealDays()),String.valueOf(item.getWorkDays())));
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
    public PageInfo selectOpen(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Integer integer = openDAO.deleteOpen();
        Integer integer1 = openDAO.updateOpen();
        List<OpenVO> openVOS = openDAO.selectOpen();
        return new PageInfo(handleOpenData(openVOS));
    }

    @Override
    public PageInfo selectOpenByCon(int pageNum, int pageSize, SearchVO searchVO) {
        PageHelper.startPage(pageNum, pageSize);

        Integer integer1 = openDAO.deleteOpen();

        Integer integer = openDAO.updateOpenByCon(searchVO);
        List<OpenVO> openVOS = openDAO.selectOpen();
        return new PageInfo(handleOpenData(openVOS));
    }
}
