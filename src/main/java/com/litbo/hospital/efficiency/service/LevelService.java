package com.litbo.hospital.efficiency.service;

import com.litbo.hospital.efficiency.bean.LevelBean;
import com.litbo.hospital.efficiency.vo.LevelVO;

/**
 *   设置效率等级的利用率、闲置率的界限service层
 *   @Author: jz
 *   @Date: 2019/7/31 16:59
 */
public interface LevelService {

        /**
         * 显示使用效率
         * @return 使用效率
         */
        LevelVO selectLevel();

        /**
         * 设置使用的效率
         * @param levelBean 参数
         * @return 返回行数
         */
        Integer updateLevel(LevelBean levelBean);
}
