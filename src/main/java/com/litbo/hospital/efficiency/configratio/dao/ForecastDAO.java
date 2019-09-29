package com.litbo.hospital.efficiency.configratio.dao;

import com.litbo.hospital.efficiency.configratio.bean.ForecastBean;
import com.litbo.hospital.efficiency.configratio.vo.ForecastRatioVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * description: 预测符合率
 * @author: sz
 * @date: 2019/8/29 11:08
 */
@Mapper
public interface ForecastDAO {

    /**
     * 添加预测符合率
     *  @param forecastBean 参数
     * @return 返回工插入的数据条数
     */
    @Insert({
            "insert into forecast_ratio (eqSbbh,eqName,actualNum,forecastNum,ratio) values",
            "(#{forecastBean.eqSbbh},#{forecastBean.eqName},#{forecastBean.actualNum}," +
                    "#{forecastBean.forecastNum},#{forecastBean.ratio})"
    })
    Integer addForecast(@Param("forecastBean") ForecastBean forecastBean);

    /**
     * 查询设备的预测符合率
     * @return 返回预测符合率
     */
    @Select("SELECT *FROM dbo.forecast_ratio")
    List<ForecastRatioVO> showForecast();

    /**
     * 根据id查询预测符合率
     * @param id 设备id
     * @return 返回预测符合率
     */
    @Select("SELECT *FROM dbo.forecast_ratio where id = #{id}")
    ForecastRatioVO showForecastById(Integer id);

    /**
     * 根据设备编号查询预测符合率
     * @param code 设备编号
     * @return 几个
     */
    @Select("SELECT *FROM dbo.forecast_ratio where eqSbbh = #{code}")
    Integer selectByEqCode(String code);

    /**
     * 更新设备预测符合率
     * @param forecastRatioVO 设备预测
     * @return 返回更新的条数
     */
    @Update({
            "<script>",
            "update dbo.forecast_ratio",
            "<set>",
            "<if test = 'forecastRatioVO.eqSbbh != null'>eqSbbh = #{forecastRatioVO.eqSbbh},</if>",
            "<if test = 'forecastRatioVO.eqName != null'>eqName = #{forecastRatioVO.eqName},</if>",
            "<if test = 'forecastRatioVO.actualNum != null'>actualNum = #{forecastRatioVO.actualNum},</if>",
            "<if test = 'forecastRatioVO.forecastNum != null'>forecastNum = #{forecastRatioVO.forecastNum},</if>",
            "<if test = 'forecastRatioVO.ratio != null'> ratio = #{forecastRatioVO.ratio}</if>",
            "</set>",
            "where id = #{forecastRatioVO.id}",
            "</script>"
    })
    Integer updateForecast(@Param("forecastRatioVO") ForecastRatioVO forecastRatioVO);


    /**
     * 删除预测符合率
     * @param ids id
     * @return 删除几条
     */
    @Delete({
            "<script>",
            "DELETE FROM dbo.forecast_ratio WHERE id in",
            "<foreach item = 'item' index = 'index' collection = 'array' open = '(' separator = ',' close = ')'>",
            "#{item}",
            "</foreach>",
            "</script>"
    })
    Integer deleteForecast(Integer[] ids);

}
