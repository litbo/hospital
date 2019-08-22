package com.litbo.hospital.metering.dao;

import com.litbo.hospital.metering.pojo.MeteringUtilStatus;

public interface MeteringUtilStatusDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(MeteringUtilStatus record);

    MeteringUtilStatus selectByUtilId(Integer id);

    int insertSelective(MeteringUtilStatus record);

    MeteringUtilStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MeteringUtilStatus record);

    int updateByPrimaryKey(MeteringUtilStatus record);
}