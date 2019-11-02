package com.litbo.hospital.lifemanage.check.service.Imp;

import com.litbo.hospital.lifemanage.check.mapper.PlanMapper;
import com.litbo.hospital.lifemanage.check.pojo.Check;
import com.litbo.hospital.lifemanage.check.pojo.Plan;
import com.litbo.hospital.lifemanage.check.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PlanServiceImp implements PlanService {

    public Plan plan;

    @Autowired
    private PlanMapper planMapper;

    @Override
    public void insertPlan1(Plan plan) {
        try{
            String planId = UUID.randomUUID().toString();
            plan.setId(planId);
            plan.setPlan_date(new Date());

            //查询科室的设备列表
            List<String> eqList = planMapper.getEqIdByBmId(plan.getBm_id());
            plan.setPlan_sum(eqList.size());
            plan.setYipan_sum(0);
            plan.setPankui_sum(0);
            plan.setPanying_sum(0);
            plan.setPlan_check("未审核");
            plan.setPlan_file("未上传");

            planMapper.insertPlan1(plan);
//            System.out.println(plan.getBm_id());
            // 把计划核对的设备添加进核对表Check表
            Check check = new Check();
            for (String eqId : eqList) {
                check.setEq_id(eqId);
                check.setPlan_id(planId);
                check.setId(UUID.randomUUID().toString());
                planMapper.insertSelective(check); //附增加到check表单
//                System.out.println(check.toString()+"aaaaaaaaaaaaaaaaaaa");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
