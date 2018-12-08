package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgGnpz;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 功能配置表Mapper接口
 */
@Mapper
public interface SgGnpzMapper {

    /**
     * 添加功能配置
     *
     * @param sgGnpz 功能配置信息
     * @return 添加的记录数
     */
    @Insert("insert into sg_gnpz (gnpz_id, ckcssb_id, gnpz_mc, \n" +
            "   gnpz_ms, gnpz_issy, extend_one, \n" +
            "   extend_two)\n" +
            "values (#{gnpzId,jdbcType=VARCHAR}, #{ckcssbId,jdbcType=VARCHAR}, #{gnpzMc,jdbcType=VARCHAR}, \n" +
            "   #{gnpzMs,jdbcType=VARCHAR}, #{gnpzIssy,jdbcType=CHAR}, #{extendOne,jdbcType=VARCHAR}, \n" +
            "   #{extendTwo,jdbcType=VARCHAR})")
    int insertSgGnpz(SgGnpz sgGnpz);

    /**
     * 通过参考厂商设备id查询对应的功能配置
     *
     * @param sgCkcssbId 参考厂商设备id
     * @return List<SgGnpz>
     */
    @Select("SELECT\n" +
            "dbo.sg_gnpz.gnpz_id,\n" +
            "dbo.sg_gnpz.ckcssb_id,\n" +
            "dbo.sg_gnpz.gnpz_mc,\n" +
            "dbo.sg_gnpz.gnpz_ms,\n" +
            "dbo.sg_gnpz.gnpz_issy,\n" +
            "dbo.sg_gnpz.extend_one,\n" +
            "dbo.sg_gnpz.extend_two\n" +
            "FROM\n" +
            "dbo.sg_gnpz\n" +
            "WHERE\n" +
            "dbo.sg_gnpz.ckcssb_id = #{sgCkcssbId,jdbcType=VARCHAR}")
    List<SgGnpz> selectSgGnpzBySgCkcssbId(String sgCkcssbId);
}