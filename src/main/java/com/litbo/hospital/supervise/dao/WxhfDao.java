package com.litbo.hospital.supervise.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WxhfDao {
    @Insert("insert into s_gcs_bm (user_id,bm_id) values(#{wxrId},#{bmId})")
    void saveWxrBm(@Param("wxrId") String wxrId,@Param("bmId") String bmId);
    @Delete("delete from s_gcs_bm where bm_id=#{bmId}")
    void wxrBmXcHf(String bmId);
}
