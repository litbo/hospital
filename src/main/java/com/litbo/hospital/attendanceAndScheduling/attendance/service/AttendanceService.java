package com.litbo.hospital.attendanceAndScheduling.attendance.service;

import com.litbo.hospital.attendanceAndScheduling.attendance.vo.SignVo;

import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/10/4 13:51
 * @Version:
 * @Description:
 */
public interface AttendanceService {

    List getSelfStaff(String id , String name);

    int sing(SignVo signVo);

    List countSign(String id , String name);

}
