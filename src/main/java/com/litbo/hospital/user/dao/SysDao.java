package com.litbo.hospital.user.dao;

import com.litbo.hospital.user.bean.SysDxm;
import com.litbo.hospital.user.bean.SysWjbb;
import com.litbo.hospital.user.bean.SysZxsj;
import com.litbo.hospital.user.dao.provider.SysProvider;
import org.apache.ibatis.annotations.*;

import java.sql.Time;

@Mapper
public interface SysDao {

    @SelectProvider(type = SysProvider.class , method = "count")
    int count(String bname);
    @UpdateProvider(type = SysProvider.class , method = "updateWjbb")
    int updateWjbb(SysWjbb wjbb);
    @InsertProvider(type = SysProvider.class , method = "addWjbb")
    int addWjbb(SysWjbb wjbb);
    @UpdateProvider(type = SysProvider.class , method = "updateDxm")
    int updateDxm(SysDxm dxm);
    @InsertProvider(type = SysProvider.class , method = "addDxm")
    int addDxm(SysDxm dxm);
    @UpdateProvider(type = SysProvider.class , method = "updateZxsj")
    int updateZxsj(@Param("amSbsj") Time amSbsj,@Param("amXbsj")  Time amXbsj,@Param("pmSbsj")  Time pmSbsj, @Param("pmXbsj") Time pmXbsj);
    @InsertProvider(type = SysProvider.class , method = "addZxsj")
    int addZxsj(@Param("amSbsj") Time amSbsj,@Param("amXbsj")  Time amXbsj,@Param("pmSbsj")  Time pmSbsj, @Param("pmXbsj") Time pmXbsj);
    @Select("select * from sys_dxm")
    SysDxm getDxm();
    @Select("select * from sys_wjbb")
    SysWjbb getWjbb();
}
