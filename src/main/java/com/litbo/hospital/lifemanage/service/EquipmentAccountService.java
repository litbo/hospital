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
     * @param departmentId        部门id
     * @param equipmentPinyinCode 设备拼音码
     * @param departmentCoding    院内编码
     * @param equipmentNumber     设备编码
     * @param pageNum             当前页数
     * @param pageSize            每页显示的条数
     * @return PageInfo<MachineAccountVO>
     */
    PageInfo<MachineAccountVO> selectEquipmentAccount(String category, String state, String departmentId, String equipmentPinyinCode, String departmentCoding, String equipmentNumber, Integer pageNum, Integer pageSize);

    /**
     * 科室设备综合查询
     *
     * @param state 状态
     * @param equipmentPinyinCode 设备拼音码
     * @param departmentCoding 院内编码
     * @param eqCxflId 设备分类Id
     * @param pageNum 当前页数
     * @param pageSize 每页显示的条数
     * @return PageInfo
     */
    PageInfo<SgQueryCountVO> selectKsEq(String state, String equipmentPinyinCode, String departmentCoding,String eqCxflId, Integer pageNum, Integer pageSize);

    /**
     * 设备卡详情
     *
     * @param eqSbbh 设备编号
     * @return Result
     */
    EqCardToVO selectEqCardShow(String eqSbbh);
}
