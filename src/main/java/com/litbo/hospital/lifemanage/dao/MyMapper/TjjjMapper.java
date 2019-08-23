package com.litbo.hospital.lifemanage.dao.MyMapper;


import com.litbo.hospital.lifemanage.bean.Example.EqTjjjExample;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqTjjjShowVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqTjjjVO;
import com.litbo.hospital.lifemanage.dao.provider.MyProvider.TjjjProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TjjjMapper {

    /*交接记录录入*/
    @InsertProvider(type = TjjjProvider.class,method = "insertTjjj")
    int insertTjjj(EqTjjjVO tjjj);

    /*全查或者根据部门名称查询并且按照日期排序*/
    @Select("<script>" +
        "select id,tjjj_drks,tjjj_dcks,tjjj_tprq" +
        ",tjjj_drjbr,tjjj_dcjbr,eq_sfqbgh from eq_tjjj\n" +
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
        " order by tjjj_tprq " +
        "</script>")
    List<EqTjjjShowVO> selectByExample(EqTjjjExample example);

    @Select("select  * from eq_tjjj where id=#{id,jdbcType=VARCHAR}")
    EqTjjjVO selectByPrimaryKey(String id);
}
