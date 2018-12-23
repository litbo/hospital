package com.litbo.hospital.lifemanage.bean.vo;

import lombok.Data;

/**
 * SgInfoLzfxVO 查询满足论证分析条件的申购单
 *
 * @author Administrator on 2018-12-12
 */
@Data
public class SgInfoLzfxVO {
    /**
     * 申购单id
     */
    private String id;
    /**
     * 申购单编号
     */
    private String bh;
    /**
     * 申购单对应的品名
     */
    private String pmName;
}
