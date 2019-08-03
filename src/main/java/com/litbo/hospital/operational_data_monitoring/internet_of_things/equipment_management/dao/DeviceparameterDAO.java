package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.dao;

import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.EqMacVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.SearchVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.Deviceparameter;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.DeviceparameterVO;
import org.apache.ibatis.annotations.*;

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
     * 1.查询设备参数设置表信息
     * @return
     */
    @Select({ "<script>",
            "SELECT\n" +
                    "b.eq_sbbh,b.eq_name,b.eq_gg,b.eq_xh,c.MacID,a.EndPointIP \n" +
                    "FROM\n" +
                    "DeviceParameter a\n" +
                    "LEFT JOIN eq_info b ON a.DeviceCode = b.eq_zcbh\n" +
                    "LEFT JOIN eq_mac_tab c ON b.eq_id = c.EquID",
            "<where>",
            "<if test='macid != null'>","and c.MacID = #{macid}","</if>",
            "<if test='bmId != null'>","and b.eq_bmid = #{bmId}","</if>",
            "<if test='eqSbbh != null'>","and b.eq_sbbh = #{eqSbbh}","</if>",
            "</where>"
            ,"</script>"})
    List<DeviceparameterVO> selectAll(SearchVO searchVO);

    /**
     * 2.查询设备联网信息
     * @param eqMacVO
     * @return
     */
    @Select({ "<script>",
            "SELECT\n" +
            "b.eq_name,\n" +
            "c.MacID,\n" +
            "a.EndPointIP,\n" +
            "c.hasPacs,\n" +
            "c.PMacID,\n" +
            "c.hasWorkBox,\n" +
            "c.MacRule, \n" +
            "a.DeviceCode \n" +
            "FROM\n" +
            "DeviceParameter a\n" +
            "LEFT JOIN eq_info b ON a.DeviceCode = b.eq_zcbh\n" +
            "LEFT JOIN eq_mac_tab c ON c.EquID = b.eq_id",
            "where a.EndPointIP = #{macip}",
            "<if test='macid != null'>","and c.MacID = #{macid}","</if>",
            "</script>"})
    DeviceparameterVO selectOne(EqMacVO eqMacVO);

    /**
     * 删除设备联网表信息
     * @param macId
     */
    @Delete("DELETE FROM eq_mac_tab where MacID = #{macId}")
    void delete(@Param("macId") String macId);

    /**
     * 更新设备参数设置表，设置设备编号为null
     */
    @Update("UPDATE DeviceParameter SET DeviceCode = NULL WHERE DeviceCode = #{DeviceCode}")
    void update(@Param("DeviceCode") String DeviceCode);

    /**
     * 设置设备参数表的设备编号
     * @param deviceparameterVO
     */
    @Update("update DeviceParameter set DeviceCode = #{eqSbbh} where EndPointIP = #{endPointIP}")
    void save(DeviceparameterVO deviceparameterVO);

}
