package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.vo.EqCardToVO;
import com.litbo.hospital.lifemanage.bean.vo.MachineAccountVO;
import com.litbo.hospital.lifemanage.bean.vo.SgQueryCountVO;
import com.litbo.hospital.lifemanage.dao.provider.EquipmentAccountProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 电子台账Mapper
 *
 * @author Administrator on 2018-12-16
 */
@Mapper
public interface EquipmentAccountMapper {
    /**
     * 查询电子台账
     *
     * @param category            购置类别
     * @param state               状态
     * @param departmentId        部门id
     * @param equipmentPinyinCode 设备拼音码
     * @param departmentCoding    院内编码
     * @param equipmentNumber     设备编码
     * @return List<MachineAccountVO>
     */
    @SelectProvider(type = EquipmentAccountProvider.class, method = "selectEquipmentAccount")
    List<MachineAccountVO> selectEquipmentAccount(
            @Param("category") String category, @Param("state") String state,
            @Param("departmentId") String departmentId, @Param("equipmentPinyinCode") String equipmentPinyinCode,
            @Param("departmentCoding") String departmentCoding, @Param("equipmentNumber") String equipmentNumber);

    /**
     * 科室设备综合查询
     *
     * @param tgbmId              托管部门id
     * @param bmId                使用部门
     * @param eqQysjLower         启用时间下限
     * @param eqQysjUpper         启用时间上限
     * @param eqCgrqLower         采购日期下限
     * @param eqCgrqUpper         采购日期上限
     * @param eqPriceLower        设备价格下限
     * @param eqPriceUpper        设备价格上限
     * @param state               状态
     * @param equipmentPinyinCode 设备拼音码
     * @param departmentCoding    院内编码
     * @param eqCxflId            设备分类Id
     * @param bxqx                是否过保
     * @return List
     */
    @SelectProvider(type = EquipmentAccountProvider.class, method = "selectKsEq")
    List<SgQueryCountVO> selectKsEqOne(@Param("tgbmId") String tgbmId, @Param("bmId") String bmId, @Param("eqQysjLower") String eqQysjLower, @Param("eqQysjUpper") String eqQysjUpper, @Param("eqCgrqLower") String eqCgrqLower, @Param("eqCgrqUpper") String eqCgrqUpper, @Param("eqPriceLower") String eqPriceLower, @Param("eqPriceUpper") String eqPriceUpper, @Param("state") String state, @Param("equipmentPinyinCode") String equipmentPinyinCode, @Param("departmentCoding") String departmentCoding, @Param("eqCxflId") String eqCxflId, @Param("bxqx") String bxqx);

    /**
     * 查询设备维修的次数和维修总金额
     *
     * @param eqId 设备id
     * @return List
     */
    @Select("SELECT\n" +
            "SUM(wx_price) as repairCosts,\n" +
            "COUNT(dbo.fw_baoxiu.id) AS repairTimes\n" +
            "FROM\n" +
            "dbo.fw_weixiu\n" +
            "INNER JOIN dbo.fw_baoxiu ON dbo.fw_weixiu.fw_id = dbo.fw_baoxiu.id\n" +
            "WHERE\n" +
            "dbo.fw_baoxiu.eq_id = #{eqId,jdbcType=VARCHAR}")
    SgQueryCountVO selectKsEqTwo(String eqId);

    /**
     * 设备卡详情
     * 注释的字段为表中没有的
     *
     * @param eqSbbh 设备编号
     * @return Result
     */
    @Select("SELECT\n" +
            "dbo.eq_info.eq_sbbh AS sbbh,\n" +
            "dbo.eq_pm.eq_pm_name AS sbpm,\n" +
            "dbo.eq_info.eq_name AS sbjc,\n" +
            "dbo.eq_info.eq_xh AS xh,\n" +
            "dbo.eq_info.eq_gg AS gg,\n" +
            "dbo.eq_info.eq_syfw AS syfw,\n" +
            "dbo.eq_info.eq_qysj AS qyrq,\n" +
            "dbo.eq_info.eq_cxfl_id AS fldm,\n" +
            "dbo.eq_cxfl.eq_cxfl_name AS flmc,\n" +
            //flbz 分类标准
            "dbo.s_bm.bm_name AS syks,\n" +
            "dbo.eq_info.eq_sybmfzr AS bgr,\n" +
            "dbo.eq_info.eq_azwz AS azwz,\n" +
            //fxdj 风险等级
            //glpm 管理品目
            "dbo.eq_info.eq_jzbh AS ajbh,\n" +
            "dbo.eq_cs.sbcs_name AS gys,\n" +
            "dbo.eq_info.eq_cgrq AS cgrq,\n" +
            "dbo.eq_info.eq_pz AS pz,\n" +
            //fj 附件
            "dbo.eq_info.eq_htbh AS htbh,\n" +
            //msph 免税批号
            "dbo.eq_info.eq_zczbh AS zczh,\n" +
            "dbo.eq_zjly.zjly_name AS jfly,\n" +
            "dbo.eq_qdfs.qdfs_name AS qdfs,\n" +
            "dbo.eq_info.eq_azrq AS azrq,\n" +
            //zrrq 转入日期
            "dbo.eq_info.eq_synx AS synx,\n" +
            //scs 生产商
            //scrq 生产日期
            //sbxlh 设备序列号
            //gb 国别
            //wxs 维修商
            //dsfwxs 第三方维修商
            //cd 产地
            //jkcp 进口产品
            "dbo.eq_info.eq_syzt AS syzt\n" +
            //jsct 技术状态
            //bxzt 报修状态
            "\n" +
            "FROM\n" +
            "dbo.eq_info\n" +
            "LEFT JOIN dbo.eq_pm ON dbo.eq_info.eq_pm_id = dbo.eq_pm.eq_pm_id\n" +
            "LEFT JOIN dbo.eq_cxfl ON dbo.eq_info.eq_cxfl_id = dbo.eq_cxfl.eq_cxfl_id\n" +
            "LEFT JOIN dbo.s_bm ON dbo.eq_info.eq_bmid = dbo.s_bm.bm_id\n" +
            "LEFT JOIN dbo.eq_cs ON dbo.eq_info.sbcs_id_gys = dbo.eq_cs.sbcs_id\n" +
            "LEFT JOIN dbo.eq_zjly ON dbo.eq_info.zjly_id = dbo.eq_zjly.zjly_id\n" +
            "LEFT JOIN dbo.eq_qdfs ON dbo.eq_info.qdfs_id = dbo.eq_qdfs.qdfs_id\n" +
            "WHERE\n" +
            "dbo.eq_info.eq_sbbh = #{eqSbbh,jdbcType=VARCHAR}")
    EqCardToVO selectEqCardShow(String eqSbbh);
}
