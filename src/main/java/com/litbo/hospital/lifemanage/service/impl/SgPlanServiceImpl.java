package com.litbo.hospital.lifemanage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.*;
import com.litbo.hospital.lifemanage.bean.vo.SgCheckVO;
import com.litbo.hospital.lifemanage.bean.vo.SgPlanVO;
import com.litbo.hospital.lifemanage.dao.SelectMapper;
import com.litbo.hospital.lifemanage.dao.SgCheckMapper;
import com.litbo.hospital.lifemanage.dao.SgPdMapper;
import com.litbo.hospital.lifemanage.dao.SgPlanMapper;
import com.litbo.hospital.lifemanage.service.SelectService;
import com.litbo.hospital.lifemanage.service.SgPlanService;
import com.litbo.hospital.supervise.service.EmpService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    @Autowired
    private EmpService empService;

    @Autowired
    private SelectMapper selectMapper;
    @Autowired
    private SgPdMapper sgPdMapper;
    @Autowired
    private SelectService selectService;
    /**
     * 计划制定
     *
     * @param sgPlan 计划内容
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
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
        for (String eqId : eqList) {
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
     * @param userName 制定人
     * @param pageNum  当前页数
     * @param pageSize 每页记录数
     * @return PageInfo<SgPlan>
     */
    @Override
    public PageInfo selectPlan(String planName, String planDate, String userName, Integer pageNum, Integer pageSize) {

//        System.out.println(PageHelper.startPage(pageNum, pageSize));
        // 把空字符串 转换为null
        if (StringUtils.isBlank(planName)) {
            planName = null;
        }else{
            planName = "%"+planName+"%";
        }
        if (StringUtils.isBlank(planDate)) {
            planDate = null;
        }
        if (StringUtils.isBlank(userName)) {
            userName = null;
        }
        List<String> userId = new ArrayList<>();
        if (StringUtils.isNotBlank(userName)) {
            userName = "%" + userName + "%";
            userId = empService.getIdByXm(userName);
//            System.out.println("员工id:"+userId);
        }
        Date date = null;
        if (StringUtils.isNotBlank(planDate)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = simpleDateFormat.parse(planDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (userId.size()==0 && StringUtils.isNotBlank(userName)){
            System.out.println("空");
            return  new PageInfo<>();
        }else{
            try {
                List<SgPlan> str = sgPlanMapper.selectPlan(planName, date, userId);
            }catch (Exception e){
                System.out.println("出错");
            }
            List<SgPlan> sgPlan = sgPlanMapper.selectPlan(planName, date, userId);
            List<SgPlanList> sgPlanLists= new ArrayList<>();
            ListNum listNum = new ListNum();
            SgPlanList sgList = new SgPlanList();


            for (SgPlan sg:sgPlan){
//                System.out.println(sg.getPlanName());
                listNum = selectMapper.getListNum(sg.getId());
//                List<SelectVO> adllDate3 = selectMapper.listCheckDate(sg.getBmId());



                List<SelectVO> adllDate3 = new ArrayList<>();
                String getAllBmName = selectMapper.getBmName(sg.getBmId()); //对应planid下的部门
                List<SgCheckVO> adllDate4  =sgCheckMapper.getListByPlanId(sg.getId());
//                System.out.println(adllDate4);
                for (SgCheckVO s1:adllDate4){
                    SelectVO selectVO = new SelectVO(s1.getEqZcbh(),s1.getEqName(),getAllBmName);
                    adllDate3.add(selectVO);
                }



                List<SgPlanList> sgPlanLists2= new ArrayList<>();
                if  (listNum ==null){
                      sgList.setAllNum(adllDate3.size());
                      SgPlanList sgList1 = new SgPlanList( sg.getBmName(), sg.getId(), sg.getUserId(), sg.getBmId(),sg.getPlanName(),
                             sg.getPlanDate(),adllDate3.size(), 0,
                             0,adllDate3.size());
//                    System.out.println("空"+sgList1);

                     sgPlanLists2.add(sgList1);
                }
                sgPlanLists.addAll(sgPlanLists2);
                 if (listNum!=null){
                     SgPlanList sgList1 = new SgPlanList( sg.getBmName(), sg.getId(), sg.getUserId(), sg.getBmId(),sg.getPlanName(),
                             sg.getPlanDate(),adllDate3.size(), listNum.getYiPanNum(),
                             listNum.getPanYingNum(),listNum.getPanKuiNum());
                     sgPlanLists.add(sgList1);
//                     System.out.println("部位空"+sgList1);
                 }

//                System.out.println("总共"+sgPlanLists);
            }
            PageHelper.startPage(pageNum, pageSize);
            return  new PageInfo(sgPlanLists);
        }
    }

    /**
     * 查询所有的计划名字
     * @return
     */
    @Override
    public List<String> getplanName() {
        System.out.println(sgPlanMapper.getplanName());
        return sgPlanMapper.getplanName();
    }

    /**
     * 根据计划名称查询计划id
     * @return
     */
    @Override
    public String selectIdByName(SgPlanVO sgPlanVO) {
        SgPlan sgPlan=new SgPlan();
        BeanUtils.copyProperties(sgPlanVO,sgPlan);
        String planName=sgPlanVO.getPlanName();
        String id=sgPlanMapper.selectIdByName(planName);
        return id;
    }
}
