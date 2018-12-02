package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.bean.SgKstl;
import com.litbo.hospital.lifemanage.dao.SgKstlMapper;
import com.litbo.hospital.lifemanage.dao.SgKstlUserMapper;
import com.litbo.hospital.lifemanage.dao.SgTlPmMapper;
import com.litbo.hospital.lifemanage.service.SgKstlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 科室讨论表Service实现类
 */
@Service
public class SgKstlServiceImpl implements SgKstlService {
    @Autowired
    private SgKstlMapper sgKstlMapper;
    @Autowired
    private SgKstlUserMapper sgKstlUserMapper;
    @Autowired
    private SgTlPmMapper sgTlPmMapper;

    /**
     * 添加科室讨论信息
     *
     * @param sgKstl  科室讨论实体对象
     * @param usersId 参加讨论的人员集合
     * @param pmId    设备品名ID
     * @return 添加是否成功
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean insertSgKstl(SgKstl sgKstl, List<String> usersId, List<Integer> pmId) {
        Integer integer = sgKstlMapper.insertSgKstl(sgKstl);
        int sgKstlUserNum = sgKstlUserMapper.insertSgKstlUser(sgKstl.getKstlId(), usersId);
        int sgTlPmNum = sgTlPmMapper.insertSgTlPm(sgKstl.getKstlId(), pmId);
        return integer > 0 && usersId.size() == sgKstlUserNum && pmId.size() == sgTlPmNum;
    }
}
