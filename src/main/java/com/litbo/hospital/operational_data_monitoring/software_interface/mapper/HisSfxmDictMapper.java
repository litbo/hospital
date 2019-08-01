package com.litbo.hospital.operational_data_monitoring.software_interface.mapper;

import com.litbo.hospital.operational_data_monitoring.software_interface.bean.HisSfxmDict;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.mapper
 * @Author: looli
 * @CreateTime: 2019-07-26 17:59
 * @Description: todo
 */
public interface HisSfxmDictMapper {
    /**
     * 查询所有收费项目
     * @return
     */
    @Select("SELECT\n" +
            "c_Xmbm as SfXmbm,\n" +
            "c_Xmmc as SfXmmc,\n" +
            "c_Unit as SfUnit,\n" +
            "c_Price as SfPrice,\n" +
            "c_InPrice as SfInprice,\n" +
            "c_Wjbm as SfWjbm,\n" +
            "c_Type as SfType,\n" +
            "c_Jcbz as  SfXmBz\n" +
            "FROM\n" +
            "app_fd_hissfxmdict")
    List<HisSfxmDict> selectAll();
}
