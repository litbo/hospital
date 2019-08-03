package com.litbo.hospital.operational_data_monitoring.software_interface.dao;

import com.litbo.hospital.operational_data_monitoring.software_interface.bean.HisSflb;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.HisSfxmDict;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.XmVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.dao
 * @Author: looli
 * @CreateTime: 2019-07-26 18:11
 * @Description: todo
 */
public interface HisSfxmDictDAO {
    @Select({"<script>",
            "insert into his_SFXM_DICT (Sf_XmBm, Sf_XmMc, Sf_Unit, \n" +
                    "      Sf_Price, Sf_InPrice, Sf_Wjbm, \n" +
                    "      Sf_Type)\n values" +
                    "<foreach item='sfxm' collection='list' separator=',' > \n" +
                    "     (#{sfxm.sfXmbm,jdbcType=VARCHAR}, #{sfxm.sfXmmc,jdbcType=VARCHAR}, #{sfxm.sfUnit,jdbcType=VARCHAR}, \n" +
                    "      #{sfxm.sfPrice,jdbcType=DECIMAL}, #{sfxm.sfInprice,jdbcType=DECIMAL}, #{sfxm.sfWjbm,jdbcType=VARCHAR}, \n" +
                    "      #{sfxm.sfType,jdbcType=VARCHAR})",
                    "</foreach>",
            "</script>"})
    void saves(List<HisSfxmDict> hisSfxmDictList);

    /**
     * 查询所有医嘱信息
     * @return
     */
    @Select("SELECT Sf_XmBm as SfXmBm,Sf_XmMc as SfXmMc,Sf_Price as SfPrice,Sf_Unit as SfUnit FROM his_SFXM_DICT")
    List<XmVO> selectAll();

    /**
     * 根据医嘱名称模糊查询医嘱信息
     * @param name
     * @return
     */
    @Select({"<script>",
            "SELECT Sf_XmBm as SfXmBm,Sf_XmMc as SfXmMc,Sf_Price as SfPrice,Sf_Unit as SfUnit FROM his_SFXM_DICT " +
            "<where>",
            "<if test='name != null'> AND  Sf_XmMc like '%${name}%' </if>\n" ,
            "</where>",
            "</script>"})
    List<XmVO> selectAllByName(@Param("name") String name);

    /**
     * 删除医嘱信息
     */
    @Delete("delete from his_SFXM_DICT")
    void delete();
}
