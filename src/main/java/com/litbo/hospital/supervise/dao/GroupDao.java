package com.litbo.hospital.supervise.dao;

import com.litbo.hospital.supervise.bean.SGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GroupDao {
    @Select("select group_id, bm_id, group_name, user_id1, create_time, user_id2, sh_time, sh_flag from s_group")
    public List<SGroup> getGroups() ;
    @Select("select group_id, bm_id, group_name, user_id1, create_time, user_id2, sh_time, sh_flag from s_group where group_id=#{group_id}")
    SGroup getGroupById(String group_id);
}
