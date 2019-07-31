package com.litbo.hospital.operational_data_monitoring.software_interface.mapper;

import com.litbo.hospital.operational_data_monitoring.software_interface.bean.HisDeptDict;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.mapper
 * @Author: looli
 * @CreateTime: 2019-07-26 16:21
 * @Description: todo
 */
public interface HisDeptDictMapper {

    @Select("SELECT\n" +
            "id AS deptNo,\n" +
            "c_CName AS deptName,\n" +
            "c_Dflag AS deptType\n" +
            "FROM\n" +
            "app_fd_department")
    List<HisDeptDict> selectAll();
}
