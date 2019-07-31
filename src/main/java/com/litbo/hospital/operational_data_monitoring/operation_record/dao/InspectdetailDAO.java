package com.litbo.hospital.operational_data_monitoring.operation_record.dao;

import com.litbo.hospital.operational_data_monitoring.operation_record.vo.OperationRecord;
import com.litbo.hospital.operational_data_monitoring.operation_record.vo.SearchVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.operation_record.orcl
 * @Author: looli
 * @CreateTime: 2019-07-22 16:52
 * @Description: 设备运行情况操作
 */
@Mapper
public interface InspectdetailDAO {
    /**运行记录*/
    @Select("SELECT d.bm_name,c.eq_sbbh,c.eq_zcbh,c.eq_name,b.MacID,a.NewStatus,a.BeginTime,a.EndTime " +
            "FROM hospital.dbo.InspectDetail a,hospital.dbo.eq_mac_tab b,hospital.dbo.eq_info c,hospital.dbo.s_bm d " +
            "WHERE a.MachineNumber = b.MacID AND b.EquID = c.eq_id AND b.DeptID = d.bm_id")
    List<OperationRecord> selectAll1();
    /**原始记录*/
    @Select("SELECT d.bm_name,c.eq_sbbh,c.eq_zcbh,c.eq_name,b.MacID,a.NewStatus,a.BeginTime,a.WorkNums " +
            "FROM hospital.dbo.InspectDetail a,hospital.dbo.eq_mac_tab b,hospital.dbo.eq_info c,hospital.dbo.s_bm d " +
            "WHERE a.MachineNumber = b.MacID AND b.EquID = c.eq_id AND b.DeptID = d.bm_id ")
    List<OperationRecord> selectAll2();
    /**单机设备运行记录*/
    @Select("SELECT\n" +
            "standby.bm_name,\n" +
            "standby.eq_sbbh,\n" +
            "standby.eq_name,\n" +
            "standby.eq_xh,\n" +
            "standby.a AS standbyTime,\n" +
            "works.a AS workHours \n" +
            "FROM\n" +
            "(\n" +
            "SELECT\n" +
            "a.MachineNumber,\n" +
            "d.bm_name,\n" +
            "c.eq_sbbh,\n" +
            "c.eq_name,\n" +
            "c.eq_xh,\n" +
            "SUM ( datediff( SECOND, a.BeginTime, a.EndTime ) ) AS 'a' \n" +
            "FROM\n" +
            "hospital.dbo.InspectDetail a,\n" +
            "hospital.dbo.eq_mac_tab b,\n" +
            "hospital.dbo.eq_info c,\n" +
            "hospital.dbo.s_bm d \n" +
            "WHERE\n" +
            "a.MachineNumber = b.MacID \n" +
            "AND b.EquID = c.eq_id \n" +
            "AND b.DeptID = d.bm_id \n" +
            "AND a.NewStatus = '02' \n" +
            "GROUP BY\n" +
            "a.MachineNumber,\n" +
            "d.bm_name,\n" +
            "c.eq_sbbh,\n" +
            "c.eq_name,\n" +
            "c.eq_xh \n" +
            ") AS standby,\n" +
            "(\n" +
            "SELECT\n" +
            "a.MachineNumber,\n" +
            "d.bm_name,\n" +
            "c.eq_sbbh,\n" +
            "c.eq_name,\n" +
            "c.eq_xh,\n" +
            "SUM ( datediff( SECOND, a.BeginTime, a.EndTime ) ) AS 'a' \n" +
            "FROM\n" +
            "hospital.dbo.InspectDetail a,\n" +
            "hospital.dbo.eq_mac_tab b,\n" +
            "hospital.dbo.eq_info c,\n" +
            "hospital.dbo.s_bm d \n" +
            "WHERE\n" +
            "a.MachineNumber = b.MacID \n" +
            "AND b.EquID = c.eq_id \n" +
            "AND b.DeptID = d.bm_id \n" +
            "AND a.NewStatus = '01' \n" +
            "GROUP BY\n" +
            "a.MachineNumber,\n" +
            "d.bm_name,\n" +
            "c.eq_sbbh,\n" +
            "c.eq_name,\n" +
            "c.eq_xh \n" +
            ") AS works \n" +
            "WHERE\n" +
            "standby.MachineNumber = works.MachineNumber")
    List<OperationRecord> selectAll3();

