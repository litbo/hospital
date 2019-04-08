package com.litbo.hospital.security.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwFk;
import com.litbo.hospital.security.bean.FwHt;
import com.litbo.hospital.security.vo.FwHtXqVo;
import com.litbo.hospital.security.vo.HtVo;

/**
 * @author zjc
 * @create 2018-11-29 19:35
 */
public interface FwHtService {

    /**
     * 合同详情
     * @param id
     * @return
     */
    public FwHtXqVo findHtxq(String id);

    public int addFwHt(FwHt fwHt);


    public int addFwFk(FwFk fwFk);

    /**
     * 分页查询
     * @param pageNum 第几页
     * @param pageSize 每页个数
     * @return
     */
    public Result getAllFwHt(Integer pageNum, Integer pageSize);

    /**
     * 合同支付查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo getHtZfList(Integer pageNum, Integer pageSize);

    public HtVo getHtVoById(String id);
}
