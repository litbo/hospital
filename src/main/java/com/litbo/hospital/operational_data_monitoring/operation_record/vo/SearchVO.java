package com.litbo.hospital.operational_data_monitoring.operation_record.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.operation_record.vo
 * @Author: looli
 * @CreateTime: 2019-07-23 10:50
 * @Description: 搜索条件
 */
@Data
public class SearchVO {
    /**部门编号*/
    private String bmId;
    /**品名拼音码*/
    private String pmpym;
    /**状态标识*/
    private String flag;
    /**仪联网编号*/
    private String macid;
    /**起始时间*/
    private Date startTime;
    /**今天*/
    private String Nowadays;
    /**结束时间*/
    private Date endTime;

}
