package com.litbo.hospital.efficiency.dao.provider;

import com.litbo.hospital.efficiency.vo.IntegrityVO;
import com.litbo.hospital.efficiency.vo.SearchVO;
import org.apache.commons.lang3.StringUtils;

/**
 *  设备完好率的SQL实现语句
 *   @Author: jz
 *   @Date: 2019/7/31 16:59
 */
public class IntegrityProvider {

    /**
     * 默认搜索设备的完好率
     * @return 返回sql
     */
   public String selectIntegrity(){
       StringBuilder sql = new StringBuilder("SELECT\n" +
               "eqNum.eqName,\n" +
               "eqUsing.usingNums,\n" +
               "eqNum.eqNums \n" +
               "FROM\n" +
               "(\n" +
               "SELECT\n" +
               "info.eq_name AS eqName,\n" +
               "COUNT ( info.eq_name ) AS eqNums \n" +
               "FROM\n" +
               "dbo.eq_info info\n" +
               "INNER JOIN dbo.s_bm bm ON info.eq_bmid = bm.bm_id \n" +
               "\n" +
               "GROUP BY\n" +
               "info.eq_name \n" +
               ") AS eqNum,\n" +
               "(\n" +
               "SELECT\n" +
               "info.eq_name AS eqName,\n" +
               "COUNT ( info.eq_syzt ) AS usingNums \n" +
               "FROM\n" +
               "dbo.eq_info info\n" +
               "INNER JOIN dbo.s_bm bm ON info.eq_bmid = bm.bm_id \n" +
               "WHERE\n" +
               "( info.eq_syzt = '在用' ) \n" +
               "GROUP BY\n" +
               "info.eq_name \n" +
               ") AS eqUsing \n" +
               "WHERE\n" +
               "eqNum.eqName = eqUsing.eqName");

       return sql.toString();
   }

    /**
     * 按条件搜索设备的完好率
     * @param searchVO 设备的完好率条件
     * @return  设备的完好率
     */
   public String selectIntegrityByCon(SearchVO searchVO){

       StringBuilder sql = new StringBuilder("SELECT\n" +
               "eqNum.eqName,\n" +
               "eqUsing.usingNums,\n" +
               "eqNum.eqNums \n" +
               "FROM\n" +
               "(\n" +
               "SELECT\n" +
               "info.eq_name AS eqName,\n" +
               "COUNT ( info.eq_name ) AS eqNums \n" +
               "FROM\n" +
               "dbo.eq_info info\n" +
               "INNER JOIN dbo.s_bm bm ON info.eq_bmid = bm.bm_id ");

       if (StringUtils.isNotBlank(searchVO.getBmSName())||StringUtils.isNotBlank(searchVO.getEqSName())){
           sql.append("WHERE");
       }

       if (StringUtils.isNotBlank(searchVO.getBmSName())){
           sql.append(" info.eq_bmid IN ( SELECT s_bm.bm_id FROM s_bm WHERE s_bm.bm_name LIKE '%");
           sql.append(searchVO.getBmSName()+"%' )");
       }

       if (StringUtils.isNotBlank(searchVO.getEqSName())){
           sql.append("AND info.eq_name IN ( SELECT eq_info.eq_name FROM eq_info WHERE eq_info.eq_name LIKE '%");
           sql.append(searchVO.getEqSName()+"%' )");
       }

       sql.append("GROUP BY\n" +
               "info.eq_name \n" +
               ") AS eqNum,\n" +
               "(\n" +
               "SELECT\n" +
               "info.eq_name AS eqName,\n" +
               "COUNT ( info.eq_syzt ) AS usingNums \n" +
               "FROM\n" +
               "dbo.eq_info info\n" +
               "INNER JOIN dbo.s_bm bm ON info.eq_bmid = bm.bm_id \n" +
               "WHERE\n" +
               "info.eq_syzt = '在用' ");

       if (StringUtils.isNotBlank(searchVO.getBmSName())){
           sql.append(" AND info.eq_bmid IN ( SELECT s_bm.bm_id FROM s_bm WHERE s_bm.bm_name LIKE '%");
           sql.append(searchVO.getBmSName()+"%' )");
       }

       if (StringUtils.isNotBlank(searchVO.getEqSName())){
           sql.append("AND info.eq_name IN ( SELECT eq_info.eq_name FROM eq_info WHERE eq_info.eq_name LIKE '%");
           sql.append(searchVO.getEqSName()+"%' )");
       }

       sql.append("GROUP BY\n" +
               "info.eq_name \n" +
               ") AS eqUsing \n" +
               "WHERE\n" +
               "eqNum.eqName = eqUsing.eqName");

       return sql.toString();
   }

}
