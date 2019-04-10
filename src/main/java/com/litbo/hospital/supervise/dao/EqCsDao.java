package com.litbo.hospital.supervise.dao;

import com.litbo.hospital.supervise.dao.provider.EqCsProvider;
import com.litbo.hospital.supervise.vo.EqCsSelectVO;
import com.litbo.hospital.supervise.vo.EqCsVO;
import com.litbo.hospital.user.bean.EqCs;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface EqCsDao {
    @Select("select * from eq_cs")
    List<EqCs> listEqCs();
    @SelectProvider(type = EqCsProvider.class ,method = "listEqCsVO")
    List<EqCsVO> listEqCsVO(EqCsSelectVO selectVo);
    @Insert("insert into eq_cs (sbcs_id, sb_cslb_id, gb_id, \n" +
            "      jg_id, sbcs_name, sbcs_address, \n" +
            "      email, sbcs_lxr1, sbcs_lxr2, \n" +
            "      sbcs_lxr3, sbcs_lxdh1, sbcs_lxdh2, \n" +
            "      sbcs_lxdh3, sbcs_fax,sbcs_csdm)\n" +
            "    values (#{sbcsId,jdbcType=INTEGER}, #{sbCslbId,jdbcType=CHAR}, #{gbId,jdbcType=CHAR}, \n" +
            "      #{jgId,jdbcType=CHAR}, #{sbcsName,jdbcType=VARCHAR}, #{sbcsAddress,jdbcType=VARCHAR}, \n" +
            "      #{email,jdbcType=VARCHAR}, #{sbcsLxr1,jdbcType=VARCHAR}, #{sbcsLxr2,jdbcType=VARCHAR}, \n" +
            "      #{sbcsLxr3,jdbcType=VARCHAR}, #{sbcsLxdh1,jdbcType=VARCHAR}, #{sbcsLxdh2,jdbcType=VARCHAR}, \n" +
            "      #{sbcsLxdh3,jdbcType=VARCHAR}, #{sbcsFax,jdbcType=VARCHAR},#{sbcsCsdm,jdbcType=VARCHAR})")
    void insertEqCs(EqCs eqCs);

    @SelectProvider(type = EqCsProvider.class ,method = "selectEqCsByX")
    List<EqCs> listEqcsByX(EqCsSelectVO selectVo);
    @Select("select sbcs_id as sbcs_id1,sbcs_name,sbcs_lxr1,sbcs_lxdh1,email from eq_cs")
    List<EqCsVO> listEqCs1();
    @SelectProvider(type = EqCsProvider.class ,method = "selectEqCsByX1")
    List<EqCsVO> listEqcsByX1(EqCsSelectVO selectVo);


}
