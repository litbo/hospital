package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.FwWeixiu;
import com.litbo.hospital.security.bean.FwWxqs;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author zjc
 * @create 2018-12-06 12:38
 */
@Mapper
public interface FwWeixiuDao {

    @Insert("insert into fw_weixiu (fw_id, xxsb_status, gzpc, \n" +
            "      gzyy_id, gzmx_id, gzbw_id, \n" +
            "      gzwx_fs, wxgznr, wxr_id, \n" +
            "      wxsy_time, wx_price, fzwx_id, \n" +
            "      wxjg, gcsjy, zj_status, \n" +
            "      gztj_time, fwks_time, pcwc_time\n" +
            "      )\n" +
            "    values (#{fwId,jdbcType=VARCHAR}, #{xxsbStatus,jdbcType=INTEGER}, #{gzpc,jdbcType=VARCHAR}, \n" +
            "      #{gzyyId,jdbcType=INTEGER}, #{gzmxId,jdbcType=INTEGER}, #{gzbwId,jdbcType=INTEGER}, \n" +
            "      #{gzwxFs,jdbcType=INTEGER}, #{wxgznr,jdbcType=INTEGER}, #{wxrId,jdbcType=VARCHAR}, \n" +
            "      #{wxsyTime,jdbcType=DOUBLE}, #{wxPrice,jdbcType=DECIMAL}, #{fzwxId,jdbcType=INTEGER}, \n" +
            "      #{wxjg,jdbcType=VARCHAR}, #{gcsjy,jdbcType=VARCHAR}, #{zjStatus,jdbcType=INTEGER}, \n" +
            "      #{gztjTime,jdbcType=TIMESTAMP}, #{fwksTime,jdbcType=TIMESTAMP}, #{pcwcTime,jdbcType=TIMESTAMP}\n" +
            "      )")
    public void addFwWeiXiu(FwWeixiu fwWeixiu);

    @Insert("insert into fw_wxqs (fw_id, qs_user, qs_shr, \n" +
            "      qs_myd, qs_jg, qs_shtime, \n" +
            "      qs_qzurl, qs_ms)\n" +
            "    values (#{fwId,jdbcType=VARCHAR}, #{qsUser,jdbcType=VARCHAR}, #{qsShr,jdbcType=VARCHAR}, \n" +
            "      #{qsMyd,jdbcType=VARCHAR}, #{qsJg,jdbcType=VARCHAR}, #{qsShtime,jdbcType=TIMESTAMP}, \n" +
            "      #{qsQzurl,jdbcType=VARCHAR}, #{qsMs,jdbcType=LONGVARCHAR})")
    public void addFwWxqr(FwWxqs fwWxqs);

    @Update("update fw_wxqs set qsShr = #{userId} and qs_shtime = (select GETDATE()) where fw_id = #{fwId}")
    public void updateFwWxsh(String userId,String fwId);

    @Select("select * from fw_weixiu where fw_id = #{fwId}")
    public FwWeixiu findWeixiuOne(String fwId);

}
