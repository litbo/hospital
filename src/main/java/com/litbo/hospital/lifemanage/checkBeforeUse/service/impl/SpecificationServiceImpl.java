package com.litbo.hospital.lifemanage.checkBeforeUse.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.checkBeforeUse.dao.SpecificationDao;
import com.litbo.hospital.lifemanage.checkBeforeUse.service.SpecificationService;
import com.litbo.hospital.lifemanage.checkBeforeUse.vo.*;
import com.litbo.hospital.operational_data_monitoring.software_interface.dao.EqInfoDAO;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.EqInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
        if (name == null | "".trim().equals(name))
            name = null;
        UserVo userVo = new UserVo();
        userVo.setUserXm(name);
        PageHelper.startPage(pageNum,pageSize);
        List<UserVo> userVos = specificationDao.searchAppointUsers(userVo);
        userVos.forEach(System.out::println);
        PageInfo<UserVo> userVoPageInfo = new PageInfo<>(userVos);
        return userVoPageInfo;
    }

    @Override
    public PageInfo<EqInfoVO2> searchAppointEqInfos(@RequestParam(name="pageNum",required = false ,defaultValue = "1")Integer pageNum,
                                                    @RequestParam(name="pageSize",required = false,defaultValue = "10")Integer pageSize,
                                                    String sbbh, String eqName, String eqPym, String bmName) {
        EqInfoVO2 eqInfoVO2 = new EqInfoVO2();
        if (sbbh == null | "".equals(sbbh))
            sbbh = null;
        if (eqName == null | "".equals(eqName))
            eqName = null;
        if (eqPym == null | "".equals(eqPym))
            eqPym = null;
        if (bmName == null | "".equals(bmName))
            bmName = null;


        eqInfoVO2.setEqSbbh(sbbh);
        eqInfoVO2.setEqName(eqName);
        eqInfoVO2.setEqPym(eqPym);
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
    public List<SearchStandardVO> searchAllStandards2(Integer result) {
        return specificationDao.searchAllStandards(result);
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


            SearchStandardVO standardVO = specificationDao.searchStandard(standardId);
            List<SearchStandardProjectVO> list= specificationDao.searchAllProject(standardId);
            standardVO.setList(list);

            EqInfoVO2 eqInfoVO2 = new EqInfoVO2();

            eqInfoVO2.setEqSbbh(null);
            eqInfoVO2.setEqName(null);
            eqInfoVO2.setEqPym(null);
            eqInfoVO2.setBmName(null);

            List<EqInfoVO2> eqInfos = specificationDao.searchAppointEqInfos(eqInfoVO2);


            EqInfoVO2 eqInfo = specificationDao.searchEqInfosBySbbh(standardVO.getEquipmentNumber());



            List<SaveTaskBufferVO> saveTaskBufferVOS = new ArrayList<>();

            if ("同类设备".equals(standardVO.getApplicableEquipment())){
                System.out.println(eqInfo);
                eqInfos.forEach(System.out::println);
                eqInfos.removeIf(a->!a.getEqSbbh().substring(4,14).equals(eqInfo.getEqSbbh().substring(4,14)));
            }else if ("同厂家同型号".equals(standardVO.getApplicableEquipment())){
                eqInfos.removeIf(a->!(a.getEqXh().equals(eqInfo.getEqXh()) && a.getSbcsIdScs().equals(eqInfo.getSbcsIdScs())
                                    && a.getEqGg().equals(eqInfo.getEqGg())));
            }else if ("全部设备".equals(standardVO.getApplicableEquipment())){

            }else {
                i = 0;
            }
            if (i!=0){
                eqInfos.forEach(e->{
                    list.forEach(l->{
                        SaveTaskBufferVO saveTaskBufferVo = new SaveTaskBufferVO();
                        saveTaskBufferVo.setEquipmentNumber(e.getEqSbbh());
                        saveTaskBufferVo.setOperationId(l.getOperationId());
                        saveTaskBufferVo.setProjectId(l.getProjectId());
                        saveTaskBufferVo.setStandardId(standardId);
                        saveTaskBufferVo.setStandardName(standardVO.getStandardName());
                        saveTaskBufferVOS.add(saveTaskBufferVo);
                    });
                });
                saveTaskBufferVOS.forEach(System.out::println);
                i = specificationDao.saveTaskBuffers(saveTaskBufferVOS);
            }
        }else {
            i = specificationDao.updateStandardCycleDateFalse(standardId);
            i = specificationDao.deleteTaskBufferByStandardId(standardId);
        }




        if (i == 1)
            return "true";
        else
            return "false";
    }

    @Override
    public String deleteTaskBufferByStandardId(Integer standardId) {
        Integer i = specificationDao.deleteTaskBufferByStandardId(standardId);
        if (i == 1)
            return "true";
        else
            return "false";
    }

    @Override
    public PageInfo<SearchStandardTaskVO> searchTodayUnfinishedStandardTask(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        List<SearchStandardTaskVO> searchStandardTaskVOS = specificationDao.searchTodayUnfinishedStandardTask();
        /*searchStandardTaskVOS.forEach(a->{
            if (a.getOperationId().equals("01")){
                if (a.getTaskResult() == 1)
                    a.setResultName("正常");
                else
                    a.setResultName("不正常");
            }else if (a.getOperationId().equals("02")){
                if (a.getTaskResult() == 1)
                    a.setResultName("进行");
                else
                    a.setResultName("未进行");
            }else if (a.getOperationId().equals("03")){
                if (a.getTaskResult() == 1)
                    a.setResultName("处理");
                else
                    a.setResultName("未处理");
            }
        });*/
        PageInfo<SearchStandardTaskVO> searchStandardTaskVOPageInfo = new PageInfo<>(searchStandardTaskVOS);
        return searchStandardTaskVOPageInfo;
    }

    @Override
    public PageInfo<SearchStandardTaskVO> searchTodayFinishedStandardTask(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SearchStandardTaskVO> searchStandardTaskVOS = specificationDao.searchTodayFinishedStandardTask();
        searchStandardTaskVOS.forEach(a->{
            if (a.getOperationId().equals("01")){
                if (a.getTaskResult() == 1)
                    a.setResultName("正常");
                else
                    a.setResultName("不正常");
            }else if (a.getOperationId().equals("02")){
                if (a.getTaskResult() == 1)
                    a.setResultName("进行");
                else
                    a.setResultName("未进行");
            }else if (a.getOperationId().equals("03")){
                if (a.getTaskResult() == 1)
                    a.setResultName("处理");
                else
                    a.setResultName("未处理");
            }
        });
        PageInfo<SearchStandardTaskVO> searchStandardTaskVOPageInfo = new PageInfo<>(searchStandardTaskVOS);
        return searchStandardTaskVOPageInfo;
    }

    @Override
    public String searchStandardTaskResult(Integer taskId, Integer taskResult, String operatorNumber) {
        Integer i = specificationDao.updateStandardTaskResult(taskId,taskResult,operatorNumber);
        if (i == 1)
            return "true";
        else
            return "false";
    }

    @Override
    public PageInfo<SearchStandardTaskVO> searchAppointStandardTasks(int pageNum, int pageSize, Integer standardId, String bmId, String eqName, String eqSbbh,Integer result) {
        PageHelper.startPage(pageNum,pageSize);
        System.out.println(result);
        System.out.println(standardId);
        System.out.println(bmId);
        List<SearchStandardTaskVO> searchStandardTaskVOS =  specificationDao.searchAppointStandardTasks(standardId,bmId,eqName,eqSbbh,result);
        searchStandardTaskVOS.forEach(System.out::println);
        PageInfo<SearchStandardTaskVO> searchStandardTaskVOPageInfo = new PageInfo<>(searchStandardTaskVOS);
        return searchStandardTaskVOPageInfo;
    }

    @Override
    public PageInfo<SearchStandardTaskVO> searchAppointFinishedStandardTasks(int pageNum, int pageSize, Integer standardId, String bmId, String eqName, String eqSbbh,Integer result) {
        PageHelper.startPage(pageNum,pageSize);
        System.out.println(result);
        System.out.println(standardId);
        System.out.println(bmId);
        List<SearchStandardTaskVO> searchStandardTaskVOS =  specificationDao.searchAppointFinishedStandardTasks(standardId,bmId,eqName,eqSbbh,result);
        searchStandardTaskVOS.forEach(System.out::println);
        if (result != null )
            searchStandardTaskVOS.forEach(a->{
                if (a.getOperationId().equals("01")){
                    if (a.getTaskResult() == 1)
                        a.setResultName("正常");
                    else
                        a.setResultName("不正常");
                }else if (a.getOperationId().equals("02")){
                    if (a.getTaskResult() == 1)
                        a.setResultName("进行");
                    else
                        a.setResultName("未进行");
                }else if (a.getOperationId().equals("03")){
                    if (a.getTaskResult() == 1)
                        a.setResultName("处理");
                    else
                        a.setResultName("未处理");
                }
            });
        PageInfo<SearchStandardTaskVO> searchStandardTaskVOPageInfo = new PageInfo<>(searchStandardTaskVOS);
        return searchStandardTaskVOPageInfo;
    }
}
