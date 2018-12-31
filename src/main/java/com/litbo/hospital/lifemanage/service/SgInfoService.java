package com.litbo.hospital.lifemanage.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.vo.*;

/**
 * 申购单表Service接口
 */
public interface SgInfoService {
    /**
     * 根据申购单ID查询申购单信息
     *
     * @param sgInfoId 申购单id
     * @return 申购单信息
     */
    SgInfoVO selectSgInfoById(String sgInfoId);

    /**
     * 添加申购单表
     *
     * @param sgInfoVO 申购单信息
     */
    void insertSgInfo(SgInfoVO sgInfoVO);

    /**
     * 科室审核
     *
     * @param shVO 审核表单VO
     */
    void updateSgInfoKssh(ShVO shVO);

    /**
     * 显示申购单科室审核列表
     *
     * @param eqPmName 设备名称
     * @param bh       申购单编号
     * @param userId   登陆人id
     * @param pageNum  页数
     * @param pageSize 每页显示记录数
     * @return SgInfoSumAuditListVO
     */
    PageInfo<SgInfoSumAuditListVO> selectSgInfoKsshList(String eqPmName, String bh, String userId, Integer pageNum, Integer pageSize);

    /**
     * 显示申购单工程处审核列表
     *
     * @param bmId     查看具体部门id
     * @param pageNum  页数
     * @param pageSize 每页显示记录数
     * @return SgInfoSumAuditListVO
     */
    PageInfo<SgInfoSumAuditListVO> selectSgInfoGccshList(String bmId, Integer pageNum, Integer pageSize);

    /**
     * 医学工程处审核
     *
     * @param shVO 审核表单VO
     */
    void updateSgInfoYxgccsh(ShVO shVO);

    /**
     * 显示申购单装备委员会审核列表
     *
     * @param bmId     部门id
     * @param bh       申购单编号
     * @param pageNum  页数
     * @param pageSize 每页显示记录数
     * @return SgInfoSumAuditListVO
     */
    PageInfo<SgInfoSumAuditListVO> selectSgInfoSgZbwyhhyList(String bmId, String bh, Integer pageNum, Integer pageSize);

    /**
     * 装备委员会审核
     *
     * @param shVO 审核表单VO
     */
    void updateSgInfoZbwyhhy(ShVO shVO);

    /**
     * 显示申购单院办公室审核列表
     *
     * @param bmId     部门id
     * @param bh       申购单编号
     * @param pageNum  页数
     * @param pageSize 每页显示记录数
     * @return PageInfo<SgInfoSumAuditListVO>
     */
    PageInfo<SgInfoSumAuditListVO> selectSgInfoYbgsShList(String bmId, String bh, Integer pageNum, Integer pageSize);

    /**
     * 院办公会审核
     *
     * @param shVO 审核表单VO
     */
    void updateSgInfoYbghhy(ShVO shVO);

    /**
     * 查询满足论证分析的申购单
     *
     * @param pageNum  页数
     * @param pageSize 每页显示记录数
     * @return PageInfo<SgInfoLzfxVO>
     */
    PageInfo<SgInfoLzfxVO> selectSgInfoLzfx(Integer pageNum, Integer pageSize);

    /**
     * 申购设备公示查询列表
     *
     * @param isSh     是否通过审核
     * @param bmId     部门id
     * @param bh       申购单编号
     * @param sbName   设备拼音码
     * @param pageNum  页数
     * @param pageSize 每页显示记录数
     * @return PageInfo<SgInfoListVO>
     */
    PageInfo<SgInfoListVO> selectSgInfoList(String isSh, String bmId, String bh, String sbName, Integer pageNum, Integer pageSize);
}
