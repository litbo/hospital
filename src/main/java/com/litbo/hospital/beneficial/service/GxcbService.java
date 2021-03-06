package com.litbo.hospital.beneficial.service;

import com.litbo.hospital.beneficial.vo.InsertSbcwVo;
import com.litbo.hospital.result.Result;

import java.math.BigDecimal;

public interface GxcbService {
    Result insertCb(InsertSbcwVo insertSbcwVo);

    Result showSbCb(Integer aId);

    Integer updateSbCb(Integer aId, BigDecimal kmValue);

    Integer deleteSbCb(Integer aId);
}
