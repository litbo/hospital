package com.litbo.hospital.user.dao;

import com.litbo.hospital.user.bean.EqPm;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PmDao {
    @Insert("insert into eq_pm (eq_pm_id,eq_pm_name,eq_pm_jc,eq_fl_id,pym,pid,glh) " +
            "      values (#{eqPmId}, #{eqPmName},#{eqPmJc},#{eqFlId},#{pym},#{pid},#{glh})")
    Integer addPm(EqPm eqPm);
    @Select("select * from eq_pm where eq_pm_id =#{id}")
    EqPm getPmById(String id);
}
