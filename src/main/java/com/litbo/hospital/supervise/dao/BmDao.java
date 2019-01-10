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
    @Select("select bm_id, bm_name, user_id, bm_tel, bm_addr, wx_flag, p_bm_id,obm_id,xbm_flag from s_bm" +
            " where xbm_flag=1  ")
    List<SBm> getXBmList();

    @Select("select s_bm.bm_id, s_bm.bm_name, s_bm.user_id, s_bm.bm_tel, s_bm.bm_addr, s_bm.wx_flag, s_bm.p_bm_id,s_bm.obm_id,s_bm.xbm_flag \n" +
            "from s_bm  LEFT JOIN s_gcs_bm on (s_bm.bm_id=s_gcs_bm.bm_id)\n" +
            "where wx_flag = 1 and xbm_flag=0  and s_gcs_bm.bm_id is NULL")
    List<SBm> getWxBms();
    @Select("select bm_id, bm_name, user_id, bm_tel, bm_addr, wx_flag, p_bm_id,obm_id,xbm_flag from s_bm" +
            " where wx_flag=0 and xbm_flag=0 ")
    List<SBm> getFwxBms();
    @Select("select bm_id, bm_name, user_id, bm_tel, bm_addr, wx_flag, p_bm_id,obm_id,xbm_flag from s_bm" +
            " where wx_flag=0 and xbm_flag=0 and bm_name like '%'+#{bmName}+'%' ")
    List<SBm> listFWXBmByBmName(String bmName);
    @Select("select bm_id, bm_name, user_id, bm_tel, bm_addr, wx_flag, p_bm_id,obm_id,xbm_flag from s_bm" +
            " where xbm_flag=0")
    List<SBm> getYZBmList();
    @Select("select bm_id, bm_name, user_id, bm_tel, bm_addr, wx_flag, p_bm_id,obm_id,xbm_flag from s_bm" +
            " where xbm_flag=0 and bm_id like '02%' ")
    List<SBm> getGLBmList();
    @Select("select bm_id, bm_name, user_id, bm_tel, bm_addr, wx_flag, p_bm_id,obm_id,xbm_flag from s_bm" +
            " where xbm_flag=0 and wx_flag=1")
    List<SBm> getWxBmList();
    @Select("select bm_id, bm_name, user_id, bm_tel, bm_addr, wx_flag, p_bm_id,obm_id,xbm_flag from s_bm where p_bm_id=#{pid}")
    List<SBm> getBmListByPid(String pid);
    @Select("select bm_id, bm_name, user_id, bm_tel, bm_addr, wx_flag, p_bm_id,obm_id,xbm_flag from s_bm where obm_id=#{id}")
    SBm getBmByOid(String id);
    @Select("select bm_id, bm_name, user_id, bm_tel, bm_addr, wx_flag, p_bm_id,obm_id,xbm_flag from s_bm where bm_id=#{bmid}")
    SBm getBmBybmid(String bmid);
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
    @Update("update s_bm set wx_flag=#{fwFlag} where obm_id=#{obmId}")
    void setWxbm(@Param("obmId")String obmId, @Param("fwFlag")int fwFlag);


}
