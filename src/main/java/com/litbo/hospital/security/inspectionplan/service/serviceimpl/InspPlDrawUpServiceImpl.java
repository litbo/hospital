package com.litbo.hospital.security.inspectionplan.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.inspectionplan.bean.vo.FuchuUpVo;
import com.litbo.hospital.security.inspectionplan.bean.vo.InspEquipmentVo;
import com.litbo.hospital.security.inspectionplan.bean.vo.UserVo;
import com.litbo.hospital.security.inspectionplan.dao.InspPlDrawUpDao;
import com.litbo.hospital.security.inspectionplan.service.InspPlDrawUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 巡检计划制定相关的功能
 *
 * @author 10366 2019-08-03 17:51
 **/
@Service
public class InspPlDrawUpServiceImpl implements InspPlDrawUpService {


    @Autowired
    private InspPlDrawUpDao
            inspPlDrawUpDao;


    /**
     * 功能描述: 查询副处长以上的人员
     *
     * @Param:
     * @Return: List<FuchuUpVo>
     * @Author: ZYJ
     * @Date: 2019/8/3 0003 18:09
     */
    public PageInfo<FuchuUpVo> selectFuchuVos(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(inspPlDrawUpDao.selectFuchuVos());
    }

    /**
     * 功能描述: 查询副处长以上的人员根据名字
     *
     * @Param: name
     * @Return: pageinfo<FuchuUpVo>
     * @Author: ZYJ
     * @Date: 2019/8/4 0004 8:48
     */
    public PageInfo<FuchuUpVo> selectFuchuVosByName(int pageNum, int pageSize, String userXm){
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(inspPlDrawUpDao.selectFuchuVosByName(userXm));
    }

    /**
     * 功能描述: 查询巡检计划制定人
     *
     * @Param:
     * @Return: List<UserVo>
     * @Author: ZYJ
     * @Date: 2019/8/4 0004 9:29
     */
    public PageInfo<UserVo> selectAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(inspPlDrawUpDao.selectAllUser());
    }

    /**
     * 功能描述: 查询巡检计划制定人条件查询
     *
     * @Param: userId userXm bmName
     * @Return: List<UserVo>
     * @Author: ZYJ
     * @Date: 2019/8/4 0004 9:34
     */
    public PageInfo<UserVo> selectUserByUserVo(int pageNum, int pageSize,
                                               String userId, String userXm,
                                               String bmName){
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(inspPlDrawUpDao.selectUserByUserVo(userId, userXm, bmName));
    }

    /**
     * 功能描述: 查询所有在此计划未选中设备
     *
     * @Param:
     * @Return: List<InspEquipmentVo>
     * @Author: ZYJ
     * @Date: 2019/8/4 0004 10:18
     */
    public PageInfo<InspEquipmentVo> selectAllNotSelectionEq(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(inspPlDrawUpDao.selectAllNotSelectionEq());
    }

    /**
     * 功能描述: 查询所有在此计划未选中设备根据eqVo
     *
     * @Param: eqsbbh eqname eqxh bmName
     * @Return: PageInfo<InspEquipmentVo>
     * @Author: ZYJ
     * @Date: 2019/8/5 0005 8:59
     */
    public PageInfo<InspEquipmentVo> selectAllNotSelectionEqByEqVo(int pageNum, int pageSize,
                                                                   String eqSbbh, String eqName,
                                                                   String eqXh, String bmName){
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(inspPlDrawUpDao.selectAllNotSelectionEqByEqVo(eqSbbh,eqName, eqXh, bmName));
    }

    /**
     * 功能描述: 查询所有在此计划选中设备
     *
     * @Param:
     * @Return: List<InspEquipmentVo>
     * @Author: ZYJ
     * @Date: 2019/8/4 0004 10:18
     */
    public PageInfo<InspEquipmentVo> selectAllSelectionEq(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(inspPlDrawUpDao.selectAllSelectionEq());
    }

    /**
     * 功能描述: 查询所有在此计划选中设备根据eqVo
     *
     * @Param: eqsbbh eqname eqxh bmName
     * @Return: PageInfo<InspEquipmentVo>
     * @Author: ZYJ
     * @Date: 2019/8/5 0005 8:59
     */
    public PageInfo<InspEquipmentVo> selectAllSelectionEqByEqVo(int pageNum, int pageSize,
                                                                String eqSbbh, String eqName,
                                                                String eqXh, String bmName){
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(inspPlDrawUpDao.selectAllSelectionEqByEqVo(eqSbbh,eqName, eqXh, bmName));
    }

    /**
     * 功能描述: 巡检计划制定完成后清除选定的设备项
     *
     * @Param:
     * @Return: int
     * @Author: ZYJ
     * @Date: 2019/8/5 0005 14:15
     */
    public int updateSelectionToZero(){
        return inspPlDrawUpDao.updateSelectionToZero();
    }

    public int updateEqSbbh(String eqSbbh){
        return  inspPlDrawUpDao.updateEqInfo(eqSbbh);
    }
    public int updateEqSbbh1(String eqSbbh){
        return  inspPlDrawUpDao.updateEqInfo1(eqSbbh);
    }

}
