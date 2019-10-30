package com.litbo.hospital.supervise.service.impl;

import com.github.pagehelper.PageHelper;
import com.litbo.hospital.supervise.bean.PbJhVO;
import com.litbo.hospital.supervise.dao.PbMapper;
import com.litbo.hospital.supervise.service.PbService;
import com.litbo.hospital.supervise.vo.getPbPlanVos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PbServiceImp implements PbService {

    @Autowired
    private PbMapper pbMapper;

    @Override
    public List<getPbPlanVos> getPbPlan(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return pbMapper.getPbPlanVos();
    }

    @Override
    public void addPbPlan(PbJhVO pbJhVO) {
        System.out.println("hahahahhhhhhhhhhhhhhhhhhhhhhhhh");
        pbMapper.addPbPlan(pbJhVO);
    }
}
