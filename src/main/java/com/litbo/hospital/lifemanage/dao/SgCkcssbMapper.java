package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgCkcssb;
import org.apache.ibatis.annotations.Delete;
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
     * 根据申购单ID查询所有厂商设备表信息
     *
     * @param sgInfoId 申购单id
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
            "dbo.sg_ckcssb.gb,\n" +
            "dbo.sg_ckcssb.cd,\n" +
            "dbo.sg_ckcssb.extend_one,\n" +
            "dbo.sg_ckcssb.extend_two,\n" +
            "dbo.eq_cs.sbcs_name AS scsName\n" +
            "FROM dbo.sg_ckcssb\n" +
            "LEFT JOIN dbo.eq_cs ON dbo.sg_ckcssb.sbcs_id = dbo.eq_cs.sbcs_id\n" +
            "WHERE dbo.sg_ckcssb.sg_id = #{sgInfoId,jdbcType=VARCHAR}")
    List<SgCkcssb> selectSgCkcssbBySgInfoId(String sgInfoId);

    /**
     * 根据申购单id查询参考厂商设备表id列表
     *
     * @param sgInfoId 申购单id
     * @return 参考厂商设备表id列表
     */
    @Select("SELECT dbo.sg_ckcssb.ckcssb_id \n" +
            "FROM dbo.sg_ckcssb \n" +
            "WHERE dbo.sg_ckcssb.sg_id = #{sgInfoId,jdbcType=VARCHAR}")
    List<String> selectSgCkcssbIdBySgInfoId(String sgInfoId);

    /**
     * 添加厂商设备表信息
     *
     * @param sgCkcssb 厂商设备表实体类
     * @return int 添加信息总条数
     */
    @Insert("INSERT INTO sg_ckcssb (ckcssb_id, sg_id, sbcs_id, \n" +
            "   ckcssb_xh, ckcssb_gg, ckcssb_sl, \n" +
            "   ckcssb_gj, gb, cd, extend_one, extend_two\n" +
            ")\n" +
            "VALUES (#{ckcssbId,jdbcType=VARCHAR}, #{sgId,jdbcType=VARCHAR}, #{sbcsId,jdbcType=INTEGER}, \n" +
            "   #{ckcssbXh,jdbcType=VARCHAR}, #{ckcssbGg,jdbcType=VARCHAR}, #{ckcssbSl,jdbcType=INTEGER}, \n" +
            "   #{ckcssbGj,jdbcType=DECIMAL}, #{gb,jdbcType=VARCHAR},#{cd,jdbcType=VARCHAR},#{extendOne,jdbcType=VARCHAR}, #{extendTwo,jdbcType=VARCHAR}\n" +
            ")")
    int insertSgCkcssb(SgCkcssb sgCkcssb);

    /**
     * 根据主键删除参考厂商设备信息
     *
     * @param sgInfoId 参考厂商设备id
     * @return 删除信息的条数
     */
    @Delete("DELETE FROM sg_ckcssb WHERE sg_id = #{sgInfoId,jdbcType=VARCHAR}")
    int deleteSgCkcssbBySgInfoId(String sgInfoId);

    /**
     * 通过id获取品名名称
     * @param pmId 品名id
     * @return 品名名称
     */
    @Select("SELECT\n" +
            "dbo.eq_pm.eq_pm_name\n" +
            "FROM\n" +
            "dbo.eq_pm\n" +
            "WHERE\n" +
            "dbo.eq_pm.eq_pm_id = #{pmId,jdbcType=VARCHAR}")
    String getEqPmNameById(String pmId);
}