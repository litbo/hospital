package com.litbo.hospital.lifemanage.bean.vo;

import com.litbo.hospital.lifemanage.bean.SgLzfxxhbj;
import lombok.Data;

import java.util.List;

/**
 * 论证分析表实体类
 */
@Data
public class SgLzfxVO {
    /**
     * 申购单id
     */
    private String sgId;
    /**
     * 临床要求及评价
     */
    private String lzfxLcyqpj;
    /**
     * 技术参数
     */
    private String lzfxJscs;
    /**
     * 售后反馈
     */
    private String lzfxShfk;
    /**
     * 技术评估
     */
    private String lzfxJspg;
    /**
     * 选型理由
     */
    private String lzfxXxly;
    /**
     * 专家组意见
     */
    private String lzfxZjzyj;
    /**
     * 院领导意见
     */
    private String lzfxYldyj;
    /**
     * 院领导签字
     */
    private String lzfxYldqz;
    /**
     * 专家签字
     */
    private String lzfxZjqz;
    /**
     * 参考型号及报价列表
     */
    private List<SgLzfxxhbj> xhbjs;
}