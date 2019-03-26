package com.litbo.hospital.supervise.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class GroupSelectDetailVO {
    private Integer groupId;
    private String bmId;
    private String bmName;
    private String groupName;
    private String userId1;
    private String userName1;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;
    private String userId2;
    private String userName2;
    List<GroupUserSelectVO> userSelectVOS;

}
