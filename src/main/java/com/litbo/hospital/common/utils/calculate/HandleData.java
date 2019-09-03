package com.litbo.hospital.common.utils.calculate;

import com.litbo.hospital.efficiency.bean.LevelBean;
import com.litbo.hospital.efficiency.vo.SearchVO;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author 48885
 */
public class HandleData {


    public static String splitPercent(String string){
        String[] split = string.split("%");
        return split[0];
    }

    public static LevelBean judge(LevelBean levelBean){



        return levelBean;
    }

    public static String changeDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public static String getNewDate(){
        Date date = new Date();
        return changeDate(date);
    }

    public static String getMonthDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,-1);
        return changeDate(calendar.getTime());
    }

    public static String[] splitTime(String times){
        String[] split = times.split(" ~ ");
        return split;
    }

    public static String calculateString(String one,String two){
        BigDecimal b1 = new BigDecimal(one);
        BigDecimal b2 = new BigDecimal(two);
        return b1.add(b2).toString();
    }

    public static SearchVO handleSearch(SearchVO searchVO){

        if (searchVO.getStartSTime()!=null&&searchVO.getStartSTime().trim().equals("")){
            searchVO.setStartSTime(null);
        }
        if (searchVO.getEndSTime()!=null&&searchVO.getEndSTime().trim().equals("")){
            searchVO.setEndSTime(null);
        }
        if (searchVO.getBmSName()!=null&&searchVO.getBmSName().trim().equals("")){
            searchVO.setBmSName(null);
        }
        if (searchVO.getEqSName()!=null&&searchVO.getEqSName().trim().equals("")){
            searchVO.setEqSName(null);
        }
        if (searchVO.getSearchLevel()!=null&&searchVO.getSearchLevel().trim().equals("")){
            searchVO.setSearchLevel(null);
        }
        return searchVO;
    }

    public static <T>T listSort(List<T> lists){

        if (lists!=null && !lists.isEmpty()){

            return (T)lists;
        }

        throw new RuntimeException("数据为null或空，请检查传入的数据。");
    }

    public static <T>T result(List<T> newLists, List<T> oldLists){
        List<T> lists = new ArrayList<>();
        if(newLists != null && !newLists.isEmpty()){

            Map<T,T> maps = new HashMap<>();
            for (T t:newLists){
                maps.put(t,t);
            }

            if (oldLists!=null && !oldLists.isEmpty()){
                for (T t:oldLists){
                    if (!maps.containsKey(t)){
                        lists.add(t);
                    }
                }
                return (T) lists;
            }

        }

        //throw new RuntimeException("请检查是否有数据");
        return (T) lists;
    }

}
