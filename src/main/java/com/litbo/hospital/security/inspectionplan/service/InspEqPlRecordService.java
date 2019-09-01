package com.litbo.hospital.security.inspectionplan.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.inspectionplan.bean.InspEqPlanRecord;
import com.litbo.hospital.security.inspectionplan.bean.vo.RecordSelectVo.InspEqPlRecordVo;
import com.litbo.hospital.security.inspectionplan.bean.vo.RecordSelectVo.InspRecordLookVo;
import com.litbo.hospital.security.inspectionplan.bean.vo.RecordSelectVo.InspSelectPlanVo;
import com.litbo.hospital.security.inspectionplan.bean.vo.RecordSelectVo.PLanAndNowExecuteRecordVo;
import com.litbo.hospital.security.inspectionplan.bean.vo.SelectRecordVo;
import com.litbo.hospital.security.inspectionplan.bean.vo.UserVo1;

import java.util.Date;

/**
 * @author 10366 2019-08-26 23:11
 **/
public interface InspEqPlRecordService {


    PageInfo<UserVo1> selectUserByUserVo(int pageNum, int pageSize, String userId, String userXm, String bmName);
    PageInfo<UserVo1> selectAllUser(int pageNum, int pageSize);

    /**
     * 功能描述: 查询 往日此巡检计划的巡检记录
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/31 0031 10:13
     */
    PageInfo<PLanAndNowExecuteRecordVo> selectPLanAndNowExecuteRecordVoByCondition(int pageNum, int pageSize,
                                                                            String inspPlId, String beginTime1,
                                                                                   String endTime1, String beginTime2,
                                                                                   String endTime2);

    /**
     * 功能描述: 查询 往日此巡检计划的巡检记录
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/31 0031 10:13
     */
    PageInfo<PLanAndNowExecuteRecordVo> selectPLanAndNowExecuteRecordVoById(int pageNum, int pageSize,
                                                                            String inspPlId);

    /**
     * 功能描述: 根据记录id查询巡检记录
     *
     * @Param: inspReId
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/28 0028 10:22
     */
    InspRecordLookVo selectRecordByRecordId(String inspReId);

    /**
     * 功能描述: 查看录入结果Vo
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/28 0028 0:09
     */
    PageInfo<SelectRecordVo> selectRecordVoByCondition(int pageNum, int pageSize,
                                                       String inspPlName, String eqName,
                                                       String bmName, String beginTime,
                                                       String endTime);

    /**
     * 功能描述: 查看录入结果Vo
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/28 0028 0:09
     */
    PageInfo<SelectRecordVo> selectRecordVo(int pageNum, int pageSize);

    /**
     * 功能描述: 结果录入查询巡检计划
     *
     * @Param: inspPlId
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/27 0027 0:19
     */
    InspSelectPlanVo selectInspPlById(String inspPlId);

    /**
     * 功能描述: 保存巡检计划
     *
     * @Param: InspEqPlanRecord
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/27 0027 8:44
     */
    void insertInspRecord(InspEqPlRecordVo inspEqPlRecordVo,
                          String executor);



}
