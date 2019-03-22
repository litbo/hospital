package com.litbo.hospital.user.vo;


import com.litbo.hospital.user.bean.SRight;
import lombok.Data;

import java.util.List;
@Data
public class RoleRightVo {

    private  String role;
    private List<SRight> rightList;
}
