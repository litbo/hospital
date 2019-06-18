package com.litbo.hospital.security.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.bean.FwBaoxiu;
import com.litbo.hospital.security.vo.FwBaoxiuIndexVo;
import com.litbo.hospital.security.vo.FwBxLcVo;
import com.litbo.hospital.security.vo.RepairInfoVo;

import java.text.ParseException;

/**
 * @author zjc
 * @create 2018-12-03 11:01
 * 报修单
 */
public interface FwBaoxiuService {

    /**
     * 报修流程详情
     * @param userId
     * @return
     */
    public FwBxLcVo getBxLcVo(String userId);

    /**
     * 报修流程
     * @param userId
     * @param pageSize
     * @param pageNum
     * @return
     */
    public PageInfo getBxLcTable(String userId, Integer pageSize, Integer pageNum,String date,String eqName,Integer bxStatus) throws ParseException;

    /**
     * 维修信息显示
     * @return
     */
    public RepairInfoVo wxInfoIndex();


    /**
     * 报修设备
     * @param userId
     * @return
     */
    public PageInfo getBaoxiuEq(String userId, Integer pageSize, Integer pageNum,String bmName,String eqName);


    /**
     * 维修任务
     * @param userId
     * @return
     */
    public PageInfo baoxiuRw(String userId,Integer pageNum,Integer pageSize , String roleName);

    public FwBaoxiuIndexVo baoxiuIndex(String eqId, String empId);

    /**
     * 添加保修单
     * @param fwBaoxiu
     */
    public void addBaoxiu(FwBaoxiu fwBaoxiu);

    /**
     * 根据报修单修改状态
     * @param id
     * @param baoxiuStatus
     */
    public void updateBaoxiuStatusById(String id,Integer baoxiuStatus);

    PageInfo listWx(int pageNum, int pageSize);
}
