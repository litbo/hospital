package com.litbo.hospital.operational_data_monitoring.software_interface.dao;

import com.litbo.hospital.operational_data_monitoring.software_interface.bean.EqInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.dao
 * @Author: looli
 * @CreateTime: 2019-07-27 16:50
 * @Description: todo
 */
public interface EqInfoDAO2 {
    /**
     *根据条件查询设备信息
     * @param name
     * @return
     */
    @Select({"<script>",
            "SELECT eq_id as eqId,eq_name as eqName from eq_info",
            "<where>",
            "<if test='name != null'>  eq_name like '%${name}%' </if>\n" +
            "</where>"
            ,"</script>"})
    List<EqInfo> selectAllBy(@Param("name") String name);
}
