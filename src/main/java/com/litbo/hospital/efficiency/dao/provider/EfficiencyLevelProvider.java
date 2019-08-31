package com.litbo.hospital.efficiency.dao.provider;

import com.litbo.hospital.common.utils.calculate.HandleData;
import com.litbo.hospital.common.utils.calculate.HandleLevel;
import com.litbo.hospital.efficiency.vo.EfficiencyLevelVO;
import com.litbo.hospital.efficiency.vo.SearchVO;
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

    public String selectLevelByCon(SearchVO searchVO){
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

        if (searchVO.getSearchLevel()!=null&&!searchVO.getSearchLevel().trim().equals("")){
            if (HandleLevel.overLoad(searchVO)){
                sql.append("AND CAST(k.ratio AS DECIMAL) > 100\n");
            }

            else if (HandleLevel.efficient(searchVO)){
                sql.append("AND (CAST(k.ratio AS DECIMAL) <= 100 AND CAST(k.ratio AS DECIMAL) >= lev.[using])\n");
            }
            else if (HandleLevel.midEfficient(searchVO)){
                sql.append("AND (CAST(k.ratio AS DECIMAL) < lev.[using] AND CAST(k.ratio AS DECIMAL) >= lev.[idling])\n");
            }
            else if (HandleLevel.inefficient(searchVO)){
                sql.append("AND (CAST(k.ratio AS DECIMAL) < lev.[idling] AND CAST(k.ratio AS DECIMAL) > 0 )\n");
            }
            else if (HandleLevel.idle(searchVO)){
                sql.append("AND CAST(k.ratio AS DECIMAL) = 0\n");
            }

            else {
                sql.append("AND CAST(k.ratio AS DECIMAL) < 0\n");
            }

        }

        if (searchVO.getStartSTime()!=null&&searchVO.getEndSTime()!=null){
            sql.append("AND k.times BETWEEN '"+ searchVO.getStartSTime()+
                    "' AND '"+searchVO.getEndSTime()+"'\n");
        }

        if (StringUtils.isNotBlank(searchVO.getBmSName())){
            sql.append("AND bm.bm_name LIKE '%"+searchVO.getBmSName()+"%'\n");
        }

        return sql.toString();
    }

}
