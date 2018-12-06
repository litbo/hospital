package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.FwPjql;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.mapping.StatementType;

@Mapper
public interface FwPjqlDao {
    @Insert({"    insert into fw_pjql ( fw_id, ql_time, " +
            "      qlr_id, qrr_id, qz_url," +
            "      qr_time, sq_status, qlyy" +
            "      )  values ( #{fwId,jdbcType=VARCHAR}, #{qlTime,jdbcType=TIMESTAMP}, " +
            "      #{qlrId,jdbcType=VARCHAR}, #{qrrId,jdbcType=VARCHAR}, #{qzUrl,jdbcType=VARCHAR}, " +
            "      #{qrTime,jdbcType=TIMESTAMP}, #{sqStatus,jdbcType=INTEGER}, #{qlyy,jdbcType=LONGVARCHAR}" +
            "      )"
    })
    @Options(useGeneratedKeys = true, keyColumn = "id")
    Integer insertFwPjql(FwPjql pjql);
}
