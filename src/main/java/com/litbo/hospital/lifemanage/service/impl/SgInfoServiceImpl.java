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
import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.dao.BmDao;
import com.litbo.hospital.supervise.dao.EmpDao;
import com.litbo.hospital.user.bean.EqPm;
import com.litbo.hospital.user.dao.EqDao;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    private BmDao bmDao;
    @Autowired
    private EqDao eqDao;
    @Autowired
    private EmpDao empDao;

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
        //查询托管科室名称
        if (StringUtils.isNotBlank(sgInfo.getTgBmId())){
            SBm sBm = bmDao.getBmBybmid(sgInfo.getTgBmId());
            if (ObjectUtils.allNotNull(sBm)){
                sgInfoVO.setBmName(sBm.getBmName());
            }
        }
        //查询 申购单对应的参考厂商设备信息
        List<SgCkcssb> sgCkcssbs = sgCkcssbMapper.selectSgCkcssbBySgInfoId(sgInfoId);
        //查询功能配置
        List<SgGnpz> sgGnpzs = sgGnpzMapper.selectSgGnpzBySgInfoId(sgInfoId);

        sgInfoVO.setSgCkcssbs(sgCkcssbs);
        sgInfoVO.setSgGnpzs(sgGnpzs);
        //通过品名id获取品名名称
        sgInfoVO.setEqPmName(sgCkcssbMapper.getEqPmNameById(sgInfo.getEqPmId()));
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
        SgInfo info = sgInfoMapper.selectSgInfoById(sgInfoVO.getId());
        // 如果申购单编号不存在生成一个编号
        if (StringUtils.isBlank(sgInfoBh)) {
            //按照格式生成申购单编号 日期+流水号
            sgInfoBh = IDFormat.getIdByIDAndTime("sg_info", "bh");
        }
        sgInfo.setBh(sgInfoBh);
        if(StringUtils.isBlank(sgInfoVO.getTgBmId()) && info!=null){
            sgInfo.setTgBmId(info.getTgBmId());
        }
        sgInfoMapper.updateSgInfoById(sgInfo);

        //根据申购单id删除对应的功能配置
        sgGnpzMapper.deleteSgGnpzBySgInfoId(sgInfoVO.getId());

        //根据申购单id删除对应的参考厂商信息
        sgCkcssbMapper.deleteSgCkcssbBySgInfoId(sgInfoVO.getId());

        //添加参考厂商设备
        List<SgCkcssb> sgCkcssbs = sgInfoVO.getSgCkcssbs();

        //获取页面的功能配置列表
        List<SgGnpz> sgGnpzs = sgInfoVO.getSgGnpzs();

        //添加参考厂商设备信息到数据库
        for (SgCkcssb sgCkcssb : sgCkcssbs) {
            sgCkcssb.setCkcssbId(UUID.randomUUID().toString());
            sgCkcssb.setSgId(sgInfo.getId());
            sgCkcssbMapper.insertSgCkcssb(sgCkcssb);
        }

        //添加功能配置
        for (SgGnpz sgGnpz : sgGnpzs) {
            sgGnpz.setGnpzId(UUID.randomUUID().toString());
            sgGnpz.setSgId(sgInfo.getId());
            sgGnpzMapper.insertSgGnpz(sgGnpz);
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
        shVO.setShsj(new Date());
        sgInfoMapper.updateSgInfoKssh(shVO);
    }

    /**
     * 显示申购单科室审核列表
     *
     * @param eqPmPym  设备名称
     * @param bh       申购单编号
     * @param userId   登陆人id
     * @param pageNum  页数
     * @param pageSize 每页显示记录数
     * @return SgInfoSumAuditListVO
     */
    @Override
    public PageInfo<SgInfoSumAuditListVO> selectSgInfoKsshList(String eqPmPym, String bh, String userId, Integer pageNum, Integer pageSize) {

        //调用用户表方法 通过人员表id获取所在科室id和名字
        SBm bm = empDao.getBmByEmpId(userId);
        // 如果人员没有科室 返回null
        if (!ObjectUtils.allNotNull(bm)) {return new PageInfo<>();}

        String bmName = bm.getBmName();
        String bmId = bm.getBmId();

        if (StringUtils.isNotBlank(eqPmPym)) {
            eqPmPym = "%" + eqPmPym + "%";
        }

        //根据品名名称模糊查询 找到对应的id
        List<String> pmIds = new ArrayList<>();
        if (StringUtils.isNotBlank(eqPmPym)) {
            List<EqPm> pmList = eqDao.listPmsByPym(eqPmPym);
            for (EqPm eqPm : pmList) {
                pmIds.add(eqPm.getEqPmId());
            }
        }

        PageHelper.startPage(pageNum, pageSize);
        List<SgInfoSumAuditListVO> selectKsShHzs = sgInfoMapper.selectSgInfoKsshList(bmId, bh, pmIds);
        for (SgInfoSumAuditListVO selectKsShHz : selectKsShHzs) {
            selectKsShHz.setBmName(bmName);
        }
        // 通过设备品名查询没有找到结果 返回null
        return StringUtils.isNotBlank(eqPmPym) && pmIds.size() <= 0 ? new PageInfo<>() : new PageInfo<>(selectKsShHzs);
    }

    /**
     * 显示申购单工程处审核列表
     *
     * @param bmId     查看具体科室id
     * @param pageNum  页数
     * @param pageSize 每页显示记录数
     * @return SgInfoSumAuditListVO
     */
    @Override
    public PageInfo<SgInfoSumAuditListVO> selectSgInfoGccshList(String bmId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SgInfoSumAuditListVO> selectKsShHzs = sgInfoMapper.selectSgInfoGccshList(bmId);
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
     * @param eqPmPym  设备拼音码
     * @param bmId     科室id
     * @param bh       申购单编号
     * @param pageNum  页数
     * @param pageSize 每页显示记录数
     * @return PageInfo<SgInfoSumAuditListVO>
     */
    @Override
    public PageInfo<SgInfoSumAuditListVO> selectSgInfoSgZbwyhhyList(String eqPmPym, String bmId, String bh, Integer pageNum, Integer pageSize) {
        if (StringUtils.isNotBlank(eqPmPym)) {
            eqPmPym = "%" + eqPmPym + "%";
        }
        PageHelper.startPage(pageNum, pageSize);
        List<SgInfoSumAuditListVO> selectKsShHzs = sgInfoMapper.selectSgInfoSgZbwyhhyList(eqPmPym, bmId, bh);
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
     * @param bmId     科室id
     * @param bh       申购单编号
     * @param eqSbPym  设备拼音码
     * @param pageNum  页数
     * @param pageSize 每页显示记录数
     * @return PageInfo<SgInfoSumAuditListVO>
     */
    @Override
    public PageInfo<SgInfoSumAuditListVO> selectSgInfoYbgsShList(String bmId, String bh, String eqSbPym, Integer pageNum, Integer pageSize) {
        if (StringUtils.isNotBlank(eqSbPym)) {
            eqSbPym = "%" + eqSbPym + "%";
        }
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(sgInfoMapper.selectSgInfoYbgsShList(bmId, bh, eqSbPym));
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
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(sgInfoMapper.selectSgInfoLzfx(sgDict.getLzfxPrice()));
    }

    /**
     * 申购设备公示查询列表
     *
     * @param isSh     是否通过审核
     * @param bmId     科室id
     * @param bh       申购单编号
     * @param sbPym    设备拼音码
     * @param pageNum  页数
     * @param pageSize 每页显示记录数
     * @return PageInfo<SgInfoListVO>
     */
    @Override
    public PageInfo<SgInfoListVO> selectSgInfoList(String isSh, String bmId, String bh, String sbPym, Integer pageNum, Integer pageSize) {
        if (StringUtils.isNotBlank(sbPym)) {
            sbPym = "%" + sbPym + "%";
        }
        PageHelper.startPage(pageNum, pageSize);
        List<SgInfoListVO> sgInfoListVOS = sgInfoMapper.selectSgInfoList(isSh, bmId, bh, sbPym);

        List<SgInfoListVO> sgList = new ArrayList<>();
        for (SgInfoListVO sgInfoListVO : sgInfoListVOS) {
            SgInfoReasonVO reason = sgInfoMapper.getReason(sgInfoListVO.getId());
            if (reason != null) {
                //科室审核未通过
                if ("0".equals(reason.getIskssh())) {
                    sgInfoListVO.setReason(reason.getKsshyj());
                }
                //医学工程处审核未通过
                else if ("0".equals(reason.getIsyxgccsh())) {
                    sgInfoListVO.setReason(reason.getYxgccshyj());
                }
                //装备委员会审核未通过
                else if ("0".equals(reason.getIszbwyhsh())) {
                    sgInfoListVO.setReason(reason.getZbwyhyj());
                }
                //院办公会审核未通过
                else if ("0".equals(reason.getIsybghsh())) {
                    sgInfoListVO.setReason(reason.getYbghyj());
                }
            }
            sgList.add(sgInfoListVO);
        }

        return new PageInfo<>(sgList);
    }

    /**
     * 申购进度跟踪
     *
     * @param isSh     是否通过审核
     * @param userId   用户id
     * @param bh       申购单编号
     * @param sbName   设备拼音码
     * @param pageNum  页数
     * @param pageSize 每页显示记录数
     * @return PageInfo<SgInfoListVO>
     */
    @Override
    public PageInfo<SgInfoListVO> selectSgInfoBmList(String isSh, String userId, String bh, String sbName, Integer pageNum, Integer pageSize) {
        //根据用户id 查询科室id
        SBm bm = empDao.getBmByEmpId(userId);
        // 如果人员没有科室 返回null
        if (!ObjectUtils.allNotNull(bm)) {return new PageInfo<>();}
        String bmId = bm.getBmId();
        return selectSgInfoList(isSh, bmId, bh, sbName, pageNum, pageSize);
    }
}
