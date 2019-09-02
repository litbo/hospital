package com.litbo.hospital.beneficial.service.serviceImpl;

import com.litbo.hospital.beneficial.dao.CountIncomeDAO;
import com.litbo.hospital.beneficial.service.CountIncomeService;
import com.litbo.hospital.beneficial.vo.CountIncomeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description:
 * @Author: jz
 * @Date: 2019/7/26 16:36
 */
@Service
public class CountIncomeServiceImpl implements CountIncomeService {

    @Autowired
    private CountIncomeDAO countIncomeDAO;

    /**
     * description: 调用DAO层统计HIS系统的收入
     * @return  his系统所有的收入
     */
    @Override
    public List<CountIncomeVO> selectHis() {
        return countIncomeDAO.selectHis();
    }

    /**
     * description: 调用DAO层统计PACS系统的收入
     * @return  Pacs系统所有的收入
     */
    @Override
    public List<CountIncomeVO> selectPacs() {
        return countIncomeDAO.selectPacs();
    }

    /**
     * description: 调用DAO层统计手术室系统的收入
     * @return  手术室系统所有的收入
     */
    @Override
    public List<CountIncomeVO> selectSss() {
        return countIncomeDAO.selectSss();
    }

    /**
     * description: 调用DAO层把查询处理过的收费数据插入到表中
     * @return  插入了几行
     */
    @Override
    public int insertSbcw(List<CountIncomeVO> list) {
        //每次插入的条数
        int batchCount =100;
        int batchLastIndex = batchCount - 1;
        for (int index = 0; index < list.size() - 1;) {
            if (batchLastIndex > list.size() - 1) {
                batchLastIndex = list.size() - 1;
                countIncomeDAO.insertSbcw(list.subList(index,batchLastIndex +1 ));
                break;// 数据插入完毕,退出循环
            } else {
                countIncomeDAO.insertSbcw(list.subList(index,batchLastIndex +1 ));
                // 设置下一批下标
                index = batchLastIndex + 1;
                batchLastIndex = index + (batchCount - 1);
            }
        }
        return 0;
    }

    /**
     * 定时查询his系统上一天的收入
     * @return his系统上一天的收入
     */
    @Override
    public List<CountIncomeVO> timingSelectHis() {
        return countIncomeDAO.timingSelectHis();
    }

    /**
     * 定时查询Pacs系统上一天的收入
     * @return Pacs系统上一天的收入
     */
    @Override
    public List<CountIncomeVO> timingSelectPacs() {
        return countIncomeDAO.timingSelectPacs();
    }

    /**
     * 定时查询手术室系统上一天的收入
     * @return 手术室系统上一天的收入
     */
    @Override
    public List<CountIncomeVO> timingSelectSss() {
        return countIncomeDAO.timingSelectSss();
    }

}