    /**使用科室设备运行记录*/
    @Select("SELECT\n" +
            "standby.bm_name,\n" +
            "sum(standby.a) as standbyTime,\n" +
            "sum(works.a)  as workHours,\n" +
            "COUNT(*) AS eqNumber\n" +
            "FROM\n" +
            "(\n" +
            "SELECT\n" +
            "a.MachineNumber,\n" +
            "d.bm_name,\n" +
            "c.eq_sbbh,\n" +
            "c.eq_name,\n" +
            "c.eq_xh,\n" +
            "SUM ( datediff( SECOND, a.BeginTime, a.EndTime ) ) AS 'a' \n" +
            "FROM\n" +
            "hospital.dbo.InspectDetail a,\n" +
            "hospital.dbo.eq_mac_tab b,\n" +
            "hospital.dbo.eq_info c,\n" +
            "hospital.dbo.s_bm d \n" +
            "WHERE\n" +
            "a.MachineNumber = b.MacID \n" +
            "AND b.EquID = c.eq_id \n" +
            "AND b.DeptID = d.bm_id \n" +
            "AND a.NewStatus = '02' \n" +
            "GROUP BY\n" +
            "a.MachineNumber,\n" +
            "d.bm_name,\n" +
            "c.eq_sbbh,\n" +
            "c.eq_name,\n" +
            "c.eq_xh \n" +
            ") AS standby,\n" +
            "(\n" +
            "SELECT\n" +
            "a.MachineNumber,\n" +
            "d.bm_name,\n" +
            "c.eq_sbbh,\n" +
            "c.eq_name,\n" +
            "c.eq_xh,\n" +
            "SUM ( datediff( SECOND, a.BeginTime, a.EndTime ) ) AS 'a' \n" +
            "FROM\n" +
            "hospital.dbo.InspectDetail a,\n" +
            "hospital.dbo.eq_mac_tab b,\n" +
            "hospital.dbo.eq_info c,\n" +
            "hospital.dbo.s_bm d \n" +
            "WHERE\n" +
            "a.MachineNumber = b.MacID \n" +
            "AND b.EquID = c.eq_id \n" +
            "AND b.DeptID = d.bm_id \n" +
            "AND a.NewStatus = '01' \n" +
            "GROUP BY\n" +
            "a.MachineNumber,\n" +
            "d.bm_name,\n" +
            "c.eq_sbbh,\n" +
            "c.eq_name,\n" +
            "c.eq_xh \n" +
            ") AS works \n" +
            "WHERE\n" +
            "standby.MachineNumber = works.MachineNumber\n" +
            "GROUP BY standby.bm_name")
    List<OperationRecord> selectAll4();

