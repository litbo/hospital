package com.litbo.hospital.lifemanage.checkBeforeUse.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.checkBeforeUse.vo.*;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.EqInfoVO;

import java.time.LocalDate;
import java.util.List;


public interface SpecificationService {
    PageInfo<EqInfoVO2> searchEqInfos(Integer pageNum, Integer pageSize);

    PageInfo<UserVo> searchUsers(Integer pageNum,Integer pageSize);

    PageInfo<UserVo> searchAppointUsers(Integer pageNum,Integer pageSize,String name);

    PageInfo<EqInfoVO2> searchAppointEqInfos(Integer pageNum, Integer pageSize, String sbbh, String eqName, String eqPym, String bmName);

    Integer saveStandard(SaveStandardVO saveStandardVO);

    Integer saveStandardProject(Integer standardId, List<SaveStandardProjectVO> list);

    PageInfo<SearchStandardVO> searchAllStandards(Integer pageNum, Integer pageSize,Integer result);

    SearchStandardVO searchStandard(Integer standardId);

    String updateStandardResult(Integer standardId,Integer result);

    String deleteTaskBufferByStandardId(Integer standardId);

    PageInfo<SearchStandardTaskVO> searchTodayUnfinishedStandardTask(int pageNum, int pageSize);

    PageInfo<SearchStandardTaskVO> searchTodayFinishedStandardTask(int pageNum, int pageSize);

    String searchStandardTaskResult(Integer taskId, Integer taskResult, String operatorNumber);

    PageInfo<SearchStandardTaskVO> searchAppointStandardTasks(int pageNum, int pageSize, Integer standardId, String bmId, String eqName, String eqSbbh,Integer result);

    PageInfo<SearchStandardTaskVO> searchAppointFinishedStandardTasks(int pageNum, int pageSize, Integer standardId, String bmId, String eqName, String eqSbbh,Integer result);

    List<SearchStandardVO> searchAllStandards2(Integer result);

    PageInfo<TaskEqVo> searchTaskEqs(int pageNum, int pageSize, String bmId,int r);


    List<SearchStandardTaskVO> searchUnFinishedEqTask(String eqSbbh);

    List<SearchStandardTaskVO> searchFinishedEqTask(String eqSbbh);

    int saveTaskResult(List<SearchStandardTaskVO> list);

    List<BmTaskEqVO> searchBmTaskEqsByDay();

    List<BmTaskEqVO> searchUseForBmEqByDate(LocalDate startDate, LocalDate endDate,String bmId,String bmName);
}
