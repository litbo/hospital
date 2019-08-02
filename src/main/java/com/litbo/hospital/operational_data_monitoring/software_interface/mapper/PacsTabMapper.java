package com.litbo.hospital.operational_data_monitoring.software_interface.mapper;

import com.litbo.hospital.operational_data_monitoring.software_interface.bean.HisDeptDict;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.PacsTab;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.mapper
 * @Author: looli
 * @CreateTime: 2019-07-27 12:03
 * @Description: todo
 */
public interface PacsTabMapper {
    @Select("SELECT c_MacID as cMacId,c_MacName as cMacName,c_Type as cType FROM app_fd_pacsmac")
    List<PacsTab> selectAll();
}
