package com.litbo.hospital.lifemanage.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * 讨论申购设备关联表Mapper接口
 */
@Mapper
public interface SgTlPmMapper {
    /**
     * 申购设备关联信息批量添加
     *
     * @param kstlId 科室讨论的ID
     * @param pmId   设备品名ID
     * @return 添加的数据的数量
     */
    @Insert({
            "insert into sg_tl_pm (kstl_id, eq_pm_id,kstl_sj)",
            "values (#{kstlId,jdbcType=VARCHAR}, #{eqPmId,jdbcType=VARCHAR},#{kstlSj,jdbcType=TIMESTAMP})"
    })
    int insertSgTlPm(@Param("kstlId") String kstlId, @Param("eqPmId") String pmId, @Param("kstlSj") Date kstlSj);

    /**
     * 通过科室讨论ID查询讨论的品名ID
     *
     * @param kstlId 科室讨论ID
     * @return 同一个讨论的所有品名ID
     */
    @Select("SELECT\n" +
            "sg_tl_pm.eq_pm_id\n" +
            "FROM\n" +
            "sg_tl_pm\n" +
            "WHERE\n" +
            "sg_tl_pm.kstl_id = #{kstlId}\n")
    List<String> selectSgTlPmPmIdsByTlId(String kstlId);
}