package com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.dao;

import com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.vo.OperationRecord;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.vo.SearchVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.dao
 * @Author: looli
 * @CreateTime: 2019-08-07 10:08
 * @Description: 设备使用情况备份表操作
 */
public interface InspectdetailbackDAO {

    /**
     * 查询符合条件的数据
     * @param searchVO
     * @return
     */
    @Select({"<script>",
             "SELECT\n" +
                    "\td.bm_name,\n" +
                    "\tc.eq_sbbh,\n" +
                    "\tc.eq_zcbh,\n" +
                    "\tc.eq_name,\n" +
                    "\tb.MacID,\n" +
                    "\ta.NewStatus,\n" +
                    "\ta.BeginTime,\n" +
                    "\ta.EndTime \n" +
                    "FROM\n" +
                    "\thospital.dbo.InspectDetailback a,\n" +
                    "\thospital.dbo.eq_mac_tab b,\n" +
                    "\thospital.dbo.eq_info c,\n" +
                    "\thospital.dbo.s_bm d \n" +
                    "WHERE\n" +
                    "\ta.MachineNumber = b.PMacID \n" +
                    "\tAND b.EquID = c.eq_id \n" +
                    "\tAND c.eq_bmid = d.bm_id \n" +
                    "\tAND CONVERT ( VARCHAR ( 100 ), a.BeginTime, 23 ) &gt;= #{beginTime}",
                    "\tAND CONVERT ( VARCHAR ( 100 ), a.EndTime, 23 )   &lt;= #{endTime}",
            "<if test='macid != null'>"," and b.MacID = #{macid}","</if>",
            "<if test='bmId != null'>"," and d.bm_id = #{bmId}","</if>",
            "<if test='eqSbbh != null'>"," and c.eq_sbbh = #{eqSbbh}","</if>",
             "ORDER BY a.BeginTime"
            ,"</script>"})
    List<OperationRecord> select(SearchVO searchVO);

    /**
     * 查询符合条件的数据
     * @param searchVO
     * @return
     */
    @Select({"<script>",
            "SELECT\n" +
                    "\td.bm_name,\n" +
                    "\tc.eq_sbbh,\n" +
                    "\tc.eq_zcbh,\n" +
                    "\tc.eq_name,\n" +
                    "\tb.MacID,\n" +
                    "min(a.BeginTime) as beginTime,",
            "\tCOUNT(a.WorkNums) as workNums\n" +
                    "FROM\n" +
                    "\thospital.dbo.InspectDetail a,\n" +
                    "\thospital.dbo.eq_mac_tab b,\n" +
                    "\thospital.dbo.eq_info c,\n" +
                    "\thospital.dbo.s_bm d \n" +
                    "WHERE\n" +
                    "\ta.MachineNumber = b.PMacID \n" +
                    "\tAND b.EquID = c.eq_id \n" +
                    "\tAND c.eq_bmid\t= d.bm_id \n" +
                    "\tAND CONVERT ( VARCHAR ( 100 ), a.BeginTime, 23 ) &gt;= #{beginTime}",
                    "\tAND CONVERT ( VARCHAR ( 100 ), a.EndTime, 23 )   &lt;= #{endTime}",
            "<if test='macid != null'>"," and b.MacID = #{macid}","</if>",
            "<if test='bmId != null'>"," and d.bm_id = #{bmId}","</if>",
            "<if test='eqSbbh != null'>"," and c.eq_sbbh = #{eqSbbh}","</if>",
            "GROUP BY\n" +
                    "\td.bm_name,\n" +
                    "\tc.eq_sbbh,\n" +
                    "\tc.eq_zcbh,\n" +
                    "\tc.eq_name,\n" +
                    "\tb.MacID",
            "</script>"})
    List<OperationRecord> select2(SearchVO searchVO);

