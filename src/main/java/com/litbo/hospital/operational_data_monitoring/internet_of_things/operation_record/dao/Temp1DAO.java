package com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.dao;

import com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.bean.Temp1;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.vo.OperationRecord;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.dao
 * @Author: looli
 * @CreateTime: 2019-08-08 11:13
 * @Description: todo
 */
public interface Temp1DAO {
    @Delete("delete from temp1")
    void delete();

    @Insert({"<script>",
            "insert into temp1 (bm_name, eq_sbbh, eq_name, \n" +
                    "      eq_xh, standbyTime, workHours\n" +
                    "      )\n" +
                    "    values " +
                    "<foreach item='temp' collection='list' separator=',' > \n" +
                    "(#{temp.bmName,jdbcType=VARCHAR}, #{temp.eqSbbh,jdbcType=VARCHAR}," +
                    " #{temp.eqName,jdbcType=VARCHAR}," +
                    "#{temp.eqXh,jdbcType=VARCHAR}, #{temp.standbyTime,jdbcType=VARCHAR}, " +
                    "#{temp.workHours,jdbcType=VARCHAR}\n" +
                    ")",
            "</foreach>",
            "</script>"})
    void save(List<OperationRecord> operationRecords);

    @Select("select * from temp1")
    List<Temp1> select();
}
