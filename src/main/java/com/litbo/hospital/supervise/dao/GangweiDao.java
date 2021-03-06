package com.litbo.hospital.supervise.dao;

import com.litbo.hospital.supervise.bean.SGangwei;
import com.litbo.hospital.supervise.bean.SZhiduzhizeZt;
import com.litbo.hospital.supervise.dao.provider.GwProvider;
import com.litbo.hospital.supervise.vo.GangWeiAndZtVO;
import com.litbo.hospital.supervise.vo.SGangweiSelect;
import com.litbo.hospital.supervise.vo.SZhiduzhizeZtSelect;
import com.litbo.hospital.supervise.vo.ZZSelectAsBaseShMsg;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GangweiDao {
    @Select("select * from s_gangwei")
    List<SGangwei> getGws();
    @Select("select * from s_gangwei where gw_zz_zt=-1 ")
//    @Select("select * from s_gangwei ")
    List<SGangwei> listMZZGws();
    @Select("select * from s_gangwei where gw_zz_zt =#{gwZt}")
    List<GangWeiAndZtVO> listGwsByGwZt(String gwZt);
    @SelectProvider(type = GwProvider.class ,method = "getGwsByGwLevelAndGwName")
    List<SGangwei> getGwsByGwLevelAndGwName(@Param("gwLevel") String gwLevel, @Param("gwName") String gwName);

    @Insert("insert into s_gangwei (gw_name, user_id, \n" +
            "      create_time, doc_url, gw_level, \n" +
            "      gw_zz,gw_zz_zt,zd_xgcs)\n" +
            "    values (#{gwName,jdbcType=VARCHAR}, #{userId,jdbcType=VARCHAR}, \n" +
            "      #{createTime,jdbcType=TIMESTAMP}, #{docUrl,jdbcType=VARCHAR}, #{gwLevel,jdbcType=CHAR}, \n" +
            "      #{gwZz,jdbcType=LONGVARCHAR},#{gwZzZt},#{zdXgcs})")
    void saveGw(SGangwei gw);

    @Delete("delete from s_gangwei where gw_id = #{gw_id}")
    void deleteGwByGwId(String gw_id);
    @Select("select * from s_gangwei where gw_id=#{gw_id}")
    SGangwei getGwsByGwId(String gw_id);
    @Select("select * from s_gangwei where gw_level=#{gw_level}")
    List<SGangwei> getGwByGwLevel(String gw_level);
    @Select("select * from s_gangwei where gw_zz_zt=#{gwZzZt}")
    List<SGangwei> getGwsByGwZzZt(Integer gwZzZt);

    @Update("update s_gangwei\n" +
            "    set gw_name = #{gwName,jdbcType=VARCHAR},\n" +
            "      gw_level = #{gwLevel,jdbcType=CHAR} \n" +
            "    where gw_id = #{gwId,jdbcType=INTEGER}")
    void updateGw(SGangwei gw);

    @Update("update s_gangwei\n" +
            "    set gw_zz = #{gwZz,jdbcType=VARCHAR},\n" +
            "      user_id = #{userId,jdbcType=VARCHAR},\n" +
            "      create_time = #{createTime,jdbcType=TIMESTAMP},\n" +
            "      doc_url = #{docUrl,jdbcType=VARCHAR},\n" +
            "      gw_zz_zt = #{gwZzZt,jdbcType=CHAR},\n" +
            "      sy_tianshu = #{syTianshu,jdbcType=LONGVARCHAR},\n" +
            "      sy_syts = #{sySyts,jdbcType=LONGVARCHAR}\n" +
            "    where gw_id = #{gwId,jdbcType=INTEGER}")
    void insertGwZz(SGangwei gw);

    @Update("update s_gangwei\n" +
            "    set gw_name = #{gwName,jdbcType=VARCHAR},\n" +
            "      gw_level = #{gwLevel,jdbcType=CHAR},\n" +
            "      gw_zz = #{gwZz,jdbcType=VARCHAR},\n" +
            "      user_id = #{userId,jdbcType=VARCHAR},\n" +
            "      create_time = #{createTime,jdbcType=TIMESTAMP},\n" +
            "      doc_url = #{docUrl,jdbcType=VARCHAR},\n" +
            "      gw_zz_zt = #{gwZzZt,jdbcType=CHAR},\n" +
            "      sy_tianshu = #{syTianshu,jdbcType=LONGVARCHAR},\n" +
            "      sy_syts = #{sySyts,jdbcType=LONGVARCHAR},\n" +
            "      zd_xgcs = #{zdXgcs,jdbcType=LONGVARCHAR}\n" +
            "    where gw_id = #{gwId,jdbcType=INTEGER}")
    void updateGwZz(SGangwei gw);

    @Insert("insert into s_zhize_zt ( zz_id, user_id, \n" +
            "      zt_date, zt_czname, zt_czzt, \n" +
            "      zt_shyj )\n" +
            "    values ( #{zdId}, #{userId}, \n" +
            "      #{ztDate}, #{ztCzname}, #{ztCzzt}, \n" +
            "      #{ztShyj})")
    void saveZzZt(SZhiduzhizeZt ztc);
    @Select("select * from s_zhize_zt  where zz_id=#{gwId} order by zt_date desc")
    List<SZhiduzhizeZt> listZzZtDescByDate(Integer gwId);

//    @Select("select gw.gw_id,gw.gw_name,szt.zt_czname " +
//            " FROM s_gangwei gw LEFT JOIN s_zhize_zt szt on (gw.gw_id = szt.zz_id) " +
//            "where  szt.zt_czzt=0 and szt.user_id=#{shr_id} ")   // 状态为0（未处理）
    @SelectProvider(type = GwProvider.class ,method = "listZdsByShr")
    List<ZZSelectAsBaseShMsg> listZdsByShr(@Param("shr_id") String shr_id, @Param("gwZt")String gwZt, @Param("reFlag")String reFlag, @Param("gwName")String gwName);

    @Select("select * from s_gangwei where gw_id=#{gw_id}")
    SGangweiSelect getGwSelectByGwId(Integer gwId);

    @Select("select szt.zt_id, szt.zz_id as zd_id, emp.user_xm, szt.zt_date, szt.zt_czname, szt.zt_czzt,szt.zt_shyj \n" +
            "from s_zhize_zt szt LEFT JOIN s_emp emp on (emp.user_id=szt.user_id) where szt.zz_id = #{gwId} and zt_czzt=2  ")
    List<SZhiduzhizeZtSelect> listZtsByGwId(Integer gwId);

    @Select("select szt.zt_id, szt.zz_id as zd_id, emp.user_xm, szt.zt_date, szt.zt_czname, szt.zt_czzt,szt.zt_shyj \n" +
            "from s_zhize_zt szt LEFT JOIN s_emp emp on (emp.user_id=szt.user_id) \n" +
            "where zt_czzt=0 and szt.user_id=#{shrId} and zz_id = #{gwId}")
    SZhiduzhizeZtSelect getDqShMsg(@Param("gwId") Integer gwId,@Param("shrId") String shrId);

    @Select("select * from s_zhize_zt  where zz_id=#{gwId} order by zt_id desc")
    List<SZhiduzhizeZt> listZdztDescByZzId(Integer gwId);
    @Update("update s_zhize_zt  set   zt_czzt = #{ztCzzt},  zt_date = #{ztDate},  zt_shyj = #{ztShyj}" +
            "  where zt_id=#{ztId}")
    void updateZzzt(SZhiduzhizeZt dqZt);
    @Update("update s_gangwei  set   gw_zz_zt = #{gwZzZt},  sy_tianshu = #{syDays},  sy_syts = #{syDays}" +
            "  where gw_id=#{zzId}")
    void updateGwZt(@Param("zzId") Integer zzId, @Param("gwZzZt")Integer gwZzZt,@Param("syDays") Integer syDays);
    @Update("update s_gangwei  set   gw_zz_zt = #{gwZzZt}, zd_xgcs=#{reFlag}" +
            "  where gw_id=#{zzId}")
    void updateGwZtIncludeReFlag(@Param("zzId") Integer zzId, @Param("gwZzZt")Integer gwZzZt,@Param("reFlag") Integer reFlag);
    @SelectProvider(type = GwProvider.class ,method = "selectGwByX")
    List<ZZSelectAsBaseShMsg> listGwsByShrAndZzZt(@Param("shr_id") String shr_id, @Param("gwZzZt")Integer gwZzZt);

    @Select("select MAX(gw_id) from s_gangwei")
    Integer getMaxId();
    @SelectProvider(type = GwProvider.class,method = "listGwsByTimeAndZdNameAndZt")
    List<GangWeiAndZtVO> listGwsByTimeAndZdNameAndZt(@Param("startTime") String startTime, @Param("endTime")String endTime, @Param("gwName") String gwName, @Param("gwZt")String gwZt,@Param("reFlag")String reFlag);

    @Select("select * from s_zhize_zt where zz_id=#{gwId}")
    List<SZhiduzhizeZt> getShProcesses(Integer gwId);


    /**
     * 每日任务
     * 试用期天数减一
     * 修改试用期天数为0且制度标识为试用期修改标识为备案
     * 修改审核表试用的审核状态
     */
    @Update("update s_gangwei set sy_tianshu=sy_tianshu-1 WHERE gw_zz_zt=2 and sy_tianshu>0 ")
    void scheUpdateSyTs();
    @Select("select * from s_gangwei where gw_zz_zt=2 and sy_tianshu=0")
    List<SGangwei> scheSelectZtDxgZd();
    @Update("update s_gangwei set gw_zz_zt=3 where gw_zz_zt=2 and sy_tianshu=0")
    void scheUpdateZt();
    @Update("update s_zhize_zt set zt_czzt=2 WHERE zt_czname='试用' and zz_id=#{gwId}")
    void scheUpdateZtsh(Integer gwId);
}
