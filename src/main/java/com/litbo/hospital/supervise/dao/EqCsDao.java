package com.litbo.hospital.supervise.dao;

import com.litbo.hospital.security.bean.Cszj;
import com.litbo.hospital.supervise.bean.EqCszjVO;
import com.litbo.hospital.supervise.dao.provider.EqCsProvider;
import com.litbo.hospital.supervise.vo.EqCsSelectVO;
import com.litbo.hospital.supervise.vo.EqCsVO;
import com.litbo.hospital.user.bean.EqCs;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EqCsDao {
    @Select("select * from eq_cs")
    List<EqCs> listEqCs();
    @SelectProvider(type = EqCsProvider.class ,method = "listEqCsVO")
    List<EqCsVO> listEqCsVO(EqCsSelectVO selectVo);
    @SelectProvider(type = EqCsProvider.class ,method = "listEqCszjVOByX")
    List<EqCszjVO> listEqCszjVOByX(EqCsSelectVO selectVo);
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

    @Delete("delete from eq_cs where sbcs_id=#{sbcsId} ")
    void deleteEqCs(String sbcsId);
    @Select("select * from eq_cs where sbcs_id=#{sbcsId}")
    EqCs getEqCsById(String sbcsId);
    @Select("select max(sbcs_id) from eq_cs")
    Integer getMaxEqId();
    @Update("update eq_cs\n" +
            "    set sb_cslb_id = #{sbCslbId,jdbcType=CHAR},\n" +
            "      gb_id = #{gbId,jdbcType=CHAR},\n" +
            "      jg_id = #{jgId,jdbcType=CHAR},\n" +
            "      sbcs_name = #{sbcsName,jdbcType=VARCHAR},\n" +
            "      sbcs_address = #{sbcsAddress,jdbcType=VARCHAR},\n" +
            "      email = #{email,jdbcType=VARCHAR},\n" +
            "      sbcs_lxr1 = #{sbcsLxr1,jdbcType=VARCHAR},\n" +
            "      sbcs_lxr2 = #{sbcsLxr2,jdbcType=VARCHAR},\n" +
            "      sbcs_lxr3 = #{sbcsLxr3,jdbcType=VARCHAR},\n" +
            "      sbcs_lxdh1 = #{sbcsLxdh1,jdbcType=VARCHAR},\n" +
            "      sbcs_lxdh2 = #{sbcsLxdh2,jdbcType=VARCHAR},\n" +
            "      sbcs_lxdh3 = #{sbcsLxdh3,jdbcType=VARCHAR},\n" +
            "      sbcs_fax = #{sbcsFax,jdbcType=VARCHAR},\n" +
            "      sbcs_csdm = #{sbcsCsdm,jdbcType=VARCHAR}\n" +
            "    where sbcs_id = #{sbcsId,jdbcType=INTEGER}")
    void updateEqCs(EqCs eqCs);

    @Insert("insert into eq_cszj ( sbcs_id, cszj_name, \n" +
            "      cszj_bh, cszj_fzdw, cszj_zjlx, \n" +
            "      fz_date, yxq_date, bg_date, \n" +
            "      bg_nr, img_url)\n" +
            "    values (#{sbcsId}, #{cszjName}, #{cszjBh}, #{cszjFzdw}, #{cszjZjlx}," +
            "    #{fzDate}, #{yxqDate}, #{bgDate}, #{bgNr}, #{imgUrl})")
    void insertCszj(Cszj cszj);
    @Delete("delete from eq_cszj where cszj_id=#{cszjID} ")
    void deleteEqCsZj(String cszjID);
    @Select("select  zj.cszj_id,zj.sbcs_id,zj.cszj_name,zj.cszj_bh,zj.cszj_fzdw,zj.cszj_zjlx,zj.fz_date,zj.yxq_date,zj.bg_date,zj.bg_nr,zj.img_url,cs.sbcs_name as sbcsName  from eq_cszj zj LEFT JOIN eq_cs cs on(zj.sbcs_id=cs.sbcs_id) " +
            "   where cszj_id=#{cszjId}")
    EqCszjVO getCszjByCszjId(String cszjId);
    @Update("update eq_cszj\n" +
            "    set sbcs_id = #{sbcsId},cszj_name = #{cszjName}," +
            "   cszj_bh = #{cszjBh},cszj_fzdw = #{cszjFzdw}," +
            "   cszj_zjlx = #{cszjZjlx},fz_date = #{fzDate}," +
            "   bg_date = #{bgDate},bg_nr = #{bgNr}," +
            "   img_url = #{imgUrl},yxq_date = #{yxqDate}" +
            "    where cszj_id = #{cszjId}")
    void upDateCszj(Cszj cszj);
}
