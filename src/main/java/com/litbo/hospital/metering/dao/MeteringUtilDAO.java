package com.litbo.hospital.metering.dao;

import com.litbo.hospital.metering.pojo.MeteringUtil;
import org.apache.ibatis.annotations.Mapper;
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

    // 综合查询
    List<MeteringUtil> findAllMeteringUtilAllChech(@Param("sign") Integer sign,@Param("gaugeCategory") String gaugeCategory,
                                                   @Param("meteringName")String meteringName,@Param("bmName") String bmName,
                                                   @Param("meteringstatus")String meteringstatus,
                                                   @Param("beginTime") String beginTime,
                                                   @Param("endTime") String endTime,@Param("needMeter") String needMeter);

    //    根据科室查看设备信息
    List<MeteringUtil> findAllMeteringUtilByDepartment(String department);
    List<MeteringUtil> findAllMeteringUtilByDepartmentAndName(@Param("department") String department,@Param("name") String name);

    //    查询在某一时间段需要计量的设备信息
    List<MeteringUtil> findAllMeteringUtilByTime(@Param("beginTime")String beginTime, @Param("endTiem") String endTiem);


    //   根据时间，科室，审计状态联合查询
    List<MeteringUtil> searchMeteringUtil(@Param("beginTime")String beginTime, @Param("endTiem") String endTiem,
                                          @Param("department")String department,@Param("status")String status);




}