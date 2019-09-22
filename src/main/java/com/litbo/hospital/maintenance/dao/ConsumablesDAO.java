package com.litbo.hospital.maintenance.dao;

import com.litbo.hospital.maintenance.pojo.Consumables;

import java.util.List;

public interface ConsumablesDAO {
    int insert(Consumables record);

    int insertSelective(Consumables record);

    List<Consumables> getConsumables(int id);
}