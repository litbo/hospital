package com.litbo.hospital.lifemanage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.TimeAgoUtils;
import com.litbo.hospital.lifemanage.bean.vo.MachineAccountVO;
import com.litbo.hospital.lifemanage.bean.vo.SgQueryCountVO;
import com.litbo.hospital.lifemanage.dao.EquipmentAccountMapper;
import com.litbo.hospital.lifemanage.service.EquipmentAccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
            equipmentPinyinCode = "%"+equipmentPinyinCode+"%";
        }
        if (StringUtils.isNotBlank(departmentCoding)) {
            departmentCoding = "%"+departmentCoding+"%";
        }
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(equipmentAccountMapper.selectEquipmentAccount(category, state, departmentId, equipmentPinyinCode, departmentCoding, equipmentNumber));
    }

    /**
     * 科室设备综合查询
     *
     * @param state 状态
     * @param equipmentPinyinCode 设备拼音码
     * @param departmentCoding 院内编码
     * @param pageNum 当前页数
     * @param pageSize 每页显示的条数
     * @return PageInfo
     */
    @Override
    public PageInfo<SgQueryCountVO> selectKsEq(String state, String equipmentPinyinCode, String departmentCoding, Integer pageNum, Integer pageSize) {
        if (StringUtils.isNotBlank(equipmentPinyinCode)) {
            equipmentPinyinCode = "%"+equipmentPinyinCode+"%";
        }
        if (StringUtils.isNotBlank(departmentCoding)) {
            departmentCoding = "%"+departmentCoding+"%";
        }
        PageHelper.startPage(pageNum, pageSize);
        List<SgQueryCountVO> sgQueryCountVOS = equipmentAccountMapper.selectKsEqOne(state, equipmentPinyinCode, departmentCoding);

        for (SgQueryCountVO sqcVO :sgQueryCountVOS){
            SgQueryCountVO sgQueryCountVO = equipmentAccountMapper.selectKsEqTwo(sqcVO.getEqId());
            sqcVO.setRepairTimes(sgQueryCountVO.getRepairTimes());
            sqcVO.setRepairCosts(sgQueryCountVO.getRepairCosts());

            try {
                sqcVO.setUseYears(TimeAgoUtils.format(new SimpleDateFormat("yyyy-MM-dd").parse(sqcVO.getUseYears())));
            } catch (ParseException | NullPointerException e) {
                System.out.println("没有查询到时间");
//                e.printStackTrace();
            }
            //折旧年限固定值为5
            sqcVO.setDepreciationYears("5");

        }
        return new PageInfo<>(sgQueryCountVOS);
    }
}
