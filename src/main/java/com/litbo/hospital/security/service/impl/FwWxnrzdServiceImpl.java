package com.litbo.hospital.security.service.impl;

import com.litbo.hospital.security.bean.FwWxnrzd;
import com.litbo.hospital.security.dao.FwWxnrzdDao;
import com.litbo.hospital.security.service.FwWxnrzdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FwWxnrzdServiceImpl implements FwWxnrzdService {
    @Autowired
    private FwWxnrzdDao wxnrzdDao;

    /**
     * 根据父类id获取次级信息
     * @param parentId
     * @return
     */
    public List<FwWxnrzd> selectFwWxnrzd(int parentId){
        List<FwWxnrzd> list = wxnrzdDao.selectFwWxnrzd(parentId);
        return list;
    }
}
