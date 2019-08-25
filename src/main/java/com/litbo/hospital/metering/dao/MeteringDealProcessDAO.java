package com.litbo.hospital.metering.dao;

import com.litbo.hospital.metering.pojo.MeteringDealProcess;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MeteringDealProcessDAO {
    int deleteByPrimaryKey(Integer processId);

    int insert(MeteringDealProcess record);

    int insertSelective(MeteringDealProcess record);

    MeteringDealProcess selectByPrimaryKey(Integer processId);

    int updateByPrimaryKeySelective(MeteringDealProcess record);

    int updateByPrimaryKey(MeteringDealProcess record);

    // 查询已处理流程
    List<MeteringDealProcess> searchDealProcess(@Param("recordBeginTime") String recordBeginTime, @Param("recordEndTime") String recordEndTime,
                                                @Param("department") String department, @Param("status") String status,
                                                @Param("dealBeginTime") String dealBeginTime, @Param("dealEndTime") String dealEndTime);

    // 查询未处理流程
    List<MeteringDealProcess> searchDealProcessNot(@Param("recordBeginTime") String recordBeginTime,
                                                   @Param("recordEndTime") String recordEndTime,
                                                   @Param("department") String department);


    // 查询所有已经通过审批的流程中包含的设备id
    List<String> seeAllUtilsMeteringUtil();

}