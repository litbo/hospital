package com.litbo.hospital.supervise.vo;

import java.util.List;

public class GroupSelectDetailVO {
    SGroupSelectVO groupSelectVO;
    List<GroupUserSelectVO> userSelectVOS;

    public SGroupSelectVO getGroupSelectVO() {
        return groupSelectVO;
    }

    public void setGroupSelectVO(SGroupSelectVO groupSelectVO) {
        this.groupSelectVO = groupSelectVO;
    }

    public List<GroupUserSelectVO> getUserSelectVOS() {
        return userSelectVOS;
    }

    public void setUserSelectVOS(List<GroupUserSelectVO> userSelectVOS) {
        this.userSelectVOS = userSelectVOS;
    }
}
