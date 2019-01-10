package com.litbo.hospital.beneficial.dao;

import com.litbo.hospital.beneficial.dao.provider.CbxySzProvider;
import com.litbo.hospital.beneficial.vo.CbMhVo;
import com.litbo.hospital.beneficial.vo.CbysVo;
import com.litbo.hospital.beneficial.vo.kmListBjVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface CbxySzDao {

    @SelectProvider(type = CbxySzProvider.class , method = "listCbxySz")
    List<CbysVo> listCbxySz();

    @SelectProvider(type = CbxySzProvider.class , method = "listCbxySzByX")
    List<CbysVo> listCbxySzByX(CbMhVo cbMhVo);

    @SelectProvider(type = CbxySzProvider.class , method = "selectCbkmByEqId")
    List<kmListBjVo> selectCbkmByEqId(Integer eqId);

    @SelectProvider(type = CbxySzProvider.class , method = "listSrSz")
    List<CbysVo> listSrSz();

    @SelectProvider(type = CbxySzProvider.class , method = "listSrSzByX")
    List<CbysVo> listSrSzByX(CbMhVo cbMhVo);

    @SelectProvider(type = CbxySzProvider.class , method = "selectSrkmByEqId")
    List<kmListBjVo> selectSrkmByEqId(Integer eqId);
}
