package com.litbo.hospital.efficiency.service.impl;

import com.litbo.hospital.efficiency.bean.LevelBean;
import com.litbo.hospital.efficiency.dao.LevelDAO;
import com.litbo.hospital.efficiency.service.LevelService;
import com.litbo.hospital.efficiency.vo.LevelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *   设置效率等级
 *   @Author: jz
 *   @Date: 2019/7/31 16:59
 */
@Service
public class LevelServiceImpl implements LevelService {

    @Autowired
    private LevelDAO levelDAO;

    /**
     * 查询效率等级
     * @return
     */
    @Override
    public LevelVO selectLevel() {
       return levelDAO.selectLevel();
    }

    /**
     * 更新效率等级的数值
     * @param levelBean     利用率 闲置率
     * @return
     */
    @Override
    public Integer updateLevel(LevelBean levelBean) {
        return levelDAO.updateLevel(levelBean);
    }
}
