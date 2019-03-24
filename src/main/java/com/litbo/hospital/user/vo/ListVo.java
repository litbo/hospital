package com.litbo.hospital.user.vo;

import lombok.Data;

import java.util.List;

@Data
public class ListVo {

    List<String> userIds;
    List<String> eqIds;

    List<String> ggxzIds;
    List<String> ggIds;
}
