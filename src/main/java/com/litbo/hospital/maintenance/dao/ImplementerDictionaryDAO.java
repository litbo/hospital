package com.litbo.hospital.maintenance.dao;

import com.litbo.hospital.maintenance.pojo.ImplementerDictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImplementerDictionaryDAO {
    int insert(ImplementerDictionary record);

    int insertSelective(ImplementerDictionary record);

    ImplementerDictionary selectByName(String name);

    List<ImplementerDictionary> selectByName1(String name);

    int deleteByName(String Name);

    List<String> findAllType(String type);

    List<ImplementerDictionary> selectAll(@Param("type") String type,@Param("value") String value);

}