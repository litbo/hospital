package com.litbo.hospital.security.specialequipment.dao;

import com.litbo.hospital.security.specialequipment.bean.SpecialEquipmentEmployee;
import com.litbo.hospital.security.specialequipment.bean.SpecialEquipmentEmployeeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SpecialEquipmentEmployeeMapper {
    long countByExample(SpecialEquipmentEmployeeExample example);

    int deleteByExample(SpecialEquipmentEmployeeExample example);

    int deleteByPrimaryKey(String userId);

    int insert(SpecialEquipmentEmployee record);

    int insertSelective(SpecialEquipmentEmployee record);

    List<SpecialEquipmentEmployee> selectByExampleWithBLOBs(SpecialEquipmentEmployeeExample example);

    List<SpecialEquipmentEmployee> selectByExample(SpecialEquipmentEmployeeExample example);

    SpecialEquipmentEmployee selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") SpecialEquipmentEmployee record, @Param("example") SpecialEquipmentEmployeeExample example);

    int updateByExampleWithBLOBs(@Param("record") SpecialEquipmentEmployee record, @Param("example") SpecialEquipmentEmployeeExample example);

    int updateByExample(@Param("record") SpecialEquipmentEmployee record, @Param("example") SpecialEquipmentEmployeeExample example);

    int updateByPrimaryKeySelective(SpecialEquipmentEmployee record);

    int updateByPrimaryKeyWithBLOBs(SpecialEquipmentEmployee record);

    int updateByPrimaryKey(SpecialEquipmentEmployee record);
}