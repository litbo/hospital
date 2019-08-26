package com.litbo.hospital.efficiency.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.calculate.HandleData;
import com.litbo.hospital.common.utils.calculate.ReLevel;
import com.litbo.hospital.efficiency.dao.EfficiencyLevelDAO;
import com.litbo.hospital.efficiency.dao.LevelDAO;
import com.litbo.hospital.efficiency.service.EfficiencyLevelService;
import com.litbo.hospital.efficiency.vo.EfficiencyLevelVO;
import com.litbo.hospital.efficiency.vo.SearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description:
 * @author: sz
 * @date: 2019/8/5 17:26
 */
@Service
public class EfficiencyLevelServiceImpl implements EfficiencyLevelService {

    @Autowired
    private EfficiencyLevelDAO dao;

    @Autowired
    private LevelDAO levelDAO;

    public  List<EfficiencyLevelVO> getLevels(List<EfficiencyLevelVO> list){

        list.forEach(item->{
            item.setEfficiencyLevel(ReLevel.getLevel(HandleData.splitPercent(item.getEqUsing()),levelDAO));
            System.out.println(item);
        });

        return list;
    }


    /**
     * 默认查询所有的效率等级
     * @param pageNum  页码
     * @param pageSize 大小
     * @return 查询查询所有的效率等级数据
     */
    @Override
    public PageInfo selectLevel(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<EfficiencyLevelVO> vos = dao.selectLevel();
        System.out.println(vos);
        return new PageInfo(getLevels(vos));
    }

    /**
     * 按条件查询所有的效率等级
     * @param pageNum   页码
     * @param pageSize  大小
     * @param searchVO  条件
     * @return 返回按条件查询所有的效率等级
     */
    @Override
    public PageInfo selectLevelByCon(int pageNum, int pageSize, SearchVO searchVO) {
        PageHelper.startPage(pageNum, pageSize);
        List<EfficiencyLevelVO> vos = dao.selectLevelByCon(searchVO);
        return new PageInfo(getLevels(vos));
    }
}
