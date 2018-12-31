package com.litbo.hospital.user.dao;

import com.litbo.hospital.user.bean.EqInfo;
import com.litbo.hospital.user.bean.EqPm;
import com.litbo.hospital.user.dao.provider.EqProvider;
import com.litbo.hospital.user.vo.EqShowVo;
import com.litbo.hospital.user.vo.EqVo;
import com.litbo.hospital.user.vo.SelectEqVo;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Select("SELECT * FROM eq_info where eq_id =#{id}")
    EqInfo getEqById(String id);

    @Update("UPDATE eq_info SET eq_pm_id =#{eqPmId},eq_sbbh =#{sbbh} WHERE eq_id =#{eqId}")
    Integer setPm(@Param("eqPmId") String eqPmId,@Param("eqId") String eqId,@Param("sbbh") String sbbh);
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
}
