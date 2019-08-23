package com.litbo.hospital.common.utils.calculate;

import com.litbo.hospital.efficiency.vo.EfficiencyLevelVO;

/**
 * description: 处理效率等级的搜索
 * @author: sz
 * @date: 2019/8/5 17:50
 */
public class HandleLevel {

    public static Boolean overLoad(EfficiencyLevelVO vo){
        String str = "超负荷运转";
        if (vo.getSearchLevel()!=null&&!vo.getSearchLevel().trim().equals("")){
            return str.contains(vo.getSearchLevel());
        }

        return false;
    }

    public static Boolean efficient(EfficiencyLevelVO vo){
        String str = "高效运转";
        if (vo.getSearchLevel()!=null&&!vo.getSearchLevel().trim().equals("")){
            return str.contains(vo.getSearchLevel());
        }

        return false;
    }

    public static Boolean midEfficient(EfficiencyLevelVO vo){
        String str = "中效运转";
        if (vo.getSearchLevel()!=null&&!vo.getSearchLevel().trim().equals("")){
            return str.contains(vo.getSearchLevel());
        }

        return false;
    }

    public static Boolean inefficient(EfficiencyLevelVO vo){
        String str = "低效运转";
        if (vo.getSearchLevel()!=null&&!vo.getSearchLevel().trim().equals("")){
            return str.contains(vo.getSearchLevel());
        }

        return false;
    }

    public static Boolean idle(EfficiencyLevelVO vo){
        String str = "长期闲置";
        if (vo.getSearchLevel()!=null&&!vo.getSearchLevel().trim().equals("")){
            return str.contains(vo.getSearchLevel());
        }

        return false;
    }
}
