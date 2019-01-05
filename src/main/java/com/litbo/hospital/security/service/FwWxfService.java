package com.litbo.hospital.security.service;

import com.litbo.hospital.security.bean.FwWxf;
import com.litbo.hospital.security.vo.WxfIndexVo;

import java.util.List;

/**
 * @author zjc
 * @create 2018-12-09 9:44
 */
public interface FwWxfService {

    public List<String> wxfGetEq(String userId);

    /**
     * 审核
     * @param id
     * @return
     */
    public WxfIndexVo wxfShIndex(Integer id);

    /**
     * 申请维修费主页面显示
     * @param fwId
     * @return
     */
    public WxfIndexVo wxfIndex(String fwId,String userId);

    /**
     * 添加
     * @param fwWxf
     */
    public void addFwWxf(FwWxf fwWxf);

    /**
     * 审核修改
     * @param userId
     * @param status
     * @param spyj
     * @param fwId
     */
    public void updateFwWxf(String userId,int status,String spyj,String fwId);

}
