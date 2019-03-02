package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.FwFp;
import com.litbo.hospital.security.vo.ListFwFpByApplyApprovalVo;
import com.litbo.hospital.security.vo.ListFwFpByWaitExamineVo;
import com.litbo.hospital.security.vo.SelectFwFpByIdVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FwFpDao {

    @SelectProvider(type=com.litbo.hospital.security.dao.sqlprovider.FwFpSqlProvider.class,method="listFwFpByWaitExamine")
    List<ListFwFpByWaitExamineVo> listFwFpByWaitExamine(@Param("fpHm") String fpHm, @Param("eqName") String eqName, @Param("wxDh") String wxDh);

    @Insert("    insert into fw_fp ( fp_dh,fp_price," +
            "      fp_sd_time,fp_status, user_id," +
            "      fp_sh_time,fp_hm)" +
            "    values (#{fpDh,jdbcType=VARCHAR}, #{fpPrice,jdbcType=DECIMAL}, " +
            "      #{fpSdTime,jdbcType=TIMESTAMP}, #{fpStatus,jdbcType=INTEGER}, #{userId,jdbcType=VARCHAR}, " +
            "      #{fpShTime,jdbcType=TIMESTAMP}, #{fpHm,jdbcType=VARCHAR})")
    Integer insertFwFp(FwFp fp);
    @SelectProvider(type=com.litbo.hospital.security.dao.sqlprovider.FwFpSqlProvider.class,method="listFwFpByApplyApproval")
    List<ListFwFpByApplyApprovalVo> listFwFpByApplyApproval(@Param("fpHm") String fpHm, @Param("eqName") String eqName, @Param("wxDh") String wxDh);
    @Update("update fw_fp set user_id=#{userId},fp_sh_time =#{fpShTime},fp_shr_id=#{fpShrId},shyj=#{shyj} where id=#{id}")
    int updateFwFp(FwFp fp);
    @SelectProvider(type=com.litbo.hospital.security.dao.sqlprovider.FwFpSqlProvider.class,method="selectFwFpById")
    SelectFwFpByIdVo selectFwFpById(Integer id);
}
