package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.FwWxf;
import com.litbo.hospital.security.vo.FwIdSelectVo;
import org.apache.ibatis.annotations.*;

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

}
