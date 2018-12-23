package com.litbo.hospital.lifemanage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.SgDhdj;
import com.litbo.hospital.lifemanage.bean.SgDjhw;
import com.litbo.hospital.lifemanage.bean.vo.DhdjksjsVO;
import com.litbo.hospital.lifemanage.bean.vo.SgDhdjVO;
import com.litbo.hospital.lifemanage.dao.SgDhdjMapper;
import com.litbo.hospital.lifemanage.dao.SgDjhwMapper;
import com.litbo.hospital.lifemanage.service.SgDhdjService;
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
 * 到货登记表Service实现类
 */
@Service
public class SgDhdjServiceImpl implements SgDhdjService {
    @Autowired
    private SgDhdjMapper sgDhdjMapper;
    @Autowired
    private SgDjhwMapper sgDjhwMapper;

    /**
     * 添加到货登记信息
     *
     * @param sgDhdjVO 到货登记信息
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    @Override
    public void insertSgDhdj(SgDhdjVO sgDhdjVO) {
        SgDhdj sgDhdj = new SgDhdj();
        BeanUtils.copyProperties(sgDhdjVO, sgDhdj);
        String sgDhdjId = UUID.randomUUID().toString();
        sgDhdj.setDhdjId(sgDhdjId);
        sgDhdjMapper.insertSgDhdj(sgDhdj);

        //添加登记货物信息
        for (SgDjhw sgDjhw : sgDhdjVO.getSgDjhws()) {
            sgDjhw.setDhdjId(sgDhdjId);
            sgDjhw.setDjhwId(UUID.randomUUID().toString());
            sgDjhwMapper.insertDjhw(sgDjhw);
        }
    }

    /**
     * 查询科室接收的货物
     *
     * @param userId   当前用户id
     * @param pageNum  当前页数
     * @param pageSize 每页显示的记录数
     * @return PageInfo<DhdjksjsVO>
     */
    @Override
    public PageInfo<DhdjksjsVO> selectDjhwKsjs(String userId, Integer pageNum, Integer pageSize) {
        //TODO 通过用户id查询所在的科室id
        String ksId = "1000011";

        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(sgDhdjMapper.selectDjhwKsjs(ksId));
    }

    /**
     * 科室接收
     *
     * @param djhwId 登记货物id
     * @param userId 登陆人id
     */
    @Override
    public void updateSgDhdjKsjs(String djhwId, String userId) {
        sgDjhwMapper.updateSgDhdjKsjs(djhwId, userId, new Date());
    }

    /**
     * 科室接收货物详情信息
     *
     * @param djhwId 到货登记id
     * @return SgDhdjVO
     */
    @Override
    public SgDhdjVO selectSgDhdjDetails(String djhwId) {
        SgDhdjVO sgDhdjVO = new SgDhdjVO();
        //查询到货登记信息
        SgDhdj sgDhdj = sgDhdjMapper.selectSgDhdjDetails(djhwId);
        //查询申购货物信息
        SgDjhw sgDjhw = sgDjhwMapper.selectSgDhdjDetails(djhwId);
        //封装成vo
        BeanUtils.copyProperties(sgDhdj,sgDhdjVO);
        List<SgDjhw> sgDjhws =new ArrayList<>();
        sgDjhws.add(sgDjhw);
        sgDhdjVO.setSgDjhws(sgDjhws);
        return sgDhdjVO;
    }


}
