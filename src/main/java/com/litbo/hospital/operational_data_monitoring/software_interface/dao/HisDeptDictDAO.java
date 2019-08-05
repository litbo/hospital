package com.litbo.hospital.operational_data_monitoring.software_interface.dao;

import com.litbo.hospital.operational_data_monitoring.software_interface.bean.HisDeptDict;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.HisSflb;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.dao
 * @Author: looli
 * @CreateTime: 2019-07-26 16:28
 * @Description: todo
 */
public interface HisDeptDictDAO {

    /**
     * 导入科室字典
     * @param HisDeptDictList
     */
    @Insert({"<script>",
            "insert into his_Dept_DICT (DeptNo, DeptName, DeptType)\n" +
            "values " +
            "<foreach item='dept' collection='list' separator=',' >",
            "(#{dept.deptNo,jdbcType=VARCHAR}, #{dept.deptName,jdbcType=VARCHAR}, #{dept.deptType,jdbcType=VARCHAR})",
            "</foreach>",
            "</script>"})
    void saves(List<HisDeptDict> HisDeptDictList);

    /**
     * 删除所有
     */
    @Delete("delete from his_Dept_DICT")
    void delete();

    /**
     * 查询所有科室
     * @return
     */
    @Select("select * from his_Dept_DICT")
    List<HisDeptDict> selectAll();
}
