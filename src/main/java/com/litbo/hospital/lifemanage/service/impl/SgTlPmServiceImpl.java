package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.dao.SgTlPmMapper;
import com.litbo.hospital.lifemanage.service.SgTlPmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 讨论申购设备关联表Service实现类
 */
@Service
public class SgTlPmServiceImpl implements SgTlPmService {
    @Autowired
    private SgTlPmMapper sgTlPmMapper;

    /**
     * 申购设备关联信息批量添加
     *
     * @param kstlId  科室讨论的ID
     * @param pmsId 设备品名ID
     * @param kstlSj 科室讨论时间
     * @return 是否插入数据成功
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean insertSgTlPm(String kstlId, List<Integer> pmsId, Date kstlSj){
        int sgTlPmNum = 0;
        for (Integer pmId : pmsId) {
            sgTlPmNum += sgTlPmMapper.insertSgTlPm(kstlId, pmId,kstlSj);
        }
        return sgTlPmNum == pmsId.size();
    }

    /**
     * 通过科室讨论ID查询讨论的品名ID
     * @param kstlId 科室讨论ID
     * @return 同一个讨论的所有品名ID
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Integer> selectSgTlPmPmIdsByTlId(String kstlId) {
        return sgTlPmMapper.selectSgTlPmPmIdsByTlId(kstlId);
    }
}
