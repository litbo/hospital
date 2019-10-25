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

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Stream;

@Service("SpecificationService")
public class SpecificationServiceImpl implements SpecificationService {



    @Autowired
    private EqInfoDAO eqInfoDAO;

    @Autowired
    private SpecificationDao specificationDao;

    @Override
    public PageInfo<EqInfoVO2> searchEqInfos(@RequestParam(name="pageNum",required = false,defaultValue = "1")Integer pageNum,
                                        @RequestParam(name="pageSize",required = false,defaultValue = "10")Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);


        List<EqInfoVO2> eqInfoVO2s = specificationDao.searchAllEqInfo();
        List<SearchStandardEqVo> searchAllStandardEqVos = specificationDao.searchAllStandardEqVos();
        for (SearchStandardEqVo s : searchAllStandardEqVos){
            eqInfoVO2s.removeIf(a->a.getEqSbbh().equals(s.getEqSbbh()));
            if (s.getApplicableEquipment().equals("同类设备")){
                eqInfoVO2s.removeIf(a->a.getEqSbbh().substring(4,14).equals(s.getEqSbbh().substring(4,14)));
            }else if (s.getApplicableEquipment().equals("同厂家同型号")){
                eqInfoVO2s.removeIf(a->{
                    if (a.getSbcsIdScs() == null || a.getEqGg() == null || a.getEqXh() == null || s == null)
                        return false;
                    else{
                        if ((a.getEqXh().equals(s.getEqXh()) && a.getSbcsIdScs().equals(s.getSbcsIdScs())
                                && a.getEqGg().equals(s.getEqGg())))
                            return true;
                        else
                            return false;
                    }
                });
            }else{
                eqInfoVO2s.removeIf(a->true);
            }
        }
        PageInfo<EqInfoVO2> eqInfoVOPageInfo = new PageInfo<>(eqInfoVO2s);
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
                eqInfos.removeIf(a->{
                    if (a.getSbcsIdScs() == null || a.getEqGg() == null || a.getEqXh() == null || eqInfo == null)
                        return true;
                    else{
                        if ((a.getEqXh().equals(eqInfo.getEqXh()) && a.getSbcsIdScs().equals(eqInfo.getSbcsIdScs())
                                && a.getEqGg().equals(eqInfo.getEqGg())))
                            return false;
                        else
                            return true;
                    }
                });
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
                if (saveTaskBufferVOS.size()>0)
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

    @Override
    public PageInfo<TaskEqVo> searchTaskEqs(int pageNum, int pageSize, String bmId,int r) {
        PageHelper.startPage(pageNum,pageSize);
        List<TaskEqVo> taskEqVos = null;
        if (r == 0)
            taskEqVos = specificationDao.searchUnFinishedTaskEqs(bmId);
        else
            taskEqVos = specificationDao.searchFinishedTaskEqs(bmId);

        PageInfo<TaskEqVo> taskEqVoPageInfo = new PageInfo<>(taskEqVos);
        return taskEqVoPageInfo;
    }


    @Override
    public List<SearchStandardTaskVO> searchUnFinishedEqTask(String eqSbbh) {
        return specificationDao.searchTodayUnfinishedStandardTaskByEqSbbh(eqSbbh);
    }

    @Override
    public List<SearchStandardTaskVO> searchFinishedEqTask(String eqSbbh) {
        List<SearchStandardTaskVO> searchStandardTaskVOS = specificationDao.searchTodayFinishedStandardTaskByEqSbbh(eqSbbh);
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
        return searchStandardTaskVOS;
    }



    @Override
    public int saveTaskResult(List<SearchStandardTaskVO> list) {
        list.forEach(l->{
            specificationDao.updateStandardTaskResult(l.getTaskId(),l.getTaskResult(),l.getOperatorNumber());
        });
        return 0;
    }


    @Override
    public List<BmTaskEqVO> searchBmTaskEqsByDay(){
        List<BmTaskEqVO> list = specificationDao.searchAllTaskBm();
        list.forEach(bte->{
            bte.setDate(LocalDate.now().minusDays(1));
            int eqTotal = specificationDao.searchEqTotal(bte.getBmId(),LocalDate.now().minusDays(1));
            bte.setTotalEqs(eqTotal);
            int notDoneTotal = specificationDao.searchNotDoneEqTotal(bte.getBmId(),LocalDate.now().minusDays(1));
            bte.setDoneEqs(eqTotal - notDoneTotal);
            bte.setEnforced((eqTotal-notDoneTotal)*1.0/eqTotal);
        });

        return list;
    }


    @Override
    public List<BmTaskEqVO> searchUseForBmEqByDate(LocalDate startDate, LocalDate endDate,String bmId,String bmName) {
        List<BmTaskEqVO> list = new ArrayList<>();
        long distance = ChronoUnit.DAYS.between(startDate, endDate);
        if (distance < 1) {
            return list;
        }
        Stream.iterate(startDate, d -> {
            return d.plusDays(1);
        }).limit(distance + 1).forEach(f -> {
            BmTaskEqVO bte = new BmTaskEqVO();

            bte.setBmId(bmId);
            bte.setBmName(bmName);
            bte.setDate(f);

            Integer eqTotal = specificationDao.searchEqTotal(bte.getBmId(),f);
            if (eqTotal == null)
                eqTotal = 0;
            bte.setTotalEqs(eqTotal);
            Integer notDoneTotal = specificationDao.searchNotDoneEqTotal(bte.getBmId(),f);
            if (notDoneTotal == null)
                notDoneTotal = 0;
            bte.setDoneEqs(eqTotal - notDoneTotal);
            if (eqTotal == 0)
                bte.setEnforced(0);
            else
                bte.setEnforced((eqTotal-notDoneTotal)*1.0/eqTotal);


            list.add(bte);
        });
        return list;
    }
}
