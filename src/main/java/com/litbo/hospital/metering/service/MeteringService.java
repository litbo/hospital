package com.litbo.hospital.metering.service;

import com.litbo.hospital.metering.pojo.MeteringUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/8/8 1:44
 * @Version:
 * @Description:
 */
@Repository
public interface MeteringService {

    int addMeteringUtil(MeteringUtil meteringutil);

    int deleteMeteringUtil(int meteringutilId);

    int updateMeteringUtil(MeteringUtil meteringutil);

    MeteringUtil findMeteringUtilById(int id);

    MeteringUtil findMeteringUtilByUtilNum(String num);

    int disableDevice(int meteringutilId);

    //    查询所有的设备信息
    List<MeteringUtil> findAllMeteringUtil();

    //    根据部门查看设备信息

    List<MeteringUtil> findAllMeteringUtilByDepartment(String department);
    List<MeteringUtil> findAllMeteringUtilByDepartmentAndMeteringUtilName(String department,String meteringUtilName);

    //    查找在某一时间段需要计量的设备信息
    List<MeteringUtil> findAllMeteringUtilByTime(String beginTime,String endTiem);

    //   根据时间，部门，审计状态联合查询
    List<MeteringUtil> searchMeteringUtil(String beginTime, String endTiem,
                                          String department,String status);

    // 更改设备计量状态，传入id，如果已经开始计量则变成为进入计量流程，未进入计量变为已进入计量流程
    int updateMeteringStatus(int id);




}
