package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgCkcssb;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 参考厂商设备表Mapper接口
 */
@Mapper
public interface SgCkcssbMapper {
    /**
     * 分页查询所有厂商设备表信息
     *
     * @return List<SgCkcssb> 查询的信息
     */
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
            "dbo.sg_ckcssb")
    List<SgCkcssb> selectSgCkcssbs();

    /**
     * 添加厂商设备表信息
     *
     * @param sgCkcssb 厂商设备表实体类
     * @return int 添加信息总条数
     */
    @Insert("INSERT INTO sg_ckcssb (ckcssb_id, sg_id, sbcs_id, \n" +
            "   ckcssb_xh, ckcssb_gg, ckcssb_sl, \n" +
            "   ckcssb_gj, extend_one, extend_two\n" +
            ")\n" +
            "VALUES (#{ckcssbId,jdbcType=VARCHAR}, #{sgId,jdbcType=VARCHAR}, #{sbcsId,jdbcType=INTEGER}, \n" +
            "   #{ckcssbXh,jdbcType=VARCHAR}, #{ckcssbGg,jdbcType=VARCHAR}, #{ckcssbSl,jdbcType=INTEGER}, \n" +
            "   #{ckcssbGj,jdbcType=DECIMAL}, #{extendOne,jdbcType=VARCHAR}, #{extendTwo,jdbcType=VARCHAR}\n" +
            ")")
    int insertSgCkcssb(SgCkcssb sgCkcssb);
}