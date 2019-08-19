package com.litbo.hospital.operational_data_monitoring.software_interface.dao;

import com.litbo.hospital.operational_data_monitoring.software_interface.bean.DeparHisSss;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.DepartmentVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.dao
 * @Author: looli
 * @CreateTime: 2019-07-27 10:01
 * @Description: todo
 */
public interface DeparHisSssDAO {

    /**
     * 保存两个系统科室关联记录
     * @param deparHisSss
     */
    @Insert(
            {"<script>",
            "insert into depar_his_sss\n"+
            "    <trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">\n"+
            "      <if test=\"id != null\">\n"+
            "        id,\n"+
            "      </if>\n"+
            "      <if test=\"deptid != null\">\n"+
            "        deptId,\n"+
            "      </if>\n"+
            "      <if test=\"hisDeptid != null\">\n"+
            "        his_deptId,\n"+
            "      </if>\n"+
            "      <if test=\"sssDeptid != null\">\n"+
            "        sss_deptId,\n"+
            "      </if>\n"+
            "    </trim>\n"+
            "    <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">\n"+
            "      <if test=\"id != null\">\n"+
            "        #{id,jdbcType=INTEGER},\n"+
            "      </if>\n"+
            "      <if test=\"deptid != null\">\n"+
            "        #{deptid,jdbcType=VARCHAR},\n"+
            "      </if>\n"+
            "      <if test=\"hisDeptid != null\">\n"+
            "        #{hisDeptid,jdbcType=VARCHAR},\n"+
            "      </if>\n"+
            "      <if test=\"sssDeptid != null\">\n"+
            "        #{sssDeptid,jdbcType=VARCHAR},\n"+
            "      </if>\n"+
            "    </trim>",
                    "</script>"})
    void save(DeparHisSss deparHisSss);

    /**
     * 查看部门匹配情况
     * @return
     */
    @Select("SELECT\n" +
            "b.DeptNo,\n" +
            "b.DeptName,\n" +
            "c.bm_name as bmName \n" +
            "FROM\n" +
            "depar_his_sss a,\n" +
            "his_Dept_DICT b,\n" +
            "s_bm c \n" +
            "WHERE\n" +
            "a.deptId = c.bm_id \n" +
            "AND a.his_deptId = b.DeptNo")
    List<DepartmentVO> select();


    /**
     * 根据条件筛选查看部门匹配情况
     * @return
     */
    @Select(
            {"<script>",
            "SELECT\n" +
            "b.DeptNo,\n" +
            "b.DeptName,\n" +
            "c.bm_name as bmName \n" +
            "FROM\n" +
            "depar_his_sss a,\n" +
            "his_Dept_DICT b,\n" +
            "s_bm c \n" +
            "WHERE\n" +
            "a.deptId = c.bm_id \n" +
            "AND a.his_deptId = b.DeptNo",
            "<if test='name != null'> AND  b.DeptName like '%${name}%' </if>\n" +
            "</script>"})
    List<DepartmentVO> selectByName(@Param("name") String name);

    /**
     * 删除两个系统部门关联信息
     */
    @Delete("delete from depar_his_sss")
    void delete();

    /**
     * 获取手术科室信息
     */
    @Select("SELECT\n" +
            "DeptNo,\n" +
            "DeptName,\n" +
            "bm_name\n" +
            "FROM\n" +
            "his_Dept_DICT \n" +
            "LEFT JOIN depar_his_sss ON his_Dept_DICT.DeptNo = depar_his_sss.his_deptId\n" +
            "LEFT JOIN s_bm ON depar_his_sss.deptId = s_bm.bm_id order by DeptNo")
    List<DepartmentVO> selectAll();

    /**
     * 根据手术室名称查询部门信息
     * @param name
     * @return
     */
    @Select({"<script>",
            "SELECT\n" +
            "DeptNo,\n" +
            "DeptName,\n" +
            "bm_name\n" +
            "FROM\n" +
            "his_Dept_DICT \n" +
            "LEFT JOIN depar_his_sss ON his_Dept_DICT.DeptNo = depar_his_sss.his_deptId\n" +
            "LEFT JOIN s_bm ON depar_his_sss.deptId = s_bm.bm_id",
            "<where>",
            "<if test='name != null'> AND  his_Dept_DICT.DeptName like '%${name}%' </if>\n" +
            "</where>",
            "</script>"
    })
    List<DepartmentVO> selectAllByName(@Param("name") String name);

    /**
     * 删除已经存在的关联
     */
    @Delete("delete from depar_his_sss where his_deptId = #{id}")
    void deleteBy(String id);
}
