package com.litbo.hospital.operational_data_monitoring.software_interface.dao;

import com.litbo.hospital.operational_data_monitoring.software_interface.bean.PacsTab;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.dao
 * @Author: looli
 * @CreateTime: 2019-07-27 09:22
 * @Description: todo
 */
public interface PacsTabDAO {
    /**
     * 批量保存
     * @param pacsTabList
     */
    @Insert({
            "<script>",
            "insert into pacs_tab (C_MacID, C_MacName,C_Type)\n" +
                    "    values " +
                    "<foreach item='pacs' collection='list' separator=',' > \n" +
                    "(#{pacs.cMacId,jdbcType=VARCHAR}, " +
                    "#{pacs.cMacName,jdbcType=VARCHAR},#{pacs.cType})",
                    "</foreach>",
            "</script>"
    })
    void saves(List<PacsTab> pacsTabList);
}
