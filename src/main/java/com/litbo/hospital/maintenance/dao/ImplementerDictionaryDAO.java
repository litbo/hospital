package com.litbo.hospital.maintenance.dao;

import com.litbo.hospital.maintenance.pojo.ImplementerDictionary;

import java.util.List;

public interface ImplementerDictionaryDAO {
    int insert(ImplementerDictionary record);

    int insertSelective(ImplementerDictionary record);

    ImplementerDictionary selectByName(String name);

    int deleteByName(String Name);

    List<String> findAllType();

}