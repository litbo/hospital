package com.litbo.hospital.security.dao;
import com.litbo.hospital.security.bean.FwBlsj;
import com.litbo.hospital.security.vo.FwBlsjVO;
import com.litbo.hospital.security.vo.SelectFwBlsjById;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FwBlsjDao {
    @Options(useGeneratedKeys = true,keyProperty ="id",keyColumn = "id")
    @Insert("    insert into fw_blsj ( eq_id, user_id, " +
            "      bgbh, bgmc, bgrgw, " +
            "      bg_time, sjxz, bgrqz, " +
            "      hzxm, hz_age, hz_sex, " +
            "      sjfs_time, sjhg, fxzx_time, " +
            "      ylqxsxcs, czry, zr_time, " +
            "      bxdh, yqzlxg, qxgz, " +
            "      zysh, sjcs,lxdh)" +
            "    values (#{eqId,jdbcType=INTEGER}, #{userId,jdbcType=VARCHAR}, " +
            "      #{bgbh,jdbcType=VARCHAR}, #{bgmc,jdbcType=VARCHAR}, #{bgrgw,jdbcType=VARCHAR}, " +
            "      #{bgTime,jdbcType=TIMESTAMP}, #{sjxz,jdbcType=VARCHAR}, #{bgrqz,jdbcType=VARCHAR}, " +
            "      #{hzxm,jdbcType=VARCHAR}, #{hzAge,jdbcType=INTEGER}, #{hzSex,jdbcType=VARCHAR}," +
            "      #{sjfsTime,jdbcType=TIMESTAMP}, #{sjhg,jdbcType=VARCHAR}, #{fxzxTime,jdbcType=TIMESTAMP}, " +
            "      #{ylqxsxcs,jdbcType=VARCHAR}, #{czry,jdbcType=VARCHAR}, #{zrTime,jdbcType=TIMESTAMP}, " +
            "      #{bxdh,jdbcType=VARCHAR}, #{yqzlxg,jdbcType=LONGVARCHAR}, #{qxgz,jdbcType=LONGVARCHAR}, " +
            "      #{zysh,jdbcType=LONGVARCHAR}, #{sjcs,jdbcType=LONGVARCHAR},#{lxdh,jdbcType=VARCHAR})")
    int insertFwBlsj(FwBlsj blsj);

    @SelectProvider(type=com.litbo.hospital.security.dao.sqlprovider.FwBlsjSqlProvider.class,method="listFwBlsj")
    List<FwBlsjVO> listFwBlsj(@Param("sjxz") String sjxz,@Param("bmName") String bmName,
                              @Param("sbcsName") String sbcsName,@Param("bgmc") String bgmc);

    @SelectProvider(type=com.litbo.hospital.security.dao.sqlprovider.FwBlsjSqlProvider.class,method="selectFwBlsjById")
    SelectFwBlsjById selectFwBlsjById(Integer id);


}
