package com.litbo.hospital.security.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.bean.FwWxf;
import com.litbo.hospital.security.vo.*;

import java.util.Date;
import java.util.List;

/**
 * @author zjc
 * @create 2018-12-09 9:44
 */
public interface FwWxfService {

    /**
     * 维修费审核
     * @param id
     * @param wxfSpyj
     * @param wxfSptime
     * @return
     */
    public int updateWxf(Integer id , String wxfSpyj, Date wxfSptime);

    /**
     * 维修费审核初始化
     * @param id
     * @param userId
     * @return
     */
    public FwWxfShIndexVo wxfShIndex(Integer id,String userId);

    /**
     * 维修费列表页面
     * @param userId
     * @return
     */
    public PageInfo<WxfListVo> WxfList(String userId, Integer pageNum, Integer pageSize, String fwId, String eqName);


    public List<FwIdSelectVo> wxfGetEq(String userId);

    /**
     * 审核（过时）
     * @param id
     * @return
     */
    public WxfIndexVo wxfShIndex(Integer id);

    /**
     * 申请维修费主页面
     * @param fwId
     * @param userId
     * @return
     */
    public FwWxfIndexVo fwWxfIndex(String fwId, String userId);

    /**
     * 申请维修费主页面显示(过时)
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
