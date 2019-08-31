package com.litbo.hospital.lifemanage.bean.vo;

import com.litbo.hospital.supervise.bean.SEmp;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 大型医学装备考察报告VO
 */
@Data
public class SgDxyxzbkcVO {
    /**
     * 申购单id
     */
    private String sgId;
    /**
     * 时间
     */
    private Date dxzbSj;
    /**
     * 考察地点及内容
     */
    private String dxzbDdnr;
    /**
     * 结论意见
     */
    private String dxzbYj;
    /**
     * 考察人员列表
     */
    private List<String> userIds;
    /**
     * 人员信息
     */
    private List<SEmp> users;
}
