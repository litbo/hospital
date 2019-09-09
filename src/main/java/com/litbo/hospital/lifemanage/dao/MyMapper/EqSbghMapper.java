package com.litbo.hospital.lifemanage.dao.MyMapper;

import com.litbo.hospital.lifemanage.bean.Example.EqSbghExample;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqSbghShowVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqSbghVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqSbghZbVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EqSbghMapper {

    /*设备归还增加*/
    @Insert(" insert into eq_sbgh (id, eq_zbbm, eq_count, \n" +
            "      eq_ghrq, eq_zbjc, eq_ghks, \n" +
            "      eq_jsks, eq_ghjbr, eq_jsjbr, \n" +
            "      eq_dpjjid, eq_ghlx,eq_drurl,eq_dcurl)\n" +
            "      values (#{id,jdbcType=VARCHAR}, #{eqZbbm,jdbcType=VARCHAR}, #{eqCount,jdbcType=INTEGER}, \n" +
            "      #{eqGhrq,jdbcType=DATE}, #{eqZbjc,jdbcType=VARCHAR}, #{eqGhks,jdbcType=VARCHAR}, \n" +
            "      #{eqJsks,jdbcType=VARCHAR}, #{eqGhjbr,jdbcType=VARCHAR}, #{eqJsjbr,jdbcType=VARCHAR}, \n" +
            "      #{eqDpjjid,jdbcType=VARCHAR}, #{eqGhlx,jdbcType=VARCHAR}," +
            "      #{eqDrurl,jdbcType=VARCHAR}, #{eqDcurl,jdbcType=VARCHAR})")
    int insertEqSbgh(EqSbghVO sbgh);

    /*设备归还修改*/
    @Update(" update eq_sbgh\n" +
            "    set eq_zbbm = #{eqZbbm,jdbcType=VARCHAR},\n" +
            "      eq_count = #{eqCount,jdbcType=INTEGER},\n" +
            "      eq_ghrq = #{eqGhrq,jdbcType=DATE},\n" +
            "      eq_zbjc = #{eqZbjc,jdbcType=VARCHAR},\n" +
            "      eq_ghks = #{eqGhks,jdbcType=VARCHAR},\n" +
            "      eq_jsks = #{eqJsks,jdbcType=VARCHAR},\n" +
            "      eq_ghjbr = #{eqGhjbr,jdbcType=VARCHAR},\n" +
            "      eq_jsjbr = #{eqJsjbr,jdbcType=VARCHAR},\n" +
            "      eq_dpjjid = #{eqDpjjid,jdbcType=VARCHAR},\n" +
            "      eq_ghlx = #{eqGhlx,jdbcType=VARCHAR}\n" +
            "    where id = #{id,jdbcType=VARCHAR}")
    int updateSbghByPrimaryKey(EqSbghVO vo);

    /*归还设备记录查询*/
    @Select("<script>select id,eq_count,eq_ghrq,eq_ghks,eq_jsks,eq_ghlx from eq_sbgh \n" +
            "<if test=\"_parameter != null\">" +
            "<where>\n" +
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
            "</if>" +
            " order by eq_ghrq" +
            "</script>" )
    List<EqSbghShowVO> selectAllSbgh(EqSbghExample example);

    /*主键查询单个归还设备记录*/
    @Select("select * from eq_sbgh where id = #{id}")
    EqSbghVO selectOneSbghByPrimaryKey(String id);
    /*根据设备编号查询设备调剂交接Id,所属科室和借出科室*/
    @Select(" select t.id, e.eq_sbbh,e.eq_name,e.eq_gg,e.eq_xh,t.tjjj_drks,t.tjjj_dcks\n " +
            " from eq_info e\n" +
            " inner join eq_tjjj t on t.tjjj_bianma like CONCAT('%',#{sbbh},'%') \n" +
            " where e.eq_sbbh=#{sbbh}\n" +
            " and t.eq_sfqbgh = '0' and e.eq_sfjc = '1' ")
    EqSbghZbVO selectEq2ByBianhao(String sbbh);
/*查询本调剂交接已经归还的设备*/
    @Select(" select t.id, e.eq_sbbh,e.eq_name,e.eq_gg,e.eq_xh,t.tjjj_drks,t.tjjj_dcks\n " +
            " from eq_info e\n" +
            " inner join eq_tjjj t on t.tjjj_bianma like CONCAT('%',#{sbbh},'%') \n" +
            " where e.eq_sbbh=#{sbbh}\n" +
            " ")
    EqSbghZbVO selectEq3ByBianhao(String sbbh);
    /*根据设备编号查询设备调剂交接Id,所属科室和借出科室*/
    @Select(" select e.eq_sbbh,e.eq_name,e.eq_gg,e.eq_xh\n " +
            " from eq_info e\n" +
            " where e.eq_sbbh=#{sbbh} ")
    EqSbghZbVO selectEq2ByBianhao2(String sbbh);

    /*根据调剂交接id查询已经归还的设备编号,
    * 之后查询此记录是否有调入和调出的签字,
    * 如果有,视为已归还,要改变借出装备状态的改变*/
    @Select(("select eq_zbbm from eq_sbgh where eq_dpjjid=#{dpjjid}\n" +
            "and eq_drurl !='' and eq_drurl is not null\n" +
            "and eq_dcurl !='' and eq_dcurl is not null\n"))
    List<String> selectAllSbgh2(String dpjjid);


    /*根据装备编号查询调剂交接表中要还装备*/
    @Select("select  tjjj_bianma from eq_tjjj \n" +
            "where tjjj_drks=#{drks} and tjjj_dcks=#{dcks}\n" +
            "and eq_sfqbgh = '0' ")
    List<String> selectElseZb(@Param("drks") String drks,
                              @Param("dcks") String dcks);




}
