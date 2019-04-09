package com.litbo.hospital.user.dao;

import com.litbo.hospital.user.bean.EqPm;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PmDao {
    @Insert("insert into eq_pm (eq_pm_id,eq_pm_name,cpms,yqyt,pym,pid,glh) " +
            "      values (#{eqPmId}, #{eqPmName},#{cpms},#{yqyt},#{pym},#{pid},#{glh})")
    Integer addPm(EqPm eqPm);
    @Select("select * from eq_pm where eq_pm_id =#{id}")
    EqPm getPmById(String id);
}
