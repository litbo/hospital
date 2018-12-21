package com.litbo.hospital.supervise.vo;

import com.litbo.hospital.supervise.bean.SZhidu;

public class ZhiduSubmitVO {
    private SZhidu sZhidu;   //制度信息对象
    private String shrId;   //审核人id

    public SZhidu getsZhidu() {
        return sZhidu;
    }

    public void setsZhidu(SZhidu sZhidu) {
        this.sZhidu = sZhidu;
    }

    public String getShrId() {
        return shrId;
    }

    public void setShrId(String shrId) {
        this.shrId = shrId;
    }
}
