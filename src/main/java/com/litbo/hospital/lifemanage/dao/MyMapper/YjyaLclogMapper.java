package com.litbo.hospital.lifemanage.dao.MyMapper;

import com.litbo.hospital.lifemanage.bean.vo.MyVO.YjyaLclogVO;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface YjyaLclogMapper {

    /*增加一条流程记录*/
    @Insert(" insert into yjya_lclog (yjya_bh, yjya_ngr, \n" +
            "      yjya_ngrq, yjya_shr, yjya_shrq, \n" +
            "      yjya_sykssj, yjya_bakssj, yjya_qykssj, \n" +
            "      yjya_zpjsqr, yjya_zpjsqrq, yjya_zpjshr, \n" +
            "      yjya_zpjshrq)\n" +
            "      values (#{yjyaBh,jdbcType=VARCHAR}, #{yjyaNgr,jdbcType=VARCHAR}, \n" +
            "      #{yjyaNgrq,jdbcType=DATE}, #{yjyaShr,jdbcType=VARCHAR}, #{yjyaShrq,jdbcType=DATE}, \n" +
            "      #{yjyaSykssj,jdbcType=DATE}, #{yjyaBakssj,jdbcType=DATE}, #{yjyaQykssj,jdbcType=DATE}, \n" +
            "      #{yjyaZpjsqr,jdbcType=VARCHAR}, #{yjyaZpjsqrq,jdbcType=DATE}, #{yjyaZpjshr,jdbcType=VARCHAR}, \n" +
            "      #{yjyaZpjshrq,jdbcType=DATE})")
    int insertYjyaLclog(YjyaLclogVO vo);

    /*查询流程记录中所有的预案编号*/
    @Select("select distinct yjya_bh from yjya_lclog order by yjya_bh")
    List<String> selectAllYaBhlog();

    /*根据预案编号查询此记录*/
    @Select("select l.yjya_bh, l.yjya_ngr, l.yjya_ngrq, l.yjya_shr, " +
            " l.yjya_shrq, l.yjya_sykssj, l.yjya_bakssj, \n" +
            "    l.yjya_qykssj, l.yjya_zpjsqr, l.yjya_zpjsqrq, l.yjya_zpjshr, l.yjya_zpjshrq," +
            "  y.yjya_shyj,y.yjya_name,y.yjya_nr,y.yjya_zpjyj,y.yjya_zpjjg,y.yjya_zpjyy,y.yjya_zt" +
            "  from yjya_lclog l " +
            "  inner join yjya_zd y on l.yjya_bh=y.yjya_bh" +
            " where l.yjya_bh=#{bh}")
    YjyaLclogVO selectYalogByBh(String bh);

    /*查询或条件查询所有记录*/
    @Select("<script>" +
            " select l.yjya_bh, l.yjya_ngr, l.yjya_ngrq, l.yjya_shr, " +
            " l.yjya_shrq, l.yjya_sykssj, l.yjya_bakssj, \n" +
            "    l.yjya_qykssj, l.yjya_zpjsqr, l.yjya_zpjsqrq, l.yjya_zpjshr, l.yjya_zpjshrq," +
            "  y.yjya_shyj,y.yjya_name,y.yjya_zpjyj,y.yjya_zpjjg,y.yjya_zpjyy,y.yjya_zt,y.yjya_zpjjd\n" +
            "  from yjya_lclog l " +
            "  inner join yjya_zd y on l.yjya_bh=y.yjya_bh\n" +
            "<where>" +
            " <if test=\"zt != null\">\n" +
            " y.yjya_zt = #{zt}" +
            "</if>" +
            " <if test=\"qssj != null\">\n" +
            " and l.yjya_shrq &gt;= #{qssj,jdbcType=DATE} " +
            "</if>" +
            " <if test=\"jssj != null\">\n" +
            " and l.yjya_shrq &lt;=#{jssj,jdbcType=DATE} " +
            "</if>" +
            " <if test=\"yabh != null\">\n" +
            " and l.yjya_bh like CONCAT('%',#{yabh},'%') " +
            "</if>" +
            " <if test=\"yaname != null\">\n" +
            " and y.yjya_name like CONCAT('%',#{yaname},'%')" +
            "</if>" +
            "</where>" +
            "</script>")

    List<YjyaLclogVO> selectAllYalogByExample(@Param("zt") String zt, @Param("qssj") Date qssj,
                                              @Param("jssj") Date jssj, @Param("yabh") String yabh, @Param("yaname") String yaname);

/*流程记录修改*/
    @Update("  update yjya_lclog\n" +
            "    set " +
            "      yjya_ngr = #{yjyaNgr,jdbcType=VARCHAR},\n" +
            "      yjya_ngrq = #{yjyaNgrq,jdbcType=DATE},\n" +
            "      yjya_shr = #{yjyaShr,jdbcType=VARCHAR},\n" +
            "      yjya_shrq = #{yjyaShrq,jdbcType=DATE},\n" +
            "      yjya_sykssj = #{yjyaSykssj,jdbcType=DATE},\n" +
            "      yjya_bakssj = #{yjyaBakssj,jdbcType=DATE},\n" +
            "      yjya_qykssj = #{yjyaQykssj,jdbcType=DATE},\n" +
            "      yjya_zpjsqr = #{yjyaZpjsqr,jdbcType=VARCHAR},\n" +
            "      yjya_zpjsqrq = #{yjyaZpjsqrq,jdbcType=DATE},\n" +
            "      yjya_zpjshr = #{yjyaZpjshr,jdbcType=VARCHAR},\n" +
            "      yjya_zpjshrq = #{yjyaZpjshrq,jdbcType=DATE}\n" +
            "    where yjya_bh = #{yjyaBh,jdbcType=VARCHAR}")
    int updateYalog(YjyaLclogVO vo);
}
