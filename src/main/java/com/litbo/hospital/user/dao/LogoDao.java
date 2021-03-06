package com.litbo.hospital.user.dao;

import com.litbo.hospital.user.bean.SysLogo;
import com.litbo.hospital.user.dao.provider.LogoProvider;
import org.apache.ibatis.annotations.*;
import org.apache.poi.ss.formula.functions.T;

@Mapper
public interface LogoDao {

    @InsertProvider(type =LogoProvider.class , method = "setLogo")
    int setLogo(SysLogo logo);
    @UpdateProvider(type = LogoProvider.class , method = "updateLogo")
    int updateLogo(SysLogo logo);
    @Select("select * from sys_logo")
    SysLogo selectLogo();

}
