package com.litbo.hospital.user.dao;

import com.litbo.hospital.user.bean.*;
import com.litbo.hospital.user.dao.provider.DictProvider;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface DictDao {
    @Select("select * from eq_zjly")
    List<EqZjly> listZjlys();
    @Select("select * from eq_jldw")
    List<EqJldw> listJldw();
    @Select("select * from eq_cxfl")
    List<EqCxfl> listCxfl();
    @Select("select * from eq_qdfs")
    List<EqQdfs> listQdfs();
    @Select("select * from eq_gzlb")
    List<EqGzlb> listGzlb();
    @SelectProvider(type = DictProvider.class, method = "selectZjlyByX")
    List<EqZjly> listZjlysByX(EqZjly eqZjl);
}
