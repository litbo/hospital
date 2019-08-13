package com.litbo.hospital.metering.dao;

import com.litbo.hospital.metering.pojo.MeteringUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MeteringUtilDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(MeteringUtil record);

    int insertSelective(MeteringUtil record);

    MeteringUtil selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MeteringUtil record);

    int updateByPrimaryKey(MeteringUtil record);

    //    根据设备编号来查询设备信息
    MeteringUtil selectByUtilNum(String num);

    //    查询所有的设备信息
    List<MeteringUtil> findAllMeteringUtil();

    //    根据部门查看设备信息
    List<MeteringUtil> findAllMeteringUtilByDepartment(String department);

    //    查找在某一时间段需要计量的设备信息
    List<MeteringUtil> findAllMeteringUtilByTime(@Param("beginTime")String beginTime, @Param("endTiem") String endTiem);


    //   根据时间，部门，审计状态联合查询
    List<MeteringUtil> searchMeteringUtil(@Param("beginTime")String beginTime, @Param("endTiem") String endTiem,
                                          @Param("department")String department,@Param("status")String status);




}