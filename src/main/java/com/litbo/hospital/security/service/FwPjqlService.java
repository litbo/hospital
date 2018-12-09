package com.litbo.hospital.security.service;

import com.litbo.hospital.security.bean.FwPjck;
import com.litbo.hospital.security.vo.InsertFwPjqlVo;

public interface FwPjqlService {
    int insertFwPjql(InsertFwPjqlVo insertFwPjqlVo);

    int updateFwPjqlSqStatus(Integer status, Integer id, String qrrId, String shyy);
}
