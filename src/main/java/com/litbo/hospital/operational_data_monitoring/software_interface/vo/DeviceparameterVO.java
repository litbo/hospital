package com.litbo.hospital.operational_data_monitoring.software_interface.vo;

import lombok.Data;

import java.util.Objects;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.vo
 * @Author: looli
 * @CreateTime: 2019-07-30 17:37
 * @Description: todo
 */
@Data
public class DeviceparameterVO {


    /**资产编号*/
    private String deviceCode;
    /**终端ip*/
    private String endPointIp;
    /**设备名称*/
    private String eqName;
    /**设备编号*/
    private String eqSbbh;
    /**设备id*/
    private String equid;
    /**设备规格*/
    private String eqGg;
    /**设备型号*/
    private String eqXh;
    private String eqGgXh;
    /**有无pacs终端*/
    private String haspacs;
    /**有无工作量记录*/
    private String hasworkbox;
    /**记录规则*/
    private String macrule;
    /**pacs终端编号*/
    private String pmacid;
    /**仪联网id*/
    private String MacID;
    /**资产编号*/
    private String eqZcbh;
    /**仪联网表id*/
    private String id;
    /**科室id*/
    private String eqBmid;
    /**科室名称*/
    private String bmName;
    /**设备id*/
    private String eqId;
    /*终端编号*/
    private String MachineNumber;
    /*联网仪IP*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceparameterVO that = (DeviceparameterVO) o;
        return MachineNumber.equals(that.MachineNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MachineNumber);
    }
}
