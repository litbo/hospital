package com.litbo.hospital.lifemanage.dao.MyMapper;


import com.litbo.hospital.lifemanage.bean.Example.EqTjsqExample;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.*;
import com.litbo.hospital.lifemanage.dao.provider.MyProvider.EqTjsqProvider;
import org.apache.ibatis.annotations.*;
import java.util.*;

@Mapper
public interface EqTjsqMapper {


    /*查询所在科室设备**/
    @Select("select e.eq_sbbh as  sbbh , e.eq_name as name\n" +
            " from s_bm s\n" +
            " INNER JOIN eq_info  e ON e.eq_bmid = #{bmId}\n" +
            " where s.bm_id = #{bmId}")
    List<Map<String, String>> ListEqInfo(String bmId);


    /*增加一条调入申请记录*/
    @InsertProvider(type = EqTjsqProvider.class, method = "insertTjDrSq")
    int insertTjDrSq(EqTjsqVO eqTjsqDrVO);

    /*根据主键修改调剂申请*/
    @UpdateProvider(type = EqTjsqProvider.class, method = "updateByPrimaryKey")
    int updateByPrimaryKey(EqTjsqVO tj);

    /*根据部门编号查询部门名字*/
    @Select("select top 1 bm_name from s_bm where bm_id = #{bmid}")
    String selectBmNameByBmid(String bmid);
    /*装备申请记录主键查询*/
    @SelectProvider(type = EqTjsqProvider.class, method = "selectSqJlByKey")
    EqTjsqVO selectSqJlByKey(String id);

    /*查询本部门调剂申请记录*/
    @Select("<script>" + "select id, bm_name,tj_zbmc,tj_drjbr,tj_sqsj\n" +
            " from s_bm \n" +
            " INNER JOIN eq_tjsq on s_bm.bm_id=eq_tjsq.tj_sqks" +
            " <if test=\"_parameter != null\">\n" +
            " <where>\n" +
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
            "   order by tj_sqsj" +
            "</script>")
    List<EqTjShowVO> selectBenBmByBmId(EqTjsqExample example);

    /*条件查或全查申请调剂记录*/
    @Select("<script>" + "select id, bm_name,tj_zbmc,tj_drjbr,tj_sfyl,tj_sqlx,tj_sqsj,tj_sfqbsl\n" +
            " from s_bm \n" +
            " INNER JOIN eq_tjsq on s_bm.bm_id=eq_tjsq.tj_sqks" +
            " <if test=\"_parameter != null\">\n" +
            " <where>\n" +
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
            " order by tj_sqsj" +
            "</script>")
    List<EqTjShowVO> selectByExample(EqTjsqExample example);

    /*根据主键删除调剂申请*/
    @DeleteProvider(type = EqTjsqProvider.class, method = "deleteByPrimaryKey")
    int deleteByPrimaryKey(String id);

    /*根据主键删除装备调出*/
    @Delete("delete from tj_zbdc where id=#{id}")
    int deleteZbDcById(String id);
    /*根据设备名称和部门名称模糊查询可调剂设备 参数为设备名，部门id，调剂科室名，院区*/
    @Select("<script> select eq_id,eq_sbbh,bm_id,bm_name,eq_name,eq_gg,eq_xh,eq_yq \n" +
            "    from eq_info e  \n" +
            "    inner join s_bm  s on e.eq_bmid = s.bm_id\n" +
            "    where eq_name like CONCAT('%',#{sbName},'%') " +
            "    and   e.eq_syzt = '在用' and e.eq_sfjc='0'" +
            "  <if test =\"bmname != null and bmname!=''\">" +
            "  and bm_name =  #{bmname} " +
            "  </if> " +
            "  <if test =\"yq !=null and yq!='' \"> " +
            "  and eq_yq=#{yq}" +
            "  </if>  " +
            "</script>")
    List<EqInfoShowVO> selectAllEqInfo(@Param("sbName") String sbName,
                                       @Param("bmname") String bmname,
                                       @Param("yq") String yq);

    /*装备调出主键查*/
    @SelectProvider(type = EqTjsqProvider.class, method = "selectByPrimaryKey")
    EqTjZbdcVO selectByPrimaryKey(String id);


    /*装备调出增加记录*/
    @InsertProvider(type = EqTjsqProvider.class, method = "insertTjZbdc")
    int insertTjZbdc(EqTjZbdcVO zbdcVO);


    /* 申请id查询 进度,申请id，科室id,决定是增加一条调出申请还是修改申请装备 */
    @Select("select id,tj_dcjd,tj_sqtj,tj_dcks,tj_zhz from tj_zbdc ")
    List<EqTjZbdcVO> selectTjZbdcThree();

    /*改变装备借出状态*/
    @Update("update eq_info set eq_sfjc=#{status} where eq_sbbh=#{sbbh} ")
    int updateEqInfoSfJc(@Param("sbbh") String sbbh, @Param("status") String status);

    /*查询科室id和申请id进度为0的调配装备*/
    @Select(" select id,tj_zbbm,tj_ggxh,tj_sqzbbms ,tj_sqzbcounts from tj_zbdc where tj_dcks=#{dcksid} " +
            " and tj_dcjd = '0' and tj_sqtj=#{sqtjid} and tj_zhz=#{zhz} ")
    EqTjZbdcVO selectTjjd(@Param("dcksid") String dcksid, @Param("sqtjid") String sqtjid, @Param("zhz") String zhz);

