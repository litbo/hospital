package com.litbo.hospital.efficiency.dao;

import com.litbo.hospital.efficiency.bean.KpiBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * description: 比率
 * @author: sz
 * @date: 2019/8/3 11:18
 */
@Mapper
public interface RadioDAO {

    /**
     * 将查询到的数据插入数据库
     * @param kpiBean 插入数据库的对象
     * @return 返回
     */
    @Insert({
            "<script>",
            "insert into dbo.kpi"+
                    "(eqCode,eqName,ratio,ranking,times,status,dataStatus) values"+
                    "<foreach item = 'item' index = 'index' collection = 'list' separator = ','>",
            "(#{item.eqCode},#{item.eqName},#{item.ratio},#{item.ranking}," +
                    "#{item.times},#{item.status},#{item.dataStatus})",
            "</foreach>",
            "</script>"})
    int insertKpi(@Param("list") List<KpiBean> kpiBean);


}
