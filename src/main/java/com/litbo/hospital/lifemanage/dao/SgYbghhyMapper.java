package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgYbghhy;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * 院办公会会议信息表Mapper接口
 */
@Mapper
public interface SgYbghhyMapper {
    /**
     * 添加院办公会信息
     * @param sgYbghhy 院办公会信息
     * @return 添加记录数
     */
    @Insert("insert into sg_ybghhy (ybghhy_id, sg_id, ybghhy_sjy, ybghhy_sj, \n" +
            "      ybghhy_dd, extend_one, extend_two, \n" +
            "      ybghhy_chry, ybghhy_nr)\n" +
            "    values (#{ybghhyId,jdbcType=VARCHAR},#{sgId,jdbcType=VARCHAR}, #{ybghhySjy,jdbcType=VARCHAR}, #{ybghhySj,jdbcType=TIMESTAMP}, \n" +
            "      #{ybghhyDd,jdbcType=VARCHAR}, #{extendOne,jdbcType=VARCHAR}, #{extendTwo,jdbcType=VARCHAR}, \n" +
            "      #{ybghhyChry,jdbcType=LONGVARCHAR}, #{ybghhyNr,jdbcType=LONGVARCHAR})")
    int insertSgInfoZbwyhhy(SgYbghhy sgYbghhy);
}