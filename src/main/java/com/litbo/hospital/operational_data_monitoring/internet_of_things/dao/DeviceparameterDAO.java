package com.litbo.hospital.operational_data_monitoring.internet_of_things.dao;

import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.EqMacVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.SearchVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.Deviceparameter;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.DeviceparameterVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.dao
 * @Author: looli
 * @CreateTime: 2019-07-30 17:09
 * @Description: todo
 */
public interface DeviceparameterDAO {
    /**
     * 1.查询设备参数设置表信息
     * @return
     */



    @Select( "<script>"+
            "SELECT\n" +
                    "\tb.eq_zcbh,\n" +
                    "\tb.eq_name,\n" +
                    "\tb.eq_gg,\n" +
                    "\tb.eq_xh,\n" +
                    "\ts.bm_name,\n" +
                    "\td.end_point_ip as endPointIp ,\n" +
                    "\ti.MachineNumber as  MachineNumber \n" +
                    "\tFROM\n" +
                    "\tInspectDetail i\n" +
                    "\tinner JOIN DeviceParameter d ON d.MachineNumber = i.MachineNumber\n" +
                    "\tleft JOIN eq_info b ON d.DeviceCode = b.eq_zcbh\n" +
                    "\tleft JOIN s_bm s ON b.eq_bmid = s.bm_id"+
            "<where>"+
            "<if test='MachineNumber != null'>"+
            " i.MachineNumber like CONCAT('%',#{MachineNumber},'%')" +
            "</if>"+
            "<if test='bmId != null'>"+
            "and b.eq_bmid = #{bmId}"+
            "</if>"+
            "<if test='eqZcbh != null'>"+
            "and b.eq_zcbh like  CONCAT('%',#{eqZcbh},'%') "+"</if>"+
            "</where>"+
            " order by b.eq_zcbh DESC"+
            "</script>")
    List<DeviceparameterVO> selectAll(SearchVO searchVO);
   @Delete("delete from InspectDetailBack where MachineNumber=#{lwxbh}")
   int deleteLwxByLwxBh(String lwxbh);
    @Delete("delete from DeviceParameter where MachineNumber=#{lwxbh}")
    int deletLwxByLwxBh2(String lwxbh);
    @Select({ "<script>",
            "SELECT\n" +
                    "\tc.MacID,\n" +
                    "\tb.eq_name,\n" +
                    "\ta.EndPointIP,\n" +
                    "\td.bm_name, \n" +
                    "b.eq_sbbh,",
                    "b.eq_xh,",
                    "b.eq_gg",
                    "FROM\n" +
                    "\tDeviceParameter a\n" +
                    "\tLEFT JOIN eq_info b ON a.DeviceCode = b.eq_sbbh\n" +
                    "\tLEFT JOIN eq_mac_tab c ON b.eq_id = c.EquID\n" +
                    "\tLEFT JOIN s_bm d ON b.eq_bmid = d.bm_id \n" +
                    "WHERE\n" +
                    "\tc.MacID != '' \n" +
                    "\tAND ( SELECT COUNT(*) FROM eq_duty_tab WHERE eq_mac_id = c.MacID ) = 0",
                    "<if test='macid != null'>","and c.MacID = #{macid}","</if>",
                    "<if test='bmId != null'>","and b.eq_bmid = #{bmId}","</if>",
                    "<if test='eqSbbh != null'>","and b.eq_sbbh = #{eqSbbh}","</if>",
            "</script>"})
    List<DeviceparameterVO> selectNoDutyEq(SearchVO searchVO);

