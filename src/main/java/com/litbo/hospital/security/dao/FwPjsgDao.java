package com.litbo.hospital.security.dao;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.bean.FwPjsg;
import com.litbo.hospital.security.enums.EnumApplyStatus;
import com.litbo.hospital.security.vo.ExaminePjsgVO;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface FwPjsgDao {
    @Insert("    insert into fw_pjsg ( user_id1, pj_rk_time, " +
            "      user_id2, sg_sh_time, sg_status, " +
            "      sg_yy, sg_sqsx)" +
            "    values (#{userId1,jdbcType=VARCHAR}, #{pjRkTime,jdbcType=TIMESTAMP}, " +
            "      #{userId2,jdbcType=VARCHAR}, #{sgShTime,jdbcType=TIMESTAMP}, #{sgStatus,jdbcType=INTEGER}, " +
            "      #{sgYy,jdbcType=VARCHAR}, #{sgSqsx,jdbcType=LONGVARCHAR})")
    @Options(useGeneratedKeys = true,keyProperty="id")
    Integer insertFwPjsg(FwPjsg pjsg);

    @SelectProvider(type=com.litbo.hospital.security.dao.sqlprovider.FwPjsgSqlProvider.class,method="listFwPjsg")
    List<FwPjsg> listFwPjsg(FwPjsg fwPjsg);

    @Update("update fw_pjsg set sg_sh_time =#{sgShTime}, sg_status = #{sgStatus,jdbcType=INTEGER} " +
            "where user_id2 = #{currentUserId,jdbcType=VARCHAR} and  id = #{id,jdbcType=INTEGER} and sg_status = #{wait}")
    int updateFwPjsgStatus(@Param("sgShTime")Date sgShTime ,@Param("sgStatus") int sgStatus, @Param("currentUserId")String currentUserId, @Param("id") int id, @Param("wait")int wait);

    @SelectProvider(type=com.litbo.hospital.security.dao.sqlprovider.FwPjsgSqlProvider.class,method="selectFwPjsgById")
    ExaminePjsgVO selectFwPjsgById(Integer id);
}
