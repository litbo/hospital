package com.litbo.hospital.beneficial.service;

import com.litbo.hospital.beneficial.vo.CountIncomeVO;

import java.util.List;

/**
 * description: His、Pacs、手术室系统的收入Service层
 * @Author: jz
 * @Date: 2019/7/26 16:34
 */
public interface CountIncomeService {

    /**
     * description: his系统的收入
     * @return  his系统所有的收入
     */
    List<CountIncomeVO> selectHis();

    /**
     * description: Pacs系统的收入
     * @return  Pacs系统所有的收入
     */
    List<CountIncomeVO> selectPacs();

    /**
     * description: 手术室系统的收入
     * @return  手术室系统所有的收入
     */
    List<CountIncomeVO> selectSss();

    /**
     * description: 把查询处理过的收费数据插入到表中
     * @param list 每种收入的集合
     * @return  插入了几行
     */
    int insertSbcw(List<CountIncomeVO> list);

    /**
     * 定时查询his系统上一天的收入
     * @return  his系统上一天的收入
     */
    List<CountIncomeVO> timingSelectHis();

    /**
     * 定时查询Pacs系统上一天的收入
     * @return  Pacs系统上一天的收入
     */
    List<CountIncomeVO> timingSelectPacs();

    /**
     * 定时查询手术室系统上一天的收入
     * @return  手术室系统上一天的收入
     */
    List<CountIncomeVO> timingSelectSss();

}
