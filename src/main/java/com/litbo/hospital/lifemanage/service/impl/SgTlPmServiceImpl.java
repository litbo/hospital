package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.dao.SgTlPmMapper;
import com.litbo.hospital.lifemanage.service.SgTlPmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
     * @param pmId 设备品名ID
     * @return 是否插入数据成功
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean insertSgTlPm(String kstlId, List<Integer> pmId){
        int i = sgTlPmMapper.insertSgTlPm(kstlId, pmId);
        return i == pmId.size();
    }
}
