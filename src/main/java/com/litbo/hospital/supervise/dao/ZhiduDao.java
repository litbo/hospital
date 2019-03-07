package com.litbo.hospital.supervise.dao;

import com.litbo.hospital.supervise.bean.SZhidu;
import com.litbo.hospital.supervise.bean.SZhiduzhizeZt;
import com.litbo.hospital.supervise.dao.provider.ZhiDuProvider;
import com.litbo.hospital.supervise.vo.SZhiduSelect;
import com.litbo.hospital.supervise.vo.SZhiduzhizeZtSelect;
import com.litbo.hospital.supervise.vo.ZDSelectAsBaseShMsg;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ZhiduDao {
    @Select("select zd_id, bm_id, zd_name,zd_content, user_id, doc_url, create_time,zd_zt,sy_tianshu,sy_syts ,zd_xgcs from s_zhidu")
    public List<SZhidu> getZds() ;
    @Select("select * from s_zhidu where zd_zt=#{zdZt}")
    List<SZhidu> listZdsByZdZt(String zdZt);

    //通过制度id查询SZhidu
    @Select("select zd_id, bm_id, zd_name,zd_content, user_id, doc_url, create_time,zd_zt,sy_tianshu,sy_syts ,zd_xgcs  " +
            "from s_zhidu where zd_id=#{zdId}")
    public SZhidu getZdByZdId(Integer zdId) ;

    //通过制度id查询szhiduSelect
    @Select("select zd.zd_id, zd.bm_id, zd.zd_name,zd.zd_content, emp.user_xm, zd.doc_url, zd.create_time,zd.zd_zt,zd.sy_tianshu,zd.sy_syts,zd.zd_xgcs\n" +
            "from s_zhidu zd  LEFT JOIN s_emp emp on (zd.user_id=emp.user_id) where zd_id=#{zdId}")
    public SZhiduSelect getZdSelectByZdId(Integer zdId) ;

    //插入制度
    @Insert("insert into s_zhidu ( bm_id, zd_name, \n" +
            "      user_id, doc_url, create_time, \n" +
            "      zd_content,zd_zt,sy_tianshu,sy_syts,zd_xgcs )\n" +
            "    values ( #{bmId,jdbcType=CHAR}, #{zdName,jdbcType=VARCHAR}, \n" +
            "      #{userId,jdbcType=VARCHAR}, #{docUrl,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, \n" +
            "      #{zdContent,jdbcType=LONGVARCHAR},#{zdZt},#{syTianshu},#{sySyts},#{zdXgcs})")
    @Options(useGeneratedKeys=true, keyProperty="zdId", keyColumn="zd_id")
    void saveZd(SZhidu zd);

    @Delete("delete from s_zhidu where zd_id = #{zd_id,jdbcType=INTEGER}")
    void deteleZd(int zd_id);
    @Update("update s_zhidu\n" +
            "    set   bm_id = #{bmId,jdbcType=CHAR},\n" +
            "      zd_name = #{zdName,jdbcType=VARCHAR},\n" +
            "      user_id = #{userId,jdbcType=VARCHAR},\n" +
            "      doc_url = #{docUrl,jdbcType=VARCHAR},\n" +
            "      create_time = #{createTime,jdbcType=TIMESTAMP},\n" +
            "      zd_content = #{zdContent,jdbcType=LONGVARCHAR}," +
            "zd_zt = #{zdZt},sy_tianshu = #{syTianshu},sy_syts = #{sySyts},zd_xgcs=#{zdXgcs}" +
            "  where zd_id=#{zdId}")
    void updateZd(SZhidu zd);
    // 保存制度审核状态
    @Insert("insert into s_zhiduzhize_zt ( zd_id, user_id, \n" +
            "      zt_date, zt_czname, zt_czzt, \n" +
            "      zt_shyj )\n" +
            "    values ( #{zdId}, #{userId}, \n" +
            "      #{ztDate}, #{ztCzname}, #{ztCzzt}, \n" +
            "      #{ztShyj})")
    void saveZdZt(SZhiduzhizeZt ztc);

    //通过审核人获取制度的基本信息   zdid zdname ztcaname
    @Select("select szd.zd_id,szd.zd_name,szt.zt_czname FROM s_zhidu szd LEFT JOIN s_zhiduzhize_zt szt\n" +
            "on (szd.zd_id = szt.zd_id) where szt.user_id=#{shr_id} and szt.zt_czzt=0 ")   // 状态为0（未处理）
    List<ZDSelectAsBaseShMsg> listZdsByShr(String shr_id);

    //通过制度id获取该制度所有已通过的审核审核记录
    @Select("select szt.zt_id, szt.zd_id, emp.user_xm, szt.zt_date, szt.zt_czname, szt.zt_czzt,szt.zt_shyj \n" +
            "from s_zhiduzhize_zt szt LEFT JOIN s_emp emp on (emp.user_id=szt.user_id) where zd_id=#{zdId} and zt_czzt=2")
    List<SZhiduzhizeZtSelect> listZtsByZdId(Integer zdId);

    //通过制度id审核人id和审核状态查询当前审核状态信息
    @Select("select szt.zt_id, szt.zd_id, emp.user_xm, szt.zt_date, szt.zt_czname, szt.zt_czzt,szt.zt_shyj \n" +
            "from s_zhiduzhize_zt szt LEFT JOIN s_emp emp on (emp.user_id=szt.user_id) " +
            "where zd_id=#{zdId} and zt_czzt=0 and szt.user_id=#{shrId}")
    SZhiduzhizeZtSelect getDqShMsg(@Param("zdId")Integer zdId, @Param("shrId")String shrId);

    @Update("update s_zhiduzhize_zt  set   zt_czzt = #{ztCzzt},  zt_date = #{ztDate},  zt_shyj = #{ztShyj}" +
            "  where zt_id=#{ztId}")
    void updateZdzt(SZhiduzhizeZt sZhiduzhizeZt);

    @Update("update s_zhidu  set   zd_zt = #{zdZt},  sy_tianshu = #{syDays}" +
            "  where zd_id=#{zdId}")
    void setZhiDuZt(@Param("zdId")Integer zdId,@Param("zdZt")Integer zdZt ,@Param("syDays")Integer syDays);


    @Select("select * from s_zhiduzhize_zt  where zd_id=#{zdId} order by zt_date desc")
    List<SZhiduzhizeZt> listZdztDescByDate(Integer zdId);
    @Select("select * from s_zhiduzhize_zt  where zd_id=#{zdId} order by zt_id desc")
    List<SZhiduzhizeZt> listZdztDescByZtid(Integer zdId);
    @SelectProvider(type = ZhiDuProvider.class,method = "listZdsByTimeAndZdNameAndZt")
    List<SZhidu> listZdsByTimeAndZdNameAndZt(@Param("startTime") String startTime, @Param("endTime")String endTime, @Param("zdName") String zdName, @Param("zdZt")String zdZt);
    @Select("select * from s_zhidu where zd_id=#{id}")
    SZhidu getZdById(String id);

    void updateZhiduZdzt(Integer zdId, int i);
}
