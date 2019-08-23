package com.litbo.hospital.efficiency.service.impl;

import com.litbo.hospital.common.utils.calculate.HandleData;
import com.litbo.hospital.efficiency.bean.KpiBean;
import com.litbo.hospital.efficiency.dao.*;
import com.litbo.hospital.efficiency.service.RadioService;
import com.litbo.hospital.efficiency.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * description: 比率的kpi实现
 * @author: sz
 * @date: 2019/8/3 11:52
 */
@Service
public class RadioServiceImpl implements RadioService {

    @Autowired
    private RadioDAO radioDAO;

    @Autowired
    private OpenDAO openDAO;

    @Autowired
    private UsingDAO usingDAO;

    @Autowired
    private IdlingDAO idlingDAO;

    @Autowired
    private IdlTimeDAO idlTimeDAO;

    @Autowired
    private IntegrityDAO integrityDAO;

    /**
     * 设置开机率的kpi数据
     * @param list 开机率相关信息
     * @return 返回
     */
    private static List<KpiBean> handOpenKpi(List<OpenVO> list){

        List<KpiBean> beanList = new ArrayList<>();

        for (OpenVO openVO : list) {
            KpiBean bean = new KpiBean();
            bean.setEqCode(openVO.getEqCode());
            bean.setEqName(openVO.getEqName());
            bean.setRatio(openVO.getRating());
            bean.setRanking(openVO.getRanking());
            bean.setTimes(HandleData.getNewDate());
            bean.setStatus("0");
            bean.setDataStatus("1");
            beanList.add(bean);
        }
        return beanList;
    }

    /**
     * 设置机时利用率的kpi数据
     * @param list 机时利用率相关信息
     * @return 返回
     */
    private static List<KpiBean> handUsingKpi(List<UsingVO> list){

        List<KpiBean> beanList = new ArrayList<>();

        for (UsingVO usingVO : list) {
            KpiBean bean = new KpiBean();
            bean.setEqCode(usingVO.getEqCode());
            bean.setEqName(usingVO.getEqJc());
            bean.setRatio(HandleData.splitPercent(usingVO.getRating()));
            bean.setRanking(usingVO.getRanking());
            bean.setTimes(HandleData.getNewDate());
            bean.setStatus("2");
            bean.setDataStatus("2");
            beanList.add(bean);
        }
        return beanList;
    }

    /**
     * 设置空转率的kpi数据
     * @param list 空转率相关信息
     * @return 返回
     */
    private static List<KpiBean> handIdlingKpi(List<IdlingVO> list){

        List<KpiBean> beanList = new ArrayList<>();

        for (IdlingVO idlingVO : list) {
            KpiBean bean = new KpiBean();
            bean.setEqCode(idlingVO.getEqCode());
            bean.setEqName(idlingVO.getEqJc());
            bean.setRatio(idlingVO.getRating());
            bean.setRanking(idlingVO.getRanking());
            bean.setTimes(HandleData.getNewDate());
            bean.setStatus("2");
            bean.setDataStatus("3");
            beanList.add(bean);
        }
        return beanList;
    }


    /**
     * 设置工作日闲置时间的kpi数据
     * @param list 工作日闲置时间相关信息
     * @return 返回
     */
    private static List<KpiBean> handIdlTimeKpi(List<IdlTimeVO> list){

        List<KpiBean> beanList = new ArrayList<>();

        for (IdlTimeVO idlTimeVO : list) {
            KpiBean bean = new KpiBean();
            bean.setEqCode(idlTimeVO.getEqCode());
            bean.setEqName(idlTimeVO.getEqName());
            bean.setRatio(idlTimeVO.getAvgTimes());
            bean.setRanking(idlTimeVO.getRanking());
            bean.setTimes(HandleData.getNewDate());
            bean.setStatus("0");
            bean.setDataStatus("4");
            beanList.add(bean);
        }
        return beanList;
    }

    /**
     * 设置完好率的kpi数据
     * @param list 完好率时间相关信息
     * @return 返回
     */
    private static List<KpiBean> handIntegrityKpi(List<IntegrityVO> list){

        List<KpiBean> beanList = new ArrayList<>();

        for (com.litbo.hospital.efficiency.vo.IntegrityVO IntegrityVO : list) {
            KpiBean bean = new KpiBean();
            bean.setEqName(IntegrityVO.getEqName());
            bean.setRatio(IntegrityVO.getRating());
            bean.setRanking(IntegrityVO.getRanking());
            bean.setTimes(HandleData.getNewDate());
            bean.setStatus("0");
            bean.setDataStatus("5");
            beanList.add(bean);
        }
        return beanList;
    }

    /**
     * 开机率
     * @return 返回
     */
    @Override
    public List<KpiBean> selectOpen() {
        List<OpenVO> vo1 = openDAO.selectOpen();
        List<OpenVO> vo2 = OpenServiceImpl.handleOpenData(vo1);
        List<KpiBean> beanList = handOpenKpi(vo2);
        return beanList;
    }

    /**
     * 机时利用率
     * @return 返回
     */
    @Override
    public List<KpiBean> selectUsing() {
        List<UsingVO> vos = usingDAO.selectUsing();
        List<UsingVO> vos1 = UsingServiceImpl.handleData(vos);
        List<KpiBean> beanList = handUsingKpi(vos1);
        return beanList;
    }

    /**
     * 空转率
     * @return 返回
     */
    @Override
    public List<KpiBean> selectIdling() {
        List<IdlingVO> vos = idlingDAO.selectIdling();
        List<IdlingVO> vos1 = IdlingServiceImpl.handData(vos);
        List<KpiBean> beanList = handIdlingKpi(vos1);
        return beanList;
    }


    /**
     * 工作日闲置时间
     * @return 返回
     */
    @Override
    public List<KpiBean> selectIdlTime() {
        List<IdlTimeVO> vos = idlTimeDAO.selectIdlTime();
        List<IdlTimeVO> vos1 = IdlTimeServiceImpl.handData(vos);
        List<KpiBean> beanList = handIdlTimeKpi(vos1);
        return beanList;
    }

    /**
     * 完好率
     * @return 返回
     */
    @Override
    public List<KpiBean> selectIntegrity() {
        List<IntegrityVO> vos = integrityDAO.selectIntegrity();
        List<IntegrityVO> vos1 = IntegrityServiceImpl.handleIntegrity(vos);
        List<KpiBean> beanList = handIntegrityKpi(vos1);
        return beanList;
    }

    /**
     * 将查询的KPI数据插入到kpi数据表中
     * @param list kpi数据
     * @return 返回
     */
    @Override
    public int insertKpi(List<KpiBean> list) {
        //每次插入的条数
        int batchCount =100;
        int cursor = batchCount - 1;
        for (int index = 0; index < list.size() ;) {
            if (cursor >= list.size() - 1) {
                cursor = list.size() - 1;
                radioDAO.insertKpi(list.subList(index,cursor+1));
                break;// 数据插入完毕,退出循环
            } else {
                radioDAO.insertKpi(list.subList(index,cursor+1));
                // 设置下一批下标
                index = cursor + 1;
                cursor = index + (batchCount - 1);
            }
        }
        //radioDAO.insertKpi(list);
        return 0;
    }
}
