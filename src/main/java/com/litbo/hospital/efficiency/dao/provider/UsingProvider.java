package com.litbo.hospital.efficiency.dao.provider;

import com.litbo.hospital.common.utils.calculate.HandleData;
import com.litbo.hospital.efficiency.vo.SearchVO;
import com.litbo.hospital.efficiency.vo.UsingVO;
import org.apache.commons.lang3.StringUtils;

/**
 * description:机时利用率的DAO层
 * @Author: jz
 * @Date: 2019/8/1 17:05
 */
public class UsingProvider {

    public String selectUsing(){
        String sql = "INSERT INTO kpi_using(eqCode,eqJc,workTimes,realTimes)\n" +
                "SELECT MAX\n" +
                "( dbo.eq_info.eq_sbbh ) AS eqCode,\n" +
                "MAX ( eq_jiancheng.c_AName ) AS eqJc,\n" +
                "MAX ( dbo.approved_working_hours.full_load_time ) AS workTimes,\n" +
                "SUM (\n" +
                "DATEDIFF( SECOND, Dbo.InspectDetail.BeginTime, dbo.InspectDetail.EndTime )) AS realTimes \n" +
                "FROM\n" +
                "dbo.approved_working_hours,\n" +
                "dbo.InspectDetail,\n" +
                "dbo.eq_mac_tab,\n" +
                "dbo.eq_info ,\n" +
                "dbo.eq_name ,\n" +
                "dbo.eq_sbjcfl ,\n" +
                "dbo.eq_jiancheng \n" +
                "WHERE\n" +
                "dbo.eq_info.eq_nid = dbo.eq_name.id \n" +
                "AND dbo.eq_name.c_BID = dbo.eq_sbjcfl.id \n" +
                "AND dbo.eq_sbjcfl.c_EquSimpleId = dbo.eq_jiancheng.id \n" +
                "AND dbo.InspectDetail.MachineNumber = dbo.eq_mac_tab.PMacID \n" +
                "AND dbo.eq_mac_tab.EquID = dbo.eq_info.eq_id \n" +
                "AND dbo.approved_working_hours.eq_mac_id = dbo.eq_mac_tab.MacID \n" +
                "AND dbo.InspectDetail.InspectDate = (\n" +
                "SELECT CONVERT\n" +
                "( VARCHAR ( 10 ), '2018-11-02', 120 )) \n" +
                "AND dbo.InspectDetail.NewStatus = '02' \n" +
                "GROUP BY\n" +
                "dbo.eq_info.eq_sbbh";

        return sql;
    }

    public String selectUsingByCon(SearchVO searchVO){

        StringBuilder sql = new StringBuilder("INSERT kpi_using(eqCode,eqJc,workTimes,realTimes)\n" +
                "SELECT MAX\n" +
                "( dbo.eq_info.eq_sbbh ) AS eqCode,\n" +
                "MAX ( eq_jiancheng.c_AName ) AS eqJc,\n" +
                "MAX ( dbo.approved_working_hours.full_load_time ) AS workTimes,\n" +
                "SUM (\n" +
                "DATEDIFF( SECOND, Dbo.InspectDetail.BeginTime, dbo.InspectDetail.EndTime )) AS realTimes \n" +
                "FROM\n" +
                "dbo.approved_working_hours,\n" +
                "dbo.InspectDetail,\n" +
                "dbo.eq_mac_tab,\n" +
                "dbo.eq_info ,\n" +
                "dbo.eq_name ,\n" +
                "dbo.eq_sbjcfl ,\n" +
                "dbo.eq_jiancheng ,\n" +
                "dbo.s_bm\n" +
                "WHERE\n" +
                "dbo.eq_info.eq_nid = dbo.eq_name.id \n" +
                "AND dbo.eq_name.c_BID = dbo.eq_sbjcfl.id \n" +
                "AND dbo.eq_sbjcfl.c_EquSimpleId = dbo.eq_jiancheng.id \n" +
                "AND dbo.InspectDetail.MachineNumber = dbo.eq_mac_tab.PMacID \n" +
                "AND dbo.eq_mac_tab.EquID = dbo.eq_info.eq_id \n" +
                "AND dbo.approved_working_hours.eq_mac_id = dbo.eq_mac_tab.MacID \n" +
                "AND dbo.eq_info.eq_bmid = dbo.s_bm.bm_id\n" +
                "AND dbo.InspectDetail.NewStatus = '02' ");

        if (StringUtils.isNotBlank(searchVO.getEqSName())){
            sql.append("AND dbo.eq_jiancheng.c_AName LIKE '%"+searchVO.getEqSName()+"%' ");
        }

        if (StringUtils.isNotBlank(searchVO.getBmSName())){
            sql.append("AND dbo.s_bm.bm_name LIKE '%"+searchVO.getBmSName()+"%' ");
        }

        if (searchVO.getStartSTime()!=null&&searchVO.getEndSTime()!=null){
            sql.append("AND dbo.eq_info.eq_qysj BETWEEN '"+ searchVO.getStartSTime() +"' AND '"+ searchVO.getEndSTime()+"' ");
        }

        if (searchVO.getStartSTime()==null||searchVO.getEndSTime()==null){
            sql.append("AND dbo.InspectDetail.InspectDate = (\n" +
                    "SELECT CONVERT\n" +
                    "( VARCHAR ( 10 ), '2018-11-02', 120 )) ");
        }

        sql.append(" GROUP BY dbo.eq_info.eq_sbbh");

        return sql.toString();
    }

}
