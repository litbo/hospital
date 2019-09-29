package com.litbo.hospital.lifemanage.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.vo.EqCardToVO;
import com.litbo.hospital.lifemanage.bean.vo.MachineAccountVO;
import com.litbo.hospital.lifemanage.bean.vo.SgQueryCountVO;

/**
 * 电子台账Service
 *
 * @author Administrator on 2018-12-16
 */
public interface EquipmentAccountService {
    /**
     * 分页查询电子台账
     *
     * @param category            购置类别
     * @param state               状态
     * @param departmentId        科室id
     * @param equipmentPinyinCode 设备拼音码
     * @param departmentCoding    院内编码
     * @param equipmentNumber     设备编码
     * @param pageNum             当前页数
     * @param pageSize            每页显示的条数
     * @return PageInfo<MachineAccountVO>
     */
    PageInfo<MachineAccountVO> selectEquipmentAccount(String category, String state,String tzlb, String departmentId, String equipmentPinyinCode, String departmentCoding, String equipmentNumber, Integer pageNum, Integer pageSize);

    /**
     * 科室设备综合查询
     *
     * @param tgbmId              托管科室id
     * @param bmId                使用科室
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
     * @param pageNum             当前页数
     * @param pageSize            每页显示的条数
     * @return PageInfo
     */
    PageInfo<SgQueryCountVO> selectKsEq(String tgbmId, String bmId, String eqQysjLower, String eqQysjUpper, String eqCgrqLower, String eqCgrqUpper, String eqPriceLower, String eqPriceUpper, String state, String equipmentPinyinCode, String departmentCoding, String eqCxflId, String bxqx, Integer pageNum, Integer pageSize);

    /**
     * 设备卡详情
     *
     * @param eqSbbh 设备编号
     * @return Result
     */
    EqCardToVO selectEqCardShow(String eqSbbh);
}
