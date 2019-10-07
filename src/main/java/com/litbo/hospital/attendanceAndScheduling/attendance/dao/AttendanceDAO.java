package com.litbo.hospital.attendanceAndScheduling.attendance.dao;

import com.litbo.hospital.attendanceAndScheduling.attendance.pojo.Attendance;
import com.litbo.hospital.attendanceAndScheduling.attendance.vo.UserInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttendanceDAO {
    int insert(Attendance record);

    int insertSelective(Attendance record);

    List <UserInfoVo> getSelfStaff(@Param("id") String id ,@Param("name") String name);

    List <UserInfoVo> countSign(@Param("id") String id ,@Param("name") String name);

}