package com.litbo.hospital.supervise.dao;

import com.litbo.hospital.supervise.bean.PbJhVO;
import com.litbo.hospital.supervise.vo.getPbPlanVos;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PbMapper {

    void addPbPlan(PbJhVO pbJhVO);

    List<getPbPlanVos> getPbPlanVos();
}
