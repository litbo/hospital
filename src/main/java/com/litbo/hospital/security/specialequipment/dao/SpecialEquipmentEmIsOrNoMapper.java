package com.litbo.hospital.security.specialequipment.dao;

import com.litbo.hospital.security.specialequipment.bean.SpecialEquipmentEmIsOrNo;
import com.litbo.hospital.security.specialequipment.bean.SpecialEquipmentEmIsOrNoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SpecialEquipmentEmIsOrNoMapper {
    long countByExample(SpecialEquipmentEmIsOrNoExample example);

    int deleteByExample(SpecialEquipmentEmIsOrNoExample example);

    int deleteByPrimaryKey(String userId);

    int insert(SpecialEquipmentEmIsOrNo record);

    int insertSelective(SpecialEquipmentEmIsOrNo record);

    List<SpecialEquipmentEmIsOrNo> selectByExample(SpecialEquipmentEmIsOrNoExample example);

    SpecialEquipmentEmIsOrNo selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") SpecialEquipmentEmIsOrNo record, @Param("example") SpecialEquipmentEmIsOrNoExample example);

    int updateByExample(@Param("record") SpecialEquipmentEmIsOrNo record, @Param("example") SpecialEquipmentEmIsOrNoExample example);

    int updateByPrimaryKeySelective(SpecialEquipmentEmIsOrNo record);

    int updateByPrimaryKey(SpecialEquipmentEmIsOrNo record);
}