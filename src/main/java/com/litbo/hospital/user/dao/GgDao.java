package com.litbo.hospital.user.dao;

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
    @UpdateProvider(type = GgProvider.class , method = "checkGg")
    int checkGg(Integer id);

    @SelectProvider(type = GgProvider.class , method = "getGgById")
    SysGgVo getGgById(Integer id);

    @SelectProvider(type = GgProvider.class , method = "listWaits")
    List<SysGgVo> listWaits();
    @Insert("insert into sys_gglx(gglx_id,gglx_name) values(#{gglxId},#{gglxName})")
    Integer addGglb(@Param("gglxName") String gglxName, @Param("gglxId") Integer gglxId);
    @Select("select top 1 gglx_id from sys_gglx order by gglx_id desc" )
    Integer getLastId();
}
