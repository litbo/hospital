package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgZbwyhhy;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * 装备委员会会议信息表Mapper类
 */
@Mapper
public interface SgZbwyhhyMapper {

    /**
     * 添加装备委员会会议信息
     *
     * @param sgZbwyhhy 装备委员会信息
     * @return 更新记录数
     */
    @Insert("insert into sg_zbwyhhy (zbwyhhy_id,sg_id, zbwyhhy_nd, zbwyhhy_chry, \n" +
            "   zbwyhhy_fgld, zbwyhhy_fgldyj, zbwyhhy_sj, \n" +
            "   zbwyhhy_dd, zbwyhhy_zgbm, zbwyhhy_zgbmyj, \n" +
            "   extend_one, extend_two, zbwyhhy_nr\n" +
            "   )\n" +
            " values (#{zbwyhhyId,jdbcType=VARCHAR}, #{sgId,jdbcType=VARCHAR}, #{zbwyhhyNd,jdbcType=VARCHAR}, #{zbwyhhyChry,jdbcType=VARCHAR}, \n" +
            "   #{zbwyhhyFgld,jdbcType=VARCHAR}, #{zbwyhhyFgldyj,jdbcType=VARCHAR}, #{zbwyhhySj,jdbcType=TIMESTAMP}, \n" +
            "   #{zbwyhhyDd,jdbcType=VARCHAR}, #{zbwyhhyZgbm,jdbcType=VARCHAR}, #{zbwyhhyZgbmyj,jdbcType=VARCHAR}, \n" +
            "   #{extendOne,jdbcType=VARCHAR}, #{extendTwo,jdbcType=VARCHAR}, #{zbwyhhyNr,jdbcType=LONGVARCHAR}\n" +
            "   )")
    int insertSgInfoZbwyhhy(SgZbwyhhy sgZbwyhhy);
}