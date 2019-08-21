package com.litbo.hospital.security.inspectionplan.service;



import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.inspectionplan.bean.InspEqStandard;


/**
 * 巡检计划标准Service
 *
 * @author Administrator on 2019-07-31
 */
public interface InspPlStandardService {

    InspEqStandard selectStandardById(String inspPlStandardId);
    /**
     * 添加巡检计划标准
     * @param inspEqStandard
     * @return
     */
    int insertInspStandard(InspEqStandard inspEqStandard);

    /**
     * 功能描述: 删除巡检计划标准
     *
     * @Param: inspPlStandardIds
     * @Return: int
     * @Author: ZYJ
     * @Date: 2019/8/1 0001 9:51
     */
    int deleteInspStandard(String[] inspPlStandardIds);

    /**
     * 功能描述: 修改巡检计划标准
     *
     * @Param: inspEqStandard
     * @Return: int
     * @Author: ZYJ
     * @Date: 2019/8/1 0001 10:06
     */
    int updateInspStandard(InspEqStandard inspEqStandard);

    /**
     * 查询所有巡检计划标准
     *
     * @return PageInfo
     */
    PageInfo<InspEqStandard> selectInspEqStandard(int pageNum, int pageSize,
                                                  String inspPlStandardName);

    /**
     * 查询所有巡检计划标准
     *
     * @return PageInfo
     */
    PageInfo<InspEqStandard> selectAllInspEqStandard(int pageNum, int pageSize);



}
