package com.litbo.hospital.operational_data_monitoring.software_interface.dao;

import com.litbo.hospital.operational_data_monitoring.software_interface.bean.HisUserDict;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.dao
 * @Author: looli
 * @CreateTime: 2019-07-26 17:17
 * @Description: todo
 */
public interface HisUserDictDAO {
    /**
     *批量插入员工信息
     * @param hisUserDictList
     */
    @Insert({"<script>",
            "insert into his_USER_DICT (UserNO, DeptID, UserName,UserSex, UserAge, UserProf,UserTech) values " +
                    "<foreach item='user' collection='list' separator=',' >",
                    "(#{user.userNO}, #{user.deptID}, #{user.userName}, \n" +
                    "#{user.userSex}, #{user.userAge}, #{user.userProf}, \n" +
                    "#{user.userTech})",
                    "</foreach>",
            "</script>"})
    void saves(List<HisUserDict> hisUserDictList);
}
