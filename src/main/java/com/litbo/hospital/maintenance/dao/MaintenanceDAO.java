package com.litbo.hospital.maintenance.dao;

import com.litbo.hospital.maintenance.pojo.Maintenance;
import com.litbo.hospital.maintenance.vo.AddEqVo;
import com.litbo.hospital.maintenance.vo.EqInfoVo;
import com.litbo.hospital.maintenance.vo.MaintenancePlanVo;
import com.litbo.hospital.user.bean.EqInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaintenanceDAO {
    int insert(Maintenance record);

    int insertSelective(Maintenance record);

    List<EqInfoVo> getEQMessage(@Param("riskLevel") String riskLevel,
                                @Param("bmName") String bmName,
                                @Param("eqName") String eqName);


    Maintenance selectByEqId(String eqId);

    int updateByPremaryKey(Maintenance record);

    // TODO: 2019/8/28 还需要添加同分类查询
    List<AddEqVo> selectEq(@Param("factory") String factory,
                           @Param("model") String model,
                           @Param("bmName") String bmName,
                           @Param("similarClass") String similarClass,
                           @Param("pym") String pym);


    EqInfo selectEqById(String id);


    List<MaintenancePlanVo> seeAllMaintenancePlan(@Param("planName") String planName,
                                                  @Param("beginTime") String beginTime,
                                                  @Param("endTime") String endTime,
                                                  @Param("status") String status);

    Maintenance selectById(int id);


    int deletePlan(int id);


}