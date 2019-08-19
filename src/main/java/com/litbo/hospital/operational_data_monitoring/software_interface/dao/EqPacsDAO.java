package com.litbo.hospital.operational_data_monitoring.software_interface.dao;

import com.litbo.hospital.operational_data_monitoring.software_interface.bean.EqPacs;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.EqPacsVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.dao
 * @Author: looli
 * @CreateTime: 2019-08-01 12:14
 * @Description: todo
 */
public interface EqPacsDAO {

    /**
     * 删除设备与pacs关联信息
     */
    @Delete("delete from eq_pacs")
    void delete();

    /**
     * 删除已经存在的关联
     */
    @Delete("delete from eq_pacs where pacs_id = #{pacsId}")
    void deleteOne(String pacsId);
    @Delete("delete from eq_pacs where eq_id = #{eqId}")
    void deleteOne2(String eqId);
    /**
     * 保存pacs设备和设备的对应关系
     * @param eqPacs
     */
    @Insert("insert into eq_pacs ( eq_id, pacs_id\n" +
            "      )\n" +
            "    values (#{eqId,jdbcType=VARCHAR}, #{pacsId,jdbcType=VARCHAR}\n" +
            "      )")
    void save(EqPacs eqPacs);

    @Select({"<script>",
            "SELECT\n" +
                    "pacs_tab.C_MacID AS pacsId,\n" +
                    "pacs_tab.C_MacName AS pacsName,\n" +
                    "eq_info.eq_sbbh AS eqSbbh \n" +
                    "FROM\n" +
                    "pacs_tab\n" +
                    "LEFT JOIN eq_pacs ON eq_pacs.pacs_id = pacs_tab.C_MacID\n" +
                    "LEFT JOIN eq_info ON eq_pacs.eq_id = eq_info.eq_id ",
            "<where>",
            "<if test='pacsId != null'> AND  pacs_tab.C_MacID = #{pacsId} </if>\n",
            "</where>"
    ,"</script>"})
    List<EqPacsVO> selectAll(@Param("pacsId") String pacsId);

    /**
     * 查看设备是否已经存在关联
     * @param eqid
     * @return
     */
    @Select("select count(*) from eq_pacs where eq_id = #{eqid}")
    int selectOne(@Param("eqid") String eqid);
}
