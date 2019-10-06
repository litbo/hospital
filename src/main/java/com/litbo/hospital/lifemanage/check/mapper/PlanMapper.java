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
}
