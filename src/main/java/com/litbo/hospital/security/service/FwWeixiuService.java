package com.litbo.hospital.security.service;

import com.litbo.hospital.security.bean.FwWeixiu;
import com.litbo.hospital.security.bean.FwWxqs;
import com.litbo.hospital.security.vo.FwWeiXiuIndexVo;
import com.litbo.hospital.security.vo.WeixiuIndexVo;
import com.litbo.hospital.security.vo.WxqrIndex;

/**
 * @author zjc
 * @create 2018-12-06 13:03
 */
public interface FwWeixiuService {


    /**
     * 配件请领页面显示
     * @param userId
     * @return
     */
    public String pjqlWxIndex(String userId);

    /**
     * 维修确认页面回显
     * @param fwId
     * @return
     */
    public WxqrIndex wxqsIndex(String fwId);

    /**
     * 维修主页面回显（过时）
     * @param fwId
     * @return
     */
    public WeixiuIndexVo weixiuIndex(String fwId);

    public FwWeiXiuIndexVo weixiuIndexVo(String fwId,String userId);

    /**
     * 添加维修
     * @param fwWeixiu
     * @param userId
     */
    public void addFwWeixiu(FwWeixiu fwWeixiu,String userId);

    /**
     * 添加维修确认
     * @param fwWxqs
     */
    public void addFwWxqs(FwWxqs fwWxqs,String userId);

    /**
     * 维修审核
     * @param userId
     */
    public void updateFwWxqs(String userId,String fwId);

}
