package com.litbo.hospital.supervise.dao;

import com.litbo.hospital.supervise.vo.SGcsBmSelect;
import com.litbo.hospital.supervise.vo.SWxbmGcsEqSelect;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WxhfDao {
    @Insert("insert into s_gcs_bm (user_id,bm_id) values(#{wxrId},#{bmId})")
    void saveWxrBm(@Param("wxrId") String wxrId,@Param("bmId") String bmId);
    @Delete("delete from s_gcs_bm where gb_id=#{gbid}")
    void wxrBmXcHf(String gbid);

    @Select("select swge.bg_id,swge.bm_id,bm.bm_name,swge.user_id,emp.user_xm,swge.eq_id,eq.eq_name\n" +
            "from s_wxbm_gcs_eq swge \n" +
            "INNER JOIN s_bm bm ON(swge.bm_id=bm.bm_id) \n" +
            "INNER JOIN s_emp emp on (swge.user_id=emp.user_id) \n" +
            "INNER JOIN eq_info eq ON (swge.eq_id=eq.eq_id)")
//    select * from s_wxbm_gcs_eq swge INNER JOIN s_bm bm ON(swge.bm_id=bm.bm_id) INNER JOIN s_emp emp on (swge.user_id=emp.user_id) INNER JOIN eq_info eq ON (swge.eq_id=eq.eq_id)
    List<SWxbmGcsEqSelect> getWxbmGcsEqMSG();

    @Select(" select sgb.gb_id,sgb.user_id,emp.user_xm,sgb.bm_id,bm.bm_name " +
            " from s_gcs_bm sgb INNER JOIN s_emp emp ON (sgb.user_id=emp.user_id) " +
            " INNER JOIN s_bm bm on (sgb.bm_id=bm.bm_id) ")
    List<SGcsBmSelect> getGcsBmMSG();
    @Insert("insert into s_wxbm_gcs_eq (bm_id,user_id,eq_id) values(#{bmId},#{gcsId},#{eqId})")
    void wxBmGcsEqHf(@Param("bmId") String bmId, @Param("gcsId") String gcsId, @Param("eqId") String eqId);
    @Delete("delete from s_wxbm_gcs_eq where bg_id=#{bgId}")
    void wxBmGcsEqXcHf(String bgId);
}
