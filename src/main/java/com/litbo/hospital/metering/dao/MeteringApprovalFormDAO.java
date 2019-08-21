package com.litbo.hospital.metering.dao;


import com.litbo.hospital.metering.pojo.MeteringApprovalForm;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MeteringApprovalFormDAO {
    int deleteByPrimaryKey(Integer formId);

    int insert(MeteringApprovalForm record);

    int insertSelective(MeteringApprovalForm record);

    MeteringApprovalForm selectByPrimaryKey(Integer formId);

    int updateByPrimaryKeySelective(MeteringApprovalForm record);

    int updateByPrimaryKey(MeteringApprovalForm record);

    MeteringApprovalForm selectByFormName(String name);

    // 查找报表
    List<MeteringApprovalForm> searchApprovalForm(@Param("recordBeginTime") String recordBeginTime,@Param("recordEndTime") String recordEndTime,
                                                  @Param("department") String department,@Param("status") String status,
                                                  @Param("dealBeginTime") String dealBeginTime,@Param("dealEndTime") String dealEndTime);



}