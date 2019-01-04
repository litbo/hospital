package com.litbo.hospital.lifemanage.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.SgLccl;
import com.litbo.hospital.lifemanage.bean.vo.*;

/**
 * 处置管理Service
 *
 * @author Administrator on 2018-12-19
 */
public interface SgLcclService {
    /**
     * 处置查询列表
     *
     * @param pageNum             当前页数
     * @param pageSize            每页显示记录数
     * @param dateLowerAndUpperVO 时间下限 时间上限
     * @return PageInfo<DisposalQueryVO>
     */
    PageInfo<DisposalQueryVO> selectSgLccLList(Integer pageNum, Integer pageSize, DateLowerAndUpperVO dateLowerAndUpperVO);

    /**
     * 待报废清单
     *
     * @param pageNum  当前页数
     * @param pageSize 每页显示记录数
     * @param bmId     部门id
     * @return PageInfo<ScrappedListVO>
     */
    PageInfo<ScrappedListVO> selectScrappedList(Integer pageNum, Integer pageSize, String bmId, String isScrapped);

    /**
     * 处置申请
     *
     * @param pageNum  当前页数
     * @param pageSize 每页显示记录数
     * @param bmId     部门id
     * @return PageInfo<ScrappedListVO>
     */
    PageInfo<ScrappedListVO> selectApplyList(Integer pageNum, Integer pageSize, String bmId);

    /**
     * 添加处置申请信息
     *
     * @param sgLcclVO 处置申请信息
     */
    void updateApply(SgLcclVO sgLcclVO);

    /**
     * 申请报废
     *
     * @param userId 用户id
     * @param eqId   设备id
     */
    void insertApplyScrap(String userId, String eqId);

    /**
     * 上报审核
     *
     * @param sgLccl 上报审核信息
     */
    void updateSgLccLByEqId(SgLccl sgLccl);

    /**
     * 待上报列表
     *
     * @param pageNum  当前页数
     * @param pageSize 每页显示记录数
     * @param tab      标记 1待上报列表 2待批复列表 3待清理设备 4待备案处置设备
     * @return PageInfo<DisposalReportListVO>
     */
    PageInfo<DisposalReportListVO> selectXList(Integer pageNum, Integer pageSize, String tab);
}
