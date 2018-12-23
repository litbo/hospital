package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.FwShouli;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zjc
 * @create 2018-12-05 17:03
 */
@Mapper
public interface FwShouLiDao {


    @Insert("insert into fw_shouli (id, xy_status, gztj_status, \n" +
            "      sl_time, wxfs, slr_id, \n" +
            "      ydwx_time, sl_bz)\n" +
            "    values (#{id,jdbcType=VARCHAR}, #{xyStatus,jdbcType=INTEGER}, #{gztjStatus,jdbcType=INTEGER}, \n" +
            "      #{slTime,jdbcType=TIMESTAMP}, #{wxfs,jdbcType=VARCHAR}, #{slrId,jdbcType=VARCHAR}, \n" +
            "      #{ydwxTime,jdbcType=TIMESTAMP}, #{slBz,jdbcType=LONGVARCHAR})")
    public void addShouLi(FwShouli fwShouli);

    @Select("select * from fw_shouli where id = #{fwId}")
    public FwShouli findShouli(String fwId);

    @Select("select id from fw_shouli where slr_id = #{userId}")
    public List<String> findFwId(String userId);
}
