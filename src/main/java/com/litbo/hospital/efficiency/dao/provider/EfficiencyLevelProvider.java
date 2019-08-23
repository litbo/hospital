package com.litbo.hospital.efficiency.dao.provider;

import com.litbo.hospital.common.utils.calculate.HandleData;
import com.litbo.hospital.common.utils.calculate.HandleLevel;
import com.litbo.hospital.efficiency.vo.EfficiencyLevelVO;
import org.apache.commons.lang3.StringUtils;

/**
 * description: sql
 * @author: sz
 * @date: 2019/8/5 16:34
 */
public class EfficiencyLevelProvider {

    public String selectLevel(){

        String sql = "SELECT\n" +
                "k.eqCode,\n" +
                "k.eqName,\n" +
                "k.ratio + '%' AS eqUsing \n" +
                "FROM\n" +
                "dbo.kpi k,\n" +
                "dbo.efficiency_level lev\n" +
                "WHERE\n" +
                "k.dataStatus = '2' ";

        return sql;
    }

    public String selectLevelByCon(EfficiencyLevelVO levelVO){
        StringBuilder sql = new StringBuilder("SELECT\n" +
                "k.eqCode,\n" +
                "k.eqName,\n" +
                "k.ratio + '%' AS eqUsing \n" +
                "FROM\n" +
                "dbo.kpi k,\n" +
                "dbo.efficiency_level lev,\n" +
                "dbo.s_bm bm,\n" +
                "dbo.eq_info eq\n" +
                "WHERE\n" +
                "k.eqCode = eq.eq_sbbh\n" +
                "AND eq.eq_bmid = bm.bm_id\n" +
                "AND k.dataStatus = '2' ");

        if (levelVO.getSearchLevel()!=null&&!levelVO.getSearchLevel().trim().equals("")){
            if (HandleLevel.overLoad(levelVO)){
                sql.append("AND CAST(k.ratio AS DECIMAL) > 100\n");
            }

            else if (HandleLevel.efficient(levelVO)){
                sql.append("AND (CAST(k.ratio AS DECIMAL) <= 100 AND CAST(k.ratio AS DECIMAL) >= lev.using)\n");
            }
            else if (HandleLevel.midEfficient(levelVO)){
                sql.append("AND (CAST(k.ratio AS DECIMAL) < lev.[using] AND CAST(k.ratio AS DECIMAL) >= lev.idling)\n");
            }
            else if (HandleLevel.inefficient(levelVO)){
                sql.append("AND (CAST(k.ratio AS DECIMAL) < lev.idling AND CAST(k.ratio AS DECIMAL) > 0 )\n");
            }
            else if (HandleLevel.idle(levelVO)){
                sql.append("AND CAST(k.ratio AS DECIMAL) = 0\n");
            }

            else {
                sql.append("AND CAST(k.ratio AS DECIMAL) < 0\n");
            }

        }

        if (levelVO.getStartTime()!=null&&levelVO.getEndTime()!=null){
            sql.append("AND k.times BETWEEN '"+ HandleData.changeDate(levelVO.getStartTime())+
                    "' AND '"+HandleData.changeDate(levelVO.getEndTime())+"'\n");
        }

        if (StringUtils.isNotBlank(levelVO.getSearchBmName())){
            sql.append("AND bm.bm_name LIKE '%"+levelVO.getSearchBmName()+"%'\n");
        }

        System.out.println(sql);

        return sql.toString();
    }

}
