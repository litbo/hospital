package com.litbo.hospital.lifemanage.dao.MyMapper;


import com.litbo.hospital.lifemanage.bean.Example.EqHtExample;
import com.litbo.hospital.lifemanage.bean.MyBean.EqHt;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqHtShowVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.LoginCheckHtStatusVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.SbCsVO;
import com.litbo.hospital.lifemanage.dao.provider.MyProvider.EqHtProvider;
import org.apache.ibatis.annotations.*;

import java.util.*;

@Mapper
public interface EqHtMapper {


    // 根据合同编号查询详情
    @SelectProvider(type = EqHtProvider.class, method = "selectByHtId")
    EqHt selectByHtId(String id);

    /*根据主键查询详情*/
    @SelectProvider(type = EqHtProvider.class, method = "selectByPrimaryId")
    EqHt selectByPrimaryId(String id);

    // 根据条件查询@SelectProvider会错,可能是重载问题
//    @SelectProvider(type = EqHtProvider.class,method = "selectByExample")
    @Select("<script> select id, ht_zt,ht_bianhao,ht_yf,ht_zbmc,ht_ggxh,ht_count,ht_danjia,ht_cjje," +
            "  ht_yfrq,ht_zbhz " +
            " from eq_ht " +
            " <if test=\"_parameter != null\">\n" +
            "      <where>\n" +
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
            "    </where>  " +
            "    </if>" +
            " order by ht_yfrq \n" +

            "</script>")
    List<EqHtShowVO> selectByExample(EqHtExample example);

    /*查询所有合同编号*/
    @Select("select ht_bianhao from eq_ht order by id")
    List<String> selectHtIds();

    /*根据主键删除*/
    @DeleteProvider(type = EqHtProvider.class, method = "deleteByPrimaryKey")
    int deleteByPrimaryKey(String id);

    // 录入合同
    @InsertProvider(type = EqHtProvider.class, method = "insert")
    int insert(EqHt record);

    /*修改合同*/
    @UpdateProvider(type = EqHtProvider.class, method = "updateByPrimaryId")
    int updateByPrimaryId(EqHt ht);

    /*通过合同号更改合同状态*/
    @UpdateProvider(type = EqHtProvider.class, method = "updateByHtBianhao")
    int updateByHtBianhao(@Param("htBianhao") String htBianhao, @Param("htZt") String htZt);

    /*查询合同的装备信息*/
    @Select("select ht_zbhz from eq_ht where id=#{id}")
    String selectHtZbHzById(String id);

    /*新增设备厂商*/
    @Insert(" insert into eq_cs (sbcs_id,sb_cslb_id,sbcs_name)" +
            " values(#{sbcsId},#{sbCslbId},#{sbcsName},)")
    int addSbCs(SbCsVO vo);

    /*合同的装备数量跟已经验收的装备数量相等时执行,获取最后装备的
    验收时间,用现在的时间与合同签订时间+保修期作对比，若大于等于，则
    修改合同状态为已完成*/


    @Select("select ht_id,count(*) count,min(ys_ysqrsj) date from sg_ys\n" +
            " where ht_id is not null and ht_id !=''" +
            " GROUP BY ht_id  ")
    List<LoginCheckHtStatusVO> loginCheckHtStatus();

    @Select("select sbcs_name from eq_cs where sbcs_id=#{id}")
    String selectCsNameById(String id);
}