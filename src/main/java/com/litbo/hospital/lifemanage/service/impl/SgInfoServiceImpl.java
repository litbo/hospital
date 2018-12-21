package com.litbo.hospital.lifemanage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.DbUtil.IDFormat;
import com.litbo.hospital.lifemanage.bean.SgCkcssb;
import com.litbo.hospital.lifemanage.bean.SgDict;
import com.litbo.hospital.lifemanage.bean.SgGnpz;
import com.litbo.hospital.lifemanage.bean.SgInfo;
import com.litbo.hospital.lifemanage.bean.vo.*;
import com.litbo.hospital.lifemanage.dao.SgCkcssbMapper;
import com.litbo.hospital.lifemanage.dao.SgDictMapper;
import com.litbo.hospital.lifemanage.dao.SgGnpzMapper;
import com.litbo.hospital.lifemanage.dao.SgInfoMapper;
import com.litbo.hospital.lifemanage.service.SgInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 申购单表Service实现类
 */
@Service
public class SgInfoServiceImpl implements SgInfoService {
    @Autowired
    private SgInfoMapper sgInfoMapper;
    @Autowired
    private SgCkcssbMapper sgCkcssbMapper;
    @Autowired
    private SgGnpzMapper sgGnpzMapper;
    @Autowired
    private SgDictMapper sgDictMapper;

    /**
     * 根据申购单ID查询申购单信息
     *
     * @param sgInfoId 申购单id
     * @return 申购单信息
     */
    @Override
    public SgInfoVO selectSgInfoById(String sgInfoId) {
        SgInfoVO sgInfoVO = new SgInfoVO();
        //添加申购单基本信息
        SgInfo sgInfo = sgInfoMapper.selectSgInfoById(sgInfoId);
        BeanUtils.copyProperties(sgInfo, sgInfoVO);

        //添加申购单对应的参考厂商设备信息
        List<SgCkcssb> sgCkcssbs = sgCkcssbMapper.selectSgCkcssbBySgInfoId(sgInfoId);

        List<SgCkcssbVO> sgCkcssbVOS = new ArrayList<>();
        SgCkcssbVO sgCkcssbVO = new SgCkcssbVO();
        for (SgCkcssb sgCkcssb : sgCkcssbs) {
            BeanUtils.copyProperties(sgCkcssb, sgCkcssbVO);
            //参考厂商设备信息对应的功能配置
            sgCkcssbVO.setSgGnpzs(sgGnpzMapper.selectSgGnpzBySgCkcssbId(sgCkcssbVO.getCkcssbId()));
            sgCkcssbVOS.add(sgCkcssbVO);
        }

        sgInfoVO.setSgCkcssbVOs(sgCkcssbVOS);
        return sgInfoVO;
    }

    /**
     * 添加申购单表
     * 这里是更新申购单 申购单在科室讨论后就加入到数据库了
     *
     * @param sgInfoVO 申购单信息
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    @Override
    public void insertSgInfo(SgInfoVO sgInfoVO) {

        //通过主键更新申购单信息
        SgInfo sgInfo = new SgInfo();
        BeanUtils.copyProperties(sgInfoVO, sgInfo);

        //查询申购单的id是否存在
        String sgInfoBh = sgInfoMapper.selectSgInfoBhById(sgInfo.getId());
        // 如何申购单编号不存在生成一个编号
        if (StringUtils.isBlank(sgInfoBh)) {
            //按照格式生成申购单编号 日期+流水号
            sgInfoBh = IDFormat.getIdByIDAndTime("sg_info", "bh");
        }
        sgInfo.setBh(sgInfoBh);
        sgInfoMapper.updateSgInfoById(sgInfo);

        // 根据申购单id查询参考厂商id
        List<String> sgCkcssbIds = sgCkcssbMapper.selectSgCkcssbIdBySgInfoId(sgInfoVO.getId());
        //根据参考厂商设备id删除对应的功能配置
        for (String id : sgCkcssbIds) {
            sgGnpzMapper.deleteSgGnpzByCkcssbId(id);
        }

        //根据申购单id删除对应的参考厂商信息
        sgCkcssbMapper.deleteSgCkcssbBySgInfoId(sgInfoVO.getId());

        //添加参考厂商设备
        List<SgCkcssbVO> sgCkcssbVOS = sgInfoVO.getSgCkcssbVOs();
        //获取页面的功能配置列表
        List<SgGnpz> sgGnpzs = new ArrayList<>();

        SgCkcssb sgCkcssb = new SgCkcssb();
        for (SgCkcssbVO sgCkcssbVO : sgCkcssbVOS) {
            sgGnpzs.addAll(sgCkcssbVO.getSgGnpzs());
            BeanUtils.copyProperties(sgCkcssbVO, sgCkcssb);
            //添加参考厂商设备信息到数据库
            sgCkcssb.setCkcssbId(UUID.randomUUID().toString());
            sgCkcssb.setSgId(sgInfo.getId());
            sgCkcssbMapper.insertSgCkcssb(sgCkcssb);

            //添加功能配置
            for (SgGnpz sgGnpz : sgGnpzs) {
                sgGnpz.setGnpzId(UUID.randomUUID().toString());
                sgGnpz.setCkcssbId(sgCkcssb.getCkcssbId());
                sgGnpzMapper.insertSgGnpz(sgGnpz);
            }
        }
    }

    /**
     * 科室审核
     *
     * @param shVO 科室审核表单VO
     */
    @Override
    public void updateSgInfoKssh(ShVO shVO) {
        String a = "1";
        if (a.equals(shVO.getIssh())) {
            shVO.setZt("科室审核通过");
        } else {
            shVO.setZt("科室审核未通过");
        }
        sgInfoMapper.updateSgInfoKssh(shVO);
    }

