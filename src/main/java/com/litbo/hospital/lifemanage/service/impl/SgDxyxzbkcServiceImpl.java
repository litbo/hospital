package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.bean.SgDxyxzbkc;
import com.litbo.hospital.lifemanage.bean.vo.SgDxyxzbkcVO;
import com.litbo.hospital.lifemanage.dao.SgDxzbUserMapper;
import com.litbo.hospital.lifemanage.dao.SgInfoMapper;
import com.litbo.hospital.lifemanage.service.SgDxyxzbkcService;
import com.litbo.hospital.supervise.bean.SEmp;
import com.litbo.hospital.supervise.service.EmpService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * 大型医学装备考察报告表Service实现类
 */
@Service
public class SgDxyxzbkcServiceImpl implements SgDxyxzbkcService {
    @Autowired
    private com.litbo.hospital.lifemanage.dao.SgDxyxzbkcMapper SgDxyxzbkcMapper;
    @Autowired
    private SgDxzbUserMapper sgDxzbUserMapper;
    @Autowired
    private SgInfoMapper sgInfoMapper;
    @Autowired
    private EmpService empService;

    /**
     * 添加或更新大型医学装备考察报告信息
     *
     * @param sgDxyxzbkcVO 大型医学装备考察报告信息
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    @Override
    public void insertOrUpdateSgDxyxzbkc(SgDxyxzbkcVO sgDxyxzbkcVO) {
        sgDxyxzbkcVO.setDxzbSj(new Date());
        SgDxyxzbkc sgDxyxzbkc = new SgDxyxzbkc();
        BeanUtils.copyProperties(sgDxyxzbkcVO, sgDxyxzbkc);
        // 获取参会人员列表
        List<String> userIds = sgDxyxzbkcVO.getUserIds();

        // 查询申购单表是否有大型医学装备考察报告id
        String sgDxyxzbkcId = sgInfoMapper.selectSgDxyxzbkcBySgInfoId(sgDxyxzbkc.getSgId());
        if (StringUtils.isBlank(sgDxyxzbkcId)) {
            sgDxyxzbkcId = UUID.randomUUID().toString();
            sgDxyxzbkc.setDxzbId(sgDxyxzbkcId);
            // 添加大型医学装备考察报告信息
            SgDxyxzbkcMapper.insertSgDxyxzbkc(sgDxyxzbkc);
            //添加参会人员列表
            for (String userId : userIds){
                sgDxzbUserMapper.insertSgDxzbUser(sgDxyxzbkcId,userId);
            }
            //把大型医学装备考察报告id插入申购单表中
            sgInfoMapper.updateSgInfoSgDxyxzbkcIdById(sgDxyxzbkcId, sgDxyxzbkc.getSgId());
        } else {
            //更新人员表
            sgDxzbUserMapper.deleteSgDxzbUserByDxyxzbkcId(sgDxyxzbkcId);
            for (String userId : userIds){
                sgDxzbUserMapper.insertSgDxzbUser(sgDxyxzbkcId,userId);
            }

            //根据查到大型医学装备考察报告id 更新大型医学装备考察报告表信息
            sgDxyxzbkc.setDxzbId(sgDxyxzbkcId);
            SgDxyxzbkcMapper.updateSgZrpjbgById(sgDxyxzbkc);
        }
    }

    /**
     * 根据申购单id查询大型医学装备考察报告信息
     *
     * @param sgInfoId 根据申购单id
     * @return SgDxyxzbkcVO
     */
    @Override
    public SgDxyxzbkcVO selectSgDxyxzbkc(String sgInfoId) {
        SgDxyxzbkcVO sgDxyxzbkcVO = new SgDxyxzbkcVO();
        //查询大型医学装备考察报告信息
        SgDxyxzbkc sgDxyxzbkc = SgDxyxzbkcMapper.selectSgDxyxzbkcBySgInfoId(sgInfoId);
        if (sgDxyxzbkc != null){
            BeanUtils.copyProperties(sgDxyxzbkc,sgDxyxzbkcVO);
            //查询大型医学装备考察报告信息人员信息
            List<String> userIds = sgDxzbUserMapper.selectSgDxzbUserBySgDxyxzbkcId(sgDxyxzbkc.getDxzbId());
            sgDxyxzbkcVO.setUserIds(userIds);
            List<SEmp> list = new LinkedList<>();
            for (String id :userIds){
                list.add(empService.getEmpsById(id));
            }
            sgDxyxzbkcVO.setUsers(list);
            return sgDxyxzbkcVO;
        }
        return null;
    }
}
