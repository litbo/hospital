package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.FwWxnrzd;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FwWxnrzdDao {
    @Select("SELECT id,wxnrzd_text,parent_id,type FROM fw_wxnrzd WHERE parent_id = #{parentId}")
    List<FwWxnrzd> selectFwWxnrzd(int parentId);
}
