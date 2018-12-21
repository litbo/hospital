package com.litbo.hospital.supervise.vo;

import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.bean.SEmp;

import java.util.List;

public class GroupReadyForSubmitVO {  // 数据准备
    //所有部门
    private List<SBm> bms;
    //所有审核人
    private List<SEmp> shrs;

    public List<SBm> getBms() {
        return bms;
    }

    public void setBms(List<SBm> bms) {
        this.bms = bms;
    }

    public List<SEmp> getShrs() {
        return shrs;
    }

    public void setShrs(List<SEmp> shrs) {
        this.shrs = shrs;
    }
}
