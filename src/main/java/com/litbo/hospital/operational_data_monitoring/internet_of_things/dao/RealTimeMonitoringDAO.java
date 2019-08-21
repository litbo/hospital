package com.litbo.hospital.operational_data_monitoring.internet_of_things.dao;

import com.litbo.hospital.operational_data_monitoring.internet_of_things.real_time_monitoring.bean.RealTimeMonitoring;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.real_time_monitoring.vo.ResultVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.real_time_monitoring.vo.SearchOV;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 实时监视
 */
public interface RealTimeMonitoringDAO {
    @Select({"<script>",
            "SELECT MAX\n" +
                    "\t( d.bm_name ) AS bmName,\n" +
                    "\tc.eq_sbbh eqSbbh,\n" +
                    "\tMAX ( a.BeginTime ) AS TIME,\n" +
                    "\tMAX ( c.eq_name ) AS eqName,\n" +
                    "\tMAX ( c.eq_xh ) AS eqXh,\n" +
                    "\tMAX ( a.NewStatus ) AS status,\n" +
                    "\tMAX(c.eq_syzt) as syzt\n" +
                    "FROM\n" +
                    "\tInspectDetail a\n" +
                    "\tLEFT JOIN eq_mac_tab b ON a.MachineNumber = b.PMacID\n" +
                    "\t,\n" +
                    "\teq_info c,\n" +
                    "\ts_bm d \n" +
                    "\t ,eq_name e,\n" +
                    "\teq_sbjcfl f,\n" +
                    "\teq_jiancheng g\n" +
                    "WHERE\n" +
                    "\tc.eq_id = b.EquID \n" +
                    "\tAND c.eq_bmid = d.bm_id \n" +
                    "\tAND c.eq_nid = e.id \n" +
                    "\tAND e.c_BID = f.id \n" +
                    "\tAND f.c_EquSimpleId = g.id \n" +
                    "<if test='cEquCate != null'>","and  f.c_EquCate= #{cEquCate}","</if>",
                    "<if test='bmId != null'>","and  d.bm_id = #{bmId}","</if>",
                    "<if test='cIsLife != null'>","and  f.c_IsLife= #{cIsLife}","</if>",
                    "<if test='status != null'>","and  a.NewStatus = #{status}","</if>",
                    "<if test='syzt != null'>","and c.eq_syzt = #{syzt}","</if>",
                    "<if test='cAName != null'>","and  g.c_AName= #{cAName}","</if>",
                    "GROUP BY\n" +
                    "\tc.eq_sbbh",
            "</script>"})
    List<RealTimeMonitoring> select1(SearchOV searchOV);

    /**
     * 查询设备再用
     * @return
     */
    @Select("SELECT COUNT\n" +
            "\t( * ) AS num \n" +
            "FROM\n" +
            "\t(\n" +
            "\tSELECT\n" +
            "\t\ta.MachineNumber \n" +
            "\tFROM\n" +
            "\t\tInspectDetail a,\n" +
            "\t\teq_info b,\n" +
            "\t\teq_mac_tab c \n" +
            "\tWHERE\n" +
            "\t\tc.PMacID = a.MachineNumber \n" +
            "\t\tAND b.eq_id = c.EquID \n" +
            "\t\tAND b.eq_syzt = \'在用\' \n" +
            "\tGROUP BY\n" +
            "\ta.MachineNumber \n" +
            "\t) d")
    ResultVO select21();
    /**
     * 查询设备故障
     * @return
     */
    @Select("SELECT COUNT\n" +
            "\t( * ) AS num \n" +
            "FROM\n" +
            "\t(\n" +
            "\tSELECT\n" +
            "\t\ta.MachineNumber \n" +
            "\tFROM\n" +
            "\t\tInspectDetail a,\n" +
            "\t\teq_info b,\n" +
            "\t\teq_mac_tab c \n" +
            "\tWHERE\n" +
            "\t\tc.PMacID = a.MachineNumber \n" +
            "\t\tAND b.eq_id = c.EquID \n" +
            "\t\tAND b.eq_syzt = \'故障\' \n" +
            "\tGROUP BY\n" +
            "\ta.MachineNumber \n" +
            "\t) d")
    ResultVO select22();
    /**
     * 查询设备维修
     * @return
     */
    @Select("SELECT COUNT\n" +
            "\t( * ) AS num \n" +
            "FROM\n" +
            "\t(\n" +
            "\tSELECT\n" +
            "\t\ta.MachineNumber \n" +
            "\tFROM\n" +
            "\t\tInspectDetail a,\n" +
            "\t\teq_info b,\n" +
            "\t\teq_mac_tab c \n" +
            "\tWHERE\n" +
            "\t\tc.PMacID = a.MachineNumber \n" +
            "\t\tAND b.eq_id = c.EquID \n" +
            "\t\tAND b.eq_syzt = \'维修\' \n" +
            "\tGROUP BY\n" +
            "\ta.MachineNumber \n" +
            "\t) d")
    ResultVO select23();


    /**
     * 查询设备工作
     * @return
     */
    @Select("SELECT COUNT\n" +
            "\t( * ) AS num \n" +
            "FROM\n" +
            "\t(\n" +
            "\tSELECT MAX\n" +
            "\t\t( MachineNumber ) AS a,\n" +
            "\t\tMAX ( BeginTime ) AS c \n" +
            "\tFROM\n" +
            "\t\tInspectDetail \n" +
            "\tWHERE\n" +
            "\t\tNewStatus = '01' \n" +
            "\t\tAND BeginTime >= getdate( ) \n" +
            "\tGROUP BY\n" +
            "\tMachineNumber \n" +
            "\t) b")
    ResultVO select31();
    /**
     * 查询设备待机
     * @return
     */
    @Select("SELECT COUNT\n" +
            "\t( * ) AS num \n" +
            "FROM\n" +
            "\t(\n" +
            "\tSELECT MAX\n" +
            "\t\t( MachineNumber ) AS a,\n" +
            "\t\tMAX ( BeginTime ) AS c \n" +
            "\tFROM\n" +
            "\t\tInspectDetail \n" +
            "\tWHERE\n" +
            "\t\tNewStatus = '02' \n" +
            "\t\tAND BeginTime >= getdate( ) \n" +
            "\tGROUP BY\n" +
            "\tMachineNumber \n" +
            "\t) b")
    ResultVO select32();
    /**
     * 查询设备关机
     * @return
     */
    @Select("SELECT COUNT\n" +
            "\t( * ) AS num \n" +
            "FROM\n" +
            "\t(\n" +
            "\tSELECT MAX\n" +
            "\t\t( MachineNumber ) AS a,\n" +
            "\t\tMAX ( BeginTime ) AS c \n" +
            "\tFROM\n" +
            "\t\tInspectDetail \n" +
            "\tWHERE\n" +
            "\t\tNewStatus = '00' \n" +
            "\t\tAND BeginTime >= getdate( ) \n" +
            "\tGROUP BY\n" +
            "\tMachineNumber \n" +
            "\t) b")
    ResultVO select33();

}
