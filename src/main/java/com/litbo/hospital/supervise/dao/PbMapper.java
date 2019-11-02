package com.litbo.hospital.supervise.dao;

import com.litbo.hospital.supervise.bean.KaoqinVO;
import com.litbo.hospital.supervise.bean.PbJhVO;
import com.litbo.hospital.supervise.vo.RyVos;
import com.litbo.hospital.supervise.vo.getPbPlanVos;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PbMapper {

    void addPbPlan(PbJhVO pbJhVO);

    List<getPbPlanVos> getPbPlanVos();

    List<RyVos> getPbPeople(@Param("id") String id);

    List<RyVos> ghPeople(@Param("sid")String sid);

    List<RyVos> getBmpeople(String bmId);

}
