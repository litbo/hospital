package com.litbo.hospital.supervise.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.KaoqinVO;
import com.litbo.hospital.supervise.bean.PbJhVO;
import com.litbo.hospital.supervise.vo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface PbService {


    void addPbPlan(PbJhVO pbJhVO);

    List<getPbPlanVos> getPbPlan(int pageNum,int pageSize);

    List<RyZtVos> getPbPeople(int pageNum,int pageSize,String id);

    List<RyVos> ghPeople(int pageNum,int pageSize,String sid);

    PageInfo<RyVos> getBmpeople(String bmId,int pageNum,int pageSize);

    void BcKqRy(List<KqRyVos> pbRyVos, String id);

    void insertGhRy(@Param("uid") String uid,@Param("sid") String sid,@Param("gid") String gid);

    void insertZbRy(@Param("uid") String uid, @Param("sid") String sid,@Param("uName")  String uName);

    List<RyZtVos> getZbPeople(int pageNum, int pageSize, String id);
}
