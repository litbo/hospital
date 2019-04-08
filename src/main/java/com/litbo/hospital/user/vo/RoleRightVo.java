package com.litbo.hospital.user.vo;



import com.litbo.hospital.user.bean.SRight;
import com.litbo.hospital.user.bean.SysLogo;
import lombok.Data;

import java.util.List;
@Data
public class RoleRightVo {

    private  String role;
    private  LiveEmpVo  emp;
    private SysLogo logos;
    private List<SRight> rightList;
}
