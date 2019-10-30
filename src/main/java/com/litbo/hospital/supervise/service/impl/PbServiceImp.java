package com.litbo.hospital.supervise.service.impl;

import com.litbo.hospital.supervise.bean.PbJhVO;
import com.litbo.hospital.supervise.dao.PbMapper;
import com.litbo.hospital.supervise.service.PbService;

public class PbServiceImp implements PbService {
    @Override
    public void addPbPlan(PbJhVO pbJhVO) {
        PbMapper.addPbPlan(pbJhVO);
    }
}
