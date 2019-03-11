package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.FwPjql;
import com.litbo.hospital.security.enums.EnumApplyStatus;
import com.litbo.hospital.security.vo.ExaminePjqlVO;
import com.litbo.hospital.security.vo.PjVo;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

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

    @Update("update fw_pjql set sq_status = #{status}, qr_time = #{date} where qrr_id = #{qrrId} and id = #{id} and sq_status = 0")
    int updateFwPjqlSqStatus(@Param("status") Integer status, @Param("id") Integer id, @Param("qrrId") String qrrId, @Param("date") Date date);

    @Select("select fw_id from fw_pjql where id = #{id}")
    String selectFwIdById(Integer id);

    @Select("SELECT pjzd.pj_name,pjzd.pjbh,pjzd.pj_ggxh,cs.sbcs_name,pjql_zjb.pj_count from fw_pjql pjql \n" +
            "INNER JOIN fw_pjql_zjb pjql_zjb ON pjql.id=pjql_zjb.pjql_id\n" +
            "INNER JOIN fw_pjzd pjzd ON pjzd.id = pjql_zjb.pj_id \n" +
            "INNER JOIN eq_cs cs ON cs.sbcs_id = pjzd.pj_ghs_id" +
            "WHERE pjql.fw_id = #{fwId}")
    List<PjVo> selectPjVo(String fwId);
    @Select("SELECT\n" +
            "\tql_time,\n" +
            "\tqlyy,\n" +
            "\ts.user_xm\n" +
            "FROM\n" +
            "\tfw_pjql as f\n" +
            "LEFT JOIN s_emp as s ON s.user_id = f.qlr_id\n" +
            "WHERE\n" +
            "\tid = #{id}")
    ExaminePjqlVO selectFwPjqlById(Integer id);
}
