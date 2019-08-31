package com.litbo.hospital.lifemanage.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.vo.SgCheckListVO;
import com.litbo.hospital.lifemanage.bean.vo.SgCheckVO;

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
    PageInfo<SgCheckVO> selectSgCheck(String planId, Integer pageNum, Integer pageSize);

    /**
     * 添加账实核对信息
     *
     * @param ids    核对表id
     * @param userId 核对人id
     * @param check  核对是否存在 0不存在 1存在
     */
    void updateSgCheckByIds(List<String> ids, String userId, String check);

    /**
     * 核对对比
     *
     * @param planId    计划id
     * @param check     是否存在
     * @param checkDate 审核日期
     * @param checkUser 审核人
     * @param planDate  制定日期
     * @param planUser  制定人
     * @param pageNum   当前页数
     * @param pageSize  每页显示的记录数
     * @return PageInfo<SgCheckListVO>
     */
    PageInfo<SgCheckListVO> selectSgCheckList(String planId, String check, String checkDate, String checkUser, String planDate, String planUser, Integer pageNum, Integer pageSize);
}
