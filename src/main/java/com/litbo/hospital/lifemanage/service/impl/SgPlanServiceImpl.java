package com.litbo.hospital.lifemanage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.SgCheck;
import com.litbo.hospital.lifemanage.bean.SgPlan;
import com.litbo.hospital.lifemanage.dao.SgCheckMapper;
import com.litbo.hospital.lifemanage.dao.SgPlanMapper;
import com.litbo.hospital.lifemanage.service.SgPlanService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 审核计划ServiceImpl
 *
 * @author Administrator on 2019-01-02
 */
@Service
public class SgPlanServiceImpl implements SgPlanService {
    @Autowired
    private SgPlanMapper sgPlanMapper;
    @Autowired
    private SgCheckMapper sgCheckMapper;

    /**
     * 计划制定
     *
     * @param sgPlan 计划内容
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = RuntimeException.class)
    @Override
    public void insertPlan(SgPlan sgPlan) {
        String planId = UUID.randomUUID().toString();
        sgPlan.setId(planId);
        sgPlan.setPlanDate(new Date());
        sgPlanMapper.insert(sgPlan);
        //查询科室的设备列表
        List<String> eqList = sgPlanMapper.getEqIdByBmId(sgPlan.getBmId());
        // 把计划核对的设备添加进核对表
        SgCheck sgCheck = new SgCheck();
        for (String eqId:eqList){
            sgCheck.setEqId(eqId);
            sgCheck.setPlanId(planId);
            sgCheck.setId(UUID.randomUUID().toString());
            sgCheckMapper.insertSelective(sgCheck);
        }
    }

    /**
     * 计划列表
     *
     * @param planName 计划名称
     * @param planDate 制定时间
     * @param userId   制定人
     * @param pageNum  当前页数
     * @param pageSize 每页记录数
     * @return PageInfo<SgPlan>
     */
    @Override
    public PageInfo<SgPlan> selectPlan(String planName, String planDate, String userId,Integer pageNum,Integer pageSize){
        Date date = null;
        if (StringUtils.isNotBlank(planDate)){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = simpleDateFormat.parse(planDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(sgPlanMapper.selectPlan(planName,date,userId));
    }
}
