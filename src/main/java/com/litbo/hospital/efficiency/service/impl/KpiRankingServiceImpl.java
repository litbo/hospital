package com.litbo.hospital.efficiency.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.efficiency.dao.KpiRankingDAO;
import com.litbo.hospital.efficiency.service.KpiRankingService;
import com.litbo.hospital.efficiency.vo.KpiRankingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description: kpi数据排名计算Service层
 * @author: sz
 * @date: 2019/8/4 14:35
 */
@Service
public class KpiRankingServiceImpl implements KpiRankingService {

    @Autowired
    private KpiRankingDAO kpiRankingDAO;

    /**
     *  KpiRankingVO
     *  status: 0：月，2：日
     *  DataStatus：1：开机率，2：机时利用率，3：空转率，4：工作日闲置时间，5：完好率
     */

    /**
     * 获取开机率的排名变化数据
     * @param pageNum  页码
     * @param pageSize 大小
     * @return 返回开机率的排名变化数据
     */
    @Override
    public PageInfo selectChangeOpen(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        KpiRankingVO kpiRankingVO = new KpiRankingVO();
        kpiRankingVO.setStatus("0");
        kpiRankingVO.setDataStatus("1");
        return new PageInfo(kpiRankingDAO.selectChange(kpiRankingVO));
    }

    /**
     * 获取机时利用率的排名变化数据
     * @param pageNum  页码
     * @param pageSize 大小
     * @return 返回机时利用率的排名变化数据
     */
    @Override
    public PageInfo selectChangeUsing(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        KpiRankingVO kpiRankingVO = new KpiRankingVO();
        kpiRankingVO.setStatus("2");
        kpiRankingVO.setDataStatus("2");
        return new PageInfo(kpiRankingDAO.selectChange(kpiRankingVO));
    }

    /**
     * 获取空转率的排名变化数据
     * @param pageNum  页码
     * @param pageSize 大小
     * @return 返回空转率的排名变化数据
     */
    @Override
    public PageInfo selectChangeIdling(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        KpiRankingVO kpiRankingVO = new KpiRankingVO();
        kpiRankingVO.setStatus("2");
        kpiRankingVO.setDataStatus("3");
        return new PageInfo(kpiRankingDAO.selectChange(kpiRankingVO));
    }

    /**
     * 获取工作日平均闲置时间的排名变化数据
     * @param pageNum  页码
     * @param pageSize 大小
     * @return 返回工作日平均闲置时间的排名变化数据
     */
    @Override
    public PageInfo selectChangeIdlTimes(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        KpiRankingVO kpiRankingVO = new KpiRankingVO();
        kpiRankingVO.setStatus("0");
        kpiRankingVO.setDataStatus("4");
        return new PageInfo(kpiRankingDAO.selectChange(kpiRankingVO));
    }

    /**
     * 获取完好率的排名变化数据
     * @param pageNum  页码
     * @param pageSize 大小
     * @return 返回完好率的排名变化数据
     */
    @Override
    public PageInfo selectChangeIntegrity(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        KpiRankingVO kpiRankingVO = new KpiRankingVO();
        kpiRankingVO.setStatus("0");
        kpiRankingVO.setDataStatus("5");
        return new PageInfo(kpiRankingDAO.selectChange(kpiRankingVO));
    }


}
