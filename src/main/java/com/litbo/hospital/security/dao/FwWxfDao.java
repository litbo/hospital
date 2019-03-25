package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.FwWxf;
import com.litbo.hospital.security.dao.sqlprovider.FwWxfProvider;
import com.litbo.hospital.security.dao.sqlprovider.WxfProvider;
import com.litbo.hospital.security.vo.*;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * @author zjc
 * @create 2018-12-09 9:00
 */
@Mapper
public interface FwWxfDao {

    @Insert("insert into fw_wxf (user1_id, fw_id, \n" +
            "      wxf_sqtime, wxf_rgf, wxf_cjrgf, \n" +
            "      user2_id, wxf_status, wxf_sptime, \n" +
            "      wxf_spyj)\n" +
            "    values (#{user1Id,jdbcType=VARCHAR}, #{fwId,jdbcType=VARCHAR}, \n" +
            "      #{wxfSqtime,jdbcType=TIMESTAMP}, #{wxfRgf,jdbcType=DOUBLE}, #{wxfCjrgf,jdbcType=DOUBLE}, \n" +
            "      #{user2Id,jdbcType=VARCHAR}, #{wxfStatus,jdbcType=INTEGER}, #{wxfSptime,jdbcType=TIMESTAMP}, \n" +
            "      #{wxfSpyj,jdbcType=LONGVARCHAR})")
    @Options(keyColumn = "id",useGeneratedKeys = true)
    public void addFwWxf(FwWxf fwWxf);

    @Update("update fw_wxf set user2_id = #{userId} , wxf_status = #{status} , wxf_spyj = #{spyj}, " +
            " wxf_sptime = (SELECT GETDATE()) where fw_id = #{fwId}")
    public void updateFwWxf(@Param("userId") String userId, @Param("status") int status,
                            @Param("spyj") String spyj, @Param("fwId") String fwId);

    @Select("select * from fw_wxf where id = #{id}")
    public FwWxf findWxf(int id);

    @Select("SELECT\n" +
            "shouli.id fwId ,\n" +
            "baoxiu.id fwIdValue\n" +
            "FROM\n" +
            "dbo.fw_shouli AS shouli ,\n" +
            "dbo.fw_baoxiu AS baoxiu\n" +
            "WHERE\n" +
            "shouli.slr_id = #{userId} AND\n" +
            "baoxiu.bx_status =  100 AND\n" +
            "shouli.id = baoxiu.id")
    public List<FwIdSelectVo> wxfGetEq(String userId);

    @SelectProvider(type = FwWxfProvider.class,method = "WxfList")
    public List<WxfListVo> WxfList(@Param("userId") String userId,@Param("fwId") String fwId,@Param("eqName") String eqName);

    @Select("SELECT\n" +
            "emp.user_xm,\n" +
            "eq.eq_name,\n" +
            "bm.bm_name,\n" +
            "emp.user_id AS user1_id,\n" +
            "bx.id AS fwId,\n" +
            "bx.bx_time\n" +
            "\n" +
            "FROM\n" +
            "dbo.eq_info AS eq ,\n" +
            "dbo.s_emp AS emp ,\n" +
            "dbo.fw_baoxiu AS bx ,\n" +
            "dbo.s_bm AS bm\n" +
            "WHERE\n" +
            "eq.eq_id = bx.eq_id AND\n" +
            "bx.bxks_id = bm.bm_id AND\n" +
            "emp.user_id = #{userId} AND\n" +
            "bx.id = #{fwId}")
    public FwWxfIndexVo fwWxfIndex(@Param("fwId") String fwId, @Param("userId") String userId);

    @Select("SELECT\n" +
            "bm.bm_name,\n" +
            "eq.eq_name,\n" +
            "emp.user_xm,\n" +
            "baoxiu.bx_time,\n" +
            "baoxiu.jjx_status,\n" +
            "eq.eq_id,\n" +
            "wxf.id,\n" +
            "wxf.wxf_status\n" +
            "\n" +
            "FROM\n" +
            "dbo.eq_info AS eq ,\n" +
            "dbo.fw_baoxiu AS baoxiu ,\n" +
            "dbo.s_bm AS bm ,\n" +
            "dbo.s_emp AS emp ,\n" +
            "dbo.fw_wxf AS wxf\n" +
            "WHERE\n" +
            "baoxiu.id = wxf.fw_id AND\n" +
            "eq.eq_id = baoxiu.eq_id AND\n" +
            "baoxiu.bxks_id = bm.bm_id AND\n" +
            "baoxiu.bxr_id = emp.user_id AND\n" +
            "wxf.user2_id = #{userId} AND\n" +
            "wxf.wxf_status = 0")
    public List<BaoXiuRw> getWxfRw(String userId);

    @Select("SELECT\n" +
            "wxf.id,\n" +
            "wxf.fw_id,\n" +
            "eq.eq_name,\n" +
            "emp.user_xm,\n" +
            "bm.bm_name,\n" +
            "wxf.wxf_sqtime,\n" +
            "wxf.wxf_rgf,\n" +
            "wxf.wxf_cjrgf\n" +
            "FROM\n" +
            "dbo.eq_info AS eq ,\n" +
            "dbo.fw_wxf AS wxf ,\n" +
            "dbo.s_bm AS bm ,\n" +
            "dbo.fw_baoxiu AS bx ,\n" +
            "dbo.s_emp AS emp\n" +
            "WHERE\n" +
            "wxf.fw_id = bx.id AND\n" +
            "eq.eq_id = bx.eq_id AND\n" +
            "bm.bm_id = bx.bxks_id AND\n" +
            "wxf.user1_id = emp.user_id AND\n" +
            "wxf.id = #{id}")
    public FwWxfShIndexVo getWxfShById(Integer id);

    @UpdateProvider(type = WxfProvider.class,method = "updateWxf")
    public int updateWxfById(@Param("id") Integer id, @Param("wxfSpyj") String wxfSpyj, @Param("wxfSptime") Date wxfSptime);

}
