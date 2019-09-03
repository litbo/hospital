package com.litbo.hospital.beneficial.dao;

import com.litbo.hospital.beneficial.dao.provider.CountIncomeProvider;
import com.litbo.hospital.beneficial.vo.CountIncomeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 *
 * description: His、Pacs、手术室系统的收入DAO层
 * @Author: jz
 * @date 2019/7/26 15:16
 */
@Mapper
public interface CountIncomeDAO {

    /**
     * description: his系统的收入
     * @return 返回his系统的收入
     */
    @SelectProvider(type = CountIncomeProvider.class,method = "selectHis")
    List<CountIncomeVO> selectHis();

    /**
     * description: Pacs系统的收入
     * @return 返回Pacs系统的收入
     */
    @SelectProvider(type = CountIncomeProvider.class,method = "selectPacs")
    List<CountIncomeVO> selectPacs();

    /**
     * description: 手术室系统的收入
     * @return 返回手术室系统的收入
     */
    @SelectProvider(type = CountIncomeProvider.class,method = "selectSss")
    List<CountIncomeVO> selectSss();

    /**
     * description:把查询处理过的收费数据插入到表中
     * @param list 为添加过的收费记录
     * @return 返回
     */
    @Update({"<script>",
            "insert into dbo.income" +
                    "(ks_id, eq_id, km_sj, km_num, km_name, km_value, km_cjdm, bm_name, eq_name) values "+
                    "<foreach item = 'item' index = 'index' collection = 'list' separator = ','>",
                    "(#{item.ksId},#{item.sbId},#{item.kmSj},#{item.kmNum},#{item.kmName},#{item.keJe}," +
                            "#{item.kmCjdm},#{item.bmName},#{item.eqName})",
                    "</foreach>",
            "</script>"})
    int insertSbcw(@Param("list") List<CountIncomeVO> list);


    /**
     * 每天定时查询his系统的收入
     * @return 返回上一日his系统的收入
     */
    @SelectProvider(type = CountIncomeProvider.class,method = "timingSelectHis")
    List<CountIncomeVO> timingSelectHis();

    /**
     * 每天定时查询pacs系统的收入
     * @return  返回上一日pacs系统的收入
     */
    @SelectProvider(type = CountIncomeProvider.class,method = "timingSelectPacs")
    List<CountIncomeVO> timingSelectPacs();

    /**
     * 每天定时查询手术室系统的收入
     * @return  返回上一日手术室系统的收入
     */
    @SelectProvider(type = CountIncomeProvider.class,method = "timingSelectSss")
    List<CountIncomeVO> timingSelectSss();

}
