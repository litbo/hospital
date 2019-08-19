package com.litbo.hospital.operational_data_monitoring.software_interface.dao;

import com.litbo.hospital.operational_data_monitoring.software_interface.bean.SBm;
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
public interface SBmDAO {
    /**
     * 获取部门id和部门名称
     * @param name
     * @return
     */
    @Select({"<script>",
            "SELECT bm_id as bmId,bm_name as bmName FROM s_bm",
            "<where>",
                "<if test='name != null'>  bm_name like '%${name}%' </if>\n" +
            "</where>",
            "</script>"})
    List<SBm> selectBy(@Param("name") String name);


}