    /**
     * 显示申购单科室审核列表
     *
     * @param sgInfoSumAuditListVO 条件信息
     * @param userId               登陆人id
     * @param pageNum              页数
     * @param pageSize             每页显示记录数
     * @return SgInfoSumAuditListVO
     */
    @Override
    public PageInfo<SgInfoSumAuditListVO> selectSgInfoKsshList(SgInfoSumAuditListVO sgInfoSumAuditListVO, String userId, Integer pageNum, Integer pageSize) {

        //TODO 调用用户表方法 通过人员表id获取所在部门id和名字
        String bmId = "1000011";
        String bmName = "部门名称";
        //TODO 根据品名名称模糊查询 找到对应的id
        List<String> pmList = new ArrayList<>();
        //TODO 模拟数据
        pmList.add("6803010101");
        pmList.add("6803010102");

        if (StringUtils.isNotBlank(sgInfoSumAuditListVO.getBh())) {
            sgInfoSumAuditListVO.setBh("%" + sgInfoSumAuditListVO.getBh() + "%");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<SgInfoSumAuditListVO> selectKsShHzs = sgInfoMapper.selectSgInfoKsshList(bmId, sgInfoSumAuditListVO.getBh(), pmList);
        for (SgInfoSumAuditListVO selectKsShHz : selectKsShHzs) {
            selectKsShHz.setBmName(bmName);
        }
        return new PageInfo<>(selectKsShHzs);
    }

    /**
     * 显示申购单工程处审核列表
     *
     * @param sgInfoSumAuditListVO 条件信息
     * @param pageNum              页数
     * @param pageSize             每页显示记录数
     * @return SgInfoSumAuditListVO
     */
    @Override
    public PageInfo<SgInfoSumAuditListVO> selectSgInfoGccshList(SgInfoSumAuditListVO sgInfoSumAuditListVO, Integer pageNum, Integer pageSize) {
        //TODO 根据品名名称模糊查询 找到对应的id
        List<String> pmList = new ArrayList<>();
        //TODO 模拟数据
        pmList.add("6803010101");
        pmList.add("6803010102");

        if (StringUtils.isNotBlank(sgInfoSumAuditListVO.getBh())) {
            sgInfoSumAuditListVO.setBh("%" + sgInfoSumAuditListVO.getBh() + "%");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<SgInfoSumAuditListVO> selectKsShHzs = sgInfoMapper.selectSgInfoGccshList(sgInfoSumAuditListVO.getBh(), pmList);
        for (SgInfoSumAuditListVO selectKsShHz : selectKsShHzs) {
            //TODO 根据部门id查询部门名称
//            selectKsShHz.getBmId();
            selectKsShHz.setBmName("部门1");
        }
        return new PageInfo<>(selectKsShHzs);
    }

    /**
     * 科室审核
     *
     * @param shVO 科室审核表单VO
     */
    @Override
    public void updateSgInfoYxgccsh(ShVO shVO) {
        String a = "1";
        if (a.equals(shVO.getIssh())) {
            shVO.setZt("申购单汇总通过");
        } else {
            shVO.setZt("申购单汇总未通过");
        }
        sgInfoMapper.updateSgInfoYxgccsh(shVO);
    }

    /**
     * 显示申购单装备委员会审核列表
     *
     * @param sgInfoSumAuditListVO 条件信息
     * @param pageNum              页数
     * @param pageSize             每页显示记录数
     * @return PageInfo<SgInfoSumAuditListVO>
     */
    @Override
    public PageInfo<SgInfoSumAuditListVO> selectSgInfoSgZbwyhhyList(SgInfoSumAuditListVO sgInfoSumAuditListVO, Integer pageNum, Integer pageSize) {
        //TODO 根据品名名称模糊查询 找到对应的id
        List<String> pmList = new ArrayList<>();
        pmList.add("6803010101");
        //TODO 模拟数据
        pmList.add("6803010102");

        if (StringUtils.isNotBlank(sgInfoSumAuditListVO.getBh())) {
            sgInfoSumAuditListVO.setBh("%" + sgInfoSumAuditListVO.getBh() + "%");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<SgInfoSumAuditListVO> selectKsShHzs = sgInfoMapper.selectSgInfoSgZbwyhhyList(sgInfoSumAuditListVO.getBh(), pmList);
        for (SgInfoSumAuditListVO selectKsShHz : selectKsShHzs) {
            //TODO 根据部门id查询部门名称
            // selectKsShHz.getBmId();
            selectKsShHz.setBmName("部门1");
        }
        return new PageInfo<>(selectKsShHzs);
    }

    /**
     * 装备委员会审核
     *
     * @param shVO 审核表单VO
     */
    @Override
    public void updateSgInfoZbwyhhy(ShVO shVO) {
        String a = "1";
        if (a.equals(shVO.getIssh())) {
            shVO.setZt("装备委员会审核通过");
        } else {
            shVO.setZt("装备委员会审核未通过");
        }
        sgInfoMapper.updateSgInfoZbwyhhy(shVO);
    }

    /**
     * 显示申购单院办公室审核列表
     *
     * @param sgInfoSumAuditListVO 条件信息
     * @param pageNum              页数
     * @param pageSize             每页显示记录数
     * @return PageInfo<SgInfoSumAuditListVO>
     */
    @Override
    public PageInfo<SgInfoSumAuditListVO> selectSgInfoYbgsShList(SgInfoSumAuditListVO sgInfoSumAuditListVO, Integer pageNum, Integer pageSize) {
        //TODO 根据品名名称模糊查询 找到对应的id
        List<String> pmList = new ArrayList<>();
        pmList.add("6803010101");
        //TODO 模拟数据
        pmList.add("6803010102");

        if (StringUtils.isNotBlank(sgInfoSumAuditListVO.getBh())) {
            sgInfoSumAuditListVO.setBh("%" + sgInfoSumAuditListVO.getBh() + "%");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<SgInfoSumAuditListVO> selectKsShHzs = sgInfoMapper.selectSgInfoYbgsShList(sgInfoSumAuditListVO.getBh(), pmList);
        for (SgInfoSumAuditListVO selectKsShHz : selectKsShHzs) {
            //TODO 根据部门id查询部门名称
            // selectKsShHz.getBmId();
            selectKsShHz.setBmName("部门1");
        }
        return new PageInfo<>(selectKsShHzs);
    }

    /**
     * 院办公会审核
     *
     * @param shVO 审核表单VO
     */
    @Override
    public void updateSgInfoYbghhy(ShVO shVO) {
        String a = "1";
        if (a.equals(shVO.getIssh())) {
            shVO.setZt("院办公会审核通过");
        } else {
            shVO.setZt("院办公会审核未通过");
        }
        sgInfoMapper.updateSgInfoYbghhy(shVO);
    }

    /**
     * 查询满足论证分析的申购单
     *
     * @param pageNum  页数
     * @param pageSize 每页显示记录数
     * @return PageInfo<SgInfoLzfxVO>
     */
    @Override
    public PageInfo<SgInfoLzfxVO> selectSgInfoLzfx(Integer pageNum, Integer pageSize) {
        //查询论证分析字典金额
        SgDict sgDict = sgDictMapper.selectSgDict();
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(sgInfoMapper.selectSgInfoLzfx(sgDict.getLzfxPrice()));
    }
}
