package com.litbo.hospital.efficiency.configratio.dao;

import com.litbo.hospital.efficiency.configratio.bean.FunctionUsingBean;
import com.litbo.hospital.efficiency.configratio.vo.FunctionUsingRatioVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * description: 利用率DAO层
 * @author: sz
 * @date: 2019/8/29 10:50
 */
@Mapper
public interface FunctionUsingDAO {

    /**
     * 利用率
     * @param usingBean 参数
     * @return 返回插入的条数
     */
    @Insert({
            "insert into function_using (eqSbbh,eqName,usingNum,exitNum,ratio) values",
            "(#{usingBean.eqSbbh},#{usingBean.eqName},#{usingBean.usingNum}," +
                    "#{usingBean.exitNum},#{usingBean.ratio})"
    })
    Integer addFunctionUsing(@Param("usingBean") FunctionUsingBean usingBean);

    /**
     * 查询功能利用率
     * @return 返回功能利用率的所有信息
     */
    @Select("SELECT *FROM dbo.function_using")
    List<FunctionUsingRatioVO> showUsing();

    /**
     * 根据Id查询设备的功能利用率
     * @param id 设备id
     * @return 根据id查询的设备信息
     */
    @Select("SELECT *FROM dbo.function_using where id = #{id}")
    FunctionUsingRatioVO showUsingUsingById(@Param("id") Integer id);

    /**
     * 根据设备编号查询设备的功能利用率
     * @param eqSbbh 设备编号
     * @return 共有几个设备
     */
    @Select("SELECT *FROM dbo.function_using where eqSbbh = #{eqSbbh}")
    Integer selectUsingByEqBh(@Param("eqSbbh") String eqSbbh);

    /**
     * 更改功能利用率的信息
     * @param ratioVO 功能利用率
     * @return 返回修改后的功能利用率
     */
    @Update({
            "<script>",
            "UPDATE dbo.function_using",
            "<set>",
            "<if test='ratioVO.eqSbbh != null'> eqSbbh = #{ratioVO.eqSbbh},</if>",
            "<if test='ratioVO.eqName != null'> eqName = #{ratioVO.eqName},</if>",
            "<if test='ratioVO.exitNum != null'> exitNum = #{ratioVO.exitNum},</if>",
            "<if test='ratioVO.usingNum != null'> usingNum = #{ratioVO.usingNum},</if>",
            "<if test='ratioVO.ratio != null'> ratio = #{ratioVO.ratio}</if>",
            "</set>",
            "where id = #{ratioVO.id}",
            "</script>"
    })
    Integer updateUsing(@Param("ratioVO") FunctionUsingRatioVO ratioVO);

    /**
     * 批量删除功能利用率
     * @param ids id
     * @return 删除几条
     */
    @Delete({
            "<script>",
            "DELETE FROM dbo.function_using WHERE id in",
            "<foreach item = 'item' index = 'index' collection = 'array' open = '(' separator = ',' close = ')'>",
            "#{item}",
            "</foreach>",
            "</script>"
    })
    Integer deleteUsing(Integer[] ids);

}
