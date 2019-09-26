package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgInfo;
import com.litbo.hospital.lifemanage.bean.vo.*;
import com.litbo.hospital.lifemanage.dao.provider.SgInfoSqlProvider;
import com.litbo.hospital.lifemanage.dao.provider.SimpleWhereInExtendedLanguageDriver;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 申购单表Mapper接口
 */
@Mapper
public interface SgInfoMapper {

    /**
     * 添加申购单信息
     *
     * @param sgInfo 申购信息
     * @return 添加记录数
     */
    @UpdateProvider(type = SgInfoSqlProvider.class, method = "updateSgInfoById")
    int updateSgInfoById(@Param("sgInfo") SgInfo sgInfo);

    /**
     * 讨论后的品名Id和申购单ID插入到申购单ID中
     *
     * @param sgInfoId 申购单ID
     * @param pmId     品名ID
     * @param bmId     部门ID
     * @param kstlId   科室讨论id
     * @return 添加记录数
     */
    @Insert("INSERT INTO sg_info (id,eq_pm_id,bm_id,kstl_id,zt) VALUES (#{sgInfoId,jdbcType=VARCHAR},#{pmId,jdbcType=VARCHAR},#{bmId,jdbcType=VARCHAR},#{kstlId,jdbcType=VARCHAR},'科室申购')")
    int insertSgInfo(@Param("sgInfoId") String sgInfoId, @Param("pmId") String pmId, @Param("bmId") String bmId, @Param("kstlId") String kstlId);

