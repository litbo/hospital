package com.litbo.hospital.lifemanage.dao.MyMapper;

import com.litbo.hospital.lifemanage.bean.Example.YjyaZdExample;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.YjyaZdVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface YjyaZdVOMapper {
    /*一条应急预案制定*/
    @Insert("insert into yjya_zd (yjya_bh, yjya_name, yjya_lx, \n" +
            "      yjya_zys, yjya_bbh, yjya_ngr, \n" +
            "      yjya_ngrq, yjya_fbbm, yjya_nr, \n" +
            "      yjya_shr, yjya_shrq, yjya_shyj, \n" +
            "      yjya_syts, yjya_zt, yjya_zpjsqr, \n" +
            "      yjya_zpjsqrq, yjya_zpjyy, yjya_zpjsshr, \n" +
            "      yjya_zpjshrq, yjya_zpjjg, yjya_zpjyj\n" +
            "      )\n" +
            "    values (#{yjyaBh,jdbcType=VARCHAR}, #{yjyaName,jdbcType=VARCHAR}, #{yjyaLx,jdbcType=VARCHAR}, \n" +
            "      #{yjyaZys,jdbcType=INTEGER}, #{yjyaBbh,jdbcType=VARCHAR}, #{yjyaNgr,jdbcType=VARCHAR}, \n" +
            "      #{yjyaNgrq,jdbcType=DATE}, #{yjyaFbbm,jdbcType=VARCHAR}, #{yjyaNr,jdbcType=VARCHAR}, \n" +
            "      #{yjyaShr,jdbcType=VARCHAR}, #{yjyaShrq,jdbcType=DATE}, #{yjyaShyj,jdbcType=VARCHAR}, \n" +
            "      #{yjyaSyts,jdbcType=INTEGER}, #{yjyaZt,jdbcType=VARCHAR}, #{yjyaZpjsqr,jdbcType=VARCHAR}, \n" +
            "      #{yjyaZpjsqrq,jdbcType=DATE}, #{yjyaZpjyy,jdbcType=VARCHAR}, #{yjyaZpjsshr,jdbcType=VARCHAR}, \n" +
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
            "      yjya_zpjsshr = #{yjyaZpjsshr,jdbcType=VARCHAR},\n" +
            "      yjya_zpjshrq = #{yjyaZpjshrq,jdbcType=DATE},\n" +
            "      yjya_zpjjg = #{yjyaZpjjg,jdbcType=VARCHAR},\n" +
            "      yjya_zpjyj = #{yjyaZpjyj,jdbcType=VARCHAR}\n" +
            "    where yjya_bh = #{yjyaBh,jdbcType=VARCHAR}")
    int updateYjyaZd(YjyaZdVO vo);

    /*条件查询所有预案*/
    @Select("<script>" +
            " select yjya_bh, yjya_name, yjya_lx, yjya_zys, yjya_bbh, yjya_ngr, yjya_ngrq, yjya_fbbm, \n" +
            "    yjya_nr, yjya_shr, yjya_shrq, yjya_shyj, yjya_syts, yjya_zt, yjya_zpjsqr, yjya_zpjsqrq, \n" +
            "    yjya_zpjyy, yjya_zpjsshr, yjya_zpjshrq, yjya_zpjjg, yjya_zpjyj\n" +
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
            "    </if>"+
            "</script>")
   List<YjyaZdVO> selectYjyaZdByExample(YjyaZdExample example);

}
