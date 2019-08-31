package com.litbo.hospital.lifemanage.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 科室讨论会议人员关联表Mapper接口
 */
@Mapper
public interface SgKstlUserMapper {
    /**
     * 添加科室讨论人员信息批量添加
     *
     * @param kstlId  科室讨论的ID
     * @param usersId 参加讨论的人员
     * @return 插入条数
     */
    @Insert({
            "insert into sg_kstl_user (kstl_id, user_id)",
            "values (#{kstlId,jdbcType=VARCHAR}, #{userId,jdbcType=VARCHAR})"
    })
    int insertSgKstlUser(@Param("kstlId") String kstlId, @Param("userId") String usersId);
}