package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgLssq;
import com.litbo.hospital.lifemanage.dao.provider.SgLssqSqlProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * 临时采购授权表Mapper接口
 */
@Mapper
public interface SgLssqMapper {
    /**
     * 添加临时授权信息
     *
     * @param sgLssq 临时授权信息
     */
    @Insert("insert into sg_lssq (lssq_id, lssq_sqr, lssq_bsqks, \n" +
            "      lssq_sqrq, lssq_ksrq, lssq_jsrq, \n" +
            "      extend_one, extend_two)\n" +
            "    values (#{lssqId,jdbcType=VARCHAR}, #{lssqSqr,jdbcType=VARCHAR}, #{lssqBsqks,jdbcType=VARCHAR}, \n" +
            "      #{lssqSqrq,jdbcType=TIMESTAMP}, #{lssqKsrq,jdbcType=TIMESTAMP}, #{lssqJsrq,jdbcType=TIMESTAMP}, \n" +
            "      #{extendOne,jdbcType=VARCHAR}, #{extendTwo,jdbcType=VARCHAR})")
    void insertSgLssq(SgLssq sgLssq);

    /**
     * 查询临时授权信息
     *
     * @param ksId  科室id
     * @param isKsg 是否过期
     */
    @SelectProvider(type = SgLssqSqlProvider.class, method = "selectSgLssq")
    List<SgLssq> selectSgLssq(@Param("ksId") String ksId,@Param("isKsg") String isKsg);
}