package com.litbo.hospital.lifemanage.dao.MyMapper;


import com.litbo.hospital.lifemanage.bean.Example.EqLpjhtExample;
import com.litbo.hospital.lifemanage.bean.MyBean.EqLpjht;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqLpjHtShowVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.SbCsVO;
import com.litbo.hospital.lifemanage.dao.provider.MyProvider.EqLpjhtProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EqLpjhtMapper {

    /* *//*根据主键删除*/
    @DeleteProvider(type = EqLpjhtProvider.class, method = "deleteByPrimaryKey")
    int deleteByPrimaryKey(String id);

    /*录入零配件合同*/
    @InsertProvider(type = EqLpjhtProvider.class, method = "insert")
    int insert(EqLpjht record);

    /*条件查询或查询全部*/
    @Select("<script> select id, ht_zt, ht_yf, ht_sbmc,ht_sbbh, ht_yfrq,ht_jhsj, ht_cjje, ht_lpjhz" +
            "  from eq_lpjht" +
            " <if test='_parameter != null\'>\n" +
            "    <where>\n" +
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
            "    </where> " +
            " </if>" +
            "<if test=\"orderByClause != null\">\n" +
            "      order by ${orderByClause} ${sort}\n" +
            "    </if>" +
            "</script>")
    List<EqLpjHtShowVO> selectByExample(EqLpjhtExample example);


    /*根据主键查询*/
    @SelectProvider(type = EqLpjhtProvider.class, method = "selectByPrimaryKey")
    EqLpjht selectByPrimaryKey(String id);


    /*根据主键修改*/
    @UpdateProvider(type = EqLpjhtProvider.class, method = "updateByPrimaryKey")
    int updateByPrimaryKey(EqLpjht lpjht);

    /*通过合同号更改合同状态*/
    @UpdateProvider(type = EqLpjhtProvider.class, method = "updateByJhtId")
    int updateByJhtId(@Param("htJhtid") String htJhtid, @Param("htZt") String htZt);

    /*增加维修厂商*/
    @Insert(" insert into eq_cs (sbcs_id,sb_cslb_id,sbcs_name,sbcs_address)" +
            "  values(#{sbcsId},#{sbCslbId},#{sbcsName},#{sbcsAddress})")
    int addWxCs(SbCsVO vo);

    /*根据设备编号查询设pm*/
    @Select("select eq_name from eq_info where eq_sbbh=#{bianhao} ")
    String selectEqnameByHtBianhao(String bianhao);

    /*根据主键查询零配件合同详情*/
    @Select("select * from eq_lpjht where id=#{id}")
    EqLpjht selectLpjHtByPrimaryKey(String id);
}