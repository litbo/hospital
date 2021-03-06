package com.litbo.hospital.lifemanage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.SgKstl;
import com.litbo.hospital.lifemanage.bean.SgKstlUser;
import com.litbo.hospital.lifemanage.bean.vo.SgKstlAddSgInfoVO;
import com.litbo.hospital.lifemanage.bean.vo.SgKstlToVO;
import com.litbo.hospital.lifemanage.bean.vo.SgKstlVO;
import com.litbo.hospital.lifemanage.dao.SgInfoMapper;
import com.litbo.hospital.lifemanage.dao.SgKstlMapper;
import com.litbo.hospital.lifemanage.dao.SgKstlUserMapper;
import com.litbo.hospital.lifemanage.dao.SgTlPmMapper;
import com.litbo.hospital.lifemanage.service.SgKstlService;
import com.litbo.hospital.supervise.bean.SBm;
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

import java.util.*;

/**
 * 科室讨论表Service实现类
 */
@Service
public class SgKstlServiceImpl implements SgKstlService {
    @Autowired
    private SgKstlMapper sgKstlMapper;
    @Autowired
    private SgKstlUserMapper sgKstlUserMapper;
    @Autowired
    private SgTlPmMapper sgTlPmMapper;
    @Autowired
    private SgInfoMapper sgInfoMapper;
    @Autowired
    private EmpDao empDao;
    @Autowired
    private EqDao eqDao;

    /**
     * 添加科室讨论信息
     *
     * @param sgKstlVO 科室讨论实体对象
     * @return 添加是否成功
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    @Override
    public boolean insertSgKstl(SgKstlVO sgKstlVO) {
        //通过人员id 查询科室id
        SBm bmByEmpId = empDao.getBmByEmpId(sgKstlVO.getUserId());
        sgKstlVO.setBmId(bmByEmpId.getBmId());

        SgKstl sgKstl = new SgKstl();
        List<SgKstlUser> usersId = sgKstlVO.getUsersId();
        List<EqPm> pmsId = sgKstlVO.getPmsId();
        BeanUtils.copyProperties(sgKstlVO, sgKstl);

        //添加讨论表id
        sgKstl.setKstlId(UUID.randomUUID().toString());
        Integer integer = sgKstlMapper.insertSgKstl(sgKstl);

        int sgKstlUserNum = 0;
        for (SgKstlUser u : usersId) {
            sgKstlUserNum += sgKstlUserMapper.insertSgKstlUser(sgKstl.getKstlId(), u.getUserId());
        }
        int sgTlPmNum = 0, sgInfoNum = 0;
        for (EqPm p : pmsId) {
            sgTlPmNum += sgTlPmMapper.insertSgTlPm(sgKstl.getKstlId(), p.getEqPmId(), sgKstl.getKstlTime());
            // 使讨论的品名Id添加到申购表中
            sgInfoNum += sgInfoMapper.insertSgInfo(UUID.randomUUID().toString(), p.getEqPmId(), sgKstl.getBmId(), sgKstl.getKstlId());
        }
        return integer > 0 && usersId.size() == sgKstlUserNum && pmsId.size() == sgTlPmNum && pmsId.size() == sgInfoNum;
    }

    /**
     * 通过科室id查询讨论表的id
     *
     * @param bmId 科室ID
     * @return 科室所有的讨论ID
     */
    @Override
    public List<String> selectSgKstlIdsByBmId(String bmId) {
        return sgKstlMapper.selectSgKstlIdsByBmId(bmId);
    }

    /**
     * 通过科室id查询所有的品名ID
     *
     * @param bmId 科室ID
     * @return 科室讨论的所有需购买设备的品名列表
     */
    @Override
    public List<String> selectSgTlPmPmIdsByBmId(String bmId) {
        List<String> tlIds = sgKstlMapper.selectSgKstlIdsByBmId(bmId);
        Set<String> pmIds = new HashSet<>();
        for (String tlId : tlIds) {
            pmIds.addAll(sgTlPmMapper.selectSgTlPmPmIdsByTlId(tlId));
        }
        return new ArrayList<>(pmIds);
    }

    /**
     * 通过品名id查询SgKstlVO
     *
     * @param pmId 品名id
     * @return SgKstlAddSgInfoVO
     */
    @Override
    public List<SgKstlAddSgInfoVO> selectSgKstlVOByPmIds(List<String> pmId) {
        return sgKstlMapper.selectSgKstlVOByPmIds(pmId);
    }

    /**
     * 显示科室下的所有讨论的设备
     *
     * @param userId   登陆人id
     * @param eqPmName 设备名称
     * @param eqPmJc   设备简称
     * @param pageNum  页数
     * @param pageSize 每页显示记录数
     * @return SgKstlAddSgInfoVO
     */
    @Override
    public PageInfo<SgKstlAddSgInfoVO> selectSgKstlSbs(String userId, String eqPmName, String eqPmJc, Integer pageNum, Integer pageSize) {
        //通过人员表id获取所在科室
        SBm bm = empDao.getBmByEmpId(userId);
        // 如果人员没有科室 返回null
        if (!ObjectUtils.allNotNull(bm)) {return new PageInfo<>();}

        String bmId = bm.getBmId();
        List<String> pmList = selectSgTlPmPmIdsByBmId(bmId);

        //调用品名的模糊查询 获得查询到的品名ID
        if (StringUtils.isNotBlank(eqPmJc)) {
            eqPmJc = "%"+eqPmJc+"%";
            List<String> pms = new ArrayList<>();
            for (EqPm eqPm : eqDao.listPmsByPym(eqPmJc)) {
                pms.add(eqPm.getEqPmId());
            }
//          把通过科室查询的品名list和模糊查询到的品名list 取交集
            pmList.retainAll(pms);
        }
        // 如果pmList为空 或者没有数据 就返回null的数据
        PageHelper.startPage(pageNum, pageSize);
        return pmList != null && pmList.size() > 0 ? new PageInfo<>(selectSgKstlVOByPmIds(pmList)) : new PageInfo<>();
    }

    /**
     * 查询科室讨论表信息
     * @param kstlId 科室讨论表id
     * @return SgKstlToVO
     */
    @Override
    public SgKstlToVO selectSgKstl(String kstlId) {
        SgKstlToVO sgKstlToVO = sgKstlMapper.selectSgKstl(kstlId);
        sgKstlToVO.setUsersName(sgKstlMapper.selectSgKstlRy(kstlId));
        return sgKstlToVO;
    }
}
