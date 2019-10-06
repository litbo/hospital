package com.litbo.hospital.common.utils.calculate;

import com.litbo.hospital.efficiency.vo.SearchVO;

/**
 * description: 处理效率等级的查询
 * @author: sz
 * @date: 2019/8/5 17:50
 */
public class HandleLevel {

    public static Boolean overLoad(SearchVO vo){
        String str = "超负荷运转";
        if (vo.getSearchLevel()!=null&&!vo.getSearchLevel().trim().equals("")){
            return str.contains(vo.getSearchLevel());
        }

        return false;
    }

    public static Boolean efficient(SearchVO vo){
        String str = "高效运转";
        if (vo.getSearchLevel()!=null&&!vo.getSearchLevel().trim().equals("")){
            return str.contains(vo.getSearchLevel());
        }

        return false;
    }

    public static Boolean midEfficient(SearchVO vo){
        String str = "中效运转";
        if (vo.getSearchLevel()!=null&&!vo.getSearchLevel().trim().equals("")){
            return str.contains(vo.getSearchLevel());
        }

        return false;
    }

    public static Boolean inefficient(SearchVO vo){
        String str = "低效运转";
        if (vo.getSearchLevel()!=null&&!vo.getSearchLevel().trim().equals("")){
            return str.contains(vo.getSearchLevel());
        }

        return false;
    }

    public static Boolean idle(SearchVO vo){
        String str = "长期闲置";
        if (vo.getSearchLevel()!=null&&!vo.getSearchLevel().trim().equals("")){
            return str.contains(vo.getSearchLevel());
        }

        return false;
    }
}
