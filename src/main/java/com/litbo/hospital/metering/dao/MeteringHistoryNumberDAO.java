package com.litbo.hospital.metering.dao;

import com.litbo.hospital.metering.pojo.MeteringHistoryNumber;

import java.util.List;

public interface MeteringHistoryNumberDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(MeteringHistoryNumber record);

    int insertSelective(MeteringHistoryNumber record);

    MeteringHistoryNumber selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MeteringHistoryNumber record);

    int updateByPrimaryKey(MeteringHistoryNumber record);

    List<MeteringHistoryNumber> findAllMeteringHistoryNumber(int utilId);
}