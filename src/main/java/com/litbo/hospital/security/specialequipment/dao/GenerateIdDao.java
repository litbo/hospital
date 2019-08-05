package com.litbo.hospital.security.specialequipment.dao;


import com.litbo.hospital.security.specialequipment.dao.provider.GenerateIdProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

@Mapper
public interface GenerateIdDao {

    @SelectProvider(type = GenerateIdProvider.class,method = "queryGenerateId")
    String getEndId(String DbTable, String idName);

}
