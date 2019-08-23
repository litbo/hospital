package com.litbo.hospital.efficiency.dao.provider;

import com.litbo.hospital.common.utils.calculate.HandleData;
import com.litbo.hospital.efficiency.vo.IdlingVO;
import org.apache.commons.lang3.StringUtils;

/**
 * description: 空转率
 * @Author: jz
 * @Date: 2019/8/1 16:28
 */
public class IdlingProvider {

    public String selectIdling(){
        String sql = "SELECT\n" +
                "works.eqCode,works.eqJc,works.workTimes,idles.idleTimes\n" +
                "FROM\n" +
                "(\n" +
                "SELECT MAX\n" +
                "( dbo.eq_info.eq_sbbh ) AS eqCode,\n" +
                "MAX ( eq_jiancheng.c_AName ) AS eqJc,\n" +
                "SUM (\n" +
                "DATEDIFF( SECOND, Dbo.InspectDetail.BeginTime, dbo.InspectDetail.EndTime )) AS workTimes \n" +
                "FROM\n" +
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
                "AND dbo.InspectDetail.InspectDate = (\n" +
                "SELECT CONVERT\n" +
                "( VARCHAR ( 10 ), '2018-11-02', 120 )) \n" +
                "AND dbo.InspectDetail.NewStatus = '01' \n" +
                "GROUP BY\n" +
                "dbo.eq_info.eq_sbbh\n" +
                ") AS works,\n" +
                "(\n" +
                "SELECT MAX\n" +
                "( dbo.eq_info.eq_sbbh ) AS eqCode,\n" +
                "MAX ( eq_jiancheng.c_AName ) AS eqJc,\n" +
                "SUM (\n" +
                "DATEDIFF( SECOND, Dbo.InspectDetail.BeginTime, dbo.InspectDetail.EndTime )) AS idleTimes \n" +
                "FROM\n" +
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
                "AND dbo.InspectDetail.InspectDate = (\n" +
                "SELECT CONVERT\n" +
                "( VARCHAR ( 10 ), '2018-11-02', 120 )) \n" +
                "AND dbo.InspectDetail.NewStatus = '02' \n" +
                "GROUP BY\n" +
                "dbo.eq_info.eq_sbbh\n" +
                ") AS idles\n" +
                "WHERE works.eqCode = idles.eqCode";


        return sql;
    }

    public String selectIdlingByCon(IdlingVO idlingVO){
        StringBuilder sql = new StringBuilder("SELECT\n" +
                "works.eqCode,works.eqJc,works.workTimes,idles.idleTimes\n" +
                "FROM\n" +
                "(\n" +
                "SELECT MAX\n" +
                "( dbo.eq_info.eq_sbbh ) AS eqCode,\n" +
                "MAX ( eq_jiancheng.c_AName ) AS eqJc,\n" +
                "SUM (\n" +
                "DATEDIFF( SECOND, Dbo.InspectDetail.BeginTime, dbo.InspectDetail.EndTime )) AS workTimes \n" +
                "FROM\n" +
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
                "AND dbo.eq_info.eq_bmid = dbo.s_bm.bm_id\n" +
                "AND dbo.InspectDetail.NewStatus = '01'");

        if (StringUtils.isNotBlank(idlingVO.getEqSName())){
            sql.append("AND dbo.eq_jiancheng.c_AName LIKE '%"+idlingVO.getEqSName()+"%'");
        }

        if (StringUtils.isNotBlank(idlingVO.getBmSName())){
            sql.append("AND dbo.s_bm.bm_name LIKE '%"+idlingVO.getBmSName()+"%'");
        }

        if (idlingVO.getStartSTime()==null||idlingVO.getEndSTime()==null){
            sql.append("AND dbo.InspectDetail.InspectDate = (\n" +
                    "SELECT CONVERT\n" +
                    "( VARCHAR ( 10 ), '2018-11-02', 120 )) ");
        }

        if (idlingVO.getStartSTime()!=null&&idlingVO.getEndSTime()!=null){
            sql.append("AND dbo.InspectDetail.CerateTime BETWEEN  "+ HandleData.changeDate(idlingVO.getStartSTime()) +" AND "+HandleData.changeDate(idlingVO.getEndSTime()));
        }

        sql.append("GROUP BY\n" +
                "dbo.eq_info.eq_sbbh\n" +
                ") AS works,\n" +
                "(\n" +
                "SELECT MAX\n" +
                "( dbo.eq_info.eq_sbbh ) AS eqCode,\n" +
                "MAX ( eq_jiancheng.c_AName ) AS eqJc,\n" +
                "SUM (\n" +
                "DATEDIFF( SECOND, Dbo.InspectDetail.BeginTime, dbo.InspectDetail.EndTime )) AS idleTimes \n" +
                "FROM\n" +
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
                "AND dbo.eq_info.eq_bmid = dbo.s_bm.bm_id\n" +
                "AND dbo.InspectDetail.NewStatus = '02' ");

        if (StringUtils.isNotBlank(idlingVO.getEqSName())){
            sql.append("AND dbo.eq_jiancheng.c_AName LIKE '%"+idlingVO.getEqSName()+"%'");
        }

        if (StringUtils.isNotBlank(idlingVO.getBmSName())){
            sql.append("AND dbo.s_bm.bm_name LIKE '%"+idlingVO.getBmSName()+"%'");
        }

        if (idlingVO.getStartSTime()==null||idlingVO.getEndSTime()==null){
            sql.append("AND dbo.InspectDetail.InspectDate = (\n" +
                    "SELECT CONVERT\n" +
                    "( VARCHAR ( 10 ), '2018-11-02', 120 )) ");
        }

        if (idlingVO.getStartSTime()!=null&&idlingVO.getEndSTime()!=null){
            sql.append("AND dbo.InspectDetail.CerateTime BETWEEN  "+ HandleData.changeDate(idlingVO.getStartSTime()) +" AND "+HandleData.changeDate(idlingVO.getEndSTime()));
        }

        sql.append("GROUP BY\n" +
                "dbo.eq_info.eq_sbbh\n" +
                ") AS idles\n" +
                "WHERE works.eqCode = idles.eqCode");

        return sql.toString();
    }
}