    /**按条件查询单机设备运行记录*/
    @Select({
            "<script>",
            "SELECT\n" +
                    "standby.bm_name,\n" +
                    "standby.eq_sbbh,\n" +
                    "standby.eq_name,\n" +
                    "standby.eq_xh,\n" +
                    "standby.a AS standbyTime,\n" +
                    "works.a AS workHours \n" +
                    "FROM\n" +
                    "(\n" +
                    "SELECT\n" +
                    "a.MachineNumber,\n" +
                    "d.bm_name,\n" +
                    "c.eq_sbbh,\n" +
                    "c.eq_name,\n" +
                    "c.eq_xh,\n" +
                    "SUM ( datediff( SECOND, a.BeginTime, a.EndTime ) ) AS 'a' \n" +
                    "FROM\n" +
                    "hospital.dbo.InspectDetail a,\n" +
                    "hospital.dbo.eq_mac_tab b,\n" +
                    "hospital.dbo.eq_info c,\n" +
                    "hospital.dbo.s_bm d \n" +
                    "WHERE\n" +
                    "a.MachineNumber = b.MacID \n" +
                    "AND b.EquID = c.eq_id \n" +
                    "AND b.DeptID = d.bm_id \n" +
                    "AND a.NewStatus = '02' \n" +
                    "GROUP BY\n" +
                    "a.MachineNumber,\n" +
                    "d.bm_name,\n" +
                    "c.eq_sbbh,\n" +
                    "c.eq_name,\n" +
                    "c.eq_xh \n" +
                    ") AS standby,\n" +
                    "(\n" +
                    "SELECT\n" +
                    "a.MachineNumber,\n" +
                    "d.bm_name,\n" +
                    "c.eq_sbbh,\n" +
                    "c.eq_name,\n" +
                    "c.eq_xh,\n" +
                    "SUM ( datediff( SECOND, a.BeginTime, a.EndTime ) ) AS 'a' \n" +
                    "FROM\n" +
                    "hospital.dbo.InspectDetail a,\n" +
                    "hospital.dbo.eq_mac_tab b,\n" +
                    "hospital.dbo.eq_info c,\n" +
                    "hospital.dbo.s_bm d ,\n" +
                    "hospital.dbo.eq_pm e \n" +
                    "WHERE\n" +
                    "a.MachineNumber = b.MacID \n" +
                    "AND b.EquID = c.eq_id \n" +
                    "AND b.DeptID = d.bm_id \n" +
                    "AND a.NewStatus = '01' \n" +
                    "AND c.eq_pm_id = e.eq_pm_id \n" +
                    "<if test='Nowadays != null'> AND a.InspectDate = #{Nowadays} </if>\n" +
                    "<if test='bmId != null'> AND d.bm_id = #{bmId} </if>\n" +
                    "<if test='pmpym != null'> AND e.bm_id = #{pmpym} </if>\n" +
                    "GROUP BY\n" +
                    "a.MachineNumber,\n" +
                    "d.bm_name,\n" +
                    "c.eq_sbbh,\n" +
                    "c.eq_name,\n" +
                    "c.eq_xh \n" +
                    ") AS works \n" +
                    "WHERE\n" +
                    "standby.MachineNumber = works.MachineNumber",
            "</script>"
    })
    List<OperationRecord> selectAll3By(SearchVO searchVO);

