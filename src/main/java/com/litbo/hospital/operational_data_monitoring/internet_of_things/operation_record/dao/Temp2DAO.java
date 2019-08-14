package com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.dao;

import com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.bean.Temp2;
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
public interface Temp2DAO {
    @Delete("delete from temp2")
    void delete();

    @Insert({"<script>",
            "insert into temp2" +
                    "(bm_name, standbyTime, workHours, \n" +
                    "      eqNumber)",
                    "    values " +
                    "<foreach item='temp' collection='list' separator=',' > \n" +
                    "(#{temp.bmName,jdbcType=VARCHAR}, #{temp.standbyTime,jdbcType=VARCHAR}, \n" +
                            "    #{temp.workHours,jdbcType=VARCHAR},  #{temp.eqNumber,jdbcType=VARCHAR})",
            "</foreach>",
            "</script>"})
    void save(List<OperationRecord> operationRecords);

    @Select("select * from temp2")
    List<Temp2> select();
}
