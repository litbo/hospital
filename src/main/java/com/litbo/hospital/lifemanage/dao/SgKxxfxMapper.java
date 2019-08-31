package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgKxxfx;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 可行性分析表Mapper接口
 */
@Mapper
public interface SgKxxfxMapper {
    @Insert("insert into sg_kxxfx (kxfx_id, sg_id, kxfx_syrq, \n" +
            "      kxfx_syqx, kxfx_hbqx, kxfx_sfxm, \n" +
            "      kxfx_pjsf, kxfx_yjyrc, kxfx_yjyze, \n" +
            "      kxfx_yjwcysr, kxfx_zxsbtz, kxfx_ptss, \n" +
            "      kxfx_yjcwxfy, kxfx_yclf, kxfx_sbzjf, \n" +
            "      kxfx_qtzjf, kxfx_ryglf, kxfx_hbqsq, \n" +
            "      kxfx_hbzys, kxfx_myhb, kxfx_xhbze, \n" +
            "      kxfx_ksfzr, extend_one, extend_two, \n" +
            "      kxfx_mqqk, kxfx_yqqk, kxfx_azcd, \n" +
            "      kxfx_pzss, kxfx_jsqk, kxfx_xhxy, \n" +
            "      kxfx_kxxjl)\n" +
            "    values (#{kxfxId,jdbcType=VARCHAR}, #{sgId,jdbcType=VARCHAR}, #{kxfxSyrq,jdbcType=TIMESTAMP}, \n" +
            "      #{kxfxSyqx,jdbcType=INTEGER}, #{kxfxHbqx,jdbcType=INTEGER}, #{kxfxSfxm,jdbcType=VARCHAR}, \n" +
            "      #{kxfxPjsf,jdbcType=DECIMAL}, #{kxfxYjyrc,jdbcType=INTEGER}, #{kxfxYjyze,jdbcType=DECIMAL}, \n" +
            "      #{kxfxYjwcysr,jdbcType=DECIMAL}, #{kxfxZxsbtz,jdbcType=DECIMAL}, #{kxfxPtss,jdbcType=DECIMAL}, \n" +
            "      #{kxfxYjcwxfy,jdbcType=DECIMAL}, #{kxfxYclf,jdbcType=DECIMAL}, #{kxfxSbzjf,jdbcType=DECIMAL}, \n" +
            "      #{kxfxQtzjf,jdbcType=DECIMAL}, #{kxfxRyglf,jdbcType=DECIMAL}, #{kxfxHbqsq,jdbcType=TIMESTAMP}, \n" +
            "      #{kxfxHbzys,jdbcType=INTEGER}, #{kxfxMyhb,jdbcType=DECIMAL}, #{kxfxXhbze,jdbcType=DECIMAL}, \n" +
            "      #{kxfxKsfzr,jdbcType=VARCHAR}, #{extendOne,jdbcType=VARCHAR}, #{extendTwo,jdbcType=VARCHAR}, \n" +
            "      #{kxfxMqqk,jdbcType=LONGVARCHAR}, #{kxfxYqqk,jdbcType=LONGVARCHAR}, #{kxfxAzcd,jdbcType=LONGVARCHAR}, \n" +
            "      #{kxfxPzss,jdbcType=LONGVARCHAR}, #{kxfxJsqk,jdbcType=LONGVARCHAR}, #{kxfxXhxy,jdbcType=LONGVARCHAR}, \n" +
            "      #{kxfxKxxjl,jdbcType=LONGVARCHAR})")
    int insertSgKxxfx(SgKxxfx sgKxxfx);

