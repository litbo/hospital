package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.FwPjql;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.Date;

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

    @Update("update fw_pjql set sq_status = #{status}, qr_time = #{date} where qrr_id = #{qrrId} and id = #{id} and sq_status == 0")
    int updateFwPjqlSqStatus(@Param("status") Integer status, @Param("id") Integer id, @Param("qrrId") String qrrId, @Param("date") Date date);

    @Select("select fw_id from fw_pjql where id = #{id}")
    String selectFwIdById(Integer id);
}
