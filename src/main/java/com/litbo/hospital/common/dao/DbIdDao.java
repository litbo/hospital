package com.litbo.hospital.common.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * @author zjc
 * @create 2018-11-29 15:28
 */
@Mapper
public interface DbIdDao {


    @SelectProvider(type = DbIdProvider.class,method = "queryDbId")
    public String getEndId(String DbTable,String idName);

}
