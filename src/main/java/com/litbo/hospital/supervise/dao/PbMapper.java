package com.litbo.hospital.supervise.dao;

import com.litbo.hospital.supervise.bean.PbJhVO;
import com.litbo.hospital.supervise.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PbMapper {

    void addPbPlan(PbJhVO pbJhVO);

    List<getPbPlanVos> getPbPlanVos();

    List<RyZtVos> getPbPeople(@Param("id") String id);

    List<RyVos> ghPeople(@Param("sid")String sid);

    List<RyVos> getBmpeople(String bmId);

    void BcKqRy(KqRyVos kq);

    void updatePbCheck(@Param("id")String id);

    void addPbPlanRy(pbJhRyVo ryVo);

    List<UserIdVo> getUidByKqYd(String id);

    List<UserIdVo> getUidByKqWd(String id);

    void updateRyZtYd(@Param("uid") String uid,@Param("jid") String jid);

    void updateRyZtWd(@Param("uid")String uid, @Param("jid")String jid);

    void insertGhRy(pbJhRyVo JhRyVo);

    List<RyZtVos> getZbPeople(@Param("id") String id);
}
