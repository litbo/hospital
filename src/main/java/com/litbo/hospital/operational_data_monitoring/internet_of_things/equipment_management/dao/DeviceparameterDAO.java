package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.dao;

import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.Deviceparameter;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.DeviceparameterVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.dao
 * @Author: looli
 * @CreateTime: 2019-07-30 17:09
 * @Description: todo
 */
public interface DeviceparameterDAO {
    /**
     * 查询设备参数设置表信息
     * @return
     */
    @Select("SELECT b.eq_sbbh,b.eq_name,b.eq_gg,b.eq_xh,a.DeviceCode,a.EndPointIP FROM DeviceParameter a LEFT JOIN eq_info b \n" +
            "on a.DeviceCode = b.eq_zcbh")
    List<DeviceparameterVO> selectAll();

    /**
     * 查询设备联网信息
     * @param ip
     * @return
     */
    @Select("SELECT\n" +
            "b.eq_name,\n" +
            "c.MacID,\n" +
            "a.EndPointIP,\n" +
            "c.hasPacs,\n" +
            "c.PMacID,\n" +
            "c.hasWorkBox,\n" +
            "c.MacRule\n" +
            "FROM\n" +
            "DeviceParameter a\n" +
            "LEFT JOIN eq_info b ON a.DeviceCode = b.eq_zcbh\n" +
            "LEFT JOIN eq_mac_tab c ON c.EquID = b.eq_id \n" +
            "WHERE\n" +
            "a.EndPointIP = #{ip}")
    DeviceparameterVO selectOne(@Param("ip") String ip);

}
