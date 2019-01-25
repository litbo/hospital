package com.litbo.hospital.security.dao;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.bean.FwPjsgZjb;
import com.litbo.hospital.security.vo.FwPjqlZjbVo;
import com.litbo.hospital.security.vo.FwPjsgZjbVo;
import org.apache.ibatis.annotations.*;

import java.util.Date;
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
    //查询所有的入库记录
    @SelectProvider(type=com.litbo.hospital.security.dao.sqlprovider.FwPjsgZjbProvider.class,method="listFwPjsgZjb")
    List<FwPjsgZjbVo> listFwPjsgZjb(@Param("start") Date start, @Param("end") Date end, @Param("pjName") String pjName);
}
