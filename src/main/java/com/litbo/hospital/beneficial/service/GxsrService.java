package com.litbo.hospital.beneficial.service;

import com.litbo.hospital.beneficial.vo.InsertSbcwVo;
import com.litbo.hospital.result.Result;

import java.math.BigDecimal;

public interface GxsrService {
    Result insertSr(InsertSbcwVo insertSbcwVo);

    Result showSbSr(Integer aId);

    Integer updateSbSr(Integer aId, BigDecimal kmValue);

    Integer deleteSbSr(Integer aId);
}
