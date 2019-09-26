package com.litbo.hospital.lifemanage.dao.MyMapper;

import com.litbo.hospital.lifemanage.bean.MyBean.MbLr;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MbLrMapper {
    /*增加一条模板*/
    @Insert(" insert into mb_lr (id, mb_mc, mb_nr\n" +
            "      )\n" +
            "    values (#{id,jdbcType=VARCHAR}, #{mbMc,jdbcType=VARCHAR}, #{mbNr,jdbcType=VARCHAR}\n" +
            "      )")
    int insertMbLr(MbLr mb);

    /*查询或者根据模板名称查询模板*/
    @Select("<script>" +
            "select id,mb_mc from mb_lr " +
            " <if test=\"mbmc != null\">\n" +
            " where mb_mc like CONCAT('%',#{mbmc},'%')" +
            "</if>" +
            " order by id desc " +
            "</script>")
    List<MbLr> selectAllMb(@Param("mbmc") String mbmc);

    /*查看一条模板详情*/
    @Select("select id,mb_mc,mb_nr from mb_lr where id=#{id}")
    MbLr selectOneMb(String id);

    /*修改一条模板*/
    @Update(" update mb_lr\n" +
            "    set mb_mc = #{mbMc,jdbcType=VARCHAR},\n" +
            "      mb_nr = #{mbNr,jdbcType=VARCHAR}\n" +
            "    where id = #{id,jdbcType=VARCHAR} ")
    int updateMb(MbLr mb);

    /*删除*/
    @Delete("delete from mb_lr where id=#{id}")
    int deleteMbByid(String id);
}
