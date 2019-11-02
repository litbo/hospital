package com.litbo.hospital.lifemanage.check.mapper;

import com.litbo.hospital.lifemanage.check.pojo.Check;
import com.litbo.hospital.lifemanage.check.pojo.Plan;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PlanMapper {


    public void insertPlan1(Plan plan);
    public List<String> getEqIdByBmId(@Param(value = "bmId") String bmId);
    public void insertSelective(Check check);

    void updatetPlanSum(@Param("plan_sum") int plan_sum,@Param("id")String id);

    void updataPlanCheck(@Param("plan_check") String plan_check,@Param("plan_id") String plan_id);
    String findPlanId(String id);

    void updataOtherNum(@Param("yipan_sum")int yipan_sum,@Param("panying_sum")int panying_sum,
                        @Param("pankui_sum")int pankui_sum,@Param("plan_file")String plan_file,@Param("pdJhid")String pdJhid);

    String fileStatus(String plan_id);

}
