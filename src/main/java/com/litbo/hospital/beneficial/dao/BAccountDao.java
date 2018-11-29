package com.litbo.hospital.beneficial.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BAccountDao {

    int insertAccount(String fkmName);
}
