package com.litbo.hospital.lifemanage.dao.MyMapper;

import com.litbo.hospital.lifemanage.bean.vo.MyVO.YjyaLclogVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface YjyaLclogMapper {

    /*增加一条流程记录*/
    @Insert(" insert into yjya_lclog (yjya_id, yjya_bh, yjya_ngr, \n" +
            "      yjya_ngrq, yjya_shr, yjya_shrq, \n" +
            "      yjya_sykssj, yjya_bakssj, yjya_qykssj, \n" +
            "      yjya_zpjsqr, yjya_zpjsqsj, yjya_zpjshr, \n" +
            "      yjya_zpjshsj)\n" +
            "    values (#{yjyaId,jdbcType=VARCHAR}, #{yjyaBh,jdbcType=VARCHAR}, #{yjyaNgr,jdbcType=VARCHAR}, \n" +
            "      #{yjyaNgrq,jdbcType=DATE}, #{yjyaShr,jdbcType=VARCHAR}, #{yjyaShrq,jdbcType=DATE}, \n" +
            "      #{yjyaSykssj,jdbcType=DATE}, #{yjyaBakssj,jdbcType=DATE}, #{yjyaQykssj,jdbcType=DATE}, \n" +
            "      #{yjyaZpjsqr,jdbcType=VARCHAR}, #{yjyaZpjsqsj,jdbcType=DATE}, #{yjyaZpjshr,jdbcType=VARCHAR}, \n" +
            "      #{yjyaZpjshsj,jdbcType=DATE})")
    int insertYjyaLclog(YjyaLclogVO vo);

    /*查询流程记录中所有的预案编号*/
    @Select("select distinct yjya_bh from yjya_lclog order by yjya_bh")
    List<String> selectAllYaBhlog();

    /*根据预案编号查询此编号的所有记录*/
    @Select("select * from yjya_lclog where yjya_bh=#{bh}")
    List<YjyaLclogVO> selectAllYalogByBh(String bh);


}
