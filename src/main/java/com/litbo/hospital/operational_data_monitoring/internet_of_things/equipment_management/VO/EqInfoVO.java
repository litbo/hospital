package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.looli.VO
 * @Author: looli
 * @CreateTime: 2019-07-21 10:59
 * @Description: todo
 */
@Data
public class EqInfoVO {
    /**科室名称*/
    private String bmName;
    /**设备id*/
    private String eqId;
    /**设备名称*/
    private String eqName;
    /**设备编号*/
    private String eqSbbh;
    /**资产编号*/
    private String eqZcbh;
    /**设备规格*/
    private String eqGg;
    /**设备型号*/
    private String eqXh;
    /**启用时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date eqQysj;
    /**品牌*/
    private String eqPp;
}
