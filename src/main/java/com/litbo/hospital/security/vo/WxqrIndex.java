package com.litbo.hospital.security.vo;

import lombok.Data;

import java.util.List;

/**
 * @author zjc
 * @create 2018-12-20 15:25
 */
@Data
public class WxqrIndex {

    private FwInfoVo fwInfoVo;

    private List<PjVo> pjVoList;
}
