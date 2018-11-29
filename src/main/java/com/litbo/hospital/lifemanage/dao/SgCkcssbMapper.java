package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgCkcssb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *参考厂商设备表
 */
@Mapper
public interface SgCkcssbMapper {
    @Select("SELECT\n" +
            "dbo.sg_ckcssb.ckcssb_id,\n" +
            "dbo.sg_ckcssb.sg_id,\n" +
            "dbo.sg_ckcssb.sbcs_id,\n" +
            "dbo.sg_ckcssb.ckcssb_xh,\n" +
            "dbo.sg_ckcssb.ckcssb_gg,\n" +
            "dbo.sg_ckcssb.ckcssb_sl,\n" +
            "dbo.sg_ckcssb.ckcssb_gj,\n" +
            "dbo.sg_ckcssb.extend_one,\n" +
            "dbo.sg_ckcssb.extend_two\n" +
            "\n" +
            "FROM\n" +
            "dbo.sg_ckcssb\n" +
            "WHERE\n" +
            "dbo.sg_ckcssb.ckcssb_id =#{sgCkcssbId}")
    List<SgCkcssb> selectSgCkcssbsById(@Param("sgCkcssbId") int sgCkcssbId);
/*
    int deleteByExample(SgCkcssbExample example);

    int deleteByPrimaryKey(String ckcssbId);

    int insert(SgCkcssb record);

    int insertSelective(SgCkcssb record);

    List<SgCkcssb> selectByExample(SgCkcssbExample example);

    SgCkcssb selectByPrimaryKey(String ckcssbId);

    int updateByExampleSelective(@Param("record") SgCkcssb record, @Param("example") SgCkcssbExample example);

    int updateByExample(@Param("record") SgCkcssb record, @Param("example") SgCkcssbExample example);

    int updateByPrimaryKeySelective(SgCkcssb record);

    int updateByPrimaryKey(SgCkcssb record);
     */
}