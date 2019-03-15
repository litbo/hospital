package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.FwWeixiu;
import com.litbo.hospital.security.bean.FwWxqs;
import com.litbo.hospital.security.vo.*;
import org.apache.ibatis.annotations.*;

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

    @Update("update fw_wxqs set qs_shr = #{userId} , qs_shtime = (select GETDATE()) where fw_id = #{fwId}")
    public void updateFwWxsh(@Param("userId") String userId,@Param("fwId") String fwId);

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
            "baoxiu.bx_status = 13")
    public List<BaoXiuRw> getBaoXiuRw(String userId);

    @Select("SELECT\n" +
            "bx.id AS fwId,\n" +
            "eq.eq_name,\n" +
            "dbo.s_emp.user_xm AS bxrName,\n" +
            "bx.bxrdh,\n" +
            "bx.bx_time,\n" +
            "eq.eq_bxjssj,\n" +
            "bx.bxksdh,\n" +
            "bx.jjx_status,\n" +
            "bx.gzxx\n" +
            "FROM\n" +
            "dbo.eq_info AS eq ,\n" +
            "dbo.fw_baoxiu AS bx ,\n" +
            "dbo.s_emp\n" +
            "WHERE\n" +
            "eq.eq_id = bx.eq_id AND\n" +
            "bx.bxr_id = dbo.s_emp.user_id AND\n" +
            "bx.id = #{fwId}")
    public FwWeiXiuIndexVo weixiuIndexVo(String fwId);

    @Select("SELECT\n" +
            "bx.id AS fwId,\n" +
            "eq.eq_name,\n" +
            "bxEmp.user_xm AS bxrName,\n" +
            "slEmp.user_xm AS slrName,\n" +
            "sl.ydwx_time,\n" +
            "wxEmp.user_xm AS wxrName,\n" +
            "bx.gzxx,\n" +
            "wxnr1.wxnrzd_text,\n" +
            "wxnr2.wxnrzd_text,\n" +
            "bx.bx_time,\n" +
            "sl.sl_time,\n" +
            "wx.fwks_time AS wx_time\n" +
            "FROM\n" +
            "dbo.fw_baoxiu AS bx \n" +
            "LEFT JOIN dbo.fw_shouli AS sl ON bx.id = sl.id\n" +
            "LEFT JOIN dbo.fw_weixiu AS wx ON bx.id = wx.fw_id\n" +
            "LEFT JOIN dbo.eq_info AS eq ON bx.eq_id = eq.eq_id\n" +
            "LEFT JOIN dbo.s_emp AS bxEmp ON bx.bxr_id = bxEmp.user_id\n" +
            "LEFT JOIN dbo.s_emp AS slEmp ON sl.slr_id = slEmp.user_id\n" +
            "LEFT JOIN dbo.s_emp AS wxEmp ON wx.wxr_id = wxEmp.user_id\n" +
            "LEFT JOIN fw_wxnrzd AS wxnr1 ON wxnr1.id = wx.gzyy_id\n" +
            "LEFT JOIN fw_wxnrzd AS wxnr2 ON wxnr2.id = gzmx_id\n" +
            "WHERE bx.id = #{fwId}")
    public FwWxqrIndexVo wxqrIndexVo(String fwId);

    @Select("SELECT\n" +
            "bx.id AS fwId,\n" +
            "eq.eq_name,\n" +
            "bxEmp.user_xm AS bxrName,\n" +
            "slEmp.user_xm AS slrName,\n" +
            "sl.ydwx_time,\n" +
            "wxEmp.user_xm AS wxrName,\n" +
            "bx.gzxx,\n" +
            "wxnr1.wxnrzd_text,\n" +
            "wxnr2.wxnrzd_text,\n" +
            "bx.bx_time,\n" +
            "sl.sl_time,\n" +
            "wx.fwks_time AS wx_time,\n" +
            "wxqsEmp.user_xm AS qrName,\n" +
            "wxqs.qs_myd,\n" +
            "wxqs.qs_jg,\n" +
            "wxqs.qs_ms\n" +
            "FROM\n" +
            "dbo.fw_baoxiu AS bx \n" +
            "LEFT JOIN dbo.fw_shouli AS sl ON bx.id = sl.id\n" +
            "LEFT JOIN dbo.fw_weixiu AS wx ON bx.id = wx.fw_id\n" +
            "LEFT JOIN dbo.eq_info AS eq ON bx.eq_id = eq.eq_id\n" +
            "LEFT JOIN dbo.s_emp AS bxEmp ON bx.bxr_id = bxEmp.user_id\n" +
            "LEFT JOIN dbo.s_emp AS slEmp ON sl.slr_id = slEmp.user_id\n" +
            "LEFT JOIN dbo.s_emp AS wxEmp ON wx.wxr_id = wxEmp.user_id\n" +
            "LEFT JOIN fw_wxnrzd AS wxnr1 ON wxnr1.id = wx.gzyy_id\n" +
            "LEFT JOIN fw_wxnrzd AS wxnr2 ON wxnr2.id = gzmx_id\n" +
            "LEFT JOIN fw_wxqs AS wxqs ON wxqs.fw_id = bx.id\n" +
            "LEFT JOIN s_emp AS wxqsEmp ON wxqsEmp.user_id = wxqs.qs_user\n" +
            "WHERE bx.id = #{fwId}\n")
    public FwWxqsShIndexVo wxqsShIndexVo(String fwId);

}