    /**
     * 根据申购单ID查询申购单信息
     *
     * @param sgInfoId 申购单id
     * @return 申购单信息
     */
    @Select("SELECT\n" +
            "dbo.sg_info.id,\n" +
            "dbo.sg_info.bm_id,\n" +
            "dbo.sg_info.jcl,\n" +
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

    /**
     * 通过主键查询申购单的编号
     *
     * @param sgInfoId 申购单主键
     * @return 申购单编号
     */
    @Select("SELECT dbo.sg_info.bh FROM dbo.sg_info WHERE dbo.sg_info.id = #{sgInfoId}")
    String selectSgInfoBhById(String sgInfoId);

    /**
     * 查询申购单表是否有准入评价报告id
     *
     * @param sgInfoId 申购单id
     * @return 准入评价报告id
     */
    @Select("SELECT dbo.sg_info.pjbg_id FROM dbo.sg_info WHERE dbo.sg_info.id = #{sgInfoId}")
    String selectSgZrpjbgBySgInfoId(String sgInfoId);

    /**
     * 把准入评价报告id插入申购单表中
     *
     * @param zrpjbgId 准入评价报告id
     * @return 添加的记录数
     */
    @Update("UPDATE sg_info SET pjbg_id = #{zrpjbgId,jdbcType=VARCHAR} \n" +
            "WHERE id = #{id,jdbcType=VARCHAR}")
    int updateSgInfoZrpjbgIdById(@Param("zrpjbgId") String zrpjbgId, @Param("id") String id);

    /**
     * 根据申购单id查询可行性分析id
     *
     * @param sgId 申购单id
     * @return 可行性分析id
     */
    @Select("SELECT dbo.sg_info.kxfx_id FROM dbo.sg_info WHERE dbo.sg_info.id = #{sgInfoId}")
    String selectSgKxxfxBySgInfoId(String sgId);

    /**
     * 把可行性分析id插入申购单表中
     *
     * @param sgKxxfxId 可行性分析id
     * @param sgId      申购单id
     * @return 更新数据条数
     */
    @Update("UPDATE sg_info SET kxfx_id = #{sgKxxfxId,jdbcType=VARCHAR} \n" +
            "WHERE id = #{id,jdbcType=VARCHAR}")
    int updateSgInfoKxfxIdById(@Param("sgKxxfxId") String sgKxxfxId, @Param("id") String sgId);

    /**
     * 根据申购单id查询大型医学装备考察报告id
     *
     * @param sgInfoId 申购单id
     * @return 型医学装备考察报告id
     */
    @Select("SELECT dbo.sg_info.dxzb_id FROM dbo.sg_info WHERE dbo.sg_info.id = #{sgInfoId}")
    String selectSgDxyxzbkcBySgInfoId(String sgInfoId);

    /**
     * 把大型医学装备考察报告id插入申购单表中
     *
     * @param sgDxyxzbkcId 大型医学装备考察报告id
     * @param sgId         申购单id
     * @return 更新数据条数
     */
    @Update("UPDATE sg_info SET dxzb_id = #{sgDxyxzbkcId,jdbcType=VARCHAR} \n" +
            "WHERE id = #{id,jdbcType=VARCHAR}")
    int updateSgInfoSgDxyxzbkcIdById(@Param("sgDxyxzbkcId") String sgDxyxzbkcId, @Param("id") String sgId);

    /**
     * 显示科室汇总审核列表
     *
     * @param bmId     部门id
     * @param sgInfoBh 申购单编号
     * @param pmList   品名列表
     * @return List<SgInfoSumAuditListVO>
     */
    @SelectProvider(type = SgInfoSqlProvider.class, method = "selectSgInfoKsshList")
    List<SgInfoSumAuditListVO> selectSgInfoKsshList(@Param("bmId") String bmId, @Param("sgInfoBh") String sgInfoBh, @Param("pmList") List<String> pmList);

    /**
     * 科室审核
     *
     * @param shVO 科室审核表单VO
     * @return 更新记录数
     */
    @Lang(SimpleWhereInExtendedLanguageDriver.class)
    @Update(" UPDATE sg_info " +
            " SET ksshr = #{shr,jdbcType=VARCHAR}, \n" +
            "   iskssh = #{issh,jdbcType=CHAR}, \n" +
            "   ksshsj = #{shsj,jdbcType=TIMESTAMP}, \n" +
            "   ksshyj = #{shyj,jdbcType=VARCHAR},\n" +
            "   zt = #{zt,jdbcType=VARCHAR}\n" +
            " WHERE id IN (#{ids})")
    int updateSgInfoKssh(ShVO shVO);

    /**
     * 显示申购单工程处审核列表
     *
     * @param bmId 查看具体部门id
     * @return List<SgInfoSumAuditListVO>
     */
    @SelectProvider(type = SgInfoSqlProvider.class, method = "selectSgInfoGccshList")
    List<SgInfoSumAuditListVO> selectSgInfoGccshList(String bmId);

    /**
     * 医学工程处审核
     *
     * @param shVO 医学工程处审核表单VO
     * @return 更新记录数
     */
    @Lang(SimpleWhereInExtendedLanguageDriver.class)
    @Update(" UPDATE sg_info " +
            " SET isyxgccsh = #{issh,jdbcType=CHAR}, \n" +
            "   yxgccshsj = #{shsj,jdbcType=TIMESTAMP}, \n" +
            "   yxgccyj = #{shyj,jdbcType=VARCHAR},\n" +
            "   zt = #{zt,jdbcType=VARCHAR}\n" +
            " WHERE id IN (#{ids})")
    int updateSgInfoYxgccsh(ShVO shVO);

    /**
     * 把论证分析表id插入申购表
     *
     * @param sgId     申购表id
     * @param sgLzfxId 论证分析表id
     * @return 更新记录数
     */
    @Update(" UPDATE sg_info " +
            " SET lzfx_id = #{sgLzfxId,jdbcType=VARCHAR}" +
            " WHERE id = #{sgId}")
    int updateSgInfoSgLzfxIdById(@Param("sgId") String sgId, @Param("sgLzfxId") String sgLzfxId);

    /**
     * 显示申购单装备委员会审核列表
     *
     * @param eqPmPym 设备拼音码
     * @param bh      申购单编号
     * @param bmId    部门id
     * @return List<SgInfoSumAuditListVO>
     */
    @SelectProvider(type = SgInfoSqlProvider.class, method = "selectSgInfoSgZbwyhhyList")
    List<SgInfoSumAuditListVO> selectSgInfoSgZbwyhhyList(@Param("eqPmPym") String eqPmPym, @Param("bmId") String bmId, @Param("bh") String bh);

    /**
     * 装备委员会审核
     *
     * @param shVO 装备委员会审核信息
     * @return 更新记录数
     */
    @Lang(SimpleWhereInExtendedLanguageDriver.class)
    @Update(" UPDATE sg_info " +
            " SET iszbwyhsh = #{issh,jdbcType=CHAR}, \n" +
            "   zbwyhyj = #{shyj,jdbcType=VARCHAR},\n" +
            "   zt = #{zt,jdbcType=VARCHAR}\n" +
            " WHERE id IN (#{ids})")
    int updateSgInfoZbwyhhy(ShVO shVO);

    /**
     * 添加装备委员会会议信息表id
     *
     * @param sgId    申购单id
     * @param zbwyhId 装备委员会会议id
     * @return 更新记录数
     */
    @Update(" UPDATE sg_info " +
            " SET zbwyhhy_id = #{zbwyhId,jdbcType=VARCHAR}" +
            " WHERE id = #{sgId,jdbcType=VARCHAR}")
    int updateSgInfoZbwyhhyIdById(@Param("sgId") String sgId, @Param("zbwyhId") String zbwyhId);

    /**
     * 显示申购单院办公会审核列表
     *
     * @param bh   编号
     * @param bmId 部门id
     * @return List<SgInfoSumAuditListVO>
     */
    @SelectProvider(type = SgInfoSqlProvider.class, method = "selectSgInfoYbgsShList")
    List<SgInfoSumAuditListVO> selectSgInfoYbgsShList(@Param("bmId") String bmId, @Param("bh") String bh, @Param("eqSbPym") String eqSbPym);

    /**
     * 院办公会会审核
     *
     * @param shVO 装备委员会审核信息
     * @return 更新记录数
     */
    @Lang(SimpleWhereInExtendedLanguageDriver.class)
    @Update(" UPDATE sg_info " +
            " SET isybghsh = #{issh,jdbcType=CHAR}, \n" +
            "   ybghyj = #{shyj,jdbcType=VARCHAR},\n" +
            "   zt = #{zt,jdbcType=VARCHAR}\n" +
            " WHERE id IN (#{ids})")
    int updateSgInfoYbghhy(ShVO shVO);

    /**
     * 添加装备委员会会议信息表id
     *
     * @param sgId     申购单id
     * @param ybghhyId 装备委员会会议id
     * @return 更新记录数
     */
    @Update(" UPDATE sg_info " +
            " SET ybghhy_id = #{ybghhyId,jdbcType=VARCHAR}" +
            " WHERE id = #{sgId,jdbcType=VARCHAR}")
    int updateSgInfoYbghhyIdById(@Param("sgId") String sgId, @Param("ybghhyId") String ybghhyId);

    /**
     * 装备委员会年度采购计划
     *
     * @param year 年份
     * @param bmId 部门id
     * @param bh   申购单编号
     * @return List<SgInfoSumAuditListVO>
     */
    @SelectProvider(type = SgInfoSqlProvider.class, method = "selectSgZbwyhYearPurchase")
    List<SgInfoSumAuditListVO> selectSgZbwyhYearPurchase(@Param("year") String year, @Param("bmId") String bmId, @Param("bh") String bh);

    /**
     * 院办公会年度采购计划
     *
     * @param year 年份
     * @param bmId 部门id
     * @param bh   申购单编号
     * @return List<SgInfoSumAuditListVO>
     */
    @SelectProvider(type = SgInfoSqlProvider.class, method = "selectSgYbghhyYearPurchase")
    List<SgInfoSumAuditListVO> selectSgYbghhyYearPurchase(@Param("year") String year, @Param("bmId") String bmId, @Param("bh") String bh);

    /**
     * 院办公会年度采购预算
     *
     * @param year 年份
     * @param bmId 部门id
     * @return List<YearBudgetVO>
     */
    @SelectProvider(type = SgInfoSqlProvider.class, method = "selectSgYbghhyYearBudget")
    List<YearBudgetVO> selectSgYbghhyYearBudget(@Param("year") String year, @Param("bmId") String bmId);

    /**
     * 装备委员会年度采购预算
     *
     * @param year 年份
     * @param bmId 部门id
     * @return List<YearBudgetVO>
     */
    @SelectProvider(type = SgInfoSqlProvider.class, method = "selectSgZbwyhYearBudget")
    List<YearBudgetVO> selectSgZbwyhYearBudget(@Param("year") String year, @Param("bmId") String bmId);

    /**
     * 查询满足论证分析的申购单
     *
     * @param lzfxPrice 论证分析字典中的价格
     * @return
     */
    @Select("SELECT\n" +
            "dbo.sg_info.id,\n" +
            "dbo.sg_info.bh,\n" +
            "dbo.eq_pm.eq_pm_name as pmName\n" +
            "FROM\n" +
            "dbo.sg_info\n" +
            "INNER JOIN dbo.eq_pm ON dbo.sg_info.eq_pm_id = dbo.eq_pm.eq_pm_id\n" +
            "WHERE\n" +
            "dbo.sg_info.price_gj_y >= #{lzfxPrice,jdbcType=DECIMAL} AND dbo.sg_info.bh IS NOT NULL")
    List<SgInfoLzfxVO> selectSgInfoLzfx(String lzfxPrice);

    /**
     * 申购设备公示查询列表
     *
     * @param isSh  是否通过审核
     * @param bmId  部门id
     * @param bh    申购单编号
     * @param sbPym 设备拼音码
     * @return List<SgInfoListVO>
     */
    @SelectProvider(type = SgInfoSqlProvider.class, method = "selectSgInfoList")
    List<SgInfoListVO> selectSgInfoList(@Param("isSh") String isSh, @Param("bmId") String bmId, @Param("bh") String bh, @Param("sbPym") String sbPym);

    /**
     * 查询未通过原因
     *
     * @param id 申购单id
     * @return 未通过原因
     */
    @Select("SELECT\n" +
            "dbo.sg_info.iskssh,\n" +
            "dbo.sg_info.ksshyj,\n" +
            "dbo.sg_info.isyxgccsh,\n" +
            "dbo.sg_info.yxgccyj,\n" +
            "dbo.sg_info.iszbwyhsh,\n" +
            "dbo.sg_info.zbwyhyj,\n" +
            "dbo.sg_info.isybghsh,\n" +
            "dbo.sg_info.ybghyj\n" +
            "FROM\n" +
            "dbo.sg_info\n" +
            "WHERE\n" +
            "dbo.sg_info.id = #{sbName,jdbcType=VARCHAR}")
    SgInfoReasonVO getReason(String id);
}