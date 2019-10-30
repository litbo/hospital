package com.litbo.hospital.supervise.service;

import com.litbo.hospital.supervise.bean.PbJhVO;
import com.litbo.hospital.supervise.vo.getPbPlanVos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PbService {

    void addPbPlan(PbJhVO pbJhVO);

    List<getPbPlanVos> getPbPlan(int pageNum,int pageSize);
}
