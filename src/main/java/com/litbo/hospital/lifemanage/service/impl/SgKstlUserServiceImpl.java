package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.dao.SgKstlUserMapper;
import com.litbo.hospital.lifemanage.service.SgKstlUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 科室讨论会议人员关联表Service实现类
 */
@Service
public class SgKstlUserServiceImpl implements SgKstlUserService {
    @Autowired
    private SgKstlUserMapper sgKstlUserMapper;

    /**
     * 添加科室讨论人员信息批量添加
     *
     * @param kstlId  科室讨论的ID
     * @param usersId 参加讨论的人员集合
     * @return 是否插入数据成功
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean insertSgKstlUser(String kstlId, List<String> usersId) {
        int i = sgKstlUserMapper.insertSgKstlUser(kstlId, usersId);
        return usersId.size()==i;
    }
}
