package com.litbo.hospital.efficiency.vo;

import lombok.Data;

/**
 *  效率等级设置
 */
@Data
public class LevelVO {

    /** 利用率 */
    Integer using;

    /** 闲置率 */
    Integer idling;

}
