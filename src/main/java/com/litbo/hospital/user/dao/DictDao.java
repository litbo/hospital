package com.litbo.hospital.user.dao;

import com.litbo.hospital.security.bean.EqCslb;
import com.litbo.hospital.security.bean.Gb;
import com.litbo.hospital.security.bean.Jg;
import com.litbo.hospital.security.bean.Xllb;
import com.litbo.hospital.user.bean.*;
import com.litbo.hospital.user.dao.provider.DictProvider;
import com.litbo.hospital.user.vo.DictVo;
import com.litbo.hospital.user.vo.SIntVo;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

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
    @Select("SELECT jg_id as dictId ,jg as dictName ,b_name as bName FROM s_jg\n" +
            "union all \n" +
            "SELECT mz_id as dictId , mz as dictName ,b_name as bName FROM s_mz\n" +
            "union all\n" +
            "SELECT xllb_id as dictId , xllb as dictName ,b_name as bName FROM s_xllb\n" +
            "union all\n" +
            "SELECT sex_id as dictId , sex as dictName ,b_name as bName FROM s_sex\n" +
            "union all\n" +
            "SELECT gb_id as dictId , gb as dictName ,b_name as bName FROM s_gb\n" +
            "union all\n" +
            "SELECT zwlb_id as dictId , zwlb as dictName ,b_name as bName FROM s_zwlb\n" +
            "union all\n" +
            "SELECT zzmm_id as dictId , zzmm as dictName ,b_name as bName FROM s_zzmm")
    List<DictVo> listJczd();


    @Select("SELECT eq_cslb_id as dictId ,eq_cslb_name as dictName,b_name FROM eq_cslb\n" +
            "union all\n" +
            "SELECT eq_cxfl_id as dictId ,eq_cxfl_name as dictName ,b_name FROM eq_cxfl\n" +
            "union all\n" +
            "SELECT gzlb_id as dictId ,gzlb_name as dictName ,b_name FROM eq_gzlb\n" +
            "union all\n" +
            "SELECT eq_jldw_id as dictId ,eq_jldw_name as dictName,b_name FROM eq_jldw\n" +
            "union all\n" +
            "SELECT qdfs_id as dictId ,qdfs_name as dictName,b_name FROM eq_qdfs\n" +
            "union all\n" +
            "SELECT zjly_id as dictId ,zjly_name as dictName,b_name FROM eq_zjly\n" +
            "union all\n" +
            "SELECT syxz_id as dictId ,syxz_name as dictName,b_name FROM eq_syxz")
    List<DictVo> listZyzd();
    @Select("select zggwlb_id  ,zggwlb  from s_zggwlb")
    List<Zggwlb> listZggwlb();
    @Select("select *  from s_mz")
    List<Mz> listMz();
    @Select("select *  from s_zc")
    List<Zc> listZc();
    @Select("select *  from s_xllb")
    List<Xllb> listXllb();
    @SelectProvider(type = DictProvider.class ,method = "listDictByTName")
  /*  @Select("Select * FROM ${tName}")*/
    List<DictVo> listDictByTName(@Param("tName") String tName);
    @SelectProvider(type = DictProvider.class ,method = "addDictByTName")
    Integer addDictByTName(@Param("tName") String tName, @Param("dictName") String dictName, @Param("sdictId") String sdictId,@Param("dictId") Integer dictId);
    @SelectProvider(type = DictProvider.class ,method = "getLastIdByTName")
    SIntVo getLastIdByTName(String tName);
    @Select("select *  from eq_cslb")
    List<EqCslb> listEqCslb();
    @Select("select *  from s_gb")
    List<Gb> listGb();
    @Select("select *  from s_jg")
    List<Jg> listJg();
    @DeleteProvider(type = DictProvider.class ,method = "delByTNameAndId")
    Integer delByTNameAndId(DictVo dictVo);
   /* @Select("select * from ${bName} where id = #{id}")*/
    @SelectProvider(type = DictProvider.class ,method = "getByTNameAndId")
    DictVo getByTNameAndId(@Param("bName") String bName,@Param("id") String id);
}
