package com.litbo.hospital.security.service;

import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwHt;

/**
 * @author zjc
 * @create 2018-11-29 19:35
 */
public interface FwHtService {

    public int addFwHt(FwHt fwHt);

    /**
     * 分页查询
     * @param pageNum 第几页
     * @param pageSize 每页个数
     * @return
     */
    public Result getAllFwHt(Integer pageNum, Integer pageSize);
}
