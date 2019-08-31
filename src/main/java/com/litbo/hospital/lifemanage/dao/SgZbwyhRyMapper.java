package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgZbwyhRy;
import com.litbo.hospital.supervise.bean.SEmp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    /**
     * 查询装备委员会人员姓名
     * @param zbwyhhyId 装备委员会id
     * @return List<SEmp>
     */
    @Select("SELECT\n" +
            "dbo.s_emp.user_xm\n" +
            "FROM\n" +
            "dbo.sg_zbwyh_ry\n" +
            "INNER JOIN dbo.s_emp ON dbo.sg_zbwyh_ry.user_id = dbo.s_emp.user_id\n" +
            "WHERE\n" +
            "dbo.sg_zbwyh_ry.zbwyhhy_id = #{zbwyhhyId,jdbcType=VARCHAR}")
    List<SEmp> selectZbwyhhyRyByZbwyhId(String zbwyhhyId);
}