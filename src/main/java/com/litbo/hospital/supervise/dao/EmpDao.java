package com.litbo.hospital.supervise.dao;

import com.litbo.hospital.supervise.bean.SEmp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author zjc
 * @create 2018-12-09 15:23
 */
@Mapper
public interface EmpDao {

    @Select("select * from s_emp where user_id = #{userId}")
    SEmp getEmpByUserId(String userId);

}
