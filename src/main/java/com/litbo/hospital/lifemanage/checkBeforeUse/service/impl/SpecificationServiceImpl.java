package com.litbo.hospital.lifemanage.checkBeforeUse.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.checkBeforeUse.dao.SpecificationDao;
import com.litbo.hospital.lifemanage.checkBeforeUse.service.SpecificationService;
import com.litbo.hospital.lifemanage.checkBeforeUse.vo.*;
import com.litbo.hospital.operational_data_monitoring.software_interface.dao.EqInfoDAO;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.EqInfoVO;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.*;

@Service("SpecificationService")
public class SpecificationServiceImpl implements SpecificationService {



    @Autowired
    private EqInfoDAO eqInfoDAO;

    @Autowired
    private SpecificationDao specificationDao;

    @Override
    public PageInfo<EqInfoVO> searchEqInfos(@RequestParam(name="pageNum",required = false,defaultValue = "1")Integer pageNum,
                                        @RequestParam(name="pageSize",required = false,defaultValue = "10")Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<EqInfoVO> eqInfoVOS = eqInfoDAO.selectAll();
        PageInfo<EqInfoVO> eqInfoVOPageInfo = new PageInfo<>(eqInfoVOS);
        return eqInfoVOPageInfo;
    }

    @Override
    public PageInfo<UserVo> searchUsers(@RequestParam(name="pageNum",required = false,defaultValue = "1")Integer pageNum,
                                    @RequestParam(name="pageSize",required = false,defaultValue = "10")Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<UserVo> userVos = specificationDao.searchUsers();
        PageInfo<UserVo> userVoPageInfo = new PageInfo<>(userVos);
        return userVoPageInfo;
    }

    @Override
    public PageInfo<UserVo> searchAppointUsers(@RequestParam(name="pageNum",required = false ,defaultValue = "1") Integer pageNum,
                                            @RequestParam(name="pageSize",required = false,defaultValue = "10")Integer pageSize,
                                               String name) {
        if (name == null | name.trim().equals(""))
            name = null;
        UserVo userVo = new UserVo();
        userVo.setUserXm(name);
        PageHelper.startPage(pageNum,pageSize);
        List<UserVo> userVos = specificationDao.searchAppointUsers(userVo);
        PageInfo<UserVo> userVoPageInfo = new PageInfo<>(userVos);
        return userVoPageInfo;
    }

    @Override
    public PageInfo<EqInfoVO2> searchAppointEqInfos(@RequestParam(name="pageNum",required = false ,defaultValue = "1")Integer pageNum,
                                                    @RequestParam(name="pageSize",required = false,defaultValue = "10")Integer pageSize,
                                                    String sbbh, String eqName, String pym, String bmName) {
        EqInfoVO2 eqInfoVO2 = new EqInfoVO2();
        if (sbbh == null | sbbh.trim().equals(""))
            sbbh = null;
        if (eqName == null | eqName.trim().equals(""))
            eqName = null;
        if (pym == null | pym.trim().equals(""))
            pym = null;
        if (bmName == null | bmName.trim().equals(""))
            bmName = null;


        eqInfoVO2.setEqSbbh(sbbh);
        eqInfoVO2.setEqName(eqName);
        eqInfoVO2.setPym(pym);
        eqInfoVO2.setBmName(bmName);


        PageHelper.startPage(pageNum,pageSize);
        List<EqInfoVO2> eqInfos = specificationDao.searchAppointEqInfos(eqInfoVO2);
        PageInfo<EqInfoVO2> eqInfoPageInfo = new PageInfo<>(eqInfos);
        return eqInfoPageInfo;
    }

    @Override
    public Integer saveStandard(SaveStandardVO saveStandardVO) {
        Integer judge = specificationDao.saveStandard(saveStandardVO);
        Integer standardId = specificationDao.searchTheLastStandard();
        return standardId;
    }

    @Override
    public Integer saveStandardProject(Integer standardId, List<SaveStandardProjectVO> list) {
        Integer judge = specificationDao.saveStandardProject(standardId,list);
        return judge;
    }

    @Override
    public PageInfo<SearchStandardVO> searchAllStandards(@RequestParam(name="pageNum",required = false ,defaultValue = "1")Integer pageNum,
                                                         @RequestParam(name="pageSize",required = false ,defaultValue = "10")Integer pageSize,
                                                         Integer result) {



        PageHelper.startPage(pageNum,pageSize);
        List<SearchStandardVO> searchAllStandards = specificationDao.searchAllStandards(result);

        searchAllStandards.forEach(s->{
            List<SearchStandardProjectVO> list= specificationDao.searchAllProject(s.getStandardId());
            s.setList(list);
        });



        PageInfo<SearchStandardVO> standardVOPageInfo = new PageInfo<>(searchAllStandards);
        return standardVOPageInfo;
    }

    @Override
    public SearchStandardVO searchStandard(Integer standardId) {
        SearchStandardVO standardVO = specificationDao.searchStandard(standardId);
        List<SearchStandardProjectVO> searchStandardProjectVOS = specificationDao.searchAllProject(standardVO.getStandardId());

        standardVO.setList(searchStandardProjectVOS);
        return standardVO;
    }

    @Override
    public String updateStandardResult(Integer standardId,Integer result) {
        Integer i = specificationDao.updateStandardResult(standardId,result);
        if (result == 1){
            i = specificationDao.updateStandardCycleDateTrue(standardId);
        }else {
            i = specificationDao.updateStandardCycleDateFalse(standardId);
        }

        if (i == 1)
            return "true";
        else
            return "false";
    }
}
