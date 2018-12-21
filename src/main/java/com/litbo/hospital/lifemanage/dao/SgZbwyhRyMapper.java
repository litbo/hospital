package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgZbwyhRy;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * 参加装备委员会会议人员关联表Mapper接口
 */
@Mapper
public interface SgZbwyhRyMapper {
    /**
     * 添加装备委员会会议人员
     *
     * @param sgZbwyhRy 装备委员会会议人员信息
     * @return 添加的记录数
     */
    @Insert("insert into sg_zbwyh_ry (zbwyhhy_id, user_id)\n" +
            " values (#{zbwyhhyId,jdbcType=VARCHAR}, #{userId,jdbcType=VARCHAR})")
    int insertZbwyhhyRy(SgZbwyhRy sgZbwyhRy);
}