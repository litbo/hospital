package com.litbo.hospital.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.DbUtil.IDFormat;
import com.litbo.hospital.security.bean.FwBaoxiu;
import com.litbo.hospital.security.bean.FwLcjl;
import com.litbo.hospital.security.dao.*;
import com.litbo.hospital.security.enums.EnumProcess;
import com.litbo.hospital.security.service.FwBaoxiuService;
import com.litbo.hospital.security.vo.*;
import com.litbo.hospital.supervise.dao.EmpDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author zjc
 * @create 2018-12-03 11:13
 */
@Service
public class FwBaoxiuServiceImpl implements FwBaoxiuService {

    @Autowired
    private FwBaoxiuDao fwBaoxiuDao;

    @Autowired
    private FwLcjlDao fwLcjlDao;

    @Autowired
    private FwShouLiDao fwShouLiDao;

    @Autowired
    private FwWeixiuDao fwWeixiuDao;

    @Autowired
    private FwWxfDao fwWxfDao;

    @Autowired
    private EmpDao empDao;

    @Override
    public FwBxLcVo getBxLcVo(String fwId) {
        FwBxLcVo bxLcVo = fwBaoxiuDao.bxlc(fwId);
        bxLcVo.setFwLcjlList(fwLcjlDao.getLcjlByFwId(bxLcVo.getFwId()));
        return bxLcVo;
    }

    @Override
    public PageInfo getBxLcTable(String userId, Integer pageSize, Integer pageNum,String date,String eqName,Integer bxStatus) throws ParseException {
        PageHelper.startPage(pageNum,pageSize);
        String ksTime = null;
        String jsTime = null;
        if(StringUtils.isNotBlank(date)){
            String[] split = date.split("~");
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            ksTime = split[0];
            Date jsDate = format.parse(split[1]);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(jsDate);
            calendar.add(Calendar.DAY_OF_MONTH,1);
            jsDate = calendar.getTime();
            jsTime = format.format(jsDate);
        }
        PageInfo<FwBxLcTableVo> pageInfo = new PageInfo<FwBxLcTableVo>(fwBaoxiuDao.bxlcTableList(userId,ksTime,jsTime,eqName,bxStatus));
        return pageInfo;
    }

    @Override
    public RepairInfoVo wxInfoIndex() {
        int wslEqCount = fwBaoxiuDao.selectCountByStatus(2);
        int selectCount = fwBaoxiuDao.selectCount();
        int i = fwBaoxiuDao.selectCountByStatus(100);
        RepairInfoVo repairInfoVo = new RepairInfoVo();
        repairInfoVo.setWslEqCount(wslEqCount);
        repairInfoVo.setSlEqCount(selectCount-i-wslEqCount);
        repairInfoVo.setWxEqCount(selectCount-i);
        repairInfoVo.setDJjxEqCount(fwBaoxiuDao.selectJjxCount(1));
        repairInfoVo.setZJjxEqCount(fwBaoxiuDao.selectJjxCount(2));
        repairInfoVo.setGJjxEqCount(fwBaoxiuDao.selectJjxCount(3));
        repairInfoVo.setWxInfoList(fwBaoxiuDao.selectWxInfo());
        return repairInfoVo;
    }

    @Override
    public PageInfo getBaoxiuEq(String userId,Integer pageSize,Integer pageNum,String bmName,String eqName) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<BaoxiuEqVo> pageInfo = new PageInfo<>(fwBaoxiuDao.findBaoxiuEq(userId,bmName,eqName));

        return pageInfo;
    }

    @Override
    public PageInfo baoxiuRw(String userId,Integer pageNum,Integer pageSize,String roleName) {
        List<BaoXiuRw> baoxiuRw = fwBaoxiuDao.findBaoxiuRw(userId, EnumProcess.FW_BX_SL.getCode());
        List<BaoXiuRw> baoxiuRw1 = fwShouLiDao.findBaoxiuRw(userId);
        List<BaoXiuRw> baoxiuRw4 = fwShouLiDao.findBaoxiuRwByBxr(userId);
        String bmId = empDao.getBmIdByUserId(userId);
        List<BaoXiuRw> baoxiuRw2 = null;
        System.out.println(roleName);
        if("设备处长".equals(roleName)||"设备副处长".equals(roleName)){
            baoxiuRw2 = fwWeixiuDao.getBaoXiuRw(bmId);
            baoxiuRw.addAll(baoxiuRw2);
        }
        List<BaoXiuRw> baoxiuRw3 = fwWxfDao.getWxfRw(userId);
        baoxiuRw.addAll(baoxiuRw1);

        baoxiuRw.addAll(baoxiuRw3);
        baoxiuRw.addAll(baoxiuRw4);
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<BaoXiuRw>(baoxiuRw);
    }



    @Override
    public FwBaoxiuIndexVo baoxiuIndex(String eqId, String empId){
            FwBaoxiuIndexVo baoxiuIndexVo = fwBaoxiuDao.findBaoxiuIndexVo(eqId, empId);
            return baoxiuIndexVo;
    }

    @Transactional
    @Override
    public int addBaoxiu(FwBaoxiu fwBaoxiu) {

        String eqStatus = fwBaoxiuDao.eqStatusByEqId(fwBaoxiu.getEqId());
        if("在用".equals(eqStatus)){
            //添加到报修单
            String id = IDFormat.getIdByIDAndTime("fw_baoxiu", "id");
            fwBaoxiu.setId(id);
            fwBaoxiu.setBxTime(new Date());
            fwBaoxiu.setBxStatus(EnumProcess.FW_BX_SL.getCode());
            fwBaoxiuDao.addBaoxiu(fwBaoxiu);
            //添加流程记录
            FwLcjl fwLcjl = new FwLcjl();
            fwLcjl.setUserId(fwBaoxiu.getBxrId());
            fwLcjl.setBxId(id);
            fwLcjl.setCreatTime(new Date());
            fwLcjl.setLc(EnumProcess.FW_GZ_BX.getMessage());
            fwLcjlDao.insertFwLcjl(fwLcjl);
            //设置报修状态
            fwBaoxiuDao.updateEqStatus(fwBaoxiu.getEqId());
            return 1;
        }else{
            return 0;
        }

    }

    @Override
    @Transactional
    public void updateBaoxiuStatusById(String id, Integer baoxiuStatus) {
        fwBaoxiuDao.updateBaoxiuStatus(id,baoxiuStatus);
    }

    @Override
    public PageInfo listWx(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        return new PageInfo(fwBaoxiuDao.listFwBaoxiuVo(EnumProcess.FW_WX_OVER.getCode()));
    }
}
