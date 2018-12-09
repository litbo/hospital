package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgZrpjbg;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 准入评价报告表Mapper类
 */
@Mapper
public interface SgZrpjbgMapper {

    /**
     * 添加准入评价报告信息
     *
     * @param sgZrpjbg 准入评价报告
     */
    @Insert("insert into sg_zrpjbg (pjbg_id, pjbg_dw, pjbg_zbxm, \n" +
            "      pjbg_bmfzr, pjbg_zbdw, pjbg_rq, \n" +
            "      extend_one, extend_two)\n" +
            "values (#{pjbgId,jdbcType=VARCHAR}, #{pjbgDw,jdbcType=VARCHAR}, #{pjbgZbxm,jdbcType=VARCHAR}, \n" +
            "      #{pjbgBmfzr,jdbcType=VARCHAR}, #{pjbgZbdw,jdbcType=VARCHAR}, #{pjbgRq,jdbcType=TIMESTAMP}, \n" +
            "      #{extendOne,jdbcType=VARCHAR}, #{extendTwo,jdbcType=VARCHAR})")
    int insertSgZrpjbg(SgZrpjbg sgZrpjbg);

    List<SgZrpjbg> selectSgZrpjbgBy();

}