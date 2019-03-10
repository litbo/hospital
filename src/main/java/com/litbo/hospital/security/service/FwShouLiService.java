package com.litbo.hospital.security.service;

import com.litbo.hospital.security.bean.FwShouli;
import com.litbo.hospital.security.vo.FwShouLiIndexVo;
import com.litbo.hospital.security.vo.ShouliIndexVo;

import java.util.List;

/**
 * @author zjc
 * @create 2018-12-06 9:27
 * 受理
 */
public interface FwShouLiService {

    /**
     * 初始化受理页面
     * @param fwId
     * @param userId
     * @return
     */
    public FwShouLiIndexVo shouLiIndexVo(String fwId, String userId);

    /**
     * 初始化受理页面 (过时)
     * @param fwId
     * @param userId
     * @return
     */
    public ShouliIndexVo shouliIndex(String fwId, String userId);

    /**
     * 保修单受理
     * @param fwShouli
     */
    public void addShouli(FwShouli fwShouli);

    /**
     * 根据受理人获取所有的保修单id
     * @param userId
     * @return
     */
    public List<String> getFWIdBySlrId(String userId);
}
