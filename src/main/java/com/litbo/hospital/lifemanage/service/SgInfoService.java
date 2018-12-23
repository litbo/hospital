package com.litbo.hospital.lifemanage.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.vo.SgInfoLzfxVO;
import com.litbo.hospital.lifemanage.bean.vo.SgInfoSumAuditListVO;
import com.litbo.hospital.lifemanage.bean.vo.SgInfoVO;
import com.litbo.hospital.lifemanage.bean.vo.ShVO;

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
     * @param sgInfoSumAuditListVO 条件信息
     * @param userId               登陆人id
     * @param pageNum              页数
     * @param pageSize             每页显示记录数
     * @return SgInfoSumAuditListVO
     */
    PageInfo<SgInfoSumAuditListVO> selectSgInfoKsshList(SgInfoSumAuditListVO sgInfoSumAuditListVO, String userId, Integer pageNum, Integer pageSize);

    /**
     * 显示申购单工程处审核列表
     *
     * @param sgInfoSumAuditListVO 条件信息
     * @param pageNum              页数
     * @param pageSize             每页显示记录数
     * @return SgInfoSumAuditListVO
     */
    PageInfo<SgInfoSumAuditListVO> selectSgInfoGccshList(SgInfoSumAuditListVO sgInfoSumAuditListVO, Integer pageNum, Integer pageSize);

    /**
     * 医学工程处审核
     *
     * @param shVO 审核表单VO
     */
    void updateSgInfoYxgccsh(ShVO shVO);

    /**
     * 显示申购单装备委员会审核列表
     *
     * @param sgInfoSumAuditListVO 条件信息
     * @param pageNum              页数
     * @param pageSize             每页显示记录数
     * @return SgInfoSumAuditListVO
     */
    PageInfo<SgInfoSumAuditListVO> selectSgInfoSgZbwyhhyList(SgInfoSumAuditListVO sgInfoSumAuditListVO, Integer pageNum, Integer pageSize);

    /**
     * 装备委员会审核
     *
     * @param shVO 审核表单VO
     */
    void updateSgInfoZbwyhhy(ShVO shVO);

    /**
     * 显示申购单院办公室审核列表
     *
     * @param sgInfoSumAuditListVO 条件信息
     * @param pageNum              页数
     * @param pageSize             每页显示记录数
     * @return PageInfo<SgInfoSumAuditListVO>
     */
    PageInfo<SgInfoSumAuditListVO> selectSgInfoYbgsShList(SgInfoSumAuditListVO sgInfoSumAuditListVO, Integer pageNum, Integer pageSize);

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
}
