package com.litbo.hospital.user.dao;

import com.litbo.hospital.user.vo.DictVo;
import com.litbo.hospital.user.bean.*;
import com.litbo.hospital.user.dao.provider.DictProvider;

import org.apache.ibatis.annotations.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
    @Insert(" insert into eq_zjly (zjly_id, zjly_name)\n" +
            "    values (#{zjlyId,jdbcType=INTEGER}, #{zjlyName,jdbcType=VARCHAR})")
    Integer addEqZjly(EqZjly eqZjly);
    @Select("select eq_jldw_name as dictName,type as dictType FROM eq_jldw")
    List<DictVo> listJldw1();
    @Select("select")
    List<DictVo> listGgs();
    @Select("select * from sys_gglx")
    List<SysGglx> listGglx();
    @Select("SELECT jg_id as dictId ,jg as dictName FROM s_jg\n" +
            "union all \n" +
            "SELECT mz_id as dictId , mz as dictName FROM s_mz\n" +
            "union all\n" +
            "SELECT xllb_id as dictId , xllb as dictName FROM s_xllb\n" +
            "union all\n" +
            "SELECT sex_id as dictId , sex as dictName FROM s_sex\n" +
            "union all\n" +
            "SELECT gb_id as dictId , gb as dictName FROM s_gb\n" +
            "union all\n" +
            "SELECT zwlb_id as dictId , zwlb as dictName FROM s_zwlb\n" +
            "union all\n" +
            "SELECT zzmm_id as dictId , zzmm as dictName FROM s_zzmm")
    List<DictVo> listJczd();
    @SelectProvider(type = DictProvider.class ,method = "listDictByTName")
    List<DictVo> listDictByTName(String tName);
}
