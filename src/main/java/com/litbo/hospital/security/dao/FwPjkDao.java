package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.FwPjk;
import org.apache.ibatis.annotations.*;

@Mapper
public interface FwPjkDao {
    @Select("select * from fw_pjk where id = #{id}")
    FwPjk selectFwPjkIsHaveById(Integer id);
    @Update("update fw_pjk set pjk_sl=pjk_sl+#{pjsgCount} where id=#{pjzdId}")
    void addFwPjkSl(@Param("pjzdId") Integer pjzdId, @Param("pjsgCount") Integer pjsgCount);
    @Insert("    insert into fw_pjk (id, pjk_sl, create_time" +
            "      )" +
            "    values (#{id,jdbcType=INTEGER}, #{pjkSl,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}" +
            "      )")
    void insertFwPjk(FwPjk pjk);

    @Update("UPDATE fw_pjk SET pjk_sl=pjk_sl-#{pjCount} WHERE pjk_sl>=#{pjCount} and id = #{pjId}")
    int reduceFwPjkSl(@Param("pjId") Integer pjId, @Param("pjCount") Integer pjCount);
}
