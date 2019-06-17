package com.litbo.hospital.security.service;

import com.litbo.hospital.security.bean.FwWeixiu;
import com.litbo.hospital.security.bean.FwYwwx;
import com.litbo.hospital.security.vo.*;

/**
 * @author zjc
 * @create 2018-12-06 13:03
 */
public interface FwWeixiuService {

    /**
     * 院外维修
     * @param fwYwwx
     * @return
     */
    public int jumpYwwx(FwYwwx fwYwwx);

    /**
     * 配件请领
     * @param fwId
     * @return
     */
    public int jumpPj(String userId,String fwId);

    /**
     * 维修审核页面初始化
     * @param userId
     * @param fwId
     * @return
     */
    public FwWxqsShIndexVo wxqsShIndexVo(String userId,String fwId);

    /**
     * 科室确认页面初始化
     * @param userId
     * @param fwId
     * @return
     */
    public FwWxqrIndexVo wxqrIndexVo(String userId,String fwId);


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
    public int addFwWeixiu(FwWeixiu fwWeixiu,String userId);

    /**
     * 添加维修确认
     * @param fwWxqs
     */
    public void addFwWxqs(FwWxqsVo fwWxqs,String userId);

    /**
     * 维修审核
     * @param userId
     */
    public void updateFwWxqs(String userId,String fwId,Integer taskId);

}
