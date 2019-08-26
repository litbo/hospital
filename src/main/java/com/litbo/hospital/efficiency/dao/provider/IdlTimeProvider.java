package com.litbo.hospital.efficiency.dao.provider;

import com.litbo.hospital.common.utils.calculate.HandleData;
import com.litbo.hospital.efficiency.vo.IdlTimeVO;
import com.litbo.hospital.efficiency.vo.SearchVO;
import org.apache.commons.lang3.StringUtils;

/**
 * description: 工作日闲置时间
 * @Author: jz
 * @Date: 2019/8/2 12:28
 */
public class IdlTimeProvider {

    public String selectIdlTime(){

        String sql = "SELECT MAX\n" +
                "( info.eq_sbbh ) AS eqCode,\n" +
                "MAX ( info.eq_name ) AS eqName,\n" +
                "MAX ( app.work_days ) AS workDays,\n" +
                "SUM (\n" +
                "DATEDIFF( SECOND, insp.BeginTime, insp.EndTime )) AS idleTimes\n" +
                "FROM\n" +
                "dbo.eq_info info,\n" +
                "dbo.s_bm bm,\n" +
                "dbo.eq_mac_tab mac,\n" +
                "dbo.InspectDetail insp,\n" +
                "dbo.approved_working_hours app \n" +
                "WHERE\n" +
                "info.eq_bmid = bm.bm_id \n" +
                "AND insp.MachineNumber = mac.PMacID\n" +
                "AND mac.EquID = info.eq_id \n" +
                "AND app.eq_mac_id = mac.MacID\n" +
                "AND insp.NewStatus = '02' \n" +
                "AND DATEDIFF(MONTH, insp.CerateTime, '2018-11-02') = 0\n" +
                "GROUP BY\n" +
                "insp.MachineNumber";


        return sql;
    }

    public String selectIdlTimeByCon(SearchVO searchVO){

        StringBuilder sql = new StringBuilder("SELECT MAX\n" +
                "( info.eq_sbbh ) AS eqCode,\n" +
                "MAX ( info.eq_name ) AS eqName,\n" +
                "MAX ( app.work_days ) AS workDays,\n" +
                "SUM (\n" +
                "DATEDIFF( SECOND, insp.BeginTime, insp.EndTime )) AS idleTimes\n" +
                "FROM\n" +
                "dbo.eq_info info,\n" +
                "dbo.s_bm bm,\n" +
                "dbo.eq_mac_tab mac,\n" +
                "dbo.InspectDetail insp,\n" +
                "dbo.approved_working_hours app \n" +
                "WHERE\n" +
                "info.eq_bmid = bm.bm_id \n" +
                "AND insp.MachineNumber = mac.PMacID\n" +
                "AND mac.EquID = info.eq_id \n" +
                "AND app.eq_mac_id = mac.MacID\n" +
                "AND insp.NewStatus = '02' ");

        if (StringUtils.isNotBlank(searchVO.getBmSName())){
            sql.append("AND info.eq_name LIKE '%"+searchVO.getEqSName()+"%'");
        }

        if (StringUtils.isNotBlank(searchVO.getBmSName())){
            sql.append("AND bm.bm_name LIKE '%"+searchVO.getEqSName()+"%'");
        }

        if (searchVO.getStartSTime()==null||searchVO.getEndSTime()==null){
            sql.append("AND DATEDIFF(MONTH, insp.CerateTime, '2018-11-02') = 0");
        }

        if (searchVO.getStartSTime()!=null&&searchVO.getEndSTime()!=null){
            sql.append("AND insp.CerateTime BETWEEN"+ searchVO.getStartSTime()+" AND "+searchVO.getEndSTime());
        }

        sql.append("GROUP BY insp.MachineNumber");


        return sql.toString();
    }

}
