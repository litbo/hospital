package com.litbo.hospital.operational_data_monitoring.software_interface.dao;

import com.litbo.hospital.operational_data_monitoring.software_interface.vo.EqInfoVO;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.SearchEqVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.looli.orcl
 * @Author: looli
 * @CreateTime: 2019-07-21 11:09
 * @Description: todo
 */
@Mapper
public interface EqInfoDAO {
    /**查询所有*/
    @Select("SELECT b.bm_name,a.eq_id,a.eq_sbbh,a.eq_zcbh,a.eq_name,a.eq_pp,a.eq_xh,a.eq_gg,a.eq_qysj FROM eq_info a,s_bm b WHERE a.eq_bmid = b.bm_id")
    List<EqInfoVO> selectAll();

    /**根据条件查询*/
    @Select({"<script>",
            "SELECT b.bm_name,a.eq_id,a.eq_sbbh,a.eq_zcbh,a.eq_name,a.eq_pp,a.eq_xh,a.eq_gg,a.eq_qysj " +
                    "FROM eq_info a LEFT JOIN s_bm b " +
                    "on a.eq_bmid = b.bm_id",
            "<where>",
            "<if test='eqZcbh != null'>","and a.eq_zcbh = #{eqZcbh}","</if>",
            "<if test='bmId != null'>","and a.eq_bmid = #{bmId}","</if>",
            "<if test='eqPym != null'>","and a.eq_pym = #{eqPym}","</if>",
            "</where>",
            "</script>"})
    List<EqInfoVO> selectAllBy(SearchEqVO searchVO);

}
