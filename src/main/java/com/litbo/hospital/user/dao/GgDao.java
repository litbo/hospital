package com.litbo.hospital.user.dao;

import com.litbo.hospital.user.vo.SysGgVo;
import com.litbo.hospital.user.bean.SysGg;
import com.litbo.hospital.user.dao.provider.GgProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

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
}
