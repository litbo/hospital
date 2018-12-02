package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgKstl;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

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
    /*
    int countByExample(SgKstlExample example);

    int deleteByExample(SgKstlExample example);

    int deleteByPrimaryKey(String kstlId);

    int insert(SgKstlExample record);

    int insertSelective(SgKstlExample record);

    List<SgKstlExample> selectByExampleWithBLOBs(SgKstlExample example);

    List<SgKstl> selectByExample(SgKstlExample example);

    SgKstlExample selectByPrimaryKey(String kstlId);

    int updateByExampleSelective(@Param("record") SgKstlExample record, @Param("example") SgKstlExample example);

    int updateByExampleWithBLOBs(@Param("record") SgKstlExample record, @Param("example") SgKstlExample example);

    int updateByExample(@Param("record") SgKstl record, @Param("example") SgKstlExample example);

    int updateByPrimaryKeySelective(SgKstlExample record);

    int updateByPrimaryKeyWithBLOBs(SgKstlExample record);

    int updateByPrimaryKey(SgKstl record);
     */
}