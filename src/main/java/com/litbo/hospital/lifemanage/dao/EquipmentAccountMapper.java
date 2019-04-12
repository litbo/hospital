package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.vo.EqCardToVO;
import com.litbo.hospital.lifemanage.bean.vo.MachineAccountVO;
import com.litbo.hospital.lifemanage.bean.vo.SgQueryCountVO;
import com.litbo.hospital.lifemanage.dao.provider.EquipmentAccountProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

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
    List<MachineAccountVO> selectEquipmentAccount(@Param("category") String category, @Param("state") String state, @Param("departmentId") String departmentId, @Param("equipmentPinyinCode") String equipmentPinyinCode, @Param("departmentCoding") String departmentCoding, @Param("equipmentNumber") String equipmentNumber);

    /**
     * 科室设备综合查询
     *
     * @param state               状态
     * @param equipmentPinyinCode 设备拼音码
     * @param departmentCoding    院内编码
     * @param bxqx                是否过保
     * @param eqCxflId            设备分类Id
     * @return List
     */
    @SelectProvider(type = EquipmentAccountProvider.class, method = "selectKsEq")
    List<SgQueryCountVO> selectKsEqOne(@Param("state") String state, @Param("equipmentPinyinCode") String equipmentPinyinCode, @Param("departmentCoding") String departmentCoding, @Param("eqCxflId") String eqCxflId, @Param("bxqx") String bxqx);

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

    //TODO 设备卡sql

    /**
     * 设备卡详情
     *
     * @param eqSbbh 设备编号
     * @return Result
     */
    @Select("")
    EqCardToVO selectEqCardShow(String eqSbbh);
}
