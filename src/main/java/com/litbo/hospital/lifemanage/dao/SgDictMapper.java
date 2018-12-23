package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgDict;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * SgDictMapper 申购字典Mapper
 *
 * @author Administrator on 2018-12-11
 */
@Mapper
public interface SgDictMapper {

    /**
     * 更新申购字典信息
     *
     * @param sgDict 字典信息
     */
    @Update("UPDATE dbo.sg_dict \n" +
            "SET dbo.sg_dict.lzfx_price = #{lzfxPrice,jdbcType=DECIMAL}, dbo.sg_dict.sg_kstl_ry_sl = #{sgKstlRySl,jdbcType=VARCHAR} \n" +
            "WHERE\n" +
            "\tdbo.sg_dict.sg_dict_id = #{sgDictId,jdbcType=VARCHAR}")
    void updateSgDict(SgDict sgDict);

    /**
     * 查询申购字典信息
     *
     * @return 字典信息
     */
    @Select("SELECT\n" +
            "dbo.sg_dict.sg_dict_id,\n" +
            "dbo.sg_dict.lzfx_price,\n" +
            "dbo.sg_dict.sg_kstl_ry_sl\n" +
            "FROM dbo.sg_dict")
    SgDict selectSgDict();

    /**
     * 添加字典信息
     * @param sgDictId 字典信息
     */
    @Insert("INSERT INTO dbo.sg_dict VALUES(#{sgDictId,jdbcType=VARCHAR},0,0)")
    void insertSgDict(String sgDictId);
}
