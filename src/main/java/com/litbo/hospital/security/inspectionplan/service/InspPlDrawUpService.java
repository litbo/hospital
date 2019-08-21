package com.litbo.hospital.security.inspectionplan.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.inspectionplan.bean.vo.FuchuUpVo;
import com.litbo.hospital.security.inspectionplan.bean.vo.InspEquipmentVo;
import com.litbo.hospital.security.inspectionplan.bean.vo.UserVo;


/**
 * 巡检计划制定相关的功能Service
 *
 * @author 10366 2019-08-03 17:51
 **/
public interface InspPlDrawUpService {


    /**
     * 功能描述: 查询副处长以上的人员
     *
     * @Param:
     * @Return: List<FuchuUpVo>
     * @Author: ZYJ
     * @Date: 2019/8/3 0003 18:09
     */
    PageInfo<FuchuUpVo> selectFuchuVos(int pageNum, int pageSize);

    /**
     * 功能描述: 查询副处长以上的人员根据名字
     *
     * @Param: name
     * @Return: pageinfo<FuchuUpVo>
     * @Author: ZYJ
     * @Date: 2019/8/4 0004 8:48
     */
    PageInfo<FuchuUpVo> selectFuchuVosByName(int pageNum, int pageSize, String userXm);

    /**
     * 功能描述: 查询巡检计划制定人
     *
     * @Param:
     * @Return: List<UserVo>
     * @Author: ZYJ
     * @Date: 2019/8/4 0004 9:29
     */
    PageInfo<UserVo> selectAllUser(int pageNum, int pageSize);

    /**
     * 功能描述: 查询巡检计划制定人条件查询
     *
     * @Param: userId userXm bmName
     * @Return: List<UserVo>
     * @Author: ZYJ
     * @Date: 2019/8/4 0004 9:34
     */
    PageInfo<UserVo> selectUserByUserVo(int pageNum, int pageSize,
                                        String userId, String userXm,
                                        String bmName);

    /**
     * 功能描述: 查询所有在此计划未选中设备
     *
     * @Param:
     * @Return: List<InspEquipmentVo>
     * @Author: ZYJ
     * @Date: 2019/8/4 0004 10:18
     */
    PageInfo<InspEquipmentVo> selectAllNotSelectionEq(int pageNum, int pageSize);


    /**
     * 功能描述: 查询所有在此计划未选中设备根据eqVo
     *
     * @Param: eqsbbh eqname eqxh bmName
     * @Return: PageInfo<InspEquipmentVo>
     * @Author: ZYJ
     * @Date: 2019/8/5 0005 8:59
     */
    PageInfo<InspEquipmentVo> selectAllNotSelectionEqByEqVo(int pageNum, int pageSize,
                                                            String eqSbbh, String eqName,
                                                            String eqXh, String bmName);

    /**
     * 功能描述: 查询所有在此计划选中设备
     *
     * @Param:
     * @Return: List<InspEquipmentVo>
     * @Author: ZYJ
     * @Date: 2019/8/4 0004 10:18
     */
    PageInfo<InspEquipmentVo> selectAllSelectionEq(int pageNum, int pageSize);

    /**
     * 功能描述: 查询所有在此计划选中设备根据eqVo
     *
     * @Param: eqsbbh eqname eqxh bmName
     * @Return: PageInfo<InspEquipmentVo>
     * @Author: ZYJ
     * @Date: 2019/8/5 0005 8:59
     */
    PageInfo<InspEquipmentVo> selectAllSelectionEqByEqVo(int pageNum, int pageSize,
                                                         String eqSbbh, String eqName,
                                                         String eqXh, String bmName);

    /**
     * 功能描述: 巡检计划制定完成后清除选定的设备项
     *
     * @Param:
     * @Return: int
     * @Author: ZYJ
     * @Date: 2019/8/5 0005 14:15
     */
    int updateSelectionToZero();

    int updateEqSbbh(String eqSbbh);
    int updateEqSbbh1(String eqSbbh);

}
