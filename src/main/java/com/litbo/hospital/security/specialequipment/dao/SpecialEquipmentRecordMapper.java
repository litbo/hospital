package com.litbo.hospital.security.specialequipment.dao;

import com.litbo.hospital.security.specialequipment.bean.SpecialEquipmentRecord;
import com.litbo.hospital.security.specialequipment.bean.SpecialEquipmentRecordExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SpecialEquipmentRecordMapper {
    long countByExample(SpecialEquipmentRecordExample example);

    int deleteByExample(SpecialEquipmentRecordExample example);

    int deleteByPrimaryKey(String speqJglrid);

    int insert(SpecialEquipmentRecord record);

    int insertSelective(SpecialEquipmentRecord record);

    List<SpecialEquipmentRecord> selectByExample(SpecialEquipmentRecordExample example);

    SpecialEquipmentRecord selectByPrimaryKey(String speqJglrid);

    int updateByExampleSelective(@Param("record") SpecialEquipmentRecord record, @Param("example") SpecialEquipmentRecordExample example);

    int updateByExample(@Param("record") SpecialEquipmentRecord record, @Param("example") SpecialEquipmentRecordExample example);

    int updateByPrimaryKeySelective(SpecialEquipmentRecord record);

    int updateByPrimaryKey(SpecialEquipmentRecord record);
}