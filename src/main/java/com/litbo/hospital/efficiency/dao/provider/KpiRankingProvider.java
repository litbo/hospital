package com.litbo.hospital.efficiency.dao.provider;

import com.litbo.hospital.efficiency.vo.KpiRankingVO;
import org.apache.commons.lang3.StringUtils;

/**
 * description: 各种kpi排名的sql
 * @author: sz
 * @date: 2019/8/4 14:20
 */
public class KpiRankingProvider {

    public String selectChange(KpiRankingVO kpiRankingVO){

        String day = "2";
        String month = "0";

        StringBuilder sql = new StringBuilder("SELECT\n" +
                " one.eqCode,\n" +
                " one.eqName,\n" +
                " one.ranking AS Ranking,\n" +
                " two.ranking AS oldRanking,\n" +
                " two.ranking-one.ranking AS change\n" +
                "FROM\n" +
                "(\n" +
                "SELECT\n" +
                "* \n" +
                "FROM\n" +
                "dbo.kpi \n" +
                "WHERE ");

        if (StringUtils.isNotBlank(kpiRankingVO.getStatus())){
            //设备的日期类型
            sql.append("kpi.status = '"+kpiRankingVO.getStatus()+"'");

            if (day.equals(kpiRankingVO.getStatus())){
                sql.append(" AND DATEDIFF( DAY, kpi.times, GETDATE() ) = 0 ");
            }
            if (month.equals(kpiRankingVO.getStatus())){
                sql.append("AND DATEDIFF( MONTH ,kpi.times, GETDATE()) = 0 ");
            }
        }

        // 设备的kpi类型
        if (StringUtils.isNotBlank(kpiRankingVO.getDataStatus())){
            sql.append(" AND kpi.dataStatus = '"+kpiRankingVO.getDataStatus()+"'");
        }

        sql.append(") AS one,\n" +
                "(\n" +
                "SELECT\n" +
                "* \n" +
                "FROM\n" +
                "dbo.kpi \n" +
                "WHERE ");

        if (StringUtils.isNotBlank(kpiRankingVO.getStatus())){
            //设备的日期类型
            sql.append("kpi.status = '"+kpiRankingVO.getStatus()+"' ");

            if (day.equals(kpiRankingVO.getStatus())){
                sql.append("AND DATEDIFF( DAY, kpi.times, GETDATE() ) = 1 ");
            }
            if (month.equals(kpiRankingVO.getStatus())){
                sql.append("AND DATEDIFF( MONTH ,kpi.times, GETDATE()) = 1 ");
            }
        }

        // 设备的kpi类型
        if (StringUtils.isNotBlank(kpiRankingVO.getDataStatus())){
            sql.append("AND kpi.dataStatus = '"+kpiRankingVO.getDataStatus()+"'");
        }

        sql.append(") AS two \n" +
                "WHERE\n" +
                "one.eqName = two.eqName \n" +
                "AND one.eqCode = two.eqCode");

        System.out.println(sql);

        return sql.toString();
    }

}
