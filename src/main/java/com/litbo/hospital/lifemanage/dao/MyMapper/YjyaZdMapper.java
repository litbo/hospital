package com.litbo.hospital.lifemanage.dao.MyMapper;

import com.litbo.hospital.lifemanage.bean.Example.YjyaZdExample;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.YjyaZdVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface YjyaZdMapper {

    /*制定一条应急预案*/
    @Insert("insert into yjya_zd (yjya_bh, yjya_name, yjya_lx, \n" +
            "      yjya_zys, yjya_bbh, yjya_ngr, \n" +
            "      yjya_ngrq, yjya_fbbm, yjya_nr, \n" +
            "      yjya_shr, yjya_shrq, yjya_shyj, \n" +
            "      yjya_syts, yjya_zt, yjya_zpjsqr, \n" +
            "      yjya_zpjsqrq, yjya_zpjyy, yjya_zpjshr, \n" +
            "      yjya_zpjshrq, yjya_zpjjg, yjya_zpjyj\n" +
            "      )\n" +
            "    values (#{yjyaBh,jdbcType=VARCHAR}, #{yjyaName,jdbcType=VARCHAR}, #{yjyaLx,jdbcType=VARCHAR}, \n" +
            "      #{yjyaZys,jdbcType=INTEGER}, #{yjyaBbh,jdbcType=VARCHAR}, #{yjyaNgr,jdbcType=VARCHAR}, \n" +
            "      #{yjyaNgrq,jdbcType=DATE}, #{yjyaFbbm,jdbcType=VARCHAR}, #{yjyaNr,jdbcType=VARCHAR}, \n" +
            "      #{yjyaShr,jdbcType=VARCHAR}, #{yjyaShrq,jdbcType=DATE}, #{yjyaShyj,jdbcType=VARCHAR}, \n" +
            "      #{yjyaSyts,jdbcType=INTEGER}, #{yjyaZt,jdbcType=VARCHAR}, #{yjyaZpjsqr,jdbcType=VARCHAR}, \n" +
            "      #{yjyaZpjsqrq,jdbcType=DATE}, #{yjyaZpjyy,jdbcType=VARCHAR}, #{yjyaZpjshr,jdbcType=VARCHAR}, \n" +
            "      #{yjyaZpjshrq,jdbcType=DATE}, #{yjyaZpjjg,jdbcType=VARCHAR}, #{yjyaZpjyj,jdbcType=VARCHAR}\n" +
            "      )")
    int insertYjyaZd(YjyaZdVO vo);

    /*修改一条应急预案*/
    @Update("update yjya_zd\n" +
            "    set yjya_name = #{yjyaName,jdbcType=VARCHAR},\n" +
            "      yjya_lx = #{yjyaLx,jdbcType=VARCHAR},\n" +
            "      yjya_zys = #{yjyaZys,jdbcType=INTEGER},\n" +
            "      yjya_bbh = #{yjyaBbh,jdbcType=VARCHAR},\n" +
            "      yjya_ngr = #{yjyaNgr,jdbcType=VARCHAR},\n" +
            "      yjya_ngrq = #{yjyaNgrq,jdbcType=DATE},\n" +
            "      yjya_fbbm = #{yjyaFbbm,jdbcType=VARCHAR},\n" +
            "      yjya_nr = #{yjyaNr,jdbcType=VARCHAR},\n" +
            "      yjya_shr = #{yjyaShr,jdbcType=VARCHAR},\n" +
            "      yjya_shrq = #{yjyaShrq,jdbcType=DATE},\n" +
            "      yjya_shyj = #{yjyaShyj,jdbcType=VARCHAR},\n" +
            "      yjya_syts = #{yjyaSyts,jdbcType=INTEGER},\n" +
            "      yjya_zt = #{yjyaZt,jdbcType=VARCHAR},\n" +
            "      yjya_zpjsqr = #{yjyaZpjsqr,jdbcType=VARCHAR},\n" +
            "      yjya_zpjsqrq = #{yjyaZpjsqrq,jdbcType=DATE},\n" +
            "      yjya_zpjyy = #{yjyaZpjyy,jdbcType=VARCHAR},\n" +
            "      yjya_zpjshr = #{yjyaZpjshr,jdbcType=VARCHAR},\n" +
            "      yjya_zpjshrq = #{yjyaZpjshrq,jdbcType=DATE},\n" +
            "      yjya_zpjjg = #{yjyaZpjjg,jdbcType=VARCHAR},\n" +
            "      yjya_zpjyj = #{yjyaZpjyj,jdbcType=VARCHAR},\n" +
            "      yjya_zysdxg = #{yjyaZysdxg},\n" +
            "      yjya_nrdxg = #{yjyaNrdxg,jdbcType=VARCHAR},\n" +
            "      yjya_bbhdxg = #{yjyaBbhdxg,jdbcType=VARCHAR},\n" +
            "      yjya_zpjjd = #{yjyaZpjjd,jdbcType=VARCHAR}\n" +
            "    where yjya_bh = #{yjyaBh,jdbcType=VARCHAR}")
    int updateYjyaZd(YjyaZdVO vo);

    /*条件查询所有预案*/
    @Select("<script>" +
            " select yjya_bh, yjya_name, yjya_lx, yjya_zys, yjya_bbh, yjya_ngr, yjya_ngrq, yjya_fbbm, \n" +
            "    yjya_nr, yjya_shr, yjya_shrq, yjya_shyj, yjya_syts, yjya_zt, yjya_zpjsqr, yjya_zpjsqrq, \n" +
            "    yjya_zpjyy, yjya_zpjshr, yjya_zpjshrq, yjya_zpjjg, yjya_zpjyj,yjya_zysdxg,yjya_nrdxg,yjya_bbhdxg,yjya_zpjjd\n" +
            "   from yjya_zd" +
            " <if test=\"_parameter != null\">" +
            "  <where>\n" +
            "      <foreach collection=\"oredCriteria\" item=\"criteria\" separator=\"or\">\n" +
            "        <if test=\"criteria.valid\">\n" +
            "          <trim prefix=\"(\" prefixOverrides=\"and\" suffix=\")\">\n" +
            "            <foreach collection=\"criteria.criteria\" item=\"criterion\">\n" +
            "              <choose>\n" +
            "                <when test=\"criterion.noValue\">\n" +
            "                  and ${criterion.condition}\n" +
            "                </when>\n" +
            "                <when test=\"criterion.singleValue\">\n" +
            "                  and ${criterion.condition} #{criterion.value}\n" +
            "                </when>\n" +
            "                <when test=\"criterion.betweenValue\">\n" +
            "                  and ${criterion.condition} #{criterion.value} and #{criterion.secondValue}\n" +
            "                </when>\n" +
            "                <when test=\"criterion.listValue\">\n" +
            "                  and ${criterion.condition}\n" +
            "                  <foreach close=\")\" collection=\"criterion.value\" item=\"listItem\" open=\"(\" separator=\",\">\n" +
            "                    #{listItem}\n" +
            "                  </foreach>\n" +
            "                </when>\n" +
            "              </choose>\n" +
            "            </foreach>\n" +
            "          </trim>\n" +
            "        </if>\n" +
            "      </foreach>\n" +
            "    </where>" +
            "    </if>" +
            "</script>")
    List<YjyaZdVO> selectYjyaZdByExample(YjyaZdExample example);


    /*查询一条应急预案*/
    @Select("select * from yjya_zd where yjya_bh = #{bh}")
    YjyaZdVO selectOneYjyaByBh(String bh);

    /*修改预案状态*/
    @Update("update yjya_zd set yjya_zt=#{zt} where yjya_bh=#{bh}")
    int updateYaStatus(@Param("bh") String bh, @Param("zt") String zt);

    /*将审核人，审核意见等信息置空*/
    @Update("update yjya_zd set yjya_zpjshrq = null,yjya_zpjjg = null,yjya_zpjyj=null,yjya_zpjshr = null\n" +
            "where yjya_bh=#{bh} ")
    int ClearShr(String bh);

}
