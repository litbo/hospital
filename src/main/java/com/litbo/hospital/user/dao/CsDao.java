package com.litbo.hospital.user.dao;

import com.litbo.hospital.user.bean.EqCs;
import com.litbo.hospital.user.dao.provider.CsProvider;
import com.litbo.hospital.user.vo.GysVo;
import com.litbo.hospital.user.vo.ScsVo;
import com.litbo.hospital.user.vo.WxsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface CsDao {

    @Select("select sbcs_id as sbcs_id_scs,sbcs_name as scsName,sbcs_lxr1,sbcs_lxdh1,email from eq_cs WHERE sb_cslb_id = 1 ")
    List<ScsVo> listScs();
    @Select("select sbcs_id as sbcs_id_wxs,sbcs_name as wxsName,sbcs_lxr1,sbcs_lxdh1,email from eq_cs WHERE sb_cslb_id = 2 ")
    List<WxsVo> listWxs();
    @Select("select sbcs_id as sbcs_id_gys,sbcs_name as gysName,sbcs_lxr1,sbcs_lxdh1,email from eq_cs WHERE sb_cslb_id = 3 ")
    List<GysVo> listGys();
    @Select("select sbcs_id as sbcs_id_scs,sbcs_name as scsName,sbcs_lxr1,sbcs_lxdh1,email from eq_cs WHERE sb_cslb_id = 1 " +
            "AND  sbcs_name like '%'+#{sbcsName}+'%'")
    List<ScsVo> listScsByX(@Param("sbcsName") String sbcsName);
    @Select("select sbcs_id as sbcs_id_scs,sbcs_name as scsName,sbcs_lxr1,sbcs_lxdh1,email from eq_cs WHERE sb_cslb_id = 2 " +
            "AND  sbcs_name like '%'+#{sbcsName}+'%'")
    List<WxsVo> listWxsByX(@Param("sbcsName") String sbcsName);
    @Select("select sbcs_id as sbcs_id_scs,sbcs_name as scsName,sbcs_lxr1,sbcs_lxdh1,email from eq_cs WHERE sb_cslb_id = 3 " +
            "AND  sbcs_name like '%'+#{sbcsName}+'%'")
    List<GysVo> listGysByX(@Param("sbcsName") String sbcsName);
    @Select("select sbcs_id as sbcs_id_scs,sbcs_name as scsName,sbcs_lxr1,sbcs_lxdh1,email from eq_cs WHERE sb_cslb_id = 4 " +
            "AND  sbcs_name like '%'+#{sbcsName}+'%'")
    List<EqCs> listDsfWxsByX(@Param("sbcsName") String sbcsName);

}