    /**
     * 2.查询设备联网信息
     * @param eqMacVO
     * @return
     */
    @Select({ "<script>",
            "SELECT\n" +
            "b.eq_id,\n" +
            "b.eq_name,\n" +
            "c.MacID,\n" +
            "a.EndPointIP,\n" +
            "c.hasPacs,\n" +
            "c.PMacID,\n" +
            "c.hasWorkBox,\n" +
            "c.MacRule, \n" +
            "b.eq_sbbh \n" +
            "FROM\n" +
            "DeviceParameter a\n" +
            "LEFT JOIN eq_info b ON a.DeviceCode = b.eq_sbbh\n" +
            "LEFT JOIN eq_mac_tab c ON c.EquID = b.eq_id",
            "<where>",
            "<if test='macip != null'>"," a.EndPointIP = #{macip}","</if>",
            "<if test='macid != null'>","and c.MacID = #{macid}","</if>",
            "</where>",
            "</script>"})
    DeviceparameterVO selectOne(EqMacVO eqMacVO);

    /**
     * 3.删除设备联网表信息
     * @param macId
     */
    @Delete("DELETE FROM eq_mac_tab where MacID = #{macId}")
    void delete(@Param("macId") String macId);

    /**
     * 4.更新设备参数设置表，设置设备编号为null
     */
    @Update("UPDATE DeviceParameter SET DeviceCode = NULL WHERE DeviceCode = #{DeviceCode}")
    void update(@Param("DeviceCode") String DeviceCode);

    /**
     * 根据ip修改对应的设备编号
     * @param deviceparameterVO
     */
    @Update("UPDATE DeviceParameter SET DeviceCode = #{eqSbbh} WHERE endPointIP = #{endPointIP}")
    void updateDeviceCode(DeviceparameterVO deviceparameterVO);

    /**
     * 5.删除设备联网表信息
     * @param macIds
     */
    @Delete({ "<script>",
            "DELETE FROM eq_mac_tab where MacID in\n",
            "<foreach item='id' collection='array' open='(' separator=',' close=')'> #{id} </foreach>"
            ,"</script>"})
    void deletes(String[] macIds);

    /**
     * 批量更新设备参数设置表，设置设备编号为null
     * @param DeviceCodes
     */
    @Update({ "<script>",
            "UPDATE DeviceParameter SET DeviceCode = NULL WHERE DeviceCode IN " +
                    "(SELECT b.eq_sbbh FROM eq_mac_tab a,eq_info b WHERE a.EquID = b.eq_id and a.MacID in" +
                    "<foreach item='id' collection='array' open='(' separator=',' close=')'> #{id} </foreach>",
                    " )"
            ,"</script>"})
    void updates(String[] DeviceCodes);

    /**
     * 设置设备参数表的设备编号
     * @param deviceparameterVO
     */
    @Update("update DeviceParameter set DeviceCode = #{eqSbbh} where EndPointIP = #{endPointIP}")
    void save(DeviceparameterVO deviceparameterVO);

    /*/**
     * 方法功能描述: my
     * @Param:
     * @Return:
     * @Description:
     * @Author: NCH
     * @Date: 2019/10/15 下午 3:07
     */

