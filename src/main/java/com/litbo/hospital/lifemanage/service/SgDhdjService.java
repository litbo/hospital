package com.litbo.hospital.lifemanage.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.vo.DhdjksjsVO;
import com.litbo.hospital.lifemanage.bean.vo.SgDhdjVO;

/**
 * 到货登记表Service接口
 */
public interface SgDhdjService {
    /**
     * 添加到货登记信息
     *
     * @param sgDhdjVO 到货登记信息
     */
    void insertSgDhdj(SgDhdjVO sgDhdjVO);

    /**
     * 查询科室接收的货物
     *
     * @param userId   当前用户id
     * @param pageNum  当前页数
     * @param pageSize 每页显示的记录数
     * @return PageInfo<DhdjksjsVO>
     */
    PageInfo<DhdjksjsVO> selectDjhwKsjs(String userId, Integer pageNum, Integer pageSize);

    /**
     * 科室接收
     *
     * @param djhwId 登记货物id
     * @param userId 登陆人id
     */
    void updateSgDhdjKsjs(String djhwId,String userId);

    /**
     * 科室接收货物详情信息
     *
     * @param djhwId 到货登记id
     * @return SgDhdjVO
     */
    SgDhdjVO selectSgDhdjDetails(String djhwId);
}
