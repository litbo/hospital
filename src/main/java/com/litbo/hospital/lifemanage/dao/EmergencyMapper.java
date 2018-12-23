package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.vo.EquipmentStoppedListVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 应急管理Mapper
 *
 * @author Administrator on 2018-12-17
 */
@Mapper
public interface EmergencyMapper {
    /**
     * 查询本科室所有设备
     *
     * @param bmId 部门id
     * @return List<EquipmentStoppedListVO>
     */
    @Select("SELECT\n" +
            "dbo.eq_info.eq_id,\n" +
            "dbo.eq_info.eq_bmid,\n" +
            "dbo.eq_info.eq_sbbh,\n" +
            "dbo.eq_info.eq_name,\n" +
            "dbo.eq_info.eq_gg,\n" +
            "dbo.eq_info.eq_xh\n" +
            "FROM\n" +
            "dbo.eq_info\n" +
            "WHERE\n" +
            "dbo.eq_info.eq_bmid = #{bmId,jdbcType=VARCHAR} AND\n" +
            "dbo.eq_info.eq_sbbh IS NOT NULL AND\n" +
            "dbo.eq_info.eq_zcbh IS NOT NULL")
    List<EquipmentStoppedListVO> selectEmergencyList(String bmId);
}