    @Select("select * from DeviceParameter where MachineNumber=#{lwybh}")
    Deviceparameter showOneLwxByLwyBh(String lwybh);
    @Update("update DeviceParameter\n" +
            "    set DeviceCode = #{deviceCode,jdbcType=VARCHAR},\n" +
            "      InspectType = #{inspectType,jdbcType=VARCHAR},\n" +
            "      KeepTime = #{keepTime,jdbcType=VARCHAR},\n" +
            "      StartElectic = #{startElectic,jdbcType=VARCHAR},\n" +
            "      EndElectic = #{endElectic,jdbcType=VARCHAR},\n" +
            "      InDistance = #{inDistance,jdbcType=VARCHAR},\n" +
            "      OutDistance = #{outDistance,jdbcType=VARCHAR},\n" +
            "      ImageStart = #{imageStart,jdbcType=VARCHAR},\n" +
            "      ImageEnd = #{imageEnd,jdbcType=VARCHAR},\n" +
            "      WeightStart = #{weightStart,jdbcType=VARCHAR},\n" +
            "      WeightEnd = #{weightEnd,jdbcType=VARCHAR},\n" +
            "      PECounting = #{PECounting,jdbcType=VARCHAR},\n" +
            "      Spare = #{spare,jdbcType=VARCHAR},\n" +
            "      HeartTime = #{heartTime,jdbcType=VARCHAR},\n" +
            "      RepeatInterval = #{repeatInterval,jdbcType=VARCHAR},\n" +
            "      end_point_ip = #{endPointIP,jdbcType=VARCHAR},\n" +
            "      EndPointPort = #{endPointPort,jdbcType=VARCHAR},\n" +
            "      RepairRemind = #{repairRemind,jdbcType=VARCHAR},\n" +
            "      MaintainRemind = #{maintainRemind,jdbcType=VARCHAR},\n" +
            "      SumWorkTime = #{sumWorkTime,jdbcType=VARCHAR},\n" +
            "      SumWaitTime = #{sumWaitTime,jdbcType=VARCHAR},\n" +
            "      ClearTime = #{clearTime,jdbcType=TIMESTAMP},\n" +
            "      SumCloseTime = #{sumCloseTime,jdbcType=VARCHAR},\n" +
            "      SumRepairTime = #{sumRepairTime,jdbcType=VARCHAR},\n" +
            "      SumMaintainTime = #{sumMaintainTime,jdbcType=VARCHAR},\n" +
            "      UnRepairOpenTime = #{unRepairOpenTime,jdbcType=VARCHAR},\n" +
            "      StopTime = #{stopTime,jdbcType=VARCHAR},\n" +
//            "      IfHaveDetail = #{ifHaveDetail,jdbcType=BIT},\n" +
            "      MaxElectic = #{maxElectic,jdbcType=VARCHAR},\n" +
            "      WaiteElectic = #{waiteElectic,jdbcType=VARCHAR},\n" +
            "      Remark1 = #{remark1,jdbcType=VARCHAR},\n" +
            "      Remark2 = #{remark2,jdbcType=VARCHAR},\n" +
            "      Remark3 = #{remark3,jdbcType=VARCHAR},\n" +
            "      Remark4 = #{remark4,jdbcType=VARCHAR},\n" +
            "      WaitPower = #{waitPower,jdbcType=VARCHAR},\n" +
            "      WorkPower = #{workPower,jdbcType=VARCHAR},\n" +
            "      Voltage = #{voltage,jdbcType=VARCHAR},\n" +
            "      ReportPrice = #{reportPrice,jdbcType=VARCHAR},\n" +
            "      CouplingAgentPrice = #{couplingAgentPrice,jdbcType=VARCHAR},\n" +
            "      FilmPrice = #{filmPrice,jdbcType=VARCHAR},\n" +
            "      ReagentPersonPrice = #{reagentPersonPrice,jdbcType=VARCHAR},\n" +
            "      ReagentItemPrice = #{reagentItemPrice,jdbcType=VARCHAR},\n" +
            "      UserType = #{userType,jdbcType=VARCHAR},\n" +
            "      MaxCurrent = #{maxCurrent,jdbcType=VARCHAR},\n" +
            "      MinCurrent = #{minCurrent,jdbcType=VARCHAR},\n" +
            "      RepairFees = #{repairFees,jdbcType=VARCHAR},\n" +
            "      MaintainFees = #{maintainFees,jdbcType=VARCHAR},\n" +
            "      QulityNum = #{qulityNum,jdbcType=VARCHAR},\n" +
            "      ErrorRate = #{errorRate,jdbcType=VARCHAR},\n" +
            "      MaintainStatus = #{maintainStatus,jdbcType=VARCHAR},\n" +
            "      SoftVerChange = #{softVerChange,jdbcType=VARCHAR},\n" +
            "      HardCloseFlag = #{hardCloseFlag,jdbcType=VARCHAR}\n" +
            "    where MachineNumber = #{machineNumber,jdbcType=VARCHAR}")
    int  updateOneLwxByLwyBh(Deviceparameter deviceparameter);

}
