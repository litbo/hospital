package com.litbo.hospital.lifemanage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.SgCheck;
import com.litbo.hospital.lifemanage.bean.vo.SgCheckListVO;
import com.litbo.hospital.lifemanage.bean.vo.SgCheckVO;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
        SEmp emp = empDao.getEmpsById(userId);
        SgCheck sgCheck = new SgCheck();
        for (String id : ids) {
            sgCheck.setUserId(emp.getUserXm());
            sgCheck.setId(id);
            sgCheck.setDate(new Date());
            sgCheck.setChecks(StateEnum.getMessageByCode(Integer.parseInt(check)));
            sgCheckMapper.updateByPrimaryKeySelective(sgCheck);
        }
    }

    /**
     * 核对对比
     *
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
    public PageInfo<SgCheckListVO> selectSgCheckList(String check, String checkDate, String checkUser, String planDate, String planUser, Integer pageNum, Integer pageSize) {
        if (StringUtils.isNotBlank(check)){
            check = StateEnum.getMessageByCode(Integer.parseInt(check));
        }
        Date cDate = null,pDate = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (StringUtils.isNotBlank(planDate)){
            try {
                pDate = simpleDateFormat.parse(planDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (StringUtils.isNotBlank(checkDate)){
            try {
                cDate = simpleDateFormat.parse(checkDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(sgCheckMapper.getListByX(check,cDate,checkUser,pDate,planUser));
    }
}
