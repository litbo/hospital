package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgKstl;
import com.litbo.hospital.lifemanage.bean.vo.SgKstlAddSgInfoVO;
import com.litbo.hospital.lifemanage.bean.vo.SgKstlToVO;
import com.litbo.hospital.lifemanage.dao.provider.SgKstlSqlProvider;
import com.litbo.hospital.supervise.bean.SEmp;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 科室讨论表Mapper接口
 */
@Mapper
public interface SgKstlMapper {
    /**
     * 添加科室讨论信息
     *
     * @param sgKstl 科室讨论实体对象
     * @return 返回插入条数
     */
    @Insert("INSERT INTO sg_kstl (kstl_id, user_id_jl, bm_id, \n" +
            "   kstl_time, kstl_addr, extend_one, \n" +
            "   extend_two, kstl_yj, kstl_content\n" +
            ")\n" +
            "VALUES (#{kstlId,jdbcType=VARCHAR}, #{userIdJl,jdbcType=VARCHAR}, #{bmId,jdbcType=CHAR}, \n" +
            "   #{kstlTime,jdbcType=TIMESTAMP}, #{kstlAddr,jdbcType=VARCHAR}, #{extendOne,jdbcType=VARCHAR}, \n" +
            "   #{extendTwo,jdbcType=VARCHAR}, #{kstlYj,jdbcType=LONGVARCHAR}, #{kstlContent,jdbcType=LONGVARCHAR}\n" +
            ")")
    Integer insertSgKstl(SgKstl sgKstl);

    /**
     * 通过部门id查询讨论表的信息
     *
     * @param bmId 部门ID
     * @return 部门所有的讨论ID
     */
    @Select("SELECT\n" +
            "sg_kstl.kstl_id\n" +
            "FROM\n" +
            "sg_kstl\n" +
            "WHERE\n" +
            "dbo.sg_kstl.bm_id =#{bmId,jdbcType=CHAR}")
    List<String> selectSgKstlIdsByBmId(String bmId);

    /**
     * 通过品名id查询SgKstlVO
     *
     * @param pmIds 品名id
     * @return SgKstlAddSgInfoVO
     */
    @SelectProvider(type = SgKstlSqlProvider.class,method = "selectSgKstlVOByEqPmIds")
    List<SgKstlAddSgInfoVO> selectSgKstlVOByPmIds(@Param("pmIds") List<String> pmIds);

    /**
     * 查询科室讨论表信息
     * @param kstlId 科室讨论表id
     * @return SgKstlToVO
     */
    @Select("SELECT\n" +
            "dbo.sg_kstl.kstl_time,\n" +
            "dbo.sg_kstl.kstl_addr,\n" +
            "dbo.sg_kstl.kstl_yj,\n" +
            "dbo.sg_kstl.kstl_content,\n" +
            "dbo.s_bm.bm_name,\n" +
            "dbo.s_emp.user_xm AS userNameJl" +
            "\n" +
            "FROM\n" +
            "dbo.sg_kstl\n" +
            "LEFT JOIN dbo.s_bm ON dbo.sg_kstl.bm_id = dbo.s_bm.bm_id\n" +
            "LEFT JOIN dbo.s_emp ON dbo.sg_kstl.user_id_jl = dbo.s_emp.user_id\n" +
            "WHERE\n" +
            "dbo.sg_kstl.kstl_id = #{kstlId,jdbcType=VARCHAR}")
    SgKstlToVO selectSgKstl(String kstlId);

    /**
     * 查询科室讨论参加人数
     * @param kstlId 科室谈论id
     * @return List<SEmp>
     */
    @Select("SELECT\n" +
            "dbo.s_emp.user_xm\n" +
            "\n" +
            "FROM\n" +
            "dbo.sg_kstl_user\n" +
            "INNER JOIN dbo.s_emp ON dbo.sg_kstl_user.user_id = dbo.s_emp.user_id\n" +
            "WHERE\n" +
            "dbo.sg_kstl_user.kstl_id = #{kstlId,jdbcType=VARCHAR}")
    List<SEmp> selectSgKstlRy(String kstlId);
}