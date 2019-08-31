package com.litbo.hospital.lifemanage.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.SgYs;
import com.litbo.hospital.lifemanage.bean.vo.SgYsListVO;

/**
 * 商务/临床/技术验收表Service接口
 */
public interface SgYsService {
    /**
     * 需验收设备列表
     *
     * @param pageNum  当前页数
     * @param pageSize 每页显示的记录数
     * @return PageInfo<SgYsListVO>
     */
    PageInfo<SgYsListVO> sgYsList(Integer pageNum, Integer pageSize);

    /**
     * 添加验收信息
     *
     * @param sgYs 验收信息
     */
    void insertSgYs(SgYs sgYs);
}