    /**
     * 按日月年不同的情况显示数据
     * @param searchVO
     * @return
     */
    @Select({"<script>",
            "SELECT\n" +
                    "\tstandby.bm_name,\n" +
                    "\tstandby.eq_sbbh,\n" +
                    "\tstandby.eq_name,\n" +
                    "\tstandby.eq_xh,\n" +
                    "\tstandby.a AS standbyTime,\n" +
                    "\tworks.a AS workHours\n" +
                    "FROM\n" +
                    "\t(\n" +
                    "\tSELECT\n" +
                    "\t\ta.MachineNumber,\n" +
                    "\t\td.bm_name,\n" +
                    "\t\tc.eq_sbbh,\n" +
                    "\t\tc.eq_name,\n" +
                    "\t\tc.eq_xh,\n" +
                    "\t\tMAX(e.pym) as pym,\n" +
                    "\t\tMAX(d.bm_id) as bmId,\n" +
                    "\t\tSUM ( datediff( SECOND, a.BeginTime, a.EndTime ) ) AS 'a' \n" +
                    "\tFROM\n" +
                    "\t\thospital.dbo.InspectDetailback a,\n" +
                    "\t\thospital.dbo.eq_mac_tab b,\n" +
                    "\t\thospital.dbo.eq_info c,\n" +
                    "\t\thospital.dbo.s_bm d,\n" +
                    "\t\thospital.dbo.eq_pm e \n" +
                    "\tWHERE\n" +
                    "\t\ta.MachineNumber = b.PMacID \n" +
                    "\t\tAND b.EquID = c.eq_id \n" +
                    "\t\tAND c.eq_bmid = d.bm_id \n" +
                    "\t\tAND a.NewStatus = '02' \n" +
                    "\t\tAND c.eq_pm_id = e.eq_pm_id\n" +
                    "\t\tAND CONVERT ( VARCHAR ( 100 ), a.BeginTime, 23 ) &gt;= #{beginTime}\n" +
                    "\t\tAND CONVERT ( VARCHAR ( 100 ), a.EndTime, 23 ) &lt;= #{endTime}\n" +
                    "<if test='pym != null'>"," and e.pym = #{pym}","</if>",
            "<if test='bmId != null'>"," and d.bm_id = #{bmId}","</if>",
                    "\tGROUP BY\n" +
                    "\t\ta.MachineNumber,\n" +
                    "\t\td.bm_name,\n" +
                    "\t\tc.eq_sbbh,\n" +
                    "\t\tc.eq_name,\n" +
                    "\t\tc.eq_xh \n" +
                    "\t) AS standby\n" +
                    "FULL JOIN",
                    "\t(\n" +
                            "\tSELECT\n" +
                            "\t\ta.MachineNumber,\n" +
                            "\t\td.bm_name,\n" +
                            "\t\tc.eq_sbbh,\n" +
                            "\t\tc.eq_name,\n" +
                            "\t\tc.eq_xh,\n" +
                            "\t\tMAX(e.pym) as pym,\n" +
                            "\t\tMAX(d.bm_id) as bmId,\n" +
                            "\t\tSUM ( datediff( SECOND, a.BeginTime, a.EndTime ) ) AS 'a' \n" +
                            "\tFROM\n" +
                            "\t\thospital.dbo.InspectDetailback a,\n" +
                            "\t\thospital.dbo.eq_mac_tab b,\n" +
                            "\t\thospital.dbo.eq_info c,\n" +
                            "\t\thospital.dbo.s_bm d,\n" +
                            "\t\thospital.dbo.eq_pm e \n" +
                            "\tWHERE\n" +
                            "\t\ta.MachineNumber = b.PMacID \n" +
                            "\t\tAND b.EquID = c.eq_id \n" +
                            "\t\tAND c.eq_bmid = d.bm_id \n" +
                            "\t\tAND a.NewStatus = '01' \n" +
                            "\t\tAND c.eq_pm_id = e.eq_pm_id\n" +
                    "\t\tAND CONVERT ( VARCHAR ( 100 ), a.BeginTime, 23 ) &gt;= #{beginTime}\n" +
                    "\t\tAND CONVERT ( VARCHAR ( 100 ), a.EndTime, 23 ) &lt;= #{endTime}\n" +
                            "<if test='pym != null'>"," and e.pym = #{pym}","</if>",
            "<if test='bmId != null'>"," and d.bm_id = #{bmId}","</if>",
                    "\tGROUP BY\n" +
                    "\t\ta.MachineNumber,\n" +
                    "\t\td.bm_name,\n" +
                    "\t\tc.eq_sbbh,\n" +
                    "\t\tc.eq_name,\n" +
                    "\t\tc.eq_xh \n" +
                    "\t) AS works \n" +
                            "ON standby.MachineNumber = works.MachineNumber",
            "</script>"})
    List<OperationRecord> select3(SearchVO searchVO);
    @Select({"<script>",
            "SELECT\n" +
                    "\tstandby.bm_name,\n" +
                    "\tstandby.eq_sbbh,\n" +
                    "\tstandby.eq_name,\n" +
                    "\tstandby.eq_xh,\n" +
                    "\tstandby.a AS standbyTime,\n" +
                    "\tworks.a AS workHours\n" +
                    "FROM\n" +
                    "\t(\n" +
                    "\tSELECT\n" +
                    "\t\ta.MachineNumber,\n" +
                    "\t\td.bm_name,\n" +
                    "\t\tc.eq_sbbh,\n" +
                    "\t\tc.eq_name,\n" +
                    "\t\tc.eq_xh,\n" +
                    "\t\tMAX(e.pym) as pym,\n" +
                    "\t\tMAX(d.bm_id) as bmId,\n" +
                    "\t\tSUM ( datediff( SECOND, a.BeginTime, a.EndTime ) ) AS 'a' \n" +
                    "\tFROM\n" +
                    "\t\thospital.dbo.InspectDetailback a,\n" +
                    "\t\thospital.dbo.eq_mac_tab b,\n" +
                    "\t\thospital.dbo.eq_info c,\n" +
                    "\t\thospital.dbo.s_bm d,\n" +
                    "\t\thospital.dbo.eq_pm e \n" +
                    "\tWHERE\n" +
                    "\t\ta.MachineNumber = b.PMacID \n" +
                    "\t\tAND b.EquID = c.eq_id \n" +
                    "\t\tAND c.eq_bmid = d.bm_id \n" +
                    "\t\tAND a.NewStatus = '02' \n" +
                    "\t\tAND c.eq_pm_id = e.eq_pm_id\n" +
                    "\t\tAND SUBSTRING(CONVERT ( VARCHAR ( 100 ), a.BeginTime, 23 ),1,7) &gt;= #{beginTime}\n" +
                    "\t\tAND SUBSTRING(CONVERT ( VARCHAR ( 100 ), a.EndTime, 23 ),1,7) &lt;= #{endTime}\n" +
                    "<if test='pym != null'>"," and e.pym = #{pym}","</if>",
            "<if test='bmId != null'>"," and d.bm_id = #{bmId}","</if>",
            "\tGROUP BY\n" +
                    "\t\ta.MachineNumber,\n" +
                    "\t\td.bm_name,\n" +
                    "\t\tc.eq_sbbh,\n" +
                    "\t\tc.eq_name,\n" +
                    "\t\tc.eq_xh \n" +
                    "\t) AS standby\n" +
                    "FULL JOIN",
            "\t(\n" +
                    "\tSELECT\n" +
                    "\t\ta.MachineNumber,\n" +
                    "\t\td.bm_name,\n" +
                    "\t\tc.eq_sbbh,\n" +
                    "\t\tc.eq_name,\n" +
                    "\t\tc.eq_xh,\n" +
                    "\t\tMAX(e.pym) as pym,\n" +
                    "\t\tMAX(d.bm_id) as bmId,\n" +
                    "\t\tSUM ( datediff( SECOND, a.BeginTime, a.EndTime ) ) AS 'a' \n" +
                    "\tFROM\n" +
                    "\t\thospital.dbo.InspectDetailback a,\n" +
                    "\t\thospital.dbo.eq_mac_tab b,\n" +
                    "\t\thospital.dbo.eq_info c,\n" +
                    "\t\thospital.dbo.s_bm d,\n" +
                    "\t\thospital.dbo.eq_pm e \n" +
                    "\tWHERE\n" +
                    "\t\ta.MachineNumber = b.PMacID \n" +
                    "\t\tAND b.EquID = c.eq_id \n" +
                    "\t\tAND c.eq_bmid = d.bm_id \n" +
                    "\t\tAND a.NewStatus = '01' \n" +
                    "\t\tAND c.eq_pm_id = e.eq_pm_id\n" +
                    "\t\tAND SUBSTRING(CONVERT ( VARCHAR ( 100 ), a.BeginTime, 23 ),1,7) &gt;= #{beginTime}\n" +
                    "\t\tAND SUBSTRING(CONVERT ( VARCHAR ( 100 ), a.EndTime, 23 ),1,7) &lt;= #{endTime}\n" +
                    "<if test='pym != null'>"," and e.pym = #{pym}","</if>",
            "<if test='bmId != null'>"," and d.bm_id = #{bmId}","</if>",
            "\tGROUP BY\n" +
                    "\t\ta.MachineNumber,\n" +
                    "\t\td.bm_name,\n" +
                    "\t\tc.eq_sbbh,\n" +
                    "\t\tc.eq_name,\n" +
                    "\t\tc.eq_xh \n" +
                    "\t) AS works \n" +
                    "ON standby.MachineNumber = works.MachineNumber",
            "</script>"})
    List<OperationRecord> select31(SearchVO searchVO);
    @Select({"<script>",
            "SELECT\n" +
                    "\tstandby.bm_name,\n" +
                    "\tstandby.eq_sbbh,\n" +
                    "\tstandby.eq_name,\n" +
                    "\tstandby.eq_xh,\n" +
                    "\tstandby.a AS standbyTime,\n" +
                    "\tworks.a AS workHours\n" +
                    "FROM\n" +
                    "\t(\n" +
                    "\tSELECT\n" +
                    "\t\ta.MachineNumber,\n" +
                    "\t\td.bm_name,\n" +
                    "\t\tc.eq_sbbh,\n" +
                    "\t\tc.eq_name,\n" +
                    "\t\tc.eq_xh,\n" +
                    "\t\tMAX(e.pym) as pym,\n" +
                    "\t\tMAX(d.bm_id) as bmId,\n" +
                    "\t\tSUM ( datediff( SECOND, a.BeginTime, a.EndTime ) ) AS 'a' \n" +
                    "\tFROM\n" +
                    "\t\thospital.dbo.InspectDetail a,\n" +
                    "\t\thospital.dbo.eq_mac_tab b,\n" +
                    "\t\thospital.dbo.eq_info c,\n" +
                    "\t\thospital.dbo.s_bm d,\n" +
                    "\t\thospital.dbo.eq_pm e \n" +
                    "\tWHERE\n" +
                    "\t\ta.MachineNumber = b.PMacID \n" +
                    "\t\tAND b.EquID = c.eq_id \n" +
                    "\t\tAND c.eq_bmid = d.bm_id \n" +
                    "\t\tAND a.NewStatus = '02' \n" +
                    "\t\tAND c.eq_pm_id = e.eq_pm_id\n" +
                    "\t\tAND SUBSTRING(CONVERT ( VARCHAR ( 100 ), a.BeginTime, 23 ),1,4) &gt;= #{beginTime}\n" +
                    "\t\tAND SUBSTRING(CONVERT ( VARCHAR ( 100 ), a.EndTime, 23 ),1,4) &lt;= #{endTime}\n" +
                    "<if test='pym != null'>"," and e.pym = #{pym}","</if>",
            "<if test='bmId != null'>"," and d.bm_id = #{bmId}","</if>",
            "\tGROUP BY\n" +
                    "\t\ta.MachineNumber,\n" +
                    "\t\td.bm_name,\n" +
                    "\t\tc.eq_sbbh,\n" +
                    "\t\tc.eq_name,\n" +
                    "\t\tc.eq_xh \n" +
                    "\t) AS standby\n" +
                    "FULL JOIN",
            "\t(\n" +
                    "\tSELECT\n" +
                    "\t\ta.MachineNumber,\n" +
                    "\t\td.bm_name,\n" +
                    "\t\tc.eq_sbbh,\n" +
                    "\t\tc.eq_name,\n" +
                    "\t\tc.eq_xh,\n" +
                    "\t\tMAX(e.pym) as pym,\n" +
                    "\t\tMAX(d.bm_id) as bmId,\n" +
                    "\t\tSUM ( datediff( SECOND, a.BeginTime, a.EndTime ) ) AS 'a' \n" +
                    "\tFROM\n" +
                    "\t\thospital.dbo.InspectDetail a,\n" +
                    "\t\thospital.dbo.eq_mac_tab b,\n" +
                    "\t\thospital.dbo.eq_info c,\n" +
                    "\t\thospital.dbo.s_bm d,\n" +
                    "\t\thospital.dbo.eq_pm e \n" +
                    "\tWHERE\n" +
                    "\t\ta.MachineNumber = b.PMacID \n" +
                    "\t\tAND b.EquID = c.eq_id \n" +
                    "\t\tAND c.eq_bmid = d.bm_id \n" +
                    "\t\tAND a.NewStatus = '01' \n" +
                    "\t\tAND c.eq_pm_id = e.eq_pm_id\n" +
                    "\t\tAND SUBSTRING(CONVERT ( VARCHAR ( 100 ), a.BeginTime, 23 ),1,4) &gt;= #{beginTime}\n" +
                    "\t\tAND SUBSTRING(CONVERT ( VARCHAR ( 100 ), a.EndTime, 23 ),1,4) &lt;= #{endTime}\n" +
                    "<if test='pym != null'>"," and e.pym = #{pym}","</if>",
            "<if test='bmId != null'>"," and d.bm_id = #{bmId}","</if>",
            "\tGROUP BY\n" +
                    "\t\ta.MachineNumber,\n" +
                    "\t\td.bm_name,\n" +
                    "\t\tc.eq_sbbh,\n" +
                    "\t\tc.eq_name,\n" +
                    "\t\tc.eq_xh \n" +
                    "\t) AS works \n" +
                    "ON standby.MachineNumber = works.MachineNumber",
            "</script>"})
    List<OperationRecord> select32(SearchVO searchVO);

