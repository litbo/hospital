package com.litbo.hospital.supervise.vo;

import com.litbo.hospital.supervise.bean.SGroup;
import com.litbo.hospital.supervise.bean.SGroupUser;

import java.util.List;

public class GroupInsertDetailVO {
    private SGroup group;   // 科室管理
    private List<SGroupUser> users;  // 科室成员

    public SGroup getGroup() {
        return group;
    }

    public void setGroup(SGroup group) {
        this.group = group;
    }

    public List<SGroupUser> getUsers() {
        return users;
    }

    public void setUsers(List<SGroupUser> users) {
        this.users = users;
    }
}