    /**使用科室设备运行记录*/
    @Select({
            "<script>",
            "SELECT\n" +
                    "standby.bm_name,\n" +
                    "sum(standby.a) as standbyTime,\n" +
                    "sum(works.a)  as workHours,\n" +
                    "COUNT(*) AS eqNumber\n" +
                    "FROM\n" +
                    "(\n" +
                    "SELECT\n" +
                    "a.MachineNumber,\n" +
                    "d.bm_name,\n" +
                    "c.eq_sbbh,\n" +
                    "c.eq_name,\n" +
                    "c.eq_xh,\n" +
                    "SUM ( datediff( SECOND, a.BeginTime, a.EndTime ) ) AS 'a' \n" +
                    "FROM\n" +
                    "hospital.dbo.InspectDetail a,\n" +
                    "hospital.dbo.eq_mac_tab b,\n" +
                    "hospital.dbo.eq_info c,\n" +
                    "hospital.dbo.s_bm d \n" +
                    "WHERE\n" +
                    "a.MachineNumber = b.MacID \n" +
                    "AND b.EquID = c.eq_id \n" +
                    "AND b.DeptID = d.bm_id \n" +
                    "AND a.NewStatus = '02' \n" +
                    "GROUP BY\n" +
                    "a.MachineNumber,\n" +
                    "d.bm_name,\n" +
                    "c.eq_sbbh,\n" +
                    "c.eq_name,\n" +
                    "c.eq_xh \n" +
                    ") AS standby,\n" +
                    "(\n" +
                    "SELECT\n" +
                    "a.MachineNumber,\n" +
                    "d.bm_name,\n" +
                    "c.eq_sbbh,\n" +
                    "c.eq_name,\n" +
                    "c.eq_xh,\n" +
                    "SUM ( datediff( SECOND, a.BeginTime, a.EndTime ) ) AS 'a' \n" +
                    "FROM\n" +
                    "hospital.dbo.InspectDetail a,\n" +
                    "hospital.dbo.eq_mac_tab b,\n" +
                    "hospital.dbo.eq_info c,\n" +
                    "hospital.dbo.s_bm d \n" +
                    "WHERE\n" +
                    "a.MachineNumber = b.MacID \n" +
                    "AND b.EquID = c.eq_id \n" +
                    "AND b.DeptID = d.bm_id \n" +
                    "AND a.NewStatus = '01' \n" +
                    "<if test='Nowadays != null'> AND a.InspectDate = #{Nowadays} </if>\n" +
                    "<if test='bmId != null'> AND d.bm_id = #{bmId} </if>\n" +
                    "GROUP BY\n" +
                    "a.MachineNumber,\n" +
                    "d.bm_name,\n" +
                    "c.eq_sbbh,\n" +
                    "c.eq_name,\n" +
                    "c.eq_xh \n" +
                    ") AS works \n" +
                    "WHERE\n" +
                    "standby.MachineNumber = works.MachineNumber\n" +
                    "GROUP BY standby.bm_name",
            "</script>"
    })
    List<OperationRecord> selectAll4By(SearchVO searchVO);

//    /**运行记录*/
//    @Select({"<script>",
//            "SELECT d.bm_name,c.eq_sbbh,c.eq_zcbh,c.eq_name,b.MacID,a.NewStatus,a.BeginTime,a.EndTime FROM " +
//                    "hospital.dbo.InspectDetail a," +
//                    "hospital.dbo.eq_mac_tab b," +
//                    "hospital.dbo.eq_info c," +
//                    "hospital.dbo.s_bm d " +
//                    "WHERE a.MachineNumber = b.MacID AND b.EquID = c.eq_id AND b.DeptID = d.bm_id ",
//            " " +
//                    " " +
//                    "" +
//                    "" ,
//            "</script>"})
//    List<OperationRecord> sle(SearchVO searchVO);

//    /**原始记录*/
//    @Select({"<script>",
//            "SELECT d.bm_name,c.eq_sbbh,c.eq_zcbh,c.eq_name,b.MacID,a.NewStatus,a.BeginTime,a.WorkNums FROM " +
//                    "hospital.dbo.InspectDetail a," +
//                    "hospital.dbo.eq_mac_tab b," +
//                    "hospital.dbo.eq_info c," +
//                    "hospital.dbo.s_bm d " +
//                    "WHERE a.MachineNumber = b.MacID AND b.EquID = c.eq_id AND b.DeptID = d.bm_id " +
//                    " " +
//                    "<if test='startTime != null'>AND a.BeginTime >= #{startTime}</if> " +
//                    "<if test='endTime != null'>AND a.EndTime <=  #{endTime}</if>",
//            "</script>"})
//    List<OperationRecord> sel(SearchVO searchVO);
    /**运行记录*/
    @Select({"<script>",
            "SELECT d.bm_name,c.eq_sbbh,c.eq_zcbh,c.eq_name,b.MacID,a.NewStatus,a.BeginTime,a.EndTime " +
                    "FROM " +
                    "hospital.dbo.InspectDetail a," +
                    "hospital.dbo.eq_mac_tab b," +
                    "hospital.dbo.eq_info c," +
                    "hospital.dbo.s_bm d ," +
                    "hospital.dbo.eq_pm e " +
                    "WHERE a.MachineNumber = b.MacID AND b.EquID = c.eq_id AND b.DeptID = d.bm_id AND e.eq_pm_id = c.eq_pm_id" +
                    "<if test='macid != null'> AND b.MacID = #{macid} </if> " +
                    "<if test='pmpym != null'> AND e.eq_pm_name = #{pmpym} </if> " +
                    "<if test='startTime != null'>AND a.BeginTime &gt;= #{startTime} </if> " +
                    "<if test='endTime != null'>AND a.EndTime &lt;=  #{endTime} </if>",
            "</script>"})
    List<OperationRecord> selectAll1By(SearchVO searchVO);
    /**原始记录*/
    @Select({"<script>",
            "SELECT d.bm_name,c.eq_sbbh,c.eq_zcbh,c.eq_name,b.MacID,a.NewStatus,a.BeginTime,a.WorkNums " +
            "FROM hospital.dbo.InspectDetail a,hospital.dbo.eq_mac_tab b,hospital.dbo.eq_info c,hospital.dbo.s_bm d " +
            "WHERE a.MachineNumber = b.MacID AND b.EquID = c.eq_id AND b.DeptID = d.bm_id " +
                    "<if test='macid != null'> AND b.MacID = #{macid} </if> " +
                    "<if test='startTime != null'>AND a.BeginTime &gt;= #{startTime} </if> " +
                    "<if test='endTime != null'>AND a.EndTime &lt;=  #{endTime} </if>",
            "</script>"})
    List<OperationRecord> selectAll2By(SearchVO searchVO);

    /**
     * 查看终端编号
     * @return
     */
    @Select("")
    List<String> selectAll();

}
