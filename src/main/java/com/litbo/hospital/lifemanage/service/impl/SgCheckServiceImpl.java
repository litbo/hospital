package com.litbo.hospital.lifemanage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.vo.SgCheckListVO;
import com.litbo.hospital.lifemanage.dao.SgCheckMapper;
import com.litbo.hospital.lifemanage.service.SgCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SgCheckService
 *
 * @author Administrator on 2018-12-29
 */
@Service
public class SgCheckServiceImpl implements SgCheckService {
    @Autowired
    private SgCheckMapper sgCheckMapper;

    /**
     * 计划下的所有待核对的设备列表
     *
     * @param planId   计划id
     * @param pageNum  当前页数
     * @param pageSize 每页显示的记录数
     * @return PageInfo<SgCheck>
     */
    @Override
    public PageInfo<SgCheckListVO> selectSgCheck(String planId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(sgCheckMapper.getListByPlanId(planId));
    }

    /**
     * 添加账实核对信息
     *
     * @param ids    核对表id
     * @param userId 核对人id
     */
    @Override
    public void updateSgCheckByIds(List<String> ids, String userId) {
        //通过人员id获取用户姓名
        String user = "a";
    }
}
