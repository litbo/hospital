package com.litbo.hospital.supervise.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.vo.getPbPlanVos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TjService {
   // PageInfo getInfo(int pageNum, int pageSize,String jhid);

    List<getPbPlanVos> getPbPlan(int pageNum, int pageSize);

    PageInfo getInfo(int pageNum, int pageSize);
}
