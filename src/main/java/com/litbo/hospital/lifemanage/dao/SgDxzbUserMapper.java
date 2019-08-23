package com.litbo.hospital.lifemanage.dao;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 大型医学装备考察报告考察人员表Mapper接口
 */
@Mapper
public interface SgDxzbUserMapper {
    /**
     * 添加大型医学装备考察报告考察人员
     * @param dxzbId 大型医学装备考察报告id
     * @param userId 考察人员id
     * @return
     */
    @Insert("    insert into sg_dxzb_user (dxzb_id, user_id)\n" +
            "    values (#{dxzbId,jdbcType=VARCHAR}, #{userId,jdbcType=VARCHAR})")
    int insertSgDxzbUser(@Param("dxzbId") String dxzbId, @Param("userId") String userId);

    /**
     * 根据大型医学装备考察报告id删除考察人员
     * @param sgDxyxzbkcId 大型医学装备考察报告id
     * @return 删除数据条数
     */
    @Delete("delete from sg_dxzb_user where dxzb_id = #{sgDxyxzbkcId,jdbcType=VARCHAR}")
    int deleteSgDxzbUserByDxyxzbkcId(String sgDxyxzbkcId);

    /**
     * 根据大型医学装备考察报告id查询考察人员列表
     * @param dxzbId 大型医学装备考察报告id
     * @return 考察人员列表
     */
    @Select("select user_id from sg_dxzb_user where dxzb_id = #{dxzbId,jdbcType=VARCHAR}")
    List<String> selectSgDxzbUserBySgDxyxzbkcId(String dxzbId);
}