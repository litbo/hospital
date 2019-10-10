package com.litbo.hospital.lifemanage.dao.MyMapper;


import com.litbo.hospital.lifemanage.bean.MyBean.Blwxbg;
import com.litbo.hospital.security.bean.FwPjzd;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BlwxbgMapper {
    /*增加*/
    @Insert(" insert into blwxbg (id, eq_id, bx_dqr, \n" +
            "      bxks_id, bxr, bxfs, \n" +
            "      fxsj, bxzt, jjx, \n" +
            "      bxksdh, bxrdh, lrr, \n" +
            "      bxsj, ygztj, slsj, \n" +
            "      ydwxsj, slr, wxfs, gzpc, \n" +
            "      wxlx, gzyymx, wxgznr, \n" +
            "      fzwxry, ywwxgcs, rgfcjj, \n" +
            "      wxgs, wxjg, fwkssj, \n" +
            "      pcwcsj, gzyylx, gzbw, \n" +
            "      wxgcs, wxzd, rgfbj, \n" +
            "      zdzxrc, gztjsc, gcsjy, \n" +
            "      fwjssj, wxpj, wxs, \n" +
            "      wxslxdh, wxtzsj, wxslxr, \n" +
            "      yyddsj, qrsj, qrjg, \n" +
            "      qrr, myd, gznr)\n" +
            "    values (#{id,jdbcType=VARCHAR}, #{eqId,jdbcType=VARCHAR}, #{bxDqr,jdbcType=DATE}, \n" +
            "      #{bxksId,jdbcType=VARCHAR}, #{bxr,jdbcType=VARCHAR}, #{bxfs,jdbcType=VARCHAR}, \n" +
            "      #{fxsj,jdbcType=TIMESTAMP}, #{bxzt,jdbcType=VARCHAR}, #{jjx,jdbcType=VARCHAR}, \n" +
            "      #{bxksdh,jdbcType=VARCHAR}, #{bxrdh,jdbcType=VARCHAR}, #{lrr,jdbcType=VARCHAR}, \n" +
            "      #{bxsj,jdbcType=TIMESTAMP}, #{ygztj,jdbcType=VARCHAR}, #{slsj,jdbcType=TIMESTAMP}, \n" +
            "      #{ydwxsj,jdbcType=DATE}, #{slr,jdbcType=VARCHAR}, #{wxfs,jdbcType=VARCHAR}, #{gzpc,jdbcType=VARCHAR}, \n" +
            "      #{wxlx,jdbcType=VARCHAR}, #{gzyymx,jdbcType=VARCHAR}, #{wxgznr,jdbcType=VARCHAR}, \n" +
            "      #{fzwxry,jdbcType=VARCHAR}, #{ywwxgcs,jdbcType=VARCHAR}, #{rgfcjj,jdbcType=VARCHAR}, \n" +
            "      #{wxgs,jdbcType=VARCHAR}, #{wxjg,jdbcType=VARCHAR}, #{fwkssj,jdbcType=TIMESTAMP}, \n" +
            "      #{pcwcsj,jdbcType=TIMESTAMP}, #{gzyylx,jdbcType=VARCHAR}, #{gzbw,jdbcType=VARCHAR}, \n" +
            "      #{wxgcs,jdbcType=VARCHAR}, #{wxzd,jdbcType=VARCHAR}, #{rgfbj,jdbcType=VARCHAR}, \n" +
            "      #{zdzxrc,jdbcType=VARCHAR}, #{gztjsc,jdbcType=VARCHAR}, #{gcsjy,jdbcType=VARCHAR}, \n" +
            "      #{fwjssj,jdbcType=TIMESTAMP}, #{wxpj,jdbcType=VARCHAR}, #{wxs,jdbcType=VARCHAR}, \n" +
            "      #{wxslxdh,jdbcType=VARCHAR}, #{wxtzsj,jdbcType=TIMESTAMP}, #{wxslxr,jdbcType=VARCHAR}, \n" +
            "      #{yyddsj,jdbcType=TIMESTAMP}, #{qrsj,jdbcType=TIMESTAMP}, #{qrjg,jdbcType=VARCHAR}, \n" +
            "      #{qrr,jdbcType=VARCHAR}, #{myd,jdbcType=VARCHAR}, #{gznr,jdbcType=VARCHAR})\n")
    int insertBlwxbg(Blwxbg blwxbg);
    @Select("select * from blwxbg")
    List<Blwxbg> selectAllBlwxbg();

    @Select("select * from blwxbg where id=#{id}")
    Blwxbg selectOneBlwxbg(String id);
    @Select("select * from fw_pjzd where id=#{id}")
    FwPjzd selectpjzdById(Integer id);

}