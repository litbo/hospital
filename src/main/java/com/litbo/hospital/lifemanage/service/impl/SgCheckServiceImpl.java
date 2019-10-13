package com.litbo.hospital.lifemanage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.SgCheck;
import com.litbo.hospital.lifemanage.bean.vo.SgCheckListVO;
import com.litbo.hospital.lifemanage.bean.vo.SgCheckVO;
import com.litbo.hospital.lifemanage.dao.AddMapper;
import com.litbo.hospital.lifemanage.dao.SgCheckMapper;
import com.litbo.hospital.lifemanage.enums.StateEnum;
import com.litbo.hospital.lifemanage.service.SgCheckService;
import com.litbo.hospital.supervise.bean.SEmp;
import com.litbo.hospital.supervise.dao.EmpDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * SgCheckService
 *
 * @author Administrator on 2018-12-29
 */
@Service
public class SgCheckServiceImpl implements SgCheckService {
    @Autowired
    private SgCheckMapper sgCheckMapper;
    @Autowired
    private EmpDao empDao;

    @Autowired
    private AddMapper addMapper;

    /**
     * 计划下的所有待核对的设备列表
     *
     * @param planId   计划id
     * @param pageNum  当前页数
     * @param pageSize 每页显示的记录数
     * @return PageInfo<SgCheck>
     */
    @Override
    public PageInfo<SgCheckVO> selectSgCheck(String planId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(sgCheckMapper.getListByPlanId(planId));
    }

    /**
     * 添加账实核对信息
     *
     * @param ids    核对表id
     * @param userId 核对人id
     * @param check  核对是否存在 0不存在 1存在
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    @Override
    public void updateSgCheckByIds(List<String> ids, String userId, String check) {
        //通过人员id获取用户姓名
        System.out.println("改改");
        System.out.println("改改");
        SEmp emp = empDao.getEmpsById(userId);
        SgCheck sgCheck = new SgCheck();
        for (String id : ids) {
            sgCheck.setUserId(emp.getUserXm());
            sgCheck.setId(id);
            sgCheck.setDate(new Date());
            sgCheck.setChecks(StateEnum.getMessageByCode(Integer.parseInt(check)));
            System.out.println("改改");
            sgCheckMapper.updateByPrimaryKeySelective(sgCheck);
        }
    }

    /**
     * 核对对比
     *
     * @param planId    计划id
     * @param check     是否存在
     * @param checkDate 审核日期
     * @param checkUser 审核人
     * @param planDate  制定日期
     * @param planUser  制定人
     * @param pageNum   当前页数
     * @param pageSize  每页显示的记录数
     * @return PageInfo<SgCheckListVO>
     */
    @Override
    public PageInfo<SgCheckListVO> selectSgCheckList(String planId, String check, String checkDate, String checkUser, String planDate, String planUser, Integer pageNum, Integer pageSize) {
        if (StringUtils.isNotBlank(check)){
            check = StateEnum.getMessageByCode(Integer.parseInt(check));
        }
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(sgCheckMapper.getListByX(planId,check,checkDate,checkUser,planDate,planUser));
    }

    @Override
    public void addOther(SgCheck sgCheck) {
        try{

            String planId = UUID.randomUUID().toString();
            sgCheck.setId(planId);
            addMapper.addOther(sgCheck);
//            sgCheck.setEqId(sgCheck.getChecks());


        }catch (Exception e){
            e.printStackTrace();
        }



    }


    @Override
    public PageInfo<SgCheckListVO> findListByEqName(String planId, String eqName,Integer pageNum,Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(sgCheckMapper.findListByEqName(planId,eqName));
    }
}
