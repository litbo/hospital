package com.litbo.hospital.supervise.dao;

import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.dao.provider.BmProvider;
import com.litbo.hospital.supervise.vo.BmSelectVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BmDao {

    @Select("select bm_id, bm_name, user_id, bm_tel, bm_addr, wx_flag, p_bm_id,obm_id,xbm_flag from s_bm")
    List<SBm> getBmList();
    @Select("select bm_id, bm_name, user_id, bm_tel, bm_addr, wx_flag, p_bm_id,obm_id,xbm_flag from s_bm where p_bm_id=#{pid}")
    List<SBm> getBmListByPid(String pid);
    @Select("select bm_id, bm_name, user_id, bm_tel, bm_addr, wx_flag, p_bm_id,obm_id,xbm_flag from s_bm where obm_id=#{id}")
    SBm getBmByOid(String id);
    @Insert("insert into s_bm (bm_id, bm_name, user_id, \n" +
            "      bm_tel, bm_addr, wx_flag, \n" +
            "      p_bm_id)\n" +
            "    values (#{bmId,jdbcType=CHAR}, #{bmName,jdbcType=VARCHAR}, #{userId,jdbcType=VARCHAR}, \n" +
            "      #{bmTel,jdbcType=VARCHAR}, #{bmAddr,jdbcType=VARCHAR}, #{wxFlag,jdbcType=CHAR}, \n" +
            "      #{pBmId,jdbcType=CHAR})")
    void saveBm(SBm bm);

    @SelectProvider(type = BmProvider.class ,method = "selectBmByX")
    List<SBm> getBmListByX(BmSelectVO selectVo);

    @Delete("delete from s_bm where obm_id = #{oid}")
    void removeBmByOid(String oid);

    @Select("select count(*) from s_bm where p_bm_id=#{obm_id}")
    Integer getAmountByPid(String obm_id);

    @Update("update s_bm set bm_id=#{bm_id},p_bm_id=#{pbm_id} where obm_id=#{obmid}")
    void setBmBeto(@Param("obmid") String obmid,@Param("bm_id") String bm_id, @Param("pbm_id") String pbm_id);

    @Update("update s_bm set bm_id=#{bmId} where obm_id=#{obmId}")
    void setBmIdByOid(@Param("obmId") String obmId,@Param("bmId") String bmId);
}
