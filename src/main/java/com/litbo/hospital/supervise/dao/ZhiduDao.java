package com.litbo.hospital.supervise.dao;

import com.litbo.hospital.supervise.bean.SZhidu;
import com.litbo.hospital.supervise.bean.SZhiduzhizeZt;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ZhiduDao {
    @Select("select zd_id, bm_id, zd_name, user_id, doc_url, create_time,is_beian,sy_tianshu,sy_syts from s_zhidu")
    public List<SZhidu> getZds() ;

    @Insert("insert into s_zhidu ( bm_id, zd_name, \n" +
            "      user_id, doc_url, create_time, \n" +
            "      zd_content,is_beian,sy_tianshu,sy_syts )\n" +
            "    values ( #{bmId,jdbcType=CHAR}, #{zdName,jdbcType=VARCHAR}, \n" +
            "      #{userId,jdbcType=VARCHAR}, #{docUrl,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, \n" +
            "      #{zdContent,jdbcType=LONGVARCHAR},#{isBeian},#{syTianshu},#{sySyts})")
    void saveZd(SZhidu zd);
    @Delete("delete from s_zhidu where zd_id = #{zd_id,jdbcType=INTEGER}")
    void deteleZd(int zd_id);
    @Update("update s_zhidu\n" +
            "    set   bm_id = #{bmId,jdbcType=CHAR},\n" +
            "      zd_name = #{zdName,jdbcType=VARCHAR},\n" +
            "      user_id = #{userId,jdbcType=VARCHAR},\n" +
            "      doc_url = #{docUrl,jdbcType=VARCHAR},\n" +
            "      create_time = #{createTime,jdbcType=TIMESTAMP},\n" +
            "      zd_content = #{zdContent,jdbcType=LONGVARCHAR},is_beian = #{isBeian},sy_tianshu = #{syTianshu},sy_syts = #{sySyts}")
    void updateZd(SZhidu zd);
    @Insert("insert into s_zhiduzhize_zt ( zd_id, user_id, \n" +
            "      zt_date, zt_czname, zt_czzt, \n" +
            "      zt_shyj )\n" +
            "    values ( #{zdId}, #{userId}, \n" +
            "      #{ztDate}, #{ztCzname}, #{ztCzzt}, \n" +
            "      #{zt_shyj})")
    void saveZdZz(SZhiduzhizeZt ztc);
}
