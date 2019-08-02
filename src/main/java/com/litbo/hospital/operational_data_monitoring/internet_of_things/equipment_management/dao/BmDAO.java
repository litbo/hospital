package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.dao;

import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.BmVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.looli.orcl
 * @Author: looli
 * @CreateTime: 2019-07-21 11:23
 * @Description: todo
 */
@Mapper
public interface BmDAO {
    @Select("SELECT bm_id,bm_name FROM s_bm")
    List<BmVO> selectAll();
}
