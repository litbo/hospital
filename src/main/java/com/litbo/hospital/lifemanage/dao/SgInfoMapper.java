package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgInfo;
import com.litbo.hospital.lifemanage.dao.provider.SgInfoSqlProvider;
import org.apache.ibatis.annotations.*;

/**
 * 申购单表Mapper接口
 */
@Mapper
public interface SgInfoMapper {

    /**
     * 通过品名Id查询申购单表信息
     *
     * @param pmId 品名ID
     * @return 返回申购单内容
     */
    @Select("SELECT\n" +
            "dbo.sg_info.id,\n" +
            "dbo.sg_info.bh\n" +
            "FROM\n" +
            "dbo.sg_info\n" +
            "WHERE\n" +
            "dbo.sg_info.eq_pm_id = #{pmId,jdbcType=INTEGER}")
    SgInfo selectSgInfoByPmId(Integer pmId);

    /**
     * 添加申购单信息
     *
     * @param sgInfo 申购信息
     * @return 添加记录数
     */
    @UpdateProvider(type = SgInfoSqlProvider.class, method = "updateSgInfoById")
    int updateSgInfoById(SgInfo sgInfo);

    /**
     * 讨论后的品名Id和申购单ID插入到申购单ID中
     *
     * @param sgInfoId 申购单ID
     * @param pmId     品名ID
     * @return 添加记录数
     */
    @Insert("insert into sg_info (id,eq_pm_id) values (#{sgInfoId,jdbcType=VARCHAR},#{pmId,jdbcType=INTEGER})")
    int insertSgInfo(@Param("sgInfoId") String sgInfoId, @Param("pmId") Integer pmId);

    /**
     * 根据申购单ID查询申购单信息
     *
     * @param sgInfoId 申购单id
     * @return 申购单信息
     */
    @Select("SELECT\n" +
            "dbo.sg_info.id,\n" +
            "dbo.sg_info.bm_id,\n" +
            "dbo.sg_info.bh,\n" +
            "dbo.sg_info.eq_pm_id,\n" +
            "dbo.sg_info.tg_bm_id,\n" +
            "dbo.sg_info.gzlb_id,\n" +
            "dbo.sg_info.zjly_id,\n" +
            "dbo.sg_info.syxz_id,\n" +
            "dbo.sg_info.num,\n" +
            "dbo.sg_info.price_wd,\n" +
            "dbo.sg_info.price_sn,\n" +
            "dbo.sg_info.price_gj_y,\n" +
            "dbo.sg_info.price_gj_my,\n" +
            "dbo.sg_info.gzll,\n" +
            "dbo.sg_info.xxyt,\n" +
            "dbo.sg_info.mdyt,\n" +
            "dbo.sg_info.jxkylcqk,\n" +
            "dbo.sg_info.jbcsyq,\n" +
            "dbo.sg_info.pzxq,\n" +
            "dbo.sg_info.syl,\n" +
            "dbo.sg_info.pjbg_id,\n" +
            "dbo.sg_info.kxfx_id,\n" +
            "dbo.sg_info.dxzb_id,\n" +
            "dbo.sg_info.iskssh,\n" +
            "dbo.sg_info.isyxgccsh,\n" +
            "dbo.sg_info.iszbwyhsh,\n" +
            "dbo.sg_info.zbwyhyj,\n" +
            "dbo.sg_info.zbwyhhy_id,\n" +
            "dbo.sg_info.isybghsh,\n" +
            "dbo.sg_info.ybghyj,\n" +
            "dbo.sg_info.ybghhy_id,\n" +
            "dbo.sg_info.zt,\n" +
            "dbo.sg_info.extend_one,\n" +
            "dbo.sg_info.extend_two,\n" +
            "dbo.sg_info.yxgccyj\n" +
            "FROM\n" +
            "dbo.sg_info\n" +
            "WHERE\n" +
            "dbo.sg_info.id = #{sgInfoId}")
    SgInfo selectSgInfoById(String sgInfoId);
}