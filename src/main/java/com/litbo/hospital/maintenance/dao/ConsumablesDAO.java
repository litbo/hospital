package com.litbo.hospital.maintenance.dao;

import com.litbo.hospital.maintenance.pojo.Consumables;

public interface ConsumablesDAO {
    int insert(Consumables record);

    int insertSelective(Consumables record);
}