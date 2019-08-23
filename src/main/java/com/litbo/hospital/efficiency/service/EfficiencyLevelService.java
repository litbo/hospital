package com.litbo.hospital.efficiency.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.efficiency.vo.EfficiencyLevelVO;

/**
 * description: 使用效率等级
 * @author: sz
 * @date: 2019/8/5 17:22
 */
public interface EfficiencyLevelService {

    /**
     * 默认查询所有的效率等级
     * @param pageNum   页码
     * @param pageSize  大小
     * @return 查询查询所有的效率等级数据
     */
    PageInfo selectLevel(int pageNum, int pageSize);

    /**
     * 按条件查询所有的效率等级
     * @param pageNum   页码
     * @param pageSize  大小
     * @param levelVOS  条件
     * @return 返回按条件查询所有的效率等级
     */
    PageInfo selectLevelByCon(int pageNum, int pageSize, EfficiencyLevelVO levelVOS);
}
