package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.FwWeixiu;
import com.litbo.hospital.security.bean.FwWxqs;
import com.litbo.hospital.security.vo.BaoXiuRw;
import com.litbo.hospital.security.vo.FwInfoVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

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
            "      #{wxsyTime,jdbcType=DOUBLE}, #{wxPrice,jdbcType=DECIMAL}, #{fzwxId,jdbcType=VARCHAR}, \n" +
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

    @Select("SELECT eq.eq_name,bx.eq_id,bx.bxr_id,emp.user_xm AS bxrName,sl.slr_id,slEmp.user_xm AS slrName,sl.ydwx_time,bx.bx_time,sl.sl_time,\n" +
            "\twx.fwks_time,wxEmp.user_xm AS wxrName,wxgzyy.wxnrzd_text AS gzyy,wxgzmx.wxnrzd_text AS gzmx \n" +
            "FROM dbo.fw_baoxiu AS bx,dbo.eq_info AS eq,dbo.s_emp AS emp,dbo.fw_shouli AS sl,\n" +
            "\tdbo.s_emp AS slEmp,dbo.fw_weixiu AS wx,dbo.s_emp AS wxEmp,dbo.fw_wxnrzd AS wxgzyy,dbo.fw_wxnrzd AS wxgzmx \n" +
            "WHERE\n" +
            "\tbx.eq_id = eq.eq_id AND bx.bxr_id = emp.user_id AND sl.id = bx.id AND slEmp.user_id = sl.slr_id AND wx.fw_id = bx.id \n" +
            "\tAND wxEmp.user_id = wx.wxr_id AND wx.gzyy_id = wxgzyy.id AND wx.gzmx_id = wxgzmx.id AND bx.id = '201812000006'")
    public FwInfoVo findFwInfo(String fwId);

    @Select("SELECT\n" +
            "bm.bm_name,\n" +
            "eq.eq_name,\n" +
            "emp.user_xm,\n" +
            "baoxiu.bx_time,\n" +
            "baoxiu.jjx_status,\n" +
            "eq.eq_id,\n" +
            "baoxiu.bx_status,\n" +
            "baoxiu.id AS fw_id\n" +
            "\n" +
            "FROM\n" +
            "dbo.eq_info AS eq ,\n" +
            "dbo.fw_baoxiu AS baoxiu ,\n" +
            "dbo.fw_wxqs AS wxqs ,\n" +
            "dbo.s_bm AS bm ,\n" +
            "dbo.s_emp AS emp\n" +
            "WHERE\n" +
            "baoxiu.id = wxqs.fw_id AND\n" +
            "eq.eq_id = baoxiu.eq_id AND\n" +
            "baoxiu.bxks_id = bm.bm_id AND\n" +
            "baoxiu.bxr_id = emp.user_id AND\n" +
            "wxqs.qs_shr = #{userId} AND\n" +
            "baoxiu.bx_status = 13")
    public List<BaoXiuRw> getBaoXiuRw(String userId);

}
