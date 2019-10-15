package com.litbo.hospital.security.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PxDelAndSelDao {
    @Delete("<script>DELETE FROM jh_yypx WHERE id IN <foreach item='item' index='index' " +
            "collection='array' open='(' separator=',' close=')'>" +
            "#{item}</foreach></script>")
    Integer DelRyjh();

    @Delete("<script>DELETE FROM jh_zd WHERE id IN <foreach item='item' index='index' " +
            "collection='array' open='(' separator=',' close=')'>" +
            "#{item}</foreach></script>")
    Integer DelYyjh();
}
