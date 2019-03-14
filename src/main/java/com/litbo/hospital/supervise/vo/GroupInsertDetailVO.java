package com.litbo.hospital.supervise.vo;

import com.litbo.hospital.supervise.bean.SGroupUser;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class GroupInsertDetailVO {
    private Integer groupId;
    private String bmId;
    private String groupName;
    private String userId1;
    private Date createTime;
    private String userId2;
    private Date shTime;
    private String shFlag;
    private String shYj;
    private List<SGroupUser> users;  // 科室成员


}
