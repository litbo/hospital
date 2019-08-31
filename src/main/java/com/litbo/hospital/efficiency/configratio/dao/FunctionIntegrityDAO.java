package com.litbo.hospital.efficiency.configratio.dao;

import com.litbo.hospital.efficiency.configratio.bean.FunctionIntegrityBean;
import com.litbo.hospital.efficiency.configratio.vo.FunctionIntegrityRatioVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * description: 功能完好率DAO层
 * @author: sz
 * @date: 2019/8/29 10:56
 */
@Mapper
public interface FunctionIntegrityDAO {

    /**
     * 添加功能完好率
     * @param integrityBean 参数
     * @return 返回成功插入的条数
     */
    @Insert({
            "insert into function_integrity (eqSbbh,eqName,integrityNum,exitNum,ratio) values",
            "(#{integrityBean.eqSbbh},#{integrityBean.eqName},#{integrityBean.integrityNum}," +
                    "#{integrityBean.exitNum},#{integrityBean.ratio})"
    })
    Integer addFunctionIntegrity(@Param("integrityBean") FunctionIntegrityBean integrityBean);

    /**
     * 查询设备功能完好率
     * @return 返回设备功能完好率
     */
    @Select("SELECT *FROM dbo.function_integrity")
    List<FunctionIntegrityRatioVO> showIntegrity();

    /**
     * 根据id查询设备功能完好率
     * @param id 设备id
     * @return  id对应的设备功能完好率
     */
    @Select("SELECT *FROM dbo.function_integrity where id = #{id}")
    FunctionIntegrityRatioVO showIntegrityById(@Param("id") Integer id);

    /**
     * 根据设备编号查询是否有该设备的存在
     * @param eqSbbh 设备编号
     * @return 返回该设备编号对应的设备数
     */
    @Select("SELECT *FROM dbo.function_integrity where eqSbbh = #{eqCode}")
    Integer selectIntegrityByeqSbbh(@Param("eqCode") String eqSbbh);

    /**
     * 更改设备功能完好率对应的信息
     * @param integrityRatioVO 设备功能完好率
     * @return  更新多少
     */
    @Update({
            "<script>",
            "update dbo.function_integrity",
            "<set>",
            "<if test = 'integrityRatioVO.eqSbbh != null'>eqSbbh = #{integrityRatioVO.eqSbbh},</if>",
            "<if test = 'integrityRatioVO.eqName != null'>eqName = #{integrityRatioVO.eqName},</if>",
            "<if test = 'integrityRatioVO.exitNum != null'>exitNum = #{integrityRatioVO.exitNum},</if>",
            "<if test = 'integrityRatioVO.integrityNum != null'>integrityNum = #{integrityRatioVO.integrityNum},</if>",
            "</set>",
            "where id = #{integrityRatioVO.id}",
            "</script>"
    })
    Integer updateIntegrity(@Param("integrityRatioVO") FunctionIntegrityRatioVO integrityRatioVO);

    /**
     * 批量删除功能完好率
     * @param list id
     * @return 删除几条
     */
    @Delete({
            "<script>",
            "DELETE FROM dbo.function_integrity WHERE id in",
            "<foreach item = 'item' index = 'index' collection = 'list' open = '(' separator = ',' close = ')'>",
            "#{item}",
            "</foreach>",
            "</script>"
    })
    Integer deleteIntegrity(@Param("list") List<Integer> list);

}