    /**
     * 根据可行性分析id更新可行性分析表信息
     *
     * @param sgKxxfx 可行性分析信息
     * @return 更新数据数
     */
    @Update("update sg_kxxfx\n" +
            "   set " +
            "       kxfx_hcgy = #{kxfxHcgy,jdbcType=VARCHAR},\n" +
            "       kxfx_syrq = #{kxfxSyrq,jdbcType=TIMESTAMP},\n" +
            "       kxfx_syqx = #{kxfxSyqx,jdbcType=INTEGER},\n" +
            "       kxfx_hbqx = #{kxfxHbqx,jdbcType=INTEGER},\n" +
            "       kxfx_sfxm = #{kxfxSfxm,jdbcType=VARCHAR},\n" +
            "       kxfx_pjsf = #{kxfxPjsf,jdbcType=DECIMAL},\n" +
            "       kxfx_yjyrc = #{kxfxYjyrc,jdbcType=INTEGER},\n" +
            "       kxfx_yjyze = #{kxfxYjyze,jdbcType=DECIMAL},\n" +
            "       kxfx_yjwcysr = #{kxfxYjwcysr,jdbcType=DECIMAL},\n" +
            "       kxfx_zxsbtz = #{kxfxZxsbtz,jdbcType=DECIMAL},\n" +
            "       kxfx_ptss = #{kxfxPtss,jdbcType=DECIMAL},\n" +
            "       kxfx_yjcwxfy = #{kxfxYjcwxfy,jdbcType=DECIMAL},\n" +
            "       kxfx_yclf = #{kxfxYclf,jdbcType=DECIMAL},\n" +
            "       kxfx_sbzjf = #{kxfxSbzjf,jdbcType=DECIMAL},\n" +
            "       kxfx_qtzjf = #{kxfxQtzjf,jdbcType=DECIMAL},\n" +
            "       kxfx_ryglf = #{kxfxRyglf,jdbcType=DECIMAL},\n" +
            "       kxfx_hbqsq = #{kxfxHbqsq,jdbcType=TIMESTAMP},\n" +
            "       kxfx_hbzys = #{kxfxHbzys,jdbcType=INTEGER},\n" +
            "       kxfx_myhb = #{kxfxMyhb,jdbcType=DECIMAL},\n" +
            "       kxfx_xhbze = #{kxfxXhbze,jdbcType=DECIMAL},\n" +
            "       kxfx_ksfzr = #{kxfxKsfzr,jdbcType=VARCHAR},\n" +
            "       extend_one = #{extendOne,jdbcType=VARCHAR},\n" +
            "       extend_two = #{extendTwo,jdbcType=VARCHAR},\n" +
            "       kxfx_mqqk = #{kxfxMqqk,jdbcType=LONGVARCHAR},\n" +
            "       kxfx_yqqk = #{kxfxYqqk,jdbcType=LONGVARCHAR},\n" +
            "       kxfx_azcd = #{kxfxAzcd,jdbcType=LONGVARCHAR},\n" +
            "       kxfx_pzss = #{kxfxPzss,jdbcType=LONGVARCHAR},\n" +
            "       kxfx_jsqk = #{kxfxJsqk,jdbcType=LONGVARCHAR},\n" +
            "       kxfx_xhxy = #{kxfxXhxy,jdbcType=LONGVARCHAR},\n" +
            "       kxfx_kxxjl = #{kxfxKxxjl,jdbcType=LONGVARCHAR}\n" +
            "   where kxfx_id = #{kxfxId,jdbcType=VARCHAR}")
    int updateSgKxxfxById(SgKxxfx sgKxxfx);

    /**
     * 根据申购单主键查询可行性分析信息
     *
     * @param sgInfoId 申购单主键
     * @return List<SgKxxfx>
     */
    @Select("select kxfx_hcgy, kxfx_id, sg_id, kxfx_syrq, kxfx_syqx, kxfx_hbqx, kxfx_sfxm, kxfx_pjsf, kxfx_yjyrc, \n" +
            "    kxfx_yjyze, kxfx_yjwcysr, kxfx_zxsbtz, kxfx_ptss, kxfx_yjcwxfy, kxfx_yclf, kxfx_sbzjf, \n" +
            "    kxfx_qtzjf, kxfx_ryglf, kxfx_hbqsq, kxfx_hbzys, kxfx_myhb, kxfx_xhbze, kxfx_ksfzr, \n" +
            "    extend_one, extend_two, kxfx_mqqk, kxfx_yqqk, kxfx_azcd, kxfx_pzss, kxfx_jsqk, kxfx_xhxy, kxfx_kxxjl,sg_id \n" +
            "from sg_kxxfx where sg_id = #{sgInfoId,jdbcType=VARCHAR}")
    SgKxxfx selectSgKxxfxBySgInfoId(String sgInfoId);
}