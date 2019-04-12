package com.litbo.hospital.lifemanage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.TimeAgoUtils;
import com.litbo.hospital.lifemanage.bean.vo.EqCardToVO;
import com.litbo.hospital.lifemanage.bean.vo.MachineAccountVO;
import com.litbo.hospital.lifemanage.bean.vo.SgQueryCountVO;
import com.litbo.hospital.lifemanage.dao.EquipmentAccountMapper;
import com.litbo.hospital.lifemanage.service.EquipmentAccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * EquipmentAccountServiceImpl
 *
 * @author Administrator on 2018-12-16
 */
@Service
public class EquipmentAccountServiceImpl implements EquipmentAccountService {
    @Autowired
    private EquipmentAccountMapper equipmentAccountMapper;


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
    @Override
    public PageInfo<MachineAccountVO> selectEquipmentAccount(String category, String state, String departmentId, String equipmentPinyinCode, String departmentCoding, String equipmentNumber, Integer pageNum, Integer pageSize) {
        if (StringUtils.isNotBlank(equipmentPinyinCode)) {
            equipmentPinyinCode = "%" + equipmentPinyinCode + "%";
        }
        if (StringUtils.isNotBlank(departmentCoding)) {
            departmentCoding = "%" + departmentCoding + "%";
        }
        if (StringUtils.isNotBlank(equipmentNumber)) {
            equipmentNumber = "%" + equipmentNumber + "%";
        }
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(equipmentAccountMapper.selectEquipmentAccount(category, state, departmentId, equipmentPinyinCode, departmentCoding, equipmentNumber));
    }

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
     * @param pageNum             当前页数
     * @param pageSize            每页显示的条数
     * @return PageInfo
     */
    @Override
    public PageInfo<SgQueryCountVO> selectKsEq(String tgbmId, String bmId, String eqQysjLower, String eqQysjUpper, String eqCgrqLower, String eqCgrqUpper, String eqPriceLower, String eqPriceUpper, String state, String equipmentPinyinCode, String departmentCoding, String eqCxflId, String bxqx, Integer pageNum, Integer pageSize) {
        if (StringUtils.isNotBlank(equipmentPinyinCode)) {
            equipmentPinyinCode = "%" + equipmentPinyinCode + "%";
        }
        if (StringUtils.isNotBlank(departmentCoding)) {
            departmentCoding = "%" + departmentCoding + "%";
        }
        PageHelper.startPage(pageNum, pageSize);
        List<SgQueryCountVO> sgQueryCountVOS = equipmentAccountMapper.selectKsEqOne(tgbmId, bmId, eqQysjLower, eqQysjUpper, eqCgrqLower, eqCgrqUpper, eqPriceLower, eqPriceUpper,state, equipmentPinyinCode, departmentCoding, eqCxflId, bxqx);

        for (SgQueryCountVO sqcVO : sgQueryCountVOS) {
            //查询设备维修的次数和维修总金额
            SgQueryCountVO sgQueryCountVO = equipmentAccountMapper.selectKsEqTwo(sqcVO.getEqId());
            sqcVO.setRepairTimes(sgQueryCountVO.getRepairTimes());
            sqcVO.setRepairCosts(sgQueryCountVO.getRepairCosts());

            try {
                //使用年数
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(sqcVO.getEqQysj());
                sqcVO.setUseYears(TimeAgoUtils.compareTime(date));
                //保修状态
            } catch (ParseException | NullPointerException e) {
                System.out.println("没有查询到时间");
            }

            //TODO 计算累计折旧额

            sqcVO.setDepreciationYears("5"); //折旧年限固定值

        }
        return new PageInfo<>(sgQueryCountVOS);
    }

    /**
     * 设备卡详情
     *
     * @param eqSbbh 设备编号
     * @return Result
     */
    @Override
    public EqCardToVO selectEqCardShow(String eqSbbh) {
        EqCardToVO eqCardToVO = equipmentAccountMapper.selectEqCardShow(eqSbbh);
        // TODO
        EqCardToVO eqCardToVO1 = new EqCardToVO();
        eqCardToVO1.setAzrq(new Date())
                .setAzwz("AZWZ")
                .setBgr("BGR")
                .setBxzt("BXZT")
                .setCd("CD")
                .setCgrq(new Date())
                .setDsfwxs("DSFWXS")
                .setFj("FJ")
                .setFlbz("FLBZ")
                .setFldm("FLDM")
                .setGb("GB")
                .setGlpm("GLPM");
        return eqCardToVO1;
    }
}
