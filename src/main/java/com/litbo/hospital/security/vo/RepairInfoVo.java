package com.litbo.hospital.security.vo;

import lombok.Data;

import java.util.List;

/**
 * @author zjc
 * @create 2019-04-18 20:52
 */
@Data
public class RepairInfoVo {

    private Integer wxEqCount;

    private Integer slEqCount;

    private Integer wslEqCount;

    private Integer gJjxEqCount;

    private Integer zJjxEqCount;

    private Integer dJjxEqCount;

    private List<wxInfoListVo> wxInfoList;

}
