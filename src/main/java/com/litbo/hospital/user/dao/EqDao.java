package com.litbo.hospital.user.dao;

import com.litbo.hospital.user.bean.EqFj;
import com.litbo.hospital.user.bean.EqInfo;
import com.litbo.hospital.user.bean.EqPm;
import com.litbo.hospital.user.bean.EqSyxz;
import com.litbo.hospital.user.dao.provider.EqProvider;
import com.litbo.hospital.user.vo.EqShowVo;
import com.litbo.hospital.user.vo.EqVo;
import com.litbo.hospital.user.vo.SelectEqVo;
import com.litbo.hospital.user.vo.SelectFlEqVo;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface EqDao {

    @SelectProvider(type = EqProvider.class , method ="selectAllEq")
    List<EqVo> getAllEq();

    @SelectProvider(type = EqProvider.class , method = "selectShowEq")
    List<EqShowVo> listShowEqs();

    @InsertProvider(type = EqProvider.class , method = "addEq")
    int addEq(EqInfo eqInfo);

    @SelectProvider(type = EqProvider.class , method = "selectEqByX")
    List<EqShowVo> listEqByX(SelectEqVo selectEqVo);

    @Select("select top 1 eq_id FROM eq_info  ORDER BY eq_id desc")
    String getLastId();
    @Select("SELECT COUNT(*) FROM eq_info")
    Integer countEq();

    @Select("SELECT COUNT(*) FROM eq_fujian")
    Integer countFj();

    @Select("SELECT * FROM eq_info where eq_id =#{id}")
    EqInfo getEqById(String id);

    @SelectProvider(type = EqProvider.class,method = "getEqById")
    EqVo getEqWithNameById(String id);

    @Update("UPDATE eq_info SET eq_pm_id =#{eqPmId},eq_sbbh =#{sbbh},eq_syzt=#{eqSyzt} WHERE eq_id =#{eqId}")
    Integer setPm(@Param("eqPmId") String eqPmId,@Param("eqId") String eqId,@Param("sbbh") String sbbh,@Param("eqSyzt")String syzt);
    @UpdateProvider(type = EqProvider.class , method = "updateEq")
    Integer updateEq(EqInfo eqInfo);
    @Select("SELECT * FROM eq_pm WHERE len(eq_pm_id)=10")
    List<EqPm> listPms();

    @SelectProvider(type = EqProvider.class , method = "listFlEq")
    List<EqShowVo> listFlEq();
    @SelectProvider(type = EqProvider.class , method = "listWFlEq")
    List<EqShowVo> listWFlEq();
    @Update("UPDATE eq_info SET eq_pm_id = null , eq_sbbh = null WHERE eq_id = #{eqId}")
    Integer cancelFl(String eqId);

    @SelectProvider(type = EqProvider.class  , method = "listPmsByPym")
    List<EqPm> listPmsByPym(@Param("pym") String pym);

    /**
     * 使用性质
     * @return
     */
    @Select("SELECT\n" +
            "dbo.eq_syxz.syxz_id,\n" +
            "dbo.eq_syxz.syxz_name\n" +
            "FROM\n" +
            "dbo.eq_syxz")
    List<EqSyxz> listSyxz();

    @InsertProvider(type = EqProvider.class , method = "saveFj")
    Integer saveFj(EqFj eqFj);
    @SelectProvider(type = EqProvider.class , method = "listFlEqByX")
    List<EqShowVo> listFlEqByX(SelectFlEqVo selectFlEqVo);
    @Delete("delete from eq_info where eq_id =#{eqId}")
    Integer delEq(String eqId);
    @Select("select * from eq_pm")
    List<EqPm> listPmTree();
    @SelectProvider(type = EqProvider.class , method = "listWFlEqByX")
    List<EqShowVo> listWFlEqByX(SelectFlEqVo selectFlEqVo);
    @Select("SELECT bm_id FROM s_bm WHERE bm_name =#{bmName}")
    String getBmIdByName(String bmName);
}