    @Select({"<script>",
            "SELECT\n" +
                    "standby.bm_name as bmName,\n" +
                    "SUM ( standby.a ) AS standbyTime,\n" +
                    "SUM ( works.a ) AS workHours,\n" +
                    "COUNT ( * ) AS eqNumber \n" +
                    "FROM\n" +
                    "(\n" +
                    "SELECT\n" +
                    "a.MachineNumber,\n" +
                    "d.bm_name,\n" +
                    "c.eq_sbbh,\n" +
                    "c.eq_name,\n" +
                    "c.eq_xh,\n" +
                    "MAX(e.pym) as pym,\n" +
                    "MAX(d.bm_id) as bmId,\n" +
                    "SUM ( datediff( SECOND, a.BeginTime, a.EndTime ) ) AS 'a' \n" +
                    "FROM\n" +
                    "hospital.dbo.InspectDetail a,\n" +
                    "hospital.dbo.eq_mac_tab b,\n" +
                    "hospital.dbo.eq_info c,\n" +
                    "hospital.dbo.s_bm d, \n" +
                    "hospital.dbo.eq_pm e \n" +
                    "WHERE\n" +
                    "a.MachineNumber = b.PMacID \n" +
                    "AND b.EquID = c.eq_id \n" +
                    "AND c.eq_bmid = d.bm_id \n" +
                    "AND a.NewStatus = '02' \n" +
                    "AND c.eq_pm_id = e.eq_pm_id\n" +
                    "\t\tAND CONVERT ( VARCHAR ( 100 ), a.BeginTime, 23 ) &gt;= #{beginTime}\n" +
                    "\t\tAND CONVERT ( VARCHAR ( 100 ), a.EndTime, 23 ) &lt;= #{endTime}\n" +
                    "<if test='pym != null'>"," and e.pym = #{pym}","</if>",
            "<if test='bmId != null'>"," and d.bm_id = #{bmId}","</if>",
            "GROUP BY\n" +
                    "a.MachineNumber,\n" +
                    "d.bm_name,\n" +
                    "c.eq_sbbh,\n" +
                    "c.eq_name,\n" +
                    "c.eq_xh \n" +
                    ") AS standby" +
                    "\tFULL JOIN\n" +
                    "(\n" +
                    "SELECT\n" +
                    "a.MachineNumber,\n" +
                    "d.bm_name,\n" +
                    "c.eq_sbbh,\n" +
                    "c.eq_name,\n" +
                    "c.eq_xh,\n" +
                    "MAX(e.pym) as pym,\n" +
                    "MAX(d.bm_id) as bmId,\n" +
                    "SUM ( datediff( SECOND, a.BeginTime, a.EndTime ) ) AS 'a' \n" +
                    "FROM\n" +
                    "hospital.dbo.InspectDetail a,\n" +
                    "hospital.dbo.eq_mac_tab b,\n" +
                    "hospital.dbo.eq_info c,\n" +
                    "hospital.dbo.s_bm d ,\n" +
                    "hospital.dbo.eq_pm e \n" +
                    "WHERE\n" +
                    "a.MachineNumber = b.PMacID \n" +
                    "AND b.EquID = c.eq_id \n" +
                    "AND c.eq_bmid = d.bm_id \n" +
                    "AND a.NewStatus = '01' \n" +
                    "AND c.eq_pm_id = e.eq_pm_id\n" +
                    "\t\tAND CONVERT ( VARCHAR ( 100 ), a.BeginTime, 23 ) &gt;= #{beginTime}\n" +
                    "\t\tAND CONVERT ( VARCHAR ( 100 ), a.EndTime, 23 ) &lt;= #{endTime}\n" +
                    "<if test='pym != null'>"," and e.pym = #{pym}","</if>",
            "<if test='bmId != null'>"," and d.bm_id = #{bmId}","</if>",
            "GROUP BY\n" +
                    "a.MachineNumber,\n" +
                    "d.bm_name,\n" +
                    "c.eq_sbbh,\n" +
                    "c.eq_name,\n" +
                    "c.eq_xh \n" +
                    ") AS works \n" +
                    "on\n" +
                    "standby.MachineNumber = works.MachineNumber\n" +
                    "GROUP BY\n" +
                    "standby.bm_name",
            "</script>"})
    List<OperationRecord> select4(SearchVO searchVO);
    @Select({"<script>",
            "SELECT\n" +
                    "standby.bm_name as bmName,\n" +
                    "SUM ( standby.a ) AS standbyTime,\n" +
                    "SUM ( works.a ) AS workHours,\n" +
                    "COUNT ( * ) AS eqNumber \n" +
                    "FROM\n" +
                    "(\n" +
                    "SELECT\n" +
                    "a.MachineNumber,\n" +
                    "d.bm_name,\n" +
                    "c.eq_sbbh,\n" +
                    "c.eq_name,\n" +
                    "c.eq_xh,\n" +
                    "MAX(e.pym) as pym,\n" +
                    "MAX(d.bm_id) as bmId,\n" +
                    "SUM ( datediff( SECOND, a.BeginTime, a.EndTime ) ) AS 'a' \n" +
                    "FROM\n" +
                    "hospital.dbo.InspectDetail a,\n" +
                    "hospital.dbo.eq_mac_tab b,\n" +
                    "hospital.dbo.eq_info c,\n" +
                    "hospital.dbo.s_bm d, \n" +
                    "hospital.dbo.eq_pm e \n" +
                    "WHERE\n" +
                    "a.MachineNumber = b.PMacID \n" +
                    "AND b.EquID = c.eq_id \n" +
                    "AND c.eq_bmid = d.bm_id \n" +
                    "AND a.NewStatus = '02' \n" +
                    "AND c.eq_pm_id = e.eq_pm_id\n" +
                    "\t\tAND SUBSTRING(CONVERT ( VARCHAR ( 100 ), a.BeginTime, 23 ),1,7) &gt;= #{beginTime}\n" +
                    "\t\tAND SUBSTRING(CONVERT ( VARCHAR ( 100 ), a.EndTime, 23 ),1,7) &lt;= #{endTime}\n" +
                    "<if test='pym != null'>"," and e.pym = #{pym}","</if>",
            "<if test='bmId != null'>"," and d.bm_id = #{bmId}","</if>",
            "GROUP BY\n" +
                    "a.MachineNumber,\n" +
                    "d.bm_name,\n" +
                    "c.eq_sbbh,\n" +
                    "c.eq_name,\n" +
                    "c.eq_xh \n" +
                    ") AS standby" +
                    "\tFULL JOIN\n" +
                    "(\n" +
                    "SELECT\n" +
                    "a.MachineNumber,\n" +
                    "d.bm_name,\n" +
                    "c.eq_sbbh,\n" +
                    "c.eq_name,\n" +
                    "c.eq_xh,\n" +
                    "MAX(e.pym) as pym,\n" +
                    "MAX(d.bm_id) as bmId,\n" +
                    "SUM ( datediff( SECOND, a.BeginTime, a.EndTime ) ) AS 'a' \n" +
                    "FROM\n" +
                    "hospital.dbo.InspectDetail a,\n" +
                    "hospital.dbo.eq_mac_tab b,\n" +
                    "hospital.dbo.eq_info c,\n" +
                    "hospital.dbo.s_bm d ,\n" +
                    "hospital.dbo.eq_pm e \n" +
                    "WHERE\n" +
                    "a.MachineNumber = b.PMacID \n" +
                    "AND b.EquID = c.eq_id \n" +
                    "AND c.eq_bmid = d.bm_id \n" +
                    "AND a.NewStatus = '01' \n" +
                    "AND c.eq_pm_id = e.eq_pm_id\n" +
                    "\t\tAND SUBSTRING(CONVERT ( VARCHAR ( 100 ), a.BeginTime, 23 ),1,7) &gt;= #{beginTime}\n" +
                    "\t\tAND SUBSTRING(CONVERT ( VARCHAR ( 100 ), a.EndTime, 23 ),1,7) &lt;= #{endTime}\n" +
                    "<if test='pym != null'>"," and e.pym = #{pym}","</if>",
            "<if test='bmId != null'>"," and d.bm_id = #{bmId}","</if>",
            "GROUP BY\n" +
                    "a.MachineNumber,\n" +
                    "d.bm_name,\n" +
                    "c.eq_sbbh,\n" +
                    "c.eq_name,\n" +
                    "c.eq_xh \n" +
                    ") AS works \n" +
                    "on\n" +
                    "standby.MachineNumber = works.MachineNumber\n" +
                    "GROUP BY\n" +
                    "standby.bm_name",
            "</script>"})
    List<OperationRecord> select41(SearchVO searchVO);
    @Select({"<script>",
            "SELECT\n" +
                    "standby.bm_name as bmName,\n" +
                    "SUM ( standby.a ) AS standbyTime,\n" +
                    "SUM ( works.a ) AS workHours,\n" +
                    "COUNT ( * ) AS eqNumber \n" +
                    "FROM\n" +
                    "(\n" +
                    "SELECT\n" +
                    "a.MachineNumber,\n" +
                    "d.bm_name,\n" +
                    "c.eq_sbbh,\n" +
                    "c.eq_name,\n" +
                    "c.eq_xh,\n" +
                    "MAX(e.pym) as pym,\n" +
                    "MAX(d.bm_id) as bmId,\n" +
                    "SUM ( datediff( SECOND, a.BeginTime, a.EndTime ) ) AS 'a' \n" +
                    "FROM\n" +
                    "hospital.dbo.InspectDetail a,\n" +
                    "hospital.dbo.eq_mac_tab b,\n" +
                    "hospital.dbo.eq_info c,\n" +
                    "hospital.dbo.s_bm d, \n" +
                    "hospital.dbo.eq_pm e \n" +
                    "WHERE\n" +
                    "a.MachineNumber = b.PMacID \n" +
                    "AND b.EquID = c.eq_id \n" +
                    "AND c.eq_bmid = d.bm_id \n" +
                    "AND a.NewStatus = '02' \n" +
                    "AND c.eq_pm_id = e.eq_pm_id\n" +
                    "\t\tAND SUBSTRING(CONVERT ( VARCHAR ( 100 ), a.BeginTime, 23 ),1,4) &gt;= #{beginTime}\n" +
                    "\t\tAND SUBSTRING(CONVERT ( VARCHAR ( 100 ), a.EndTime, 23 ),1,4) &lt;= #{endTime}\n" +
                    "<if test='pym != null'>"," and e.pym = #{pym}","</if>",
            "<if test='bmId != null'>"," and d.bm_id = #{bmId}","</if>",
            "GROUP BY\n" +
                    "a.MachineNumber,\n" +
                    "d.bm_name,\n" +
                    "c.eq_sbbh,\n" +
                    "c.eq_name,\n" +
                    "c.eq_xh \n" +
                    ") AS standby" +
                    "\tFULL JOIN\n" +
                    "(\n" +
                    "SELECT\n" +
                    "a.MachineNumber,\n" +
                    "d.bm_name,\n" +
                    "c.eq_sbbh,\n" +
                    "c.eq_name,\n" +
                    "c.eq_xh,\n" +
                    "MAX(e.pym) as pym,\n" +
                    "MAX(d.bm_id) as bmId,\n" +
                    "SUM ( datediff( SECOND, a.BeginTime, a.EndTime ) ) AS 'a' \n" +
                    "FROM\n" +
                    "hospital.dbo.InspectDetail a,\n" +
                    "hospital.dbo.eq_mac_tab b,\n" +
                    "hospital.dbo.eq_info c,\n" +
                    "hospital.dbo.s_bm d ,\n" +
                    "hospital.dbo.eq_pm e \n" +
                    "WHERE\n" +
                    "a.MachineNumber = b.PMacID \n" +
                    "AND b.EquID = c.eq_id \n" +
                    "AND c.eq_bmid = d.bm_id \n" +
                    "AND a.NewStatus = '01' \n" +
                    "AND c.eq_pm_id = e.eq_pm_id\n" +
                    "\t\tAND SUBSTRING(CONVERT ( VARCHAR ( 100 ), a.BeginTime, 23 ),1,4) &gt;= #{beginTime}\n" +
                    "\t\tAND SUBSTRING(CONVERT ( VARCHAR ( 100 ), a.EndTime, 23 ),1,4) &lt;= #{endTime}\n" +
                    "<if test='pym != null'>"," and e.pym = #{pym}","</if>",
            "<if test='bmId != null'>"," and d.bm_id = #{bmId}","</if>",
            "GROUP BY\n" +
                    "a.MachineNumber,\n" +
                    "d.bm_name,\n" +
                    "c.eq_sbbh,\n" +
                    "c.eq_name,\n" +
                    "c.eq_xh \n" +
                    ") AS works \n" +
                    "on\n" +
                    "standby.MachineNumber = works.MachineNumber\n" +
                    "GROUP BY\n" +
                    "standby.bm_name",
            "</script>"})
    List<OperationRecord> select42(SearchVO searchVO);

}