    /*查找所有未送达验收单,点替换之后装备状态变成待借出,未送达调配单+1，别人将无法查找到*/
    @Select("select  t.id, t.tj_dpsj,t.tj_zhz,s.bm_name ,e.tj_sqks as zbSdks \n" +
            "    from  tj_zbdc t \n " +
            "    inner join eq_tjsq e on e.id=t.tj_sqtj " +
            "    inner join s_bm s on t.tj_dcks= s.bm_id" +
            "    where tj_dcjd = '0' order by t.tj_dpsj")
    List<EqTjDpdVO> selectWsdDpd();

    /*查找所有验收单已送达*/
    @Select("select t.id, t.tj_dpsj,e.tj_zhz,s.bm_name  ,e.tj_sqks as zbSdks\n" +
            "    from  tj_zbdc t \n " +
            "    inner join eq_tjsq e on e.id=t.tj_sqtj " +
            "    inner join s_bm s on t.tj_dcks= s.bm_id" +
            "    where tj_dcjd = '1' order by t.tj_dpsj")
    List<EqTjDpdVO> selectYsdDpd();

    /*科室id查询科室名字*/
    @Select("select  bm_name as zbSdks from s_bm where bm_id=#{ksid} ")
    String selectKsNameByID(String ksid);

    /*修改待调剂装备的信息*/
    @Update(" update tj_zbdc set tj_zbbm = #{zbbm,jdbcType=VARCHAR},tj_ggxh = #{ggxh,jdbcType=VARCHAR},tj_dpsj=#{date,jdbcType=DATE},tj_sqzbbms=#{sqzbbm,jdbcType=VARCHAR},tj_sqzbcounts=#{tjzbcounts,jdbcType=VARCHAR}" +
            " where id = #{id}" )
    int updateDcZb(@Param("id") String id,
                   @Param("zbbm") String zbbm,
                   @Param("ggxh") String ggxh,
                   @Param("sqzbbm") String sqzbbm,
                   @Param("tjzbcounts") String tjzbcounts,
                   @Param("date") Date date);

    /*修改待调剂装备数量*/
    @Update(" update tj_zbdc set tj_tpsl=#{count} " +
            " where id = #{id} ")
    int updateZbCount(@Param("id") String id,
                      @Param("count") Integer count);


    /* *//*通过主键改变调剂申请装备的名称*//*
    @Update("update eq_tjsq set tj_zbmc=#{zbmc} where id=#{id} ")
    int updateSqZbBykey(@Param("id") String id, @Param("zbmc") String zbmc);*/
    /*根据调剂申请的装备名称和替换数量修改调剂申请装备的名称和数量*/
    @Update("update eq_tjsq set tj_zbmc=#{zbmc} where id=#{id}")
    int updateSqZbBykey(@Param("id") String id, @Param("zbmc") String zbmc);

    /*根据主键修改装备调出*/
    @Update("update tj_zbdc\n" +
            "    set tj_sqtj = #{tjSqtj,jdbcType=VARCHAR},\n" +
            "      tj_dcks = #{tjDcks,jdbcType=VARCHAR},\n" +
            "      tj_lxr = #{tjLxr,jdbcType=VARCHAR},\n" +
            "      tj_dwsj = #{tjDwsj,jdbcType=DATE},\n" +
            "      tj_zbbm = #{tjZbbm,jdbcType=VARCHAR},\n" +
            "      tj_gg = #{tjGg,jdbcType=VARCHAR},\n" +
            "      tj_tpsl = #{tjTpsl,jdbcType=INTEGER},\n" +
            "      tj_sysc = #{tjSysc,jdbcType=INTEGER},\n" +
            "      tj_zbztjc = #{tjZbztjc,jdbcType=VARCHAR},\n" +
            "      tj_fjjc = #{tjFjjc,jdbcType=VARCHAR},\n" +
            "      tj_dcjbr = #{tjDcjbr,jdbcType=VARCHAR},\n" +
            "      tj_dpsj = #{tjDpsj,jdbcType=DATE},\n" +
            "      tj_dcjd = #{tjDcjd,jdbcType=VARCHAR},\n" +
            "      tj_xh = #{tjXh,jdbcType=VARCHAR},\n" +
            "      tj_dcksurl = #{tjDcksurl,jdbcType=VARCHAR},\n" +
            "      tj_zhz = #{tjZhz,jdbcType=VARCHAR},\n" +
            "      tj_ggxh = #{tjGgxh,jdbcType=VARCHAR},\n" +
            "      tj_sqzbbms = #{tjSqzbbms,jdbcType=VARCHAR},\n" +
            "      tj_sqzbcounts = #{tjSqzbcounts,jdbcType=VARCHAR}\n" +
            "    where id = #{id,jdbcType=VARCHAR}")
    int updateZbdcByprimaryKey(EqTjZbdcVO vo);
    /*根据装备编号查询装备名称*/
    @Select("select top 1 eq_name from eq_info where" +
            " eq_sbbh=#{bianhao} ")
    String selectZbNameByZbBh(String bianhao);


}