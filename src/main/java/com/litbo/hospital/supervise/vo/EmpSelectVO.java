package com.litbo.hospital.supervise.vo;

import lombok.Data;

@Data
public class EmpSelectVO {

//    部门	编号	姓名	性别	学历	岗位  毕业院校
    private String bmName;
    private String userId;
    private String userXm;
    private String sex;
    private String xllb;
    private String zwlb;
    private String zggwlb;
    private String byyx;
    private Integer status;

}
