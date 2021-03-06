package com.litbo.hospital.user.dao;

import com.litbo.hospital.user.bean.SysGgxz;
import com.litbo.hospital.user.dao.provider.GgxzProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GgxzDao {

    @InsertProvider(type = GgxzProvider.class , method = "addGgxz")
    int addGgxz(SysGgxz ggxz);

    @SelectProvider(type = GgxzProvider.class , method = "listGgxzs")
    List<SysGgxz> listGgxzs();
    @UpdateProvider(type = GgxzProvider.class , method = "ggxzPass")
    int ggxzPass(Integer id);
    @DeleteProvider(type = GgxzProvider.class , method = "ggxzFail")
    int ggxzFail(Integer id);
    @SelectProvider(type = GgxzProvider.class , method = "listWaits")
    List<SysGgxz> listWaits(String wjmc);

    @SelectProvider(type = GgxzProvider.class , method = "getGgxzById")
    SysGgxz getGgxzById(Integer id);
    @Delete("<script>DELETE FROM dbo.sys_ggxz WHERE  id in" +
            "<foreach item='ggxzid' index='index' collection='array' open = '(' separator = ',' close = ')'>" +
            "#{ggxzid}" +
            "</foreach>" +
            "</script>")
    Integer delGgxz(Integer[] ggxzids);
}
