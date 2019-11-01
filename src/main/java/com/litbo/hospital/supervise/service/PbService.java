package com.litbo.hospital.supervise.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.KaoqinVO;
import com.litbo.hospital.supervise.bean.PbJhVO;
import com.litbo.hospital.supervise.vo.RyVos;
import com.litbo.hospital.supervise.vo.getPbPlanVos;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface PbService {


    Result insertKaoqin(KaoqinVO kaoqinVO);

    void addPbPlan(PbJhVO pbJhVO);

    List<getPbPlanVos> getPbPlan(int pageNum,int pageSize);

    List<RyVos> getPbPeople(int pageNum,int pageSize,String id);

    List<RyVos> ghPeople(int pageNum,int pageSize,String sid);

    PageInfo<RyVos> getBmpeople(String bmId,int pageNum,int pageSize);
}
