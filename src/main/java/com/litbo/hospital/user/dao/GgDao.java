package com.litbo.hospital.user.dao;

import com.litbo.hospital.user.bean.SysGglx;
import com.litbo.hospital.user.vo.SysGgVo;
import com.litbo.hospital.user.bean.SysGg;
import com.litbo.hospital.user.dao.provider.GgProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GgDao {
    @InsertProvider(type = GgProvider.class , method = "addGg")
    int addGg(SysGg gg);
    @SelectProvider(type = GgProvider.class , method = "listShowGgs")
    List<SysGgVo> listShowGgs();
    @Update(" UPDATE dbo.sys_gg SET status = 1 WHERE id = #{id}")
    int checkGg(Integer id);
    @Select("SELECT * FROM dbo.sys_gglx")
    List<SysGglx> listShowGglxs();
    @SelectProvider(type = GgProvider.class , method = "getGgByBname")
    List<SysGgVo> getByBname(@Param("bName") String bName);

    @SelectProvider(type = GgProvider.class , method = "listWaits")
    List<SysGgVo> listWaits();

    @Insert("insert into sys_gglx(gglx_id,gglx_name) values(#{gglxId},#{gglxName})")
    Integer addGglb(@Param("gglxName") String gglxName, @Param("gglxId") Integer gglxId);

    @Select("select top 1 gglx_id from sys_gglx order by gglx_id desc" )
    Integer getLastId();
    @Delete({
            "<script>",
            "DELETE FROM dbo.sys_gg WHERE id in",
            "<foreach item = 'item' index = 'index' collection = 'array' open = '(' separator = ',' close = ')'>",
            "#{item}",
            "</foreach>",
            "</script>"
    })
    Integer delGg(Integer [] ids);
    @SelectProvider(type = GgProvider.class , method = "listGgDesc")
    List<SysGgVo> listGgDesc();
}
