package com.litbo.hospital.lifemanage.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 时间上限和下限VO
 *
 * @author Administrator on 2018-12-19
 */
@Data
public class DateLowerAndUpperVO {
    /**
     * 时间上限
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date lower;
    /**
     * 时间下限
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date upper;

    /**
     * pageNum
     */
    private Integer pageNum = 1;

    /**
     * pageSize
     */
    private Integer pageSize = 10;
}
