package com.litbo.hospital.user.dao;

import com.litbo.hospital.operational_data_monitoring.software_interface.vo.EqInfoVO;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.SearchEqVO;
import com.litbo.hospital.user.bean.*;
import com.litbo.hospital.user.dao.provider.EqProvider;
import com.litbo.hospital.user.vo.*;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;
@Mapper
public interface EqDao {

    @SelectProvider(type = EqProvider.class , method ="selectAllEq")
    List<EqVo> getAllEq();

    @SelectProvider(type = EqProvider.class , method = "selectShowEq")
    List<EqShowVo> listShowEqs();

    @InsertProvider(type = EqProvider.class , method = "addEq")
    int addEq(EqInfoVo eqInfo);

    /**根据条件查询*/
    @Select({"<script>",
            "SELECT b.bm_name,a.eq_id,a.eq_sbbh,a.eq_zcbh,a.eq_name,a.eq_pp,a.eq_xh,a.eq_gg,a.eq_qysj " +
                    "FROM eq_info a LEFT JOIN s_bm b " +
                    "on a.eq_bmid = b.bm_id",
            "<where>",
            "<if test='eqZcbh != null'>","and a.eq_zcbh = #{eqZcbh}","</if>",
            "<if test='bmId != null'>","and a.eq_bmid = #{bmId}","</if>",
            "<if test='eqPym != null'>","and a.eq_pym = #{eqPym}","</if>",
            "</where>",
            "</script>"})
    List<EqInfoVO> selectAllBy(SearchEqVO searchVO);
    /**根据条件查询*/
    @Select({"<script>",
            "SELECT b.bm_name,a.eq_id,a.eq_sbbh,a.eq_zcbh,a.eq_name,a.eq_pp,a.eq_xh,a.eq_gg,a.eq_qysj \n" +
                    "                    FROM eq_info a LEFT JOIN s_bm b  \n" +
                    "                    on a.eq_bmid = b.bm_id WHERE \n" +
                    "(select count(*) FROM DeviceParameter c WHERE a.eq_sbbh = c.DeviceCode)=0",
            "<if test='eqZcbh != null'>","and a.eq_zcbh = #{eqZcbh}","</if>",
            "<if test='bmId != null'>","and a.eq_bmid = #{bmId}","</if>",
            "<if test='eqPym != null'>","and a.eq_pym = #{eqPym}","</if>",
            "</script>"})
    List<EqInfoVO> selectAllBy2(SearchEqVO searchVO);
    @Select("select top 1 eq_id FROM eq_info  ORDER BY eq_id desc")
    String getLastId();
    @Select("SELECT COUNT(*) FROM eq_info")
    Integer countEq();

    @Select("SELECT COUNT(*) FROM eq_fujian")
    Integer countFj();

    @Select("SELECT * FROM eq_info where eq_id =#{id}")
    EqInfo getEqById(String id);

    @SelectProvider(type = EqProvider.class,method = "getEqById")
    EqInfo getEqWithNameById(String id);

    @Update("UPDATE eq_info SET eq_pm_id =#{eqPmId},eq_sbbh =#{sbbh},eq_syzt=#{eqSyzt} WHERE eq_id =#{eqId}")
    Integer setPm(@Param("eqPmId") String eqPmId,@Param("eqId") String eqId,@Param("sbbh") String sbbh,@Param("eqSyzt")String syzt);
    @UpdateProvider(type = EqProvider.class , method = "updateEq")
    Integer updateEq(EqInfoVo eqInfo);
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
    @Select("SELECT eq_jldw_id FROM eq_jldw WHERE eq_jldw_name =#{eqJldwName}")
    String getJldwId(String eqJldwName);
    @Select("SELECT eq_cxfl_id FROM eq_cxfl WHERE eq_cxfl_name =#{eqCxflName}")
    String getCxflId(String eqCxflName);
    @Select("SELECT zjly_id FROM eq_zjly WHERE zjly_name =#{eqZjlyName}")
    String getZjlyId(String eqZjlyName);
    @Select("select * from eq_pm where eq_pm_id = #{eqPmId}")
    EqPm getPmById(String eqPmId);
    @Select("SELECT top 1  eq_sbbh FROM eq_info WHERE eq_sbbh in (SELECT eq_sbbh FROM eq_info WHERE eq_pm_id = #{eqPmId}) " +
            "ORDER BY eq_sbbh desc")
    String getEqSbbhByPmid(String eqPmId);

    @Select("SELECT sbcs_name FROM eq_cs WHERE sbcs_id =#{sbcsId}")
    String getCsById(String sbcsId);

    @Select("SELECT id,c_CName FROM eq_name ")
    List<EqName> listEqName();
    @SelectProvider(type = EqProvider.class , method = "listEqNameByX")
    List<EqName> listEqNameByX(String ccname);
    @Update("UPDATE eq_info SET eq_bmid = #{bmId} WHERE eq_id = #{eqId}")
    void updateBmId(@Param("eqId") String eqId,@Param("bmId")  String bmId);
    @Update("UPDATE eq_info SET eq_bxkssj = #{eqBxkssj}, eq_bxJssj = #{eqBxkssj} WHERE eq_id = #{eqId}")
    void updateBxTimeById(@Param("eqId") String eqId, @Param("eqBxkssj") Date eqBxkssj, @Param("eqBxJssj") Date eqBxJssj);
}
