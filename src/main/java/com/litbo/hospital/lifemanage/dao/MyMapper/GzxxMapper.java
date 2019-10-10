package com.litbo.hospital.lifemanage.dao.MyMapper;

import com.litbo.hospital.lifemanage.bean.MyBean.Gzxx;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GzxxMapper {
    @Select("select id,gznr from gzxx")
    List<Gzxx> selectAllczxx();


}