package com.litbo.hospital.security.service;

import com.litbo.hospital.security.bean.FwWxnrzd;
import com.litbo.hospital.security.vo.WxnrzdIndexVo;

import java.util.List;

public interface FwWxnrzdService {

    List<FwWxnrzd> selectFwWxnrzd(int parentId);

    public WxnrzdIndexVo wxnrZdIndex(Integer gzyId, Integer gzmxId);
}
