package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgDhdj;
import com.litbo.hospital.lifemanage.bean.vo.DhdjksjsVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 到货登记表Mapper接口
 */
@Mapper
public interface SgDhdjMapper {
    /**
     * 添加到货登记信息
     *
     * @param sgDhdj 到货登记信息
     * @return 添加记录数
     */
    @Insert("insert into sg_dhdj (dhdj_id, dhdj_shdw, dhdj_fhdw, \n" +
            "      dhdj_shr, dhdj_fhr, dhdj_shrdh, \n" +
            "      dhdj_fhrdh, dhdj_mdd, dhdj_fhd, \n" +
            "      dhdj_shxxdz, dhdj_fhxxdz, dhsj, \n" +
            "      dhdj_wlgs, dhdj_bjgs, dhdj_ysdh, \n" +
            "      dhdj_byfy, dhdj_ysfs, dhdj_jsr, \n" +
            "      dhdj_cfdd, ht_id, \n" +
            "      dhdj_fhxs, dhdj_sdxs, dhdj_csxs, \n" +
            "      dhdj_bz, dhdj_isqbdh, extend_one, \n" +
            "      extend_two)\n" +
            "    values (#{dhdjId,jdbcType=VARCHAR}, #{dhdjShdw,jdbcType=VARCHAR}, #{dhdjFhdw,jdbcType=VARCHAR}, \n" +
            "      #{dhdjShr,jdbcType=VARCHAR}, #{dhdjFhr,jdbcType=VARCHAR}, #{dhdjShrdh,jdbcType=VARCHAR}, \n" +
            "      #{dhdjFhrdh,jdbcType=VARCHAR}, #{dhdjMdd,jdbcType=VARCHAR}, #{dhdjFhd,jdbcType=VARCHAR}, \n" +
            "      #{dhdjShxxdz,jdbcType=VARCHAR}, #{dhdjFhxxdz,jdbcType=VARCHAR}, #{dhsj,jdbcType=TIMESTAMP}, \n" +
            "      #{dhdjWlgs,jdbcType=VARCHAR}, #{dhdjBjgs,jdbcType=VARCHAR}, #{dhdjYsdh,jdbcType=INTEGER}, \n" +
            "      #{dhdjByfy,jdbcType=DECIMAL}, #{dhdjYsfs,jdbcType=CHAR}, #{dhdjJsr,jdbcType=VARCHAR}, \n" +
            "      #{dhdjCfdd,jdbcType=VARCHAR}, #{htId,jdbcType=VARCHAR},\n" +
            "      #{dhdjFhxs,jdbcType=INTEGER}, #{dhdjSdxs,jdbcType=INTEGER}, #{dhdjCsxs,jdbcType=INTEGER}, \n" +
            "      #{dhdjBz,jdbcType=VARCHAR}, #{dhdjIsqbdh,jdbcType=CHAR}, #{extendOne,jdbcType=VARCHAR}, \n" +
            "      #{extendTwo,jdbcType=VARCHAR})")
    int insertSgDhdj(SgDhdj sgDhdj);

    /**
     * 到货登记科室接收列表
     *
     * @param ksId 科室id
     * @return List<DhdjksjsVO>
     */
    @Select("SELECT\n" +
            "dbo.sg_djhw.djhw_id,\n" +
            "dbo.sg_dhdj.ht_id,\n" +
            "dbo.sg_dhdj.sg_id,\n" +
            "dbo.sg_dhdj.dhdj_fhdw,\n" +
            "dbo.sg_dhdj.dhdj_ysdh,\n" +
            "dbo.sg_info.bh,\n" +
            "dbo.sg_dhdj.dhsj,\n" +
            "dbo.sg_dhdj.dhdj_cfdd,\n" +
            "dbo.sg_dhdj.dhdj_sdxs\n" +
            "\n" +
            "FROM\n" +
            "dbo.sg_dhdj\n" +
            "INNER JOIN dbo.sg_djhw ON dbo.sg_djhw.dhdj_id = dbo.sg_dhdj.dhdj_id\n" +
            "INNER JOIN dbo.sg_info ON dbo.sg_djhw.sg_id = dbo.sg_info.id\n" +
            "WHERE\n" +
            "dbo.sg_info.bm_id = #{ksId,jdbcType=VARCHAR} AND\n" +
            "dbo.sg_dhdj.dhdj_isqbdh = '1'")
    List<DhdjksjsVO> selectDjhwKsjs(String ksId);

    /**
     * 科室接收货物详情信息
     *
     * @param djhwId 到货登记id
     * @return SgDhdjVO
     */
    @Select("SELECT\n" +
            "dbo.sg_dhdj.dhdj_shdw,\n" +
            "dbo.sg_dhdj.dhdj_fhdw,\n" +
            "dbo.sg_dhdj.dhdj_shr,\n" +
            "dbo.sg_dhdj.dhdj_fhr,\n" +
            "dbo.sg_dhdj.dhdj_shrdh,\n" +
            "dbo.sg_dhdj.dhdj_fhrdh,\n" +
            "dbo.sg_dhdj.dhdj_fhd,\n" +
            "dbo.sg_dhdj.dhdj_shxxdz,\n" +
            "dbo.sg_dhdj.dhdj_fhxxdz,\n" +
            "dbo.sg_dhdj.dhsj,\n" +
            "dbo.sg_dhdj.dhdj_wlgs,\n" +
            "dbo.sg_dhdj.dhdj_bjgs,\n" +
            "dbo.sg_dhdj.dhdj_ysdh,\n" +
            "dbo.sg_dhdj.dhdj_byfy,\n" +
            "dbo.sg_dhdj.dhdj_ysfs,\n" +
            "dbo.sg_dhdj.dhdj_jsr,\n" +
            "dbo.sg_dhdj.dhdj_cfdd,\n" +
            "dbo.sg_dhdj.ht_id,\n" +
            "dbo.sg_dhdj.dhdj_fhxs,\n" +
            "dbo.sg_dhdj.dhdj_sdxs,\n" +
            "dbo.sg_dhdj.dhdj_csxs,\n" +
            "dbo.sg_dhdj.dhdj_mdd\n" +
            "FROM\n" +
            "dbo.sg_dhdj\n" +
            "INNER JOIN dbo.sg_djhw ON dbo.sg_dhdj.dhdj_id = dbo.sg_djhw.dhdj_id\n" +
            "WHERE\n" +
            "dbo.sg_djhw.djhw_id = #{djhwId,jdbcType=VARCHAR}")
    SgDhdj selectSgDhdjDetails(String djhwId);
}