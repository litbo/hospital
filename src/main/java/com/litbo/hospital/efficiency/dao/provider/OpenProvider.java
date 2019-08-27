package com.litbo.hospital.efficiency.dao.provider;

import com.litbo.hospital.common.utils.calculate.HandleData;
import com.litbo.hospital.efficiency.vo.OpenVO;
import com.litbo.hospital.efficiency.vo.SearchVO;
import org.apache.commons.lang3.StringUtils;

/**
 * description:开机率的DAO层
 * @Author: jz
 * @Date: 2019/8/1 10:06
 */
public class OpenProvider {

    public String updateOpen(){

        StringBuilder sql = new StringBuilder("INSERT INTO kpi_open(eqCode,eqName,realDays,workDays)\n" +
                "SELECT\n" +
                "many.eqCode,\n" +
                "many.eqName,\n" +
                "less.realDays,\n" +
                "many.workDays \n" +
                "FROM\n" +
                "(\n" +
                "SELECT MAX\n" +
                "( dbo.eq_info.eq_sbbh ) AS eqCode,\n" +
                "MAX ( dbo.eq_info.eq_name ) AS eqName,\n" +
                "MAX ( dbo.approved_working_hours.work_days ) AS workDays \n" +
                "FROM\n" +
                "dbo.eq_info\n" +
                "INNER JOIN dbo.eq_mac_tab ON dbo.eq_info.eq_id = dbo.eq_mac_tab.EquID\n" +
                "INNER JOIN dbo.approved_working_hours ON dbo.approved_working_hours.eq_mac_id = dbo.eq_mac_tab.MacID\n" +
                "INNER JOIN dbo.InspectDetail ON dbo.InspectDetail.MachineNumber = dbo.eq_mac_tab.PMacID\n" +
                "INNER JOIN dbo.s_bm ON dbo.eq_info.eq_bmid = dbo.s_bm.bm_id \n" +
                "GROUP BY\n" +
                "dbo.eq_info.eq_sbbh \n" +
                ") AS many,\n" +
                "(\n" +
                "SELECT COUNT\n" +
                "( * ) AS realDays \n" +
                "FROM\n" +
                "(\n" +
                "SELECT\n" +
                "dbo.InspectDetail.InspectDate \n" +
                "FROM\n" +
                "dbo.InspectDetail \n" +
                "WHERE\n" +
                "DATEDIFF( MONTH, CerateTime, '2018-11-02' ) = 0 \n" +
                "GROUP BY\n" +
                "dbo.InspectDetail.InspectDate \n" +
                ") AS num \n" +
                ") AS less");

        return sql.toString();
    }

    public String updateOpenByCon(SearchVO searchVO){

        StringBuilder sql = new StringBuilder("INSERT INTO kpi_open(eqCode,eqName,realDays,workDays)\n" +
                "SELECT \n" +
                "many.eqCode,many.eqName,less.realDays,many.workDays\n" +
                "FROM\n" +
                "(\n" +
                "SELECT MAX\n" +
                "( dbo.eq_info.eq_sbbh ) AS eqCode,\n" +
                "MAX ( dbo.eq_info.eq_name ) AS eqName,\n" +
                "MAX ( dbo.approved_working_hours.work_days ) AS workDays \n" +
                "FROM\n" +
                "dbo.eq_info\n" +
                "INNER JOIN dbo.eq_mac_tab ON dbo.eq_info.eq_id = dbo.eq_mac_tab.EquID\n" +
                "INNER JOIN dbo.approved_working_hours ON dbo.approved_working_hours.eq_mac_id = dbo.eq_mac_tab.MacID\n" +
                "INNER JOIN dbo.InspectDetail ON dbo.InspectDetail.MachineNumber = dbo.eq_mac_tab.PMacID \n" +
                "INNER JOIN dbo.s_bm ON dbo.eq_info.eq_bmid = dbo.s_bm.bm_id\n" +
                "WHERE\n" +
                "dbo.approved_working_hours.rating_type = '1'");

        if (StringUtils.isNotBlank(searchVO.getEqSName())){
            sql.append(" AND dbo.eq_info.eq_name LIKE '%");
            sql.append(searchVO.getEqSName()+"%'");
        }

        if (StringUtils.isNotBlank(searchVO.getBmSName())){
            sql.append(" AND dbo.eq_info.eq_name LIKE '%");
            sql.append(searchVO.getBmSName()+"%'");
        }

        sql.append("GROUP BY\n" +
                "dbo.eq_info.eq_sbbh \n" +
                ") AS many,\n" +
                "(\n" +
                "SELECT COUNT\n" +
                "( * ) AS realDays \n" +
                "FROM\n" +
                "(\n" +
                "SELECT\n" +
                "dbo.InspectDetail.InspectDate \n" +
                "FROM\n" +
                "dbo.InspectDetail \n" +
                "WHERE ");

        if (searchVO.getStartSTime()==null||searchVO.getEndSTime()==null){
            sql.append("DATEDIFF( MONTH, CerateTime, '2018-11-02' ) = 0");
        }

        if (searchVO.getStartSTime()!=null&&searchVO.getEndSTime()!=null){
            sql.append("CerateTime BETWEEN  '"+ searchVO.getStartSTime() +"' AND '"+searchVO.getEndSTime()+"'");
        }


        sql.append("GROUP BY\n" +
                "dbo.InspectDetail.InspectDate \n" +
                ") AS num \n" +
                ") AS less");

        return sql.toString();
    }

}
