package com.litbo.hospital.operational_data_monitoring.software_interface.mapper;

import com.litbo.hospital.operational_data_monitoring.software_interface.bean.HisDeptDict;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.HisUserDict;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.mapper
 * @Author: looli
 * @CreateTime: 2019-07-26 16:57
 * @Description: 查询员工信息
 */
public interface HisUserDictMapper {

    
    @Select("SELECT\n" +
            "id as userNO,\n" +
            "c_DeptID as deptID,\n" +
            "c_CName as userName,\n" +
            "c_USex as userSex, \n" +
            "c_UAge as userAge,\n" +
            "c_UProf as userProf,\n" +
            "c_UTech as  userTech\n" +
            "FROM\n" +
            "app_fd_employee")
    List<HisUserDict> selectAll();
}
