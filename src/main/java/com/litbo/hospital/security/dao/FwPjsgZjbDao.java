package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.FwPjsgZjb;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FwPjsgZjbDao {
    @Insert({"<script>",
            "insert into fw_pjsg_zjb(pjzd_id, pjsg_id, " +
                    "      pjsg_count, pjsg_price) values ",
            "<foreach collection='fwPjsgZjbs' item='item' index='index' separator=','>",
            "(#{item.pjzdId,jdbcType=INTEGER}, #{item.pjsgId,jdbcType=INTEGER}, " +
                    " #{item.pjsgCount,jdbcType=INTEGER}, #{item.pisgPrice,jdbcType=DECIMAL})", "</foreach>",
            "</script>"})
    int insertFwPjsgZjbList(@Param("fwPjsgZjbs") List<FwPjsgZjb> fwPjsgZjbs);


    @Select("select * from fw_pjsg_zjb where pjsg_id = #{id}")
    List<FwPjsgZjb> listFwPjsgZjbByPjsgId(int id);

}
