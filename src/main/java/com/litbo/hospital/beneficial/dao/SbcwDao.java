package com.litbo.hospital.beneficial.dao;

import com.litbo.hospital.beneficial.dao.provider.CwProvider;
import com.litbo.hospital.beneficial.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.Date;
import java.util.List;

@Mapper
public interface SbcwDao {

    @SelectProvider(type = CwProvider.class , method = "listZjcb")
    List<ZjcbVo> listZjcb(@Param("qssj") Date qssj, @Param("jssj")Date jssj,@Param("bmName") String bmName,@Param("eqName") String eqName);

    @SelectProvider(type = CwProvider.class , method = "listZjcbByX")
    List<ZjcbVo> listZjcbByX(CbMhVo cbMhVo);

    @SelectProvider(type = CwProvider.class , method = "listJjcb")
    List<JjcbVo> listJjcb(@Param("qssj") Date qssj,@Param("jssj") Date jssj,@Param("bmName") String bmName,@Param("eqName") String eqName);

    @SelectProvider(type = CwProvider.class , method = "listJjcbByX")
    List<JjcbVo> listJjcbByX(CbMhVo cbMhVo);

    @SelectProvider(type = CwProvider.class , method = "listSr")
    List<SrVo> listSr(@Param("qssj") Date qssj,@Param("jssj") Date jssj,@Param("bmName") String bmName,@Param("eqName") String eqName);

    @SelectProvider(type = CwProvider.class , method = "listSrByX")
    List<SrVo> listSrByX(CbMhVo cbMhVo);

    @SelectProvider(type = CwProvider.class , method = "listXyFx")
    List<XyFxVo> listXyFx(@Param("qssj") Date qssj,@Param("jssj") Date jssj,@Param("bmName") String bmName,@Param("eqName") String eqName);

    @SelectProvider(type = CwProvider.class , method = "listXyFxByX")
    List<XyFxVo> listXyFxByX(CbMhVo cbMhVo);

    @SelectProvider(type = CwProvider.class , method = "listXyPj")
    List<XyPjVo> listXyPj(@Param("qssj") Date qssj,@Param("jssj") Date jssj,@Param("bmName") String bmName,@Param("eqName") String eqName);

    @SelectProvider(type = CwProvider.class , method = "listXyPjByX")
    List<XyPjVo> listXyPjByX(CbMhVo cbMhVo);


}
