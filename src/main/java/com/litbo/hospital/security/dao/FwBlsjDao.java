package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.FwBlsj;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FwBlsjDao {
    @Options(useGeneratedKeys = true,keyProperty ="id",keyColumn = "id")
    @Insert("insert into fw_blsj (bgrq, sbks, \n" +
            "      lxdh, tmh, bgr_xm, cpmc, \n" +
            "      zczbh, xh, gg, cpph, \n" +
            "      cpbh, ynbm, UDI, scrq, \n" +
            "      yxqz, ssxkcyr_xm, sjfsrq, \n" +
            "      fxhhzrq, sh, shbx, \n" +
            "      qxgzbx, xm, csrq, \n" +
            "      nllx, nl, xb, blh, \n" +
            "      jwbs, yqzljbyzy, qxsyrq, \n" +
            "      sycs, csmc, sygc, hbyy_xqksm, \n" +
            "      sjyyfx, sjyyfxms, cbczqk, \n" +
            "      eq_id, bgr_id, cjrq, \n" +
            "      lb, shr, status, fw_id\n" +
            "      )\n" +
            "    values ( #{bgrq,jdbcType=TIMESTAMP}, #{sbks,jdbcType=VARCHAR}, \n" +
            "      #{lxdh,jdbcType=VARCHAR}, #{tmh,jdbcType=VARCHAR}, #{bgrXm,jdbcType=VARCHAR}, #{cpmc,jdbcType=VARCHAR}, \n" +
            "      #{zczbh,jdbcType=VARCHAR}, #{xh,jdbcType=VARCHAR}, #{gg,jdbcType=VARCHAR}, #{cpph,jdbcType=VARCHAR}, \n" +
            "      #{cpbh,jdbcType=VARCHAR}, #{ynbm,jdbcType=VARCHAR}, #{udi,jdbcType=VARCHAR}, #{scrq,jdbcType=TIMESTAMP}, \n" +
            "      #{yxqz,jdbcType=TIMESTAMP}, #{ssxkcyrXm,jdbcType=VARCHAR}, #{sjfsrq,jdbcType=TIMESTAMP}, \n" +
            "      #{fxhhzrq,jdbcType=TIMESTAMP}, #{sh,jdbcType=VARCHAR}, #{shbx,jdbcType=VARCHAR}, \n" +
            "      #{qxgzbx,jdbcType=VARCHAR}, #{xm,jdbcType=VARCHAR}, #{csrq,jdbcType=TIMESTAMP}, \n" +
            "      #{nllx,jdbcType=VARCHAR}, #{nl,jdbcType=INTEGER}, #{xb,jdbcType=VARCHAR}, #{blh,jdbcType=VARCHAR}, \n" +
            "      #{jwbs,jdbcType=VARCHAR}, #{yqzljbyzy,jdbcType=VARCHAR}, #{qxsyrq,jdbcType=TIMESTAMP}, \n" +
            "      #{sycs,jdbcType=VARCHAR}, #{csmc,jdbcType=VARCHAR}, #{sygc,jdbcType=VARCHAR}, #{hbyyXqksm,jdbcType=VARCHAR}, \n" +
            "      #{sjyyfx,jdbcType=VARCHAR}, #{sjyyfxms,jdbcType=VARCHAR}, #{cbczqk,jdbcType=VARCHAR}, \n" +
            "      #{eqId,jdbcType=VARCHAR}, #{bgrId,jdbcType=VARCHAR}, #{cjrq,jdbcType=TIMESTAMP}, \n" +
            "      #{lb,jdbcType=INTEGER}, #{shr,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, #{fwId,jdbcType=VARCHAR}\n" +
            "      )")
    int insertFwBlsj(FwBlsj blsj);

    @SelectProvider(type=com.litbo.hospital.security.dao.sqlprovider.FwBlsjSqlProvider.class,method="listFwBlsj")
//    @Select("select * from fw_blsj where status = #{status} and lb = #{lb}")
    List<FwBlsj> listFwBlsj(@Param("status") Integer status, @Param("lb") Integer lb, @Param("cpmc") String cpmc,@Param("bgrXm") String bgrXm);

    @Select("select * from fw_blsj where id = #{id}")
    FwBlsj selectFwBlsjById(Integer id);

    @Update("update fw_blsj set status = #{status} where id = #{id}")
    int updateFwBlsjStatus(@Param("status") Integer status, @Param("id") Integer id);
}
