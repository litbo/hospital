package com.litbo.hospital.lifemanage.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.vo.SgCheckListVO;

import java.util.List;

/**
 * SgCheckService
 *
 * @author Administrator on 2018-12-29
 */
public interface SgCheckService {
    /**
     * 计划下的所有待核对的设备列表
     *
     * @param planId   计划id
     * @param pageNum  当前页数
     * @param pageSize 每页显示的记录数
     * @return PageInfo<SgCheck>
     */
    PageInfo<SgCheckListVO> selectSgCheck(String planId, Integer pageNum, Integer pageSize);

    /**
     * 添加账实核对信息
     *
     * @param ids 核对表id
     * @param userId 核对人id
     */
    void updateSgCheckByIds(List<String> ids, String userId);
}
